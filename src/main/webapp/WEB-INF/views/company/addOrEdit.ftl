<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>单位管理</li>
			<li>
				<#if company.id??>
				修改
				<#else>
				新增
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
               <form class="form-horizontal" role="form" action="/company/addOrEdit" method="post">                                                  
                    <input type="hidden" class="form-control" name="id" value="${company.id }" />
                   <div class="form-group">
                       <label class="col-lg-2 control-label">单位简码</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="code" value="${company.code }"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">单位全称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="name" value="${company.name }"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">省份</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="province" value="${company.province }"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">类型</label>
                       <div class="col-lg-6">
                           <select class="form-control m-bot15">
                                              <option>Option 1</option>
                                              <option>Option 2</option>
                                              <option>Option 3</option>
                                          </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="submit" class="btn btn-primary">保存</button>
                           <button type="button" class="btn btn-danger">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>


</@override> <@extends name="/base/base.ftl"/>
