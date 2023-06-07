
package com.step;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

/**
 * @author ashok
 * @see this class used to perform us to reduce the code redundancy
 * @since02-06-2023
 *
 */
public class HooksClass extends BaseClass {

  Scenario scenario;
	@After
	public void afterScenario(Scenario sc) {
		
		scenario =  sc;
		scenario.log(getAsPreetyString(response));
		
		
	}
	
	
}
