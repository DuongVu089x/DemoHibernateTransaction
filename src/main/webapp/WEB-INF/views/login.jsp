<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/">

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Spring MVC & Hibernate</title>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>

<link href="css/jquery-ui.min.css" rel="stylesheet" />
<script src="js/jquery-ui.min.js"></script>

<link href="css/bootstrap.min.css" rel="stylesheet" />
<script src="js/bootstrap.min.js"></script>
<script src="js/login.js"></script>

<style>
.nn-box {
	margin: 0;
	padding: 0;
	font-size: smaller;
	text-align: center;
}

.nn-box .panel {
	margin: 5px;
	position: relative;
}

.nn-box .panel-body img {
	height: 150px;
	max-width: 100%;
}

.nn-box .pull-left {
	margin-left: 5px;
	font-size: 16px;
	color: red;
}

.nn-box .pull-right {
	margin-right: 5px;
}

.nn-box .icon {
	position: absolute;
	top: 0;
	right: 0;
}

p.text-center.solution, .error p {
	color: red;
	background: antiquewhite;
	margin: 10px 0;
	padding: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<header class="nn-header row">
			<h1 class="nn-company">Java Technology Suite</h1>
			<h5 class="nn-slogan">The center point of the professional
				programming</h5>
		</header>

		<div class="navbar navbar-inverse row">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
		</div>

		<div class="nn-sheet row">
			<article class="col-md-9">
				<div class="nn-body">
					<div class="login-page">
						<div class="container">
							<div class="row">
								<div class="col-sm-6 col-md-4 col-md-offset-4">
									<div class="panel panel-default">
										<div class="panel-heading">
											<strong> Sign in to continue</strong>
										</div>
										<div class="panel-body">
											<ul class="nav nav-tabs" role="tablist">
												<li class="active" id="tab-low"><a href="#low"
													role="tab" data-toggle="tab">Low</a></li>
												<li id="tab-medium"><a href="#medium" role="tab"
													data-toggle="tab">Medium</a></li>
												<li id="tab-high"><a href="#high" role="tab"
													data-toggle="tab">High</a></li>
												<li id="tab-impossible"><a href="#impossible"
													role="tab" data-toggle="tab">Impossible</a></li>
											</ul>
											<div class="tab-content">
												<div class="tab-pane active" id="low">
													<h4 class="text-center">Low</h4>
													<form:form method="POST" commandName="userFormLow"
														class="form-signin" action="login/low.htm">
														<spring:bind path="username">
															<div
																class="form-group ${status.error ? 'has-error' : ''}">
																<form:input type="text" path="username"
																	class="form-control" placeholder="Username"
																	autofocus="true" />
																<form:errors path="username"></form:errors>
															</div>
														</spring:bind>

														<spring:bind path="password">
															<div
																class="form-group ${status.error ? 'has-error' : ''}">
																<form:input type="password" path="password"
																	class="form-control" placeholder="Password" />
																<form:errors path="password"></form:errors>
															</div>
														</spring:bind>

														<button class="btn btn-lg btn-primary btn-block"
															type="submit">Low Submit</button>
													</form:form>
													<p class="text-center solution">
														Don't have check in client <br /> SQL injection ' OR 1 =
														'1
													</p>
													<p class="text-center">${userlow.username}</p>
												</div>
												<div class="tab-pane" id="medium">
													<h4 class="text-center">Medium</h4>
													<form:form method="POST" commandName="userFormMedium"
														class="form-signin" action="login/medium.htm"
														onsubmit="return confirmForMedium();">
														<spring:bind path="username">
															<div
																class="form-group ${status.error ? 'has-error' : ''}">
																<form:input type="text" path="username"
																	class="form-control" placeholder="Username"
																	autofocus="true" />
																<form:errors path="username"></form:errors>
															</div>
															<div class="error" id="error-username"></div>
														</spring:bind>
														<spring:bind path="password">
															<div
																class="form-group ${status.error ? 'has-error' : ''}">
																<form:input type="password" path="password"
																	class="form-control" placeholder="Password" />
																<form:errors path="password"></form:errors>
																<div class="error" id="error-password"></div>
															</div>
														</spring:bind>
														<button class="btn btn-lg btn-primary btn-block"
															type="submit">Medium Submit</button>
													</form:form>
													<p class="text-center solution">
														Have check null in client <br /> but not check special
														characters <br /> SQL injection ' OR 1 = '1
													</p>
													<p class="text-center">${usermedium.username}</p>
												</div>
												<div class="tab-pane" id="high">
													<h4 class="text-center">High</h4>
													<form:form method="POST" commandName="userFormHigh"
														class="form-signin" action="login/high.htm">
														<spring:bind path="username">
															<div
																class="form-group ${status.error ? 'has-error' : ''}">
																<form:input type="text" path="username"
																	class="form-control" placeholder="Username"
																	autofocus="true" />
																<form:errors path="username"></form:errors>
															</div>
														</spring:bind>
														<spring:bind path="password">
															<div
																class="form-group ${status.error ? 'has-error' : ''}">
																<form:input type="password" path="password"
																	class="form-control" placeholder="Password" />
																<form:errors path="password"></form:errors>
															</div>
														</spring:bind>
														<button class="btn btn-lg btn-primary btn-block"
															type="submit">High Submit</button>
													</form:form>
													<p class="text-center">${userhigh.username}</p>
												</div>
												<div class="tab-pane" id="impossible">
													<h4 class="text-center">Impossible</h4>
													<form:form method="POST"
														commandName="userFormImpossible" class="form-signin"
														action="login/impossible.htm">
														<spring:bind path="username">
															<div
																class="form-group ${status.error ? 'has-error' : ''}">
																<form:input type="text" path="username"
																	class="form-control" placeholder="Username"
																	autofocus="true" />
																<form:errors path="username"></form:errors>
															</div>
														</spring:bind>
														<spring:bind path="password">
															<div
																class="form-group ${status.error ? 'has-error' : ''}">
																<form:input type="password" path="password"
																	class="form-control" placeholder="Password" />
																<form:errors path="password"></form:errors>
															</div>
														</spring:bind>
														<button class="btn btn-lg btn-primary btn-block"
															type="submit">Impossible Submit</button>
													</form:form>
													<p class="text-center">${userimpossible.username}</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</article>
		</div>
		<footer class="row" style="text-align: center">
			<p>DAV &copy; 2015. All rights reserved.</p>
		</footer>
	</div>
</body>
</html>