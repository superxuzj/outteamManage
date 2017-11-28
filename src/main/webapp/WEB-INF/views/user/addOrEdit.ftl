<@override name="head">
<style>
.personpanel{
	margin-left:40px;
	margin-right:20px;
}
.aleft{
	margin-left:780px;
}
.heightcol{
	height:40px;
}
</style>
 </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>用户管理</li>
			<li>
			<#if user.id??>
				修改
			<#else>
				添加
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
                id="userform" action="/user/save">    
             	  <input type="hidden" name="id" value="${user.id }">                                              
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">姓名</label>
                       <div class="col-lg-7 heightcol">
                           <input type="text" class="form-control" name="name" data-rule="required" value="${user.name }">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">性别</label>
                       <div class="col-lg-7 heightcol">
                           <select class="form-control m-bot15" name="sex">
                                <option value="1" <#if user.sex==1>selected</#if>>男</option>
                                <option value="2" <#if user.sex==2>selected</#if>>女</option>
                            </select>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">身份证号</label>
                       <div class="col-lg-7 heightcol">
                           <input type="text" class="form-control" name="idcard" 
                           value="${user.idcard }" data-rule="required IDcard">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">单位</label>
                       <div class="col-lg-7 heightcol">
                          <select class="form-control m-bot15" name="cid">
                          <#if sessionroleid==1>
                             <#list companyList as company>
                             <#if user??>
                                <option value="${company.id }"  <#if company.id==user.cid>selected="selected"</#if> >${company.province }</option>
                            <#else>
                            <option value="${company.id }"  <#if company.id==sessioncid>selected="selected"</#if> >${company.province }</option>
                            </#if>
                             </#list>
                            <#else>
                            <option value="${sessioncid }"  >${sessioncompany}</option>
                            </#if>
                            </select>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">联系电话</label>
                       <div class="col-lg-7 heightcol">
                           <input type="text" class="form-control" name="phone" value="${user.phone }" data-rule="required mobile">
                       </div>
                   </div>
                  
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">救援专业</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" name="profession" value="${user.profession }">
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="submit" class="btn btn-primary"  onclick="save()">保存</button>
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
	$("#userform").submit();
}
</script>

</@override> <@extends name="/base/base.ftl"/>
