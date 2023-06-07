package com.step;

import org.testng.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Then;

/**
 * @author ashok
 * @see this class perform common steps
 * @since 02-06-2023
 *
 */
public class CommonStep extends BaseClass {
	
	
	/**
	 * @author ashok
	 *  @see this method perform to verify the Status code
	 * @param expStatusCode (String)
	 * @since 02-06-2023
	 */
	@Then("User verify the Status code is {int}")
	public void user_verify_status_code_is(int expStatusCode) {
	int actStatucCode = TC1_Login1Step.	globalData.setStatusCode(response.getStatusCode());		
	Assert.assertEquals(expStatusCode, actStatucCode,"Verify Status Code");
		
		

	
	}




}
