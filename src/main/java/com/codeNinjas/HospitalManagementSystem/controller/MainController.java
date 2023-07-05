package com.codeNinjas.HospitalManagementSystem.controller;

import com.codeNinjas.HospitalManagementSystem.dto.PatientDTO;
import com.codeNinjas.HospitalManagementSystem.entity.Patient;
import com.codeNinjas.HospitalManagementSystem.exception.UserNotFoundException;
import com.codeNinjas.HospitalManagementSystem.repository.PatientRepository;
import com.codeNinjas.HospitalManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/api/user")
public class MainController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/saveUser")
    public PatientDTO saveUser(@RequestBody PatientDTO patientDTO){
        return patientService.savePatient(patientDTO);
    }

    @GetMapping("/getUser")
    public List<PatientDTO> getUser(){
        return patientService.getUserData();
    }
//
//    @PutMapping("/updateUser")
//    public UserDTO updateUser(@RequestBody UserDTO userDTO){
//        return userService.updateUser(userDTO);
//    }
//
//    @DeleteMapping("/DeleteUser")
//    public Boolean deleteUser(@RequestBody UserDTO userDTO){
//        return userService.deleteUser(userDTO);
//    }

    @GetMapping("/getUserByID/{userID}")
    public Patient getUserByID(@PathVariable int userID){
//        return modelMapper.map(userService.getUserByID(userID), User.class);
        return patientService.getUserByID(userID);
    }

    @PutMapping("/updateUserByID/{userID}")
    public Patient updateUserByID(@RequestBody Patient newPatient, @PathVariable int userID){
        return patientRepository.findById(userID)
                .map(user -> {
                    user.setFirst_name(newPatient.getFirst_name());
                    user.setLast_name(newPatient.getLast_name());
                    user.setAddress(newPatient.getAddress());
                    user.setBirthdate(newPatient.getBirthdate());
                    user.setGender(newPatient.getGender());
                    user.setEmail(newPatient.getEmail());
                    user.setContact(newPatient.getContact());
                    user.setPassword(newPatient.getPassword());
                    return patientService.updatePatient(user);
                }).orElseThrow(()->new UserNotFoundException(userID));
    }

    @DeleteMapping("/deleteUserByID/{userID}")
    public String deleteUserByID(@PathVariable int userID){
        if(!patientRepository.existsById(userID)){
            throw new UserNotFoundException(userID);
        }
        patientRepository.deleteById(userID);
        return "User with ID "+userID+ " has been deleted";
    }


    //    // CRUD operations using queries
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
