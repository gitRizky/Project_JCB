package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class BucketDistribusi {
	private WebDriver driver;

	public BucketDistribusi() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a")
	private WebElement btnSidebar;

	@FindBy(css = "a[href='https://dev.ptdika.com/jcb/new/distribusi']")
	private WebElement btnDistribusi;

	@FindBy(css = "#data-table-default > thead > tr > th.sorting_asc")
	private WebElement sortNo1;

	@FindBy(css = "#data-table-default > thead > tr > th:nth-child(2)")
	private WebElement sortNik;

	@FindBy(css = "#data-table-default > thead > tr > th:nth-child(3)")
	private WebElement sortName1;

	@FindBy(css = "#data-table-default > thead > tr > th:nth-child(4)")
	private WebElement sortTotaldata;

	@FindBy(css = "#data-table-default > thead > tr > th:nth-child(5)")
	private WebElement sortvisit;

	@FindBy(css = "#data-table-default > thead > tr > th:nth-child(6)")
	private WebElement sortUnvisit;

	@FindBy(css = "#content > ol > a")
	private WebElement assignment;

	@FindBy(id = "mybutton")
	private WebElement pilihData;

	@FindBy(id = "buttonUser")
	private WebElement pilihUser;

	@FindBy(css = "#modalUser > div > div > div.modal-body > div > table > tbody > tr:nth-child(1) > td:nth-child(5) > a")
	private WebElement formUser;

	@FindBy(css = "#distribusi > tbody > tr > td:nth-child(4) > input")
	private WebElement subProcess;

	@FindBy(css = "#data-table-default > tbody > tr:nth-child(1) > td.sorting_1")
	private WebElement btnAction;

	@FindBy(css = "#data-table-default > tbody > tr.child > td > ul > li > span.dtr-data > a.btn.btn-primary.btn-xs")
	private WebElement btnDetail;

	@FindBy(id = "mybutton")
	private WebElement pilihData2;

	@FindBy(css = "#divcheck_1 > div > label")
	private WebElement cekBox;

	@FindBy(id = "buttonUser")
	private WebElement btnUser2;

	@FindBy(css = "#modalUser > div > div > div.modal-body > div > table > tbody > tr:nth-child(1) > td:nth-child(5) > a")
	private WebElement formUser2;

	@FindBy(css = "#distribusi > tbody > tr > td:nth-child(6) > input")
	private WebElement subProcess2;

	@FindBy(css = "#data-table-default_filter > label > input")
	private WebElement sDistribusi;

	public void MenuDistribusi() {
		btnSidebar.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnDistribusi.click();
	}

	public void SortNo1() {
		sortNo1.click();
	}

	public void Nik() {
		sortNik.click();
	}

	public void SortName1() {
		sortName1.click();
	}

	public void SortTotalData() {
		sortTotaldata.click();
	}

	public void StatusVisit() {
		sortvisit.click();
	}

	public void StatusUnvisit() {
		sortUnvisit.click();
	}

	public void Assignment() {
		assignment.click();
	}

	public void PilihDataAssignment() {
		pilihData.click();
	}

	public void PilihUserAssignment() {
		pilihUser.click();
	}

	public void FormUserAssignment() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formUser.click();
	}

	public void SubmitAssignment() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subProcess.click();
	}

	public void ButtonAction() {
		btnAction.click();
	}

	public void ViewDetail() {
		btnDetail.click();
	}

	public void PilihDataDistribusi() {
		pilihData2.click();
	}

	public void CeklisBox() {
		cekBox.click();
	}

	public void PilihUserDistribusi() {
		btnUser2.click();
	}

	public void formUserDistribusi() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formUser2.click();
	}

	public void SubmitDistribusi() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subProcess2.click();
	}

	public void SearchDistribusi(String sdistribusi) {
		sDistribusi.sendKeys(sdistribusi);
	}

}