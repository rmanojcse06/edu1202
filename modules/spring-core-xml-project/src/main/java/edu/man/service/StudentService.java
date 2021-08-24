package edu.man.service;

import java.util.List;
import java.util.Map;

import edu.man.pojo.Student;

public class StudentService {
	List<Student> students;
	Map<String,Student> studentByRoll;
	
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Map<String, Student> getStudentByRoll() {
		return studentByRoll;
	}

	public void setStudentByRoll(Map<String, Student> studentByRoll) {
		this.studentByRoll = studentByRoll;
	}
	
	
	
	
}
