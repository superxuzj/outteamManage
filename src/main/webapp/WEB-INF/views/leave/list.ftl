<@override name="head"> </@override> <@override name="body">
<style>
.form-group {
	border-bottom: 0px !important;
	padding-bottom: 1px !important;
	margin-bottom: 1px !important;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>撤退管理</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
<div class="col-lg-12">
           <section class="panel">
               <div class="panel-body">
                   <form class="form-horizontal" role="form" action="/leave/list">
                       <div class="form-group col-lg-3">
                           <label for="inputPassword1" class="col-lg-3 control-label">名称</label>
                           <div class="col-lg-9">
                               <input type="text" class="form-control" name="eqname" value="${outteam. eqname}">
                           </div>
                       </div>
                       <div class="form-group col-lg-3">
                     	  <label for="inputPassword1" class="col-lg-3 control-label">单位</label>
                          <div class="col-lg-9">
                              <input type="text" class="form-control" name="company" value="${outteam.company }">
                          </div>
                       </div>
                       <div class="form-group col-lg-3">
                           <div class="col-lg-offset-2 col-lg-10">
                               <button type="submit" class="btn">搜索</button>
                           </div>
                       </div>
                   </form>
               </div>
           </section>
       </div>
	   <!-- <div class="col-lg-12">
			<a class="btn btn-primary btn-sm" href="" title="Bootstrap 3 themes generator">新增</a>
	   </div> -->
       <div class="col-lg-12">
           <section class="panel">
               <table class="table table-striped table-advance table-hover">
                <tbody>
                   <tr>
                      <th>地震名称</th>
                      <th>单位名称</th>
                      <th>人数</th>
                      <th>状态</th>
                      <th>操作</th>
                   </tr>
                   <#list page.list as outteam>
                   <tr>
                      <td>${outteam.eqname }</td>
                      <td>${outteam.company }</td>
                      <td>${outteam.count }</td>
                      <td><@ps.outteamstate outteam.state/></td>
                      
                      <td>
                       <div class="btn-group">
                           <a class="btn btn-info dropdown-toggle" data-toggle="dropdown" href="" title="Bootstrap 3 themes generator">
                           	操作<span class="caret"></span></a>
                           <ul class="dropdown-menu">
                             <#if outteam.eqcompany==sessioncompany>
                             	<#if outteam.state==4 || outteam.state==5>
                             	<li><a href="javascript:void(0)" onclick="vete('${outteam.lid }')" title="详情">详情</a></li>
                             	<#else>
                             	<li><a href="javascript:void(0)" onclick="vete('${outteam.lid }')" title="审批">审批</a></li>
                             	</#if>
                          	<#else>
                          	
                          		<#if outteam.state==4 || outteam.state==5>
                             	<li><a href="/leave/ask?id=${outteam.id }" title="撤退详情">撤退详情</a></li>
                             	<#else>
								<li><a href="/leave/ask?id=${outteam.id }" title="撤退申请">撤退申请</a></li>
                             	</#if>
                             
                          	</#if>
                           </ul>
                       </div>
                       </td>
                   </tr>
                  </#list>
                </tbody>
                		
             </table>
           </section>
       </div>
       <div class="col-lg-12">
		<#import "/macros/pager.ftl" as p/>
		<@p.pager page/>
	 </div>
   </div>
   <script type="text/javascript">
	function vete(lid){
	if(lid==""){
		alert("该单位还未申请撤离，请等待！");
		return;
	}
	window.location.href="/leave/info?id="+lid;
}
</script>
</@override> <@extends name="/base/base.ftl"/>
