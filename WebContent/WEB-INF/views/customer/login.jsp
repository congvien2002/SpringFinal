<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" />
<spt:url value="/" var="rootpath" />
	<h2 class="text-center mt-50">
		<spt:message code="app.label.first_name" /><spt:message code="app.label.last_name" />
	</h2>
	<hr />
	<c:if test="${msgOk != null}">
		<div class="alert alert-success">
		    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		    <strong>${msgOk}</strong>
		</div>
	</c:if>
	<c:if test="${msgError != null}">
	<div class="alert alert-danger">
	    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	    <strong>${msgError}</strong>
	</div>
	</c:if>
	
	<hr />
	<h2 class="text-center mt-50">
		<spt:message code="app.label.login" />
	</h2>
	<c:if test="${msgErr != null}">
	<div class="alert alert-danger">
	    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	    <strong>${msgErr}</strong>
	</div>
	</c:if>
	<div class = "container form-update form-login">
		<div class="row justify-content-center">
			<div class="col-6 col-lg-6 col-sm-6">
				<form action="${rootpath}customer/login" method="POST">
					<div class="form-group">
						<label for="name"><spt:message code="app.label.account" /></label>
						<input type="text" name="name" class="form-control" placeholder=" Enter here .." required="required"/>
					</div>
					<div class="form-group">
						<label for="passtoken"><spt:message code="app.label.password" /></label>
						<input type="password" name="password" class="form-control" id="passtoken" required="required"/><button class="btn btn-dark" type="button" id="clicktoken">Ẩn/Hiện</button>
					</div>
					<div class="col-6 col-lg-6 col-sm-6 m-auto">
					<button type="submit" class="btn btn-success"><spt:message code="app.label.login" /> </button>
					<button type="button" class="btn btn-warning"><spt:message code="app.label.back" /></button>
					</div>
				</form>
			</div>
		</div>
	</div>
<jsp:include page="../layout/footer.jsp" />