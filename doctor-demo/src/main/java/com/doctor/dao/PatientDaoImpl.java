package com.doctor.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.doctor.model.Patient;

@Component
@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	 SessionFactory sessionFactory;
	 JavaMailSender mailSender;

	public int insertPatient(Patient p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
