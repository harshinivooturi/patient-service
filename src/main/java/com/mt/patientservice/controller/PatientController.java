package com.mt.patientservice.controller;

import com.mt.patientservice.entity.Patient;
import com.mt.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patient/{id}")
    public Optional<Patient> getPatient(@PathVariable long id) {
        return patientService.getPatient(id);
    }

    @PostMapping("/patient")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @PutMapping("/patient/{id}")
    public void updatePatient(@RequestBody Patient patient, @PathVariable long id) {
        patientService.updatePatient(patient, id);
    }

    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable long id) {
        patientService.deletePatient(id);
    }
}
