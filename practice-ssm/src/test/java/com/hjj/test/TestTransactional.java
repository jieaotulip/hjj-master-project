package com.hjj.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hjj.entityMapper.Student;
import com.hjj.entityMapper.Teacher;
import com.hjj.service.SchoolService;

public class TestTransactional {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//		SchoolServiceImpl
		SchoolService schoolService = (SchoolService) ac.getBean("schoolServiceImpl");
		schoolService.insertTeacherAndStudent(new Teacher(1, null), new Student(1, "hjjtest", 20, "1234"));
		ac.close();
	}
}
