<@override name="head"> </@override> <@override name="body">
<style>

.aleft{
	margin-left:480px;
}
.secondtd{
	padding-left:290px !important;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>华北预案管理</li>
			<li>
			<#if link.id??>
				修改
			<#else>
				添加
			</#if>
			</li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form" id="hbplanform"
               data-validator-option="{timely:2, theme:'yellow_top'}" action="/hbplan/save">  
               <input type="hidden" name="id"  value="${hbplan.id }" />                                                
                   <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="name" value="${hbplan.name }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">受灾省份</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="companys" value="${hbplan.companys }" placeholder="多个省份用空格"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">对应震级</label>
                       <div class="col-lg-6">
                           <input  type="text" name="low" value="${hbplan.low }"/>----<input  type="text" name="high" value="${hbplan.high }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">备注</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="remark" value="${hbplan.remark }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   第一梯队
                      <a class="btn btn-danger btn-sm aleft" href="javascript:void(0)" onclick="addFirstCompany()" title="">添加单位</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>单位id</th>
                                  <th>省份</th>
                              </tr>
                              </thead>
                              <tbody id="companytbody">
                               <#list firstdetailList as detail>
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
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   第二梯队
                      <a class="btn btn-danger btn-sm aleft" href="javascript:void(0)" onclick="addSecondCompany()" title="">添加单位</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>单位id</th>
                                  <th class="secondtd">省份</th>
                              </tr>
                              </thead>
                              <tbody id="secondcompanytbody">
                               <#list seconddetailList as detail>
                              	 <tr>
	                                  <th>${detail.cid }</th>
	                                  <th class="secondtd">${detail.company }</th>
                             	 </tr>
                               </#list>
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
                   <input type="hidden" name="secondcids" id="secondcids"/>
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                      		 <button type="button" class="btn btn-primary" onclick="save()">保存</button>
                           <button type="button" class="btn btn-danger">Cancel</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
function save(){
	$("#hbplanform").submit();
}

function addFirstCompany(){
   	 layer.open({
			type: 2,
		    area: ['750px', '561px'],
		    fix: false, //不固定
		    title: "单位列表",
		    maxmin: true,
		    content: '/company/all'
		}); 
}

function addSecondCompany(){
  	 layer.open({
			type: 2,
		    area: ['750px', '561px'],
		    fix: false, //不固定
		    title: "单位列表",
		    maxmin: true,
		    content: '/company/second'
		}); 
}
</script>
</@override> <@extends name="/base/base.ftl"/>
