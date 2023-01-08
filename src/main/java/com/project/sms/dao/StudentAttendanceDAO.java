package com.project.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sms.model.StudentAttendance;

@Repository
public interface StudentAttendanceDAO extends JpaRepository<StudentAttendance, Integer> {

}
