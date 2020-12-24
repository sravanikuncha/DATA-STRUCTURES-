package com.main.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.test.bean.STUDENT;
import com.main.test.entity.StudentTable;
import com.main.test.service.Student_Service;

@RestController
@RequestMapping("/Test2Controller")
public class Test2Contoller {
	@Autowired
	Student_Service st;
	/*@RequestMapping("/TEST")
	public String test()
	{
		return "testmethod inside controller";
	}
	@GetMapping("/GetTest")
	public String gettest()
	{
		return "get test method inside controller with getmapping";
	}*/
	@PostMapping("/createStudent")
	public String createStudent(@RequestBody STUDENT stu)
	{
		System.out.println(stu.getName());
		st.createStudentService(stu);
		return "success";
	}
}
