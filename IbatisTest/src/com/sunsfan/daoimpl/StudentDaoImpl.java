package com.sunsfan.daoimpl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import com.sunsfan.dao.IStudentDao;
import com.sunsfan.entity.Student;

public class StudentDaoImpl implements IStudentDao {
	// private SqlSessionFactory sqlSessionFactory =
	// SessionFactory.getInstance().getSqlSessionFactory();
	//
	// public void addStudent(Student student) {
	// SqlSession session = null;
	// try {
	// session = sqlSessionFactory.openSession();
	// session.insert("addStudent", student);
	// session.commit();
	// } finally {
	// session.close();
	// }
	// }
	//
	// public void deleteStudentById(int id) {
	// SqlSession session = null;
	// try {
	// session = sqlSessionFactory.openSession();
	// session.delete("deleteStudentById", id);
	// session.commit();
	// } finally {
	// session.close();
	// }
	// }
	//
	// public void updateStudent(Student student) {
	// SqlSession session = null;
	// try {
	// session = sqlSessionFactory.openSession();
	// session.update("updateStudent", student);
	// session.commit();
	// } finally {
	// session.close();
	// }
	// }
	//
	// @SuppressWarnings("unchecked")
	// public List<Student> selectAllStudent() {
	// List<Student> students = new ArrayList<Student>();
	// SqlSession session = null;
	// try {
	// session = sqlSessionFactory.openSession();
	// students = session.selectList("selectAllStudent");
	// } finally {
	// session.close();
	// }
	//
	// return students;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public List<Student> selectStudentByName(String name) {
	// List<Student> students = new ArrayList<Student>();
	// SqlSession session = null;
	// try {
	// session = sqlSessionFactory.openSession();
	// System.out.println(name);
	// students = session.selectList("selectStudentByName", "%" + name + "%");
	// session.commit();
	// } finally {
	// session.close();
	// }
	//
	// return students;
	// }
	//
	// public Student selectStudentById(int id) {
	// Student student = new Student();
	// SqlSession session = null;
	// try {
	// session = sqlSessionFactory.openSession();
	// student = (Student) session.selectOne("selectStudentById", id);
	// } finally {
	// session.close();
	// }
	// return student;
	// }
	private static SqlMapClient sqlMapClient = null;

	// 读取配置文件
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/sunsfan/entity/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean addStudent(Student student) {
		Object object = null;
		boolean flag = false;
		try {
			object = sqlMapClient.insert("addStudent", student);
			System.out.println("添加学生信息的返回值:" + object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteStudentById(int id) {
		boolean flag = false;
		Object object = null;
		try {
			object = sqlMapClient.delete("deleteStudentById", id);
			System.out.println("删除学生信息的返回值:" + object + ",这里返回的是影响的函数");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateStudent(Student student) {
		boolean flag = false;
		Object object = false;
		try {
			object = sqlMapClient.update("updateStudent", student);
			System.out.println("更新学生信息的返回值:" + object + ",返回影响的行数");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<Student> selectAllStudent() {
		List<Student> students = null;
		try {
			students = sqlMapClient.queryForList("selectAllStudent");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	@SuppressWarnings("unchecked")
	public List<Student> selectStudentByName(String name) {
		List<Student> students = null;
		try {
			students = sqlMapClient.queryForList("selectStudentByName", name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public Student selectStudentById(int id) {
		Student student = null;
		try {
			student = (Student) sqlMapClient.queryForObject("selectStudentById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
}
