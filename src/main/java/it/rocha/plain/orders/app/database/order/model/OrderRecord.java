package it.rocha.plain.orders.app.database.order.model;

import it.rocha.plain.orders.app.database.customer.model.CustomerRecord;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class OrderRecord {

    @Id
    @Column(nullable = false)
    private Long number;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL, FOREIGN KEY (customer_code) REFERENCES customer_record(code)")
    private String customerCode;

    @Column(nullable = false)
    private BigDecimal total;

    @OneToMany(mappedBy = "orderRecord")
    private List<OrderItemRecord> items;
}