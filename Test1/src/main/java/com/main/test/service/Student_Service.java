package com.main.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.test.bean.STUDENT;
import com.main.test.entity.StudentTable;
import com.main.test.repository.StudentInterface;

@Service
public class Student_Service {
	
	@Autowired
	StudentInterface sinterface;
	
	@Autowired
	StudentTable stable;
	
   public void createStudentService(STUDENT st)
   {
	   System.out.println("inside service");
	   stable.setId(st.getId());
	   stable.setAddress(st.getAddress());
	   stable.setClassname(st.getClassname());
	   stable.setGender(st.getGender());
	   stable.setMailid(st.getMailid());
	   stable.setMobile_no(st.getMobile_no());
	   stable.setName(st.getName());
	   stable.setRoll_no(st.getRoll_no());
	   sinterface.save(stable);
   }
}
