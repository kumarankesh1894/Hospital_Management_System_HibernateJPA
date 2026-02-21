package org.hospitalmanagementsystemerp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dob;
    private String bloodGroup;
    private String phone;

    // -----------------------------
    // Uni 1:1 with MedicalRecord
    // -----------------------------
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "med_record_id")
    private MedicalRecord medicalRecord;

    // -----------------------------
    // Inverse side of Many-to-Many
    // -----------------------------
    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors = new ArrayList<>();

    // REQUIRED by Hibernate
    public Patient() {}

    // -----------------------------
    // Getters
    // -----------------------------
    public Long getId() { return id; }

    public String getName() { return name; }

    public LocalDate getDob() { return dob; }

    public String getBloodGroup() { return bloodGroup; }

    public String getPhone() { return phone; }

    public MedicalRecord getMedicalRecord() { return medicalRecord; }

    public List<Doctor> getDoctors() { return doctors; }

    // -----------------------------
    // Setters
    // -----------------------------
    public void setName(String name) { this.name = name; }

    public void setDob(LocalDate dob) { this.dob = dob; }

    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}