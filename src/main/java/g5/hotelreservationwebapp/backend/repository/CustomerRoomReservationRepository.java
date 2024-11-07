package g5.hotelreservationwebapp.backend.repository;

import g5.hotelreservationwebapp.backend.model.CustomerRoomReservation;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRoomReservationRepository extends BaseEntityRepository<CustomerRoomReservation> {
    
}