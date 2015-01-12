package com.paypal.svcs.types.ap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.paypal.svcs.types.ap.CurrencyConversionList;

/**
 * A table that contains a list of estimated currency
 * conversions for a base currency in each row. 
 */
public class CurrencyConversionTable{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<CurrencyConversionList> currencyConversionList = new ArrayList<CurrencyConversionList>();

	

	/**
	 * Default Constructor
	 */
	public CurrencyConversionTable (){
	}	

	/**
	 * Getter for currencyConversionList
	 */
	 public List<CurrencyConversionList> getCurrencyConversionList() {
	 	return currencyConversionList;
	 }
	 
	/**
	 * Setter for currencyConversionList
	 */
	 public void setCurrencyConversionList(List<CurrencyConversionList> currencyConversionList) {
	 	this.currencyConversionList = currencyConversionList;
	 }
	 


	
	public static com.paypal.svcs.types.ap.CurrencyConversionTable createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.CurrencyConversionTable currencyConversionTable = null;
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
			
		i = 0;
		while(true) {
			CurrencyConversionList currencyConversionList =  CurrencyConversionList.createInstance(map, prefix + "currencyConversionList", i);
			if (currencyConversionList != null) {
				currencyConversionTable = (currencyConversionTable == null) ? new com.paypal.svcs.types.ap.CurrencyConversionTable() : currencyConversionTable;
				currencyConversionTable.getCurrencyConversionList().add(currencyConversionList);
				i++;
			} else {
				break;
			}
		}
		return currencyConversionTable;
	}
 
}