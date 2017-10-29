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
			<li>华北预案管理</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">

	<div class="col-lg-12">
		<a class="btn btn-primary btn-sm" href="javascript:add();" title="新增">新增</a>
	</div>
	<div class="col-lg-12">
		<section class="panel">
			<table class="table table-striped table-advance table-hover">
				<tbody>
					<tr>
						<th>名称</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
					<#list page.list as hbplan>
					<tr>
						<td>${hbplan.name }</td>
						<td>${hbplan.remark }</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
									href="" title="Bootstrap 3 themes generator"> 操作<span
									class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/plan/info"
										title="Bootstrap 3 themes generator">详情</a>
									</li>
									<li class="divider"></li>
									<li><a href="/plan/info"
										title="Bootstrap 3 themes generator">修改</a>
									</li>
									<li class="divider"></li>
									<li><a href="" title="Bootstrap 3 themes generator">结束</a>
									</li>
								</ul>
							</div></td>
					</tr>
					</#list>
				</tbody>

			</table>
		</section>
		这里是分页的页码
	</div>
</div>

<script type="text/javascript">
	function add(){
		window.location.href = "/hbplan/goadd";
	}
</script>
</@override> <@extends name="/base/base.ftl"/>
