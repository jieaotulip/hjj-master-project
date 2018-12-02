package com.hjj.db;

import java.util.List;

import com.hjj.entityMapper.Student;

public interface StudentDao {
	Student selectStudentById(int studentId);

	Student selectStudentByIdAndName(int studentId, String studentName);

	List<Student> selectStudentsById(int studentId);

	List<Student> selectStudentsByIdByResultMap(int studentId);

	boolean insertOneStudentA(Student student);

	boolean insertOneStudentB(Student student);

	boolean updateStudentAgeById(int studentId, int studentAge);

	boolean delStudentAgeById(int studentId);
	
	int batchInsertStudents(List<Student> studentList);
	
	List<Student> selectAllStudents();
}
