package com.hjj.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hjj.entityMapper.Student;

public class StudentOperator extends BaseOperator {
	private static class LazyLoad{
		private static final StudentOperator studentInstance = new StudentOperator();
	}
	private StudentOperator() {

	}
	public static StudentOperator getInstance() {
		return LazyLoad.studentInstance;
	}

	public Student selectStudentById(int studentId) {
		SqlSession ss = ssf.openSession();
		Student student = null;
		try {
			student = ss.selectOne("com.hjj.entityMapper.selectStudentById", studentId);
		} finally {
			ss.close();
		}
		return student;
	}
	
	public Student selectStudentByIdAndName(int studentId, String studentName) {
		SqlSession ss = ssf.openSession();
		Student student = null;
		try {
			student = ss.selectOne("com.hjj.entityMapper.selectStudentById", new Student(studentId, studentName, 0, null));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return student;
	}
	
	public List<Student> selectStudentsById(int studentId){
		SqlSession ss = ssf.openSession();
		List<Student> list = null;
		try {
			list = ss.selectList("com.hjj.entityMapper.selectAll", studentId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}

		return list;
		
	}
	
	public List<Student> selectStudentsByIdByResultMap(int studentId){
		SqlSession ss = ssf.openSession();
		List<Student> list = null;
		try {
			list = ss.selectList("com.hjj.entityMapper.selectAllByResultMap", studentId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return list;
	}
	
}
