package hms_IntegrationTest;

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
import com.comcast.hms.ObjectRepository.PatientInfoPage;
import com.comcast.hms.ObjectRepository.PatientRegistrationPage;
import com.comcast.hms.genericUtility.ExcelUtility;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.JavaUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;

public class PatientRegistrationToPatientSearch_Test extends BaseClass {
	@Test(groups = "integrationTest")
	public void patientRegistrationToPatientSearch_Test() throws IOException, InterruptedException {
		// get data from excel
				String FIRSTNAME = eLib.getDataFromExcel("patient", 1, 0);
				String LASTNAME = eLib.getDataFromExcel("patient", 1, 1) + jLib.getAlphaNumericData();
				String SELECTDOCTOR = eLib.getDataFromExcel("patient", 1, 2);
				String ADDRESS = eLib.getDataFromExcel("patient", 1, 3);
				String CONTACTNUMBER = eLib.getDataFromExcel("patient", 1, 4);
				//String EMAILADDRESS = eLib.getDataFromExcel("patient", 1, 5);
				String GENDER = eLib.getDataFromExcel("patient", 1, 6);
				String BIRTHDATE = eLib.getDataFromExcel("patient", 1, 7);
				String BLOODGROUP = eLib.getDataFromExcel("patient", 1, 8);

				HomePage hp=new HomePage(driver);
				hp.navigatePatientInfo();

				PatientRegistrationPage prp=new PatientRegistrationPage(driver);
				prp.patientRegistrationForm(FIRSTNAME, LASTNAME, SELECTDOCTOR, ADDRESS);
				prp.getContactNumTextField().sendKeys(CONTACTNUMBER+jLib.getRandomNumberContactNum());
				prp.getEmailAddressTextField().sendKeys(jLib.getEmailAlphaData()+"@gmail.com");
				prp.patientRegistrationForm1(GENDER, BIRTHDATE, BLOODGROUP);
				
				PatientInfoPage pip=new PatientInfoPage(driver);
				pip.navigatepatientSearchLink();
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

