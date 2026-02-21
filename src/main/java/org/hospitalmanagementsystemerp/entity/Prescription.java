package org.hospitalmanagementsystemerp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicines;
    private String dosage;
    private LocalDate issuedDate;
    private boolean isActive;

    // Required by Hibernate
    public Prescription() {}

    // ---------------------------------
    // Getters
    // ---------------------------------
    public Long getId() { return id; }

    public String getMedicines() { return medicines; }

    public String getDosage() { return dosage; }

    public LocalDate getIssuedDate() { return issuedDate; }

    public boolean isActive() { return isActive; }

    // ---------------------------------
    // Setters
    // ---------------------------------
    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}