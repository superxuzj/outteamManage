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
.class1{
	width:12% !important;
	margin-right:18px;
}
.class2{
	width:36% !important;
	margin-left:-5px;
}
</style>
 </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>撤退管理</li>
			<li>撤退详情</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form" action="/leave/save"
               data-validator-option="{timely:2, theme:'yellow_top'}" method="pose">                                                  
                   <div class="form-group col-lg-6" col-lg-6>
                       <input type="hidden" name="id" value="${outteam.lid}" >
                   	   <input type="hidden" name="otid" value="${outteam.id}" >
                       <label class="col-lg-3 control-label">地震名称</label>
                       <div class="col-lg-9">
                      	   <input type="hidden" name="eqid" value="${outteam.eqid}" >
                           <input type="text" class="form-control"  value="${outteam.eqname}" name="eqname" readonly>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">单位名称</label>
                       <div class="col-lg-9">
                       	   <input type="hidden" name="cid" value="${outteam.cid}" >
                           <input type="text" class="form-control"  value="${outteam.company}" name="company" readonly >
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">人数</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" value="${outteam.count }" readonly>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出队状态</label>
                       <div class="col-lg-9">
                          <input type="text" class="form-control" value="<@ps.outteamstate outteam.state/>" readonly>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发日期</label>
                       <div class="col-lg-9">
                          <input class="form-control Wdate" type="text" name="depdate" id="depdate" 
                          value="${flight.depdate }" onclick="WdatePicker({minDate:'%y-%M-%d'})" readonly/>
	                   
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">航班号</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" id="flight" name="flight" value="${flight.flight }" readonly>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发城市</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depcity" id="depcity" value="${flight.depcity }" readonly/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达城市</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control"  name="arrcity" id="arrcity" value="${flight.arrcity }" readonly/>
                       </div>
                   </div>
                    <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发机场</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depport" id="depport" value="${flight.depport }" readonly/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达机场</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control"  name="arrport" id="arrport" value="${flight.arrport }" readonly/>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发航站楼</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depterminal" id="depterminal" value="${flight.depterminal }" readonly/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达航站楼</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control"  name="arrterminal" id="arrterminal" value="${flight.arrterminal }" readonly/>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">计划出发时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depscheduled" id="depscheduled" value="${flight.depscheduled }" readonly/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">计划到达时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="arrscheduled" id="arrscheduled" value="${flight.arrscheduled}" readonly/>
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">实际出发时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="depactual" id="depactual" value="${flight.depactual }" readonly/>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">实际到达时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" name="arractual" id="arractual" value="${flight.arractual}" readonly/>
                       </div>
                   </div>
                   <div class="form-group col-lg-11">
                       <label class="col-lg-3 control-label class1">航班状态</label>
                       <div class="col-lg-6 class2">
                       <input type="text" class="form-control" name="flightstate" id="flightstate" value="${flight.flightstate}" readonly/>
                       </div>
                   </div>
                  
                   <div class="form-group col-lg-11">
                       <label class="col-lg-3 control-label class1">撤离备注</label>
                       <div  class="col-lg-7 class2">
                          <textarea name="remark" rows="5" cols="50" name="remark" readonly>${leave.remark }</textarea>
                       </div>
                   </div>
                   
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

</script>

</@override> <@extends name="/base/base.ftl"/>
