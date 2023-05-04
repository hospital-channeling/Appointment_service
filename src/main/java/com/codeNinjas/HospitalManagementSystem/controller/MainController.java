package com.codeNinjas.HospitalManagementSystem.controller;

import com.codeNinjas.HospitalManagementSystem.dto.UserDTO;
import com.codeNinjas.HospitalManagementSystem.entity.User;
import com.codeNinjas.HospitalManagementSystem.exception.UserNotFoundException;
import com.codeNinjas.HospitalManagementSystem.repository.UserRepository;
import com.codeNinjas.HospitalManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/api/user")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.savePatient(userDTO);
    }

    @GetMapping("/getUser")
    public List<UserDTO> getUser(){
        return userService.getUserData();
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
    public User getUserByID(@PathVariable int userID){
        return userRepository.findById(userID).orElseThrow(()->new UserNotFoundException(userID));
    }

    @PutMapping("/updateUserByID/{userID}")
    public User updateUserByID(@RequestBody User newUser, @PathVariable int userID){
        return userRepository.findById(userID)
                .map(user -> {
                    user.setFirst_name(newUser.getFirst_name());
                    user.setLast_name(newUser.getLast_name());
                    user.setAddress(newUser.getAddress());
                    user.setBirthdate(newUser.getBirthdate());
                    user.setGender(newUser.getGender());
                    user.setEmail(newUser.getEmail());
                    user.setContact(newUser.getContact());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(userID));
    }

    @DeleteMapping("/deleteUserByID/{userID}")
    public String deleteUserByID(@PathVariable int userID){
        if(!userRepository.existsById(userID)){
            throw new UserNotFoundException(userID);
        }

        userRepository.deleteById(userID);
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
