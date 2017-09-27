$(function(){
	
	$(".add-to-cart").click(function(){
		pid = $(this).attr("data-id");
		$.ajax({
			url:"cart/add/" + pid+ ".htm",
			dataType:"json",
			success:function(response){
				$("#cart-count").html(response.count);
				$("#cart-amount").html(response.amount);
			}
		});
	});
	
	$(".remove-from-cart").click(function(){
		pid = $(this).attr("data-id");
		$.ajax({
			url:"cart/remove/" + pid+ ".htm",
			dataType:"json",
			success:function(response){
				$("#cart-count").html(response.count);
				$("#cart-amount").html(response.amount);
			}
		});
	});
	
});