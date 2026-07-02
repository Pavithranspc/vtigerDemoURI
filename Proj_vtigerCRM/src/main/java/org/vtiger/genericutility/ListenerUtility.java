package org.vtiger.genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.vitger.bussinessutility.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ListenerUtility implements ITestListener, ISuiteListener {

	ExtentReports extentreports;
	ExtentTest test;
	
	JavaUtility jUtil = new JavaUtility();
	
	@Override
	public void onStart(ISuite suite) {
		
		Reporter.log("onStartMethod",true);

		//Step 1: create object for ExtentSparkReporter class
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/Report"+jUtil.getTimeStamp()+".html");
		
		//Step 2: create object for ExtentReports class
		extentreports = new ExtentReports();
		
		//Step 3: attach the reporter to spark
		extentreports.attachReporter(spark);
		
		//Step 4: Create report using createTest()
		test = extentreports.createTest("SampleTest");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
		Reporter.log("onFinishMethod",true);
		
		//Step 6: save the report
		extentreports.flush();

		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		Reporter.log("onTestSuccessMethod",true);
		
		//Step 5: Log the message
		test.log(Status.PASS,result.getMethod().getMethodName());

		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		
		
		//step 1: type cast driver reference into TakesScreenshot reference
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
  
		//step 2: call getScreenshotAs() and pass file type argument
		File temp = ts.getScreenshotAs(OutputType.FILE);
		 
		//step 3: create a destination file
		//create object for File class form java.io package
		File dest = new File("./errorshots/errorshots"+result.getMethod().getMethodName()+jUtil.getTimeStamp()+".png");         
		
		//step 4: copy paste the temp into dest using FileHandler class from selenium.io
		
			try {
				FileHandler.copy(temp, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Reporter.log("onTestFailureMethod",true);
		
		test.log(Status.FAIL, result.getMethod().getMethodName()); 
		
		
		
		
		
		

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		Reporter.log("onTestSkippedMethod",true);
		
		test.log(Status.SKIP, result.getMethod().getMethodName());

	}

}






