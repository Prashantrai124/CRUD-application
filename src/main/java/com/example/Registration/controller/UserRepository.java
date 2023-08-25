package com.example.Registration.controller;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {
  public User findByEmailAndPassword(String email,String password);
	@Transactional
	@Modifying
	@Query ("Update User u set u.firstName =?1 where u.id=?2 ")
 public Integer updateFirstNameById(String name, Integer id); 
	
	@Transactional
	@Modifying
	@Query ("Update User u set u.lastName =?1 where u.id=?2 ")
 public Integer updateLastNameById(String lastname, Integer id);

	 @Transactional
	 @Modifying
	 @Query("Update User u set u.email=?1 where u.id=?2")
	 public Integer updateEmailById(String email,Integer id);
}
