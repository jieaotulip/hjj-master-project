package com.hjj.service;

import com.hjj.entityMapper.Student;
import com.hjj.entityMapper.Teacher;

public interface SchoolService {
	void insertTeacherAndStudent(Teacher teacher, Student student);
}
