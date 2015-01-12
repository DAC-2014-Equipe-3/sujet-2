package com.paypal.svcs.types.ap;

/**
 * 
 */
public enum  PhoneType {

	NONE("NONE"),

	HOME("HOME"),

	WORK("WORK"),

	BUSINESS("BUSINESS"),

	MOBILE("MOBILE"),

	FAXHOME("FAX_HOME"),

	FAXBUSINESS("FAX_BUSINESS");

	private String value;

	private PhoneType (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static com.paypal.svcs.types.ap.PhoneType fromValue(String v) {
		for (com.paypal.svcs.types.ap.PhoneType c : values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}