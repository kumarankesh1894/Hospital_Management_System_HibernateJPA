package org.hospitalmanagementsystemerp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointDate;
    private String status;
    private String reason;

    // ---------------------------------
    // Uni 1:1 (Owner Side)
    // ---------------------------------
    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = true)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    // Required by Hibernate
    public Appointment() {}

    // ---------------------------------
    // Getters
    // ---------------------------------
    public Long getId() { return id; }

    public LocalDateTime getAppointDate() { return appointDate; }

    public String getStatus() { return status; }

    public String getReason() { return reason; }

    public Prescription getPrescription() { return prescription; }

    // ---------------------------------
    // Setters
    // ---------------------------------
    public void setAppointDate(LocalDateTime appointDate) {
        this.appointDate = appointDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}