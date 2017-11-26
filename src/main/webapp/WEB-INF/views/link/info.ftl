<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>联动管理</li>
			<li>联动详情</li>
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
                       <label class="col-lg-2 control-label">联动条件名称</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="name" value="${link.name }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">联动对应响应等级</label>
                       <div class="col-lg-6">
                            <input class="form-control" type="text" value="${re.name }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">对应受灾省份</label>
                       <div class="col-lg-6">
                          <input class="form-control" type="text" value="${company.province }"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">备注</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="remark" value="${link.remark }"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   联动单位 
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>单位id</th>
                                  <th>省份</th>
                              </tr>
                              </thead>
                              <tbody id="companytbody">
                               <#list detailList as detail>
                              	 <tr>
	                                  <td>${detail.cid }</td>
	                                  <td>${detail.company }</td>
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
