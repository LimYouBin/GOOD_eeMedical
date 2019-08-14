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
<link href="../css/common.css" type="text/css" rel="stylesheet"> <!-- css 파일 불러오기 -->
<script src="../js/common.js"></script>
<script src="../js/jquery.min.js"></script> <!-- jQuery를 쓰기위한 선언 -->
</head>
<style>
    .tab {text-align: center;}

    .inp, .inpTextArea {width: 600px; border: 1px solid #23A41A;}

    .inpTextArea:focus {border-color: #9bcfb8;}

    .inpTextArea {height: 250px; line-height: normal; border-radius: 5px; outline: 0 none; border: 2px solid #23A41A; box-sizing: border-box;}

    dt {margin-right: 470px; font-size: 13px; padding: 10px; color: #23A41A;}

    p {float: left; margin-top: 20px;}

    li {list-style: none;}

    .btn_m { background-color: #9bcfb8; color: #23A41A; border: solid 1px #23A41A; margin: 0 auto;}

    .body { padding-bottom: 100px; width: 100%;}
    
    .menutitle { text-align: left; padding: 30px 0px 0px 0px; border-bottom: 3px solid #9bcfb8; background-color: white; margin: 0 auto; height: 60px; width: 1000px;}
    
    .tab {margin-top: 20px; text-align: center;}
    
    a {text-decoration: none; color: black;}
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
                <span class="logo"><a href="main.html"><img src="../images/logo.JPG"></a></span>
                <div class="search">
                    <input type="text" value=" search" class="searchtxt">
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
                        <li><a href="board.html">게시판</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div class="body">
        <div class="menutitle">
            <h3>글쓰기</h3>
        </div>
        <ul class="tab">
            <li>
                <dl>
                    <dt>제목</dt>
                    <dd><input type="text" class="inp" /></dd><!-- 제목은 수정 불가능 하도록 readonly 속성 추가 -->
                </dl>
            </li>
            <li>
                <dl>
                    <dt>내용</dt>
                    <dd><textarea rows="5" cols="" class="inpTextArea" ></textarea></dd>
                </dl>
            </li>
            
            <li>
                <button type="button" class="btn_m"><a href="board.html">취소</a></button>
                <button type="button" class="btn_m"><a href="board.html">저장</a></button>
            </li>
        </ul>
    </div>

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