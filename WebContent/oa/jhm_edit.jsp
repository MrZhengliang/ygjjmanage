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

<!-- BEGIN BODY -->
<body>
	<div id="wrap">
<!--PAGE CONTENT -->
        <div id="content">
            <div class="inner" style="min-height:1200px;">
                <div class="row">
                    <div class="col-lg-12">
	                        <h5>客服管理-激活码编辑</h5>
	                </div>
	            </div>
	            <hr />
	            <div class="">
	            	<!-- 信息显示 -->
	            	<form class="" method="post" id="editForm" name="editForm"
						action="<spring:url value='/doEditOaJhm.do' htmlEscape='true'/>" target="_self">
						<input type="hidden" name="uid" value="${loginUser.id}">
		            	<input type="hidden" id="parentId" name="parentId" value="${parentId }" />
		            	<input type="hidden" id="ownId" name="ownId" value="${ownId }" />
		            	<input type="hidden" id="jhmId" name="jhmId" value="" />
		            	<ul class="box_l_h_c">
							
							<li class="box_l_h_c_li">
								激活码:<input id="masterCard" class="form-control span3" type="text"
									name="masterCard" value="${giffgaff.masterCard }" placeholder="激活码">
							</li>
							<li class="box_l_h_c_li">
								备卡:<input name="sliverCard" type="text" value="${giffgaff.sliverCard }"
									placeholder="备卡" class="form-control span3" id="sliverCard"
									autocomplete="off" />
							</li>
							
							<li class="box_l_h_c_li">
								姓名:<input name="username" id="username" type="text"
									placeholder="姓名" class="form-control span3" value="${giffgaff.username }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								联系电话:<input name="terminalId" id="terminalId" type="text"
									placeholder="联系电话" class="form-control span3" value="${giffgaff.terminalId }" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								淘宝:<input name="taobaoId" id="taobaoId" type="text"
									placeholder="淘宝" class="form-control span3" value="${giffgaff.taobaoId }" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								微信:<input name="weixinCode" id="weixinCode" type="text"
									placeholder="微信" class="form-control span3" value="${giffgaff.weixinCode }" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								快递单号:<input name="deliverCode" id="deliverCode" type="text"
									placeholder="快递单号" class="form-control span3" value="${giffgaff.deliverCode }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								套餐日期:<input name="packDate" id="packDate" type="text"
									placeholder="套餐日期" class="form-control span3" value="${giffgaff.packDate }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								金额:<input name="amount" id="amount" type="text" value="${giffgaff.amount }"
									placeholder="金额" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								购买日期:<input name="buyDate" id="buyDate" type="text" value="${giffgaff.buyDate }"
									placeholder="购买日期" class="form-control span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<textarea rows="4" cols="50" name="remark" placeholder="输入备注信息,5000字以内" class="form-control">${giffgaff.remark }</textarea>
							</li>
						</ul>
		            	
	            	</form>
	            </div>			
                 <!-- /row -->
                </div>
             </div>
       <!--END PAGE CONTENT -->               
	</div>
    <!--END MAIN WRAPPER -->	
    <!-- FOOTER -->
    <div id="footer">
        <p>&copy;  splatform-h5 &nbsp;2015 &nbsp;</p>
    </div>
    <!--END FOOTER -->
    <!-- GLOBAL SCRIPTS -->
    <script src="<%=path%>/static/assets/plugins/jquery-2.0.3.min.js"></script>
    <script src="<%=path%>/static/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/static/assets/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <!-- END GLOBAL SCRIPTS -->
    
    <!-- zDialog -->
	<script src="<%=path %>/static/js/zdialog/zDialog.js"></script>
	<script src="<%=path %>/static/js/zdialog/zDrag.js"></script>
       
    <script type="text/javascript"	src="<%=path %>/static/js/date-time/bootstrap-datepicker.js"></script>
    
    
    
</body>
    <!-- END BODY -->
<script type="text/javascript">
				$('#packDate').datepicker({format:"yyyy-mm-dd"});
				$('#buyDate').datepicker({format:"yyyy-mm-dd"});
</script>	
    	
<iframe style="display: none" name="thisFrame"></iframe>
</html>
