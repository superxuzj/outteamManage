<@override name="head"> </@override> <@override name="body">
<style>

.aleft{
	margin-left:480px;
}
.secondtd{
	padding-left:290px !important;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>华北预案管理</li>
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
               <form class="form-horizontal" role="form" id="hbplanform"
               data-validator-option="{timely:2, theme:'yellow_top'}" action="/hbplan/save">  
               <input type="hidden" name="id" id="hiddenid" value="${hbplan.id }" />                                                
                   <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="name" value="${hbplan.name }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">受灾省份</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="companys" value="${hbplan.companys }" placeholder="多个省份用空格"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">对应震级</label>
                       <div class="col-lg-6">
                           <input  type="text" name="low" value="${hbplan.low }"/>----<input  type="text" name="high" value="${hbplan.high }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">备注</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="remark" value="${hbplan.remark }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   第一梯队
                      <a class="btn btn-danger btn-sm aleft" href="javascript:void(0)" onclick="addFirstCompany()" title="">添加单位</a>
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
                               <#list firstdetailList as detail>
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
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   第二梯队
                      <a class="btn btn-danger btn-sm aleft" href="javascript:void(0)" onclick="addSecondCompany()" title="">添加单位</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>单位id</th>
                                  <th >省份</th>
                                  <th>人数</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody id="secondcompanytbody">
                               <#list seconddetailList as detail>
                              	 <tr>
	                                  <td class="test" cid="${detail.cid }">${detail.cid }</th>
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
                   <input type="hidden" name="secondcids" id="secondcids"/>
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
function firstdel(me){
	$(me).parent().parent().remove();
}
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
	$("#secondcompanytbody tr").each(function(){  
		if($("td:eq(2)",this).children(".inputvale").val()==""){
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
           url:"/hbplan/save",
           data:$('#hbplanform').serialize(),// 你的formid
           async: false,
           success: function(data) {
           		$("#hiddenid").val(data);//id框
          		//删除之前配置 type=1
        		$.ajax({
        			type : "post",
        			url : "/hbplan/delHbplanDetail",
        			data : "hbplanid=" +data+"&type="+1,
        			dataType : 'text',
        			async:false,
        			success : function(data) {
        			}
        		});
        		//保存type1
        		$("#companytbody tr").each(function(){     	
        	    		var count=$("td:eq(2)",this).children(".inputvale").val();
        	    		var cid=$("td:eq(0)",this).attr("cid");
        				$.ajax({
        					type : "post",
        					url : "/hbplan/addHbplanDetail",
        					data : "hbplanid=" + data+"&cid="+cid+"&count="+count+"&type="+1,
        					dataType : 'text',
        					async:false,
        					success : function(data) {
        					}
        				});
        		}); 
        		
        		//删除之前配置type=2
        		$.ajax({
        			type : "post",
        			url : "/hbplan/delHbplanDetail",
        			data : "hbplanid=" +data+"&type="+2,
        			dataType : 'text',
        			async:false,
        			success : function(data) {
        			}
        		});
           		//保存type2
        		$("#secondcompanytbody tr").each(function(){     	
        	    		var count=$("td:eq(2)",this).children(".inputvale").val();
        	    		var cid=$("td:eq(0)",this).attr("cid");
        				$.ajax({
        					type : "post",
        					url : "/hbplan/addHbplanDetail",
        					data : "hbplanid=" + data+"&cid="+cid+"&count="+count+"&type="+2,
        					dataType : 'text',
        					async:false,
        					//jsonp: 'jsonpcallback',
        					success : function(data) {
        							//alert(data);
        					}
        				});
        		});
           	
           }
	});
	
	window.location.href="/hbplan/list";
	//$("#hbplanform").submit();
}

function addFirstCompany(){
   	 layer.open({
			type: 2,
		    area: ['750px', '561px'],
		    fix: false, //不固定
		    title: "单位列表",
		    maxmin: true,
		    content: '/company/allhascount'
		}); 
}

function addSecondCompany(){
  	 layer.open({
			type: 2,
		    area: ['750px', '561px'],
		    fix: false, //不固定
		    title: "单位列表",
		    maxmin: true,
		    content: '/company/second'
		}); 
}
</script>
</@override> <@extends name="/base/base.ftl"/>
