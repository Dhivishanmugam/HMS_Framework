package comcast_hms_testNgTest;

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
import com.comcast.hms.ObjectRepository.ActiveStaffMempersPage;
import com.comcast.hms.ObjectRepository.AdmittedPatientInfoPage;
import com.comcast.hms.ObjectRepository.AllOPDPatientInvoice;
import com.comcast.hms.ObjectRepository.HomePage;
import com.comcast.hms.ObjectRepository.LoginPage;
import com.comcast.hms.ObjectRepository.PatientAdmitRegisterPage;
import com.comcast.hms.ObjectRepository.PatientAdmitedInvoicePage;
import com.comcast.hms.ObjectRepository.PatientHomePage;
import com.comcast.hms.ObjectRepository.PatientInfoPage;
import com.comcast.hms.ObjectRepository.PatientInvoiceCreatePage;
import com.comcast.hms.ObjectRepository.PatientInvoiceHomePage;
import com.comcast.hms.ObjectRepository.PatientRegistrationPage;
import com.comcast.hms.ObjectRepository.RoomAvailaBilityPage;
import com.comcast.hms.ObjectRepository.RoomDetailsUpdateFormPage;
import com.comcast.hms.ObjectRepository.StaffInfoPage;
import com.comcast.hms.ObjectRepository.StaffMemberRegistrationPage;
import com.comcast.hms.genericUtility.ExcelUtility;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.JavaUtility;
import com.comcast.hms.genericUtility.WebDriverUtility;

@Listeners(com.comcast.hms.ListenerUtility.ListenerImpClass.class)
public class Hms_AllTest extends BaseClass {

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
		paip.PatientAdmittedInvoiceDetails(MEDICINECHARGE, DOCTORCHARGE, COUNTOFDAYS);
		System.out.println("Patient Discharged==>PASS");
		
		
		
	}
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
	wLib.switchToTabOnUrlParent(driver,"printopd.php");
	String invoiceSlip = driver.findElement(By.id("upform")).getText();
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
	@Test(groups = "smokeTest")
	public void RoomInformationIsymbol_Test() throws IOException {
	
		HomePage hp=new HomePage(driver);
		hp.navigateRoomInformationLink();
		
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
	 @Test(groups = "integrationTest")
		public void UpdateRoomInformationTest() throws IOException {
			
				
//			String DOCMORGINCHARGENAME = eLib.getDataFromExcel("patient",17, 0);
//			String DOCEVEINCHARGENAME = eLib.getDataFromExcel("patient",17, 1);
				
				
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
//				if(updatedOpdDoctorName.equals(DOCMORGINCHARGENAM)) {
					System.out.println("Updated Doctor Name is Displayed==>PASS");
//				}else {
//					System.out.println("Updated Doctor Name is Not Displayed==>FAIL");
//				}
				
				
			}
}
