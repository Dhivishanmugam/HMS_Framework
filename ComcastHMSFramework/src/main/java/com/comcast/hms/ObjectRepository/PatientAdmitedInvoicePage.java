package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientAdmitedInvoicePage {
	WebDriver driver;
	public PatientAdmitedInvoicePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@placeholder='Medicine Charge']")
	private WebElement medicineChargeTf;
	
	@FindBy(xpath = "//input[@placeholder='Doctor Charge']")
	private WebElement doctorChargeTf;
	
	@FindBy(xpath = "//input[@placeholder='Count of days']")
	private WebElement CountOfDaysTf;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	public WebElement getMedicineChargeTf() {
		return medicineChargeTf;
	}

	public WebElement getDoctorChargeTf() {
		return doctorChargeTf;
	}

	public WebElement getCountOfDaysTf() {
		return CountOfDaysTf;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void PatientAdmittedInvoiceDetails(String medicineCharge,String doctorCharge,String countOfDays) {
		medicineChargeTf.sendKeys(medicineCharge);
		doctorChargeTf.sendKeys(doctorCharge);
		CountOfDaysTf.sendKeys(countOfDays);
		submitBtn.click();
		
	}
	
}
