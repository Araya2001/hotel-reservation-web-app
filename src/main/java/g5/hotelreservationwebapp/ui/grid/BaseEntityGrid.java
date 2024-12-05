package g5.hotelreservationwebapp.ui.grid;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import g5.hotelreservationwebapp.backend.model.BaseEntity;
import g5.hotelreservationwebapp.backend.service.BaseEntityService;
import g5.hotelreservationwebapp.ui.form.BaseEntityForm;
import g5.hotelreservationwebapp.ui.hlbutton.GridActionButtonLayout;
import g5.hotelreservationwebapp.ui.hlbutton.GridColumnActionButtonLayout;
import g5.hotelreservationwebapp.ui.style.StyleComponent;


public abstract class BaseEntityGrid<Model extends BaseEntity> extends Div implements StyleComponent {

    // Grid must be protected for subclasses to access the attribute
    protected final Grid<Model> baseEntityGrid;
    protected final BaseEntityForm<Model> baseEntityForm;
    protected final Div baseEntityFormDiv;
    protected final BaseEntityService<Model> baseEntityService;
    protected final GridActionButtonLayout gridActionButtonLayout = new GridActionButtonLayout();
    protected final Div gridActionButtonLayoutDiv;
    protected final H3 titleH3;
    protected final Div titleContainer;


    public BaseEntityGrid(Grid<Model> baseEntityGrid, BaseEntityForm<Model> baseEntityForm, BaseEntityService<Model> baseEntityService, String title) {

        // Map the Grid Constructor from the subclass
        this.baseEntityGrid = baseEntityGrid;

        // Map Entity Service from subclass to fill grid
        this.baseEntityService = baseEntityService;


        // Map Form to add next to the grid when pressed on editButton
        this.baseEntityForm = baseEntityForm;
        this.baseEntityFormDiv = addStyleToComponentInDiv(baseEntityForm, "center", "0px", "100%");

        // Map title from subclass
        this.titleH3 = new H3(title);
        titleContainer = addStyleToComponentInDiv(titleH3, "left", "0px", "100%");

        // Add action column to start
        prepareGridColumnActionButtonLayoutToBeFrozen();


        // Automatically hide baseEntityForm container
        this.baseEntityFormDiv.setVisible(Boolean.FALSE);
        this.baseEntityFormDiv.setEnabled(Boolean.FALSE);

        // Add Grid Action Button Layout to a container
        this.gridActionButtonLayoutDiv = addStyleToComponentInDiv(gridActionButtonLayout, "right", "0px", "100%");
        gridActionButtonLayout.setVisibilityToHideFormButton(Boolean.FALSE);

        // Add a header to the grid
        HorizontalLayout headerLayout = new HorizontalLayout(titleContainer, gridActionButtonLayoutDiv);
        headerLayout.setWidthFull();
        VerticalLayout gridLayout = new VerticalLayout(headerLayout, baseEntityGrid);

        // Add Listeners for Refresh And New Item Action Buttons
        addRefreshButtonListener();
        addNewItemButtonListener();
        addHideFormButtonListener();

        // Runnable task so when a delete gets performed
        Runnable higherOrderFunctionForFormButtonsToHideFormAndRefreshGrid = () -> {
            showDisabledFormDiv();
            fillGrid();
        };

        // Listeners from Form
        baseEntityForm.getFormButtonLayout().mapActionToSaveButtonListener(higherOrderFunctionForFormButtonsToHideFormAndRefreshGrid);
        baseEntityForm.getFormButtonLayout().mapActionToUpdateButtonListener(higherOrderFunctionForFormButtonsToHideFormAndRefreshGrid);
        baseEntityForm.getFormButtonLayout().mapActionToDeleteButtonListener(higherOrderFunctionForFormButtonsToHideFormAndRefreshGrid);

        // Add padding to grid
        this.getStyle().set("padding", "30px");

        // TODO: Make sure this adds the other columns when making the subclass inherit this class
        add(gridLayout, baseEntityFormDiv);

    }

    protected void prepareGridColumnActionButtonLayoutToBeFrozen() {
        baseEntityGrid.addColumn(mapActionToButtonLayoutFromColumnAction()).setHeader("Action");
    }

    protected ComponentRenderer<Div, Model> mapActionToButtonLayoutFromColumnAction() {
        return new ComponentRenderer<>(entityFromColumn -> {

            GridColumnActionButtonLayout actionButtonLayout = new GridColumnActionButtonLayout();

            // Trigger event when clicking edit Button to show a form in the window side
            actionButtonLayout.addListenerForEditButton(buttonClickEvent -> {
                baseEntityForm.setEntity(entityFromColumn);
                baseEntityForm.setVisibilityUpdateButton(Boolean.TRUE);
                baseEntityForm.setVisibilityDeleteButton(Boolean.TRUE);
                baseEntityForm.setVisibilitySaveButton(Boolean.FALSE);
                baseEntityForm.showBaseEntityFields();
                showEnabledFormDiv();
            });

            // Trigger event when clicking edit Button to show a form in the window side
            actionButtonLayout.addListenerForInfoButton(buttonClickEvent -> {
                baseEntityForm.showBaseEntityFields();
                baseEntityForm.setEntity(entityFromColumn);
                baseEntityForm.setVisibilitySaveButton(Boolean.FALSE);
                baseEntityForm.setVisibilityUpdateButton(Boolean.FALSE);
                baseEntityForm.setVisibilityDeleteButton(Boolean.FALSE);
                showDisabledFormDiv();
            });


            return addStyleToComponentInDiv(actionButtonLayout, "center", "2px", "100%");

        });

    }

    protected void fillGrid() {
        baseEntityGrid.setItems(baseEntityService.findAll());
    }

    private void addRefreshButtonListener() {
        this.gridActionButtonLayout.addListenerForRefreshButton(buttonClickEvent -> {
            fillGrid();
        });
    }

    private void addHideFormButtonListener() {
        this.gridActionButtonLayout.addListenerForHideFormButton(buttonClickEvent -> {
            hideFormDiv();
        });
    }

    private void addNewItemButtonListener() {
        this.gridActionButtonLayout.addListenerForNewItemButton(buttonClickEvent -> {
            baseEntityForm.setEntity(baseEntityForm.preparedBaseEntityWithAuditAttributes());
            baseEntityForm.setVisibilityUpdateButton(Boolean.FALSE);
            baseEntityForm.setVisibilityDeleteButton(Boolean.FALSE);
            baseEntityForm.setVisibilitySaveButton(Boolean.TRUE);
            baseEntityForm.hideBaseEntityFields();
            showEnabledFormDiv();
        });
    }

    private void hideFormDiv() {
        gridActionButtonLayout.setVisibilityToHideFormButton(Boolean.FALSE);
        this.baseEntityFormDiv.setVisible(Boolean.FALSE);
        this.baseEntityFormDiv.setEnabled(Boolean.FALSE);
    }

    private void showEnabledFormDiv() {
        gridActionButtonLayout.setVisibilityToHideFormButton(Boolean.TRUE);
        this.baseEntityFormDiv.setVisible(Boolean.TRUE);
        this.baseEntityFormDiv.setEnabled(Boolean.TRUE);
    }

    private void showDisabledFormDiv() {
        gridActionButtonLayout.setVisibilityToHideFormButton(Boolean.TRUE);
        this.baseEntityFormDiv.setVisible(Boolean.TRUE);
        this.baseEntityFormDiv.setEnabled(Boolean.FALSE);
    }
}
