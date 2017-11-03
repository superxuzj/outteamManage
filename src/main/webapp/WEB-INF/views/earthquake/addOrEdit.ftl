<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>地震事件管理</li>
			<li>
			<#if earthquake.id??>
			修改
			<#else>
			添加
			</#if>
			</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" action="/earthquake/save" id="earthquakeForm" method="POST">                                                  
                   <input type="hidden" id="hiddenid" name="id" value="${earthquake.id}"/>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eqname" id="eqname" value="${earthquake.eqname}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">地震唯一标识码</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eventid" value="${earthquake.eventid}" />
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">区域</label>
                       <div class="col-lg-6">
                       		<select class="form-control m-bot15" name="area" id="area">
                       			 <option value="非华北" <#if earthquake.area=='非华北' >selected</#if> >非华北</option>
                                 <option value="华北"  <#if earthquake.area=='华北' >selected</#if> >华北</option>
                            </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">省份</label>
                       <div class="col-lg-6">
                       
                       <select class="form-control m-bot15" name="province" id="province">
                       		<#list companyList as company>
                       			 <option value="${company.province }" >${company.province }</option>
                       			 </#list>
                            </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">位置</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="location" value="${earthquake.location}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">地震等级</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="magnitude" id="magnitude" value="${earthquake.magnitude}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">经度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="longitude" value="${earthquake.longitude}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">纬度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="latitude" value="${earthquake.latitude}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">发震日期</label>
                       <div class="col-lg-6">
                       	<input class="form-control Wdate" type="text" name="eqdate" id="eqdate" value="${earthquake.eqdate }" onclick="WdatePicker({maxDate:'%y-%M-%d'})"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">发震时刻</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eqtime" value="${earthquake.eqtime}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">震源深度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="depth" value="${earthquake.depth}">
                       </div>
                   </div>
                   <div class="form-group"  id="responddiv">
                       <label class="col-lg-2 control-label">响应等级</label>
                       <div class="col-lg-6">
                          <select class="form-control m-bot15" name="responseid" id="responseid">
                          <option value="" >请选择</option>
	                          <#list responseList as response>
	                          	<option value="${response.id }" <#if response.id==earthquake.responseid>selected="selected"</#if> >
	                          		${response.name }
	                          	</option>
	                          </#list>
                          </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="button" class="btn btn-primary" onclick="save()">保存</button>
                           <button type="button" class="btn btn-danger" onclick="gohistory()">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
function gohistory(){
	window.history.go(-1);
}


	function save(){
		if($("#eqname").val()==""){
			alert("请输入地震名称！");
			return false;
		}
		if($("#magnitude").val()==""){
			alert("请输入地震等级！");
			return false;
		}
		if($("#area").val()=="非华北" && $("#responseid").val()==""){
			alert("请选择响应等级");
			return false;
		}
		var rid=$("#responseid").val();
		var id = $("#hiddenid").val();
		//新增
		if(id==null || id==''){
			$.ajax({ 
	            type: "POST",
	            url:"/earthquake/savenew",
	            data:$('#earthquakeForm').serialize(),// 你的formid
	            async: false,
	            success: function(data) {
	            	$("#hiddenid").val(data);//返回的地震id赋值给id框
	            	layer.open({
	        			type: 2,
	        		    area: ['780px', '561px'],
	        		    fix: false, //不固定
	        		    title: "出队列表",
	        		    maxmin: true,
	        		    content: '/earthquake/ruleoutteam?id='+data+"&rid="+rid
	        		}); 
	            }
			});
		}else{
			$.ajax({  
		         type : "POST",  //提交方式  
		         url : "/earthquake/valCompany",//判断是否已经安排了出队
		         data:$('#earthquakeForm').serialize(),// 你的formid
		         success : function(result) {//返回数据根据结果进行相应的处理  
		         	if(result=="success"){
		         		layer.open({
		        			type: 2,
		        		    area: ['780px', '561px'],
		        		    fix: false, //不固定
		        		    title: "出队列表",
		        		    maxmin: true,
		        		    content: '/earthquake/ruleoutteam?id='+id+"&rid="+rid
		        		}); 
		         	}else{
		         		alert("已确定出队单位，请在出队管理界面查看！");
		         		window.location.href="/earthquake/list";
		         	}
		         }
		     });
		}
		
		// $("#earthquakeForm").submit();
	}
	
	
	$(document).on("change",'select#area',function(){
		var val = $(this).val();
		if(val=="华北"){
			$("#responddiv").hide();
		}else{
			$("#responddiv").show();
		}
	});
</script>
</@override> <@extends name="/base/base.ftl"/>
