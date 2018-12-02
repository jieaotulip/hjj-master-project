package com.hjj.entityMapper;

public class Teacher {
	private int teacherId;
	private String teacherName;
	public Teacher() {
		super();
	}
	public Teacher(int teacherId, String teacherName) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String toString() {
		return "Teacher{teacherId:" + teacherId + "], [teacherName:" + teacherName + "}";
	}
}
