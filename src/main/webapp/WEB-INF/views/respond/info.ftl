<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>响应管理</li>
			<li>响应详情</li>
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
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="name" value="${response.name }">
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">响应等级</label>
                       <div class="col-lg-6">
                         <input type="text" class="form-control" name="name" value="${response.grade }">
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   出队单位
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>单位id</th>
                                  <th>省份</th>
                              </tr>
                              </thead>
                              <tbody>
                                <#list companyList as detail>
                              	 <tr>
	                                  <th>${detail.cid }</th>
	                                  <th>${detail.company }</th>
                             	 </tr>
                               </#list>
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
                   <input type="hidden" name="cids" id="cids"/>
                   
                   
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


</@override> <@extends name="/base/base.ftl"/>
