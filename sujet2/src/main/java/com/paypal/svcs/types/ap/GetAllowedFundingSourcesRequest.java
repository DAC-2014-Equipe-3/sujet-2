package com.paypal.svcs.types.ap;

import java.io.UnsupportedEncodingException;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;

/**
 * The request to get the allowed funding sources available for
 * a preapproval. 
 */
public class GetAllowedFundingSourcesRequest{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String key;

	

	/**
	 * Constructor with arguments
	 */
	public GetAllowedFundingSourcesRequest (RequestEnvelope requestEnvelope, String key){
		this.requestEnvelope = requestEnvelope;
		this.key = key;
	}	

	/**
	 * Default Constructor
	 */
	public GetAllowedFundingSourcesRequest (){
	}	

	/**
	 * Getter for requestEnvelope
	 */
	 public RequestEnvelope getRequestEnvelope() {
	 	return requestEnvelope;
	 }
	 
	/**
	 * Setter for requestEnvelope
	 */
	 public void setRequestEnvelope(RequestEnvelope requestEnvelope) {
	 	this.requestEnvelope = requestEnvelope;
	 }
	 
	/**
	 * Getter for key
	 */
	 public String getKey() {
	 	return key;
	 }
	 
	/**
	 * Setter for key
	 */
	 public void setKey(String key) {
	 	this.key = key;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.requestEnvelope != null) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(this.requestEnvelope.toNVPString(newPrefix));
		}
		if (this.key != null) {
			sb.append(prefix).append("key=").append(NVPUtil.encodeUrl(this.key));
			sb.append("&");
		}
		return sb.toString();
	}

}