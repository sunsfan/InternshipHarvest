package com.sunteng.gsonjunit.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Person {

	private int id;
	private String name;
	private String address;

}
