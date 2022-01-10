package com.magang.jcb.glue;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.magang.jcb.configs.AutomationFrameworkConfigJava;
import com.magang.jcb.drivers.DriverSingleton;
import com.magang.jcb.utils.ConfigurationProperties;
import com.magang.jcb.utils.Constans;
import com.magang.jcb.utils.TestCases;
import com.magang.jcb.utils.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfigJava.class)
public class StepDefinition {
	private WebDriver driver;
	TestCases[] testCases;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");

	@Autowired
	ConfigurationProperties configProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(Constans.CHROME);
		driver = DriverSingleton.getDriver();
		testCases = TestCases.values();
		this.extentTest = report.startTest(testCases[Utility.testCount].getTestName());
		Utility.testCount++;
	}

	@After
	public void closeObjects() {
		report.endTest(this.extentTest);
		report.flush();

	}

}
