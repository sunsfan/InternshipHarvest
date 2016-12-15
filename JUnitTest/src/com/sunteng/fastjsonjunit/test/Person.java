package com.sunteng.fastjsonjunit.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Person {

	private int id;
	private String name;
	private String address;

}
