package com.paypal.svcs.types.common;

/**
 * 
 */
public enum  ErrorSeverity {

	ERROR("Error"),

	WARNING("Warning");

	private String value;

	private ErrorSeverity (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static com.paypal.svcs.types.common.ErrorSeverity fromValue(String v) {
		for (com.paypal.svcs.types.common.ErrorSeverity c : values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}