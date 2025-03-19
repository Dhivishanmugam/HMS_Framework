package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomAvailaBilityPage {
	WebDriver driver;
	public RoomAvailaBilityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath = "(//a[text()='Update Room Informtion'])[1]")
private WebElement updtaeRoomLink;

@FindBy(linkText = "Doctor Info")
private WebElement doctorInfoLink;

@FindBy(xpath = "(//img[contains(@src,'images/info.png')])[4]")
private WebElement iSymbol;

public WebElement getUpdtaeRoomLink() {
	return updtaeRoomLink;
}

public WebElement getDoctorInfoLink() {
	return doctorInfoLink;
}

public void navigateUpdateRoomLink() {
	updtaeRoomLink.click();
}
public void navigatedoctorInfoLink() {
	doctorInfoLink.click();
}

public WebElement getiSymbol() {
	return iSymbol;
}
public void navigateiSymbol() {
	iSymbol.click();
}
}
