package hms_IntegrationTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.hms.BaseTest.BaseClass;
import com.comcast.hms.ObjectRepository.ActiveStaffMempersPage;
import com.comcast.hms.ObjectRepository.HomePage;
import com.comcast.hms.ObjectRepository.LoginPage;
import com.comcast.hms.ObjectRepository.StaffInfoPage;
import com.comcast.hms.genericUtility.ExcelUtility;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;

public class StaffDoctorWorkingTimeCheck_Test extends BaseClass {
	@Test(groups = "integrationTest")
	public void StaffDoctorWorkingTimeCheckTest() throws IOException {
		
		String HEADNAME = eLib.getDataFromExcel("patient", 23, 0);
		
		HomePage hp=new HomePage(driver);
		hp.navigateStaffInfo();
		//wLib.scrollToElement(driver);
		
		StaffInfoPage sip=new StaffInfoPage(driver);
		sip.navigateActiveMembersLink();
		ActiveStaffMempersPage asmp=new ActiveStaffMempersPage(driver);
		String ActEveStaffWorking = asmp.getEveDate().getText();
		System.out.println(ActEveStaffWorking);
		
		wLib.scrollUp(driver);
		String ActHeadName = asmp.getHeadName().getText();
		if(ActHeadName.equals(HEADNAME)) {
			System.out.println("Doctor working time verified==>PASS");
		}else {
			System.out.println("Doctor working time not verified==>FAIL");
		}
		
	}
}
