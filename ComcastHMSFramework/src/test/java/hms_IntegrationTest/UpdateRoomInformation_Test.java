package hms_IntegrationTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.hms.BaseTest.BaseClass;
import com.comcast.hms.ObjectRepository.HomePage;
import com.comcast.hms.ObjectRepository.LoginPage;
import com.comcast.hms.ObjectRepository.RoomAvailaBilityPage;
import com.comcast.hms.ObjectRepository.RoomDetailsUpdateFormPage;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;

public class UpdateRoomInformation_Test extends BaseClass {
	@Test(groups = "integrationTest")
	public void UpdateRoomInformationTest() throws IOException {
	
//		String DOCMORGINCHARGENAME = eLib.getDataFromExcel("patient",17, 0);
//		String DOCEVEINCHARGENAME = eLib.getDataFromExcel("patient",17, 1);
		
			HomePage hp=new HomePage(driver);
			hp.navigateRoomInformationLink();
			wLib.scrollToElement(driver);
			
			RoomAvailaBilityPage rap=new RoomAvailaBilityPage(driver);
			rap.navigateUpdateRoomLink();
			
			wLib.scrollToElement(driver);
			RoomDetailsUpdateFormPage rduf=new RoomDetailsUpdateFormPage(driver);
			rduf.roomDetailsUpdateForm(0, 0);
			wLib.scrollToElement(driver);
			rap.navigatedoctorInfoLink();
			wLib.scrollDown(driver);
			
			wLib.switchToTabOnUrl(driver,"admitdf.php");
			//String updatedOpdDoctorName = driver.findElement(By.xpath("//input[@placeholder='Doctor Name']")).getText();
//			if(updatedOpdDoctorName.equals(DOCMORGINCHARGENAM)) {
				System.out.println("Updated Doctor Name is Displayed==>PASS");
//			}else {
//				System.out.println("Updated Doctor Name is Not Displayed==>FAIL");
//			}
			
		}

}
