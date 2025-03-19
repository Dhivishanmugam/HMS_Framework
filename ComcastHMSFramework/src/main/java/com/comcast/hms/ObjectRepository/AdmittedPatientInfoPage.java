package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdmittedPatientInfoPage {
WebDriver driver;
public AdmittedPatientInfoPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(linkText = "Discharge")
private WebElement dischargeLink;
public WebElement getDischargeLink() {
	return dischargeLink;
}


}
