package com.magang.jcb.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.magang.jcb.configs.AutomationFrameworkConfigJava;
import com.magang.jcb.drivers.DriverSingleton;
import com.magang.jcb.pages.LoginPages;
import com.magang.jcb.utils.ConfigurationProperties;
import com.magang.jcb.utils.Constans;
import com.magang.jcb.utils.TestCases;
import com.magang.jcb.utils.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfigJava.class)
public class StepDefinition {
	private WebDriver driver;
	private LoginPages login;
	TestCases[] testCases;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");

	@Autowired
	ConfigurationProperties configProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configProperties.getBrowser());
		driver = DriverSingleton.getDriver();
		login = new LoginPages();
		testCases = TestCases.values();
		this.extentTest = report.startTest(testCases[Utility.testCount].getTestName());
		Utility.testCount++;
	}
	
	//============================ Login Activity =======================================
	
	@Given("^Menampilkan form login")
	public void Menampilkan_form_login() {
		driver = DriverSingleton.getDriver();
		driver.get(Constans.URL);
		extentTest.log(LogStatus.PASS,"Navigating to " + Constans.URL);
	}
	
	@When("^Mengisi username")
	public void Mengisi_username() {
		login.inputUsername(configProperties.getUsername());
		extentTest.log(LogStatus.PASS,"Mengisi username");
	}
	
	@When("^Mengisi Password")
	public void Mengisi_Password() {
		login.inputPassword(configProperties.getPassword());
		extentTest.log(LogStatus.PASS,"Mengisi Password");
	}
	
	@When("^Login ke sistem JCB")
	public void Login_ke_sistem_JCB() {
		login.clickButtonLogin();
		extentTest.log(LogStatus.PASS,"Login ke sistem JCB");
	}
	
	@Then("^Muncul pesan selamat datang superadmin2")
	public void Muncul_pesan_selamat_datang_superadmin2() {
		assertEquals(configProperties.getMessageLogin(), login.getMessageText());
		extentTest.log(LogStatus.PASS,"Muncul pesan selamat datang superadmin2");
	}

//	@After
//	public void closeObjects() {
//		report.endTest(this.extentTest);
//		report.flush();
//
//	}

}
