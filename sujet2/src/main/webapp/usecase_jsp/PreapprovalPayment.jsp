<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - Preapproval Payment</title>
<%
	URL currentURL = new URL(request.getRequestURL().toString());
	URL returnURL = new URL(currentURL, "../index.html");
%>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>Preapproval Payment</h3>
			<div id="apidetails">The Pay API operation can use PreapprovalKey, setup between
			  you and sender to transfer funds from a sender's PayPal account to receiver's
				PayPal accounts.</div>
		</div>
		<form method="POST" onsubmit="return check();">
			<div id="request_form">
				<div class="params">
					<div class="param_name">Currency Code*</div>
					<div class="param_value">
						<input type="text" name="currencyCode" value="USD" />
					</div>

					<div class="param_name">Action Type*</div>
					<div class="param_value">
						<input type="text" name="actionType" value="PAY" readonly>
					</div>
					<div class="param_name">Cancel URL*</div>
					<div class="param_value">
						<input type="text" name="cancelURL" value="<%=returnURL%>" />
					</div>
					<div class="param_name">Return URL*</div>
					<div class="param_value">
						<input type="text" name="returnURL" value="<%=returnURL%>" />
					</div>
					<div class="param_name">IPN Notification URL (For receiving
						IPN call back from PayPal)</div>
					<div class="param_value">
						<input type="text" size="50" name="ipnNotificationURL" value="" />
					</div>
					<div class="param_name">
						PreApproval Key(Get PreApproval Key via <a href="Preapprove">Preapproval</a>)
					</div>
					<div class="param_value">
						<input type="text" size="30" id="preapprovalKey" name="preapprovalKey" value="<%=(session.getAttribute("preapprovalKey")!=null)?((String)session.getAttribute("preapprovalKey")):"" %>" />
						<%session.removeAttribute("preapprovalKey"); %>
					</div>
					<div class="section_header">ReceiverList</div>
					<div class="note">Receiver is the party where funds are
						transferred to. </div>
					<table>
						<tr>
							<th class="param_name">Amount*(Double)</th>
							<th class="param_name">E-mail</th>

						</tr>
						<tr>
							<td class="param_value"><input type="text" name="amount"
								value="1.00" />
							</td>
							<td class="param_value"><input type="text" name="mail"
								value="pp15@paypal.com" />
							</td>
						</tr>

					</table>
					<div class="submit">
						<input type="submit" name="PayBtn" value="Pay" />
					</div>
					<br /> 	<a href="paypal.xhtml">Home</a>
				</div>
			</div>
		</form>
		<b>Note:</b>
		<div id="relatedcalls">
			The Payment can be made using <b>preapprovalKey</b>. To obtain preapprovalKey you need to
			make a Preapproval api call and create an agreement between you and sender. 			
		</div>
	</div>
	<script>
		function check(){
			var value = document.getElementById("preapprovalKey").value;
			if(value == ""){
				alert("Please enter Preapproval Key");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>