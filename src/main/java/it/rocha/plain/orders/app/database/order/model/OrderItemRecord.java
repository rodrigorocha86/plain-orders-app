package it.rocha.plain.orders.app.database.order.model;

import it.rocha.plain.orders.domain.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderItemRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(optional = false)
    private OrderRecord orderRecord;

    @Column
    private String productCode;

    @Column
    private  BigDecimal productValue;

    @Column
    private Integer amount;

    public OrderItemRecord() {}

    public OrderItemRecord(
            OrderRecord orderRecord,
            String productCode, BigDecimal productValue,
            Integer amount) {
        this.productCode = productCode;
        this.productValue = productValue;
        this.amount = amount;
    }
}