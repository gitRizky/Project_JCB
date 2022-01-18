package com.magang.jcb.utils;

public enum TestCases {

	T1("input username and password"),
	T2("Menampilkan halaman dashboard"),
	T3("Input data user"),
	T4("Input data kota"),
	T5("Input data area"),
	T8("Modul Login Surveyor"),
	T9("Modul Report"),
	T10("Modul Worklist Part 1"),
	T11("Modul Worklist Part 2"),
	T12("Modul Completed");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
