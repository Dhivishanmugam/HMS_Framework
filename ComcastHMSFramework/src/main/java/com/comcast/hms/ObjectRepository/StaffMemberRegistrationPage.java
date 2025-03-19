package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StaffMemberRegistrationPage {
WebDriver driver;
public StaffMemberRegistrationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(id="fname")
private WebElement firstNameTf;

@FindBy(id = "lname")
private WebElement lastNameTf;

@FindBy(xpath = "//input[@placeholder='Address']")
private WebElement addressTf;

@FindBy(name = "tel")
private WebElement contactNumTf;

@FindBy(id="eml")
private WebElement emailTf;

@FindBy(name = "gender")
private WebElement genderDropDown;

@FindBy(name = "smbdd")
private WebElement dateDropDown;

@FindBy(name = "typesm")
private WebElement staffTypeDropDown;

@FindBy(name="workt")
private WebElement workingTimeDropDown;

@FindBy(name = "submit")
private WebElement submitBtn;
public WebElement getFirstNameTf() {
	return firstNameTf;
}

public WebElement getLastNameTf() {
	return lastNameTf;
}

public WebElement getAddressTf() {
	return addressTf;
}

public WebElement getContactNumTf() {
	return contactNumTf;
}

public WebElement getEmailTf() {
	return emailTf;
}

public WebElement getGenderDropDown() {
	return genderDropDown;
}

public WebElement getDateDropDown() {
	return dateDropDown;
}

public WebElement getStaffTypeDropDown() {
	return staffTypeDropDown;
}

public WebElement getWorkingTimeDropDown() {
	return workingTimeDropDown;
}

public WebElement getSubmitBtn() {
	return submitBtn;
}
public void staffMemberRegistrationForm1(String firstName,String lastName,String address,String contactNum) {
	firstNameTf.sendKeys(firstName);
	lastNameTf.sendKeys(lastName);
	addressTf.sendKeys(address);
	contactNumTf.sendKeys(contactNum);
}
public void staffMemberRegistrationForm2(String genderType,String birthType,String staffType,String workingTime) throws InterruptedException {
	Actions act=new Actions(driver);
	act.scrollByAmount(0, 500).perform();
	Thread.sleep(2000);
	Select sel1 = new Select(genderDropDown);
	sel1.selectByVisibleText(genderType);
	dateDropDown.sendKeys(birthType);
	Select sel2 = new Select(staffTypeDropDown);
	sel2.selectByVisibleText(staffType);
	Select sel3 = new Select(workingTimeDropDown);
	sel3.selectByVisibleText(workingTime);
	submitBtn.click();
}
}
