package com.hjj.test;

import java.util.List;

import org.junit.Test;

import com.hjj.db.StudentOperator;
import com.hjj.entityMapper.Student;

public class MyBatisTest {
	
	public static void main(String[] args) {
//		MyBatisTest.testSelectStudentById();
//		MyBatisTest.testSelectStudentByIdAndName();
//		MyBatisTest.testSelectStudentsById();
		testSelectStudentsByIdB();
	}
	
	public static void testSelectStudentById() {
		System.out.println(StudentOperator.getInstance().selectStudentById(1));
	}
	
	public static void testSelectStudentByIdAndName() {
		Student student = StudentOperator.getInstance().selectStudentByIdAndName(1, "Jack");
		if (student != null) {
			System.out.println(student);
		}
	}
	
	public static void testSelectStudentsById() {
		List<Student> list = StudentOperator.getInstance().selectStudentsById(0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void testSelectStudentsByIdB() {
		List<Student> list = StudentOperator.getInstance().selectStudentsByIdByResultMap(0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
}
