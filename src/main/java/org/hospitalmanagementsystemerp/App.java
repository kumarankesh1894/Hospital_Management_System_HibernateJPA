package org.hospitalmanagementsystemerp;

import org.hospitalmanagementsystemerp.services.AppointmentService;
import org.hospitalmanagementsystemerp.services.DepartmentService;
import org.hospitalmanagementsystemerp.services.DoctorService;
import org.hospitalmanagementsystemerp.services.PatientService;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        PatientService patient = new PatientService();
//        patient.createPatientWithRecord();

        DoctorService doctor = new DoctorService();
//        doctor.assignDoctorsToPatients();
        doctor.updateDoctorDetails("Dr. A","Neurologist","LIC002");

//        AppointmentService appointmentService = new AppointmentService();
//        appointmentService.createAppointmentWithPrescription();

//        DepartmentService departmentService = new DepartmentService();
//        departmentService.createDepartmentsWithDoctors();


    }
}
