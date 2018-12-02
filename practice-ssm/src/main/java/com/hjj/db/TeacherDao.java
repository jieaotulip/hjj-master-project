package com.hjj.db;

import java.util.List;
import com.hjj.entityMapper.Teacher;

public interface TeacherDao {
	List<Teacher> selectAllTeachers();

	int insertTeacher(String teacherName);
	
	int insertTeacher(Teacher teacher);
}
