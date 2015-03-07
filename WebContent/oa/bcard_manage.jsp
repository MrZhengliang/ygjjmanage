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
							
							
							
							<button class="btn btn-default mt5" type="button" onClick="submitSearchForm()">
												<i class="icon-search"></i>
							</button>
						</form>
				</div>
                
                
                        <div class="table-responsive">
										${masterCard }
									</div>
									<!-- /.table-responsive -->
								<!-- /row -->
							<div
								style="display: inline-block; background-repeat: no-repeat; border-width: 4px; font-size: 13px; line-height: 1.39; padding: 4px 9px;">
								<a onclick="addSetcar();" href="javascript:;" class="btn btn-success btn-sm">添加</a>
							</div>
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
    var addSetcar = function(){
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
    var editCourse = function(id){
    	$('#edit-courseId').val(id);
    	document.getElementById('editForm').submit();
    }
    
    
    //订车记录删除
    var delCourse= function(id,name){
    	$('#del-userId').val(id);
    	zDialog.confirm('警告：您确认要删除订车记录['+name+']吗？',function(){
    		document.getElementById('delForm').submit();diag.close();
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

<form id="delForm" name="delForm" method="post" action="doDelGroup.do" target="thisFrame">
	<input type="hidden" id="del-userId" name="userId">
</form>
<form id="editForm" name="editForm" method="post" action="toEditCourse.do" target="_self">
	<input type="hidden" id="edit-courseId" name="courseId">
	<input type="hidden" id="edit-parentId" name="parentId" value="${parentId }">
	<input type="hidden" id="edit-ownId" name="ownId" value="${ownId }">
</form>
<iframe style="display: none" name="thisFrame"></iframe>
</html>
