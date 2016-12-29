package com.sunsfan.annotation;

import java.sql.Date;
import java.util.List;

public class IbatisTest {
	public static void main(String[] args) {
		PersonDao personDao = new PersonDao();
		// 插入
//		Person p = new Person();
//		p.setName("lux");
//		p.setBirthday(Date.valueOf("1990-01-01"));
//		p.setSex("female");
//		personDao.insertPerson(p);
//		Person p1 = new Person();
//		p1.setName("jax");
//		p1.setBirthday(Date.valueOf("1980-01-01"));
//		p1.setSex("male");
//		personDao.insertPerson(p1);
//		Person p2 = new Person();
//		p2.setName("thresh");
//		p2.setBirthday(Date.valueOf("1982-01-01"));
//		p2.setSex("male");
//		personDao.insertPerson(p2);
//		Person p3 = new Person();
//		p3.setName("gnar");
//		p3.setBirthday(Date.valueOf("1984-01-01"));
//		p3.setSex("male");
//		personDao.insertPerson(p3);
//		Person p4 = new Person();
//		p4.setName("sivir");
//		p4.setBirthday(Date.valueOf("1986-01-01"));
//		p4.setSex("female");
//		personDao.insertPerson(p4);
//		Person p5 = new Person();
//		p5.setName("azir");
//		p5.setBirthday(Date.valueOf("1988-01-01"));
//		p5.setSex("male");
//		personDao.insertPerson(p5);
		//删除
		//personDao.deletePerson(p1);
		Person result = personDao.selectById(4);
		System.out.println(result.getName());
		List<Person> l = personDao.selectPersonsByName("a");
		for(Person p : l){
			System.out.println(p.getName());
		}
	}
}
