package g5.hotelreservationwebapp.ui.hlbutton;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.BaseEntity;
import g5.hotelreservationwebapp.backend.service.BaseEntityService;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Route("form-button-layout")
public class FormButtonLayout<Model extends BaseEntity> extends HorizontalLayout {

    // Form Buttons
    private final Button saveButton = new Button("Save", new Icon(VaadinIcon.PLUS));
    private final Button deleteButton = new Button("Delete", new Icon(VaadinIcon.TRASH));
    private final Button updateButton = new Button("Update", new Icon(VaadinIcon.EDIT));

    // Binder and Service for Data Handling
    private final BaseEntityService<Model> entityService;
    private final Binder<Model> binder;


    public FormButtonLayout(BaseEntityService<Model> entityService, Binder<Model> binder) {
        // Define the object instance for Service and Binder
        this.entityService = entityService;
        this.binder = binder;

        // Add Lumo Style to button
        saveButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        deleteButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        updateButton.addThemeVariants(ButtonVariant.LUMO_ICON);

        // Add components to layout
        add(saveButton, deleteButton, updateButton);
    }

    public void mapActionToSaveButtonListener(Runnable action) {
        // Listens to clicks on Save Button and performs save action through Base Entity Service
        this.saveButton.addClickListener(event -> {
            Model entity = binder.getBean();
            if (entity != null && binder.validate().isOk()) {
                entityService.save(entity);
                Notification.show("Entity with ID: " + entity.getId() + " saved.", 3000, Notification.Position.MIDDLE);
            } else {
                log.error(entity);
            }
            action.run();
        });
    }

    public void mapActionToUpdateButtonListener(Runnable action) {
        // Listens to clicks on Update Button and performs update action through Base Entity Service
        this.updateButton.addClickListener(event -> {
            Model entity = binder.getBean();
            if (entity != null && binder.validate().isOk()) {
                log.warn(entityService.update(entity));
                Notification.show("Entity with ID: " + entity.getId() + " updated.", 3000, Notification.Position.MIDDLE);
            } else {
                log.error(entity.toString());
            }
            action.run();
        });
    }

    public void mapActionToDeleteButtonListener(Runnable action) {
        // Listens to clicks on Delete Button and performs update action through Base Entity Service
        this.deleteButton.addClickListener(event -> {
            Model entity = binder.getBean();
            if (binder.validate().isOk()) {
                entityService.hardDelete(entity);
                Notification.show("Entity with ID: " + entity.getId() + " deleted.", 3000, Notification.Position.MIDDLE);
            }
        });
    }


    public void setVisibilitySaveButton(Boolean isVisible) {
        // This will flag hide the Save Button in the UI
        this.saveButton.setVisible(isVisible);
    }

    public void setVisibilityUpdateButton(Boolean isVisible) {
        // This will flag hide the Update Button in the UI
        this.updateButton.setVisible(isVisible);
    }

    public void setVisibilityDeleteButton(Boolean isVisible) {
        // This will flag hide the Delete Button in the UI
        this.deleteButton.setVisible(isVisible);
    }
}
