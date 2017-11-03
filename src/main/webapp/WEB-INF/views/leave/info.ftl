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
			<li>撤退管理</li>
			<li>撤退申请</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form" action="/leave/approval" method="pose">                                                  
                   <div class="form-group col-lg-6" col-lg-6>
                       <input type="hidden" name="id" value="${leave.id}" >
                       <label class="col-lg-3 control-label">地震名称</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="eqname" value="${leave.eqname}" >
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">单位名称</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="company" value="${leave.company}" >
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">状态</label>
                       <div class="col-lg-9">
                          <input type="text" class="form-control" value="<@ps.leavestate leave.state/>" >
                       </div>
                   </div>
                   
                  
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">撤离备注</label>
                       <div class="col-lg-9">
                          <textarea name="remark" rows="5" cols="50" readonly>${leave.remark}</textarea>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-5 col-lg-7">
                      		<#if leave.state!=1>
                           <button type="submit" class="btn btn-primary" disabled="disabled">已批准</button>
                           	<#else>
                           	<button type="submit" class="btn btn-primary">批准</button>
                           	</#if>
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
</script>

</@override> <@extends name="/base/base.ftl"/>
