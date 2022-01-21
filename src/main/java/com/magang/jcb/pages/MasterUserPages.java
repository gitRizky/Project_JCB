package com.magang.jcb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.magang.jcb.drivers.DriverSingleton;

import io.github.sukgu.Shadow;

public class MasterUserPages {
	private WebDriver driver;
	private Select se;
	private Shadow shadow;
	
	public MasterUserPages() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3)")
	private WebElement dropdownMaster;
	
	public void gotoMaster() {
		dropdownMaster.click();
	}
	
	@FindBy(xpath = "//ul[@class=\"sub-menu\"]//li//a[contains(@href,'https://dev.ptdika.com/jcb/new/master/users')]")
	private WebElement gotoUser;
	
	public void gotoUser() {
		gotoUser.click();
	}
	
	@FindBy(css = "#data-table-default_paginate > ul > li:nth-child(8) > a")
	private WebElement btnPage;
	
	@FindBy(css = "#data-table-default > tbody > tr:nth-child(3) > td.sorting_1")
	private WebElement btnCollapse;
	
	@FindBy(css = "#data-table-default > tbody > tr.child > td > ul > li > span.dtr-data > a.btn.btn-primary.btn-xs")
	private WebElement btnEditUser;
	
	@FindBy(xpath = "//*[@id=\"modalEdit\"]/div/div/div[1]/button")
	private WebElement btnClose;
	
	public void editUser() {
		btnPage.click();
		btnCollapse.click();
		btnEditUser.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(btnClose));
		
	}
	
	public void editUserClose() {
		btnClose.click();
	}
	
	@FindBy(css = "#data-table-default > tbody > tr.child > td > ul > li > span.dtr-data > a.btn.btn-danger.btn-xs")
	private WebElement btnDelete;
	
	public void clickBtnDelete() {
		btnDelete.click();
		driver.switchTo().alert().accept();
	}
	
	@FindBy(css = "#content > div.row > div.col.col-lg-12 > div > a")
	private WebElement btnAddNew;
	
	public void clickBtnAdd() {
		btnAddNew.click();
	}
	
	@FindBy(name = "nik")
	private WebElement txtNik;
	
	public void inputNik(String nik) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(txtNik));
		txtNik.sendKeys(nik);
	}
	
	@FindBy(css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(2) > div > input")
	private WebElement txtName;
	
	public void inputName(String name) {
		txtName.sendKeys(name);
	}
	
	@FindBy(css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(3) > div > input")
	private WebElement txtUsername;
	
	public void inputUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	@FindBy(css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(4) > div > input")
	private WebElement txtPassword;
	
	public void inputPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void dropdwonPrivilege(String privilege) {
		se = new Select(driver.findElement(By.name("privilege")));
		se.selectByValue(privilege);
	}
	
	@FindBy(css = "#modalAdd > div > div > div.modal-body > form > fieldset > button.btn.btn-sm.btn-primary.m-r-5")
	private WebElement btnSave;
	
	public void clickBtnSave() {
		 btnSave.click();
	}
}
