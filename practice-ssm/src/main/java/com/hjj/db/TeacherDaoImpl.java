package com.hjj.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjj.entityMapper.Teacher;

@Repository
public class TeacherDaoImpl extends BaseDao implements TeacherDao {
	private static final String NAMESPACE = "com.hjj.entityMapper.Teacher.";

	@Override
	public List<Teacher> selectAllTeachers() {
		return getSqlSession().selectList(NAMESPACE + "selectAllTeachers");
	}

	@Override
	public int insertTeacher(String teacherName) {
		return getSqlSession().insert(NAMESPACE + "insertTeacher", teacherName);	
	}
	
	@Override
	public int insertTeacher(Teacher teacher) {
		return getSqlSession().insert(NAMESPACE + "insertTeacherA", teacher);
	}

}
