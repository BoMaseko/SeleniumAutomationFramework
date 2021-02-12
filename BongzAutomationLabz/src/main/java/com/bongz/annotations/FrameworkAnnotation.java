/**
 * 
 */
package com.bongz.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.bongz.enums.CategoryType;

/**
 * 12 Feb 2021
 * @author Bongz
 * @version 1.0
 */

@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {

	public String[] author();
	
	public CategoryType[] category();
	
}
