<@override name="head">
<style>
.m-bot15{
	margin-bottom:0px;
}
.personpanel{
	margin-left:60px;
	margin-right:-20px;
}
.aleft{
	margin-left:750px;
}
</style>
 </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>出队管理</li>
			<li>出队详情</li>
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
                   <div class="form-group col-lg-6" col-lg-6>
                       <label class="col-lg-3 control-label">地震名称</label>
                       <div class="col-lg-9">
                       <input type="hidden" name="eqid" value="${outteam.eqid }">   
                           <input type="text" class="form-control" name="eqname" value="${outteam.eqname }" readonly />
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">单位名称</label>
                       <div class="col-lg-9">
                       <input type="hidden" name="cid" value="${outteam.cid }"/>   
                           <input type="text" class="form-control" name="company" value="${outteam.company }" />
                       </div>
                   </div>
                  <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">人数</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="count" value="${outteam.count }">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">状态</label>
                       <div class="col-lg-9">
                       	<input type="text" class="form-control" value="<@ps.outteamstate outteam.state/>" readonly />
                       </div>
                   </div>
                  
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发日期</label>
                       <div class="col-lg-9">
                          <input class="form-control Wdate" type="text" name="depdate" id="depdate" value="${flight.depdate }" onclick="WdatePicker({minDate:'%y-%M-%d'})"/>
	                   
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">航班号</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" id="flight" name="flight" value="${flight.flight }">
                       </div>
                      
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发城市</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depcity" id="depcity" value="${flight.depcity }"/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达城市</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control"  name="arrcity" id="arrcity" value="${flight.arrcity }"/>
                       </div>
                   </div>
                    <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发机场</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depport" id="depport" value="${flight.depport }"/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达机场</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control"  name="arrport" id="arrport" value="${flight.arrport }"/>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发航站楼</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depterminal" id="depterminal" value="${flight.depterminal }"/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达航站楼</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control"  name="arrterminal" id="arrterminal" value="${flight.arrterminal }"/>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">计划出发时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depscheduled" id="depscheduled" value="${flight.depscheduled }"/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">计划到达时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="arrscheduled" id="arrscheduled" value="${flight.arrscheduled}"/>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">实际出发时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depactual" id="depactual" value="${flight.depactual }"/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">实际到达时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="arractual" id="arractual" value="${flight.arractual}"/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">航班状态</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="flightstate" id="flightstate" value="${flight.flightstate}"/>
                       </div>
                   </div>
                   
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">总结</label>
                       <div class="col-lg-9">
                          <input type="text" class="form-control" id="mobile" placeholder=" ">
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-sm-11">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   出队队员列表 
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>姓名</th>
                                  <th>单位</th>
                                  <th>电话</th>
                                  <th>职责</th>
                              </tr>
                              </thead>
                              <tbody id="usertbody">
                                  <#list otdetailList as detail>
                                  	<tr>
										<td>${detail.name }</td>
										<td>${detail.company }</td>
										<td>${detail.phone }</td>
										<td>
										<#if detail.iscontact==1>
										联系人
										</#if>
										<#if detail.islead==1>
										负责人
										</#if>
										<#if detail.ismeet==1>
											接机人
										</#if>
										</td>
									</tr>
								   </#list>
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
                   <input type="hidden" name="chooses" id="chooses"/>
                   <input type="hidden" name="contacts" id="contacts"/>
                   <input type="hidden" name="leaders" id="leaders"/>
                   <div class="form-group">
                       <div class="col-lg-offset-5 col-lg-7">
                           <button type="button" class="btn btn-danger" onclick="gohistory()">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
function gohistory(){
	window.history.go(-1);
}
function choosePerson(){
   	 layer.open({
			type: 2,
		    area: ['750px', '561px'],
		    fix: false, //不固定
		    title: "队员列表",
		    maxmin: true,
		    content: '/outteam/personlist'
		}); 
}
</script>

</@override> <@extends name="/base/base.ftl"/>
