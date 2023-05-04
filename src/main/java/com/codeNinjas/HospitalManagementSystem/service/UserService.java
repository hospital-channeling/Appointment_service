package com.codeNinjas.HospitalManagementSystem.service;

import com.codeNinjas.HospitalManagementSystem.dto.UserDTO;
import com.codeNinjas.HospitalManagementSystem.entity.User;
import com.codeNinjas.HospitalManagementSystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    public UserDTO savePatient(UserDTO userDTO){
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getUserData(){
        List<User> userList = userRepository.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public Boolean deleteUser(UserDTO userDTO) {
        userRepository.delete(modelMapper.map(userDTO, User.class));
        return true;
    }


    // Methods for CRUD operations using queries
    public UserDTO getUserByID(String userID){
        User user = userRepository.getUserByID(Integer.parseInt(userID));
        return modelMapper.map(user, UserDTO.class);
    }
}
