<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script type="text/javascript">
	$(function(){
		//默认首页
		getPage(1);
	})
	function getPage(pages){
		$.ajax({
			url:"house_list.action",
			data:"pages="+pages+"&pagesize=2",
			dataType:'HTML',
			success:function(data){
				$("#houseArea").html(data);
			}
		})
	}
	
	function add(){
		document.location="user/house_toAdd.action";
	}
	
</script>

<c:if test="${users!=null}">
	<div class="search">
		<label class="ui-green">
			<input onclick="add()" type="button" name="search" value="发布房屋信息" />
		</label> 
		<label class="ui-green">
			<input type="button" name="search" value="退       出" onclick='document.location="user/logout.action"' />
		</label>
	</div>
</c:if>


	<div class="main wrap">
		<div id="houseArea">

		</div>
	</div>
<%@ include file="bottom.jsp" %>
	