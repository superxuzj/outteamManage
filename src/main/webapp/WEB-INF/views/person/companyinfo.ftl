<@override name="head">
<style>
.personpanel{
	margin-left:40px;
	margin-right:20px;
}
.aleft{
	margin-left:780px;
}
</style>
 </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>我的信息</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form"  id="companyuserform" action="/person/save">                                                  
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">登录名称</label>
                       <div class="col-lg-7">
                       	   <input type="hidden" name="id" value="${user.id }">
                           <input type="text" class="form-control" name="username" value="${user.username }">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">单位</label>
                       <div class="col-lg-7">
                         <input type="hidden" name="cid" value="${user.cid }">
                         <input type="text" class="form-control" name="company" value="${user.company }">
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">手机号1</label>
                       <div class="col-lg-7">
                         <input type="text" class="form-control" name="phoneone" value="${user.phoneone }">
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">手机号2</label>
                       <div class="col-lg-7">
                         <input type="text" class="form-control" name="phonetwo" value="${user.phonetwo }">
                       </div>
                   </div>
                   
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="submit" class="btn btn-primary"  onclick="save()">保存</button>
                           <button type="button" class="btn btn-danger">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>
<script type="text/javascript">
<script type="text/javascript">
	function save(){
		$("#companyuserform").submit();
	}
</script>
</script>

</@override> <@extends name="/base/base.ftl"/>
