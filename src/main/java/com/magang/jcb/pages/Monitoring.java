package com.magang.jcb.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class Monitoring {
private WebDriver driver;
	
	public Monitoring() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(6) > a > span")
	private WebElement btnMonitoring;
	
	@FindBy(css = "#data-table-default_length > label > select")
	private WebElement showEntries1;
	
	@FindBy(css = "#data-table-default > thead > tr > th:nth-child(1)")
	private WebElement NO;
	
	@FindBy(css = "#data-table-default > thead > tr > th:nth-child(2)")
	private WebElement Name;
	
	@FindBy(css = "#data-table-default > thead > tr > th:nth-child(3)")
	private WebElement TotalData;
	
	@FindBy(css = "#data-table-default > thead > tr > th:nth-child(4)")
	private WebElement TotalVisit;
	
	@FindBy(css = "#data-table-default_filter > label > input")
	private WebElement txtSearch1;
	
	@FindBy(css = "#data-table-default > tbody > tr:nth-child(1) > td:nth-child(4) > a > span")
	private WebElement btnDetail;
	
	@FindBy(id = "datepicker-autoClose4")
	private WebElement ClickDatePicker;
	
	@FindBy(css = "body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-bottom > div.datepicker-days > table > thead > tr:nth-child(2) > th.prev")
	private WebElement clickPrevDate;
	
	@FindBy(css = "body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-bottom > div.datepicker-days > table > tbody > tr:nth-child(1) > td:nth-child(4)")
	private WebElement clickdate;
	
	@FindBy(css = "#form_filter > div > div.col-md-1 > button")
	private WebElement btnFilterdate;
	
	@FindBy(css = "#data-table-default_length > label > select")
	private WebElement showEntries2;
	
	@FindBy(css = "#data-table-default_paginate > ul > li:nth-child(3) > a")
	private WebElement PageButton;
	
	@FindBy(css = "#data-table-default_filter > label > input")
	private WebElement txtSearch2;
	
	@FindBy(css = "#data-table-default > tbody > tr:nth-child(1) > td.sorting_1 > a.btn.btn-primary.btn-sm.m-b-5")
	private WebElement btnViewImage;
	
	@FindBy(css = "#modalImage > div > div > div.modal-header > button")
	private WebElement btnCloseViewImage;
	
	@FindBy(css = "#data-table-default > tbody > tr:nth-child(1) > td.sorting_1 > a.btn.btn-warning.btn-sm.m-b-5")
	private WebElement btnViewEDC1;
	
	@FindBy(css = "#modalImage > div > div > div.modal-header > button")
	private WebElement btnCloseViewEDC1;
	
	@FindBy(css = "#content > div.row > div:nth-child(2) > ul > li:nth-child(2) > a > span.d-sm-block.d-none")
	private WebElement MerchantIssue;
	
	@FindBy(css = "#data-table-default2_length > label > select")
	private WebElement showEntries3;
	
	@FindBy(css = "#data-table-default2_filter > label > input")
	private WebElement txtSearch3;
	
	@FindBy(css = "#data-table-default2 > tbody > tr:nth-child(1) > td.sorting_1 > a")
	private WebElement btnViewEDC2;
	
	@FindBy(css = "#modalImage > div > div > div.modal-header > button")
	private WebElement btnCloseViewEDC2;
	
	public void PageMonitoring() {
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnMonitoring.click();
	}
	
	public void showEntries1() {
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		showEntries1.click();
		showEntries1.sendKeys(Keys.DOWN);
		showEntries1.sendKeys(Keys.ENTER);
	}
	
	public void No() {
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		NO.click();
	}
	
	public void Name() {
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Name.click();
	}
	
	public void TotalData() {
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		TotalData.click();
	}
	
	public void TotalVisit() {
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		TotalVisit.click();
	}
	
	public void txtSearch1(String Name) {
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		txtSearch1.click();
		txtSearch1.sendKeys(Name);	
	}
	
	public void Detail() {
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnDetail.click();
	}
	
	public void Period() {
		ClickDatePicker.click();
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		clickPrevDate.click();
		clickdate.click();
	}
	
	public void Filter() {
		btnFilterdate.click();
	}
	
	public void showEntries2() {
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		showEntries2.click();
		showEntries2.sendKeys(Keys.DOWN);
		showEntries2.sendKeys(Keys.ENTER);
	}
	
	public void PageButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1000)");
		PageButton.click();		
	}
	
	public void txtSearch2(String nameMerchant) {
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("scroll(0,-1000)");
		txtSearch2.click();
		txtSearch2.sendKeys(nameMerchant);	
	}
	
	public void ViewImage() {
		btnViewImage.click();
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnCloseViewImage.click();
	}
	
	public void ViewEDC1() {
		btnViewEDC1.click();
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnCloseViewEDC1.click();
	}
	
	public void merchantIssue() {
		MerchantIssue.click();
	}
	
	public void showEntries3() {
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		showEntries3.click();
		showEntries3.sendKeys(Keys.DOWN);
		showEntries3.sendKeys(Keys.ENTER);
	}
	
	public void txtSearch3(String nameMerchant) {
		txtSearch3.click();
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		txtSearch3.sendKeys(nameMerchant);	
	}
	
	public void ViewEDC2() {
		btnViewEDC2.click();
		try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnCloseViewEDC2.click();
	}
	
}
