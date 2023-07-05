package com.codeNinjas.HospitalManagementSystem.service;

import com.codeNinjas.HospitalManagementSystem.dto.PatientDTO;
import com.codeNinjas.HospitalManagementSystem.entity.Patient;
import com.codeNinjas.HospitalManagementSystem.exception.UserNotFoundException;
import com.codeNinjas.HospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;
    public PatientDTO savePatient(PatientDTO patientDTO){
        patientRepository.save(modelMapper.map(patientDTO, Patient.class));
        return patientDTO;
    }

    public List<PatientDTO> getUserData(){
        List<Patient> patientList = patientRepository.findAll();
        return modelMapper.map(patientList, new TypeToken<List<PatientDTO>>(){}.getType());
    }

    public Patient updatePatient(Patient patient){
        patientRepository.save(modelMapper.map(patient, Patient.class));
        return patient;
    }

    public Patient getUserByID(int userID){
//        User user = userRepository.getUserByID(userID);
//        return modelMapper.map(user, UserDTO.class);
        return patientRepository.findById(userID).orElseThrow(()->new UserNotFoundException(userID));
    }
}
