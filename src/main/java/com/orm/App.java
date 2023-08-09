package com.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.dao.StudentDao;
import com.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext cxt = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = cxt.getBean("stDao", StudentDao.class);
//		Student student = new Student(101, "karan", "Mumbai");
//		int insertStudent = studentDao.insertStudent(student);
//		System.out.println("Record inserted: " + insertStudent);
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("1.Add Student");
			System.out.println("2.Display All Student");
			System.out.println("3.Get Student By Id");
			System.out.println("4.Delete Student");
			System.out.println("5.Update Student");
			System.out.println("6.Exit");

			try {
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter Student Id:");
					int id = sc.nextInt();
					System.out.println("Enter Student Name:");
					String studentName = sc.next();
					System.out.println("Enter Student City:");
					String studentCity = sc.next();
					
					Student student = new Student(id,studentName,studentCity);
					
					int insertStudent = studentDao.insertStudent(student);
					System.out.println("Student Added: "+insertStudent);
					break;
					
				case 2:
					List<Student> allStudents = studentDao.getAllStudents();
					for(Student s: allStudents) {
						System.out.println("_______________________");
						System.out.println(s.getStudentId());
						System.out.println(s.getStudentName());
						System.out.println(s.getStudentCity());
					}
					System.out.println("**********************************");
					break;
					
				case 3:
					System.out.println("Enter Student Id:");
					int stId = sc.nextInt();
					Student stud = studentDao.getStudent(stId);
					System.out.println("_______________________");
					System.out.println(stud.getStudentId());
					System.out.println(stud.getStudentName());
					System.out.println(stud.getStudentCity());
					System.out.println("_______________________");
					break;
					
				case 4:
					System.out.println("Enter Student Id");
					int i = sc.nextInt();
					studentDao.deleteStudent(i);
					System.out.println("Student Deleted......");
					break;
				case 5:
					System.out.println("Enter Student Id:");
					int sid = sc.nextInt();
					System.out.println("Enter Student Name:");
					String sName = sc.next();
					System.out.println("Enter Student City:");
					String sCity = sc.next();
					Student s = new Student(sid,sName,sCity);
					studentDao.updateStudent(s);
					System.out.println("Student Updated....");
					break;
				case 6:
					sc.close();
					flag= false;
					System.out.println("Thank you for using me");
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Choice");
				e.printStackTrace();
			}
		}

	}
}
