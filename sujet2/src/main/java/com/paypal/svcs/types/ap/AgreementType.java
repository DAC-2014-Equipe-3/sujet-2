package com.paypal.svcs.types.ap;

/**
 * 
 */
public enum  AgreementType {

	OFFLINE("OFFLINE"),

	ONLINE("ONLINE");

	private String value;

	private AgreementType (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static com.paypal.svcs.types.ap.AgreementType fromValue(String v) {
		for (com.paypal.svcs.types.ap.AgreementType c : values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}