<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link href="css/common.css" type="text/css" rel="stylesheet"> <!-- css 파일 불러오기 -->
<script src="js/common.js"></script>
<script src="js/jquery.min.js"></script> <!-- jQuery를 쓰기위한 선언 -->
</head>
<style>
	/* 로그인 회원가입 장바구니 고객센터 우로 정렬 */
    .top-menu {float: right;}

    /* 모든 input 태그 간격 조절 */
    .form-group {margin-bottom: 50px;}

    .btn btn-warning {margin-left: 30px;}

    body {font-weight: bold; margin: 0; padding: 0;}

    .control {font-size: 20px;}

    label {font-size: 20px;}
    
    form {margin-top: 100px;}
    
  	#button-level {width: 100px; height: 100px; width: 100%;}
  	
    #joinout-Contents {margin: 100px; font-size: 20px;}
    
    #button-out {text-align: left; margin: 20px;}
    
  	#button-level2 {width: 200px; margin: 20PX; float: left;}
    
    form{margin-top: 100px;}
    
    #line{padding: 10%;}
    
    #line-hend{padding: 30px;}
</style>
<body>
	<div class="head">
	        <div class="header">
	            <div class="login">
	                <a href="term.html"><input type="button" class="login2" value="회원가입"></a>
	                <a href="login.html"> <input type="button" class="login2" value="로그인"></a>
	                <a href="mypage.html"><input type="button" class="login2" value="마이페이지"></a>
	                <a href="main.html"> <input type="button" class="login2" value="로그아웃"></a>
	            </div>
	            <div>
	                <span class="logo"><a href="main.html"><img src="./images/logo.JPG"></a></span>
	                <div class="search">
	                    <input type="text" class="searchtxt" style="padding-left: 15px;" placeholder="제품 검색">
	                    <input type="button" class="searchbtn">
	                </div>
	            </div>
	        </div>
	        <div class="menubar">
	            <ul class="menu">
	                <li id="test"><a class="bigmenu" href="notice.html" >새소식</a>
	                    <ul class="smallmenu">
	                        <li><a href="notice.html">공지사항</a></li>
	                        <li><a href="event.html">이벤트</a></li>
	                    </ul>
	                </li>
	                <li><a class="bigmenu" href="productlist.html" >의약품</a>
	                    <ul class="smallmenu">
	                        <li><a href="productlist.html">감기</a></li>
	                        <li><a href="#">눈</a></li>
	                        <li><a href="#">피부</a></li>
	                        <li><a href="#">통증</a></li>
	                        <li><a href="#">뼈/관절</a></li>
	                        <li><a href="#">위장기능</a></li>
	                    </ul>
	                </li>
	                <li><a class="bigmenu" href="productlist.html" >건강식품</a>
	                    <ul class="smallmenu">
	                        <li><a href="productlist.html">면역</a></li>
	                        <li><a href="#">간</a></li>
	                        <li><a href="#">기관지</a></li>
	                        <li><a href="#">뼈/관절</a></li>
	                        <li><a href="#">위장기능</a></li>
	                    </ul>
	                </li>
	                <li><a class="bigmenu" href="board.html" >커뮤니티</a>
	                    <ul class="smallmenu">
	                        <li><a href="Controller.do?command=community">게시판</a></li> <!-- 경로를 /Controller.do로 주면 안된다. -->
	                    </ul>
	                </li>
	            </ul>
	        </div>
	    </div>
	
	   <h1>메인페이지</h1>
	    <footer>
	    <div class="footer">
	        <div class="footer1">
	            <ul class="clearFix">
	                <li><a href=#>이용약관</a></li>ㅣ
	                <li><a href=#>개인정보 처리방침</a></li>ㅣ
	                <li><a href=#>오시는길</a></li>
	            </ul>
	        </div>
	        <div class="footer2">
	            <address>서울시 금천구 가산디지털2로 대륭테크노타운 3차</address>
	            <a href="tel:02.000.0000">문의전화 02)000-0000 </a>
	            <div class="copyright">Copyright &copy; 구디메디컬. All Right Reserved.</div>
	        </div>
	    </div>
	</footer>
</body>
</html>