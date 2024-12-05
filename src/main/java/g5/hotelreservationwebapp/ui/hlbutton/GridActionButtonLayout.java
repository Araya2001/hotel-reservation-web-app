package g5.hotelreservationwebapp.ui.hlbutton;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("grid-action-button-layout")
public class GridActionButtonLayout extends HorizontalLayout {
    // Grid Buttons
    private final Button newItemButton = new Button("New Item", new Icon(VaadinIcon.PLUS));
    private final Button refreshButton = new Button("Refresh", new Icon(VaadinIcon.REFRESH));
    private final Button hideFormButton = new Button("Hide Form", new Icon(VaadinIcon.CLOSE));

    public GridActionButtonLayout() {
        // Set Theme Variant to LUMO SMALL for greater visibility on the grid
        newItemButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        refreshButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        hideFormButton.addThemeVariants(ButtonVariant.LUMO_ICON);

        // Set aria-labels to each button
        newItemButton.setAriaLabel("new-item");
        refreshButton.setAriaLabel("refresh-items");
        hideFormButton.setAriaLabel("hide-form");

        // Set tooltip to each button
        newItemButton.setTooltipText("Add a new Record");
        refreshButton.setTooltipText("Refresh Table");
        refreshButton.setTooltipText("Hide Form");


        // Add Buttons to layout
        add(newItemButton, refreshButton, hideFormButton);
    }

    // addListenerForInfoButton, addListenerForEditButton and addListenerForHideFormButton will be managed by the grid
    public void addListenerForNewItemButton(ComponentEventListener<ClickEvent<Button>> listener) {
        this.newItemButton.addClickListener(listener);
    }

    public void addListenerForRefreshButton(ComponentEventListener<ClickEvent<Button>> listener) {
        this.refreshButton.addClickListener(listener);
    }

    public void addListenerForHideFormButton(ComponentEventListener<ClickEvent<Button>> listener) {
        this.hideFormButton.addClickListener(listener);
    }

    // The grid layout may trigger the hide form button
    public void setVisibilityToHideFormButton(Boolean isVisible) {
        this.hideFormButton.setVisible(isVisible);
        this.hideFormButton.setEnabled(isVisible);
    }


}
