package com.paypal.svcs.types.ap;

import java.util.Map;

import com.paypal.svcs.types.common.CurrencyType;

/**
 * FeeDisclosure contains the information related to Fees and
 * taxes. 
 */
public class FeeDisclosure{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType fee;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType taxes;

	

	/**
	 * Default Constructor
	 */
	public FeeDisclosure (){
	}	

	/**
	 * Getter for fee
	 */
	 public CurrencyType getFee() {
	 	return fee;
	 }
	 
	/**
	 * Setter for fee
	 */
	 public void setFee(CurrencyType fee) {
	 	this.fee = fee;
	 }
	 
	/**
	 * Getter for taxes
	 */
	 public CurrencyType getTaxes() {
	 	return taxes;
	 }
	 
	/**
	 * Setter for taxes
	 */
	 public void setTaxes(CurrencyType taxes) {
	 	this.taxes = taxes;
	 }
	 


	
	public static com.paypal.svcs.types.ap.FeeDisclosure createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.FeeDisclosure feeDisclosure = null;
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
			
		CurrencyType fee =  CurrencyType.createInstance(map, prefix + "fee", -1);
		if (fee != null) {
			feeDisclosure = (feeDisclosure == null) ? new com.paypal.svcs.types.ap.FeeDisclosure() : feeDisclosure;
			feeDisclosure.setFee(fee);
		}
		CurrencyType taxes =  CurrencyType.createInstance(map, prefix + "taxes", -1);
		if (taxes != null) {
			feeDisclosure = (feeDisclosure == null) ? new com.paypal.svcs.types.ap.FeeDisclosure() : feeDisclosure;
			feeDisclosure.setTaxes(taxes);
		}
		return feeDisclosure;
	}
 
}