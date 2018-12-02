package com.hjj.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hjj.db.TeacherDao;
import com.hjj.entityMapper.Teacher;

public class TestTeacherDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestTeacherDao.class);
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		TeacherDao teacherDao = (TeacherDao) ac.getBean("teacherDaoImpl");
		Teacher teacher = new Teacher();
		teacher.setTeacherId(1);
		teacher.setTeacherName("hjj");
//		LOGGER.info(teacher.toString());
//		teacherDao.insertTeacher("hjj");
		teacherDao.insertTeacher(teacher);
		Teacher teacher1 = new Teacher();
		teacher1.setTeacherId(2);
		teacher1.setTeacherName("lmj");
//		LOGGER.info(teacher.toString());
//		teacherDao.insertTeacher("lmj");
		teacherDao.insertTeacher(teacher1);
		List<Teacher> list = teacherDao.selectAllTeachers();
		for (int i = 0; i < list.size(); i++) {
			LOGGER.info(list.get(i).toString());
		}
	}
}
