package com.ezio.springdatarest.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezio.springdatarest.domain.User;
import com.ezio.springdatarest.exception.EtAuthException;

@Service
@Transactional
public interface UserService {
	User valicateUser(String email, String password) throws EtAuthException;
	User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
