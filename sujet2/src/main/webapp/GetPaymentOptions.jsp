<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adaptive Payments - GetPaymentOptions</title>
</head>
<body>
	<img src="https://devtools-paypal.com/image/bdg_payments_by_pp_2line.png" alt="PAYMENTS BY PayPal" />
	<div id="wrapper">
		<div id="header">
			<h3>GetPaymentOptions</h3>
			<div id="apidetails">GetPaymentOptions API operation is used to
				retrieve the payment options passed with the
				SetPaymentOptionsRequest.</div>
		</div>
		<form method="POST">
			<div id="request_form">
				<div class="params">
					<div class="param_name">
						Pay Key(Get PayKey via <a href='Pay'>Pay</a>)
					</div>
					<div class="param_value">
						<input type="text" name="payKey" value="" />
					</div>
				</div>
				<div class="submit">
					<input type="submit" name="GetPaymentOptionsBtn"
						value="GetPaymentOptions" /><br />
				</div>
				<a href="paypal.xhtml">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li><a href='Pay'>Pay</a></li>
				<li><a href='Refund'>Refund</a></li>
				<li><a href='PaymentDetails'>PaymentDetails</a></li>
				<li><a href='ExecutePayment'>ExecutePayment</a></li>
				<li><a href='SetPaymentOptions'>SetPaymentOptions</a></li>
			</ul>
		</div>
	</div>
</body>
</html>