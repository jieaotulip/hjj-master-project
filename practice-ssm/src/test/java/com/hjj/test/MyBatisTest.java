package com.hjj.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hjj.db.StudentDao;
import com.hjj.db.StudentDaoImpl;
import com.hjj.entityMapper.Student;



public class MyBatisTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisTest.class);

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		StudentDao studentDao = (StudentDao) ac.getBean("studentDaoImpl");
		List<Student> studentList = null;
//		Student student0 = new Student();
//		student0.setStudentName("Smith1");
//		student0.setStudentAge(20);
//		student0.setStudentPhone("1234567");
//		Student student1 = new Student();
//		student1.setStudentName("ArmStrong11");
//		student1.setStudentAge(22);
//		student1.setStudentPhone("654321");
//		studentList = new ArrayList<>();
//		studentList.add(student0);
//		studentList.add(student1);
//		studentDao.batchInsertStudents(studentList);

		System.out.println("-----Display students------");
		studentList = studentDao.selectAllStudents();
		for (int i = 0, length = studentList.size(); i < length; i++)
			System.out.println(studentList.get(i));
//		Student student = studentDao.selectStudentById(1);
//		LOGGER.info(student.toString());

//		MyBatisTest.testSelectStudentById();
//		MyBatisTest.testSelectStudentByIdAndName();
//		MyBatisTest.testSelectStudentsById();
//		testSelectStudentsByIdB();
//		testInsertOneStudentA();
//		testInsertOneStudentB();
//		testUpdateStudentAgeById();
//		testDelStudentAgeById();
	}

	public static void testSelectStudentById() {
		StudentDaoImpl.getInstance().selectStudentById(1).toString();
//		studentDao.selectStudentById(1).toString();
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
