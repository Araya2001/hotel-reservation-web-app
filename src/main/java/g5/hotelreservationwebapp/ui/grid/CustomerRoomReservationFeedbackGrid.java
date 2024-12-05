package g5.hotelreservationwebapp.ui.grid;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservationFeedback;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationFeedbackService;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationService;
import g5.hotelreservationwebapp.ui.form.CustomerRoomReservationFeedbackForm;
import g5.hotelreservationwebapp.ui.layout.MainAppLayout;

@Route(value = "customer-room-reservation-feedback-grid", layout = MainAppLayout.class)
public class CustomerRoomReservationFeedbackGrid extends BaseEntityGrid<CustomerRoomReservationFeedback> {

    public CustomerRoomReservationFeedbackGrid(CustomerRoomReservationFeedbackService customerRoomReservationFeedbackService,
                                               CustomerRoomReservationService customerRoomReservationService) {
        super(
                new Grid<>(CustomerRoomReservationFeedback.class, true),
                new CustomerRoomReservationFeedbackForm(customerRoomReservationFeedbackService, customerRoomReservationService),
                customerRoomReservationFeedbackService,
                "Customer Room Reservation Feedback Table"
        );

        super.fillGrid();
    }
}