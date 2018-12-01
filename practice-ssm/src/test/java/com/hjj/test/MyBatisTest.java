package com.hjj.test;

import java.util.List;

import com.hjj.db.StudentDaoImpl;
import com.hjj.entityMapper.Student;

public class MyBatisTest {
	
	public static void main(String[] args) {
		MyBatisTest.testSelectStudentById();
//		MyBatisTest.testSelectStudentByIdAndName();
//		MyBatisTest.testSelectStudentsById();
//		testSelectStudentsByIdB();
//		testInsertOneStudentA();
//		testInsertOneStudentB();
//		testUpdateStudentAgeById();
//		testDelStudentAgeById();
	}
	
	public static void testSelectStudentById() {
		System.out.println(StudentDaoImpl.getInstance().selectStudentById(1));
	}
	
	public static void testSelectStudentByIdAndName() {
		Student student = StudentDaoImpl.getInstance().selectStudentByIdAndName(1, "Jack");
		if (student != null) {
			System.out.println(student);
		}
	}
	
	public static void testSelectStudentsById() {
		List<Student> list = StudentDaoImpl.getInstance().selectStudentsById(-1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void testSelectStudentsByIdB() {
		List<Student> list = StudentDaoImpl.getInstance().selectStudentsByIdByResultMap(0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void testInsertOneStudentA() {
		Student student = new Student(0, "hujunjieA", 27, "1232");
		boolean insertOneStudentA = StudentDaoImpl.getInstance().insertOneStudentA(student);
		System.out.println(insertOneStudentA);
	}
	
	public static void testInsertOneStudentB() {
		Student student = new Student(0, "hujunjieB", 28, "321");
		boolean insertOneStudentB = StudentDaoImpl.getInstance().insertOneStudentB(student);
		System.out.println(insertOneStudentB);
		
	}
	
	public static void testUpdateStudentAgeById() {
		boolean updateBoolean = StudentDaoImpl.getInstance().updateStudentAgeById(2, 25);
		System.out.println(updateBoolean);
	}
	
	public static void testDelStudentAgeById() {
		boolean delStudentAgeById = StudentDaoImpl.getInstance().delStudentAgeById(9);
		System.out.println(delStudentAgeById);
	}
	
	
}
