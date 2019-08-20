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
    
    .menutitle {text-align: left; border-bottom: 3px solid #9bcfb8; background-color: white; margin: 0 auto; padding: 10px 0 6px 15px; width: 1000px;}
    
    .menutitle h3 {font-size: 24px; font-weight: bold;}
    
    .writeContainer {width: 1000px; margin: 0 auto; padding-left: 50px;}
    
    .inputInfo {margin: 10px 10px 0 0; padding: 0 12px 0 12px; width: 230px; height: 35px;}
    
    #bd_writer {float: left;}
    .writerInfo::after {display: block; content: ''; clear: both; }
    
    .inputTitle {width: 728px; margin: 10px 0 0 0;}
    
    .boardCautious {margin-top: 10px;}
    
    .writeContent {margin-top: 25px;}
    
    .bd_cont {padding: 10px 15px 10px 15px; width: 900px; height: 300px;}
    
    .boardImgFile, .resubBoard {margin-top: 25px;}
    
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
                    <input type="text" class="searchtxt" placeholder="제품 검색" />
                    <input type="button" class="searchbtn" />
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
        
        <div class="writeContainer">
	        <form action="../Controller.do?command=boardWrite" method="post" enctype="multipart/form-data">
			    <div class="writeBoard">
					<div class="writerInfo">
				        <div class="boardInfo">
				        	<c:choose>
				        		<c:when test="${sessionScope.user != null }"> <!-- 회원이 글 쓸 때 -->
				        			<input type="text" id ="bd_writer" class="inputInfo searchtxt" name="bd_writer" value="${sessionScope.user.nickname }" readonly />
				        		</c:when>
				        		<c:otherwise> <!-- 비회원이 글 쓸 때 --> <!-- readonly / disabled : 둘다 only read, disabled는 form으로 값 전송시 값 전송 불가-->
				        			<input type="text" id ="bd_writer" class="inputInfo searchtxt" name="bd_writer" value="(비회원)" readonly />
				        		</c:otherwise>
				        	</c:choose>
				        </div>
				        <div class="boardInfo">
				        	<input type="password" id="bd_pwd" class="inputInfo searchtxt" name="bd_pwd" maxlength="20" /><br/>
				        </div>
				    </div>
			        <div class="boardInfo">
			        	<input type="text" id ="bd_title" class="inputInfo inputTitle searchtxt" name="bd_title" maxlength="40" />
			        </div>
			        <div class="boardCautious">
			        	<span>※ 쉬운 비밀번호를 입력하면 타인의 수정, 삭제가 쉽습니다.</span><br/>
			        	<span>※ 음란물, 차별, 비하, 혐오 및 초상권, 저작권 침해 게시물은 민, 형사상의 책임을 질 수 있습니다.</span>
			        </div>
			        <div class="writeContent">
			        	<textarea rows="15" cols="150" class="bd_cont searchtxt" name="bd_cont"></textarea>
			        </div>
			        <div class="boardImgFile">
			        	<input type="file" id="bd_img" name="bd_imgfile" />
			        </div>
			    </div>
			    
		    	<div class="resubBoard">
		    		<button type="button" class="btn_m">취소</button>
	            	<button type="submit" class="btn_m">등록</button>
		    	</div>
	        </form>
        </div>
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