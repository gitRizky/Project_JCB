package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class DataMerchant {
private WebDriver driver;
	
	public DataMerchant() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
}
	@FindBy(css = "a[href='https://dev.ptdika.com/jcb/new/master_merchant']" )
	private WebElement dataMerchant;
	
	@FindBy(css = "#content > div.row > div.col-lg-12.ui-sortable > div > div.panel-body > div > table > thead > tr > th:nth-child(1) > a")
	private WebElement sortNo;
	
	@FindBy (css = "#content > div.row > div.col-lg-12.ui-sortable > div > div.panel-body > div > table > thead > tr > th:nth-child(3) > a")
	private WebElement sortBatch;
	
	@FindBy (css = "#content > div.row > div.col-lg-12.ui-sortable > div > div.panel-body > div > table > thead > tr > th:nth-child(4) > a")
	private WebElement sortMerchant;
	
	@FindBy (css = "#content > div.row > div.col-lg-12.ui-sortable > div > div.panel-body > div > table > thead > tr > th:nth-child(5) > a")
	private WebElement sortAddress;
	
	@FindBy (css = "#content > div.row > div.col-lg-12.ui-sortable > div > div.panel-body > div > table > thead > tr > th:nth-child(6) > a")
	private WebElement sortCategory;
	
	@FindBy (css = "#content > div.row > div.col-lg-12.ui-sortable > div > div.panel-body > div > table > thead > tr > th:nth-child(7) > a")
	private WebElement sortOfficer;
	
	@FindBy (css = "#content > div.row > div.col-lg-12.ui-sortable > div > div.panel-body > div > table > thead > tr > th:nth-child(8) > a")
	private WebElement sortStatus;
	
	@FindBy (css = "#content > div.row > div.col-lg-12.ui-sortable > div > div.panel-body > ul > li:nth-child(4) > a")
	private WebElement nextButton;
	
	@FindBy (css = "#content > div.row > div.col-lg-12.ui-sortable > div > div.panel-body > form > div > div > div > input")
	private WebElement searchMerchant;
	
	@FindBy(css = "#content > ol > a:nth-child(3)")
	private WebElement addNew;
	
	@FindBy(name = "batch") 
	private WebElement nameBatch;
	
	@FindBy (css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(2) > div > select")
	private WebElement nameKota;
	
	@FindBy (css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(3) > div > select")
	private WebElement nameArea;
	
	@FindBy (css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(4) > div > input")
	private WebElement nameMerchant;
	
	@FindBy (css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(5) > div > textarea")
	private WebElement nameAddress;
	
	@FindBy (css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(6) > div > input")
	private WebElement nameFloor;
	
	@FindBy (css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(7) > div > input")
	private WebElement nameCategory;
	
	@FindBy (css = "#modalAdd > div > div > div.modal-body > form > fieldset > div:nth-child(8) > div > select")
	private WebElement nameUsers;
	
	@FindBy (css = "#modalAdd > div > div > div.modal-body > form > fieldset > button.btn.btn-sm.btn-primary.m-r-5")
	private WebElement saveButton;
	
	
	public void dataMerchant() {
		dataMerchant.click();
	}
	
	public void sortNo() {
		sortNo.click();
		
	}
	
	public void sortBatch() {
		sortBatch.click();
		
	}
	
	public void sortMerchant() {
		sortMerchant.click();
	}
	
	public void sortAddress() {
		sortAddress.click();
	}
	
	public void sortCategory() {
		sortCategory.click();
	}
	
	public void sortOfficer() {
		sortOfficer.click();
	}
	
	public void sortStatus() {
		sortStatus.click();
	}
	
	public void nextButton() {
		nextButton.click();
	}
	
	public void addNew() {
		addNew.click();
	}
	
	public void inputBatch(String batch) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		nameBatch.sendKeys(batch);
	}
	
	public void nameKota( ) {
		nameKota.click();
		nameKota.sendKeys(Keys.DOWN);
		nameKota.sendKeys(Keys.ENTER);
	}
	
	public void nameArea() {
		nameArea.click();
		nameArea.sendKeys(Keys.DOWN);
		nameArea.sendKeys(Keys.DOWN);
		nameArea.sendKeys(Keys.ENTER);
	}
	
	public void inputMerchant(String merchant) {
		nameMerchant.sendKeys(merchant);
	}
	
	public void inputAddress(String address) {
		nameAddress.sendKeys(address);
	}
	
	public void inputFloor(String floor) {
		nameFloor.sendKeys(floor);
	}
	
	public void inputCategory(String category) {
		nameCategory.sendKeys(category);
	}
	
	public void nameUsers() {
		nameUsers.sendKeys(Keys.DOWN);
		nameUsers.sendKeys(Keys.DOWN);
		nameUsers.sendKeys(Keys.DOWN);
		nameUsers.sendKeys(Keys.ENTER);
	}

	public void saveBtn() {
		saveButton.click();
	}

	public void searchMerchant(String smerchant) {
		searchMerchant.sendKeys(smerchant);
	}

	
}