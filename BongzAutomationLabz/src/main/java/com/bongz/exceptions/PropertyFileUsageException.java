
package com.bongz.exceptions;

/**
 * Runtime Exception occurs when the key or value fetched from the property file is null
 * 
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 * @see com.bongz.constants.FrameworkConstants
 * @see com.bongz.utils.PropertyUtils
 */
@SuppressWarnings("serial")
public class PropertyFileUsageException extends FrameworkException{
	
	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public PropertyFileUsageException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public PropertyFileUsageException(String message,Throwable cause) {
		super(message,cause);
	}

}
