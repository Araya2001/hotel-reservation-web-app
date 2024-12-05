package g5.hotelreservationwebapp.ui.grid;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.CustomerContact;
import g5.hotelreservationwebapp.backend.service.CustomerContactService;
import g5.hotelreservationwebapp.backend.service.CustomerService;
import g5.hotelreservationwebapp.ui.form.CustomerContactForm;
import g5.hotelreservationwebapp.ui.layout.MainAppLayout;

@Route(value = "customer-contact-grid", layout = MainAppLayout.class)
public class CustomerContactGrid extends BaseEntityGrid<CustomerContact> {

    public CustomerContactGrid(CustomerContactService customerContactService, CustomerService customerService) {
        super(
                new Grid<>(CustomerContact.class, true),
                new CustomerContactForm(customerContactService, customerService),
                customerContactService,
                "Customer Contact Table"
        );

        super.fillGrid();
    }
}