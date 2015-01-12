package com.paypal.svcs.types.common;

/**
 * 
 */
public enum  ErrorCategory {

	SYSTEM("System"),

	APPLICATION("Application"),

	REQUEST("Request");

	private String value;

	private ErrorCategory (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static com.paypal.svcs.types.common.ErrorCategory fromValue(String v) {
		for (com.paypal.svcs.types.common.ErrorCategory c : values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}