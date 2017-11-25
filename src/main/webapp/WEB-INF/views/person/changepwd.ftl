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
               <form class="form-horizontal" role="form"  id="userform" action="/person/savepwd">                                                  
                   <div class="form-group col-lg-12">
                       <label class="col-lg-3 control-label">登录名称</label>
                       <div class="col-lg-7">
                       	   <input type="hidden" name="id" value="${user.id }">
                           <input type="text" class="form-control"  value="${user.username }" readonly>
                       </div>
                   </div>
                   <div class="form-group col-lg-12">
                       <label class="col-lg-3 control-label">单位</label>
                       <div class="col-lg-7">
                         <input type="hidden" name="cid" value="${user.cid }">
                         <input type="text" class="form-control" value="${user.company }" readonly>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-12">
                       <label class="col-lg-3 control-label">旧密码</label>
                       <div class="col-lg-7">
                         <input type="password" class="form-control" id="oldpwd" >
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-12">
                       <label class="col-lg-3 control-label">新密码</label>
                       <div class="col-lg-7">
                         <input type="password" class="form-control" id="newpwd1">
                       </div>
                   </div>
                   <div class="form-group col-lg-12">
                       <label class="col-lg-3 control-label">新密码确认</label>
                       <div class="col-lg-7">
                         <input type="password" class="form-control" name="password" id="newpwd2">
                       </div>
                   </div>
                   
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="button" class="btn btn-primary"  onclick="save()">保存</button>
                           <button type="button" class="btn btn-danger" onclick="gohistory()">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>
<script type="text/javascript">
function save(){
	var oldpassword = '${user.password}';
	if($("#oldpwd").val()==""){
		alert("请输入旧密码！");
		return ;
	}
	if($("#oldpwd").val()!=oldpassword){
		alert("旧密码不正确，请重新输入！");
		return ;
	}
	
	if($("#newpwd1").val()=="" && $("#newpwd2").val()==""){
		alert("请输入新密码！");
		return;
	}
	
	if($("#newpwd1").val()!="" && $("#newpwd2").val()!=""){
		if($("#newpwd1").val() != $("#newpwd2").val()){
			alert("两次输入新密码不一致！");
			return;
		}
	}
	
	if($("#newpwd1").val()!="" && $("#newpwd2").val()==""){
		alert("请输入新密码！");
		return;
	}
	if($("#newpwd1").val()=="" && $("#newpwd2").val()!=""){
		alert("请输入新密码！");
		return;
	}
	
	alert("密码修改成功，请重新登录！");
	$("#userform").submit();
}
</script>

</@override> <@extends name="/base/base.ftl"/>
