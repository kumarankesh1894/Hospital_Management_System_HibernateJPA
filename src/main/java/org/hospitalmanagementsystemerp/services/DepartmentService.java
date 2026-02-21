package org.hospitalmanagementsystemerp.services;

import org.hospitalmanagementsystemerp.config.HibernateUtil;
import org.hospitalmanagementsystemerp.entity.*;
import jakarta.persistence.EntityManager;

public class DepartmentService {

    public void createDepartmentsWithDoctors() {

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Department cardio = new Department();
        cardio.setName("Cardiology");
        cardio.setLocation("Block A");
        cardio.setHeadDoctorName("Dr. Mehta");

        Doctor d1 = new Doctor();
        d1.setName("Dr. A");
        d1.setSpecialization("Heart");
        d1.setLicenseNo("LIC003");

        cardio.addDoctor(d1); // Helper method

        em.persist(cardio);

        em.getTransaction().commit();
        em.close();
    }
}
