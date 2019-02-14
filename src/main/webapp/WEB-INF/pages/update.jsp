<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script type="ckeditor/ckeditor.js"></script>

<!-- 根据区取出该区下所有的街道 -->
<script type="text/javascript">
	function onchangeDistrict(obj){
		var districtId = obj;
		$.ajax({
			url:"street_list.action",
			dataType:"JSON",
			data:"id=" + districtId,
            scriptCharset:"UTF-8",
			type:"POST",
			success:function(data){
				alert(data.rows[0].name);
				var str="";
				var length = data.rows.length;
				for(var i=0;i<length;i++){
					var street = data.rows[i];
					var name2=decodeURI(decodeURI(street.name));
					str+="<option value='"+ street.id +"'>"+name2+"</option>"
				}
				$("#houseStreet").html(str);
			}
			
		});
	}
	
</script>







	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
	</div>
	<div id="regLogin" class="wrap">
		<div class="dialog">
			<dl class="clearfix">
				<dt>新房屋信息发布</dt>
				<dd class="past">填写房屋信息</dd>
			</dl>
			<div class="box">
				<form id="House_add_action" name="House_add_action" action="user/house_DoUpdate.action" method="post">
					<input type="hidden" name="id" value="${house.id} ">
					<div class="infos">
						<table class="field">
							<tr>
								<td class="field">标 题：</td>
								<td><input type="text" name="title" value="${house.title} " id="House_add_action_title" class="text"/></td>
							</tr>
							<tr>
								<td class="field">户 型：</td>
								<td>
								<select class="text" name="type_id" id="houseType">
									<c:forEach items="${houseTypeList }" var="houseType">
										<c:if test="${house.houseType.id==houseType.id }">
											<option value="${houseType.id} " selected>${houseType.name }</option>
										</c:if>
										<c:if test="${house.houseType.id!=houseType.id }">
											<option value="${houseType.id} ">${houseType.name }</option>										
										</c:if>
									</c:forEach>
							
								</select>
								</td>
							</tr>
							<tr>
								<td class="field">面 积：</td>
								<td><input type="text" name="floorage" value="" id="House_add_action_floorage" class="text" value="${house.floorage }"/></td>
							</tr>
							<tr>
								<td class="field">价 格：</td>
								<td><input type="text" name="price" value="" id="House_add_action_price" class="text" value="${house.price }"/></td>
							</tr>

							<tr>
								<td class="field">房产证日期：</td>
								<td><input type="text" class="text" name="pubDate" /></td>
							</tr>

							<tr>
								<td class="field">位 置：</td>
								<td>区：
								<select class="text" name="district.id" id="houseDistrict" onchange="onchangeDistrict(this.value)">
									<c:forEach items="${districtList }" var="district">
										<option value="${district.id} ">${district.name }</option>
									</c:forEach>
								
								</select> 
								街：<select class="text" name="street.id" id="houseStreet">
										<option value="${house.street.id}">${house.street.id }</option>
								</select>
								</td>
							</tr>
							<tr>
								<td class="field">联系方式：</td>
								<td><input type="text" name="contact" value="" id="House_add_action_contact" class="text" value="${house.contact }"/></td>
							</tr>
							<tr>
								<td class="field">详细信息：</td>
								<td>
								<textarea class="ckeditor" name="description" value="${house.description }"></textarea>
								</td>
							</tr>
						</table>
						<div class="buttons">
							<input type="submit" id="House_add_action_0" value="立即发布"/>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<%@ include file="bottom.jsp" %>