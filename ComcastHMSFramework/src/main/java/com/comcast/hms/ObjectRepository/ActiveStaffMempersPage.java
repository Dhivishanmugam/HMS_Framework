package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveStaffMempersPage {
	WebDriver driver;
	public ActiveStaffMempersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//div[@class='col-md-4 col-xs-4 alert-success']")
	private WebElement eveDate;
	@FindBy(xpath = "//h3[text()='Active Staff Members']")
	private WebElement headName;
	public WebElement getHeadName() {
		return headName;
	}
	public WebElement getEveDate() {
		return eveDate;
	}
	public void setEveDate(WebElement eveDate) {
		this.eveDate = eveDate;
	}
}
