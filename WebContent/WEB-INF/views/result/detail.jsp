<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/header.jsp" />
<spt:url value="/" var="rootpath" />
<c:if test="${cus != null}">
	<div class="container mt-50">
		<div class="row justify-content-center">
			<h2 class="text-center">
				<i><spt:message code="app.label.first_name" /> ${cus.name} <spt:message code="app.label.last_name" /></i>
			</h2>
		</div>
		<div class="row justify-content-center">
			<div class="col-4 col-lg-4 col-sm-4">
				<h2><spt:message code="app.label.question" /></h2>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-lg-12 col-sm-12">
				 	<div class="checkout__form__input">
			            <h5><spt:message code="app.label.ques"/> ${ques.id} :</h5>
			            <div class="row">
			            	<div class="col-8 col-lg-8 col-sm-8">
			            		<h3>${ques.description}</h3>
			            	</div>
				 		</div>
			            <div class="row	">
			            	<div class="col-6 col-lg-6 col-sm-6 img_ques">
			            		<img src="/Public/${ques.img}" alt="${ques.description} " />
			            	</div>
			            	<div class="col-6 col-lg-6 col-sm-6">
			            		<table class="table table-secondary table-border table-hover" >
			            			<tr>
			            				<th><i>Kết quả :</i></th>
			            			</tr>
			            			 <c:forEach items="${lstA}" var="a">
					           			<c:if test="${a.ques.id == ques.id }">
					           			<tr>
					            			<th><h4>${a.description}</h4></th>
					            			<th><input type="range" value="${a.count}"/> ${ques.total } %</th>
					            		</tr>
					            	</c:if>
					            </c:forEach>
			            		</table>
			            	</div>
			            </div>
						
			        </div>
						
			</div>
		</div>
	</div>
</c:if>
<c:if test="${cus == null}">
	<div class="alert alert-danger">
	    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	    <strong>Oh !!!</strong> Chưa đăng nhập thông tin
	</div>
	<a href="${rootpath}customer/init-login"><button class="btn btn-success mt-50" ><spt:message code="app.label.login" /></button></a>
	<a href="${rootpath}index.jsp"><button class="btn btn-primary mt-50" ><spt:message code="app.label.home" /></button></a>
</c:if>
<jsp:include page="../layout/footer.jsp" />