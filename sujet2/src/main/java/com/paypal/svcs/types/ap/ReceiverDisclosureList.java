package com.paypal.svcs.types.ap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.paypal.svcs.types.ap.ReceiverDisclosure;

/**
 * 
 */
public class ReceiverDisclosureList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<ReceiverDisclosure> receiverDisclosure = new ArrayList<ReceiverDisclosure>();

	

	/**
	 * Default Constructor
	 */
	public ReceiverDisclosureList (){
	}	

	/**
	 * Getter for receiverDisclosure
	 */
	 public List<ReceiverDisclosure> getReceiverDisclosure() {
	 	return receiverDisclosure;
	 }
	 
	/**
	 * Setter for receiverDisclosure
	 */
	 public void setReceiverDisclosure(List<ReceiverDisclosure> receiverDisclosure) {
	 	this.receiverDisclosure = receiverDisclosure;
	 }
	 


	
	public static com.paypal.svcs.types.ap.ReceiverDisclosureList createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.ReceiverDisclosureList receiverDisclosureList = null;
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
			ReceiverDisclosure receiverDisclosure =  ReceiverDisclosure.createInstance(map, prefix + "receiverDisclosure", i);
			if (receiverDisclosure != null) {
				receiverDisclosureList = (receiverDisclosureList == null) ? new com.paypal.svcs.types.ap.ReceiverDisclosureList() : receiverDisclosureList;
				receiverDisclosureList.getReceiverDisclosure().add(receiverDisclosure);
				i++;
			} else {
				break;
			}
		}
		return receiverDisclosureList;
	}
 
}