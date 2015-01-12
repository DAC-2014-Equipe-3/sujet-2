package com.paypal.svcs.types.ap;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.paypal.svcs.types.common.AccountIdentifier;

/**
 * The sender identifier type contains information to identify
 * a PayPal account. 
 */
public class ReceiverIdentifier extends AccountIdentifier {


	

	/**
	 * Default Constructor
	 */
	public ReceiverIdentifier (){
	}	



	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toNVPString(prefix));
		return sb.toString();
	}
	
	public static com.paypal.svcs.types.ap.ReceiverIdentifier createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.ReceiverIdentifier receiverIdentifier = null;
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
		AccountIdentifier accountIdentifier = AccountIdentifier.createInstance(map, prefix, -1);
		if (accountIdentifier != null) {
			receiverIdentifier = (receiverIdentifier == null) ? new com.paypal.svcs.types.ap.ReceiverIdentifier() : receiverIdentifier;
			receiverIdentifier.setEmail(accountIdentifier.getEmail());
			receiverIdentifier.setPhone(accountIdentifier.getPhone());
			receiverIdentifier.setAccountId(accountIdentifier.getAccountId());
		}
			
		return receiverIdentifier;
	}
 
}