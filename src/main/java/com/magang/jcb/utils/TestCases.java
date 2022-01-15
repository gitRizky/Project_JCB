package com.magang.jcb.utils;

public enum TestCases {

	T1("input username and password"), T8("Modul Report Part 1"), T9("Modul Report Part 2"), T10("Modul Worklist"),
	T11("Modul Completed");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
