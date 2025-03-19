package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInvoiceCreatePage {
	WebDriver driver;
	public PatientInvoiceCreatePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath= "//input[@placeholder='Age']")
	private WebElement ageTf;
	@FindBy(xpath= "//input[@placeholder='Medicine Charge']")
	private WebElement medicineChargeTf;
	@FindBy(xpath="//input[@placeholder='Doctor Charge']")
	private WebElement doctorChargeTf;
	@FindBy(name = "submit")
    private WebElement submitBtn;
	public WebElement getAgeTf() {
		return ageTf;
	}
	public WebElement getMedicineChargeTf() {
		return medicineChargeTf;
	}
	public WebElement getDoctorChargeTf() {
		return doctorChargeTf;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void patientInvoiceCreateForm(String age,String medicineCharge,String doctorCharge) {
		ageTf.sendKeys(age);
		medicineChargeTf.sendKeys(medicineCharge);
		doctorChargeTf.sendKeys(doctorCharge);
		submitBtn.click();
	}
}
