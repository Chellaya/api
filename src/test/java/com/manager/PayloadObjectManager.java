package com.manager;

import com.address.AddressPayLoad;
import com.product.ProductSearchPayLoad;

/**
 * @author ashok
 * @see this method perform deserializes the JSON into an object of the class
 * @since 02-06-2023
 *
 */
public class PayloadObjectManager {

	private AddressPayLoad addresspayload;
	private ProductSearchPayLoad productpayload;



	/**
	 * @author ashok
	 * @return addresspayload
	 * @since 02-06-2023
	 */
	public AddressPayLoad getAddresspayload() {
		return (addresspayload == null)? addresspayload = new AddressPayLoad() : addresspayload;
	}

	/**
	 * @author ashok
	 * @return productpayload
	 * @since 02-06-2023
	 */
	public ProductSearchPayLoad getProductpayload() {
		return (productpayload == null)? productpayload = new ProductSearchPayLoad() :productpayload;
	}

}
  