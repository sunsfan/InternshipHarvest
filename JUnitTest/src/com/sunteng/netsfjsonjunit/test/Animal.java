package com.sunteng.netsfjsonjunit.test;

import java.util.List;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class Animal {
	private int id;
	private String name;
	private List catlist;
}
