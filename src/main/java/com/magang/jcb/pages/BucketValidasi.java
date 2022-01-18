package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class BucketValidasi {
private WebDriver driver;
	
	public BucketValidasi() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a")
	private WebElement btnBucket;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(2) > a > span")
	private WebElement btnValidasi;
	
	@FindBy(id = "area")
	private WebElement FilterArea;
	
	@FindBy(id = "btn-filter")
	private WebElement btnFilter;
	
	@FindBy(css = "#data-worklist_filter > label > input")
	private WebElement txtSearch1;
	
	@FindBy(css = "#data-worklist > tbody > tr:nth-child(1) > td:nth-child(8) > a")
	private WebElement btnView1;
	
	//Validate
	@FindBy(css = "#content > div:nth-child(5) > div > button.btn.btn-primary")
	private WebElement btnValidate;
	
	@FindBy(id = "btnSave1")
	private WebElement btnSubmitValidate;
	
	@FindBy(xpath = "/html/body/div[5]/div[3]/div/div/div[3]/button[2]")
	private WebElement btnCancelValidate;
	
	@FindBy(css = "#data-worklist_filter > label > input")
	private WebElement txtSearch2;
	
	@FindBy(css = "#data-worklist > tbody > tr:nth-child(1) > td:nth-child(8) > a")
	private WebElement btnView2;
	
	//Return
	@FindBy(css = "#content > div:nth-child(5) > div > button.btn.btn-warning")
	private WebElement btnReturn;
	
	@FindBy(css = "#form_return > div:nth-child(4) > div > textarea")
	private WebElement txtNotesReturn;
	
	@FindBy(id = "btnSave2")
	private WebElement btnSubmitReturn;
	
	@FindBy(css = "#modal_form2 > div > div > div.modal-footer > button.btn.btn-danger.pull-left")
	private WebElement btnCancelReturn;
	
	@FindBy(css = "#data-worklist_filter > label > input")
	private WebElement txtSearch3;
	
	@FindBy(css = "#data-worklist > tbody > tr:nth-child(1) > td:nth-child(8) > a")
	private WebElement btnView3;
	
	//Reject
	@FindBy(css = "#content > div:nth-child(5) > div > button.btn.btn-danger")
	private WebElement btnReject;
	
	@FindBy(css = "#form_return > div:nth-child(4) > div > textarea")
	private WebElement txtNotesReject;
	
	@FindBy(id = "btnSave2")
	private WebElement btnSubmitReject;
	
	@FindBy(xpath = "//div[@id='modal_form2']//button[@type='button'][normalize-space()='Cancel']")
	private WebElement btnCancelReject;
	
	public void bucketValidasi() {
		btnBucket.click();
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnValidasi.click();
	}
	
	public void FilterArea() {
		FilterArea.click();
		FilterArea.sendKeys(Keys.DOWN);
	}
	
	public void BtnFilter() {
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnFilter.click();
	}
	
	
	public void Search(String merchant) {
		txtSearch1.click();
		txtSearch1.sendKeys(merchant);
		txtSearch1.sendKeys(Keys.ENTER);
	}
	
	public void View() {
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnView1.click();
	}
	
	//Validate
	public void Validate() {
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnValidate.click();
	}
	
	public void SubmitValidate() {
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnSubmitValidate.click();
	}
	
	public void CancelValidate() {
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnCancelValidate.click();
	}
	
	
	//Return
	public void Return() {
		btnReturn.click();
	}
	
	public void NotesReturn(String notesreturn) {
		txtNotesReturn.click();
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		txtNotesReturn.sendKeys(notesreturn);
	}
	
	public void SubmitReturn() {
		btnSubmitReturn.click();
	}
	
	public void CancelReturn() {
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnCancelReturn.click();
	}
	
	//Reject
	public void Reject() {
		btnReject.click();
	}
	
	public void NotesReject(String notesreject) {
		txtNotesReject.click();
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		txtNotesReject.sendKeys(notesreject);
	}
	
	public void SubmitReject() {
		btnSubmitReject.click();
	}
	
	public void CancelReject() {
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnCancelReject.click();
	}
}
