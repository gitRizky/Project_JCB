package com.magang.jcb.utils;

public enum TestCases {

	T1("input username and password"),
	T2("Menampilkan halaman dashboard"),
	T3("Input data user"),
	T4("Input data kota"),
	T5("Input data area"),
	T6("Modul data merchant"),
	T7("Modul Bucket Validasi"),
	T8("Modul Monitoring"),
	T9("Modul Login Surveyor"),
	T10("Modul Report"),
	T11("Modul Worklist Part 1"),
	T12("Modul Worklist Part 2"),
	T13("Modul Completed");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
