package g5.hotelreservationwebapp.backend.service;

import g5.hotelreservationwebapp.backend.model.Customer;
import g5.hotelreservationwebapp.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends AbstractBaseEntityServiceImpl<Customer> implements CustomerService {

    @Autowired
    protected CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
    }
}
