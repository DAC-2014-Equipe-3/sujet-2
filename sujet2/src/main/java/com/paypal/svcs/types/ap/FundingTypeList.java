package com.paypal.svcs.types.ap;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.paypal.svcs.types.ap.FundingTypeInfo;

/**
 * 
 */
public class FundingTypeList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<FundingTypeInfo> fundingTypeInfo = new ArrayList<FundingTypeInfo>();

	

	/**
	 * Constructor with arguments
	 */
	public FundingTypeList (List<FundingTypeInfo> fundingTypeInfo){
		this.fundingTypeInfo = fundingTypeInfo;
	}	

	/**
	 * Default Constructor
	 */
	public FundingTypeList (){
	}	

	/**
	 * Getter for fundingTypeInfo
	 */
	 public List<FundingTypeInfo> getFundingTypeInfo() {
	 	return fundingTypeInfo;
	 }
	 
	/**
	 * Setter for fundingTypeInfo
	 */
	 public void setFundingTypeInfo(List<FundingTypeInfo> fundingTypeInfo) {
	 	this.fundingTypeInfo = fundingTypeInfo;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.fundingTypeInfo != null) {
			for(int i=0; i < this.fundingTypeInfo.size(); i++) {
				String newPrefix = prefix + "fundingTypeInfo" + "(" + i + ").";
				sb.append(this.fundingTypeInfo.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}
	
	public static com.paypal.svcs.types.ap.FundingTypeList createInstance(Map<String, String> map, String prefix, int index) {
		com.paypal.svcs.types.ap.FundingTypeList fundingTypeList = null;
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
			FundingTypeInfo fundingTypeInfo =  FundingTypeInfo.createInstance(map, prefix + "fundingTypeInfo", i);
			if (fundingTypeInfo != null) {
				fundingTypeList = (fundingTypeList == null) ? new com.paypal.svcs.types.ap.FundingTypeList() : fundingTypeList;
				fundingTypeList.getFundingTypeInfo().add(fundingTypeInfo);
				i++;
			} else {
				break;
			}
		}
		return fundingTypeList;
	}
 
}