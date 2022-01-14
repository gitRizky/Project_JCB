package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class VisitPage {
	private WebDriver driver;

	public VisitPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content > div.row > div:nth-child(2) > form > div.panel.panel-info > div.panel-body > div > a")
	private WebElement editData;

	@FindBy(id = "btnSave2")
	private WebElement btnSave2;

	@FindBy(css = "#modal_form_merchant > div > div > div.modal-footer > button.btn.btn-danger")
	private WebElement btnCancel;

	@FindBy(css = "#content > div.row > div:nth-child(2) > form > div.panel.panel-inverse > div.panel-body > div > a")
	private WebElement addTID;

	@FindBy(css = "#form_edc > div.form-body > div:nth-child(1) > div > select")
	private WebElement bankName;

	@FindBy(css = "#form_edc > div.form-body > div:nth-child(2) > div > input")
	private WebElement mID;

	@FindBy(css = "#form_edc > div.form-body > div:nth-child(3) > div > input")
	private WebElement tID;

	@FindBy(css = "#form_edc > div.form-body > div:nth-child(4) > div > select")
	private WebElement acceptanceJCB;

	@FindBy(id = "file")
	private WebElement uploadPhoto;

	@FindBy(id = "btnSave")
	private WebElement btnSave;

	@FindBy(css = "#form_edc > div.form-body > div.form-group.row.has-error > div > span")
	private WebElement errorMesg;

	@FindBy(css = "#modal_form > div > div > div.modal-footer > button.btn.btn-danger")
	private WebElement cancelBank;

	@FindBy(css = "#collateral > div.panel-body > div > table > tbody > tr:nth-child(2) > td > select")
	private WebElement collSticker;

	@FindBy(css = "#collateral > div.panel-body > div > table > tbody > tr:nth-child(4) > td > select")
	private WebElement collStand;

	@FindBy(css = "#collateral > div.panel-body > div > table > tbody > tr:nth-child(6) > td > select")
	private WebElement collOpenCls;

	@FindBy(css = "#collateral > div.panel-body > div > table > tbody > tr:nth-child(8) > td > select")
	private WebElement collCard;

	@FindBy(css = "#amex > div.panel-body > div > table > tbody > tr:nth-child(2) > td > select")
	private WebElement op_sticker;

	@FindBy(css = "#amex > div.panel-body > div > table > tbody > tr:nth-child(4) > td > select")
	private WebElement op_stand_logo;

	@FindBy(css = "#amex > div.panel-body > div > table > tbody > tr:nth-child(6) > td > select")
	private WebElement op_open_close;

	@FindBy(css = "#gimmick > div.panel-body > table > tbody > tr:nth-child(1) > td:nth-child(3) > div > label")
	private WebElement cssCheckbox1;

	@FindBy(css = "#gimmick > div.panel-body > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > label")
	private WebElement cssCheckbox2;

	@FindBy(css = "#gimmick > div.panel-body > table > tbody > tr:nth-child(3) > td:nth-child(3) > div > label")
	private WebElement cssCheckbox3;

	@FindBy(css = "#gimmick > div.panel-body > table > tbody > tr:nth-child(4) > td:nth-child(3) > div > label")
	private WebElement cssCheckbox4;

	@FindBy(css = "#content > div.row > div:nth-child(2) > form > input.btn.btn-primary")
	private WebElement submit;

	@FindBy(css = "#content > div.row > div.col-lg-12.m-b-5 > div")
	private WebElement successMsg;

	@FindBy(css = "#content > div.row > div:nth-child(2) > form > div.panel.panel-inverse > div.panel-body > div.alert.alert-danger.fade.show")
	private WebElement finalFailMsg;

	public void editData() {
		this.editData.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSave2.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String successEdit() {
		return successMsg.getText();
	}

	public void addNewTID() {
		addTID.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void chooseBank() {
		bankName.click();
		_key(bankName);
	}

	public void fillMID(String string) {
		mID.sendKeys(string);

	}

	public void fillTID(String string) {
		tID.sendKeys(string);

	}

	public void confirmJCB() {
		acceptanceJCB.click();
		_key(acceptanceJCB);
	}

	public void chooseFile(String string) {
		uploadPhoto.sendKeys(string);
	}

	public void submitJCB() {
		btnSave.click();
	}

	public String getTxtError() {
		return errorMesg.getText();
	}

	public void cancelJCB() {
		cancelBank.click();
	}

	public void chooseColSticker() {
		collSticker.click();
		_key(collSticker);
	}

	public void chooseColStand() {
		collStand.click();
		_key(collStand);
	}

	public void chooseColOpenCls() {
		collOpenCls.click();
		_key(collOpenCls);
	}

	public void chooseColCard() {
		collCard.click();
		_key(collCard);
	}

	public void chooseASticker() {
		op_sticker.click();
		_key(op_sticker);
	}

	public void choooseALogo() {
		op_stand_logo.click();
		_key(op_stand_logo);
	}

	public void chooseAOpCls() {
		op_open_close.click();
		_key(op_open_close);
	}

	public void checkItems() {
		cssCheckbox1.click();
		cssCheckbox2.click();
		cssCheckbox3.click();
		cssCheckbox4.click();
		submit.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFailedTxt() {
		return finalFailMsg.getText();
	}

	private void _key(WebElement e) {
		e.sendKeys(Keys.DOWN);
		e.sendKeys(Keys.ENTER);
	}

}
