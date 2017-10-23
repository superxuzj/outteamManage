<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<div class="panel-body bio-graph-info">
				<form class="form-horizontal" role="form">
				  <#if earthsource??>
					<div class="form-group">
						<div class="col-sm-11">
							<section class="panel personpanel">
								<header class="panel-heading">
									震源省份是：${earthquake.province }，出队单位 ${earthsource }。
								</header>
							</section>
						</div>
					</div>
					</#if>
					<div class="form-group">
						<div class="col-sm-11">
							<section class="panel personpanel">
								<header class="panel-heading">
									${responseName }对应的出队单位
								</header>
								<table class="table">
									<thead>
										<tr>
											<th>单位id</th>
											<th>单位名称</th>
											<th>职责</th>
											<th>人数</th>
										</tr>
									</thead>
									<tbody>
										<#list rcList as responseCompany>
										<tr>
											<td>${responseCompany.cid }</td>
											<td>${responseCompany.company }</td>
											<td>
											<a title="${responseCompany.duty}">
											<#if responseCompany.duty?length gte 12 >
												${responseCompany.duty?substring(0,12)}...
											<#else>
												${responseCompany.duty}
											</#if>
											</a>
											</td>
											<td>${responseCompany.count }</td>
										</tr>
										</#list>
									</tbody>
								</table>
							</section>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-11">
							<section class="panel personpanel">
								<header class="panel-heading">
									${yearm }对应的轮值单位
								</header>
								<table class="table">
									<thead>
										<tr>
											<th>单位id</th>
											<th>单位名称</th>
										</tr>
									</thead>
									<tbody>
										<#list dutyList as onduty>
										<tr>
											<td>${onduty.cid }</td>
											<td>${onduty.company }</td>
										</tr>
										</#list>
									</tbody>
								</table>
							</section>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-11">
							<section class="panel personpanel">
								<header class="panel-heading">
									此次地震的出队单位为：
									<#list set as company>
										${company }.
										</#list>
								</header>
							</section>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-5 col-lg-7">
							<button type="button" class="btn btn-primary" id="confirm">确定</button>
							<button type="button" class="btn btn-danger" id="cancle">返回</button>
						</div>
					</div>
				</form>
			</div>
		</section>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){ 
		var index = parent.layer.getFrameIndex(window.name);
		$('#confirm').on('click', function(){
			parent.location.href="/earthquake/addoutteam?eqid="+${earthquake.id};
		    parent.layer.close(index);
		});
		
		$('#cancle').on('click', function(){
		    parent.layer.close(index);
		});
	});
</script>
</@override> <@extends name="/base/base_dialog.ftl"/>
