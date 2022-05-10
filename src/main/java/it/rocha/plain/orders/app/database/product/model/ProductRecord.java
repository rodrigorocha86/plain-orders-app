package it.rocha.plain.orders.app.database.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ProductRecord {

    @Id
    private String code;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal value;

    public ProductRecord() {}

    public ProductRecord(
            String code, String name,
            String description, BigDecimal value) {
        this();
        this.code = code;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) { this.value = value; }
}