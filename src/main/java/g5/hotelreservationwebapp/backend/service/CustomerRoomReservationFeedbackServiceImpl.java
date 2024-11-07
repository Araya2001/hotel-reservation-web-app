package g5.hotelreservationwebapp.backend.service;

import g5.hotelreservationwebapp.backend.model.CustomerRoomReservationFeedback;
import g5.hotelreservationwebapp.backend.repository.CustomerRoomReservationFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRoomReservationFeedbackServiceImpl extends AbstractBaseEntityServiceImpl<CustomerRoomReservationFeedback> implements CustomerRoomReservationFeedbackService {
    private final CustomerRoomReservationFeedbackRepository customerRoomReservationFeedbackRepository;

    @Autowired
    public CustomerRoomReservationFeedbackServiceImpl(CustomerRoomReservationFeedbackRepository customerRoomReservationFeedbackRepository) {
        super(customerRoomReservationFeedbackRepository);
        this.customerRoomReservationFeedbackRepository = customerRoomReservationFeedbackRepository;
    }

}