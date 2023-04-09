package com.codeNinjas.HospitalManagementSystem.service;

import com.codeNinjas.HospitalManagementSystem.dto.PatientDTO;
import com.codeNinjas.HospitalManagementSystem.entity.Patient;
import com.codeNinjas.HospitalManagementSystem.repository.PatientRepo;
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
    private PatientRepo patientRepo;
    @Autowired
    private ModelMapper modelMapper;
    public PatientDTO savePatient(PatientDTO patientDTO){
        patientRepo.save(modelMapper.map(patientDTO, Patient.class));
        return patientDTO;
    }

    public List<PatientDTO> getPatientData(){
        List<Patient> patientList = patientRepo.findAll();
        return modelMapper.map(patientList, new TypeToken<List<PatientDTO>>(){}.getType());
    }

    public PatientDTO updatePatient(PatientDTO patientDTO) {
        patientRepo.save(modelMapper.map(patientDTO, Patient.class));
        return patientDTO;
    }

    public Boolean deletePatient(PatientDTO patientDTO) {
        patientRepo.delete(modelMapper.map(patientDTO, Patient.class));
        return true;
    }


    // Methods for CRUD operations using queries
    public PatientDTO getPatientByID(String patientID){
        Patient patient = patientRepo.getPatientByID(patientID);
        return modelMapper.map(patient, PatientDTO.class);
    }
}
