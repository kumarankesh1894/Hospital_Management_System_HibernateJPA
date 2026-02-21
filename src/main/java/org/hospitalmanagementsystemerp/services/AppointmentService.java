package org.hospitalmanagementsystemerp.services;

import org.hospitalmanagementsystemerp.config.HibernateUtil;
import org.hospitalmanagementsystemerp.entity.*;
import jakarta.persistence.EntityManager;
import java.time.*;

public class AppointmentService {

    public void createAppointmentWithPrescription() {

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Appointment appt = new Appointment();
        appt.setAppointDate(LocalDateTime.now());
        appt.setStatus("Process");
        appt.setReason("Cancer");

        Prescription prescription = new Prescription();
        prescription.setMedicines("ChemoTherapy");
        prescription.setDosage("once a week");
        prescription.setIssuedDate(LocalDate.now());
        prescription.setActive(true);

        appt.setPrescription(prescription);

        em.persist(appt);

        em.getTransaction().commit();
        em.close();
    }

    public void createAppointmentWithoutPrescription() {

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Appointment appt = new Appointment();
        appt.setAppointDate(LocalDateTime.now());
        appt.setStatus("SCHEDULED");
        appt.setReason("General Checkup");

        em.persist(appt); // prescription_id will be NULL

        em.getTransaction().commit();
        em.close();
    }
}