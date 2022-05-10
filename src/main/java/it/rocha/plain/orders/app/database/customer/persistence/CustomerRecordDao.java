package it.rocha.plain.orders.app.database.customer.persistence;

import it.rocha.plain.orders.app.database.customer.model.CustomerRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRecordDao
        extends CrudRepository<CustomerRecord, String> {
}
