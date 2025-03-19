package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInvoiceHomePage {
	WebDriver driver;
	public PatientInvoiceHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//strong[text()='All Admited Patients Invoiceses']")
	private WebElement allAdmittedPatientmodule;
	public WebElement getAllAdmittedPatientmodule() {
		return allAdmittedPatientmodule;
	}
	public void navigateAllAdmittedPatientmodule() {
		allAdmittedPatientmodule.click();
	}
}
