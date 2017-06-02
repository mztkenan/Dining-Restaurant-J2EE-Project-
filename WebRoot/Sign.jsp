<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Home</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Deliccio Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='https://fonts.googleapis.com/css?family=UnifrakturMaguntia' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:600,600italic,700,400' rel='stylesheet' type='text/css'>
<!-- FlexSlider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script defer src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
						$(window).load(function(){
						  $('.flexslider').flexslider({
							animation: "slide",
							start: function(slider){
							  $('body').removeClass('loading');
							}
						  });
						});
					  </script>
<!-- //FlexSlider -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>

<body>
<!-- banner -->
	<div class="banner">
		<div class="container">
			<div class="header-nav">
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
					  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					  </button>
						<div class="logo">
							<a class="navbar-brand" href="index.html">点点订餐</a>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					 <ul class="nav navbar-nav">
						<li class="active"><a href="Sign.jsp">主页</a></li>
						<li><a href="Menu.jsp">菜单</a></li>
						<li><a href="shopCart.jsp">购物车</a></li>
						<li><a href="MyOrder.jsp">订单</a></li>
						<li><a href="contact.html">关于我们</a></li>
					  </ul>
					</div><!-- /.navbar-collapse -->
				</nav>
			</div>
			<div class="banner-info">
				<div class="col-md-6 banner-info-right">
					<div class="sap_tabs">	
						<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
							<ul class="resp-tabs-list">
							  <li class="resp-tab-item grid1" aria-controls="tab_item-0" role="tab"><span>登录</span></li>
							  <li class="resp-tab-item grid2" aria-controls="tab_item-1" role="tab"><span>注册</span></li>
							  <div class="clear"></div>
							</ul>				  	 
							<div class="resp-tabs-container">
								<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
									<div class="facts">
										<div class="sign-in-form">
											<div class="in-form">
												<form action="UserLogIn" method="get">
													<input type="text" name="loginname" placeholder="Username" required>
													<input type="password" name="loginpassword" placeholder="Password" required>												
												<div class="ckeck-bg">
													<div class="checkbox-form">
														<div class="check-right">
															<input type="submit" value="登录">
														</div>
														<div class="clearfix"> </div>
													</div>
												</div>
												</form> 
											</div>
										</div>
									</div>
								</div>
								<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts">
										<div class="sign-in-form">
											<div class="in-form Personal">
												<h4>个 人 信 息</h4>
												<form action="UserSignUp" method="get">
													<input type="text" name="userName" class="textbox" value="Enter your name here..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter your name here...';}">
													<!--  <input type="text" class="textbox" value="Enter your email here..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}">
													-->
												
												<h5>登 录 信 息</h5>
												
												    <input type="password" name="passWord" class="password" value="Enter your password..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
												    <input type="password" name="passWord2" class="password" value="Enter your password..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
													<input type="submit" value="submit">
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
						<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
							<script type="text/javascript">
								$(document).ready(function () {
									$('#horizontalTab').easyResponsiveTabs({
										type: 'default', //Types: default, vertical, accordion           
										width: 'auto', //auto or any width like 600px
										fit: true   // 100% fit in a container
									});
								});
							</script>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //banner -->
<!--footer-->
	<div class="footer-bottom">
		<div class="container">		
			<p>Copyright &copy; 2017.Lengendary All rights reserved.</p>					
		</div>
	</div>
<!-- //menu -->
<!--footer-->
	<div class="footer-bottom">
		<div class="container">		
			<p>Copyright &copy; 2017.Lengendary All rights reserved.</p>					
		</div>
	</div>
<!--//footer-->	
<!-- for bootstrap working -->
		<script src="js/bootstrap.js"> </script>
<!-- //for bootstrap working -->
</body>
</html>