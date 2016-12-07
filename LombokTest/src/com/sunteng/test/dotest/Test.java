package com.sunteng.test.dotest;

import com.sunteng.test.bean.Person;

public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("sunteng");
		p.setSex(1);
		p.setAddress("beijing");
		System.out.println(p.toString());
		System.out.println(p.getName() + " " + (p.getSex() == 1 ? "male" : "female") + " " + p.getAddress());
	}
}
