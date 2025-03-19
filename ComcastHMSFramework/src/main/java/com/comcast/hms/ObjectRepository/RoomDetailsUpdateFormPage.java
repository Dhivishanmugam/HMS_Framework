package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RoomDetailsUpdateFormPage {
	WebDriver driver;
	public RoomDetailsUpdateFormPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "mrdo")
	private WebElement doctorMorgInchargeDropDown;
	
	@FindBy(name = "erdo")
	private WebElement doctorEveInchargeDropDown;
	@FindBy(name = "submit")
	private WebElement submitBtn;
	public WebElement getDoctorMorgInchargeDropDown() {
		return doctorMorgInchargeDropDown;
	}
	public WebElement getDoctorEveInchargeDropDown() {
		return doctorEveInchargeDropDown;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void roomDetailsUpdateForm(int doc1,int doc2 ) {
		doctorMorgInchargeDropDown.click();
		Select sel=new Select(doctorMorgInchargeDropDown);
//		sel.selectByVisibleText(docMorgInchargeName);
		sel.selectByIndex(4);	
		doctorEveInchargeDropDown.click();
		Select sel1=new Select(doctorEveInchargeDropDown);
//		sel1.selectByVisibleText(docEveInchargeName);
		sel1.selectByIndex(3);
		doctorEveInchargeDropDown.getText();
		submitBtn.click();
	}
}
