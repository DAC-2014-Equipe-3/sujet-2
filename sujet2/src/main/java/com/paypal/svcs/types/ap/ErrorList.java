package com.paypal.svcs.types.ap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.paypal.svcs.types.common.ErrorData;

/**
 * 
 */
public class ErrorList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public ErrorList (){
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
	 


	
	public static com.paypal.svcs.types.ap.ErrorList createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.ErrorList errorList = null;
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
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				errorList = (errorList == null) ? new com.paypal.svcs.types.ap.ErrorList() : errorList;
				errorList.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return errorList;
	}
 
}