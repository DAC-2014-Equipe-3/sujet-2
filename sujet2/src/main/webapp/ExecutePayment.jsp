<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - ExecutePayment</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>ExecutePayment</h3>
			<div id="apidetails">ExecutePayment API operation lets you
				execute a payment set up with the Pay API operation with the
				actionType CREATE.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">
						Pay Key*(Get PayKey via <a href='Pay'>Pay</a>)
					</div>
					<div class="param_value">
						<input type="text" name="payKey" value="" />
					</div>

				</div>
				<div class="params">
					<div class="param_name">Funding Plan ID</div>
					<div class="param_value">
						<input type="text" name="fundingPlanID" value="" />
					</div>

				</div>
				<div class="param_name">Action Type*</div>
				<div class="param_value">
					<select name="actionType">
						<option value="">--Select a value--</option>
						<option value="PAY">Pay</option>
						<option value="CREATE">Create</option>
						<option value="PAY_PRIMARY">Pay Primary</option>
					</select>
				</div>
				<div class="submit">
					<input type="submit" name="ExecutePaymentBtn"
						value="ExecutePayment" /><br />
				</div>
				<a href="paypal.xhtml">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Pay'>Pay</a></li>
				<li><a href='PaymentDetails'>PaymentDetails</a></li>
				<li><a href='GetPaymentOptions'>GetPaymentOptions</a></li>
				<li><a href='Refund'>Refund</a></li>
				<li><a href='SetPaymentOptions'>SetPaymentOptions</a></li>
			</ul>
		</div>
	</div>
</body>
</html>