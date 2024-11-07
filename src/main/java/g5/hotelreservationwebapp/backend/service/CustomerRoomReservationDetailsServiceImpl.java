package g5.hotelreservationwebapp.backend.service;

import g5.hotelreservationwebapp.backend.model.CustomerRoomReservationDetails;
import g5.hotelreservationwebapp.backend.repository.CustomerRoomReservationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRoomReservationDetailsServiceImpl extends AbstractBaseEntityServiceImpl<CustomerRoomReservationDetails> implements CustomerRoomReservationDetailsService {
    private final CustomerRoomReservationDetailsRepository customerRoomReservationDetailsRepository;

    @Autowired
    public CustomerRoomReservationDetailsServiceImpl(CustomerRoomReservationDetailsRepository customerRoomReservationDetailsRepository) {
        super(customerRoomReservationDetailsRepository);
        this.customerRoomReservationDetailsRepository = customerRoomReservationDetailsRepository;
    }

}