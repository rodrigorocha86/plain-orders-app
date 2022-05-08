package it.rocha.plain.orders.app.persistence.repository;

import it.rocha.plain.orders.app.persistence.model.CustomerRecord;
import it.rocha.plain.orders.domain.entity.Cpf;
import it.rocha.plain.orders.domain.entity.Customer;
import it.rocha.plain.orders.domain.repository.Customers;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class JpaCustomers
        implements Customers {

    private JpaCustomerRecords jpaCustomerRecords;

    public JpaCustomers(JpaCustomerRecords jpaCustomerRecords) {
        this.jpaCustomerRecords = jpaCustomerRecords;
    }

    @Override
    public void add(Customer customer) {
        CustomerRecord customerRecord =
                new CustomerRecord(
                        customer.getCpf().getValue(),
                        customer.getName(),
                        customer.getBirthdate()
                );

        jpaCustomerRecords.save(customerRecord);
    }

    @Override
    public Set<Customer> all() {
        var stream = StreamSupport.stream(
                jpaCustomerRecords.findAll().spliterator(), false);

        return stream.map(
                customerRecord ->
                        new Customer(
                                new Cpf(customerRecord.getCpf()),
                                customerRecord.getName(),
                                customerRecord.getBirthdate())
                ).collect(Collectors.toSet());
    }
}