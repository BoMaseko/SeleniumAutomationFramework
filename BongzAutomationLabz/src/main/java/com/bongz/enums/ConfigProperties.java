
package com.bongz.enums;

/**
 * 
 * Enums to restrict the values used on Property files. Without using enums there can be null pointer exceptions happening
 * because of typos.
 * <p>
 * Whenever a new value is added to property file, corresponding enum should be created here.
 * 
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 * @see com.bongz.utils.PropertyUtils
 */
public enum ConfigProperties {
	
	URL,
	OVERRIDEREPORTS,
	PASSEDSTEPSSCREENSHOTS,
	FAILEDSTEPSSCREENSHOTS,
	SKIPPEDSTEPSSCREENSHOTS,
	RETRYFAILEDTESTS,
	SENDRESULTTOELK,
	SELENIUMGRIDURL,
	ELASTICSEARCHURL,
	RUNMODE,
	BROWSER;

}
