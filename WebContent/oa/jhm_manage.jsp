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
	    height: 32px;
	    line-height: 1.42857;
	    padding: 6px 12px;
	    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
	    vertical-align: middle;
	    display: inline;
	    width:10%;
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
	                        <h5>客服管理-激活码管理</h5>
	                </div>
	            </div>
	            <hr />
	                <div class="page-header mr0">
						<form id="suserSearchForm" name="suserSearchForm"
							action="<spring:url value='/oajhmmanage.do' htmlEscape='true'/>"
							method="post" target="_self">
							<input type="hidden" id="parentId" name="parentId" value="${parentId }" />
							<input type="hidden" id="ownId" name="ownId" value="${ownId }" />
							
							<i class="icon-hand-right"></i><span>搜索</span>
							
							<input type="text" placeholder="输入激活码" class="form-control" 
									id="masterCard" name="masterCard" value="${masterCard }"
								autocomplete="off" />
							
							<input type="text" placeholder="微信" class="form-control" 
									id="weixinCode" name="weixinCode" value="${weixinCode }"
								autocomplete="off" /> 
							
							
							<button class="btn btn-default mt5" type="button" onClick="submitSearchForm()">
												<i class="icon-search"></i>
							</button>
							<div
								style="display: inline-block; background-repeat: no-repeat; border-width: 4px; font-size: 13px; line-height: 1.39; padding: 4px 9px;">
								<a onclick="addJhm();" href="javascript:;" class="btn btn-success btn-sm">添加</a>
							</div>
						</form>
				</div>
                
                
                        <div class="table-responsive">
										<table id="sample-table-1"
											class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th class="center">序号</th>
													<th>激活码</th>
													<th>备用卡</th>
													<th>用户名</th>
													<th>联系电话</th>
													<th>淘宝</th>
													<th>微信</th>
													<th>快递号</th>
													<th>购买日期</th>
													<th>套餐日期</th>
													<th>备注</th>
													<th>金额</th>
													<th>操作员</th>
													<th>操作</th>
												</tr>
											</thead>

											<tbody>
												<c:forEach items="${giffgaffList}" var="giffgaff"
													varStatus="status">
													<tr>
														<td>${giffgaff.id}</td>
														<td>${giffgaff.masterCard}</td>
														<td>${giffgaff.sliverCard}</td>
														<td>${giffgaff.username}</td>
														<td>${giffgaff.terminalId}</td>
														<td>${giffgaff.taobaoId}</td>
														<td>${giffgaff.weixinCode}</td>
														<td>${giffgaff.deliverCode}</td>
														<td>${giffgaff.buyDate}</td>
														<td>${giffgaff.packDate}</td>
														<td>${fn:substring(giffgaff.remark,0,6)}...</td>
														<td>${giffgaff.amount}</td>
														<td>${giffgaff.operateName}</td>

														<td>													
														<c:if test="${giffgaff.id > 0}">
															<a data-toggle="modal" href="#suserEdit"
															onClick="editJhm('${giffgaff.id}');"
															class="btn btn-xs btn-primary"><i class="icon-edit"></i></a>
															<a data-toggle="modal" href="#suserDel"
																onClick="delJhm('${giffgaff.id}','${giffgaff.username}');"
																class="btn btn-xs btn-danger"><i class="icon-trash"></i></a>
														</c:if>
															
														</td>
													</tr>
												</c:forEach>

												<c:if test="${page.totalRowNum>0}">
													<c:if test="${page.totalRowNum >= pageSize}">
														<tr class="page_c">
															<td colspan="16">${page.display}</td>
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
    

  	//订车记录新增
    var addJhm = function(){
    		var diag = new zDialog();
    		diag.Height = 470;
        	diag.Title = "客服管理-激活码新增";
        	diag.URL = "<%=path %>/toAddOaJhm.do";
        	diag.OKEvent = function(){
        		//参数校验
        		/* var title = diag.innerDoc.getElementById("title").value;
        		var name = diag.innerDoc.getElementById("name").value;
        		if(title == '' || name == ''){
        			alert('请输入订车记录名和姓名');
        			//$("input[type='text'][name='usercode']").focus();
        			return;
        		} */
        		
        		//提交表单
        		diag.innerDoc.getElementById('addJhmForm').submit();
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
    var editJhm = function(id){
    	var diag = new zDialog();
		diag.Height = 470;
    	diag.Title = "客服管理-激活码编辑";
    	diag.URL = "<%=path %>/toEditOaJhm.do?parentId=${parentId}&ownId=${ownId}&jhmId="+id;;
    	diag.OKEvent = function(){
    		diag.innerDoc.getElementById("jhmId").value = id;
    		//提交表单
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
    var delJhm= function(id,name){
    		$('#del-jhmId').val(id);
    		zDialog.confirm('警告：您确认要删除激活码记录['+name+']吗？',function(){
	    		document.getElementById('delForm').submit();
	    		diag.close();
    		});
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

<form id="delForm" name="delForm" method="post" action="doOaJhmDel.do" target="thisFrame">
	<input type="hidden" id="del-jhmId" name="jhmId">
	<input type="hidden" id="del-parentId" name="parentId" value="${parentId }">
	<input type="hidden" id="del-ownId" name="ownId" value="${ownId }">
</form>
<%-- <form id="editForm" name="editForm" method="post" action="toEditJhm.do" target="_self">
	<input type="hidden" id="edit-courseId" name="courseId">
	<input type="hidden" id="edit-parentId" name="parentId" value="${parentId }">
	<input type="hidden" id="edit-ownId" name="ownId" value="${ownId }">
</form> --%>
<iframe style="display: none" name="thisFrame"></iframe>
</html>
