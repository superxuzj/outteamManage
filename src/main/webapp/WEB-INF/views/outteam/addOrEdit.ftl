<@override name="head">
<style>
.m-bot15{
	margin-bottom:0px;
}
.personpanel{
	margin-left:60px;
	margin-right:-20px;
}
.aleft{
	margin-left:750px;
}
</style>
 </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>出队管理</li>
			<li>
			<#if outteam.id??>
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
               <form class="form-horizontal" role="form" id="outteamform" action="/outteam/save">  
               	   <input type="hidden" name="id" value="${outteam.id }"> 
               	                                                
                   <div class="form-group col-lg-6" col-lg-6>
                       <label class="col-lg-3 control-label">地震名称</label>
                       <div class="col-lg-9">
                       <input type="hidden" name="eqid" value="${outteam.eqid }">   
                           <input type="text" class="form-control" name="eqname" value="${outteam.eqname }" readonly />
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">单位名称</label>
                       <div class="col-lg-9">
                       <input type="hidden" name="cid" value="${outteam.cid }"/>   
                           <input type="text" class="form-control" name="company" value="${outteam.company }" />
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出队类型</label>
                       <div class="col-lg-9">
                           ${outteam.outtype }
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">状态</label>
                       <div class="col-lg-9">
                       	<#if outteam.state==1>
                       		<input type="text" class="form-control" value="通知" disabled>
                       	<#elseif outteam.state==1>
                       		<input type="text" class="form-control" value="出队 " disabled>
                       	<#else>
                       		<input type="text" class="form-control" value="结束 " disabled>
                       	</#if>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">人数</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="count" value="${outteam.count }">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">航班号</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="flight" value="${outteam.flight }">
                       </div>
                       <a class="btn btn-primary btn-sm" href="javascript:getFliht()" title="获取航班信息">获取航班信息</a>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发地点</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" />
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达地点</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" />
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control"/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" />
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">总结</label>
                       <div class="col-lg-9">
                          <input type="text" class="form-control" id="mobile" placeholder=" ">
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-sm-11">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   出队队员列表 
                      <a class="btn btn-danger btn-sm aleft" href="javascript:void(0)" onclick="choosePerson()" title="">添加队员</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>姓名</th>
                                  <th>单位</th>
                                  <th>电话</th>
                              </tr>
                              </thead>
                              <tbody id="usertbody">
                             
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
                   <input type="hidden" name="chooses" id="chooses"/>
                   <input type="hidden" name="contacts" id="contacts"/>
                   <input type="hidden" name="leaders" id="leaders"/>
                   <div class="form-group">
                       <div class="col-lg-offset-5 col-lg-7">
                           <button type="button" class="btn btn-primary" onclick="save()">确认</button>
                           <button type="button" class="btn btn-danger">Cancel</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
function save(){
	$("#outteamform").submit();
}

function getFliht(){
	alert(1);
	
}
function choosePerson(){
   	 layer.open({
			type: 2,
		    area: ['750px', '561px'],
		    fix: false, //不固定
		    title: "队员列表",
		    maxmin: true,
		    content: '/outteam/personlist?cid=${outteam.cid}'
		}); 
}
</script>

</@override> <@extends name="/base/base.ftl"/>
