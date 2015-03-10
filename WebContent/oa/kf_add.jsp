<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../WEB-INF/include.jsp"%>

<!-- BEGIN HEAD -->
<%@ include file="../main/header.jsp"%>
<style type="text/css">
	.role—area{
		border:1px solid #9FA0A3;
		line-height: 40px;
		background-color: #ffffff;
	}
	div.left {
	    float: left;
	    width: 250px;
	}
	div.zTreeDemoBackground {
	    text-align: left;
	    width: 250px;
	}
	#wrap ul{
		text-align: left;
	}
	.wrap-ul li{
		display:block;
	    float:left;
	    width:110px;
	}
	#wrap ul .wrap-li{
		transition-property: transform, opacity;
		transition-duration: 0.4s;
	}
	.box_l_h_c li{
	    display:block;
	    float:left;
	    margin:15px 0 0 10px;
	}
	.display_none{
		display: none;
	}
	.fl{
		float: left;
	}
	.upload_div{
		
	}
	#pic_list li{
		margin:0;
	}
</style>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body>
	<div id="wrap">
					<form class="" method="post" id="addForm" name="addForm"
						action="<spring:url value='/doAddOaKf.do' htmlEscape='true'/>" target="_self">
						<input type="hidden" name="uid" value="${loginUser.id}">
						<input type="hidden" id="parentId" name="parentId" value="${parentId }" />
		            	<input type="hidden" id="ownId" name="ownId" value="${ownId }" />
						<ul class="box_l_h_c">
							<li class="box_l_h_c_li">
								接送类型:<select id="useType" name="useType" class="form-control"
									style="height:33px;width: 195px; background: none repeat scroll 0 0 #f5f5f5 !important;">
										<option value="0" selected>请选择接送类型</option>
										<option value="1">接</option>
										<option value="2">送</option>
										<option value="3">旅游</option>
										<option value="4">包车</option>
								</select>
							</li>
							<li class="box_l_h_c_li">
								接送日期:<input id="usecarDate" class="form-control span3" type="text"
									name="usecarDate" value="" placeholder="接送日期" readonly>
							</li>
							<li class="box_l_h_c_li">
								航班:<input name="flightNumber" type="text"
									placeholder="航班" class="form-control span3" id="flightNumber"
									autocomplete="off" />
								</li>
							<li class="box_l_h_c_li">
								姓名:<input name="customerName" id="customerName" type="text"
									placeholder="姓名" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								人数:<input name="peopleNumber" id="peopleNumber" type="text"
									placeholder="人数" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								联系电话:<input name="telephone" id="telephone" type="text"
									placeholder="联系电话" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								淘宝:<input name="taobaoId" id="taobaoId" type="text"
									placeholder="淘宝" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								微信:<input name="weixinCode" id="weixinCode" type="text"
									placeholder="微信" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								QQ:<input name="qqCode" id="qqCode" type="text"
									placeholder="QQ" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								接机人:<input name="pickPeople" id="pickPeople" type="text"
									placeholder="接机人" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								会员号:<input name="memCode" id="memCode" type="text"
									placeholder="会员号" class="form-control span3" 
									autocomplete="off" />
							</li>
							
							<li class="box_l_h_c_li">
								备注:<textarea rows="4" cols="50" name="remark" placeholder="输入备注信息,5000字以内" class="form-control"></textarea>
							</li>
						</ul>
					</form>
	</div>
	<!--END MAIN WRAPPER -->
</body>
<!-- GLOBAL SCRIPTS -->
<script src="<%=path%>/static/assets/plugins/jquery-2.0.3.min.js"></script>

<script type="text/javascript"	src="<%=path %>/static/js/date-time/bootstrap-datepicker.js"></script>

<iframe name="targetFrame" style="width: 0%; display: none;"></iframe>
<script type="text/javascript">
				$('#usecarDate').datepicker({format:"yyyy-mm-dd"});
				
				//提交搜索
				/* var setCoTypeId = function(typeId,typeName){
					document.getElementById("typeId").value=typeId;
				}
				var setSuStatus = function(suStatus){
					document.getElementById("status").value=suStatus;
				}*/
				
</script>
</html>