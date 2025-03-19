package com.comcast.hms.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.hms.BaseTest.BaseClass;
import com.comcast.hms.genericUtility.ThreadLocalImp;

public class ListenerImpClass implements ITestListener,ISuiteListener {
	public static ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		//spark report Config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("HMSTest Suite Results");
		spark.config().setReportName("HMS Report");
		spark.config().setTheme(Theme.DARK);

		//Add ENV information & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		//for save and backup the report
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
				System.out.println("========"+result.getMethod().getMethodName()+"====START====");
				test=report.createTest(result.getMethod().getMethodName());
				ThreadLocalImp.setTest(test);
				test.log(Status.INFO,result.getMethod().getMethodName()+"===>STARTED<====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("========"+result.getMethod().getMethodName()+"====END====");
		test.log(Status.PASS,result.getMethod().getMethodName()+"===>COMPLETED<====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		//		File srcFile = edriver.getScreenshotAs(OutputType.FILE);

		//to take screenshot for external reports
		 TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);

		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		//		try {
		//		FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+"+ "+time+".png"));
		//		}catch (Exception e) {
		//			// TODO: handle exception
		//			e.printStackTrace();
		//			}
		//for extent report
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time); 
		test.log(Status.FAIL,result.getMethod().getMethodName()+"===>FAILED<====");
		test.log(Status.FAIL, result.getThrowable());//to get the exception in report with exception name

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
   
}
