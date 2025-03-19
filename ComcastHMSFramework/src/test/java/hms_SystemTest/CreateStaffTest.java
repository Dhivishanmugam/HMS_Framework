package hms_SystemTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.hms.BaseTest.BaseClass;
import com.comcast.hms.ObjectRepository.HomePage;
import com.comcast.hms.ObjectRepository.LoginPage;
import com.comcast.hms.ObjectRepository.StaffInfoPage;
import com.comcast.hms.ObjectRepository.StaffMemberRegistrationPage;
import com.comcast.hms.genericUtility.ExcelUtility;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.JavaUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;

public class CreateStaffTest extends BaseClass {

	@Test(groups = "systemTest")
	public void CreateStaff_Test() throws IOException, InterruptedException{
		
		//from excel
		String FIRSTNAME = eLib.getDataFromExcel("patient",1,0);
		String LASTNAME = eLib.getDataFromExcel("patient",1,1) + jLib.getAlphaNumericData();
		String ADDRESS=eLib.getDataFromExcel("patient",1,3);
		String CONTACTNUMBER = eLib.getDataFromExcel("patient",1,4)+jLib.getRandomNumberContactNum();
		String GENDER = eLib.getDataFromExcel("patient",1,6);
		String BIRTHDATE = eLib.getDataFromExcel("patient",1,7);
		String STAFFTYPE = eLib.getDataFromExcel("patient",10,0);
		String WORKINGTIME = eLib.getDataFromExcel("patient",10,1);
		
		
		HomePage hp=new HomePage(driver);
		hp.navigateStaffInfo();

		wLib.scrollToElement(driver);
		StaffMemberRegistrationPage smrp=new StaffMemberRegistrationPage(driver);
		smrp.staffMemberRegistrationForm1(FIRSTNAME, LASTNAME, ADDRESS, CONTACTNUMBER);
		smrp.getEmailTf().sendKeys(jLib.getEmailAlphaData()+"@gmail.com");
		smrp.staffMemberRegistrationForm2(GENDER, BIRTHDATE, STAFFTYPE, WORKINGTIME);
		
		StaffInfoPage sip=new StaffInfoPage(driver);
		sip.navigateStaffMemberDetailsLink();
		wLib.scrollToElement(driver);
		String actName = driver.findElement(By.xpath("//td[3]")).getText();
		if(actName.contains(LASTNAME)) {
			System.out.println("Staff is CREATED==>PASS");
		}else {
			System.out.println("Staff is NOT CREATED==>FAIL");
		}
		
	wLib.scrollUp(driver);
	sip.navigateStaffMemberSearchLink();
	Thread.sleep(2000);
	wLib.scrollDown(driver);
	driver.findElement(By.name("searvalu")).sendKeys(CONTACTNUMBER);
	driver.findElement(By.name("filter")).click();
	String actContactNum = driver.findElement(By.xpath("//dd[2]")).getText();
	if(actContactNum.contains(CONTACTNUMBER)) {
		System.out.println("Staff is VERIFIED==>PASS");
	}else {
		System.out.println("Staff is NOT VERIFIED==>FAIL");
	}
	}
 
}
