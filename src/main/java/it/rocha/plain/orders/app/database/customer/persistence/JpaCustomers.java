package it.rocha.plain.orders.app.database.customer.persistence;

import it.rocha.plain.orders.app.database.customer.model.CustomerRecord;
import it.rocha.plain.orders.app.database.customer.persistence.CustomerRecordDao;
import it.rocha.plain.orders.domain.customer.Cpf;
import it.rocha.plain.orders.domain.customer.Customer;
import it.rocha.plain.orders.domain.customer.Customers;
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
    public void create(Customer customer) {
        CustomerRecord customerRecord =
                new CustomerRecord(
                        customer.getCode(),
                        customer.getCpf().getValue(),
                        customer.getName(),
                        customer.getBirthdate()
                );

        customerRecordDao.save(customerRecord);
    }

    @Override
    public void update(Customer customer) {
        CustomerRecord customerRecord =
                customerRecordDao.findById(customer.getCode())
                        .orElse(null);

        if(customerRecord == null) {
            throw new IllegalArgumentException("Customer not exists in the database!");
        }
        customerRecord.setName(customer.getName());
        customerRecord.setBirthdate(customer.getBirthdate());
        customerRecordDao.save(customerRecord);
    }

    @Override
    public Customer get(String code) {
        CustomerRecord customerRecord =
                customerRecordDao.findById(code)
                        .orElse(null);

        if(customerRecord == null) {
            return null;
        }
        return new Customer(
                customerRecord.getCode(),
                new Cpf(customerRecord.getCpf()),
                customerRecord.getName(),
                customerRecord.getBirthdate()
        );
    }

    @Override
    public Set<Customer> all() {
        var stream = StreamSupport.stream(
                customerRecordDao.findAll().spliterator(), false);

        return stream.map(
                customerRecord ->
                        new Customer(
                                customerRecord.getCode(),
                                new Cpf(customerRecord.getCpf()),
                                customerRecord.getName(),
                                customerRecord.getBirthdate())
                ).collect(Collectors.toSet());
    }
}