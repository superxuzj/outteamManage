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
                   <form class="form-horizontal" role="form">
                       <div class="form-group col-lg-3">
                           <label for="inputPassword1" class="col-lg-3 control-label">名称</label>
                           <div class="col-lg-9">
                               <input type="text" class="form-control" id="inputPassword1" placeholder="名称">
                           </div>
                       </div>
                       <div class="form-group col-lg-3">
                      	 <label for="inputPassword1" class="col-lg-3 control-label">类型</label>
                           <div class="col-lg-9">
                             <select class="form-control m-bot15">
                                   <option>Option 1</option>
                                   <option>Option 2</option>
                                   <option>Option 3</option>
                               </select>
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
	   <div class="col-lg-12">
			<a class="btn btn-primary btn-sm" href="" title="Bootstrap 3 themes generator">新增</a>
	   </div>
       <div class="col-lg-12">
           <section class="panel">
               <table class="table table-striped table-advance table-hover">
                <tbody>
                   <tr>
                      <th>地震名称</th>
                      <th>单位名称</th>
                      <th>出队类型</th>
                      <th>人数</th>
                      <th>状态</th>
                      <th>操作</th>
                   </tr>
                   <#list page.list as outteam>
                   <tr>
                      <td>${outteam.eqname }</td>
                      <td>${outteam.company }</td>
                      <td>${outteam.state }</td>
                      <td>${outteam.count }</td>
                      <td>${outteam.state }</td>
                      
                      <td>
                       <div class="btn-group">
                           <a class="btn btn-info dropdown-toggle" data-toggle="dropdown" href="" title="Bootstrap 3 themes generator">
                           	操作<span class="caret"></span></a>
                           <ul class="dropdown-menu">
                             <li><a href="/outteam/info?id=${outteam.id }" title="详情">详情</a></li>
                             <li class="divider"></li>
                             <li><a href="/outteam/del?id=${outteam.id }" title="结束">撤退</a></li>
                           </ul>
                       </div>
                       </td>
                   </tr>
                  </#list>
                </tbody>
                		
             </table>
           </section>
           	这里是分页的页码
       </div>
   </div>
</@override> <@extends name="/base/base.ftl"/>
