package com.project.sms.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.sms.model.Attendance;

@Repository
public interface AttendanceDAO extends JpaRepository<Attendance, Integer>{

//	@Query("select a from Attendance a where a.status = ?1 and a.date = ?2")
//	Attendance findByStatusAndDate(String status, String date);
	
	@Query("SELECT a FROM Attendance a WHERE a.date = ?1")
	Attendance findbyDate(Date date);
	
}
