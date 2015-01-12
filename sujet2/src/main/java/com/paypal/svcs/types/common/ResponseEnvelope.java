package com.paypal.svcs.types.common;

import java.util.Map;

import com.paypal.svcs.types.common.AckCode;

/**
 * This specifies a list of parameters with every response from
 * a service. 
 */
public class ResponseEnvelope{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private String timestamp;

	/**
	 * Application level acknowledgment code. 	  
	 *@Required	 
	 */ 
	private AckCode ack;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String correlationId;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String build;

	

	/**
	 * Default Constructor
	 */
	public ResponseEnvelope (){
	}	

	/**
	 * Getter for timestamp
	 */
	 public String getTimestamp() {
	 	return timestamp;
	 }
	 
	/**
	 * Setter for timestamp
	 */
	 public void setTimestamp(String timestamp) {
	 	this.timestamp = timestamp;
	 }
	 
	/**
	 * Getter for ack
	 */
	 public AckCode getAck() {
	 	return ack;
	 }
	 
	/**
	 * Setter for ack
	 */
	 public void setAck(AckCode ack) {
	 	this.ack = ack;
	 }
	 
	/**
	 * Getter for correlationId
	 */
	 public String getCorrelationId() {
	 	return correlationId;
	 }
	 
	/**
	 * Setter for correlationId
	 */
	 public void setCorrelationId(String correlationId) {
	 	this.correlationId = correlationId;
	 }
	 
	/**
	 * Getter for build
	 */
	 public String getBuild() {
	 	return build;
	 }
	 
	/**
	 * Setter for build
	 */
	 public void setBuild(String build) {
	 	this.build = build;
	 }
	 


	
	public static com.paypal.svcs.types.common.ResponseEnvelope createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.common.ResponseEnvelope responseEnvelope = null;
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
			
		if (map.containsKey(prefix + "timestamp")) {
				responseEnvelope = (responseEnvelope == null) ? new com.paypal.svcs.types.common.ResponseEnvelope() : responseEnvelope;
				responseEnvelope.setTimestamp(map.get(prefix + "timestamp"));
		}
		if (map.containsKey(prefix + "ack")) {
				responseEnvelope = (responseEnvelope == null) ? new com.paypal.svcs.types.common.ResponseEnvelope() : responseEnvelope;
				responseEnvelope.setAck(AckCode.fromValue(map.get(prefix + "ack")));
		}
		if (map.containsKey(prefix + "correlationId")) {
				responseEnvelope = (responseEnvelope == null) ? new com.paypal.svcs.types.common.ResponseEnvelope() : responseEnvelope;
				responseEnvelope.setCorrelationId(map.get(prefix + "correlationId"));
		}
		if (map.containsKey(prefix + "build")) {
				responseEnvelope = (responseEnvelope == null) ? new com.paypal.svcs.types.common.ResponseEnvelope() : responseEnvelope;
				responseEnvelope.setBuild(map.get(prefix + "build"));
		}
		return responseEnvelope;
	}
 
}