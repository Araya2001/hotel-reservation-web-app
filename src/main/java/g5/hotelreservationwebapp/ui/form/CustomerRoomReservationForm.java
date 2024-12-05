package g5.hotelreservationwebapp.ui.form;


import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.Customer;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservation;
import g5.hotelreservationwebapp.backend.model.Room;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationService;
import g5.hotelreservationwebapp.backend.service.CustomerService;
import g5.hotelreservationwebapp.backend.service.RoomService;


@Route("customer-room-reservation-form")
public class CustomerRoomReservationForm extends BaseEntityForm<CustomerRoomReservation> {


    private final ComboBox<Room> room = new ComboBox<>("Room");
    private final ComboBox<Customer> customer = new ComboBox<>("Customer");
    private final DateTimePicker reservationStartDate = new DateTimePicker("Start Date");
    private final DateTimePicker reservationEndDate = new DateTimePicker("End Date");


    public CustomerRoomReservationForm(CustomerRoomReservationService customerRoomReservationService, CustomerService customerService,
                                       RoomService roomService) {
        super(customerRoomReservationService, new Binder<>(CustomerRoomReservation.class), "Customer Room Reservation");

        // Configure petOwnerCombo
        customer.setItems(customerService.findAll());
        customer.setItemLabelGenerator(Customer::getFullName);

        // Configure petOwnerCombo
        room.setItems(roomService.findAll());
        room.setItemLabelGenerator(Room::getIdentificationValue);

        // Bind instance fields
        binder.bindInstanceFields(this);

        // Add new Entity to Binder
        setEntity(preparedBaseEntityWithAuditAttributes());

        // Add components to Layout
        add(room, customer, reservationStartDate, reservationEndDate, styledFormButtonLayoutDiv);
    }

    @Override
    public CustomerRoomReservation createNewEntity() {
        return new CustomerRoomReservation();
    }
}