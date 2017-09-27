<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<c:set var="cart" value="${sessionScope['scopedTarget.cart']}" />

<div class="panel panel-default nn-cart">
	<div class="panel-body">
		<img class="col-md-5" src="images/shoppingcart.gif" />
		<ul class="col-md-7">
			<li><span id="count">${cart.count}</span>Items</li>
			<li><span id="amount">${cart.amount}</span></li>
			<li><a href="home/purchase.htm">Purchase</a></li>
		</ul>
	</div>
</div>