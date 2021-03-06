<@override name="head"> </@override> <@override name="body">
<style>
.form-group {
	border-bottom: 0px !important;
	padding-bottom:1px !important;
	margin-bottom:1px !important;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>用户管理</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="/user/list">
					<div class="form-group col-lg-3">
						<label for="inputPassword1" class="col-lg-3 control-label">姓名</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" name="name" value="${user.name }">
						</div>
					</div>
					<div class="form-group col-lg-3">
						<label for="inputPassword1" class="col-lg-3 control-label">单位</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" name="company" value="${user.company }">
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
		<a class="btn btn-primary btn-sm" href="javascript:add();" title="新增">新增</a>
	</div>
	<div class="col-lg-12">
		<section class="panel">
			<table class="table table-striped table-advance table-hover">
				<tbody>
					<tr>
					    <th>角色</th>
						<th>姓名</th>
						<th>性别</th>
						<th>单位</th>
						<th>电话</th>
						<th>专业技能</th>
						<th>操作</th>
					</tr>
					
					<#list page.list as user>
					<tr>
						<td><@ps.userroleid user.roleid/></td>
						<td>${user.name }</td>
						<td>
						<#if user.sex==2>
						女
						<#else>
						男
						</#if>
						</td>
						<td>${user.company }</td>
						<td>${user.phone }</td>
						<td>${user.profession }</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
									href="" title="Bootstrap 3 themes generator"> 操作<span
									class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/user/info?id=${user.id }"
										title="详情">详情</a>
									</li>
									<li class="divider"></li>
									<li><a href="/user/goadd?id=${user.id }"
										title="修改">修改</a>
									</li>
									<li class="divider"></li>
									<li><a href="javascript:void(0)" onclick="del(${user.id })" title="删除">删除</a>
									</li>
								</ul>
							</div></td>
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
	function add(){
		window.location.href = "/user/goadd";
	}
	function del(id){
		if(window.confirm('你确定要删除吗？')){
            //alert("确定");
            window.location.href = "/user/del?id="+id;
            return true;
         }else{
            //alert("取消");
            return false;
        }
	}
</script>

</@override> <@extends name="/base/base.ftl"/>
