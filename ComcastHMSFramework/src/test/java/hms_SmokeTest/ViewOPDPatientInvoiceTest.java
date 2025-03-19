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
import com.comcast.hms.ObjectRepository.PatientInvoiceHomePage;
import com.comcast.hms.genericUtility.ExcelUtility;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;

public class ViewOPDPatientInvoiceTest extends BaseClass {

  @Test(groups = "smokeTest")
  public void ViewOPDPatientInvoice_Test() throws IOException{
		
		
		String actPageName = eLib.getDataFromExcel("patient",21, 0);
		HomePage hp=new HomePage(driver);
		hp.navigatePatientInvoice();
		
		PatientInvoiceHomePage pihp=new PatientInvoiceHomePage(driver);
		pihp.navigateAllAdmittedPatientmodule();
		
		wLib.scrollToElement(driver);
		String actPage = driver.findElement(By.xpath("//h3[text()='All Admite Patient Invoices']")).getText();
		if(actPage.equals(actPageName)) {
			System.out.println("All patient invoices displayed==>PASS");
		}else {
			System.out.println("All patient invoices not displayed==>FAIL");
		}
		wLib.scrollUp(driver);
		
	}

}
