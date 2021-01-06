package com.doctor.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doctor.model.Patient;
import com.doctor.service.PatientService;


@Controller
public class PatientController {
	
//	@Autowired
//	PatientService patientService;
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String m1(Patient p)
	{
		System.out.println("working properly");
//		if(patientService.insertPatient(p)>0)
//		{
//		   return "PatientDetails";
//		}
		return "PatientDetails";
	}
	@Transactional
	@RequestMapping(value = "/save_patientinsert",method = RequestMethod.POST)
	public String save_patientinsert(HttpServletRequest request,Model m)
	{
		System.out.println("---------"+request.getParameter("dob"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		/*Date dob = request.getParameter("dob");*/
		Date dob = null;
        try {
            dob =  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));         
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String bloodgroup = request.getParameter("bloodgroup");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));
        Date doa = null;
        try {
            doa =  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("doa"));         
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Patient p = new Patient();
        p.setName(name);
        p.setAge(age);
        p.setDob(dob);
        p.setBloodgroup(bloodgroup);
		p.setAddress(address);
		p.setEmail(email);
		p.setPhone(phone);
		p.setDoa(doa);
		hibernateTemplate.save(p);
		Patient details = new Patient();
		details = p;
		m.addAttribute("details",details);
		return "show_details";
	}
}
