<%@page import="com.yc.bean.JsonModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<script type="text/javascript">
	function update(id){
		open("pages/modify.jsp?id="  + id);
	}
	function update(id,pages){
		location.href="user/house_ToUpdate.action?id="  + id;
	}
	
	function del(id, pages){
		var isDel = confirm("是否确定删除" + id + "的数据吗？？？？");
		alert(isDel)
		
		if(isDel==true){
			$.ajax({
				url:"user/house_del.action",
				data:"id=" + id,
				dataType:"JSON",
				type:"POST",
				success:function(data){
					alert(">>>>>>>>>" + data);
					getPage(pages);
				}
				
			})
		}
	}
</script>

<table class="house-list">
    <c:forEach items="${jsonModel.rows}" var="v">
    		<tr>
				<td class="house-thumb"><span><a href="page/show.jsp?id=10001"><img src="images/thumb_house.gif" /></a></span></td>
				<td>
					<dl>
						<dt>
							<a href="page/show.jsp?id=10001">${v.title }</a>
						</dt>
						<dd>
							${v.description}
						</dd>
					</dl>
				</td>
				<c:if test="${id==v.users.id}">
						<td class="house-type">
							<label class="ui-green">
								<input type="button" onclick='update(${v.id}, ${jsonModel.pages })' value="修    改" />
							</label>
						</td>
						<td class="house-price">
							<label class="ui-green">
								<input type="button" onclick='del(${v.id}, ${jsonModel.pages })' value="删    除" />
							</label>
						</td>		
				</c:if>
				<c:if test="${ id!=v.users.id}"> 
				 		<td class="house-type" colspan="2">	
				 		</td>
				</c:if>
			
			</tr>
    </c:forEach>			
</table>
<div class="pager">
		<ul>
			<li class="current">
				<a href="javaScript:getPage(1)">首页</a>
					<%
						JsonModel jm = (JsonModel)request.getAttribute("jsonModel");
						int pages = jm.getPages();
						int total = jm.getTotal();
						int pagesize = jm.getPagesize();
						int totalPage = total%pagesize==0?total/pagesize:total/pagesize+1;
						int prePage = pages;
						if(pages>1){
							prePage = pages-1;
						}
						int nextPage = totalPage;
						if(pages<totalPage){
							nextPage=pages+1;
						}else if(pages==totalPage){
							nextPage = pages;
						}
					%>
			</li>
			<li class="current">
				<a href="javaScript:getPage(<%=prePage %>)">上一页</a>
			</li>
			
			<li class="current">
				<a href="javaScript:getPage(<%=nextPage %>)">下一页</a>
			</li>
			<li class="current">
				<a href="javaScript:getPage(<%=totalPage %>)">尾页</a>
			</li>
		</ul>
		<span class="total">第<%=pages %>页/总<%=totalPage %>页 ___记录总数<%=total %>条 ___每页显示<%=pagesize %>条 </span>
	</div>