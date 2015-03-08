<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../WEB-INF/include.jsp"%>


<!-- include HEAD -->
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
<body >
        <div id="content">
            <div class="inner" style="min-height:1200px;">
                <div class="row">
                    <div class="col-lg-12">
	                        <h5>客服管理-订车记录编辑</h5>
	                </div>
	            </div>
	            <hr />
	            <div class="">
	            	<!-- 信息显示 -->
	            	<form class="" method="post" id="editForm" name="editForm"
						action="<spring:url value='/doEditOaKf.do' htmlEscape='true'/>" target="_self">
						<input type="hidden" name="uid" value="${loginUser.id}">
		            	<input type="hidden" id="parentId" name="parentId" value="${parentId }" />
		            	<input type="hidden" id="ownId" name="ownId" value="${ownId }" />
		            	<input type="hidden" id="carId" name="carId"/>
		            	<ul class="box_l_h_c">
							<li class="box_l_h_c_li">
								接送类型:<select id="useType" name="useType" class="form-control"
									style="height:33px;width: 195px; background: none repeat scroll 0 0 #f5f5f5 !important;">
										<option value="0">请选择接送类型</option>
										<option value="1" <c:if test="${car.useType==1 }">selected</c:if>>接</option>
										<option value="2" <c:if test="${car.useType==2 }">selected</c:if>>送</option>
										<option value="3" <c:if test="${car.useType==3 }">selected</c:if>>旅游</option>
										<option value="4" <c:if test="${car.useType==4 }">selected</c:if>>包车</option>
								</select>
							</li>
							<li class="box_l_h_c_li">
								接送日期:<input id="usecarDate" class="form-control span3" type="text"
									name="usecarDate" value="${car.usecarDate }" placeholder="接送日期" readonly>
							</li>
							<li class="box_l_h_c_li">
								航班:<input name="flightNumber" type="text" value="${car.flightNumber }"
									placeholder="航班" class="form-control span3" id="flightNumber"
									autocomplete="off" />
								</li>
							<li class="box_l_h_c_li">
								姓名:<input name="customerName" id="customerName" type="text"
									placeholder="姓名" class="form-control span3" value="${car.customerName }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								人数:<input name="peopleNumber" id="peopleNumber" type="text"
									placeholder="人数" class="form-control span3" value="${car.peopleNumber }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								联系电话:<input name="telephone" id="telephone" type="text"
									placeholder="联系电话" class="form-control span3" value="${car.telephone }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								淘宝:<input name="taobaoId" id="taobaoId" type="text"
									placeholder="淘宝" class="form-control span3" value="${car.taobaoId }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								微信:<input name="weixinCode" id="weixinCode" type="text"
									placeholder="微信" class="form-control span3" value="${car.weixinCode }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								QQ:<input name="qqCode" id="qqCode" type="text"
									placeholder="QQ" class="form-control span3" value="${car.qqCode }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								接机人:<input name="pickPeople" id="pickPeople" type="text"
									placeholder="接机人" class="form-control span3" value="${car.pickPeople }"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								会员号:<input name="memCode" id="memCode" type="text"
									placeholder="会员号" class="form-control span3" value="${car.memCode }"
									autocomplete="off" />
							</li>
							
							<li class="box_l_h_c_li">
								备注:<textarea rows="4" cols="50" name="remark" placeholder="输入备注信息,5000字以内" class="form-control">${car.remark }</textarea>
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
    <script type="text/javascript">
				$('#usecarDate').datepicker({format:"yyyy-mm-dd"});
				//提交搜索
	</script> 
</body>
    <!-- END BODY -->
<iframe style="display: none" name="thisFrame"></iframe>
</html>
