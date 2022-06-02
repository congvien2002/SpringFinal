<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/header.jsp" />
<spt:url value="/" var="rootpath" /> 
<c:if test="${cus !=null && cus.rules}">
	<h2 class="text-center mt-50"> 
		<i><spt:message code="app.label.first_name" /> ${cus.name} <spt:message code="app.label.last_name" /></i>
	</h2>
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
	<div class="container">
		<div class="row"> 
			<div class="col-6 col-lg-6 col-sm-6 ">
				<form class="form" method="get" action="${rootpath}customer/search">
					<div class="row">
					<div class="col-8 col-lg-8 col-sm-8">
						<input type="text" class="form-control" name="search" placeholder="Search ...." /> 
					</div>
					<div class="col-3 col-lg-3 col-sm-3">
						<button type="submit" class="btn btn-primary w-100"><spt:message code="app.label.search" /></button>
					</div>
					</div>
				</form>
				
			</div>
			
			<div class="col-4 col-lg-4 col-sm-4 ">
					<button class="btn btn-warning">
					<a href="${rootpath}customer/init-insert" style="color:#fff">
					<spt:message code="app.label.add" />
					</a></button>
			</div>
		</div>
		<h2 class="text-center m-50"><spt:message code="app.label.listemp" /></h2>
		<table border="1" class="table table-hover table-secondary">
			<tr>
				<th><spt:message code="app.label.id" /></th>
				<th><spt:message code="app.label.empname" /></th>
				<th><spt:message code="app.label.email" /></th>
				<th><spt:message code="app.label.phone" /></th>
				<th><spt:message code="app.label.address" /></th>
				<th><spt:message code="app.label.dob" /></th>
				<th><spt:message code="app.label.gender" /></th>
				<th><spt:message code="app.label.status" /></th>
				<th><spt:message code="app.label.rules" /></th>
				<th><spt:message code="app.label.update" /></th>
				<th><spt:message code="app.label.delete" /></th>
			</tr>
			<c:forEach items="${listCus}" var="c">
				<tr>
					<th>${c.id}</th>
					<td><a href="${rootpath}customer/${c.id}">${c.name}</a></td>
					<td>${c.email}</td>
					<td>${c.phone}</td>
					<td>${c.address}</td>
					<td><fmt:formatDate dateStyle="MEDIUM" value="${c.dob}" /></td>
					<td>
						<c:if test="${!c.gender}">
							<spt:message code="app.label.male" />
						</c:if> 
						<c:if test="${c.gender}">
							<spt:message code="app.label.female" />
						</c:if> 
					</td>
					<td>
						<c:if test="${c.status == 0}">
							<spt:message code="app.label.stt0" />
						</c:if> 
						<c:if test="${c.status == 1}">
							<spt:message code="app.label.stt1" />
						</c:if> 
						<c:if test="${c.status == 2}">
							<spt:message code="app.label.stt2" />
						</c:if>
					</td>
					<td>
						<c:if test="${!c.rules}">
							<spt:message code="app.label.customer" />
						</c:if> 
						<c:if test="${c.rules}">
							<spt:message code="app.label.admin" />
						</c:if> 
					</td>
					<td align="center"><a href="${rootpath}customer/update/${c.id}"><spt:message code="app.label.update" />
					</a></td>
					<td align="center"><a href="${rootpath}customer/delete/${c.id}" onclick="return actionDel('${c.name}')"><spt:message code="app.label.delete" />
					</a></td>
				</tr>
			</c:forEach>
		</table>
		<button class="btn btn-primary"><a href="${rootpath}index.jsp" style="color:#fff"><spt:message code="app.label.home" /></a></button>
	</div>
</c:if>
<c:if test="${cus != null && !cus.rules}">
	<div class="alert alert-danger">
	    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	    <strong>Oh !!!</strong> Bạn không có quyền quản trị viên
	</div>
	<a href="${rootpath}customer/init-login"><button class="btn btn-success mt-50 "><spt:message code="app.label.login" /></button></a>
	<button class="btn btn-primary mt-50" ><a style="color:#fff" href="${rootpath}/index.jsp" ><spt:message code="app.label.home" /></a></button>
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