package it.rocha.plain.orders.app.web;

import it.rocha.plain.orders.usecase.CreateCustomerAccount;
import it.rocha.plain.orders.usecase.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {

    private CreateCustomerAccount createCustomerAccount;

    public CustomerController(CreateCustomerAccount createCustomerAccount) {
        this.createCustomerAccount = createCustomerAccount;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody CustomerDto customerDto) {
        createCustomerAccount.run(customerDto);
    }
}