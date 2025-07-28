package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import BaseClass.BaseClass;

public class Listener implements  ITestListener,ISuiteListener{

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String testname=result.getMethod().getMethodName();
		Reporter.log("==="+testname+"FAILURE===",true);
		Date d=new Date();
		String newdate=d.toString().replace(" ","_").replace(":","_");
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./errorShots/"+testname+""+newdate+".png");
		try
		{
			FileHandler.copy(temp, perm);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
