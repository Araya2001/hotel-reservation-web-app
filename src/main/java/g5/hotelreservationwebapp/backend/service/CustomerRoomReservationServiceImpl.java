package g5.hotelreservationwebapp.backend.service;

import g5.hotelreservationwebapp.backend.model.CustomerRoomReservation;
import g5.hotelreservationwebapp.backend.repository.CustomerRoomReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRoomReservationServiceImpl extends AbstractBaseEntityServiceImpl<CustomerRoomReservation> implements CustomerRoomReservationService {
    private final CustomerRoomReservationRepository customerRoomReservationRepository;

    @Autowired
    public CustomerRoomReservationServiceImpl(CustomerRoomReservationRepository customerRoomReservationRepository) {
        super(customerRoomReservationRepository);
        this.customerRoomReservationRepository = customerRoomReservationRepository;
    }

}