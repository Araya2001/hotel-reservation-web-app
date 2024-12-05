package g5.hotelreservationwebapp.ui.form;


import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.Room;
import g5.hotelreservationwebapp.backend.model.RoomDetails;
import g5.hotelreservationwebapp.backend.service.RoomDetailsService;
import g5.hotelreservationwebapp.backend.service.RoomService;


@Route("room-details-form")
public class RoomDetailsForm extends BaseEntityForm<RoomDetails> {
    private final TextField detailKey = new TextField("Detail Key");
    private final TextField detailValue = new TextField("Detail Value");
    private final ComboBox<Room> room = new ComboBox<>("Room");


    public RoomDetailsForm(RoomDetailsService RoomDetailsService, RoomService roomService) {
        super(RoomDetailsService, new Binder<>(RoomDetails.class), "Room Details");

        // Configure petOwnerCombo
        room.setItems(roomService.findAll());
        room.setItemLabelGenerator(Room::getIdentificationValue);

        // Bind instance fields
        binder.bindInstanceFields(this);

        // Add new Entity to Binder
        setEntity(preparedBaseEntityWithAuditAttributes());

        // Add components to Layout
        add(detailKey, detailValue, room, styledFormButtonLayoutDiv);
    }

    @Override
    public RoomDetails createNewEntity() {
        return new RoomDetails();
    }
}