package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOPDPatientInvoice {
WebDriver driver;
public AllOPDPatientInvoice(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath = "//td//a[text()='View']")
private WebElement viewLink;
public WebElement getViewLink() {
	return viewLink;
}
public void navigateViewLink() {
	viewLink.click();
}


}
