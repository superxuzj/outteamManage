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
			<li>联动管理</li>
			<li>
			<#if link.id??>
				修改
			<#else>
				添加
			</#if>
			</li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form" id="linkform"
               data-validator-option="{timely:2, theme:'yellow_top'}" action="/link/save">  
               <input type="hidden" name="id" id="hiddenid" value="${link.id }" />                                                
                   <div class="form-group">
                       <label class="col-lg-2 control-label">联动条件名称</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="name" value="${link.name }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">联动对应响应等级</label>
                       <div class="col-lg-6">
                           <select class="form-control m-bot15" name="rid">
                           		<#list  responseList as response>
                                <option value="${response.id }" <#if response.id==link.rid>selected</#if>>${response.name }</option>
                                </#list>
                            </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">对应受灾省份</label>
                       <div class="col-lg-6">
                           <select class="form-control m-bot15" name="eqcid">
                             <#list companyList as company>
                                <option value="${company.id }" <#if company.id==link.eqcid>selected</#if>>${company.province }</option>
                             </#list>
                            </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">备注</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="remark" value="${link.remark }"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   联动单位 
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
                               <#list detailList as duty>
                              	 <tr>
	                                  <td class="test" cid="${duty.cid }">${duty.cid }</td>
	                                  <td class="test">${duty.company }</td>
	                                  <td class="test"><input type="text" class="inputvale" value="${duty.count }"/></td>
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
	//保存hbplan
	$.ajax({ 
           type: "POST",
           url:"/link/save",
           data:$('#linkform').serialize(),// 你的formid
           async: false,
           success: function(data) {
           		$("#hiddenid").val(data);//id框
          		//删除之前配置 
        		$.ajax({
        			type : "post",
        			url : "/link/delyLinkDetail",
        			data : "linkid=" +data,
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
       					url : "/link/addLinkDetail",
       					data : "linkid=" + data+"&cid="+cid+"&count="+count,
       					dataType : 'text',
       					async:false,
       					success : function(data) {
       					}
       				});
        		}); 
           }
	});
	
	window.location.href="/link/list";
	//$("#linkform").submit();
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
