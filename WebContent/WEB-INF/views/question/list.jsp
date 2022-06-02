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
		<div class="row">
			<div class="col-12 col-lg-12 col-sm-12">
			<form action="${rootpath}result/insert" method="post">
				 <c:forEach items="${lstQ}" var="q">
				 	<div class="checkout__form__input">
				 	<input hidden="hidden" name="" value="${q.id}"/>
			            <h5><spt:message code="app.label.ques"/> ${q.id} :</h5>
			            <div class="row">
			            	<div class="col-8 col-lg-8 col-sm-8">
			            		<h3>${q.description}</h3>
			            	</div>
			            	<div class="col-4 col-lg-4 col-sm-4">
			            		<a href="${rootpath}question/detail/${q.id}"><spt:message code="app.label.detailques" /></a> |
				            	<a href="${rootpath}question/update/${q.id}"><spt:message code="app.label.update" /></a> |
				            	<a href="${rootpath}question/delete/${q.id}"><spt:message code="app.label.delete" /></a>
			            	</div>
				 		</div>
			            <div class="row	">
			            	<div class="col img_ques">
			            		<img src="/Public/${q.img}" alt="${q.description}"  />
			            	</div>
			            </div>
			            
			            <c:forEach items="${lstA}" var="a">
			            	<c:if test="${a.ques.id == q.id }">
			            		 ${a.description}<input class="answer" type="radio" name="${a.id}" value="${a.id}">
			            	</c:if>
			            </c:forEach>
						
			        </div>
			     </c:forEach>
			 <div class="row justify-content-between mt-50">
			 	<div class="col-4 col-lg-4 col-sm-4 ">
			 		<button class="btn btn-success" type="submit" ><spt:message code="app.label.confirm" /></button>
		     		<button class="btn btn-primary" ><a style="color:#fff" href="${rootpath}/index.jsp" ><spt:message code="app.label.home" /></a></button>
			 	</div>
			 	<c:if test="${cus.rules}">
				 	<div class="col-4 col-lg-4 col-sm-4 ">
			     		<button class="btn btn-warning" ><a style="color:#fff" href="${rootpath}/question/init-insert" ><spt:message code="app.label.addques" /></a></button>
				 	</div>
			 	</c:if>
			 </div>
		     
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
	<a href="${rootpath}customer/init-login"><button class="btn btn-success mt-50" ><spt:message code="app.label.login" /></button></a>
	<a href="${rootpath}index.jsp"><button class="btn btn-primary mt-50" ><spt:message code="app.label.home" /></button></a>
</c:if>
<jsp:include page="../layout/footer.jsp" />