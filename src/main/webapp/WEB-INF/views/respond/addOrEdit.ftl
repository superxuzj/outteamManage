<@override name="head"> </@override> <@override name="body">
<style>

.aleft{
	margin-left:480px;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>响应管理</li>
			<li>
			<#if response.id??>
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
               <form class="form-horizontal" role="form" id="responseform"
               data-validator-option="{timely:2, theme:'yellow_top'}" action="/respond/save">                                                  
                    <input type="hidden"  name="id"  value="${response.id }">
                   <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                       
                           <input type="text" class="form-control" name="name" value="${response.name }" <#if response??>readonly</#if>>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">响应等级</label>
                       <div class="col-lg-6">
                          <select class="form-control m-bot15" name="grade">
                          	   <#if response??>
                               <option value="${response.grade }" >${response.name }</option>
                          	   <#else>
   								<option value="1" <#if response.grade==1>selected="selected"</#if> >一级响应</option>
                               <option value="2" <#if response.grade==2>selected="selected"</#if>>二级响应</option>
                          	   </#if>
                           </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   出队单位
                         <a class="btn btn-danger btn-sm aleft" href="javascript:void(0)" onclick="addCompany()" title="">添加单位</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>单位id</th>
                                  <th>省份</th>
                                  <th>人数</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody id="companytbody">
                                <#list companyList as detail>
                              	 <tr>
	                                  <td class="test" cid="${detail.cid }">${detail.cid }</td>
	                                  <td class="test">${detail.company }</td>
	                                  <td class="test"><input type="text" class="inputvale" value="${detail.count }"/></td>
	                                  <td class="test"><input type="button" value="删除" onclick="firstdel(this)"></td>
                             	 </tr>
                               </#list>
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
                   <input type="hidden" name="cids" id="cids"/>
                   
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="button" id="buttonsava" class="btn btn-primary" onclick="save()">保存</button>
                           <button type="button" class="btn btn-danger" onclick="gohistory()">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
function save(){
	//数字验证
	var val = "true";
	$("#companytbody tr").each(function(){   
		if($("td:eq(2)",this).children(".inputvale").val()==""){//非空判断
			alert("人数只能填数字");
       		val="fail";
       	    return false;
		}
       	if(isNaN($("td:eq(2)",this).children(".inputvale").val())){//必须是数字
       		alert("人数只能填数字");
       		val="fail";
       	    return false;
       	}
   	});
	if(val=="fail"){
		return false;
	}
	$('#buttonsava').attr('disabled',"true");//添加disabled属性 
	var data = '${response.id }';
	$.ajax({
		type : "post",
		url : "/respond/delResponseCompany",
		data : "rid=" +data,
		dataType : 'text',
		async:false,
		success : function(data) {
		}
	});
	//保存
	$("#companytbody tr").each(function(){     	
   		var count=$("td:eq(2)",this).children(".inputvale").val();
   		var cid=$("td:eq(0)",this).attr("cid");
			$.ajax({
				type : "post",
				url : "/respond/addResponseCompany",
				data : "rid=" + data+"&cid="+cid+"&count="+count,
				dataType : 'text',
				async:false,
				success : function(data) {
				}
			});
	}); 
	window.location.href="/respond/list";
	//$("#responseform").submit();
}
function firstdel(me){
	$(me).parent().parent().remove();
}
function addCompany(){
   	 layer.open({
			type: 2,
		    area: ['750px', '561px'],
		    fix: false, //不固定
		    title: "单位列表",
		    maxmin: true,
		    content: '/company/allhascount'
		}); 
}

</script>
</@override> <@extends name="/base/base.ftl"/>
