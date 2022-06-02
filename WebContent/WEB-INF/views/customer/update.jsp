<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<div class="container form-update">
		<div class="row justify-content-center">
			<div class="col-6 col-lg-6 col-sm-6" >
			<spf:form action="${rootpath}customer/store" method="POST"
				modelAttribute="cus">
				<h2 class="text-center"><spt:message code="app.label.updatecus" /></h2>
				<table class="table table-hover">
						<spf:hidden path="id" value="${cus.id}"/>
						<tr>
						<th><spt:message code="app.label.empname" /></th>
						<td><spf:input path="name" class="input-controller" placeholder="${cus.name}"/>
						<spf:errors path="name" cssClass="boxError" />
						</td>
						
					</tr>
					<tr>
						<th><spt:message code="app.label.email" /></th>
						<td><spf:input path="email" class="input-controller" placeholder="${cus.email}"/>
								<spf:errors path="email" cssClass="boxError" />
						</td>
					</tr>
		
					<tr>
						<th><spt:message code="app.label.phone" /></th>
						<td><spf:input path="phone" class="input-controller" placeholder="${cus.phone}"/>
							<spf:errors path="phone" cssClass="boxError" /></td>
					</tr>
					<tr>
						<th><spt:message code="app.label.address" /></th>
						<td><spf:textarea row="5" col="15" path="address" placeholder="${cus.address}"/>
							<spf:errors path="address" cssClass="boxError" /></td>
					</tr>
					<tr>
						<th><spt:message code="app.label.dob" /></th>
						<td><spf:input type="date" path="dob" />
						<spf:errors path="dob" cssClass="boxError" />
					</tr>
		
					<tr>
						<th><spt:message code="app.label.gender" /></th>
						<td>
							<c:if test="${cus.gender}">
								<spf:radiobutton value="true" class="input-radio" path="gender" checked="checked"/><spt:message code="app.label.female" />
								<spf:radiobutton value="false" class="input-radio" path="gender" /> <spt:message code="app.label.male" />
							</c:if>
							<c:if test="${!cus.gender}">
								<spf:radiobutton value="true" class="input-radio" path="gender" /><spt:message code="app.label.female" />
								<spf:radiobutton value="false" class="input-radio" path="gender" checked="checked"/> <spt:message code="app.label.male" />
							</c:if>
						</td>
					</tr>
		
					<tr>
						<th><spt:message code="app.label.password" /></th>
						<td><spf:input type="password" id="passtoken" path="password" value="${cus.password }"/><button class="btn btn-dark" type="button" id="clicktoken">Ẩn/Hiện</button>
						<spf:errors path="password" cssClass="boxError" />
					</tr>
					<tr>
						<th><spt:message code="app.label.status" /></th>
						<td>
						<c:if test="${cus.status ==0}">
							<spf:radiobutton value="0" class="input-radio" path="status" checked="checked"/>Đã khảo sát
							<spf:radiobutton value="1" class="input-radio" path="status" />Chưa khảo sát
							<spf:radiobutton value="2" class="input-radio" path="status" />Không khảo sát
						</c:if>
						<c:if test="${cus.status ==1}">
							<spf:radiobutton value="0" class="input-radio" path="status" />Đã khảo sát
							<spf:radiobutton value="1" class="input-radio" path="status" checked="checked"/>Chưa khảo sát
							<spf:radiobutton value="2" class="input-radio" path="status" />Không khảo sát
						</c:if>
						<c:if test="${cus.status ==2}">
							<spf:radiobutton value="0" class="input-radio" path="status" />Đã khảo sát
							<spf:radiobutton value="1" class="input-radio" path="status" />Chưa khảo sát
							<spf:radiobutton value="2" class="input-radio" path="status" checked="checked"/>Không khảo sát
						</c:if>
						</td>
					</tr>
					<tr>
						<th><spt:message code="app.label.rules" /></th>
						<td>
						<c:if test="${!cus.rules}">
							<spf:radiobutton value="false" class="input-radio" path="rules" checked="checked"/><spt:message code="app.label.customer" />
							<spf:radiobutton value="true" class="input-radio" path="rules" /><spt:message code="app.label.admin" />
						</c:if>
						<c:if test="${cus.rules}">
							<spf:radiobutton value="false" class="input-radio" path="rules" /><spt:message code="app.label.customer" />
							<spf:radiobutton value="true" class="input-radio" path="rules" checked="checked"/><spt:message code="app.label.admin" />
						</c:if>
						</td>
					</tr>
		
					<tr>
						<th></th>
						<td>
							<button type="submit" class="btn btn-success"><spt:message code="app.label.update" /></button>
							<button class="btn btn-primary"><a style="color:#fff" href="${rootpath}customer/"><spt:message code="app.label.back" /></a></button>
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