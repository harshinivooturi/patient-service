package com.mt.patientservice.service;

import com.mt.patientservice.entity.Patient;
import com.mt.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    public Optional<Patient> getPatient(long id) {
        return patientRepository.findById(id);
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void updatePatient(Patient patient, long id) {
        Optional<Patient> optionalPatientEntity = patientRepository.findById(id);

        if(optionalPatientEntity.isPresent()) {

            Patient patientEntity = optionalPatientEntity.get();

            getPatientEntity(patient, patientEntity);

            patientRepository.save(patientEntity);
        }
    }

    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }

    private void getPatientEntity(Patient patient, Patient patientEntity) {
        patientEntity.setFirstName(patient.getFirstName());
        patientEntity.setLastName(patient.getLastName());
        patientEntity.setAddress(patient.getAddress());
        patientEntity.setCity(patient.getCity());
        patientEntity.setEmail(patient.getEmail());
        patientEntity.setPhoneNumber(patient.getPhoneNumber());
        patientEntity.setState(patient.getState());
        patientEntity.setZipCode(patient.getZipCode());
    }

}
