package com.sunteng.gsonjunit.test;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class Cat {
	private int id;
	private String name;
	private transient Animal animal;
}
