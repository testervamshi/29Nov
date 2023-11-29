package Utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;//UI of the report
	public ExtentReports extent;// populate common info on the report
	public ExtentTest test;// create entry in the report and update
	String repName;
	
	public void onStart(ITestContext context) 
	{
		String timestamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// Time stamp
		repName="Test-Report-"+timestamp+".html";
		//specify the location of folder to generate report
	   sparkreporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location
	   sparkreporter.config().setDocumentTitle("Automation Testing");//Title of report
	   sparkreporter.config().setReportName("Functional Testing");//name of the report
	   sparkreporter.config().setTheme(Theme.DARK);//theme
	   //Common info to the report
	   extent =new ExtentReports();
	   extent.attachReporter(sparkreporter);
	   extent.setSystemInfo("computer name", "localhost");
	   extent.setSystemInfo("Environment", "QA");
	   extent.setSystemInfo("Testername", "Vamshi");
	   extent.setSystemInfo("OS", "Windows 10");
	   extent.setSystemInfo("Browser", "Chrome");
	   
	}
		
	public void onTestSuccess(ITestResult result) 
	{
		test=extent.createTest(result.getName());// create entry on the report
		test.log(Status.PASS, "Test is passed:"+result.getName());// update the status of test
		try {
			String imgpath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result) 
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test is failed:"+result.getName());
		test.log(Status.FAIL, "Test is failed because:"+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test is skipped:"+result.getName());
		test.log(Status.SKIP, "Test is skipped because:"+result.getThrowable());
	}
	
	public void onFinish(ITestContext context) 
	{
		extent.flush();//modify the alignment
	}

}
