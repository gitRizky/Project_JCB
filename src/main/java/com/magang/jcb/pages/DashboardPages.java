package com.magang.jcb.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class DashboardPages {
	private WebDriver driver;
	
	public DashboardPages() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a")
	private WebElement btnDashboard;
	
	public void gotoDashboardPage() {
		btnDashboard.click();
	}
	
	@FindBy(css = "#content > div:nth-child(3) > div:nth-child(1) > div > div.stats-info > h4")
	private WebElement txtMonthlyVisit;
	
	public String getMonthly() {
		return txtMonthlyVisit.getText();
	}
	
	@FindBy(css = "#content > div:nth-child(3) > div:nth-child(2) > div > div.stats-info > h4")
	private WebElement txtUnvisit;
	
	public String getUnvisit() {
		return txtUnvisit.getText();
	}
	
	@FindBy(css = "#content > div:nth-child(3) > div:nth-child(3) > div > div.stats-info > h4")
	private WebElement txtMonthlyPrice;
	
	public String getMonthlyPrice() {
		return txtMonthlyPrice.getText();
	}
	
	@FindBy(css = "#content > div:nth-child(3) > div:nth-child(4) > div > div.stats-info > h4")
	private WebElement txtTotalPrice;
	
	public String getTotalPrice() {
		return txtTotalPrice.getText();
	}
	
	@FindBy(css = "#content > div:nth-child(4) > div > div > div.panel-heading.ui-sortable-handle > h4")
	private WebElement txtSummaryByArea;
	
	public String getSummary() {
		return txtSummaryByArea.getText();
	}
	
	@FindBy(css = "#content > div:nth-child(4) > div > div > div.panel-body.p-t-0 > div > table > tbody > tr:nth-child(1) > td:nth-child(1)")
	private WebElement txtAreaD;
	
	@FindBy(css = "#content > div:nth-child(4) > div > div > div.panel-body.p-t-0 > div > table > tbody > tr:nth-child(1) > td:nth-child(2)")
	private WebElement txtMerchantD;
	
	@FindBy(css = "#content > div:nth-child(4) > div > div > div.panel-body.p-t-0 > div > table > tbody > tr:nth-child(1) > td:nth-child(3)")
	private WebElement txtVisitD;
	
	@FindBy(css = "#content > div:nth-child(4) > div > div > div.panel-body.p-t-0 > div > table > tbody > tr:nth-child(1) > td:nth-child(4)")
	private WebElement txtUnvisitD;
	
	@FindBy(css = "#content > div:nth-child(4) > div > div > div.panel-body.p-t-0 > div > table > tbody > tr:nth-child(1) > td:nth-child(5)")
	private WebElement txtTotalPriceD;
	
	@FindBy(css = "#content > div:nth-child(4) > div > div > div.panel-body.p-t-0 > div > table > tbody > tr")
	private List<WebElement> txtGrandTotal;
	
	public String getTxtAreaD() {
		return txtAreaD.getText();
	}
	
	public String getTxtMerchantD() {
		return txtMerchantD.getText();
	}
	
	public String getTxtVisitD() {
		return txtVisitD.getText();
	}
	
	public String getTxtUnvisitD() {
		return txtUnvisitD.getText();
	}
	
	public String getTxtTotalPriceD() {
		return txtTotalPriceD.getText();
	}
	
	public String getTxtGrandTotal() {
		return txtGrandTotal.get(txtGrandTotal.size()-2).getText();
	}
}