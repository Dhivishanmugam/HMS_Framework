package hms_SmokeTest;

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
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;

public class RoomInformationIsymbolTest extends BaseClass {

	
	@Test(groups = "smokeTest")
	public void RoomInformationIsymbol_Test() throws IOException {
	
		HomePage hp=new HomePage(driver);
		hp.navigateRoomInformationLink();
		//wLib.scrollToElement(driver);
		
//		RoomAvailaBilityPage rap=new RoomAvailaBilityPage(driver);
//		rap.navigateiSymbol();
		 //String actualRoomInfo = driver.findElement(By.xpath("//table//tbody//tr[2]//td[3]")).getText();
		String actualRoomInfo=driver.findElement(By.xpath("//h3[text()='Room Avilablity']")).getText();
		 System.out.println(actualRoomInfo);
		//String actUrl = driver.getCurrentUrl();
		if(actualRoomInfo.equals("Room Avilablity")) {
			 System.out.println("Verified Room information==>PASS");
		 }else {
			 System.out.println("Not Verified Room information==>FAIL");
		 }
		
		wLib.scrollUp(driver);
	
	}

}
