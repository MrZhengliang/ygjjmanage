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
					<form method="post" id="addJhmForm" name="addJhmForm"
						action="<spring:url value='/doAddOaJhm.do' htmlEscape='true'/>" target="_self">
						<input type="hidden" name="uid" value="${loginUser.id}">
						<input type="hidden" id="parentId" name="parentId" value="${parentId }" />
		            	<input type="hidden" id="ownId" name="ownId" value="${ownId }" />
						<ul class="box_l_h_c">
							<li class="box_l_h_c_li">
								激活码:<input id="masterCard" class="form-control span3" type="text"
									name="masterCard" value="" placeholder="激活码">
							</li>
							<li class="box_l_h_c_li">
								备卡:<input name="sliverCard" type="text"
									placeholder="备卡" class="form-control span3" id="sliverCard"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								姓名:<input name="username" id="username" type="text"
									placeholder="姓名" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								联系电话:<input name="terminalId" id="terminalId" type="text"
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
								快递单号:<input name="deliverCode" id="deliverCode" type="text"
									placeholder="快递单号" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								套餐日期:<input name="packDate" id="packDate" type="text"
									placeholder="套餐日期" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								金额:<input name="amount" id="amount" type="text"
									placeholder="金额" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								购买日期:<input name="buyDate" id="buyDate" type="text"
									placeholder="购买日期" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<textarea rows="4" cols="50" name="remark" placeholder="输入备注信息,5000字以内" class="form-control"></textarea>
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
				$('#packDate').datepicker({format:"yyyy-mm-dd"});
				$('#buyDate').datepicker({format:"yyyy-mm-dd"});
				//提交搜索
				/* var setCoTypeId = function(typeId,typeName){
					document.getElementById("typeId").value=typeId;
				}
				var setSuStatus = function(suStatus){
					document.getElementById("status").value=suStatus;
				}*/
</script>    
</html>