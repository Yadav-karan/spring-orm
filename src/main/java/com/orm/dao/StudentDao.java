package com.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insertStudent(Student student) {
		Integer i = (Integer) hibernateTemplate.save(student);
		return i;
	}

	public Student getStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	public List<Student> getAllStudents(){
		List<Student> students = hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		hibernateTemplate.delete(student);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}
}
