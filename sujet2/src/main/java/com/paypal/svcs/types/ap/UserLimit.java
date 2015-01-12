package com.paypal.svcs.types.ap;

import java.util.Map;

import com.paypal.svcs.types.common.CurrencyType;

/**
 * 
 */
public class UserLimit{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private String limitType;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType limitAmount;

	

	/**
	 * Default Constructor
	 */
	public UserLimit (){
	}	

	/**
	 * Getter for limitType
	 */
	 public String getLimitType() {
	 	return limitType;
	 }
	 
	/**
	 * Setter for limitType
	 */
	 public void setLimitType(String limitType) {
	 	this.limitType = limitType;
	 }
	 
	/**
	 * Getter for limitAmount
	 */
	 public CurrencyType getLimitAmount() {
	 	return limitAmount;
	 }
	 
	/**
	 * Setter for limitAmount
	 */
	 public void setLimitAmount(CurrencyType limitAmount) {
	 	this.limitAmount = limitAmount;
	 }
	 


	
	public static com.paypal.svcs.types.ap.UserLimit createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.UserLimit userLimit = null;
		int i = 0;
		if (index != -1) {
				if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
					prefix = prefix + "(" + index + ").";
				}
		} else {
			if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
				prefix = prefix + ".";
			}
		}
			
		if (map.containsKey(prefix + "limitType")) {
				userLimit = (userLimit == null) ? new com.paypal.svcs.types.ap.UserLimit() : userLimit;
				userLimit.setLimitType(map.get(prefix + "limitType"));
		}
		CurrencyType limitAmount =  CurrencyType.createInstance(map, prefix + "limitAmount", -1);
		if (limitAmount != null) {
			userLimit = (userLimit == null) ? new com.paypal.svcs.types.ap.UserLimit() : userLimit;
			userLimit.setLimitAmount(limitAmount);
		}
		return userLimit;
	}
 
}