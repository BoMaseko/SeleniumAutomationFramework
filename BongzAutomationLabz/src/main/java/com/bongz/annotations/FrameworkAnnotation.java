
package com.bongz.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.bongz.enums.CategoryType;

/**
 * 
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and 
 * category details to the extent report.<p>
 * 
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 * 
 * 12 Feb 2021
 * @author Bongz
 * @version 1.0
 * 
 * @see com.bongz.tests.AmazonDemoTest
 * @see com.bongz.enums.CategoryType
 * 
 */

@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {

	/**
	 * Store the authors who created the tests in String[]
	 * Manadatory to enter atleast a value
	 * 
	 * @author Bongz
	 * @return
	 */
	public String[] author();
	
	
	/**
	 * Stores the category in form of Enum Array. Include the possible values in {@link com.bongz.enums.CategoryType}
	 * 
	 * @author Bongz
	 * @return
	 */
	public CategoryType[] category();
	
}
