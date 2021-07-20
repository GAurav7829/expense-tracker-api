package com.ezio.springdatarest.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezio.springdatarest.domain.User;
import com.ezio.springdatarest.exception.EtAuthException;
import com.ezio.springdatarest.repository.UserRepository;


public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repository;
	
	@Override
	public User valicateUser(String email, String password) throws EtAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if(email!=null) {
			email = email.toLowerCase();
		}
		if(!pattern.matcher(email).matches()) {
			throw new EtAuthException("Invalid Email Format");
		}
		Integer count = repository.getCountByEmail(email);
		if(count>0) {
			throw new EtAuthException("Email Already Exist");
		}
		Integer userId = repository.create(firstName, lastName, email, password);
		return repository.findById(userId).get();
	}

}
