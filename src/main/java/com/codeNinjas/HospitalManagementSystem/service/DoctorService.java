package com.codeNinjas.HospitalManagementSystem.service;

import com.codeNinjas.HospitalManagementSystem.entity.Doctor;
import com.codeNinjas.HospitalManagementSystem.exception.UserNotFoundException;
import com.codeNinjas.HospitalManagementSystem.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Doctor saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return doctor;
    }

    public List<Doctor> getDoctorData(){
        List<Doctor> doctorList = doctorRepository.findAll();
        return modelMapper.map(doctorList, new TypeToken<List<Doctor>>(){}.getType());
    }

    public Doctor updateDoctor(Doctor doctor){
        doctorRepository.save(modelMapper.map(doctor, Doctor.class));
        return doctor;
    }

    public Doctor getDoctorByID(int doctorID){
//        User user = userRepository.getUserByID(userID);
//        return modelMapper.map(user, UserDTO.class);
        return doctorRepository.findById(doctorID).orElseThrow(()->new UserNotFoundException(doctorID));
    }
}
