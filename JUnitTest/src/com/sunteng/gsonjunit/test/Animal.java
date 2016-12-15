package com.sunteng.gsonjunit.test;

import java.util.List;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class Animal {
	private String name;
	private List catlist;
}
