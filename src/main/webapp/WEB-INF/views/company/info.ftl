<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>单位管理</li>
			<li>单位详情</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form">                                                  
                    <input type="hidden" class="form-control"  value="${company.id }" />
                   <div class="form-group">
                       <label class="col-lg-2 control-label">单位简码</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="code" value="${company.code }" disabled/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">单位全称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="name" value="${company.name }" disabled/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">省局单位</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="province" value="${company.province }" disabled/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">所在地</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="location" value="${company.location }" disabled/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">类型</label>
                       <div class="col-lg-6">
                            <select class="form-control m-bot15" name="type">
                            <#if company.type==1>
                            <option>省局</option>
							<#else>
							<option>单位</option>
							</#if>		
                            </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="button" class="btn btn-danger" onclick="gohistory()">返回</button>
                           
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
</script>
</@override> <@extends name="/base/base.ftl"/>
