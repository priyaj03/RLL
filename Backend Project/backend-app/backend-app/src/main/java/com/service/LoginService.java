package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	public String signIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());  //checking the record based on email id
		if(result.isPresent()) {
					Login ll = result.get();
					if(ll.getPassword().equals(login.getPassword())) {		
						return "Admin Login successfull";
						}					
					else {
						return "Incorrect password";
					}
		}else {
			return "This EmailId is not registered";
		}
	}
		
				
	public String signUp(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					return "This Email is already registered";
		}else {
				loginRepository.save(login);
				return "Account created successfully";
			}
			
		}	
	}
