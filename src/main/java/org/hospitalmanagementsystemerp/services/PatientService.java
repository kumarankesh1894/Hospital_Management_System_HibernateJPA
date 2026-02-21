package org.hospitalmanagementsystemerp.services;

import org.hospitalmanagementsystemerp.config.HibernateUtil;
import org.hospitalmanagementsystemerp.entity.*;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;

public class PatientService {

    public Long createPatientWithRecord() {

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        MedicalRecord record = new MedicalRecord();
        record.setRecordDate(LocalDate.now());
        record.setDiagnosis("Brain Tumer");
        record.setNotes("Rest 1 month");

        Patient patient = new Patient();
        patient.setName("Ashan");
        patient.setDob(LocalDate.of(2003, 1, 9));
        patient.setBloodGroup("A-");
        patient.setPhone("6284454948");
        patient.setMedicalRecord(record);

        em.persist(patient); // Cascade persists record

        em.getTransaction().commit();
        em.close();

        return patient.getId();
    }

    public void updateMedicalNotes(Long patientId) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Patient p = em.find(Patient.class, patientId);
        p.getMedicalRecord().setNotes("Updated: Follow-up required");

        em.getTransaction().commit(); // Dirty checking
        em.close();
    }

    public void deletePatient(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Patient p = em.find(Patient.class, id);
        em.remove(p); // Cascade delete

        em.getTransaction().commit();
        em.close();
    }
}