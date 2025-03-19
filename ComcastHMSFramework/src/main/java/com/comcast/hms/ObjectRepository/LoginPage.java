package com.comcast.hms.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(id = "field")
private WebElement userNameTextField;

@FindBy(xpath = "//input[@type='password']")
private WebElement passwordTextField;

@FindBy(name = "login")
private WebElement loginBtn;
public WebElement getUserNameTextField() {
	return userNameTextField;
}
@FindBy(linkText = "Logout")
private WebElement logoutLink;

public WebElement getPasswordTextField() {
	return passwordTextField;
}
public WebElement getLoginBtn() {
	return loginBtn;
}
public WebElement getLogoutLink() {
	return logoutLink;
}
public void loginToApp(String url,String username,String password) {
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(url);
	userNameTextField.sendKeys(username);
	passwordTextField.sendKeys(password);
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()",loginBtn);
}
public void Logout() {
	logoutLink.click();
}

}
