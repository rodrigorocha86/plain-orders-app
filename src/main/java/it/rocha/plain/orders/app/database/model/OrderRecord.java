package it.rocha.plain.orders.app.database.model;

import it.rocha.plain.orders.domain.customer.Customer;

import javax.persistence.*;
import java.math.BigDecimal;

//@Entity
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Long number;

    @ManyToOne(optional = false)
    private Customer customer;

    @Column(nullable = false)
    private BigDecimal total;

}
