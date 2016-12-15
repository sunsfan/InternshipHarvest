package com.sunsfan.entity;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
	private int id;
	private String name;
	private Date birth;
	private int score;

	@Override
	public String toString() {
		return "id=" + id + "\t name=" + name + "\t birth=" + birth + "\t score=" + score + "\n";
	}
}
