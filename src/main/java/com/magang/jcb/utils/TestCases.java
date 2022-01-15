package com.magang.jcb.utils;

public enum TestCases {

	T1("input username and password"), T8("Modul Report"), T9("Modul Worklist"), T10("Modul Completed");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
