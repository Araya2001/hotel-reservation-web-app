package g5.hotelreservationwebapp.ui.form;


import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservation;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservationPayment;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationPaymentService;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationService;


@Route("customer-room-reservation-payment-form")
public class CustomerRoomReservationPaymentForm extends BaseEntityForm<CustomerRoomReservationPayment> {
    private final ComboBox<CustomerRoomReservation> customerRoomReservation = new ComboBox<>("Customer Room Reservation Payment");
    private final TextField transactionId = new TextField("Transaction ID");
    private final Checkbox isRefund = new Checkbox("Refund Transaction");
    private final Checkbox isTransactionClosed = new Checkbox("Closed Transaction");


    public CustomerRoomReservationPaymentForm(CustomerRoomReservationPaymentService customerRoomReservationPaymentService,
                                              CustomerRoomReservationService customerRoomReservationService) {
        super(customerRoomReservationPaymentService, new Binder<>(CustomerRoomReservationPayment.class), "Customer Contact");

        // Configure petOwnerCombo
        customerRoomReservation.setItems(customerRoomReservationService.findAll());
        customerRoomReservation.setItemLabelGenerator(reservation -> reservation.getId().toString());

        // Bind instance fields
        binder.bindInstanceFields(this);

        // Add new Entity to Binder
        setEntity(preparedBaseEntityWithAuditAttributes());

        // Add components to Layout
        add(customerRoomReservation, transactionId, isRefund, isTransactionClosed, styledFormButtonLayoutDiv);
    }

    @Override
    public CustomerRoomReservationPayment createNewEntity() {
        return new CustomerRoomReservationPayment();
    }
}