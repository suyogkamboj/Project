package com.project.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.sms.model.Admin;
import com.project.sms.model.Faculty;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {
	
	@Query("select a from Admin a where a.email=:email and a.password= :pwd")
	Admin findByAdminEmailAndAdminPassword(@Param("email")String email, @Param("pwd")String pwd);
	
	@Query("select a from Admin a where a.email=:email")
	Admin findAdminByEmail(@Param("email") String email);
}
