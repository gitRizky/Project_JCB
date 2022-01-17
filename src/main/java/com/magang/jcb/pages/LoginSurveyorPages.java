package com.magang.jcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class LoginSurveyorPages {
	private WebDriver driver;
	
	public LoginSurveyorPages() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Logout']")
	private WebElement logout;
	
	public void logout() {
		this.logout.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FindBy(css = "#page-container > div > div.login-content > form > div:nth-child(1) > input")
	private WebElement txtUsernameS;
	
	@FindBy(css = "#page-container > div > div.login-content > form > div:nth-child(2) > input")
	private WebElement txtPasswordS;
	
	@FindBy(css = "#page-container > div > div.login-content > form > div.login-buttons > button")
	private WebElement btnLoginS;
	
	@FindBy(css = "#content > div > div > div > div.card-block > h4 > b")
	private WebElement txtMessageS;
	
	@FindBy(css = "#page-container > div > div.login-header > div.brand > b")
	private WebElement txtLogin;
	
	public String getTxtLogin() {
		return txtLogin.getText();
	}
	
	public void inputUsernameS(String username) {
		txtUsernameS.sendKeys(username);
	}
	
	public void inputPasswordS(String password) {
		txtPasswordS.sendKeys(password);
	}
	
	public void clickButtonLoginS() {
		btnLoginS.click();
	}
	
	public String getMessageTextS() {
		return txtMessageS.getText();
	}

}
