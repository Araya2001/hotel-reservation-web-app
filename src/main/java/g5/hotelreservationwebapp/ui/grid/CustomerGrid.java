package g5.hotelreservationwebapp.ui.grid;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import g5.hotelreservationwebapp.backend.model.Customer;
import g5.hotelreservationwebapp.backend.service.CustomerService;
import g5.hotelreservationwebapp.ui.form.CustomerForm;
import g5.hotelreservationwebapp.ui.layout.MainAppLayout;


@Route(value = "customer-grid", layout = MainAppLayout.class)
public class CustomerGrid extends BaseEntityGrid<Customer> {

    public CustomerGrid(CustomerService customerService) {
        super(
                new Grid<>(Customer.class, true),
                new CustomerForm(customerService),
                customerService,
                "Customer Table"
        );

        super.fillGrid();
    }
}