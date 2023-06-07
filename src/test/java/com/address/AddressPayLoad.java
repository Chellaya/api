package com.address;

import com.POJO.address.AddAddress_Input_POJO;
import com.POJO.address.UpdateAddress_Input_POJO;

/**
 * @author ashok
 * @see this method used to perform AddressPayLoad
 *@since 02-06-2023
 */
public class AddressPayLoad {
	/**
	 * @author ashok
	 * @see this method used to perform addAddressPayload
	 * @param first_name (String)
	 * @param last_name (String)
	 * @param mobile (String)
	 * @param apartment (String)
	 * @param state (int)
	 * @param city (int)
	 * @param country (int)
	 * @param zipcode (String)
	 * @param address (String)
	 * @param address_type (String)
	 * @return addAddress_Input_POJO
	 * @since 02-06-2023
	 */
	public  AddAddress_Input_POJO addAddressPayload(String first_name, String last_name, String mobile, String apartment, int state,
			int city, int country, String zipcode, String address, String address_type) {
		
		AddAddress_Input_POJO addAddress_Input_POJO = new AddAddress_Input_POJO(first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		
		return addAddress_Input_POJO;
				
				
		
	}
	/**
	 * @author ashok
	 * @see this method used to perform updateAddressPayload
	 * @param address_id (String)           
	 * @param first_name   (String) 
	 * @param last_name  (String) 
	 * @param mobile  (String) 
	 * @param apartment  (String) 
	 * @param state (int)
	 * @param city (int)
	 * @param country (int)
	 * @param zipcode  (String) 
	 * @param address  (String) 
	 * @param address_type  (String) 
	 * @return address_Input_POJO
	 * @since 02-06-2023
	 */
	public UpdateAddress_Input_POJO updateAddressPayload(String address_id, String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		
		UpdateAddress_Input_POJO address_Input_POJO = new UpdateAddress_Input_POJO(address_id, first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		
		return address_Input_POJO;
	}



}
