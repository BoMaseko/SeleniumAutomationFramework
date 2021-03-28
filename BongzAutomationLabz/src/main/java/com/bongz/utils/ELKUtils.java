/**
 * 
 */
package com.bongz.utils;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.bongz.enums.ConfigProperties;

import io.restassured.response.Response;

/**
 * 12 Mar 2021
 * @author Bongz
 * @version 1.0
 */
public class ELKUtils {

	private ELKUtils() {}

	public static void sendDetailsToElk(String testName, String status) {

		if (PropertyUtils.get(ConfigProperties.SENDRESULTTOELK).equalsIgnoreCase("yes")) {

			Map<String, String> map = new HashMap<>();
			map.put("testName", testName);
			map.put("status", status);
			map.put("executionTime", LocalDateTime.now().toString());

			Response response = given().header("Content-Type", "application/json")
					.log()
					.all()
					.body(map)
					.post(PropertyUtils.get(ConfigProperties.ELASTICSEARCHURL));

			Assert.assertEquals(response.statusCode(), 201);
			response.prettyPrint();

		}
	}

}
