<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" />
<spt:url value="/" var="rootpath" />
<c:if test="${cus != null }">
	<h2 class="text-center mt-50">
		<i><spt:message code="app.label.first_name" /> ${cus.name} <spt:message code="app.label.last_name" /></i>
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
	<h2 class="text-center"><spt:message code="app.label.updateques" /></h2>
	<div class ="container" >
		<div class="row justify-content-center">
			<div class="col-6 col-lg-6 col-sm-6">
				<form action="${rootpath}question/store" method="POST" enctype="multipart/form-data" >
					<table border="1" class="table">
						<input hidden="hidden" name="id" value="${ques.id}"/>
						<tr>
							<th><label for="description"><spt:message code="app.label.mainques" /></label></th>
							<td><input type="text" class="description form-control"  name="description" id="description" value="${ques.description }"></td>
						</tr>
						<tr>
							<th><spt:message code="app.label.img" /></th>
							<td><input type="file" id="fileUpload" name="fileUpload" /></td>
						</tr>
						<input hidden="hidden" name="total" value="${ques.total}"/>
						<tr>
							<th></th>
							<td>
								<button class="btn btn-danger" type="reset"><spt:message code="app.label.reset" /></button>
								<button class="btn btn-success" type="submit"><spt:message code="app.label.update" /></button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
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