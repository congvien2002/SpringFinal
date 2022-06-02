<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/header.jsp" />
<spt:url value="/" var="rootpath" />
<c:if test="${cus != null }">
	<h2 class="text-center">
		<i><spt:message code="app.label.first_name" /> ${cus.name} <spt:message code="app.label.last_name" /></i>
	</h2>
	<div class="container mt-50">
		<div class="row justify-content-center">
			<div class="col-6 col-lg-6 col-sm-6">
				<h3 class="text-center"><spt:message code="app.label.detailcus" /></h3>
				<table class="table table-hover" border="1">
						
					<tr>
						<th><spt:message code="app.label.empname" /></th>
						<td>${cus.name}</td>
					</tr>
					<tr>
						<th><spt:message code="app.label.email" /></th>
						<td>${cus.email}</td>
					</tr>
			
					<tr>
						<th><spt:message code="app.label.phone" /></th>
						<td>${cus.phone}</td>
					</tr>
			
					<tr>
						<th><spt:message code="app.label.address" /></th>
						<td>${cus.address}</td>
					</tr>
			
					<tr>
						<th><spt:message code="app.label.dob" /></th>
						<td><fmt:formatDate dateStyle="FULL" value="${cus.dob}" /></td>
					</tr>
			
					<tr>
						<th><spt:message code="app.label.gender" /></th>
						<td>
							<c:if test="${!cus.gender}">
								<spt:message code="app.label.male" />
							</c:if>
							<c:if test="${cus.gender}">
								<spt:message code="app.label.female" />
							</c:if>
						</td>
					</tr>
			
					<tr>
						<th><spt:message code="app.label.rules" /></th>
						<td>
							<c:if test="${!cus.rules}">
								<spt:message code="app.label.customer" />
							</c:if>
							<c:if test="${cus.rules}">
								<spt:message code="app.label.admin" />
							</c:if>
						</td>
					</tr>
			
					<tr>
						<th><spt:message code="app.label.status" /></th>
						<td>
							<c:if test="${cus.status == 0}">
								<spt:message code="app.label.stt0" />
							</c:if>
							<c:if test="${cus.status == 1}">
								<spt:message code="app.label.stt1" />
							</c:if>
							<c:if test="${cus.status == 2}">
								<spt:message code="app.label.stt2" />
							</c:if>
						</td>
					</tr>
			
				</table>
			</div>
		</div>
		<button class="btn btn-primary ml-50"><a style="color:#fff" href="${rootpath}customer/"><spt:message code="app.label.back" /></a></button>
	</div>
</c:if>
<c:if test="${cus == null}">
	<div class="alert alert-danger">
	    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	    <strong>Oh !!!</strong> Chưa đăng nhập thông tin
	</div>
	<a href="${rootpath}customer/init-login"><button class="btn btn-success mt-50" type="submit" ><spt:message code="app.label.login" /></button></a>
	<button class="btn btn-primary mt-50" ><a style="color:#fff" href="${rootpath}/index.jsp" ><spt:message code="app.label.home" /></a></button>
</c:if>
<jsp:include page="../layout/footer.jsp" />