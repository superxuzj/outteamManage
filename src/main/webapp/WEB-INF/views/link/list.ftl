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
			<li>轮值管理</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<!--<div class="col-lg-12">
		<section class="panel">
			<div class="panel-body">
				<form class="form-horizontal" role="form">
					<div class="form-group col-lg-3">
						<label for="inputPassword1" class="col-lg-3 control-label">名称</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" id="inputPassword1"
								placeholder="名称">
						</div>
					</div>
					<div class="form-group col-lg-3">
						<label for="inputPassword1" class="col-lg-3 control-label">类型</label>
						<div class="col-lg-9">
							<select class="form-control m-bot15">
								<option>Option 1</option>
								<option>Option 2</option>
								<option>Option 3</option>
							</select>
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
	</div>-->
	<div class="col-lg-12">
		<a class="btn btn-primary btn-sm" href="javascript:add();" title="新增">新增</a>
	</div>
	<div class="col-lg-12">
		<section class="panel">
			<table class="table table-striped table-advance table-hover">
				<tbody>
					<tr>
						<th>ID</th>
						<th>名称</th>
						<th>响应等级</th>
						<th>对应省份</th>
						<th>操作</th>
					</tr>
					<#list page.list as link>
					<tr>
						<td>${link.id }</td>
						<td>${link.name }</td>
						<td>${link.rid }</td>
						<td>${link.eqcompany }</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
									href=""> 操作<span
									class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/link/info?id=${link.id }"
										title="查看">查看</a>
									</li>
									<li class="divider"></li>
									<li><a href="/link/goadd?id=${link.id }"
										title="修改">修改</a>
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
	</div>
	<div class="col-lg-12">
				<#import "/macros/pager.ftl" as p/>
				<@p.pager page/>
			 </div>
</div>
<script type="text/javascript">
	function add(){
		window.location.href = "/link/goadd";
	}
</script>

</@override> <@extends name="/base/base.ftl"/>
