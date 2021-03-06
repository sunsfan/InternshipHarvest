package com.sunsfan.dao;

import java.util.List;

import com.sunsfan.entity.Student;

public interface IStudentDao {
	/*
	 * 添加学生信息
	 */
	public boolean addStudent(Student student);

	/*
	 * 根据id删除学生信息
	 */
	public boolean deleteStudentById(int id);

	/*
	 * 更新学生信息
	 */
	public boolean updateStudent(Student student);

	/*
	 * 查询全部学生信息
	 */
	public List<Student> selectAllStudent();

	/*
	 * 根据学生姓名模糊查询学生信息
	 */
	public List<Student> selectStudentByName(String name);

	/*
	 * 根据学生id查询学生信息
	 */
	public Student selectStudentById(int id);

}
