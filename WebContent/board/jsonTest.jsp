<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery.min.js"></script> <!-- jQuery를 쓰기위한 선언 -->
<script>
	function displayBoardList(data){
		let tbody;
		
		console.log(data.length);
		console.log(data[0].board_title);
		
		for(let i=0; i<data.length; i++){
			tbody += "<tr>";
			tbody += "<td>" + data[i].board_no + "</td>";
			tbody += "<td>" + data[i].board_title + "</td>";
			tbody += "<td>" + data[i].writer + "</td>";
			tbody += "<td>" + data[i].postdate + "</td>";
			tbody += "<td>" + data[i].viewcnt + "</td>";
			tbody += "<td>" + data[i].likecnt + "</td>";
			tbody += "</tr>";
		}
		
		$('.empVal').append(tbody);
	}
	
	function boardListToIndex(){ // 인덱스에서 게시판으로 넘어 올 때
		$.ajax({
			type: "GET",
			url: "../Controller.do?command=changeListCnt&listCnt=10&page=1",
			dataType: "json",
			success: function(data) {
				console.log(data);
				displayBoardList(data);
			},
			error: function(res) {
				console.log(res.responseText);
			},
			complete: function() {
				
			}
		}); // end ajax
	}
	
	function changeListCnt(listCnt){
		$.ajax({
			type: "GET",
			url: "../Controller.do?command=changeListCnt&listCnt=" + listCnt + "&page=1",
			dataType: "json",
			success: function(data) {
				console.log(data);
				displayBoardList(data);
			},
			error: function(res) {
				console.log(res.responseText);
			},
			complete: function() {
				
			}
		}); // end ajax
	}
	
	$(document).ready(function(){
		boardListToIndex();
		
		$('#listCnt').change(function(){
			let listCnt = $(this).val(); // select박스의 option value값
			
			changeListCnt(listCnt);
		});
		
	}); // end document
</script>
</head>
<body>
	<select id="listCnt">
		<option value='10' selected>10개</option>
		<option value='15'>15개</option>
		<option value='20'>20개</option>
    </select>
    
	<table class="empTable" width="100%">
		<thead>
			<tr>
				<th>N  O</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>POST</th>
				<th>CNT</th>
				<th>LIKE</th>
			</tr>
		</thead>
		<tbody class="empVal"></tbody>
	</table>
</body>
</html>