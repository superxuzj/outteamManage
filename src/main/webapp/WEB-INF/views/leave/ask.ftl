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
               <form class="form-horizontal" role="form" action="/leave/save" method="pose">                                                  
                   <div class="form-group col-lg-6" col-lg-6>
                       <input type="hidden" name="id" value="${outteam.lid}" >
                   	   <input type="hidden" name="otid" value="${outteam.id}" >
                       <label class="col-lg-3 control-label">地震名称</label>
                       <div class="col-lg-9">
                      	   <input type="hidden" name="eqid" value="${outteam.eqid}" >
                           <input type="text" class="form-control" name="eqname" value="${outteam.eqname}" >
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">单位名称</label>
                       <div class="col-lg-9">
                       	   <input type="hidden" name="cid" value="${outteam.cid}" >
                           <input type="text" class="form-control" name="company" value="${outteam.company}" >
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出队类型</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="outtype" value="${outteam.outtype}" >
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">状态</label>
                       <div class="col-lg-9">
                          <input type="text" class="form-control" name="state" value="${outteam.state}" >
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">人数</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="occupation" placeholder=" ">
                       </div>
                   </div>
                  
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">撤离备注</label>
                       <div class="col-lg-9">
                          <textarea name="remark" rows="5" cols="50">这里写内容</textarea>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-5 col-lg-7">
                           <button type="submit" class="btn btn-primary">申请</button>
                           <button type="button" class="btn btn-danger">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
function choosePerson(){
	
   	 layer.open({
			type: 2,
		    area: ['750px', '561px'],
		    fix: false, //不固定
		    title: "队员列表",
		    maxmin: true,
		    content: '/outteam/personlist'
		}); 
}
</script>

</@override> <@extends name="/base/base.ftl"/>
