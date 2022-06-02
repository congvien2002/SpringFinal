<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spt" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CongVien</title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
    rel="stylesheet">
    <!-- Css Styles -->
    <spt:url value="/" var="rootpath" />
    <link rel="stylesheet" href="${rootpath}public/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${rootpath}public/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${rootpath}public/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${rootpath}public/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${rootpath}public/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${rootpath}public/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${rootpath}public/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${rootpath}public/css/style.css" type="text/css">
</head>
<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__close">+</div>
        <ul class="offcanvas__widget">
            <li><a href="#"><span class="icon_heart_alt"></span>
                <div class="tip">2</div>
            </a></li>
            <li><a href="#"><span class="icon_bag_alt"></span>
                <div class="tip">2</div>
            </a></li>
        </ul>
        <div class="offcanvas__logo">
            <a href="${rootpath}index.jsp"><img src="${rootpath}public/img/logo.png" alt=""></a>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__auth">
            <a href="${rootpath}customer/init-login">Login</a>
            <a href="${rootpath}customer/register">Register</a>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3 col-lg-2">
                    <div class="header__logo">
                        <a href="${rootpath}index.jsp"><img src="${rootpath}public/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-7">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="${rootpath}index.jsp"><spt:message code="app.label.home" /></a></li>
                            <li><a href="#"><spt:message code="app.label.manage" /></a>
                                <ul class="dropdown">
                                    <li><a href="${rootpath}customer"><spt:message code="app.label.customer" /></a></li>
                                    <li><a href="${rootpath}question"><spt:message code="app.label.ques" /></a></li>
                                </ul>
                            </li>
                             <li><a href="#"><spt:message code="app.label.language" /></a>
                                <ul class="dropdown">
                                    <li><a href="?language=vi_VN"><spt:message code="lang.vi" text="Tiếng Việt" /></a></li>
                                    <li><a href="?language=en_US"><spt:message code="lang.en" text="Tiếng Anh" /></a></li>
                                    <li><a href="?language=ja_JP"><spt:message code="lang.ja" text="Tiếng Nhật" /></a></li>
                                </ul>
                            </li>
                            <li><a href="${rootpath}result"><spt:message code="app.label.statistical" /></a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__right">
                   	<c:if test="${cus != null}">
                        <div class="header__right__auth">
                            <a href="#">${cus.name}</a>
                            <a href="${rootpath}customer/logout">Logout</a>
                        </div>
                    </c:if>
                    <c:if test="${cus == null}">
                    	<div class="header__right__auth">
                            <a href="${rootpath}customer/init-login">Login</a>
                            <a href="${rootpath}customer/register">Register</a>
                        </div>
                    </c:if>
                        <ul class="header__right__widget">
                            <li><span class="icon_search search-switch"></span></li>
                            <li><a href="#"><span class="icon_heart_alt"></span>
                                <div class="tip">2</div>
                            </a></li>
                            <li><a href="#"><span class="icon_bag_alt"></span>
                                <div class="tip">2</div>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="canvas__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->