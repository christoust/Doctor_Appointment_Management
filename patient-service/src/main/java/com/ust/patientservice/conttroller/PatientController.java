package com.ust.patientservice.conttroller;


import com.ust.patientservice.model.Patient;
import com.ust.patientservice.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepo repo;
    @PostMapping("/reg")
    public Patient addDoctor(@RequestBody Patient patient)
    {
        return repo.save(patient);
    }
    @GetMapping("/all")
    public List<Patient> getAllDoctor()
    {
        return repo.findAll();
    }
    @GetMapping("/{id}")
    public Patient getDoctorById(@PathVariable Integer id)
    {
        return repo.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public Patient updateDoctor(@PathVariable Integer id,@RequestBody Patient patient)
    {
        Patient doc  = repo.findById(id).orElse(null);
        if(doc!=null)
        {
            Patient d = new Patient(id, patient.getPatient_Name());
            return repo.save(d);
        }
        return null;
    }
}
