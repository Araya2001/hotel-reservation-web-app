package g5.hotelreservationwebapp.ui.form;


import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservation;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservationDetails;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationDetailsService;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationService;


@Route("customer-room-reservation-details-form")
public class CustomerRoomReservationDetailsForm extends BaseEntityForm<CustomerRoomReservationDetails> {

    private final ComboBox<CustomerRoomReservation> customerRoomReservation = new ComboBox<>("Customer Room Reservation");
    private final TextField detailKey = new TextField("Detail Key");
    private final TextField detailValue = new TextField("Detail Value");


    public CustomerRoomReservationDetailsForm(CustomerRoomReservationDetailsService customerRoomReservationDetailsService,
                                              CustomerRoomReservationService customerRoomReservationService) {
        super(customerRoomReservationDetailsService, new Binder<>(CustomerRoomReservationDetails.class), "Customer Room Reservation Details");

        // Configure petOwnerCombo
        customerRoomReservation.setItems(customerRoomReservationService.findAll());
        customerRoomReservation.setItemLabelGenerator(reservation ->
                new StringBuffer()
                        .append(reservation.getRoom().getIdentificationValue())
                        .append("::")
                        .append(reservation.getCustomer().getFullName())
                        .toString());

        // Bind instance fields
        binder.bindInstanceFields(this);

        // Add new Entity to Binder
        setEntity(preparedBaseEntityWithAuditAttributes());

        // Add components to Layout
        add(customerRoomReservation, detailKey, detailValue, styledFormButtonLayoutDiv);
    }

    @Override
    public CustomerRoomReservationDetails createNewEntity() {
        return new CustomerRoomReservationDetails();
    }
}