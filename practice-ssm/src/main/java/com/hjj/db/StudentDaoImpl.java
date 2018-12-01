package com.hjj.db;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hjj.entityMapper.Student;

@Repository
public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao {
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	private static final String NAMESPACE = "StudentMapper.";

	private static class LazyLoad {
		private static final StudentDaoImpl studentInstance = new StudentDaoImpl();
	}

	private StudentDaoImpl() {

	}

	public static StudentDaoImpl getInstance() {
		return LazyLoad.studentInstance;
	}
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public Student selectStudentById(int studentId) {
//		SqlSession ss = ssf.openSession();
//		Student student = null;
//		try {
//			student = ss.selectOne(NAMESPACE + "selectStudentById", studentId);
//		} finally {
//			ss.close();
//		}
//		return student;
		return getSqlSession().selectOne(NAMESPACE + "selectStudentById", studentId);
	}

	public Student selectStudentByIdAndName(int studentId, String studentName) {
//		SqlSession ss = ssf.openSession();
//		Student student = null;
//		try {
//			student = ss.selectOne(NAMESPACE + "selectStudentById", new Student(studentId, studentName, 0, null));
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ss.close();
//		}
		return getSqlSession().selectOne(NAMESPACE + "selectStudentById", new Student(studentId, studentName, 0, null));
	}

	public List<Student> selectStudentsById(int studentId) {
//		SqlSession ss = ssf.openSession();
//		List<Student> list = null;
//		try {
//			list = ss.selectList(NAMESPACE + "selectAll", studentId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ss.close();
//		}

		return getSqlSession().selectList(NAMESPACE + "selectAll", studentId);

	}

	public List<Student> selectStudentsByIdByResultMap(int studentId) {
//		SqlSession ss = ssf.openSession();
//		List<Student> list = null;
//		try {
//			list = ss.selectList(NAMESPACE + "selectAllByResultMap", studentId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ss.close();
//		}
		return getSqlSession().selectList(NAMESPACE + "selectAllByResultMap", studentId);
	}

	public boolean insertOneStudentA(Student student) {
//		SqlSession ss = ssf.openSession();
//		if (student != null) {
//			try {
//				int a = ss.insert(NAMESPACE + "insertOneStudentA", student);
//				ss.commit();
//				if (a > 0)
//					return true;
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				ss.close();
//			}
//		}
		int a = getSqlSession().insert(NAMESPACE + "insertOneStudentA", student);
		if (a > 0) return true;
		else return false;
	}

	public boolean insertOneStudentB(Student student) {
//		SqlSession ss = ssf.openSession();
//		if (student != null) {
//			try {
//				int a = ss.insert(NAMESPACE + "insertOneStudentB", student);
//				ss.commit();
//				if (a > 0)
//					return true;
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				ss.close();
//			}
//		}
		int a = getSqlSession().insert(NAMESPACE + "insertOneStudentB", student);
		if (a > 0) return true;
		else return false;
	}

	public boolean updateStudentAgeById(int studentId, int studentAge) {
//		SqlSession ss = ssf.openSession();
//		Student student = new Student();
//		try {
//			student.setStudentId(studentId);
////			student.setStudentName(studentName);
//			student.setStudentAge(studentAge);
//			int a = ss.update(NAMESPACE + "updateStudentAgeById", student);
//			ss.commit();
//			if (a > 0) {
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ss.close();
//		}
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentAge(studentAge);
		int result = getSqlSession().update(NAMESPACE + "updateStudentAgeById", student);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delStudentAgeById(int studentId) {
//		SqlSession ss = ssf.openSession();
//		try {
//			int delete = ss.delete(NAMESPACE + "deleteStudentById", studentId);
//			ss.commit();
//			if (delete > 0)
//				return true;
//		} catch (Exception e) {
//			ss.rollback();
//		} finally {
//			ss.close();
//		}
//		return false;
		int result = getSqlSession().delete(NAMESPACE + "deleteStudentById", studentId);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

}
