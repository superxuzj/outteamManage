<@override name="head"> </@override> <@override name="body">
<style>

.heightcol{
	height:40px;
}
</style>
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
               <form class="form-horizontal" role="form" 
               data-validator-option="{timely:2, theme:'yellow_right'}"
               action="/company/addOrEdit" method="post">                                                  
                    <input type="hidden" class="form-control" name="id" value="${company.id }" />
                   <div class="form-group">
                       <label class="col-lg-4 control-label">单位简码(单位管理员登录名)</label>
                       <div class="col-lg-3 heightcol">
                           <input type="text" class="form-control" name="code" data-rule="required" value="${company.code }"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-4 control-label">单位全称</label>
                       <div class="col-lg-3 heightcol">
                           <input type="text" class="form-control" name="name" value="${company.name }"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-4 control-label">省局单位</label>
                       <div class="col-lg-3 heightcol">
                           <input type="text" class="form-control" name="province" data-rule="required" value="${company.province }"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-4 control-label">所在地</label>
                       <div class="col-lg-3 heightcol">
                          <select class="form-control m-bot15" name="location" id="location">
                       		 <#list companyList as cl>
                       			 <option value="${cl.province }" <#if company.location==cl.province>selected</#if> >${cl.province }</option>
                       		 </#list>
                          </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-4 control-label">类型</label>
                       <div class="col-lg-3 heightcol">
                           <select class="form-control m-bot15" name="type">
                                              <option value="1" <#if company.type==1>selected</#if>>省局</option>
                                              <option value="2" <#if company.type==2>selected</#if>>单位</option>
                                          </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-4 col-lg-8">
                           <button type="submit" class="btn btn-primary">保存</button>
                           <button type="button" class="btn btn-danger" onclick="gohistory()">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>


</@override> <@extends name="/base/base.ftl"/>
