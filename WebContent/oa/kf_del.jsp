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
	.pd{
		padding: 50px 40px;
	}
</style>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body>
	<div id="wrap">
			<form id="delForm" name="delForm" method="post" action="doDelOaKf.do" target="_self">
				<input type="hidden" id="del-carId" name="carId" value="${carId }">
				<input type="hidden" id="edit-parentId" name="parentId" value="${parentId }">
				<input type="hidden" id="edit-ownId" name="ownId" value="${ownId }">
			</form>
			<div class="pd">警告:你确定要删除订车记录${name}吗?</div>
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