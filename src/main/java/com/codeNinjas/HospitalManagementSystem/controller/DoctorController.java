package com.codeNinjas.HospitalManagementSystem.controller;

import com.codeNinjas.HospitalManagementSystem.entity.Doctor;
import com.codeNinjas.HospitalManagementSystem.exception.DoctorNotFoundException;
import com.codeNinjas.HospitalManagementSystem.repository.DoctorRepository;
import com.codeNinjas.HospitalManagementSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/saveDoctor")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping("/getDoctor")
    public List<Doctor> getDoctor(){
        return doctorService.getDoctorData();
    }

    @GetMapping("/getDoctorByID/{doctorID}")
    public Doctor getUserByID(@PathVariable int doctorID){
        return doctorService.getDoctorByID(doctorID);
    }

    @PutMapping("/updateDoctorByID/{DoctorID}")
    public Doctor updateDoctorByID(@RequestBody Doctor newDoctor, @PathVariable int doctorID){
        return doctorRepository.findById(doctorID)
                .map(doctor -> {
                    doctor.setFirst_name(newDoctor.getFirst_name());
                    doctor.setLast_name(newDoctor.getLast_name());
                    doctor.setSpecialization(newDoctor.getSpecialization());
                    doctor.setService_start_date(newDoctor.getService_start_date());
                    doctor.setAvailable_days_of_week(newDoctor.getAvailable_days_of_week());
                    doctor.setAvailable_time(newDoctor.getAvailable_time());
                    doctor.setEmail(newDoctor.getEmail());
                    doctor.setContact(newDoctor.getContact());
                    doctor.setGender(newDoctor.getGender());
                    doctor.setPassword(newDoctor.getPassword());
                    return doctorService.updateDoctor(doctor);
                }).orElseThrow(()->new DoctorNotFoundException(doctorID));
    }

    @DeleteMapping("/deleteDoctorByID/{DoctorID}")
    public String deleteDoctorByID(@PathVariable int doctorID){
        if(!doctorRepository.existsById(doctorID)){
            throw new DoctorNotFoundException(doctorID);
        }
        doctorRepository.deleteById(doctorID);
        return "Doctor with ID "+doctorID+ " has been deleted";
    }
}
