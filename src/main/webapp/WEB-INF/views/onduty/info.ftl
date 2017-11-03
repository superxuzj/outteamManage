<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>轮值管理</li>
			<li>轮值详情</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form">                                                  
                   <div class="form-group">
                       <label class="col-lg-2 control-label">年月</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="yearm" id="yearm" value="${yearm.yearm }">
                       </div>
                   </div>
                   
                  <div class="form-group">
                       <label class="col-lg-2 control-label">状态</label>
                       <div class="col-lg-6">
                          <#if yearm.state==1>
                        		  开启
                          <#else>
                          		关闭
                          </#if>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">备注</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" value="${yearm.remark }">
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   轮值单位 
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>年月</th>
                                  <th>省份</th>
                              </tr>
                              </thead>
                              <tbody>
                              <#list dutyList as duty>
                              <tr>
                                  <td>${duty.yearm }</td>
                                  <td>${duty.company }</td>
                              </tr>
                              </#list>
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="button" class="btn btn-danger" onclick="gohistory()">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
function addCompany(){
	
   	 layer.open({
			type: 2,
		    area: ['750px', '561px'],
		    fix: false, //不固定
		    title: "队员列表",
		    maxmin: true,
		    content: '/company/all'
		}); 
}
</script>
</@override> <@extends name="/base/base.ftl"/>
