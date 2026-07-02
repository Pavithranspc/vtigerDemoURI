package org.vtiger.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	int num = 0;
	int upperlimit = 3;
	
	@Override
	public boolean retry(ITestResult result) {

		if (num<upperlimit) {
			
			num++;
			return true;
			
		}
		
		return false;
	}
	
}
