package hms_SystemTest;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.hms.BaseTest.BaseClass;
import com.comcast.hms.ObjectRepository.HomePage;
import com.comcast.hms.ObjectRepository.LoginPage;
import com.comcast.hms.ObjectRepository.PatientAdmitRegisterPage;
import com.comcast.hms.ObjectRepository.PatientInfoPage;
import com.comcast.hms.ObjectRepository.PatientRegistrationPage;
import com.comcast.hms.genericUtility.ExcelUtility;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.JavaUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;
public class CreatePatientTest extends BaseClass {
	@Test(groups = "systemTest")
	public void CreatePatient_Test() throws IOException, InterruptedException{
		
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

		String DISEASENAME = eLib.getDataFromExcel("patient", 4, 0);

		

		HomePage hp=new HomePage(driver);
		hp.navigatePatientInfo();

		PatientRegistrationPage prp=new PatientRegistrationPage(driver);
		prp.patientRegistrationForm(FIRSTNAME, LASTNAME, SELECTDOCTOR, ADDRESS);
		prp.getContactNumTextField().sendKeys(CONTACTNUMBER+jLib.getRandomNumberContactNum());
		prp.getEmailAddressTextField().sendKeys(jLib.getEmailAlphaData()+"@gmail.com");
		prp.patientRegistrationForm1(GENDER, BIRTHDATE, BLOODGROUP);

		PatientInfoPage pip=new PatientInfoPage(driver);
		pip.patientInformationLink();

		wLib.scrollToElement(driver);
		//WebElement patientName = driver.findElement(By.xpath("//td='Diyaa PinkuLFOVF']/..//a[text()='Admit to Hospital']"));
		//WebElement patientName=driver.findElement(By.xpath("//td[text()='"+FIRSTNAME+"\t"+LASTNAME+"']/..//a[text()='Admit to Hospital']"));
		driver.findElement(By.xpath("(//a[@name='ad'])[3]")).click();
		 
		wLib.switchToTabOnUrl(driver,"admit.php");
		wLib.scrollDown(driver);
		
		PatientAdmitRegisterPage parp=new PatientAdmitRegisterPage(driver);
		parp.admitPatient(DISEASENAME);
		Select sel=new Select(parp.getSelectRoomDropDown());
		sel.selectByIndex(jLib.getRandomNumberRoomNo());
		parp.getSubmitButton().click();
		
		String ActPatientName = driver.findElement(By.xpath("//td[5]")).getText();
		System.out.println(ActPatientName);
		
		WebElement fulldetails = driver.findElement(By.xpath("//h4[@class='text-center']/.."));
		String text = fulldetails.getText();
		System.out.println(text);
		if(ActPatientName.contains(LASTNAME)) {
			System.out.println("Patient admitted==>TRUE");
		}else {
			System.out.println("Patient admitted==>FALSE");
		}
		wLib.scrollUp(driver);
		
	}
	
}
