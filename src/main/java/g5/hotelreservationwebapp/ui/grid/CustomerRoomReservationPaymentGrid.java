package g5.hotelreservationwebapp.ui.grid;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.CustomerRoomReservationPayment;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationPaymentService;
import g5.hotelreservationwebapp.backend.service.CustomerRoomReservationService;
import g5.hotelreservationwebapp.ui.form.CustomerRoomReservationPaymentForm;
import g5.hotelreservationwebapp.ui.layout.MainAppLayout;

@Route(value = "customer-room-reservation-payment-grid", layout = MainAppLayout.class)
public class CustomerRoomReservationPaymentGrid extends BaseEntityGrid<CustomerRoomReservationPayment> {

    public CustomerRoomReservationPaymentGrid(CustomerRoomReservationPaymentService customerRoomReservationPaymentService,
                                              CustomerRoomReservationService customerRoomReservationService) {
        super(
                new Grid<>(CustomerRoomReservationPayment.class, true),
                new CustomerRoomReservationPaymentForm(customerRoomReservationPaymentService, customerRoomReservationService),
                customerRoomReservationPaymentService,
                "Customer Room Reservation Payment Table"
        );

        super.fillGrid();
    }
}