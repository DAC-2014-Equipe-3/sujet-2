package com.sample.adaptivepayments;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.exception.*;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.svcs.services.AdaptivePaymentsService;
import com.paypal.svcs.types.ap.ConfirmPreapprovalRequest;
import com.paypal.svcs.types.ap.ConfirmPreapprovalResponse;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.sample.util.Configuration;

/**
 * Servlet implementation class ConfirmPreapprovalServlet
 */
public class ConfirmPreapprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ConfirmPreapprovalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext()
				.getRequestDispatcher("/ConfirmPreapproval.jsp")
				.forward(request, response);
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("url", request.getRequestURI());
		session.setAttribute(
				"relatedUrl",
				"<ul><li><a href='Preapproval'>Preapproval</a></li><li><a href='PreapprovalDetails'>PreapprovalDetails</a></li><li><a href='ConfirmPreapproval'>ConfirmPreapproval</a></li><li><a href='CancelPreapproval'>CancelPreapproval</a></li></ul>");
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		ConfirmPreapprovalRequest req = new ConfirmPreapprovalRequest();
		req.setRequestEnvelope(requestEnvelope);
		//Funding source ID.
		if (request.getParameter("fundingSourceID") != "")
			req.setFundingSourceId(request.getParameter("fundingSourceID"));
		
		if (request.getParameter("pin") != "")
			req.setPin(request.getParameter("pin"));
		/**
		 *  A preapproval key that identifies the preapproval requested. You can use this
		 * key in other Adaptive Payment requests to identify this preapproval.
		 */
		if (request.getParameter("preapprovalKey") != "")
			req.setPreapprovalKey(request.getParameter("preapprovalKey"));
		
		// Configuration map containing signature credentials and other required configuration.
		// For a full list of configuration parameters refer in wiki page
		// (https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters)
		Map<String,String> configurationMap =  Configuration.getAcctAndConfig();
		
		// Creating service wrapper object to make an API call by loading configuration map. 
		AdaptivePaymentsService service = new AdaptivePaymentsService(configurationMap);
		
		response.setContentType("text/html");
		try {
			ConfirmPreapprovalResponse resp = service.confirmPreapproval(req);
			if (resp != null) {
				session.setAttribute("RESPONSE_OBJECT", resp);
				session.setAttribute("lastReq", service.getLastRequest());
				session.setAttribute("lastResp", service.getLastResponse());
				if (resp.getResponseEnvelope().getAck().toString()
						.equalsIgnoreCase("SUCCESS")) {
					Map<Object, Object> map = new LinkedHashMap<Object, Object>();
					map.put("Ack", resp.getResponseEnvelope().getAck());
					
					/** 
					 * Correlation identifier. It is a 13-character, alphanumeric string 
						(for example, db87c705a910e) that is used only by PayPal Merchant Technical Support.
						Note:
	
						You must log and store this data for every response you receive. 
						PayPal Technical Support uses the information to assist with reported issues.
					*/
					map.put("Correlation ID", resp.getResponseEnvelope().getCorrelationId());
					
					/** 
					 *  Date on which the response was sent, for example:
						2012-04-02T22:33:35.774-07:00
						Note:
						You must log and store this data for every response you receive. 
						PayPal Technical Support uses the information to assist with reported issues.
				    */
					map.put("Time Stamp", resp.getResponseEnvelope().getTimestamp());
					session.setAttribute("map", map);
					response.sendRedirect("Response.jsp");
				} else {
					session.setAttribute("Error", resp.getError());
					response.sendRedirect("Error.jsp");
				}
			}
		} catch (SSLConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HttpErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidResponseDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientActionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
