package com.step;

import java.util.ArrayList;
import java.util.List;

import com.POJO.address.City;
import com.POJO.address.CityList_Output_POJO;
import com.base.BaseClass;
import com.endpoints.EndPoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author ashok
 * @see this class used perform get city list 
 * @since 02-06-2023
 *
 */
public class TC3_CityListStep extends BaseClass {

	public static Response response;

	/**
	 * @author ashok
	 * @see this method used to perform add headers
	 * @since20-06-2023
	 * 
	 */
	@Given("User add headers for to CityList")
	public void user_add_headers_for_to_city_list() {
		List<Header> ListHeader = new ArrayList<Header>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		ListHeader.add(h1);
		ListHeader.add(h2);
		Headers head = new Headers(ListHeader);
		addHeaders(head);
	}

	/**
	 *  @author ashok
	 * @see this class used perform add request body to get cityid
	 * @param string
	 * @since 02-06-2023
	 * 
	 */
	@When("User add request body to get cityid {string}")
	public void user_add_request_body_to_get_cityid(String string) {

		com.POJO.address.CityList_Input_POJO input = new com.POJO.address.CityList_Input_POJO(TC1_Login1Step.globalData.getStateId());
		System.out.println(TC1_Login1Step.globalData.getStateId());
		addBody(input);

	}

	/**
	 * @author ashok
	 * @see this class used perform send request for CityList endpoint
	 * @param reqType
	 * @since 02-06-2023
	 */
	@When("User send {string} request for CityList endpoint")
	public void user_send_request_for_city_list_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.CITYLIST);

	}

	/**
	 * @author ashok
	 * @see this class used perform CityList response message matches
	 * @param expCity
	 * @since 02-06-2023
	 */
	@Then("User verify CityList response message matches {string} and save City id")
	public void user_verify_city_list_response_message_matches_and_save_city_id(String expCity) {

		CityList_Output_POJO CityList = response.as(CityList_Output_POJO.class);
		System.out.println(getStatusCode(response));

		ArrayList<City> city = CityList.getData();
		for (City citylist : city) {
			String name = citylist.getName();
			if (name.equals(expCity)) {
				int Cityid = citylist.getId();
				String CityID = String.valueOf(Cityid);
				TC1_Login1Step.globalData.setCityId(CityID);

				System.out.println(Cityid);
				break;
			}

		}

	}

}
