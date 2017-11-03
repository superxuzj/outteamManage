<@override name="head"> </@override> <@override name="body">
<style>

.aleft{
	margin-left:480px;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>联动管理</li>
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
               <form class="form-horizontal" role="form" id="linkform"
               data-validator-option="{timely:2, theme:'yellow_top'}" action="/link/save">  
               <input type="hidden" name="id"  value="${link.id }" />                                                
                   <div class="form-group">
                       <label class="col-lg-2 control-label">联动条件名称</label>
                       <div class="col-lg-6">
                           <input class="form-control" type="text" name="name" value="${link.name }"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">联动对应响应等级</label>
                       <div class="col-lg-6">
                           <select class="form-control m-bot15" name="rid">
                           		<#list  responseList as response>
                                <option value="${response.id }">${response.name }</option>
                                </#list>
                            </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">对应受灾省份</label>
                       <div class="col-lg-6">
                           <select class="form-control m-bot15" name="eqcid">
                             <#list companyList as company>
                                <option value="${company.id }">${company.province }</option>
                             </#list>
                            </select>
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
                               <#list detailList as duty>
                              	 <tr>
	                                  <th>${duty.cid }</th>
	                                  <th>${duty.company }</th>
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
                      		 <button type="button" class="btn btn-primary" onclick="save()">保存</button>
                           <button type="button" class="btn btn-danger" onclick="gohistory()">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
function save(){
	$("#linkform").submit();
}

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
</@override> <@extends name="/base/base.ftl"/>
