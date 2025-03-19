package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PatientAdmitRegisterPage {
WebDriver driver;
public PatientAdmitRegisterPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(name = "pet_disea")
private WebElement diseaseTextField;
@FindBy(name="adm_rn")
private WebElement roomNoDropDown;
@FindBy(name = "submit")
private WebElement submitButton;

public WebElement getDiseaseTextField() {
	return diseaseTextField;
}
public WebElement getSelectRoomDropDown() {
	return roomNoDropDown;
}
public WebElement getSubmitButton() {
	return submitButton;
}

public void admitPatient(String diseaseName) {
	diseaseTextField.sendKeys(diseaseName);
}
}
