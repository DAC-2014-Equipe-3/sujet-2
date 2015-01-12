package com.paypal.svcs.types.ap;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.paypal.svcs.types.ap.FundingTypeList;

/**
 * 
 */
public class FundingConstraint{


	/**
	 * 	 
	 */ 
	private FundingTypeList allowedFundingType;

	

	/**
	 * Default Constructor
	 */
	public FundingConstraint (){
	}	

	/**
	 * Getter for allowedFundingType
	 */
	 public FundingTypeList getAllowedFundingType() {
	 	return allowedFundingType;
	 }
	 
	/**
	 * Setter for allowedFundingType
	 */
	 public void setAllowedFundingType(FundingTypeList allowedFundingType) {
	 	this.allowedFundingType = allowedFundingType;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.allowedFundingType != null) {
			String newPrefix = prefix + "allowedFundingType.";
			sb.append(this.allowedFundingType.toNVPString(newPrefix));
		}
		return sb.toString();
	}
	
	public static com.paypal.svcs.types.ap.FundingConstraint createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.FundingConstraint fundingConstraint = null;
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
			
		FundingTypeList allowedFundingType =  FundingTypeList.createInstance(map, prefix + "allowedFundingType", -1);
		if (allowedFundingType != null) {
			fundingConstraint = (fundingConstraint == null) ? new com.paypal.svcs.types.ap.FundingConstraint() : fundingConstraint;
			fundingConstraint.setAllowedFundingType(allowedFundingType);
		}
		return fundingConstraint;
	}
 
}