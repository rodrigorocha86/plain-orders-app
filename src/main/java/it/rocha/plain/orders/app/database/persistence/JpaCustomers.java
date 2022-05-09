package it.rocha.plain.orders.app.database.persistence;

import it.rocha.plain.orders.app.database.model.CustomerRecord;

import it.rocha.plain.orders.domain.customer.Cpf;
import it.rocha.plain.orders.domain.customer.Customer;
import it.rocha.plain.orders.repository.Customers;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class JpaCustomers
        implements Customers {

    private CustomerRecordDao customerRecordDao;

    public JpaCustomers(CustomerRecordDao customerRecordDao) {
        this.customerRecordDao = customerRecordDao;
    }

    @Override
    public void add(Customer customer) {
        CustomerRecord customerRecord =
                new CustomerRecord(
                        customer.getCpf().getValue(),
                        customer.getName(),
                        customer.getBirthdate()
                );

        customerRecordDao.save(customerRecord);
    }

    @Override
    public Set<Customer> all() {
        var stream = StreamSupport.stream(
                customerRecordDao.findAll().spliterator(), false);

        return stream.map(
                customerRecord ->
                        new Customer(
                                new Cpf(customerRecord.getCpf()),
                                customerRecord.getName(),
                                customerRecord.getBirthdate())
                ).collect(Collectors.toSet());
    }
}