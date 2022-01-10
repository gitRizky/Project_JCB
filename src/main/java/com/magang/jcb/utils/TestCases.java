package com.magang.jcb.utils;

public enum TestCases {

	T1("");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
