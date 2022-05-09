package it.rocha.plain.orders.app.database.persistence;

import it.rocha.plain.orders.app.database.model.CustomerRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRecordDao
        extends CrudRepository<CustomerRecord, Long> {
}
