package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientHomePage {
WebDriver driver;
public PatientHomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath = "//strong[text()='Active Members']")
private WebElement activeMemberModule;
public WebElement getActiveMemberModule() {
	return activeMemberModule;
}

public void navigateActiveMemberModule() {
	activeMemberModule.click();
}
}
