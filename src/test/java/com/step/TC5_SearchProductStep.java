package com.step;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.POJO.Product.SearchProduct_Input_POJO;
import com.POJO.Product.SearchProduct_Output_POJO;
import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.manager.PayloadObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author ashok
 * @see this class used to perform search product 
 * @since 02-06-2023
 *
 */
public class TC5_SearchProductStep extends BaseClass {
	PayloadObjectManager pom = new PayloadObjectManager();
	
	Response response;
	

	/**
	 * @author ashok
	 * @see this method perform user to add header for search product
	 * @since 02-06-2023
	 */
	@Given("User add header for search products")
	public void user_add_header_for_search_products() {
	   
		List<Header>ListHeader = new ArrayList<Header>();

		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Content-Type", "application/json");


		ListHeader.add(h1);
		ListHeader.add(h2);

		Headers head =new Headers(ListHeader);
		addHeaders(head);
		
	}

	/**
	 * @author ashok
	 * @param productName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see this method used to perform user to add request in request body for search product
	 * @since 02-06-2023
	 */
	@When("User add request body for search Product {string}")
	public void user_add_request_body_for_search_product(String productName) throws FileNotFoundException, IOException {
		
		SearchProduct_Input_POJO input = pom.getProductpayload().SearchProduct_Input_POJO(productName);
		addBody(input);

	}

	/**
	 * @author ashok
	 * @see this method user add request type endpoint to search product
	 * @param reqType
	 * @since 02-06-2023
	 */
	@When("User send {string} request for searchProduct endpoint")
	public void user_send_request_for_search_product_endpoint(String reqType) {
		
		response = addReqType(reqType, EndPoints.SEARCHPRODUCT);


	}

	/**
	 * @author ashok
	 * @see in this method user verify status code 
	 * @param expStatusCode
	 * @since 02-06-2023
	 */
	@Then("User Verify the status code is {int}")
	public void user_verify_the_status_code_is(int expStatusCode) {
		int actStatucCode = TC1_Login1Step.	globalData.setStatusCode(expStatusCode);		
		Assert.assertEquals(expStatusCode, actStatucCode,"Verify Status Code");
			

	}

	/**
	 * @author ashok
	 * @see in this method User verify the searchProdct response message matches
	 * @param string
	 * @since 02-06-2023
	 */
	@Then("User verify the searchProdct response message matches {string}")
	public void user_verify_the_search_prodct_response_message_matches(String string) {
		SearchProduct_Output_POJO output = response.as(SearchProduct_Output_POJO.class);
		String message = output.getMessage();
		System.out.println(message);

		Assert.assertEquals(message ,string,"Verify Search Product Success");


	
	}




}
