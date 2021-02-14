
package com.bongz.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.bongz.constants.FrameworkConstants;

/**
 * Holds the data provider for all the test cases in the framework.
 * 
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public class DataProviderUtils {


	/**
	 * Private constructor to avoid external instantiation
	 */
	private DataProviderUtils() {}

	private static List<Map<String, String>> list =	new ArrayList<>();
	
	/**
	 * Acts as a data provider for all the test cases.
	 * Parallel=true indicates that each of the iteration will be ran in parallel.
	 * 
	 * @author Bongz
	 * @param m {@link java.lang.reflect.Method} holds the information about the testcases at runtime
	 * @return Object[] containing the List. Each index of the list contains HashMap and each of them
	 * contains the test data needed to run the iterations.
	 * 
	 * @see com.bongz.tests.AmazonDemoTest 
	 * @see com.bongz.listeners.AnnotationTransformer
	 */
	@DataProvider(parallel=true)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDatasheet());
		}
		
		List<Map<String, String>> smalllist = new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) &&  
					list.get(i).get("execute").equalsIgnoreCase("yes")) {
						smalllist.add(list.get(i));
			}
		}
		
		return smalllist.toArray();
		
	}
}
