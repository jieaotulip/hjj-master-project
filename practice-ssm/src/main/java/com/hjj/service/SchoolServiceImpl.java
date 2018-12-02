package com.hjj.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hjj.db.StudentDao;
import com.hjj.db.TeacherDao;
import com.hjj.entityMapper.Student;
import com.hjj.entityMapper.Teacher;

@Service
public class SchoolServiceImpl implements SchoolService {
	@Resource
	private StudentDao studentDao;
	@Resource
	private TeacherDao teacherDao;
	
	@Transactional
	@Override
	public void insertTeacherAndStudent(Teacher teacher, Student student) {
		studentDao.insertOneStudentA(student);
		teacherDao.insertTeacher(teacher);
	}

}
