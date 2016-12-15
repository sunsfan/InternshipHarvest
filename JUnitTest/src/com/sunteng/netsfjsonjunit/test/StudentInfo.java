package com.sunteng.netsfjsonjunit.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class StudentInfo {
	private int id;
	private String stuName;
	private ClassInfoBean classInfo;
	
}
