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
<script>
	$(document).ready(function() {
		$('#rpSubBtn').click(function() {
			$.ajax({
				type: "GET",
				url: "Controller.do?command=replySubmit",
				dataType: "json", // 서버에서 반환되는 데이터 타입
				success: function(data) {
					console.log(data);
				},
				error: function(res) {
					console.log(res.responseText);
				},
				complete: function() {
					
				}
			}); // end ajax			
		}); // end reply submit		
	}); // end function
</script>
<style>
    .tab {text-align: center;}

    .inp, .inpTextArea {width: 500px; border: 1px solid #23A41A;}

    .inpTextArea:focus {border-color: #9bcfb8;}

    .inpTextArea {height: 100px; line-height: normal; border-radius: 5px; outline: 0 none; border: 2px solid #23A41A; box-sizing: border-box;}

    dt {margin-right: 470px; font-size: 13px; padding: 10px; color: #23A41A;}    

    li {list-style: none;}

    .btn_m {background-color: #9bcfb8; color: #23A41A; border: solid 1px #23A41A; margin: 0 auto;}
    
    .menutitle {text-align: left; border-bottom: 3px solid #9bcfb8; background-color: white; margin: 0 auto; padding: 10px 0 6px 15px; width: 1000px;}
    
    .menutitle h3 {font-size: 24px; font-weight: bold;}
    
    .register {text-align: center; margin: 20px;}
    
    .body {text-align: center;}
    
    .reply {border-top: 3px solid #9bcfb8; width: 1000px; margin: 0 auto; padding: 20px 0 0 50px; text-align: left; font-weight: bold;}
    .inputInfo {margin: 10px 10px 0 0; padding: 0 12px 0 12px; width: 230px; height: 35px;}
    #rp_writer {float: left;}
    .writerInfo::after {display: block; content: ''; clear: both; }
    .rp_cont {padding: 10px 15px 10px 15px; width: 900px; height: 130px;}
    .replyContent {margin-top: 15px;}
    .rpNum {width: 1000px; margin: 15px auto; padding-left: 15px; text-align: left; font-weight: bold;}
    .comment {border-top: 3px solid #9bcfb8; width: 1000px; margin: 0 auto; margin-bottom: 30px; }
    
    .comment table {width: 1000px; margin: 0 auto; border-collapse: collapse;}
	.comment table td {padding: 10px 3px; border-bottom: 0.5px solid #D8F6CE; text-align: center;}
	
	.contBtn {width: 1000px; margin: 0 auto; text-align: right;}
	.rp_btn {padding-right: 50px; text-align: right;}
    
    .bcontent {width: 1000px; margin: 0 auto; padding: 40px 15px 40px 15px; text-align: left; }
    
    .btitle {width: 1000px; margin: 0 auto; padding-left: 15px; text-align: left; border-bottom: 0.5px solid #D8F6CE; position: relative;}
    
    .btitle h3 {margin-top: 10px;}
    
    .optionCnt {position: absolute; right:0; bottom: 0; right: 15px;}
    
    #inputWord {width: 570px; height: 50px;}
    
    .register>button {height: 52px; width: 80px;}
    
    a {text-decoration: none; color: black;}
    
    .clsline {color: #E6E6E6;}
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
                <span class="logo"><a href="main.html"><img src="images/logo.JPG"></a></span>
                <div class="search">
                    <input type="text" class="searchtxt" style="padding-left: 15px;" placeholder="제품 검색" />
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
            <h3>글내용</h3>
        </div>
        <div class="btitle">
            <h3>${requestScope.board.board_title }</h3>
            <p class="postdate">
            	${requestScope.board.writer }
            	<span class="clsline">ㅣ</span>
            	${requestScope.board.postdate }
            </p>
            <p class="optionCnt">
            	<span>조회 ${requestScope.board.viewcnt }</span>
            	<span class="clsline">ㅣ</span>
            	<span>추천 ${requestScope.board.likecnt }</span>
            	<span class="clsline">ㅣ</span>
            	<span>댓글 ${requestScope.board.unlikecnt }</span>
            </p>
        </div>
        <div class="bcontent">
        	${requestScope.board.content }
        </div>
        <div class="contBtn">
	        <button type="button" class="btn_m"><a href="#">목록</a></button>
	        <c:if test="${requestScope.board.writer == sessionScope.user.nickname }">
		        <button type="button" class="btn_m"><a href="#">수정</a></button>
		        <button type="button" class="btn_m"><a href="Controller.do?command=boardDelete&no=${requestScope.board.board_no }">삭제</a></button>
	        </c:if>
        </div>
        
        <div class="rpNum">전체 리플 <span style="color: red;">1</span>개</div>
        
        <div class="comment">
        	<table>
        		<colgroup>
        			<col width="15%">
        			<col width="68%">
        			<col width="17%">
        		</colgroup>
        		<tr>
        			<td style='text-align: left;'>가나다라마바사아자</td>
        			<td style='text-align: left;'>내용</td>
        			<td style='text-align: right;'>2019-05-15 12:34:15</td>
        		</tr>
        	</table>
        </div>
        
        <div class="reply">
	        <form action="" method="post">
	        	<div class="writerInfo">
					<div class="replyInfo">
						<input type="text" id ="rp_writer" class="inputInfo searchtxt" name="rp_writer" maxlength="6" />
					</div>
					<div class="replyInfo">
						<input type="password" id="rp_pwd" class="inputInfo searchtxt" name="rp_pwd" maxlength="10" /><br/>
					</div>
				</div>
				<div class="replyContent">
					<textarea rows="15" cols="150" class="rp_cont searchtxt" name="rp_cont" maxlength="300"></textarea>
				</div>
				<div id="rpSubBtn" class="rp_btn"><button type="submit">등록</button></div>				
			</form>
		</div>
		
    </div>

    <footer>
        <div class="footer">
            <div class="footer1">
                <ul class="clearFix">
                    <li><a href=#>이용약관</a></li><span>ㅣ</span>
                    <li><a href=#>개인정보 처리방침</a></li><span>ㅣ</span>
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