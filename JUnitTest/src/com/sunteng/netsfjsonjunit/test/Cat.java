package com.sunteng.netsfjsonjunit.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Cat {
	private int id;
	private String name;
	private transient Animal animal;

}
