package org.hospitalmanagementsystemerp.services;
import org.hospitalmanagementsystemerp.config.HibernateUtil;
import org.hospitalmanagementsystemerp.entity.*;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;

public class DoctorService {

    public void assignDoctorsToPatients() {

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Doctor doctor = new Doctor();
        doctor.setName("Dr. Pramod");
        doctor.setSpecialization("Cardiologist");
        doctor.setLicenseNo("LIC001");

        Patient patient1 = new Patient();
        patient1.setName("Shyam");
        patient1.setDob(LocalDate.of(2000, 3, 18));
        patient1.setBloodGroup("AB-");
        patient1.setPhone("8988433234");

        Patient patient2 = new Patient();
        patient2.setName("Riya");
        patient2.setDob(LocalDate.of(2004, 6, 24));
        patient2.setBloodGroup("B+");
        patient2.setPhone("7865688981");

        doctor.addPatient(patient1);
        doctor.addPatient(patient2);

        em.persist(doctor);

        em.getTransaction().commit();
        em.close();
    }

    public void removePatientFromDoctor(Long doctorId, Long patientId) {

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Doctor doctor = em.find(Doctor.class, doctorId);
        Patient patient = em.find(Patient.class, patientId);

        doctor.removePatient(patient);

        em.getTransaction().commit();
        em.close();
    }

    public void updateDoctorDetails(String newName,
                                    String newSpecialization,
                                    String newLicenseNo) {

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Doctor doctor = em.find(Doctor.class, 3);

        if (doctor != null) {

            // Update only if value is not null (optional safety)
            if (newName != null) {
                doctor.setName(newName);
            }

            if (newSpecialization != null) {
                doctor.setSpecialization(newSpecialization);
            }

            if (newLicenseNo != null) {
                doctor.setLicenseNo(newLicenseNo);
            }

            System.out.println("Doctor updated successfully!");

        } else {
            System.out.println("Doctor not found with ID: " + doctor.getId());
        }

        em.getTransaction().commit();  // Dirty checking happens here
        em.close();
    }
}