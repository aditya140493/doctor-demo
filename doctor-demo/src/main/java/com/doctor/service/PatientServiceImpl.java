package com.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.doctor.dao.PatientDao;
import com.doctor.model.Patient;
@Service
@Component
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;

	public int insertPatient(Patient p) {
		// TODO Auto-generated method stub
		return patientDao.insertPatient(p);
	}

}
