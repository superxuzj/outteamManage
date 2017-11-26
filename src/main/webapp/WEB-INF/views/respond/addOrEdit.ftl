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
			<li>响应管理</li>
			<li>
			<#if response.id??>
				修改
			<#else>
				添加
			</#if>
			</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form" id="responseform"
               data-validator-option="{timely:2, theme:'yellow_top'}" action="/respond/save">                                                  
                    <input type="hidden"  name="id" value="${response.id }">
                   <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                       
                           <input type="text" class="form-control" name="name" value="${response.name }" <#if response??>readonly</#if>>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">响应等级</label>
                       <div class="col-lg-6">
                          <select class="form-control m-bot15" name="grade">
                          
                          	   <#if response??>
                               <option value="${response.grade }" >${response.name }</option>
                          	   <#else>
   								<option value="1" <#if response.grade==1>selected="selected"</#if> >一级响应</option>
                               <option value="2" <#if response.grade==2>selected="selected"</#if>>二级响应</option>
                          	   </#if>
                           </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   出队单位
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
                                <#list companyList as detail>
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
	$("#responseform").submit();
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
