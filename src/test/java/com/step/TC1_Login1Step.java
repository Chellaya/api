package com.step;

import java.io.FileNotFoundException;

import java.io.IOException;

import org.testng.Assert;

import com.POJO.login.Login_Output_POJO;
import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.global.GlobalDatas;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


/**
 * @author ashok
 * @see This class is used to perform Login functionallity
 * @since 02-06-2023
 *
 */
public class TC1_Login1Step extends BaseClass {
	static GlobalDatas globalData = new GlobalDatas();
	Response response;

	/**
	 * @author ashok
	 * @param  add header
	 * @since 02-06-2023
	 */
	@Given("User add header")
	public void user_add_header() {
		addHeader("accept", "application/json");
	}

	/**
	 * @author ashok
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @since 02-06-2023
	 */
	@When("User add base Authentication for login")
	public void user_add_base_authentication_for_login() throws FileNotFoundException, IOException {

		addBasicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));
		

	}

	/**
	 * @author ashok
	 * @see This method perform Login endpoint
	 * @param reqType (String)
	 * @since 02-06-2023
	 */
	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String reqType) {

		response = addReqType(reqType, EndPoints.POSTMANBASICAUTH);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		globalData.setStatusCode(statusCode);

	}

	/**
	 * @author ashok
	 * @see this method perform to get first name present and get logtoken
	 * @see then using assert equals method to verify first name
	 * @param expFirstName (String)
	 * @since 02-06-2023
	 */
	@Then("User verify the login response body firstName present as {string} and get the logtoken")
	public void user_verify_the_login_response_body_first_name_present_as_and_get_the_logtoken(String expFirstName) {

		Login_Output_POJO output_POJO = response.as(Login_Output_POJO.class);
		String first_name = output_POJO.getData().getFirst_name();
		 TC1_Login1Step.globalData.setLogtoken(output_POJO.getData().getLogtoken());
		System.out.println(output_POJO.getData().getFirst_name());
		Assert.assertEquals(expFirstName, first_name, "Verify FirstName");

	}

}
