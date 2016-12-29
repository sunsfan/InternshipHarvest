package com.sunsfan.annotation;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PersonDao implements PersonMapper {
	private SqlSessionFactory sessionFactory = SessionFactory.getInstance().getSqlSessionFactory();

	public Person selectById(Integer id) {
		Person person = new Person();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			PersonMapper personMapper = session.getMapper(PersonMapper.class);
			person = personMapper.selectById(id);
		} finally {
			session.close();
		}
		return person;
	}

	@SuppressWarnings("unchecked")
	public List<Person> selectAll() {
		List<Person> persons = new ArrayList<Person>();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			PersonMapper personMapper = session.getMapper(PersonMapper.class);
			persons = personMapper.selectAll();
		} finally {
			session.close();
		}

		return persons;
	}

	public void deletePerson(Person person) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			PersonMapper personMapper = session.getMapper(PersonMapper.class);
			personMapper.deletePerson(person);
			session.commit();
		} finally {
			session.close();
		}

	}

	public void insertPerson(Person person) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			PersonMapper personMapper = session.getMapper(PersonMapper.class);
			personMapper.insertPerson(person);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public void updatePerson(Person person) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			PersonMapper personMapper = session.getMapper(PersonMapper.class);
			personMapper.updatePerson(person);
			session.commit();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Person> selectPersonsByName(String name) {
		List<Person> persons = new ArrayList<Person>();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			PersonMapper personMapper = session.getMapper(PersonMapper.class);
			persons = personMapper.selectPersonsByName("%" + name + "%");
		} finally {
			session.close();
		}

		return persons;
	}

}
