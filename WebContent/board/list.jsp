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
	.btn_chkdel {margin: 10px 10px 10px 700px; text-align: center;}

    .btn_chkdel .btn_m { background-color: #9bcfb8; color: #23A41A; border: solid 1px #23A41A;}

    table { margin: 0 auto; width: 800px; border-top: 1px solid #23A41A; border-collapse: collapse;}

    table th { padding: 10px 3px; border: 1px solid #23A41A; font-size: 12px;}

    table td { padding: 10px 3px; border: 1px solid #23A41A; text-align: center;}

    table .tit {text-align: left; padding: 0 10px;}

    .icon {display: inline-block; width: 50px; height: 23px; line-height: 23px; text-align: center; color: #fff; font-size: 11px; border-radius: 3px}

    .icon_s {background-color: #bababa;}

    .icon_f {background-color: #346dff;}

    .paging {text-align: center;}

    .paging a {display: inline-block; width: 22px; height: 22px; vertical-align: top; line-height: 22px; text-align: center; margin: 20px 7px 0 7px;}

    .paging .num {background-color: #d5d5d5; border-radius: 3px;}

    .paging .num.on {font-weight: bold; color: #fff; background-color: #346dff;}

    .paging .first { background: url(images/btn_firstpage.png) no-repeat 0 0; background-size: 22px; text-indent: -9999px;}

    .paging .last {background: url(images/btn_lastpage.png) no-repeat 0 0; background-size: 22px; text-indent: -9999px;}

    .menutitle {text-align: left; padding: 30px 0px 0px 0px; border-bottom: 3px solid #9bcfb8; background-color: white; margin: 0 auto; height: 60px; width: 1000px;}

    .body {margin: 0 auto;}

    .blank {height: 40px;}

    .search2 { text-align: center; margin: 20px;}
    
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
                        <li><a href="board.html">게시판</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div class="body">
        <div class="menutitle">
            <h3>게시판</h3>
        </div>
        <div class="blank"></div>
        <table>
        	<thead>
	            <tr>
	                <th>번호</th>
	                <th>제목</th>
	                <th>글쓴이</th>
	                <th>작성일</th>
	                <th>조회</th>
	                <th>추천</th>
	            </tr>
            </thead>
            <tbody>
	            <c:forEach items="${requestScope.boards }" var="board">
	            	<tr>
	            		<td>${board.board_no }</td>
	            		<td><a href='Controller.do?command=bdContView&no=${board.board_no }'>${board.board_title }</a></td>
	            		<td>${board.writer }</td>
	            		<td>${board.postdate }</td>
	            		<td>${board.viewcnt }</td>
	            		<td>${board.likecnt }</td>
	            	</tr>
	            </c:forEach>
            </tbody>
		</table>

        <p class="btn_chkdel"><button type="button" class="btn_m"><a href="board/write.jsp">글쓰기</a></button></p>
        <p class="paging">
            <a href="#" class="first">처음페이지</a>
            <a href="#" class="num on">1</a>
            <a href="#" class="num">2</a>
            <a href="#" class="num">3</a>
            <a href="#" class="last">마지막페이지</a>
        </p>
        <form action="" method="post">
            <div class="search2">
                <select>
                    <option value="bwriter">작성자</option>
                    <option value="btitle">제목</option>
                    <option value="bcontent">내용</option>
                </select> <input id="searchWord" type="text">
                <button type="submit">검색</button>
            </div>
        </form>
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