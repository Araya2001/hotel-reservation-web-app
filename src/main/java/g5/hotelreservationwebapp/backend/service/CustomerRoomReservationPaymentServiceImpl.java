package g5.hotelreservationwebapp.backend.service;

import g5.hotelreservationwebapp.backend.model.CustomerRoomReservationPayment;
import g5.hotelreservationwebapp.backend.repository.CustomerRoomReservationPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRoomReservationPaymentServiceImpl extends AbstractBaseEntityServiceImpl<CustomerRoomReservationPayment> implements CustomerRoomReservationPaymentService {
    private final CustomerRoomReservationPaymentRepository customerRoomReservationPaymentRepository;

    @Autowired
    public CustomerRoomReservationPaymentServiceImpl(CustomerRoomReservationPaymentRepository customerRoomReservationPaymentRepository) {
        super(customerRoomReservationPaymentRepository);
        this.customerRoomReservationPaymentRepository = customerRoomReservationPaymentRepository;
    }

}