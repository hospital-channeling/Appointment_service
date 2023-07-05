package com.codeNinjas.HospitalManagementSystem.service;

import com.codeNinjas.HospitalManagementSystem.entity.Receptionist;
import com.codeNinjas.HospitalManagementSystem.exception.UserNotFoundException;
import com.codeNinjas.HospitalManagementSystem.repository.ReceptionistRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReceptionistService {

    @Autowired
    private ReceptionistRepository receptionistRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Receptionist saveReceptionist(Receptionist receptionist){
        receptionistRepository.save(modelMapper.map(receptionist, Receptionist.class));
        return receptionist;
    }

    public List<Receptionist> getReceptionistData(){
        List<Receptionist> receptionistList = receptionistRepository.findAll();
        return modelMapper.map(receptionistList, new TypeToken<List<Receptionist>>(){}.getType());
    }

    public Receptionist updateReceptionist(Receptionist receptionist){
        receptionistRepository.save(modelMapper.map(receptionist, Receptionist.class));
        return receptionist;
    }

    public Receptionist getReceptionistByID(int receptionistID){
//        User user = userRepository.getUserByID(userID);
//        return modelMapper.map(user, UserDTO.class);
        return receptionistRepository.findById(receptionistID).orElseThrow(()->new UserNotFoundException(receptionistID));
    }
}
