package g5.hotelreservationwebapp.ui.form;


import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservation;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservationFeedback;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationFeedbackService;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationService;


@Route("customer-room-reservation-feedback-form")
public class CustomerRoomReservationFeedbackForm extends BaseEntityForm<CustomerRoomReservationFeedback> {

    private final ComboBox<CustomerRoomReservation> customerRoomReservation = new ComboBox<>("Customer Room Reservation");
    private final TextField feedback = new TextField("Feedback");
    private final IntegerField ratingValue = new IntegerField("Rating Value");


    public CustomerRoomReservationFeedbackForm(CustomerRoomReservationFeedbackService customerRoomReservationFeedbackService,
                                               CustomerRoomReservationService customerRoomReservationService) {
        super(customerRoomReservationFeedbackService, new Binder<>(CustomerRoomReservationFeedback.class), "Customer Room Reservation " +
                "Feedback");

        // Configure petOwnerCombo
        customerRoomReservation.setItems(customerRoomReservationService.findAll());
        customerRoomReservation.setItemLabelGenerator(reservation ->
                new StringBuffer()
                        .append(reservation.getRoom().getIdentificationValue())
                        .append("::")
                        .append(reservation.getCustomer().getFullName())
                        .toString());

        ratingValue.setValue(1);
        ratingValue.setMin(1);
        ratingValue.setMax(10);
        ratingValue.setStep(1);
        ratingValue.setStepButtonsVisible(true);
        ratingValue.setHelperText("Minimum Rating: 1, Maximum Rating: 10");


        // Bind instance fields
        binder.bindInstanceFields(this);

        // Add new Entity to Binder
        setEntity(preparedBaseEntityWithAuditAttributes());

        // Add components to Layout
        add(customerRoomReservation, feedback, ratingValue, styledFormButtonLayoutDiv);
    }

    @Override
    public CustomerRoomReservationFeedback createNewEntity() {
        return new CustomerRoomReservationFeedback();
    }
}