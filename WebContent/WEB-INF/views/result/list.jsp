<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layout/header.jsp" />
<spt:url value="/" var="rootpath" />
	<div class="container mt-50">
		<div class="row justify-content-center">
			<div class="col-4 col-lg-4 col-sm-4">
				<h2><spt:message code="app.label.result" /></h2>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12 col-lg-12 col-sm-12">
				 <c:forEach items="${lstQ}" var="q">
				 	<div class="checkout__form__input">
			            <h5><spt:message code="app.label.ques"/> ${q.id} :</h5>
			            <div class="row">
			            	<div class="col-10 col-lg-10 col-sm-10">
			            		<h3>${q.description}</h3>
			            	</div>
			            	<div class="col-2 col-lg-2 col-sm-2">
				            	Đã khảo sát : <h3>${q.total}</h3>
			            	</div>
				 		</div>
			            <div class="row	">
			            	<div class="col img_ques">
			            		<img src="/Public/${q.img}" alt="${q.description} " />
			            	</div>
			            </div>
			           <button class="btn btn-success"><a style="color:#fff" href="${rootpath}/result/${q.id}" ><spt:message code="app.label.detail"  /></a></button>
			        </div>
			     </c:forEach>
		     <button class="btn btn-primary mt-50" ><a style="color:#fff" href="${rootpath}/index.jsp" ><spt:message code="app.label.home" /></a></button>
						
			</div>
		</div>
	</div>
	
<jsp:include page="../layout/footer.jsp" />