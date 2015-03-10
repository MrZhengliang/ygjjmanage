<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../WEB-INF/include.jsp"%>


<!-- include HEAD -->
<!-- BEGIN HEAD -->
<%@ include file="../main/header.jsp" %>
<style type="text/css">
	.form-control{
		background-color: #fff;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
	    color: #555;
	    font-size: 14px;
	    height: 34px;
	    line-height: 1.42857;
	    padding: 6px 12px;
	    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
	    vertical-align: middle;
	    display: inline;
	    width:12%;
	}
	.mr0{
		margin: 0px 0px 0px 0px;
	}
	.col-lg-12{
		margin: 20px 0 0 10px;
	}
	.mlt5{
		margin:5px 0 0 46px;
	}
	.mt5{
		margin:5px 0 0 0;
	}
</style>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="padTop53 " >

        
	<div id="wrap">
        <%@ include file="../main/top.jsp" %>
        <!-- END HEADER SECTION -->



        <%@ include file="../main/left.jsp" %>
        <!--END MENU SECTION -->



        <!--PAGE CONTENT -->
        <div id="content">
            <div class="inner" style="min-height:1200px;">
                <div class="row">
                    <div class="col-lg-12">
	                        <h5>客服管理-定车记录管理</h5>
	                </div>
	            </div>
	            <hr />
	                <div class="page-header mr0">
						<form id="suserSearchForm" name="suserSearchForm"
							action="<spring:url value='/oakfmanage.do' htmlEscape='true'/>"
							method="post" target="_self">
							<input type="hidden" id="parentId" name="parentId" value="${parentId }" />
							<input type="hidden" id="ownId" name="ownId" value="${ownId }" />
							
							<i class="icon-hand-right"></i><span>搜索</span>
							<input id="usecarDate" class="form-control span2"
								type="text" name="usecarDate" value="${usecarDate }" placeholder="接送日期" readonly>
							<select id="useType" name="useType" class="form-control"
									style="height:33px;width: 130px; background: none repeat scroll 0 0 #f5f5f5 !important;">
										<option value="0" selected>选择接送类型</option>
										<option value="1">接</option>
										<option value="2">送</option>
										<option value="3">旅游</option>
										<option value="4">包车</option>
							</select>
							<input type="text" placeholder="输入姓名" class="form-control" 
									id="customerName" name="customerName" value="${customerName }"
								autocomplete="off" />
							<input type="text" placeholder="联系电话" class="form-control" 
									id="telephone" name="telephone" value="${telephone }"
								autocomplete="off" />
							<input type="text" placeholder="淘宝" class="form-control" 
									id="taobaoId" name="taobaoId" value="${taobaoId }"
								autocomplete="off" />
							<input type="text" placeholder="微信" class="form-control" 
									id="weixinCode" name="weixinCode" value="${weixinCode }"
								autocomplete="off" /> 
							<input type="text" placeholder="接机人" class="form-control" 
									id="pickPeople" name="pickPeople" value="${pickPeople }"
								autocomplete="off" />
							<input type="text" placeholder="备注" class="form-control mlt5" 
									id="remark" name="remark" value="${remark }"
								autocomplete="off" />
							
							<button class="btn btn-info btn-line mt5" type="button" onClick="submitSearchForm()">
												<i class="icon-search"></i>
							</button>
							<div
								style="display: inline-block; background-repeat: no-repeat; border-width: 4px; font-size: 13px; line-height: 1.39; padding: 4px 9px;">
								<a onclick="addSetcar();" href="javascript:;" class="btn btn-success btn-sm">添加</a>
							</div>
						</form>
				</div>
                        <div class="table-responsive">
										<table id="sample-table-1"
											class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th class="center">序号</th>
													<th>咨询日期</th>
													<th>接送日期</th>
													<th>航班</th>
													<th>类型</th>
													<th>姓名</th>
													<th>人数</th>
													<th>联系电话</th>
													
													<th>淘宝</th>
													<th>微信</th>
													<th>QQ</th>
													<th>接机人</th>
													<th>会员号</th>
													<th>操作员</th>
													<th>操作</th>
												</tr>
											</thead>

											<tbody>
												<c:forEach items="${oaSetcarList}" var="car"
													varStatus="status">
													<tr>
														<td>${status.index + 1}</td>
														<td>
														<fmt:parseDate value="${car.targetDate}" var="targetDate" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${targetDate}" pattern="yyyy年MM月dd日"/>
														<td>
														<fmt:parseDate value="${car.targetDate}" var="usecarDate" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${usecarDate}" pattern="yyyy年MM月dd日"/>
														</td>
														<td>${car.flightNumber}</td>
														<td>
														    <!-- 1 接/2送/3旅游/4包车 -->
															<c:if test="${car.useType ==1 }">接</c:if>
															<c:if test="${car.useType ==2 }">送</c:if>
															<c:if test="${car.useType ==3 }">旅游</c:if>
															<c:if test="${car.useType ==4 }">包车</c:if>
														</td>

														<td>${car.customerName}</td>
														<td>${car.peopleNumber}</td>
														<td>${car.telephone}</td>
														
														<td>${car.taobaoId}</td>
														<td>${car.weixinCode}</td>
														<td>${car.qqCode}</td>
														<td>${car.pickPeople}</td>
														<td>会员号</td>
														<td>${car.operateName}</td>
														<td>													
														<c:if test="${car.id > 0}">
															<a data-toggle="modal" href="#suserEdit"
															onClick="editSetcar('${car.id}');"
															class="btn btn-xs btn-primary"><i class="icon-edit"></i></a>
															<a data-toggle="modal" href="#suserDel"
																onClick="delSetcar('${car.id}','${car.customerName}');"
																class="btn btn-xs btn-danger"><i class="icon-trash"></i></a>
														</c:if>
															
														</td>
													</tr>
												</c:forEach>

												<c:if test="${page.totalRowNum>0}">
													<c:if test="${page.totalRowNum >= pageSize}">
														<tr class="page_c">
															<td colspan="15">${page.display}</td>
														</tr>
													</c:if>
												</c:if>
											</tbody>
										</table>
									</div>
									<!-- /.table-responsive -->
								<!-- /row -->
							
							<div class="hr hr-18 dotted hr-double"></div>
                    </div>
                </div>
                
            </div>
       <!--END PAGE CONTENT -->
    <!--END MAIN WRAPPER -->
	
    <!-- FOOTER -->
    <div id="footer">
        <p>&copy;  splatform-h5 &nbsp;2015 &nbsp;</p>
    </div>
    <!--END FOOTER -->


    <!-- GLOBAL SCRIPTS -->
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
    

  	//订车记录新增
    var addSetcar = function(){
    		var diag = new zDialog();
    		diag.Height = 450;
        	diag.Title = "客服管理-订车记录新增";
        	diag.URL = "<%=path %>/toAddOaKf.do?parentId=${parentId}&ownId=${ownId}";
        	diag.OKEvent = function(){
        		//参数校验
        		var telephone = diag.innerDoc.getElementById("telephone").value;
        		if(telephone == ''){
        			alert('请输入订车记录联系电话');
        			return;
        		}
        		if(telephone.length > 11){
        			alert('请输入正确联系电话');
        			return;
        		}
        		//提交表单
        		diag.innerDoc.getElementById('addForm').submit();
        		diag.submited=true;
        	};//点击确定后调用的方法
        	diag.OnLoad=function(){
        		if(diag.submited){
        			diag.openerWindow.location.reload();
                    try{
        				diag.close();
                    }catch(e){}
        		}
        	};
        	diag.CancelEvent = function(){diag.close();};
        	diag.show();
    }
    
    //在父页面提交iframe中的表单
    //订车记录编辑
    var editSetcar = function(id){
    	var diag = new zDialog();
		diag.Height = 450;
		diag.Title = "客服管理-订车记录编辑";
    	diag.URL = "<%=path %>/toEditOaKf.do?parentId=${parentId}&ownId=${ownId}&carId="+id;
    	diag.OKEvent = function(){
    		diag.innerDoc.getElementById("carId").value = id;
    		diag.innerDoc.getElementById('editForm').submit();
    		diag.submited=true;
    	};//点击确定后调用的方法
    	diag.OnLoad=function(){
    		if(diag.submited){
    			diag.openerWindow.location.reload();
                try{
    				diag.close();
                }catch(e){}
    		}
    	};
    	diag.CancelEvent = function(){diag.close();};
    	diag.show();
    }
    
    
    //订车记录删除
    var delSetcar= function(id,name){
    	/* $('#del-carId').val(id);
    	zDialog.confirm('警告：您确认要删除订车记录['+name+']吗？',function(){
    		document.getElementById('delForm').submit();
    		
    		alert(456);
    	});
    	 */
    	var diag = new zDialog();
		diag.Height = 150;
		diag.Width = 320;
		diag.Title = "客服管理-订车记录删除";
    	diag.URL = "<%=path %>/toDelOaKf.do?parentId=${parentId}&ownId=${ownId}&carId="+id+"&name="+name;
    	diag.OKEvent = function(){
    		diag.innerDoc.getElementById('delForm').submit();
    		diag.submited=true;
    	};//点击确定后调用的方法
    	diag.OnLoad=function(){
    		if(diag.submited){
    			diag.openerWindow.location.reload();
                try{
    				diag.close();
                }catch(e){}
    		}
    	};
    	diag.CancelEvent = function(){diag.close();};
    	diag.show();
    	
    }
    </script>



<iframe name="targetFrame" style="width: 0%; display: none;"></iframe>
<script type="text/javascript">
				$('#usecarDate').datepicker({format:"yyyy-mm-dd"});
				//提交搜索
				
				var submitSearchForm = function(){
					document.getElementById("suserSearchForm").submit();
				}
</script>    

<form id="delForm" name="delForm" method="post" action="doDelOaKf.do" target="thisFrame">
	<input type="hidden" id="del-carId" name="carId">
	<input type="hidden" id="edit-parentId" name="parentId" value="${parentId }">
	<input type="hidden" id="edit-ownId" name="ownId" value="${ownId }">
</form>
<%-- <form id="editForm" name="editForm" method="post" action="toEditOaKf.do" target="_self">
	<input type="hidden" id="edit-carId" name="carId">
	<input type="hidden" id="edit-parentId" name="parentId" value="${parentId }">
	<input type="hidden" id="edit-ownId" name="ownId" value="${ownId }">
</form> --%>
<iframe style="display: none" name="thisFrame"></iframe>
</html>
