<@override name="head"> 
<style>
.nameclass{
margin-top:5px !important;
}
</style>
</@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>地震事件管理</li>
			<li>出队成员</li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form">                                                  
                  <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eqname" value="${earthquake.eqname}"/>
                       </div>
                   </div>
                   
                   <#list details as outteamDetail>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">${outteamDetail.company}（共${outteamDetail.userid}人）</label>
                       <div class="col-lg-6 nameclass">
                       ${outteamDetail.name}
                       </div>
                   </div>
                   </#list>
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                       <button type="button" class="btn btn-primary" onclick="exportall(${earthquake.id })">导出</button>
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
function exportall(id){
	window.location.href = "/earthquake/export?id="+id;
}
</script>

</@override> <@extends name="/base/base.ftl"/>
