package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author ashok
 * @since 02-06-2023
 * @see  this class maintain reuseable codes used in this project
 *
 */
public class BaseClass {

	RequestSpecification reqSpec;
	public static Response response;

	public void addHeader(String Key, String Value) {
		reqSpec = RestAssured.given().header(Key, Value);

	}

	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);

	}

	public void addBody(String body) {

		reqSpec = reqSpec.body(body);
	}

	public void addBody(Object body) {

		reqSpec = reqSpec.body(body);
	}

	public void addPathParam(String Key, Integer string) {
		reqSpec = reqSpec.pathParam(Key, string);

	}

	public void addQueryParam(String Key, String Value) {

		reqSpec = reqSpec.queryParam(Key, Value);
	}

	public Response addReqType(String type, String endpoint) {

		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);

			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;

		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;

		case "PATCH":
			response = reqSpec.log().all().patch(endpoint);
			break;

		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);

		default:
			break;
		}
		return response;

	}

	public int getStatusCode(Response response) {
		int code = response.getStatusCode();
		return code;

	}

	public String getAsString(Response response) {

		String string = response.asString();
		return string;
	}

	public String getAsPreetyString(Response response) {

		String prettyString = response.asPrettyString();
		return prettyString;

	}

	public void addBasicAuth(String userName, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);

	}

	public static   String getProjectPath() {
		return System.getProperty("user.dir");

	}

	public static  String getPropertyFileValue(String Key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\config.properties"));
		Object object = properties.get(Key);
		String value = (String) object;
		System.out.println(value);
		return value;

	}

}
