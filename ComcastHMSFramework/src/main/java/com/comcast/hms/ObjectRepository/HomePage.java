package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(linkText = "Patient Info")
private WebElement patientInfoLink;
@FindBy(linkText = "Staff Info")
private WebElement staffInfoLink;
@FindBy(linkText = "Ptient Invoices")
private WebElement patientInvoiceLink;
@FindBy(linkText = "Room Information")
private WebElement roomInformationLink;
@FindBy(linkText = "Admited Patient Information")
private WebElement admitedPatientInfoLink;
public WebElement getPatientInfoLink() {
	return patientInfoLink;
}
public WebElement getStaffInfoLink() {
	return staffInfoLink;
}
public WebElement getPatientInvoiceLink() {
	return patientInvoiceLink;
}
public WebElement getRoomInformationLink() {
	return roomInformationLink;
}
public WebElement getAdmitedPatientInfoLink() {
	return admitedPatientInfoLink;
}
public void navigatePatientInfo() {
	patientInfoLink.click();
}
public void navigateStaffInfo() {
	staffInfoLink.click();
}
public void navigatePatientInvoice() {
	patientInvoiceLink.click();
}
public void navigateRoomInformationLink() {
	roomInformationLink.click();
}
public void navigateAdmitedPatientInfoLink() {
	admitedPatientInfoLink.click();
}
}
