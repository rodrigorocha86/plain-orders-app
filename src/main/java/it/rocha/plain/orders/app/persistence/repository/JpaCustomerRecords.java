package it.rocha.plain.orders.app.persistence.repository;

import it.rocha.plain.orders.app.persistence.model.CustomerRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomerRecords
        extends CrudRepository<CustomerRecord, Long> {
}
