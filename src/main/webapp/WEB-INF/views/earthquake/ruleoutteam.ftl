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
					<#if rcList??>
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
					</#if>
					
					<#if linkDetailList??>
					<div class="form-group">
						<div class="col-sm-11">
							<section class="panel personpanel">
								<header class="panel-heading">
									${link.name }对应的出队单位
								</header>
								<table class="table">
									<thead>
										<tr>
											<th>单位id</th>
											<th>单位名称</th>
											<th>人数</th>
										</tr>
									</thead>
									<tbody>
										<#list linkDetailList as linkDetail>
										<tr>
											<td>${linkDetail.cid }</td>
											<td>${linkDetail.company }</td>
											<td>${linkDetail.count }</td>
										</tr>
										</#list>
									</tbody>
								</table>
							</section>
						</div>
					</div>
					</#if>
					
					<#if hbplanDetailList??>
					<div class="form-group">
						<div class="col-sm-11">
							<section class="panel personpanel">
								<header class="panel-heading">
									${hbplan.name }对应的出队单位
								</header>
								<table class="table">
									<thead>
										<tr>
											<th>单位id</th>
											<th>单位名称</th>
											<th>人数</th>
										</tr>
									</thead>
									<tbody>
										<#list hbplanDetailList as hbplanDetail>
										<tr>
											<td>${hbplanDetail.cid }</td>
											<td>${hbplanDetail.company }</td>
											
											<td>${hbplanDetail.count }</td>
										</tr>
										</#list>
									</tbody>
								</table>
							</section>
						</div>
					</div>
					</#if>
					
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
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   手动添加单位
                      <a class="btn btn-danger btn-sm aleft" href="javascript:void(0)" onclick="addCompany()" title="">添加单位</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>单位id</th>
                                  <th>省份</th>
                              </tr>
                              </thead>
                              <tbody id="companytbody">
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
					<input type="hidden" name="cids" id="cids"/>
					
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
			
			var cids = $("#cids").val();
		
			parent.location.href="/earthquake/addoutteam?eqid="+${earthquake.id}+"&cids="+cids;
		    parent.layer.close(index);
		});
		
		$('#cancle').on('click', function(){
		    parent.layer.close(index);
		});
	});
	
	function addCompany(){
	   	 layer.open({
				type: 2,
			    area: ['750px', '561px'],
			    fix: false, //不固定
			    title: "单位列表",
			    maxmin: true,
			    content: '/company/all'
			}); 
	}
</script>
</@override> <@extends name="/base/base_dialog.ftl"/>
