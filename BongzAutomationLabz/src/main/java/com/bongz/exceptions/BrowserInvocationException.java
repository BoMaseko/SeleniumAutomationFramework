/**
 * 
 */
package com.bongz.exceptions;

/**
 * 01 Mar 2021
 * @author Bongz
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BrowserInvocationException extends FrameworkException{
	
	/**
	 * 
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public BrowserInvocationException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public BrowserInvocationException(String message,Throwable cause) {
		super(message,cause);
	}

}
