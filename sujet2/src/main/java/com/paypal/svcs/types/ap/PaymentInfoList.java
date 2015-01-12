package com.paypal.svcs.types.ap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.paypal.svcs.types.ap.PaymentInfo;

/**
 * 
 */
public class PaymentInfoList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<PaymentInfo> paymentInfo = new ArrayList<PaymentInfo>();

	

	/**
	 * Default Constructor
	 */
	public PaymentInfoList (){
	}	

	/**
	 * Getter for paymentInfo
	 */
	 public List<PaymentInfo> getPaymentInfo() {
	 	return paymentInfo;
	 }
	 
	/**
	 * Setter for paymentInfo
	 */
	 public void setPaymentInfo(List<PaymentInfo> paymentInfo) {
	 	this.paymentInfo = paymentInfo;
	 }
	 


	
	public static com.paypal.svcs.types.ap.PaymentInfoList createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.PaymentInfoList paymentInfoList = null;
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
			PaymentInfo paymentInfo =  PaymentInfo.createInstance(map, prefix + "paymentInfo", i);
			if (paymentInfo != null) {
				paymentInfoList = (paymentInfoList == null) ? new com.paypal.svcs.types.ap.PaymentInfoList() : paymentInfoList;
				paymentInfoList.getPaymentInfo().add(paymentInfo);
				i++;
			} else {
				break;
			}
		}
		return paymentInfoList;
	}
 
}