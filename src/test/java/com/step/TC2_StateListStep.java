 package com.step;

import java.util.ArrayList;

import com.POJO.address.StateList_Output_POJO;
import com.base.BaseClass;
import com.endpoints.EndPoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * @author ashok
 * @see this class used to perform user to find state list
 * @since 20-06-2023
 * 
 *
 */
public class TC2_StateListStep extends BaseClass{

    public static Response response;
	
	/**
	 * @author ashok
	 * @see this method use to perform add headers
	 * @since 02-06-2023
	 * 
	 */
	@Given("User add headers for to StateList")
	public void user_add_headers_for_to_state_list() {
		addHeader("accept", "application/json");
		
	}

	/**
	 * @author ashok
	 * @see this method use to perform send request for StateList endpoint
	 * @param string
	 * @since 02-06-2023
	 */
	@When("User send {string} request for StateList endpoint")
	public void user_send_request_for_state_list_endpoint(String endpoint) {
		 response = addReqType(endpoint, EndPoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_Login1Step.globalData.setStatusCode(statusCode);
		System.out.println(statusCode);
	}

	

	/**
	 * @author ashok
	 * @see this method use to perform StateList response message matches
	 * @param expState
	 * @since 02-06-2023
	 */
	@Then("User verify StateList response message matches {string} and save State id")
	public void user_verify_state_list_response_message_matches_and_save_state_id(String expState) {

		
		StateList_Output_POJO output = response.as(StateList_Output_POJO.class);

		ArrayList<com.POJO.address.State> data = output.getData();

		for (com.POJO.address.State state : data) {

			String name = state.getName();
			

			if (name.equals(expState)) {
				int stateid = state.getId();
				String StateId = String.valueOf(stateid);
				TC1_Login1Step.globalData.setStateId(StateId);

				System.out.println(stateid);			
				break;
			}

		}
		
    
	}


}
