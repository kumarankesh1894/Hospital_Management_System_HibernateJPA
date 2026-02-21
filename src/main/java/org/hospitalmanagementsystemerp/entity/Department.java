package org.hospitalmanagementsystemerp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String headDoctorName;

    // Bidirectional 1:N
    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Doctor> doctors = new ArrayList<>();

    // Required by Hibernate
    public Department() {}

    // -----------------------------
    // Getters
    // -----------------------------
    public Long getId() { return id; }

    public String getName() { return name; }

    public String getLocation() { return location; }

    public String getHeadDoctorName() { return headDoctorName; }

    public List<Doctor> getDoctors() { return doctors; }

    // -----------------------------
    // Setters
    // -----------------------------
    public void setName(String name) { this.name = name; }

    public void setLocation(String location) { this.location = location; }

    public void setHeadDoctorName(String headDoctorName) {
        this.headDoctorName = headDoctorName;
    }

    // -----------------------------
    // Helper Methods (Very Important)
    // -----------------------------
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.setDepartment(this);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
        doctor.setDepartment(null);
    }
}