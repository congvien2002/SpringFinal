<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" />
<spt:url value="/" var="rootpath" />
<c:if test="${cus != null}">
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
	
	<div class="container">
		<h2 class="text-center">
			<spt:message code="app.label.insert" />
		</h2>
		<div class="row justify-content-center">
			<div class="col-6 col-lg-6 col-sm-6 mt-50">
				<spf:form action="${rootpath}answer/insert" method="POST"
					modelAttribute="ans" >
					<table border="1" class="table table-hover">
					<spf:hidden path="ques.id" value="${quesid}"/>
						<tr>
							<th><spt:message code="app.label.mainans" /></th>
							<td><spf:textarea cols="15" rows="5" path="description" />
							<spf:errors path="description" cssClass="boxError" />
							</td>
							
						</tr>
						<tr>
							<th></th>
							<td><spf:hidden path="count" value="0"/></td>
						</tr>
			
						<tr>
							<th></th>
							<td>
								<button type="button" class="btn btn-warning"><a style="color:#fff" href="${rootpath}question/"><spt:message code="app.label.back" /></a></button>
								<button type="submit" class="btn btn-success"><spt:message code="app.label.confirm" /></button>
							</td>
						</tr>
					</table>
				</spf:form>
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