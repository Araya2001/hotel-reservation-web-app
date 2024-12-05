package g5.hotelreservationwebapp.ui.form;


import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.Customer;
import g5.hotelreservationwebapp.backend.service.CustomerService;


@Route("customer-form")
public class CustomerForm extends BaseEntityForm<Customer> {
    private final TextField fullName = new TextField("Full Name");
    private final TextField identification = new TextField("Identification");
    private final TextField identificationType = new TextField("Identification Type");


    public CustomerForm(CustomerService customerService) {
        super(customerService, new Binder<>(Customer.class), "Customer");

        // Bind instance fields
        binder.bindInstanceFields(this);

        // Add new Entity to Binder
        setEntity(preparedBaseEntityWithAuditAttributes());

        // Add components to Layout
        add(fullName, identification, identificationType, styledFormButtonLayoutDiv);
    }

    @Override
    public Customer createNewEntity() {
        return new Customer();
    }
}