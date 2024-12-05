package g5.hotelreservationwebapp.ui.form;


import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.Customer;
import g5.hotelreservationwebapp.backend.model.CustomerContact;
import g5.hotelreservationwebapp.backend.service.CustomerContactService;
import g5.hotelreservationwebapp.backend.service.CustomerService;


@Route("customer-contact-form")
public class CustomerContactForm extends BaseEntityForm<CustomerContact> {
    private final TextField communicationType = new TextField("Communication Type");
    private final TextField communicationTypeValue = new TextField("Communication Type Value");
    private final ComboBox<Customer> customer = new ComboBox<>("Customer");


    public CustomerContactForm(CustomerContactService customerContactService, CustomerService customerService) {
        super(customerContactService, new Binder<>(CustomerContact.class), "Customer Contact");

        // Configure petOwnerCombo
        customer.setItems(customerService.findAll());
        customer.setItemLabelGenerator(Customer::getFullName);

        // Bind instance fields
        binder.bindInstanceFields(this);

        // Add new Entity to Binder
        setEntity(preparedBaseEntityWithAuditAttributes());

        // Add components to Layout
        add(communicationType, communicationTypeValue, customer, styledFormButtonLayoutDiv);
    }

    @Override
    public CustomerContact createNewEntity() {
        return new CustomerContact();
    }
}