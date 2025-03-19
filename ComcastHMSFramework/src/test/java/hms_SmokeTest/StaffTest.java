package hms_SmokeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.hms.BaseTest.BaseClass;
import com.comcast.hms.ObjectRepository.HomePage;
import com.comcast.hms.ObjectRepository.LoginPage;
import com.comcast.hms.ObjectRepository.PatientHomePage;
import com.comcast.hms.genericUtility.FileUtility;

public class StaffTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void staffTest() throws IOException{
		

		HomePage hp=new HomePage(driver);
		hp.navigateStaffInfo();
		PatientHomePage php=new PatientHomePage(driver);
		php.navigateActiveMemberModule();
		String url1 = driver.getCurrentUrl();
		if(url1.contains("staffactmem.php")) {
			System.out.println("Active members page is displyed==>PASS");
		}else {
			System.out.println("Active members page is not displyed==>FAIL");
		}
		
	}

}
