
package com.bongz.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.bongz.annotations.FrameworkAnnotation;
import com.bongz.reports.ExtentLogger;
import com.bongz.reports.ExtentReport;
import com.bongz.utils.ELKUtils;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 * Mostly used to help in extent report generation
 * 
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 *  
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public class ListenerClass implements ITestListener, ISuiteListener{

	/**
	 * 
	 * Initialise the reports with the file name
	 * @see com.bongz.reports.ExtentReport
	 */
	
	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}
	
	/**
	 * Terminate the reports
	 * @see com.bongz.reports.ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
			ExtentReport.flushReports();
			
	}
	
	/**
	 * Starts a test node for each testng test
	 * @see com.bongz.reports.ExtentReport
	 * @see com.bongz.annotations.FrameworkAnnotation
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.category());
	}
	
	/**
	 * 
	 * Marks the test as pass and logs it in the report
	 * @see com.bongz.reports.ExtentLogger
	 */
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() +" is passed");
		ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(), "pass");
	}
	
	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report
	 * @see com.bongz.reports.ExtentLogger
	 * @see com.bongz.utils.ScreenshotUtils
	 */
	@Override
	public void onTestFailure(ITestResult result) {
	
			ExtentLogger.fail(result.getMethod().getMethodName() +" is failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
			ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(), "fail");
	}
	
	/**
	 * Marks the test as skip and logs it in the report
	 * @see com.bongz.reports.ExtentLogger
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() +" is skipped");
		ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(), "skip");
	}

	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * For now, we are not using this.
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
		
	}


}
