package com.practice.services ;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.UserDTO;
import com.practice.entity.User;
import com.practice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private String encryptPassword(String password) {
        // Basic encryption using Base64 encoding (for educational purposes only)
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    private String decryptPassword(String encryptedPassword) {
        // Basic decryption using Base64 decoding (for educational purposes only)
        return new String(Base64.getDecoder().decode(encryptedPassword));
    }

    public User registerUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(encryptPassword(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        return userRepository.save(user);
    }

    public User updateUser(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(encryptPassword(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        return userRepository.save(user);
    }
}
