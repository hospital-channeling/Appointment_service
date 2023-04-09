package com.codeNinjas.HospitalManagementSystem.controller;

import com.codeNinjas.HospitalManagementSystem.dto.PatientDTO;
import com.codeNinjas.HospitalManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/api/patient")
public class MainController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/getPatient")
    public List<PatientDTO> getPatient(){
        return patientService.getPatientData();
    }

    @PostMapping("/savePatient")
    public PatientDTO savePatient(@RequestBody PatientDTO patientDTO){
       return patientService.savePatient(patientDTO);
    }

    @PutMapping("/updatePatient")
    public PatientDTO updatePatient(@RequestBody PatientDTO patientDTO){
        return patientService.updatePatient(patientDTO);
    }

    @DeleteMapping("/DeletePatient")
    public Boolean deletePatient(@RequestBody PatientDTO patientDTO){
        return patientService.deletePatient(patientDTO);
    }

//    // CRUD operations using queries
//    @GetMapping("/getPatientByID/{patientID}")
//    public PatientDTO getPatientByID(@PathVariable String patientID){
//        return patientService.getPatientByID(patientID);
//    }

//    @PostMapping("/savePatientByID/{patientID}")
//    public PatientDTO savePatientByID(@PathVariable String patientID){
//        return patientService.savePatientByID();
//    }
//
//    @PutMapping("/updatePatientByID/{patientID}")
//    public PatientDTO updatePatientByID(@PathVariable String patientID){
//        return patientService.updatePatientByID();
//    }
//
//    @DeleteMapping("/deletePatientByID/{patientID}/{patientName}")
//    public Boolean deletePatientByIDAndName(@PathVariable String patientID,@PathVariable String patientName){
//        return patientService.deletePatientByIDAndName(patientID, patientName);
//    }
}
