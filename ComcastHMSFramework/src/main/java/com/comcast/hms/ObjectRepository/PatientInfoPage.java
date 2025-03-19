package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInfoPage {
WebDriver driver;
public PatientInfoPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(xpath = "//strong[text()='Patient Information']")
private WebElement patientInformationLink;

@FindBy(xpath = "//strong[text()='Patient Search']")
private WebElement patientSearchLink;

@FindBy(xpath="//strong[text()='Patient Information Edit and Delete']")
private WebElement patientInformationEditAndDeleteLink;

@FindBy(linkText = "Admit to Hospital")
private WebElement admitToHospLink;

@FindBy(linkText = "Make OPD Invoice")
private WebElement makeOpdInvoiceLink;

public WebElement getPatientInformationLink() {
	return patientInformationLink;
}
public WebElement getAdmitToHospLink() {
	return admitToHospLink;
}

public void patientInformationLink() {
	patientInformationLink.click();
}
public WebElement getMakeOpdInvoiceLink() {
	return makeOpdInvoiceLink;
}
public void navigateMakeOpdInvoiceLink() {
	makeOpdInvoiceLink.click();
}
public WebElement getPatientSearchLink() {
	return patientSearchLink;
}
public WebElement getPatientInformationEditAndDeleteLink() {
	return patientInformationEditAndDeleteLink;
}

public void navigatepatientSearchLink() {
	patientSearchLink.click();
}
	
	
	
}

