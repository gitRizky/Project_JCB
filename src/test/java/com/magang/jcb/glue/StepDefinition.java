package com.magang.jcb.glue;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.magang.jcb.configs.AutomationFrameworkConfigJava;
import com.magang.jcb.drivers.DriverSingleton;
import com.magang.jcb.pages.CompletedPage;
import com.magang.jcb.pages.LoginPages;
import com.magang.jcb.pages.ReportPage;
import com.magang.jcb.pages.VisitPage;
import com.magang.jcb.pages.WorklistPage;
import com.magang.jcb.utils.ConfigurationProperties;
import com.magang.jcb.utils.Constans;
import com.magang.jcb.utils.GetScreenShot;
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
	private ReportPage reportPage;
	private CompletedPage completedPage;
	WorklistPage worklistPage;
	VisitPage visitPage;
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
		reportPage = new ReportPage();
		completedPage = new CompletedPage();
		worklistPage = new WorklistPage();
		visitPage = new VisitPage();
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
	
	//============================Report Activity=================================
	
	@When("^Menampilkan menu reporting")
	public void toReport() {
		reportPage.toReport();
		assertThat(reportPage.getTxtReport().toLowerCase(), containsString("report"));
		extentTest.log(LogStatus.PASS,"Menampilkan menu reporting");
	}
	
	@When("^Memilih dari drop down list")
	public void chooseLstItem() {
		reportPage.chooseKategori();;
		extentTest.log(LogStatus.PASS,"Memilih dari drop down list");
	}
	
	@When("^Mengisi start date")
	public void fillSDate() {
		reportPage.chooseSDate(configProperties.getStartDate());
		extentTest.log(LogStatus.PASS,"Mengisi start date");
	}
	
	@When("^Mengisi end date")
	public void fillEDate() {
		reportPage.chooseEDate(configProperties.getEndDate());
		extentTest.log(LogStatus.PASS,"Mengisi end date");
	}
	
	@When("^Unduh laporan")
	public void downloadReport() {
		reportPage.downloadReport();
		extentTest.log(LogStatus.PASS,"Unduh laporan");
	}
	
	@Then("^Unduh template laporan")
	public void downloadReport2() {
		reportPage.downloadReport2();
		extentTest.log(LogStatus.PASS,"Unduh template laporan");
		
	}
	
	//============================Worklist Activity=============================
	
	@When("^Menampilkan submenu")
	public void submenuWorklist() {
		reportPage.logout();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.inputUsername(configProperties.getSurveyor());
		login.inputPassword(configProperties.getPassword());
		login.clickButtonLogin();
		worklistPage.toWorklist();
		extentTest.log(LogStatus.PASS,"Menampilkan submenu");
	}
	
	@When("^Menampilkan Data Merchant yang belum divisit")
	public void subMenuNewData(){
		worklistPage.toNewData();
		extentTest.log(LogStatus.PASS,"Menampilkan Data Merchant yang belum divisit");
	}
	
	@When("^Memilih drop down list worklist")
	public void newDataDropDown(){
		worklistPage.chooseArea();
		extentTest.log(LogStatus.PASS,"Memilih drop down list worklist");
	}
	
	@When("^Menampilkan filter data")
	public void flterNewData(){
		worklistPage.clickFilter();
		extentTest.log(LogStatus.PASS,"Menampilkan filter data");
	}
	
	@When("^Mencari data newdata")
	public void findData(){
		worklistPage.searchItem("sate");
		extentTest.log(LogStatus.PASS,"Mencari data newdata");
	}
	
	@When("^Menampilkan form visit merchant")
	public void visitMerchant(){
		worklistPage.toVisitItem();
		extentTest.log(LogStatus.PASS,"Menampilkan form visit merchant");
	}
	
	@When("^Menampilkan form update data")
	public void updateData(){
		visitPage.editData();
		extentTest.log(LogStatus.PASS,"Menampilkan form update data");
	}
	
	@When("^Menyimpan perubahan data")
	public void saveUpdate(){
		assertThat(visitPage.successEdit().toLowerCase(), containsString("success"));
		extentTest.log(LogStatus.PASS,"Menyimpan perubahan data");
	}
	
	@When("^Menampilkan form add data bank")
	public void addTID(){
		visitPage.addNewTID();
		extentTest.log(LogStatus.PASS,"Menyimpan perubahan data bank");
	}
	
	@When("^Memilih dari drop down list")
	public void chooseBank(){
		visitPage.chooseBank();
		extentTest.log(LogStatus.PASS,"Memilih dari drop down list");
	}
	
	@When("^Mengisi MID")
	public void fillMID(){
		visitPage.fillMID("MK2221I");
		extentTest.log(LogStatus.PASS,"Mengisi MID");
	}
	
	@When("^Mengisi TID")
	public void fillTID(){
		visitPage.fillTID("CD5231X");
		extentTest.log(LogStatus.PASS,"Mengisi TID");
	}
	@When("^Memilih dari drop down list acceptance")
	public void chooseAccept(){
		visitPage.confirmJCB();
		extentTest.log(LogStatus.PASS,"Memilih dari drop down list acceptance");
	}
	@When("^Upload foto")
	public void uploadValid(){
		visitPage.chooseFile("C:\\Users\\Lenovo\\Downloads\\Background JC.jpg");
		extentTest.log(LogStatus.PASS,"Upload foto");
	}
	@When("^Menyimpan data")
	public void submitForm() throws Throwable{
		visitPage.submitJCB();
		String screenShotPath = GetScreenShot.capture(driver, "Gagal menampilkan hasil filter");
		extentTest.log(LogStatus.FAIL,"Menyimpan data" + extentTest.addScreenCapture(screenShotPath));
	}
	
	@Then("^Tidak menyimpan data")
	public void cancelForm(){
		visitPage.cancelJCB();
		extentTest.log(LogStatus.PASS,"Tidak menyimpan data");
	}
	
	//============================Completed Activity============================
	
	@When("^Menampilkan menu completed")
	public void toCompleted(){
		completedPage.toCompleted();
		assertThat(completedPage.getTxtDataCompleted(), containsString("completed"));
		extentTest.log(LogStatus.PASS,"Menampilkan menu completed");
	}
	
	@When("^Memilih dari drop down list complete")
	public void chooseItems() {
		completedPage.chooseArea();
		extentTest.log(LogStatus.PASS,"Memilih dari drop down list complete");
	}	
	
	@When("^Menampilkan hasil filter")
	public void filterData() throws Throwable {
		completedPage.testFilter();
		String screenShotPath = GetScreenShot.capture(driver, "Gagal menampilkan hasil filter");
		extentTest.log(LogStatus.FAIL,"Menampilkan hasil filter" + extentTest.addScreenCapture(screenShotPath));
	}	
	
	@When("^Mencari data")
	public void search() {
		completedPage.searchData(configProperties.getSearchKeyCompleted());
		assertThat(completedPage.getTxtCheck(), containsString("chigo"));
		extentTest.log(LogStatus.PASS,"Mencari data");
	}	
	
	@When("^Menampilkan foto laporan")
	public void viewPhoto() {
		completedPage.viewPhoto();
		assertThat(completedPage.getMyModalLabel(), containsString("view"));
		completedPage.close();
		extentTest.log(LogStatus.PASS,"Menampilkan foto laporan");
	}	
	
	@When("^Menampilkan Info EDC")
	public void viewEDC() {
		completedPage.viewEDC();
		assertThat(completedPage.getMyModalLabel(), containsString("view"));
		completedPage.close();
		extentTest.log(LogStatus.PASS,"Menampilkan Info EDC");
	}
	
	@Then("^Mengganti halaman aktif")
	public void changePage() {
		completedPage.clearSearch();
		completedPage.changePage();
		extentTest.log(LogStatus.PASS,"Mengganti halaman aktif");
		completedPage.logout();
	}

	@After
	public void closeObjects() {
		report.endTest(this.extentTest);
		report.flush();

	}

}
