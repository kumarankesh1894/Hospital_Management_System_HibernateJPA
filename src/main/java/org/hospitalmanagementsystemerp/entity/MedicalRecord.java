package org.hospitalmanagementsystemerp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate recordDate;
    private String diagnosis;
    private String notes;

    // Required by Hibernate
    public MedicalRecord() {}

    // -----------------------------
    // Getters
    // -----------------------------
    public Long getId() { return id; }

    public LocalDate getRecordDate() { return recordDate; }

    public String getDiagnosis() { return diagnosis; }

    public String getNotes() { return notes; }

    // -----------------------------
    // Setters
    // -----------------------------
    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}