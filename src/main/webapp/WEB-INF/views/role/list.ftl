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
			<li><i class="fa fa-laptop"></i>角色管理</li>
			<!-- <li><i class="fa fa-laptop"></i>Dashboard</li>
						<li><i class="fa fa-laptop"></i>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
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

	</div>

	<div class="col-lg-12">
		<section class="panel">
			<table class="table table-striped table-advance table-hover">
				<tbody>
					<tr>
						<th>ID</th>
						<th>名称</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
					<tr>
						<td>752000</td>
						<td>系统管理员</td>
						<td>开启</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
									href="" title="Bootstrap 3 themes generator"> 操作<span
									class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/role/info"
										title="Bootstrap 3 themes generator">详情</a>
									</li>
									<li class="divider"></li>
									<li><a href="/role/info"
										title="Bootstrap 3 themes generator">修改</a>
									</li>
									<li class="divider"></li>
									<li><a href="" title="Bootstrap 3 themes generator">结束</a>
									</li>
								</ul>
							</div></td>
					</tr>
					<tr>
						<td>Sung Carlson</td>
						<td>单位管理员</td>
						<td>开启</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
									href="" title="Bootstrap 3 themes generator"> 操作<span
									class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/role/info"
										title="Bootstrap 3 themes generator">详情</a>
									</li>
									<li class="divider"></li>
									<li><a href="/role/info"
										title="Bootstrap 3 themes generator">修改</a>
									</li>
									<li class="divider"></li>
									<li><a href="" title="Bootstrap 3 themes generator">结束</a>
									</li>
								</ul>
							</div></td>
					</tr>
					<tr>
						<td>Bryon Osborne</td>
						<td>系统管理员</td>
						<td>开启</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
									href="" title="Bootstrap 3 themes generator"> 操作<span
									class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/role/info"
										title="Bootstrap 3 themes generator">详情</a>
									</li>
									<li class="divider"></li>
									<li><a href="/role/info"
										title="Bootstrap 3 themes generator">修改</a>
									</li>
									<li class="divider"></li>
									<li><a href="" title="Bootstrap 3 themes generator">结束</a>
									</li>
								</ul>
							</div></td>
					</tr>
					<tr>
						<td>Dalia Marquez</td>
						<td>系统管理员</td>
						<td>开启</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
									href="" title="Bootstrap 3 themes generator"> 操作<span
									class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/role/info"
										title="Bootstrap 3 themes generator">详情</a>
									</li>
									<li class="divider"></li>
									<li><a href="/role/info"
										title="Bootstrap 3 themes generator">修改</a>
									</li>
									<li class="divider"></li>
									<li><a href="" title="Bootstrap 3 themes generator">结束</a>
									</li>
								</ul>
							</div></td>
					</tr>
					
				</tbody>

			</table>
		</section>
	</div>
</div>


</@override> <@extends name="/base/base.ftl"/>
