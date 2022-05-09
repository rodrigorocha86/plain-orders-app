package it.rocha.plain.orders.app.database.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CustomerRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthdate;

    public CustomerRecord() {}

    public CustomerRecord(String cpf, String name, LocalDate birthdate) {
        this();
        this.cpf = cpf;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}