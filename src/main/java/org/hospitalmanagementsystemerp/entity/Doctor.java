package org.hospitalmanagementsystemerp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String licenseNo;

    // ---------------------------------
    // MANY side of Department 1:N
    // ---------------------------------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    // ---------------------------------
    // Uni 1:N → Doctor manages Appointments
    // ---------------------------------
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private List<Appointment> appointments = new ArrayList<>();

    // ---------------------------------
    // Owning side of Many-to-Many
    // ---------------------------------
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "patient_doctors",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients = new ArrayList<>();

    // Required by Hibernate
    public Doctor() {}

    // ---------------------------------
    // Getters
    // ---------------------------------
    public Long getId() { return id; }

    public String getName() { return name; }

    public String getSpecialization() { return specialization; }

    public String getLicenseNo() { return licenseNo; }

    public Department getDepartment() { return department; }

    public List<Appointment> getAppointments() { return appointments; }

    public List<Patient> getPatients() { return patients; }

    // ---------------------------------
    // Setters
    // ---------------------------------
    public void setName(String name) { this.name = name; }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // ---------------------------------
    // Helper Methods (VERY IMPORTANT)
    // ---------------------------------
    public void addPatient(Patient patient) {
        patients.add(patient);
        patient.getDoctors().add(this);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
        patient.getDoctors().remove(this);
    }
}