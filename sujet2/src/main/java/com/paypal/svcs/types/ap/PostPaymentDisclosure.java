package com.paypal.svcs.types.ap;

import java.util.Map;

import com.paypal.svcs.types.ap.StateRegulatoryAgencyInfo;
import com.paypal.svcs.types.common.AccountIdentifier;

/**
 * Contains information related to Post Payment Disclosure
 * Details This contains 1.Receivers information 2.Funds
 * Avalibility Date 3.State Regulatory Agency Information 
 */
public class PostPaymentDisclosure{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private AccountIdentifier accountIdentifier;

	/**
	 * 	 
	 */ 
	private String fundsAvailabilityDate;

	/**
	 * 	 
	 */ 
	private String fundsAvailabilityDateDisclaimerText;

	/**
	 * 	 
	 */ 
	private StateRegulatoryAgencyInfo stateRegulatoryAgencyInfo;

	

	/**
	 * Default Constructor
	 */
	public PostPaymentDisclosure (){
	}	

	/**
	 * Getter for accountIdentifier
	 */
	 public AccountIdentifier getAccountIdentifier() {
	 	return accountIdentifier;
	 }
	 
	/**
	 * Setter for accountIdentifier
	 */
	 public void setAccountIdentifier(AccountIdentifier accountIdentifier) {
	 	this.accountIdentifier = accountIdentifier;
	 }
	 
	/**
	 * Getter for fundsAvailabilityDate
	 */
	 public String getFundsAvailabilityDate() {
	 	return fundsAvailabilityDate;
	 }
	 
	/**
	 * Setter for fundsAvailabilityDate
	 */
	 public void setFundsAvailabilityDate(String fundsAvailabilityDate) {
	 	this.fundsAvailabilityDate = fundsAvailabilityDate;
	 }
	 
	/**
	 * Getter for fundsAvailabilityDateDisclaimerText
	 */
	 public String getFundsAvailabilityDateDisclaimerText() {
	 	return fundsAvailabilityDateDisclaimerText;
	 }
	 
	/**
	 * Setter for fundsAvailabilityDateDisclaimerText
	 */
	 public void setFundsAvailabilityDateDisclaimerText(String fundsAvailabilityDateDisclaimerText) {
	 	this.fundsAvailabilityDateDisclaimerText = fundsAvailabilityDateDisclaimerText;
	 }
	 
	/**
	 * Getter for stateRegulatoryAgencyInfo
	 */
	 public StateRegulatoryAgencyInfo getStateRegulatoryAgencyInfo() {
	 	return stateRegulatoryAgencyInfo;
	 }
	 
	/**
	 * Setter for stateRegulatoryAgencyInfo
	 */
	 public void setStateRegulatoryAgencyInfo(StateRegulatoryAgencyInfo stateRegulatoryAgencyInfo) {
	 	this.stateRegulatoryAgencyInfo = stateRegulatoryAgencyInfo;
	 }
	 


	
	public static com.paypal.svcs.types.ap.PostPaymentDisclosure createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.PostPaymentDisclosure postPaymentDisclosure = null;
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
			
		AccountIdentifier accountIdentifier =  AccountIdentifier.createInstance(map, prefix + "accountIdentifier", -1);
		if (accountIdentifier != null) {
			postPaymentDisclosure = (postPaymentDisclosure == null) ? new com.paypal.svcs.types.ap.PostPaymentDisclosure() : postPaymentDisclosure;
			postPaymentDisclosure.setAccountIdentifier(accountIdentifier);
		}
		if (map.containsKey(prefix + "fundsAvailabilityDate")) {
				postPaymentDisclosure = (postPaymentDisclosure == null) ? new com.paypal.svcs.types.ap.PostPaymentDisclosure() : postPaymentDisclosure;
				postPaymentDisclosure.setFundsAvailabilityDate(map.get(prefix + "fundsAvailabilityDate"));
		}
		if (map.containsKey(prefix + "fundsAvailabilityDateDisclaimerText")) {
				postPaymentDisclosure = (postPaymentDisclosure == null) ? new com.paypal.svcs.types.ap.PostPaymentDisclosure() : postPaymentDisclosure;
				postPaymentDisclosure.setFundsAvailabilityDateDisclaimerText(map.get(prefix + "fundsAvailabilityDateDisclaimerText"));
		}
		StateRegulatoryAgencyInfo stateRegulatoryAgencyInfo =  StateRegulatoryAgencyInfo.createInstance(map, prefix + "stateRegulatoryAgencyInfo", -1);
		if (stateRegulatoryAgencyInfo != null) {
			postPaymentDisclosure = (postPaymentDisclosure == null) ? new com.paypal.svcs.types.ap.PostPaymentDisclosure() : postPaymentDisclosure;
			postPaymentDisclosure.setStateRegulatoryAgencyInfo(stateRegulatoryAgencyInfo);
		}
		return postPaymentDisclosure;
	}
 
}