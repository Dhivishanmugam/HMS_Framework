package com.comcast.hms.BaseTest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.hms.ObjectRepository.HomePage;
import com.comcast.hms.ObjectRepository.LoginPage;
import com.comcast.hms.genericUtility.DataBaseUtility;
import com.comcast.hms.genericUtility.ExcelUtility;
import com.comcast.hms.genericUtility.FileUtility;
import com.comcast.hms.genericUtility.JavaUtility;
import com.comcast.hms.genericUtility.ThreadLocalImp;
import com.comcast.hms.genericUtility.WebDriverUtility;



public class BaseClass {
	//create objects
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public  WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = {"smokeTest","integrationTest","systemTest"})
	public void configBS() throws SQLException {
		System.out.println("===Connect to DB,Report config===");
		dLib.getDbConnection();


	}

	/*@BeforeClass(groups = {"smokeTest","regressionTest"})
		public void configBC() throws IOException {
			System.out.println("==Launch the browser==");
			String BROWSER = fLib.getDataFromPropertiesFile("browser");

			if (BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (BROWSER.equals("edge")) {
				driver = new EdgeDriver();
			} 
		}*/
	//for cross browser testing
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","integrationTest","systemTest"})
	public void configBC(@Optional("chrome")String browser) throws IOException {
		System.out.println("==Launch the browser==");
		String BROWSER = browser;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} 
		sdriver=driver;
		ThreadLocalImp.setDriver(driver);
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException {
		System.out.println("==Login to an application==");
		String URL = fLib.getDataFromPropertyFile("url");
		String USERNAME = fLib.getDataFromPropertyFile("username");
		String PASSWORD = fLib.getDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
        
	}
	@AfterMethod(groups = {"smokeTest","integrationTest","systemTest"})
	public void congigAM() {
		System.out.println("==Logout to an application==");
		HomePage hp=new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.Logout();
	}
	@AfterClass(groups = {"smokeTest","integrationTest","systemTest"})
	public void configAC() {
		System.out.println("==Close the browser==");
		driver.quit();
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("===Close DB,Report backup===");
		dLib.closeDbConnection();
	} 
}


