package com.sunsfan.test;

import java.sql.Date;
import java.util.List;

import com.sunsfan.daoimpl.StudentDaoImpl;
import com.sunsfan.entity.Student;

public class IbatisTest {
	public static void main(String[] args) {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

		// 测试插入
		Student addStudent = new Student();
		addStudent.setName("lux");
		addStudent.setBirth(Date.valueOf("2011-09-02"));
		addStudent.setScore(88);
		System.out.println(studentDaoImpl.addStudent(addStudent));

		addStudent.setName("jax");
		addStudent.setBirth(Date.valueOf("1990-09-02"));
		addStudent.setScore(98);
		System.out.println(studentDaoImpl.addStudent(addStudent));
		// 根据Id查询
		System.out.println(studentDaoImpl.selectStudentById(3));

		// 根据姓名查询
		List<Student> list = studentDaoImpl.selectStudentByName("u");
		for (Student student : list) {
			System.out.println(student);
		}

		// 查询所有
		List<Student> lists = studentDaoImpl.selectAllStudent();
		for (Student student : lists) {
			System.out.println(student);
		}

		// 更新信息
		Student updateStudent = new Student();
		updateStudent.setId(3);
		updateStudent.setName("thresh");
		updateStudent.setBirth(Date.valueOf("1990-09-07"));
		updateStudent.setScore(24);
		System.out.println(studentDaoImpl.updateStudent(updateStudent));

		// 删除数据
		Boolean b = studentDaoImpl.deleteStudentById(1);
		Boolean b1 = studentDaoImpl.deleteStudentById(2);
		System.out.println("删除结果:" + b);
		System.out.println("删除结果:" + b1);
	}

}
