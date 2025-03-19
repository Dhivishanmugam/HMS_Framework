package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffInfoPage {
WebDriver driver;
public StaffInfoPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath = "//strong[text()='Staff Memebers Details']")
private WebElement staffMemberDetailsLink;

@FindBy(xpath = "//strong[text()='Staff Memeber Search']")
private WebElement staffMemberSearchLink;

@FindBy(xpath = "//strong[text()='Active Members']")
private WebElement activeMembersLink;

@FindBy(xpath="//strong[text()='Staff Memeber Modifications']")
private WebElement staffMemberModificationLink;
public WebElement getStaffMemberDetailsLink() {
	return staffMemberDetailsLink;
}

public WebElement getStaffMemberSearchLink() {
	return staffMemberSearchLink;
}

public WebElement getActiveMembersLink() {
	return activeMembersLink;
}

public WebElement getStaffMemberModificationLink() {
	return staffMemberModificationLink;
}
public void navigateStaffMemberDetailsLink() {
	staffMemberDetailsLink.click();
}
public void navigateStaffMemberSearchLink() {
	staffMemberSearchLink.click();
}
public void navigateActiveMembersLink() {
	activeMembersLink.click();
}
}
