package com.paypal.svcs.types.ap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;

/**
 * The result of the ConfirmPreapprovalRequest. 
 */
public class ConfirmPreapprovalResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public ConfirmPreapprovalResponse (){
	}	

	/**
	 * Getter for responseEnvelope
	 */
	 public ResponseEnvelope getResponseEnvelope() {
	 	return responseEnvelope;
	 }
	 
	/**
	 * Setter for responseEnvelope
	 */
	 public void setResponseEnvelope(ResponseEnvelope responseEnvelope) {
	 	this.responseEnvelope = responseEnvelope;
	 }
	 
	/**
	 * Getter for error
	 */
	 public List<ErrorData> getError() {
	 	return error;
	 }
	 
	/**
	 * Setter for error
	 */
	 public void setError(List<ErrorData> error) {
	 	this.error = error;
	 }
	 


	
	public static com.paypal.svcs.types.ap.ConfirmPreapprovalResponse createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.ConfirmPreapprovalResponse confirmPreapprovalResponse = null;
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
			
		ResponseEnvelope responseEnvelope =  ResponseEnvelope.createInstance(map, prefix + "responseEnvelope", -1);
		if (responseEnvelope != null) {
			confirmPreapprovalResponse = (confirmPreapprovalResponse == null) ? new com.paypal.svcs.types.ap.ConfirmPreapprovalResponse() : confirmPreapprovalResponse;
			confirmPreapprovalResponse.setResponseEnvelope(responseEnvelope);
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				confirmPreapprovalResponse = (confirmPreapprovalResponse == null) ? new com.paypal.svcs.types.ap.ConfirmPreapprovalResponse() : confirmPreapprovalResponse;
				confirmPreapprovalResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return confirmPreapprovalResponse;
	}
 
}