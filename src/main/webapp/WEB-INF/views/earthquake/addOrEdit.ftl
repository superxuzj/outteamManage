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
                   <input type="hidden"  name="id" value="${earthquake.id}"/>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eqname" value="${earthquake.eqname}"/>
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
                           <input type="text" class="form-control" name="area" value="${earthquake.area}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">省市</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="province" value="${earthquake.province}"/>
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
                           <select class="form-control m-bot15">
                                              <option>Option 1</option>
                                              <option>Option 2</option>
                                              <option>Option 3</option>
                                          </select>
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
                           <input type="text" class="form-control" name="eqdate" value="${earthquake.eqdate}"/>
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
                   <div class="form-group">
                       <label class="col-lg-2 control-label">响应等级</label>
                       <div class="col-lg-6">
                          <select class="form-control m-bot15" name="responseid">
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
                           <button type="button" class="btn btn-primary" onclick="save(${earthquake.id})">保存</button>
                           <button type="button" class="btn btn-danger">Cancel</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
	function save(id){
		$.ajax({  
	         type : "POST",  //提交方式  
	         url : "/earthquake/valCompany",//路径  
	         data : {  
	             "id" : id 
	         },//数据，这里使用的是Json格式进行传输  
	         success : function(result) {//返回数据根据结果进行相应的处理  
	         	if(result=="success"){
	         		layer.open({
	        			type: 2,
	        		    area: ['750px', '561px'],
	        		    fix: false, //不固定
	        		    title: "出队列表",
	        		    maxmin: true,
	        		    content: '/earthquake/ruleoutteam?id='+id
	        		}); 
	         	}
	         }
	     });
		
		
		// $("#earthquakeForm").submit();
	}
</script>
</@override> <@extends name="/base/base.ftl"/>