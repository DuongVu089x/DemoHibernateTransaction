<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="layout/_header.jsp"/>
<style>
.nn-box{
	margin: 0;
	padding: 0;
	font-size: smaller;
	text-align: center;
}
.nn-box .panel{
	margin: 5px;
	position: relative;
}
.nn-box .panel-body img{
	height: 150px;
	max-width: 100%;
}
.nn-box .pull-left{
	margin-left: 5px;
	font-size: 16px;
	color: red;
}
.nn-box .pull-right{
	margin-right: 5px;
}
.nn-box .icon{
	position: absolute;
	top: 0; 
	right: 0;
}
</style>
<h2>PRODUCT LIST</h2>
<div>
	${message}
	<c:forEach var="p" items="${prods}">
	<div class="col-md-4 nn-box">
		<div class="panel panel-default">
			<c:choose>
				<c:when test="${p.special}">
					<img class="icon" src="images/special_icon.gif"> 
				</c:when>
				<c:when test="${p.latest}">
					<img class="icon" src="images/new_icon.gif"> 
				</c:when>
				<c:when test="${p.discount > 0}">
					<img class="icon" src="images/promo_icon.gif"> 
				</c:when>
			</c:choose>		
			<div class="panel-heading">${p.name}</div>
			<div class="panel-body">
				<a href="product/detail/${p.id}.htm">
					<img src="images/products/${p.image}.jpg"> 
				</a>
			</div>
			<div class="panel-footer">
				<div class="row">
					<strong class="pull-left">${p.unitPrice}</strong>
					<img class="add-to-cart pull-right" data-id="${p.id}" 
						src="images/icons/Add to basket.png">
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
</div>

<script>
$(function(){
	$(".add-to-cart").click(function(){
		pid = $(this).attr("data-id");
		$.ajax({
			url:"cart/add.htm?"+Math.random(),
			data:{id: pid},
			dataType:"json",
			success:function(response){
				$(".nn-cart #count").html(response.count);
				$(".nn-cart #amount").html(response.amount);
			}
		});
	});
});
</script>


<jsp:include page="layout/_footer.jsp"/>