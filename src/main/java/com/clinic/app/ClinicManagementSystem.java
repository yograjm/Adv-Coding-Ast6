package com.clinic.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClinicManagementSystem {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ClinicConfig.class);

        // Retrieve the Clinic bean and Patient beans from the context
        Clinic clinic = context.getBean(Clinic.class);
        Patient p1 = context.getBean("alice", Patient.class);
        Patient p2 = context.getBean("bob", Patient.class);
        Patient p3 = context.getBean("charlie", Patient.class);
        Patient p4 = context.getBean("diana", Patient.class);
        Patient p5 = context.getBean("eva", Patient.class);

        // Admit patients
        clinic.admitPatient(p1);
        clinic.admitPatient(p2);
        clinic.admitPatient(p3);
        clinic.admitPatient(p4);
        clinic.admitPatient(p5);

        // Schedule appointments
        clinic.getSchedule(); // Should schedule first 3 patients
        clinic.getSchedule(); // Should schedule the remaining patients for the next day

        // Provide treatment
        clinic.providedTreatment(p1, "Paracetamol");
        clinic.providedTreatment(p2, "Ibuprofen");

        // Get patient details
        clinic.getPatientDetails(p1);
        clinic.getPatientDetails(p4);

        // Get appointment details
        clinic.getAppointmentDetails(p1);
        clinic.getAppointmentDetails(p5);

        // Discharge a patient
        clinic.dischargePatient(p1);
    }
}
