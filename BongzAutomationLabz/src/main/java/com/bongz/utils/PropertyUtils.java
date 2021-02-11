/**
 * 
 */
package com.bongz.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.bongz.constants.FrameworkConstants;
import com.bongz.enums.ConfigProperties;
import com.bongz.exceptions.PropertyFileUsageException;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class PropertyUtils {
	
	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private PropertyUtils() {}

	static {
		try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			property.load(file);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} 
	}
	
	public static String get(ConfigProperties key)  {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name " + key + " is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
