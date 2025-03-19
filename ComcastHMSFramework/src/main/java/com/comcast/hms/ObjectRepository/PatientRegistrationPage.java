package com.comcast.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.hms.genericUtility.JavaUtility;

public class PatientRegistrationPage {
	WebDriver driver;

	public PatientRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "fname")
	private WebElement firstNameTf;
	@FindBy(id = "lname")
	private WebElement lastNameTf;
	@FindBy(name = "dnames")
	private WebElement selectDoctorDropDown;
	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement addressTextField;
	@FindBy(xpath = "//input[@placeholder='Contact Number']")
	private WebElement contactNumTextField;
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	private WebElement emailAddressTextField;
	@FindBy(name = "gender")
	private WebElement genderDropDown;
	@FindBy(xpath = "//input[@type='date']")
	private WebElement birthDateDropDown;
	@FindBy(xpath = "//select[@title='Select Your Blood Group']")
	private WebElement bloodGroupDropDown;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitBtn;

	JavaUtility jLib=new JavaUtility();
	public WebElement getFirstNameTf() {
		return firstNameTf;
	}

	public WebElement getLastNameTf() {
		return lastNameTf;
	}

	public WebElement getSelectDoctorDropDown() {
		return selectDoctorDropDown;
	}

	public WebElement getAddressTextField() {
		return addressTextField;
	}

	public WebElement getContactNumTextField() {
		return contactNumTextField;
	}

	public WebElement getEmailAddressTextField() {
		return emailAddressTextField;
	}

	public WebElement getGenderDropDown() {
		return genderDropDown;
	}

	public WebElement getBirthDateDropDown() {
		return birthDateDropDown;
	}

	public WebElement getBloodGroupDropDown() {
		return bloodGroupDropDown;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void patientRegistrationForm(String firstName,String lastName,String doctorType,String address) {
		firstNameTf.sendKeys(firstName);
		lastNameTf.sendKeys(lastName);
		Select sel=new Select(selectDoctorDropDown);
		sel.selectByVisibleText(doctorType);
		addressTextField.sendKeys(address);
	}
	public void patientRegistrationForm1(String genderType,String birthType,String bloodGroupType) throws InterruptedException{
		Actions act=new Actions(driver);
		act.scrollByAmount(0, 500).perform();
		//Thread.sleep(2000);
		Select sel1 = new Select(genderDropDown);
		sel1.selectByVisibleText(genderType);
		birthDateDropDown.sendKeys(birthType);
		Select sel2 = new Select(bloodGroupDropDown);
		sel2.selectByVisibleText(bloodGroupType);
		submitBtn.click();
	}
		


	}

