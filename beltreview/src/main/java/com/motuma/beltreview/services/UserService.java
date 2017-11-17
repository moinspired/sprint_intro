package com.motuma.beltreview.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.motuma.beltreview.models.User;
import com.motuma.beltreview.repositories.RoleRepository;
import com.motuma.beltreview.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
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
    
    public void updateUserWithAdminRole(User user) {
    	user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
    	userRepository.save(user);
    	
    }
    public void  updateUse(User user) {
    	userRepository.save(user);
    }
 
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}


	public User getUser(long id) {
		return userRepository.findOne(id);
	}
}