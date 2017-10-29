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
			<li>轮值管理</li>
			<li>
			<#if yearm.id??>
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
               <form class="form-horizontal" role="form" id="ondutyform" action="/onduty/save">  
               <input type="hidden" name="id"  value="${yearm.id }" />                                                
                   <div class="form-group">
                       <label class="col-lg-2 control-label">年月</label>
                       <div class="col-lg-6">
                           <input class="form-control Wdate" type="text" name="yearm" id="yearm" value="${yearm.yearm }" onclick="WdatePicker({dateFmt:'yyyy-MM'})"/>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">状态</label>
                       <div class="col-lg-6">
                           <select class="form-control m-bot15" name="state">
                                <option value="1">开启</option>
                                <option value="2">关闭</option>
                            </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">备注</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="remark" value="${yearm.remark }">
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-7">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   轮值单位 
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
                               <#list dutyList as duty>
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
	$("#ondutyform").submit();
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
