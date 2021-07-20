package com.ezio.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezio.springdatarest.domain.User;
import com.ezio.springdatarest.exception.EtAuthException;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
	User findByEmailAndPassword(String email, String password);
	Integer getCountByEmail(String email);
}
