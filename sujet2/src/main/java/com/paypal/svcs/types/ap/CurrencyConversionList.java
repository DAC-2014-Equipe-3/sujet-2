package com.paypal.svcs.types.ap;

import java.util.Map;

import com.paypal.svcs.types.ap.CurrencyList;
import com.paypal.svcs.types.common.CurrencyType;

/**
 * A list of estimated currency conversions for a base
 * currency. 
 */
public class CurrencyConversionList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType baseAmount;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyList currencyList;

	

	/**
	 * Default Constructor
	 */
	public CurrencyConversionList (){
	}	

	/**
	 * Getter for baseAmount
	 */
	 public CurrencyType getBaseAmount() {
	 	return baseAmount;
	 }
	 
	/**
	 * Setter for baseAmount
	 */
	 public void setBaseAmount(CurrencyType baseAmount) {
	 	this.baseAmount = baseAmount;
	 }
	 
	/**
	 * Getter for currencyList
	 */
	 public CurrencyList getCurrencyList() {
	 	return currencyList;
	 }
	 
	/**
	 * Setter for currencyList
	 */
	 public void setCurrencyList(CurrencyList currencyList) {
	 	this.currencyList = currencyList;
	 }
	 


	
	public static com.paypal.svcs.types.ap.CurrencyConversionList createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.CurrencyConversionList currencyConversionList = null;
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
			
		CurrencyType baseAmount =  CurrencyType.createInstance(map, prefix + "baseAmount", -1);
		if (baseAmount != null) {
			currencyConversionList = (currencyConversionList == null) ? new com.paypal.svcs.types.ap.CurrencyConversionList() : currencyConversionList;
			currencyConversionList.setBaseAmount(baseAmount);
		}
		CurrencyList currencyList =  CurrencyList.createInstance(map, prefix + "currencyList", -1);
		if (currencyList != null) {
			currencyConversionList = (currencyConversionList == null) ? new com.paypal.svcs.types.ap.CurrencyConversionList() : currencyConversionList;
			currencyConversionList.setCurrencyList(currencyList);
		}
		return currencyConversionList;
	}
 
}