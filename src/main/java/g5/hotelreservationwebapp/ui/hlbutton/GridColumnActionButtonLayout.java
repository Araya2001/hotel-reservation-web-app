package g5.hotelreservationwebapp.ui.hlbutton;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("grid-column-action-button-layout")
public class GridColumnActionButtonLayout extends HorizontalLayout {

    // Grid Buttons
    private final Button infoButton = new Button(new Icon(VaadinIcon.INFO));
    private final Button editButton = new Button(new Icon(VaadinIcon.EDIT));

    public GridColumnActionButtonLayout() {
        // Set Theme Variant to LUMO SMALL for greater visibility on the grid
        infoButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        editButton.addThemeVariants(ButtonVariant.LUMO_SMALL);

        // Set aria-labels to each button
        infoButton.setAriaLabel("information");
        editButton.setAriaLabel("edit");

        // Set tooltip to each button
        infoButton.setTooltipText("Show more information for this record");
        editButton.setTooltipText("Edit this record");


        // Add Buttons to layout
        add(infoButton, editButton);
    }

    // addListenerForInfoButton and addListenerForEditButton will be managed by the grid
    public void addListenerForInfoButton(ComponentEventListener<ClickEvent<Button>> listener) {
        this.infoButton.addClickListener(listener);
    }

    public void addListenerForEditButton(ComponentEventListener<ClickEvent<Button>> listener) {
        this.editButton.addClickListener(listener);
    }
}
