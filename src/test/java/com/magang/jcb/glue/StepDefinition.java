package com.magang.jcb.glue;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.magang.jcb.configs.AutomationFrameworkConfigJava;
import com.magang.jcb.drivers.DriverSingleton;
import com.magang.jcb.pages.BucketValidasi;
import com.magang.jcb.pages.CompletedPage;
import com.magang.jcb.pages.DashboardPages;
import com.magang.jcb.pages.DataMerchant;
import com.magang.jcb.pages.LoginPages;
import com.magang.jcb.pages.LoginSurveyorPages;
import com.magang.jcb.pages.MasterAreaPages;
import com.magang.jcb.pages.MasterKotaPages;
import com.magang.jcb.pages.MasterUserPages;
import com.magang.jcb.pages.Monitoring;
import com.magang.jcb.pages.ReportPage;
import com.magang.jcb.pages.VisitOtherPage;
import com.magang.jcb.pages.VisitPage;
import com.magang.jcb.pages.WorklistAddPage;
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
	private DashboardPages db;
	private MasterUserPages user;
	private MasterKotaPages kota;
	private MasterAreaPages area;
	private DataMerchant merchant;
	private BucketValidasi validasi;
	private Monitoring monitoring;
	private ReportPage reportPage;
	private LoginSurveyorPages ls;
	private CompletedPage completedPage;
	WorklistPage worklistPage;
	VisitPage visitPage;
	VisitOtherPage otherPage;
	WorklistAddPage addPage;
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
		db = new DashboardPages();
		user = new MasterUserPages();
		kota = new MasterKotaPages();
		area = new MasterAreaPages();
		merchant = new DataMerchant();
		validasi = new BucketValidasi();
		monitoring = new Monitoring();
		reportPage = new ReportPage();
		ls = new LoginSurveyorPages();
		completedPage = new CompletedPage();
		worklistPage = new WorklistPage();
		visitPage = new VisitPage();
		otherPage = new VisitOtherPage();
		addPage = new WorklistAddPage();
		testCases = TestCases.values();
		this.extentTest = report.startTest(testCases[Utility.testCount].getTestName());
		Utility.testCount++;
	}

	// ============================ Login Admin Activity=====================================

	@Given("^Menampilkan form login")
	public void Menampilkan_form_login() {
		driver = DriverSingleton.getDriver();
		driver.get(Constans.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constans.URL);
	}

	@When("^Mengisi username")
	public void Mengisi_username() {
		login.inputUsername(configProperties.getUsername());
		extentTest.log(LogStatus.PASS, "Mengisi username");
	}

	@When("^Mengisi Password")
	public void Mengisi_Password() {
		login.inputPassword(configProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Mengisi Password");
	}

	@When("^Login ke sistem JCB")
	public void Login_ke_sistem_JCB() {
		login.clickButtonLogin();
		extentTest.log(LogStatus.PASS, "Login ke sistem JCB");
	}

	@Then("^Muncul pesan selamat datang superadmin2")
	public void Muncul_pesan_selamat_datang_superadmin2() {
//		assertEquals(configProperties.getMessageLogin(), login.getMessageText());
		assertThat(login.getMessageText(), containsString(configProperties.getMessageLogin()));
		extentTest.log(LogStatus.PASS, "Muncul pesan selamat datang superadmin2");
	}

	// ============================ Dashboard Activity ============================
	@When("^Menuju halaman dashboard")
	public void Menuju_halaman_dashboard() {
		db.gotoDashboardPage();
		extentTest.log(LogStatus.PASS, "Menuju halaman dashboard");
	}

	@When("^Menampilkan jumlah monthly visit")
	public void Menampilkan_jumlah_monthly_visit() {
		assertEquals(configProperties.getM1(), db.getMonthly());
		extentTest.log(LogStatus.PASS, "Menampilkan jumlah monthly visit");
	}

	@When("^Menampilkan jumlah unvisit")
	public void Menampilkan_jumlah_unvisit() {
		assertEquals(configProperties.getM2(), db.getUnvisit());
		extentTest.log(LogStatus.PASS, "Menampilkan jumlah unvisit");
	}

	@When("^Menampilkan jumlah monthly price")
	public void Menampilkan_jumlah_monthly_price() {
		assertEquals(configProperties.getM3(), db.getMonthlyPrice());
		extentTest.log(LogStatus.PASS, "Menampilkan jumlah monthly price");
	}

	@When("^Menampilkan jumlah total price")
	public void Menampilkan_jumlah_total_price() {
		assertEquals(configProperties.getM4(), db.getTotalPrice());
		extentTest.log(LogStatus.PASS, "Menampilkan jumlah total price");
	}

	@When("^Menampilkan data table summary by area")
	public void Menampilkan_data_table_summary_by_area() {
		assertEquals(configProperties.getM5(), db.getSummary());
		extentTest.log(LogStatus.PASS, "Menampilkan data table summary by area");
	}
	
	@When("^Menampilkan data area dashboard")
	public void Menampilkan_data_area_dashboard() {
		assertEquals(configProperties.getArea(), db.getTxtAreaD());
		extentTest.log(LogStatus.PASS, "Menampilkan data area dashboard");
	}
	
	@When("^Menampilkan data jumlah merchant")
	public void Menampilkan_data_jumlah_merchant() {
		assertEquals(configProperties.getMerchant(), db.getTxtMerchantD());
		extentTest.log(LogStatus.PASS, "Menampilkan data jumlah merchant");
	}
	
	@When("^Menampilkan data jumlah visit")
	public void Menampilkan_data_jumlah_visit() {
		assertEquals(configProperties.getVisit(), db.getTxtVisitD());
		extentTest.log(LogStatus.PASS, "Menampilkan data jumlah visit");
	}
	
	@When("^Menampilkan data jumlah unvisit")
	public void Menampilkan_data_jumlah_unvisit() {
		assertEquals(configProperties.getUnvisit(), db.getTxtUnvisitD());
		extentTest.log(LogStatus.PASS, "Menampikan data jumlah unvisit");
	}
	
	@When("^Menampilkan data jumlah total price")
	public void Menampilkan_data_jumlah_total_price() {
		assertEquals(configProperties.getPrice(), db.getTxtTotalPriceD());
		extentTest.log(LogStatus.PASS, "Menampilkan data jumlah total price");
	}
	
	@Then("^Menampilkan grand total")
	public void Menampilkan_grand_total() {
		assertEquals(configProperties.getGrand(), db.getTxtGrandTotal());
		extentTest.log(LogStatus.PASS, "Menampilkan grand total");
	}

	// ============================ Master User Activity ==========================
	@When("^Menampilkan dropdown menu master")
	public void Menampilkan_dropdown_menu_master() {
		user.gotoMaster();
		extentTest.log(LogStatus.PASS, "Menampilkan dropdown menu master");
	}

	@When("^Menampilkan data table user")
	public void Menampilkan_data_table_user() {
		user.gotoUser();
		extentTest.log(LogStatus.PASS, "Menampilkan data table user");
	}
	
	@When("^Mengubah data user")
	public void Mengubah_data_user() {
		user.editUser();
		extentTest.log(LogStatus.PASS, "Mengubah data user");
	}
	
	@When("^Menghapus data user")
	public void Menghapus_data_user() {
		user.clickBtnDelete();
		extentTest.log(LogStatus.PASS, "Menghapus data user");
	}

	@When("^Menampilkan form tambah data user")
	public void Menampilkan_form_tambah_data_user() {
		user.clickBtnAdd();
		extentTest.log(LogStatus.PASS, "Menampilkan form tambah data user");
	}

	@When("^Mengisi NIK")
	public void Mengisi_NIK() {
		user.inputNik(configProperties.getNik());
		extentTest.log(LogStatus.PASS, "Mengisi NIK");
	}

	@When("^Mengisi nama")
	public void Mengisi_nama() {
		user.inputName(configProperties.getName());
		extentTest.log(LogStatus.PASS, "Mengisi nama");
	}

	@When("^Mengisi username user")
	public void UMengisi_username() {
		user.inputUsername(configProperties.getUsernameU());
		extentTest.log(LogStatus.PASS, "Mengisi username");
	}

	@When("^Mengisi password user")
	public void UMengisi_Password() {
		user.inputPassword(configProperties.getPasswordU());
		extentTest.log(LogStatus.PASS, "Mengisi Password");
	}

	@When("^Privilege")
	public void privilege() {
		user.dropdwonPrivilege(configProperties.getPrivilege());
		extentTest.log(LogStatus.PASS, "Privilege");
	}

	@Then("^Menambahkan data")
	public void Menambahkan_data() {
		user.clickBtnSave();
		extentTest.log(LogStatus.PASS, "Menambahkan data");
	}

	// ============================ Master Kota Activity ==========================
	@When("^Menampilkan data kota")
	public void Menampilkan_data_kota() {
		kota.clickGotoKota();
		extentTest.log(LogStatus.PASS, "Menampilkan data kota");
	}
	
	@When("^Mengubah data kota")
	public void Mengubah_data_kota() {
		kota.inputEditKota(configProperties.getKota1());
		extentTest.log(LogStatus.PASS, "Mengubah data kota");
	}

	@When("^Menampilkan form data kota")
	public void Menampilkan_form_data_kota() {
		kota.clickBtnAddKota();
		extentTest.log(LogStatus.PASS, "Menampilkan form data kota");
	}

	@When("^Mengisi nama kota")
	public void Mengisi_nama_kota() {
		kota.inputKota(configProperties.getKota2());
		extentTest.log(LogStatus.PASS, "Mengisi nama kota");
	}

	@Then("^Menambahkan data kota")
	public void Menambahkan_data_kota() {
		kota.clickSaveKota();
		extentTest.log(LogStatus.PASS, "Menambahkan data");
	}

	// ============================ Master area activity ==========================
	@When("^Menampilkan data area")
	public void Menampilkan_data_area() {
		area.clickArea();
		extentTest.log(LogStatus.PASS, "Menampilkan data area");
	}
	
	@When("^Mengubah data area")
	public void Mengubah_data_area() {
		area.editArea(configProperties.getArea1());
		extentTest.log(LogStatus.PASS, "Mengubah data area");
	}

	@When("^Menampilkan form data area")
	public void Menampilkan_form_data_area() {
		area.clickBtnAdd();
		extentTest.log(LogStatus.PASS, "Menampilkan form data area");
	}

	@When("^Mengisi nama area")
	public void Mengisi_nama_area() {
		area.inputArea(configProperties.getArea2());
		extentTest.log(LogStatus.PASS, "Mengisi nama area");
	}

	@Then("^Menambahkan data area")
	public void Menambahkan_data_area() {
		area.clickSave();
		extentTest.log(LogStatus.PASS, "Menambahkan data");
	}
	
	//============================Data Merchant===================================
	
			@When("^Menampilkan form data merchant")
			public void formMerchant() {
				merchant.dataMerchant();
				extentTest.log(LogStatus.PASS,"Menampilkan menu merchant");
			}
			
			@When("^Mengurutkan baris angka pada kolom No.")
			public void SortirNo() {
				merchant.sortNo();
				extentTest.log(LogStatus.PASS,"Mengurutkan baris angka pada kolom No");
			}
			
			@When("^Mengurutkan baris pada kolom batch")
			public void SortirBatch() {
				merchant.sortBatch();
				extentTest.log(LogStatus.PASS,"Mengurutkan baris pada kolom batch");
			}
			
			@When("^Mengurutkan baris pada kolom nama merchant")
			public void SortirMerchant() {
				merchant.sortMerchant();
				extentTest.log(LogStatus.PASS,"Mengurutkan baris pada kolom nama merchant");
			}
			
			@When("^Mengurutkan baris pada kolom address")
			public void SortirAddress() {
				merchant.sortAddress();
				extentTest.log(LogStatus.PASS,"Mengurutkan baris pada kolom address");
			}
			
			@When("^Mengurutkan baris pada kolom category")
			public void SortirCategory() {
				merchant.sortCategory();
				extentTest.log(LogStatus.PASS,"Mengurutkan baris pada kolom category");		
			}
			
			@When("^Mengurutkan baris pada kolom officer")
			public void SortirOfficer() {
				merchant.sortOfficer();
				extentTest.log(LogStatus.PASS,"Mengurutkan baris pada kolom officer");		
			}
			
			@When("^Mengurutkan baris pada kolom status visit")
			public void SortirStatus() {
				merchant.sortStatus();
				extentTest.log(LogStatus.PASS,"Mengurutkan baris pada kolom status visit");		
			}
			
			@When("^Pindah ke tabel selanjutnya")
			public void NextPage() {
				merchant.nextButton();
				extentTest.log(LogStatus.PASS,"Pindah ke tabel selanjutnya");
			}
			
			@When("^Mencari nama merchant")
			public void SearchMerchant() {
				merchant.searchMerchant(configProperties.getSmerchant());
				extentTest.log(LogStatus.PASS,"Mencari nama merchant");
			}
			
			@When("^Menambahkan data merchant")
			public void addMerchant() {
				merchant.addNew();
				extentTest.log(LogStatus.PASS, "Menampilkan form new merchant");
			}
			
			@When("^Menginput batch")
			public void addBatch() {
				merchant.inputBatch(configProperties.getBatch());
				extentTest.log(LogStatus.PASS, "Menginput batch");
			}

			@When("^Memilih kota")
			public void addKota() {
				merchant.nameKota();
				extentTest.log(LogStatus.PASS, "Memilih kota");
			}
			
			@When("^Memilih area")
			public void addArea() {
				merchant.nameArea();
				extentTest.log(LogStatus.PASS, "Memilih area");
			}
			
			@When("^Menginput merchant name")
			public void addMerchantname() {
				merchant.inputMerchant(configProperties.getNameMerchant());
				extentTest.log(LogStatus.PASS, "Menginput merchant name");
			}
			
			@When("^Menginput address")
			public void addAddress() {
				merchant.inputAddress(configProperties.getNameAddress());
				extentTest.log(LogStatus.PASS, "Menginput address");
			}
			
			@When("^Menginput address by floor")
			public void addFloor() {
				merchant.inputFloor(configProperties.getNameFloor());
				extentTest.log(LogStatus.PASS, "Menginput address by floor");
			}
			
			@When("^Menginput category")
			public void addCategory() {
				merchant.inputCategory(configProperties.getNameCategory());
				extentTest.log(LogStatus.PASS, "Menginput category");
			}
			
			@When("^Memilih users")
			public void addUsers() {
				merchant.nameUsers();
				extentTest.log(LogStatus.PASS, "Memilih users");
			}
			
			@Then("^Menyimpan input data merchant")
			public void saveForm() {
				merchant.saveBtn();
				extentTest.log(LogStatus.PASS, "Menyimpan input data merchant");
			}

	//============================ Bucket Validasi ================================
	@When("^Menampilkan Data Validation")
	public void Menampilkan_Data_Validation() {
		validasi.bucketValidasi();
		extentTest.log(LogStatus.PASS,"Menampilkan Data Validation");
	}
		
	@When("^Drop down list yang berisi nama area")
	public void Drop_down_list_yang_berisi_nama_area() {
		validasi.FilterArea();
		extentTest.log(LogStatus.PASS,"Drop down list yang berisi nama area");
	}
		
	@When("^Menampilkan filter data berdasarkan nama area")
	public void Menampilkan_filter_data_berdasarkan_nama_area() {
		validasi.BtnFilter();
		extentTest.log(LogStatus.PASS,"Menampilkan filter data berdasarkan nama area");
	}
		
	@When("^Mencari Data merchant name")
	public void Mencari_Data_merchant_name() {
		validasi.Search(configProperties.getSearch1());
		extentTest.log(LogStatus.PASS,"Mencari Data merchant name");
	}
	
	@When("^Menampilkan Detail Visit")
	public void Menampilkan_Detail_Visit() {
		validasi.View();
		extentTest.log(LogStatus.PASS,"Menampilkan Detail Visit");
	}
		
	@When("^Menampilkan Pop up Validate form")
	public void Menampilkan_Pop_up_Validate_form() {
		validasi.Validate();
		extentTest.log(LogStatus.PASS,"Menampilkan Pop up Validate form");
	}

	@When("^Menyimpan data validate")
	public void Menyimpan_data_validate() {
		validasi.SubmitValidate();
		extentTest.log(LogStatus.PASS,"Menyimpan data validate");
	}
		
	@When("^Tidak menyimpan data validate")
	public void Tidak_menyimpan_data_validate() {
		validasi.CancelValidate();
		extentTest.log(LogStatus.PASS,"Tidak menyimpan data validate");
	}

		
	@When("^Menampilkan Pop up return form")
	public void Menampilkan_Pop_up_return_form() {
		validasi.Return();
		extentTest.log(LogStatus.PASS,"Menampilkan Pop up return form");
	}

	@When("^Mengisi Note return")
	public void Mengisi_Note_return() {
		validasi.NotesReturn(configProperties.getNotesreturn());
		extentTest.log(LogStatus.PASS,"Mengisi Note return");
	}
		
	@When("^Menyimpan data return")
	public void Menyimpan_data_return() {
		validasi.SubmitReturn();
		extentTest.log(LogStatus.PASS,"Menyimpan data return");
	}
		
	@When("^Tidak menyimpan data return")
	public void Tidak_menyimpan_data_return() {
		validasi.CancelReturn();
		extentTest.log(LogStatus.PASS,"Tidak menyimpan data return");
	}
		
		
	@When("^Menampilkan Pop up reject form")
	public void Menampilkan_Pop_up_rejectform() {
		validasi.Reject();
		extentTest.log(LogStatus.PASS,"Menampilkan Pop up reject form");
	}
		
	@When("^Mengisi Note reject")
	public void Mengisi_Note_reject() {
		validasi.NotesReject(configProperties.getNotesreject());
		extentTest.log(LogStatus.PASS,"Mengisi Note reject");
	}
		
	@When("^Menyimpan data reject")
	public void Menyimpan_data_reject() {
		validasi.SubmitReject();
		extentTest.log(LogStatus.PASS,"Menyimpan data reject");
	}
		
	@When("^Tidak menyimpan data reject")
	public void Tidak_menyimpan_data_reject() {
		validasi.CancelReject();
		extentTest.log(LogStatus.PASS,"Tidak menyimpan data reject");
	}
	
	//============================ Monitoring =====================================	
	@When("^Menampilkan Monitoring")
	public void Menampilkan_Monitoring() {
		monitoring.PageMonitoring();
		extentTest.log(LogStatus.PASS,"Menampilkan Monitoring");
	}
	
	@When("^Drop down list yang berisi angka")
	public void Drop_down_list_yang_berisi_angka() {
		monitoring.showEntries1();
		extentTest.log(LogStatus.PASS,"Drop down list yang berisi angka");
	}
	
	@When("^Mengurutkan baris angka pada kolom No")
	public void Mengurutkan_baris_angka_pada_kolom_No() {
		monitoring.No();
		extentTest.log(LogStatus.PASS,"Mengurutkan baris angka pada kolom No");
	}
	
	@When("^Mengurutkan baris pada kolom nama")
	public void Mengurutkan_baris_pada_kolom_nama() {
		monitoring.Name();
		extentTest.log(LogStatus.PASS,"Mengurutkan baris pada kolom nama");
	}
	
	@When("^Mengurutkan baris pada kolom total data")
	public void Mengurutkan_baris_pada_kolom_total_data() {
		monitoring.TotalData();
		extentTest.log(LogStatus.PASS,"Mengurutkan baris pada kolom total data");
	}
	
	@When("^Mengurutkan baris pada kolom total visit")
	public void Mengurutkan_baris_pada_kolom_total_visit() {
		monitoring.TotalVisit();
		extentTest.log(LogStatus.PASS,"Mengurutkan baris pada kolom total visit");
	}
	
	@When("^Mencari Data Nama")
	public void Mencari_Data_Nama() {
		monitoring.txtSearch1(configProperties.getSearch2());
		extentTest.log(LogStatus.PASS,"Mencari Data Nama");
	}
	
	@When("^Menampilkan Data Monitoring Visit")
	public void Menampilkan_Data_Monitoring_Visit() {
		monitoring.Detail();
		extentTest.log(LogStatus.PASS,"Menampilkan Data Monitoring Visit");
	}
	
	@When("^Mengisi tahun dan bulan")
	public void Mengisi_tahun_dan_bulan() {
		monitoring.Period();
		extentTest.log(LogStatus.PASS,"Mengisi tahun dan bulan");
	}
	
	@When("^Menampilkan filter data berdasarkan tahun dan bulan")
	public void Menampilkan_filter_data_berdasarkan_tahun_dan_bulan() {
		monitoring.Filter();
		extentTest.log(LogStatus.PASS,"Menampilkan filter data berdasarkan tahun dan bulan");
	}
	
	@When("^Drop down list yang berisi angka untuk tabel")
	public void Drop_down_list_yang_berisi_angka_untuk_tabel() {
		monitoring.showEntries2();
		extentTest.log(LogStatus.PASS,"Drop down list yang berisi angka untuk tabel");
	}
	
	@When("^Pindah ke halaman selanjutnya")
	public void Pindah_ke_halaman_selanjutnya() {
		monitoring.PageButton();
		extentTest.log(LogStatus.PASS,"Pindah ke halaman selanjutnya");
	}
	
	@When("^Mencari Data Master Merchant")
	public void Mencari_Data_Master_Merchant() {
		monitoring.txtSearch2(configProperties.getSearch3());
		extentTest.log(LogStatus.PASS,"Mencari Data Master Merchant");
	}
	
	@When("^Menampilkan View Image")
	public void Menampilkan_View_Image() {
		monitoring.ViewImage();
		extentTest.log(LogStatus.PASS,"Mencari Data Nama");
	}
	
	@When("^Menampilkan View EDC")
	public void Menampilkan_View_EDC() {
		monitoring.ViewEDC1();
		extentTest.log(LogStatus.PASS,"Menampilkan View EDC");
	}
	
	@When("^Menampilkan merchant issue sesuai dengan tahun dan bulan")
	public void Menampilkan_merchant_issue_sesuai_dengan_tahun_dan_bulan() {
		monitoring.merchantIssue();
		extentTest.log(LogStatus.PASS,"Menampilkan merchant issue sesuai dengan tahun dan bulan");
	}
	
	@When("^Drop down list yang berisi angka untuk tabel Merchant Issue")
	public void Drop_down_list_yang_berisi_angka_untuk_tabel_Merchant_Issue() {
		monitoring.showEntries3();
		extentTest.log(LogStatus.PASS,"Drop down list yang berisi angka untuk tabel Merchant Issue");
	}
	
	@When("^Mencari Data Merchant Issue")
	public void Mencari_Data_Merchant_Issue() {
		monitoring.txtSearch3(configProperties.getSearch4());
		extentTest.log(LogStatus.PASS,"Mencari Data Merchant Issue");
	}
	
	@Then("^Menampilkan View EDC Merchant Issue")
	public void Menampilkan_View_EDC_Merchant_Issue() {
		monitoring.ViewEDC2();
		extentTest.log(LogStatus.PASS,"Menampilkan View EDC Merchant Issue");
	}	
	
	// ============================Report Activity=================================
	
	@When("^Menampilkan menu reporting")
	public void toReport() {
		reportPage.toReport();
		assertThat(reportPage.getTxtReport().toLowerCase(), containsString("report"));
		extentTest.log(LogStatus.PASS, "Menampilkan menu reporting");
	}

	@When("^Memilih dari drop down list")
	public void chooseLstItem() {
		reportPage.chooseKategori();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list");
	}

	@When("^Mengisi start date")
	public void fillSDate() {
		reportPage.chooseSDate(configProperties.getStartDate());
		extentTest.log(LogStatus.PASS, "Mengisi start date");
	}

	@When("^Mengisi end date")
	public void fillEDate() {
		reportPage.chooseEDate(configProperties.getEndDate());
		extentTest.log(LogStatus.PASS, "Mengisi end date");
	}

	@When("^Unduh laporan")
	public void downloadReport() {
		reportPage.downloadReport();
		extentTest.log(LogStatus.PASS, "Unduh laporan");
	}

	@Then("^Unduh template laporan")
	public void downloadReport2() {
		reportPage.downloadReport2();
		extentTest.log(LogStatus.PASS, "Unduh template laporan");

	}

	//============================= Login Surveyor activity =====================
	@When("^logout akun administrator")
	public void logout_akun_administrator() {
		ls.logout();
		extentTest.log(LogStatus.PASS, "logout akun administrator");
	}
	
	@When("^Menampilkan form login surveyor")
	public void Menampilkan_form_login_surveyor() {
		assertEquals(configProperties.getTxtLogin(), ls.getTxtLogin());
		extentTest.log(LogStatus.PASS, "Menampilkan form login surveyor");
	}
	
	@When("^Mengisi username surveyor")
	public void Mengisi_username_surveyor() {
		ls.inputUsernameS(configProperties.getSurveyor());
		extentTest.log(LogStatus.PASS, "Mengisi username surveyor");
	}
	
	@When("^Mengisi password surveyor")
	public void Mengisi_password_surveyor() {
		ls.inputPasswordS(configProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Mengisi password surveyor");
	}
	
	@When("^Login ke sistem JCB surveyor")
	public void Login_ke_sistem_JCB_surveyor() {
		ls.clickButtonLoginS();
		extentTest.log(LogStatus.PASS, "Login ke sistem JCB surveyor");
	}
	
	@When("^Muncul pesan selamat datang user")
	public void Muncul_pesan_selamat_datang_user() {
		assertEquals(configProperties.getMessageSurveyor(), ls.getMessageTextS());
		extentTest.log(LogStatus.PASS, "Muncul pesan selamat datang user");
	}
	
	// ============================Worklist Activity=============================
	@When("^Menampilkan submenu")
	public void submenuWorklist() {
		worklistPage.toWorklist();
		extentTest.log(LogStatus.PASS, "Menampilkan submenu");
	}

	@When("^Menampilkan Data Merchant yang belum divisit")
	public void subMenuNewData() {
		worklistPage.toNewData();
		extentTest.log(LogStatus.PASS, "Menampilkan Data Merchant yang belum divisit");
	}

	@When("^Memilih drop down list worklist")
	public void newDataDropDown() {
		worklistPage.chooseArea();
		extentTest.log(LogStatus.PASS, "Memilih drop down list worklist");
	}

	@When("^Menampilkan filter data")
	public void flterNewData() {
		worklistPage.clickFilter();
		extentTest.log(LogStatus.PASS, "Menampilkan filter data");
	}

	@When("^Mencari data newdata")
	public void findData() {
		worklistPage.searchItem(configProperties.getSrcItemWorklist());
		extentTest.log(LogStatus.PASS, "Mencari data newdata");
	}

	@When("^Menampilkan form visit merchant")
	public void visitMerchant() {
		worklistPage.toVisitItem();
		extentTest.log(LogStatus.PASS, "Menampilkan form visit merchant");
	}

	@When("^Menampilkan data merchant")
	public void dataMerchantTable() {
		assertThat(visitPage.getPanelTitleDataMerchant().getText().toLowerCase(), containsString("data merchant"));
		extentTest.log(LogStatus.PASS, "Menampilkan data merchant");
	}

	@When("^Menampilkan form update data")
	public void updateData() {
		visitPage.editData();
		extentTest.log(LogStatus.PASS, "Menampilkan form update data");
	}

	@When("^Menampilkan data merchant yang akan diupdate")
	public void editViewDataMerchant() {
		assertThat(visitPage.getModalTitleUpdateData().getText().toLowerCase(), containsString("update"));
		extentTest.log(LogStatus.PASS, "Menampilkan data merchant yang akan diupdate");

	}

	@When("^Menyimpan perubahan data")
	public void saveUpdate() {
		visitPage.saveUpdateData();
		assertThat(visitPage.successEdit().toLowerCase(), containsString("success"));
		extentTest.log(LogStatus.PASS, "Menyimpan perubahan data");
	}

	@When("^Menampilkan data bank")
	public void tableViewDataBank() {
		assertThat(visitPage.getPanelTitleDataTerminal().getText().toLowerCase(), containsString("data terminal edc"));
		extentTest.log(LogStatus.PASS, "Menampilkan data bank");
	}

	@When("^Menampilkan form add data bank")
	public void addTID() {
		visitPage.addNewTID();
		extentTest.log(LogStatus.PASS, "Menyimpan perubahan data bank");
	}

	@When("^Memilih dari drop down list bank")
	public void chooseBank() {
		visitPage.chooseBank();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list bank");
	}

	@When("^Mengisi MID")
	public void fillMID() {
		visitPage.fillMID(configProperties.getMid());
		extentTest.log(LogStatus.PASS, "Mengisi MID");
	}

	@When("^Mengisi TID")
	public void fillTID() {
		visitPage.fillTID(configProperties.getTid());
		extentTest.log(LogStatus.PASS, "Mengisi TID");
	}

	@When("^Memilih dari drop down list acceptance")
	public void chooseAccept() {
		visitPage.confirmJCB();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list acceptance");
	}

	@When("^Upload foto")
	public void uploadValid() {
		visitPage.chooseFile(configProperties.getLocationphoto());
		extentTest.log(LogStatus.PASS, "Upload foto");
	}

	@When("^Menyimpan data")
	public void submitForm() throws Throwable {
		visitPage.submitJCB();
		String screenShotPath = GetScreenShot.capture(driver, "Gagal menyimpan data");
		extentTest.log(LogStatus.FAIL, "Menyimpan data" + extentTest.addScreenCapture(screenShotPath));
	}

	@When("^Tidak menyimpan data")
	public void cancelForm() {
		visitPage.cancelJCB();
		extentTest.log(LogStatus.PASS, "Tidak menyimpan data");
	}

	@When("^Menampilkan form Collateral JCB")
	public void tableViewCollateral() {
		assertThat(visitPage.getPanelTitleCollateral().getText().toLowerCase(), containsString("collateral"));
		extentTest.log(LogStatus.PASS, "Menampilkan form Collateral JCB");
	}

	@When("^Memilih dari drop down list JCB Sticker")
	public void chooseJCBSticker() {
		visitPage.chooseColSticker();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list JCB Sticker");
	}

	@When("^Memilih dari drop down list JCB Logo")
	public void chooseJCBLogo() {
		visitPage.chooseColStand();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list JCB Logo");
	}

	@When("^Memilih dari drop down list JCB Opn/Cls")
	public void chooseJCBOpnCls() {
		visitPage.chooseColOpenCls();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list JCB Opn/Cls");
	}

	@When("^Memilih dari drop down list JCB Name Card")
	public void chooseJCBNmCrd() {
		visitPage.chooseColCard();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list JCB Name Card");
	}

	@When("^Menampilkan form V/M/Amex/CUP")
	public void tableViewAmex() {
		assertThat(visitPage.getPanelTitleAmex().getText().toLowerCase(), containsString("amex"));
		extentTest.log(LogStatus.PASS, "Menampilkan form V/M/Amex/CUP");
	}

	@When("^Memilih dari drop down list Amex Sticker")
	public void chooseAmexSticker() {
		visitPage.chooseASticker();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list Amex Sticker");
	}

	@When("^Memilih dari drop down list Amex Logo")
	public void chooseAmexLogo() {
		visitPage.choooseALogo();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list Amex Logo");
	}

	@When("^Memilih dari drop down list Amex Opn/Cls")
	public void chooseAmexOpnCls() {
		visitPage.chooseAOpCls();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list Amex Opn/Cls");
	}

	@When("^Menampilkan form Gimmick")
	public void tableViewGimmick() {
		assertThat(visitPage.getPanelTitleGimmick().getText().toLowerCase(), containsString("gimmick"));
		extentTest.log(LogStatus.PASS, "Menampilkan form Gimmick");

	}

	@When("^Cek Checkbox Bill Holder")
	public void cekBillHolder() {
		visitPage.checkItems1();
		extentTest.log(LogStatus.PASS, "Cek Checkbox Bill Holder");
	}

	@When("^Cek Checkbox Sticker Sheet")
	public void cekStckSht() {
		visitPage.checkItems2();
		extentTest.log(LogStatus.PASS, "Cek Checkbox Sticker Sheet");
	}

	@When("^Cek Checkbox Pen")
	public void cekPen() {
		visitPage.checkItems3();
		extentTest.log(LogStatus.PASS, "Cek Checkbox Pen");
	}

	@When("^Cek Checkbox Reserved Sign")
	public void cekSign() {
		visitPage.checkItems4();
		extentTest.log(LogStatus.PASS, "Cek Checkbox Reserved Sign");
	}

	@When("^Simpan Data")
	public void submitVisited() throws Throwable {
		visitPage.submitVisited();
		String screenShotPath = GetScreenShot.capture(driver, "Gagal menyimpan visited data");
		extentTest.log(LogStatus.FAIL, "Simpan Data" + extentTest.addScreenCapture(screenShotPath));
	}

	@When("^Menampilkan form visit merchant other conditions")
	public void otherConditions() {
		worklistPage.toWorklist();
		worklistPage.toNewData();
		worklistPage.toOtherCondition();
		assertThat(otherPage.getPageHeader().toLowerCase(), containsString("visit merchant"));
		extentTest.log(LogStatus.PASS, "Menampilkan form visit merchant other conditions");

	}

	@When("^Menampilkan data merchant menu other conditions")
	public void conditionsMenu() {
		assertThat(otherPage.getPanelTitle1().toLowerCase(), containsString("data merchant"));
		extentTest.log(LogStatus.PASS, "Menampilkan data merchant menu other conditions");

	}

	@When("^Menampilkan form visit status")
	public void formVisitStatus() {
		assertThat(otherPage.getPanelTitle2().toLowerCase(), containsString("visit status"));
		extentTest.log(LogStatus.PASS, "Menampilkan form visit status");

	}

	@When("^Memilih dari drop down list Jika pilih Others akan muncul kolom tambahan")
	public void chooseStatus() {
		otherPage.chooseOptions(configProperties.getChooseoption());
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list Jika pilih Others akan muncul kolom tambahan");

	}

	@When("^Konfirmasi data other conditions")
	public void confimConditions() {
		otherPage.confirm();
		assertThat(worklistPage.getAlertSuccess().getText().toLowerCase(), containsString("success"));
		extentTest.log(LogStatus.PASS, "Konfirmasi data other conditions");

	}

	@Then("^Mengganti halaman aktif Worklist")
	public void pageWorklist() {
		worklistPage.toNextPrev();
		extentTest.log(LogStatus.PASS, "Mengganti halaman aktif Worklist");

	}

	@When("^Menampilkan form input new merchant")
	public void toAddNewMerchant() {
		worklistPage.toWorklist();
		worklistPage.toAddNewData();
		assertThat(addPage.getPanelTitle().getText().toLowerCase(), containsString("input new merchant"));
		extentTest.log(LogStatus.PASS, "Menampilkan form input new merchant");

	}

	@When("^Memilih dari drop down list kota new merchant")
	public void chooseNewCity() {
		addPage.chooseCity();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list kota new merchant");

	}

	@When("^Memilih dari drop down list area new merchant")
	public void chooseNewArea() {
		addPage.chooseArea();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list area new merchant");

	}

	@When("^Memilih dari drop down list batch new merchant")
	public void chooseNewBatch() {
		addPage.chooseBatch();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list batch new merchant");

	}

	@When("^Mengisi Name Merchant")
	public void fillNewName() {
		addPage.fillName(configProperties.getFillname());
		extentTest.log(LogStatus.PASS, "Mengisi Name Merchant");

	}

	@When("^Mengisi Address")
	public void fillNewAddress() {
		addPage.fillAddress(configProperties.getFilladdress());
		extentTest.log(LogStatus.PASS, "Mengisi Address");

	}

	@When("^Mengisi Address By Floor")
	public void fillFloorLoc() {
		addPage.fillAddrFloor(configProperties.getFillfloor());
		extentTest.log(LogStatus.PASS, "Mengisi Address By Floor");

	}

	@When("^Mengisi category")
	public void fillCategory() {
		addPage.fillCategory(configProperties.getFillcategory());
		extentTest.log(LogStatus.PASS, "Mengisi category");

	}

	@When("^Mengisi PIC")
	public void fillPIC() {
		addPage.fillPIC(configProperties.getFillpic());
		extentTest.log(LogStatus.PASS, "Mengisi PIC");

	}

	@When("^Mengisi No Telp PIC")
	public void fillPhoneNum() {
		addPage.fillPhone(configProperties.getFillphone());
		extentTest.log(LogStatus.PASS, "Mengisi No Telp PIC");

	}

	@When("^Memilih dari drop down list PIC Position dan pilih Others akan muncul kolom tambahan")
	public void chooseOtherPosition() {
		addPage.choosePosition(configProperties.getChooseposition());
		extentTest.log(LogStatus.PASS,
				"Memilih dari drop down list PIC Position dan pilih Others akan muncul kolom tambahan");

	}

	@When("^Memilih dari drop down list Merchant Acceptance dan pilih Others akan muncul kolom tambahan")
	public void chooseOtherAcceptance() {
		addPage.chooseAcceptCard(configProperties.getChooseaccp());
		extentTest.log(LogStatus.PASS,
				"Memilih dari drop down list Merchant Acceptance dan pilih Others akan muncul kolom tambahan");

	}

	@When("^Memilih dari drop down list Bussiness issue dan pilih Others akan muncul kolom tambahan")
	public void chooseOtherIssue() {
//		addPage.chooseIssue(configProperties.getChooseissue());
		extentTest.log(LogStatus.PASS,
				"Memilih dari drop down list Bussiness issue dan pilih Others akan muncul kolom tambahan");

	}

	@When("^Simpan New Merchant data")
	public void saveNewMerchant() {
		addPage.submitForm();
		assertThat(visitPage.getSuccessCreateMsg().getText().toLowerCase(), containsString("success"));
		extentTest.log(LogStatus.PASS, "Simpan New Merchant data");

	}

	@Then("^tidak Simpan New Merchant data")
	public void cancelCreateMerchant() {
		worklistPage.toWorklist();
		worklistPage.toAddNewData();
		addPage.fillPhone(configProperties.getFillphone());
		addPage.cancelForm();
		extentTest.log(LogStatus.PASS, "tidak Simpan New Merchant data");

	}

	// ============================Completed Activity============================

	@When("^Menampilkan menu completed")
	public void toCompleted() {
		completedPage.toCompleted();
		assertThat(completedPage.getTxtDataCompleted(), containsString("completed"));
		extentTest.log(LogStatus.PASS, "Menampilkan menu completed");
	}

	@When("^Memilih dari drop down list complete")
	public void chooseItems() {
		completedPage.chooseArea();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list complete");
	}

	@When("^Menampilkan hasil filter")
	public void filterData() throws Throwable {
		completedPage.testFilter();
		String screenShotPath = GetScreenShot.capture(driver, "Gagal menampilkan hasil filter");
		extentTest.log(LogStatus.FAIL, "Menampilkan hasil filter" + extentTest.addScreenCapture(screenShotPath));
	}

	@When("^Mencari data")
	public void search() {
		completedPage.searchData(configProperties.getSearchKeyCompleted());
		assertThat(completedPage.getTxtCheck(), containsString("chigo"));
		extentTest.log(LogStatus.PASS, "Mencari data");
	}

	@When("^Menampilkan foto laporan")
	public void viewPhoto() {
		completedPage.viewPhoto();
		assertThat(completedPage.getMyModalLabel(), containsString("view"));
		completedPage.close();
		extentTest.log(LogStatus.PASS, "Menampilkan foto laporan");
	}

	@When("^Menampilkan Info EDC")
	public void viewEDC() {
		completedPage.viewEDC();
		assertThat(completedPage.getMyModalLabel(), containsString("view"));
		completedPage.close();
		extentTest.log(LogStatus.PASS, "Menampilkan Info EDC");
	}

	@Then("^Mengganti halaman aktif")
	public void changePage() {
		completedPage.clearSearch();
		completedPage.changePage();
		extentTest.log(LogStatus.PASS, "Mengganti halaman aktif");
		completedPage.logout();
	}

	@After
	public void closeObjects() {
		report.endTest(this.extentTest);
		report.flush();

	}

}
