/**
 * 
 */
package com.bongz.exceptions;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException{
	
	public FrameworkException(String message) {
		super(message);
	}
	
	public FrameworkException(String message,Throwable cause) {
		super(message,cause);
	}

}
