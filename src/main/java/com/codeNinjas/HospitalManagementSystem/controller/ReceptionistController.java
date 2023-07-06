package com.codeNinjas.HospitalManagementSystem.controller;

import com.codeNinjas.HospitalManagementSystem.entity.Receptionist;
import com.codeNinjas.HospitalManagementSystem.exception.ReceptionistNotFoundException;
import com.codeNinjas.HospitalManagementSystem.repository.ReceptionistRepository;
import com.codeNinjas.HospitalManagementSystem.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/api/receptionist")
public class ReceptionistController {

    @Autowired
    private ReceptionistService receptionistService;

    @Autowired
    private ReceptionistRepository receptionistRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/saveReceptionist")
    public Receptionist saveReceptionist(@RequestBody Receptionist receptionist){
        return receptionistService.saveReceptionist(receptionist);
    }

    @GetMapping("/getReceptionist")
    public List<Receptionist> getReceptionist(){
        return receptionistService.getReceptionistData();
    }

    @GetMapping("/getReceptionistByID/{ReceptionistID}")
    public Receptionist getReceptionistrByID(@PathVariable int ReceptionistID){
//        return modelMapper.map(userService.getUserByID(userID), User.class);
        return receptionistService.getReceptionistByID(ReceptionistID);
    }

    @PutMapping("/updateReceptionistByID/{receptionistID}")
    public Receptionist updateReceptionistByID(@RequestBody Receptionist newReceptionist, @PathVariable int receptionistID){
        return receptionistRepository.findById(receptionistID)
                .map(receptionist -> {
                    receptionist.setFirst_name(newReceptionist.getFirst_name());
                    receptionist.setLast_name(newReceptionist.getLast_name());
                    receptionist.setAddress(newReceptionist.getAddress());
                    receptionist.setBirthdate(newReceptionist.getBirthdate());
                    receptionist.setGender(newReceptionist.getGender());
                    receptionist.setService_start_date(newReceptionist.getService_start_date());
                    receptionist.setEmail(newReceptionist.getEmail());
                    receptionist.setContact(newReceptionist.getContact());
                    receptionist.setPassword(newReceptionist.getPassword());
                    return receptionistService.updateReceptionist(receptionist);
                }).orElseThrow(()->new ReceptionistNotFoundException(receptionistID));
    }

    @DeleteMapping("/deleteReceptionistByID/{userID}")
    public String deleteReceptionistByID(@PathVariable int receptionistID){
        if(!receptionistRepository.existsById(receptionistID)){
            throw new ReceptionistNotFoundException(receptionistID);
        }
        receptionistRepository.deleteById(receptionistID);
        return "Receptionist with ID "+receptionistID+ " has been deleted";
    }
}
