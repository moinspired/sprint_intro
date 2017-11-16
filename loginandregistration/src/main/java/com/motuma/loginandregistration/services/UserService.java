package com.motuma.loginandregistration.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.motuma.loginandregistration.models.User;
import com.motuma.loginandregistration.repositories.RoleRepository;
import com.motuma.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    	this.userRepository = userRepository;
    	this.roleRepository = roleRepository;
    	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public void saveWithUserRole(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	user.setRoles(roleRepository.findByName("ROLE_USER"));
    	userRepository.save(user);
    }
    
    public void saveUserWithAdminRole(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
    	userRepository.save(user);
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
