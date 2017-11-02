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
                       <label class="col-lg-2 control-label">省份</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="province" value="${company.province }" disabled/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">类型</label>
                       <div class="col-lg-6">
                            <select class="form-control m-bot15" name="type">
                                              <option value="1" <#if company.type==1>selected</#if>>省局</option>
                                              <option value="2" <#if company.type==2>selected</#if>>单位</option>
                                          </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="button" class="btn btn-danger" onclick="history()">返回</button>
                           
                           <a href="javascript:history.go(-1)" title="删除">返回</a>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
	function history(){
		window.location.go(-1);
	}
</script>
</@override> <@extends name="/base/base.ftl"/>
