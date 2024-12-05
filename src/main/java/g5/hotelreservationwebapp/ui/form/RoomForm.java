package g5.hotelreservationwebapp.ui.form;


import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.Room;
import g5.hotelreservationwebapp.backend.service.RoomService;


@Route("room-form")
public class RoomForm extends BaseEntityForm<Room> {
    private final IntegerField floor = new IntegerField("Floor");
    private final TextField identificationValue = new TextField("Room Number");
    private final Checkbox isRoomAvailable = new Checkbox("Room Available");


    public RoomForm(RoomService customerContactService) {
        super(customerContactService, new Binder<>(Room.class), "Room");

        floor.setMin(1);
        floor.setMax(10);
        floor.setRequired(true);
        floor.setStep(1);
        floor.setStepButtonsVisible(true);


        // Bind instance fields
        binder.bindInstanceFields(this);

        // Add new Entity to Binder
        setEntity(preparedBaseEntityWithAuditAttributes());

        // Add components to Layout
        add(floor, identificationValue, isRoomAvailable, styledFormButtonLayoutDiv);
    }

    @Override
    public Room createNewEntity() {
        return new Room();
    }
}