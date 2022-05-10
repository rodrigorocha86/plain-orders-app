package it.rocha.plain.orders.app.database.customer.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CustomerRecord {

    @Id
    private String code;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthdate;

    public CustomerRecord() {}

    public CustomerRecord(
            String code, String cpf,
            String name, LocalDate birthdate) {
        this();
        this.cpf = cpf;
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getCode() { return code; }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) { this.birthdate = birthdate; }
}