package g5.hotelreservationwebapp.ui.form;


import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import g5.hotelreservationwebapp.backend.model.BaseEntity;
import g5.hotelreservationwebapp.backend.service.BaseEntityService;
import g5.hotelreservationwebapp.ui.hlbutton.FormButtonLayout;
import g5.hotelreservationwebapp.ui.style.StyleComponent;
import lombok.Getter;


public abstract class BaseEntityForm<Model extends BaseEntity> extends FormLayout implements StyleComponent {
    // Fields from BaseEntity
    protected final TextField id = new TextField("ID");
    protected final DateTimePicker dateCreate = new DateTimePicker("Created At");
    protected final DateTimePicker dateUpdate = new DateTimePicker("Updated At");
    protected final H3 formTitle;

    // Binder for Data Handling, this object instance must be available for forms to autocomplete when pressing edit or info in a grid
    @Getter
    protected final Binder<Model> binder;

    // Button Layout for every form
    @Getter
    protected final FormButtonLayout<Model> formButtonLayout;

    protected final Div styledFormButtonLayoutDiv;

    public BaseEntityForm(BaseEntityService<Model> entityService, Binder<Model> binder, String title) {
        // Map binder from subclass
        this.binder = binder;

        // Add Custom Button Layout to form
        this.formButtonLayout = new FormButtonLayout<>(entityService, binder);

        // Add title to form
        this.formTitle = new H3(title);

        // We don't need to modify this values from the frontend, however, they might become valuable for audit purposes
        id.setReadOnly(true);
        dateCreate.setReadOnly(true);
        dateUpdate.setReadOnly(true);


        // Add Style Title in a Div
        Div divFromTitle = addStyleToComponentInDiv(formTitle, "left", "4px", "100%");
        setColspan(divFromTitle, 2);

        // Add Style to the Button Form Layout
        this.styledFormButtonLayoutDiv = addStyleToComponentInDiv(formButtonLayout, "right", "0px", "100%");
        setColspan(styledFormButtonLayoutDiv, 2);

        // Add Base entity Fields to form
        add(divFromTitle, id, dateCreate, dateUpdate);
    }

    public Model preparedBaseEntityWithAuditAttributes() {
        // Get Entity From Subclass
        return createNewEntity();
    }

    public void hideBaseEntityFields() {
        // We might not need to have visibility of this data when creating new Records
        id.setVisible(Boolean.FALSE);
        dateCreate.setVisible(Boolean.FALSE);
        dateUpdate.setVisible(Boolean.FALSE);
    }

    public void showBaseEntityFields() {
        // We might not need to have visibility of this data when creating new Records
        id.setVisible(Boolean.TRUE);
        dateCreate.setVisible(Boolean.TRUE);
        dateUpdate.setVisible(Boolean.TRUE);
    }

    public void setEntity(Model entity) {
        binder.setBean(entity);
    }

    public void setVisibilitySaveButton(Boolean isVisible) {
        formButtonLayout.setVisibilitySaveButton(isVisible);
    }

    public void setVisibilityUpdateButton(Boolean isVisible) {
        formButtonLayout.setVisibilityUpdateButton(isVisible);
    }

    public void setVisibilityDeleteButton(Boolean isVisible) {
        formButtonLayout.setVisibilityDeleteButton(isVisible);
    }

    public abstract Model createNewEntity();

}
