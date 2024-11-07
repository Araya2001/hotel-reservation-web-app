package g5.hotelreservationwebapp.backend.service;

import g5.hotelreservationwebapp.backend.model.CustomerContact;
import g5.hotelreservationwebapp.backend.repository.CustomerContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactServiceImpl extends AbstractBaseEntityServiceImpl<CustomerContact> implements CustomerContactService {
    private final CustomerContactRepository customerContactRepository;

    @Autowired
    public CustomerContactServiceImpl(CustomerContactRepository customerContactRepository) {
        super(customerContactRepository);
        this.customerContactRepository = customerContactRepository;
    }

}