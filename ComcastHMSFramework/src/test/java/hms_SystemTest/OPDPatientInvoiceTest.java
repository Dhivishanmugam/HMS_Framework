package hms_SystemTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.hms.BaseTest.BaseClass;
import com.comcast.hms.ObjectRepository.AllOPDPatientInvoice;
import com.comcast.hms.ObjectRepository.HomePage;
import com.comcast.hms.ObjectRepository.LoginPage;
import com.comcast.hms.ObjectRepository.PatientInfoPage;
import com.comcast.hms.ObjectRepository.PatientInvoiceCreatePage;
import com.comcast.hms.ObjectRepository.PatientRegistrationPage;
import com.comcast.hms.genericUtility.ExcelUtility;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.JavaUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;

public class OPDPatientInvoiceTest extends BaseClass {
        @Test(groups="systemTest")
        public void OPDPatientInvoice_Test() throws IOException, InterruptedException {
		

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
		
		String AGE = eLib.getDataFromExcel("patient",13,0);
		String MEDICINECHARGE = eLib.getDataFromExcel("patient",13,1);
		String DOCTORCHARGE = eLib.getDataFromExcel("patient",13,2);

	
		HomePage hp=new HomePage(driver);
		hp.navigatePatientInfo();

		PatientRegistrationPage prp=new PatientRegistrationPage(driver);
		prp.patientRegistrationForm(FIRSTNAME, LASTNAME, SELECTDOCTOR, ADDRESS);
		prp.getContactNumTextField().sendKeys(CONTACTNUMBER+jLib.getRandomNumberContactNum());
		prp.getEmailAddressTextField().sendKeys(jLib.getEmailAlphaData()+"@gmail.com");
		prp.patientRegistrationForm1(GENDER, BIRTHDATE, BLOODGROUP);
      
		PatientInfoPage pip=new PatientInfoPage(driver);
		Thread.sleep(2000);
		pip.patientInformationLink();
		wLib.scrollToElement(driver);
		pip.navigateMakeOpdInvoiceLink();
		
		wLib.switchToTabOnUrl(driver,"opdinvo.php");
		wLib.scrollToElement(driver);
		PatientInvoiceCreatePage picp=new PatientInvoiceCreatePage(driver);
		picp.patientInvoiceCreateForm(AGE, MEDICINECHARGE, DOCTORCHARGE);
		
		hp.navigatePatientInvoice();
		wLib.scrollToElement(driver);
		AllOPDPatientInvoice aopi=new AllOPDPatientInvoice(driver);
		aopi.navigateViewLink();
		//wLib.switchToTabOnUrl(driver, "printopd.php");
		wLib.switchToTabOnUrlParent(driver,"printopd.php");
		String invoiceSlip = driver.findElement(By.id("upform")).getText();
		//String invoiceSlip = driver.findElement(By.xpath("//tr[2]//td[1]//strong[1]")).getText();
		System.out.println(invoiceSlip);
		String actPatient = driver.findElement(By.xpath("//tr[4]//td[2]//strong[1]")).getText();
		if(actPatient.contains(LASTNAME)) {
			System.out.println("INVOICE CREATED==>PASS");
		}else {
			System.out.println("INVOICE NOT CREATED==>FAIL");
		}
		wLib.switchToTabOnUrlParent(driver, "invoinfo.php");
		wLib.scrollUp(driver);
		
	}

}
