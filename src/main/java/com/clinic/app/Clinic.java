package com.clinic.app;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Scope;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

@Component
//@Scope("prototype") // Ensures each patient gets a new instance
public class Clinic {

    private Queue<Patient> patientQueue;
    private Set<Patient> admittedPatients;
    private int dayCount;

    @Autowired
    public Clinic() {
        this.patientQueue = new LinkedList<>();
        this.admittedPatients = new HashSet<>();
        this.dayCount = 1;
    }

    public void admitPatient(Patient patient) {
        patientQueue.add(patient);
        System.out.println("Patient " + patient.getName() + " admitted.");
    }

    public void getSchedule() {
        System.out.println("Scheduling appointments for Day " + dayCount + "...");
        int patientsScheduled = 0;
        while (!patientQueue.isEmpty() && patientsScheduled < 3) {
            Patient patient = patientQueue.poll();
            patient.setAppointmentDay("Day " + dayCount);
            admittedPatients.add(patient);
            patientsScheduled++;
            System.out.println("Scheduled " + patient.getName() + " on " + patient.getAppointmentDay());
        }
        if (patientsScheduled > 0) {
            dayCount++;
        }
    }

    public void providedTreatment(Patient patient, String treatment) {
        if (admittedPatients.contains(patient)) {
            patient.setTreatment(treatment);
            System.out.println("Treatment provided to " + patient.getName() + ": " + treatment);
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }

    public void getPatientDetails(Patient patient) {
        if (admittedPatients.contains(patient)) {
            System.out.println("Patient Details: " + patient);
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }

    public void getAppointmentDetails(Patient patient) {
        if (admittedPatients.contains(patient)) {
            System.out.println("Appointment Details: " + patient.getName() + " is scheduled on " + patient.getAppointmentDay());
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }

    public void dischargePatient(Patient patient) {
        admittedPatients.remove(patient);
        System.out.println("Patient " + patient.getName() + " discharged.");
    }
}
