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
			<li>角色管理</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">

	<div class="col-lg-12">
		<section class="panel">
			<table class="table table-striped table-advance table-hover">
				<tbody>
					<tr>
						<th>ID</th>
						<th>名称</th>
						<th>编码</th>
						<th>操作</th>
					</tr>
					<#list page.list as role>
					<tr>
						<td>${role.id }</td>
						<td>${role.name }</td>
						<td>${role.code }</td>
						<td>
							</td>
					</tr>
					</#list>
					
				</tbody>

			</table>
		</section>
	</div>
</div>


</@override> <@extends name="/base/base.ftl"/>
