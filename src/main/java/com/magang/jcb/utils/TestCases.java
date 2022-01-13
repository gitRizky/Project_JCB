package com.magang.jcb.utils;

public enum TestCases {

	T1("input username and password");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
