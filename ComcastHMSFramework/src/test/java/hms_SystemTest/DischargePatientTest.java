package hms_SystemTest;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.hms.BaseTest.BaseClass;
import com.comcast.hms.ObjectRepository.AdmittedPatientInfoPage;
import com.comcast.hms.ObjectRepository.HomePage;
import com.comcast.hms.ObjectRepository.LoginPage;
import com.comcast.hms.ObjectRepository.PatientAdmitedInvoicePage;
import com.comcast.hms.genericUtility.ExcelUtility;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;

public class DischargePatientTest extends BaseClass {
@Test(groups = "systemTest")
public void DischargePatient_Test() throws IOException{
	
	
	String MEDICINECHARGE = eLib.getDataFromExcel("patient",7,0);
	String DOCTORCHARGE = eLib.getDataFromExcel("patient",7,1);
	String COUNTOFDAYS = eLib.getDataFromExcel("patient",7,2);
	
	
	HomePage hp=new HomePage(driver);
	hp.navigateAdmitedPatientInfoLink();
	
	AdmittedPatientInfoPage apip=new AdmittedPatientInfoPage(driver);
	wLib.scrollToElement(driver);
	apip.getDischargeLink().click();
	
	wLib.switchToTabOnUrl(driver,"admiteinvo.php?");
	wLib.scrollDown(driver);
	
	PatientAdmitedInvoicePage paip=new PatientAdmitedInvoicePage(driver);
//	paip.getMedicineChargeTf().sendKeys(MEDICINECHARGE);
//	paip.getDoctorChargeTf().sendKeys(DOCTORCHARGE);
//	paip.getCountOfDaysTf().sendKeys(COUNTOFDAYS);
	paip.PatientAdmittedInvoiceDetails(MEDICINECHARGE, DOCTORCHARGE, COUNTOFDAYS);
	System.out.println("Patient Discharged==>PASS");
}
}
