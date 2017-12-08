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
			<li>撤退申请</li>
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
                          <input class="form-control Wdate" type="text" name="depdate" id="depdate" value="${flight.depdate }" onclick="WdatePicker({minDate:'%y-%M-%d'})"/>
	                   
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">航班号</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" id="flight" name="flight" value="${flight.flight }">
                       </div>
                       <a id="agetflight"  class="btn btn-primary btn-sm" href="javascript:getFliht()" title="获取航班信息">获取航班信息</a>
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
                   <div class="form-group col-lg-11">
                       <label class="col-lg-3 control-label class1">航班状态</label>
                       <div class="col-lg-6 class2">
                       <input type="text" class="form-control" name="flightstate" id="flightstate" value="${flight.flightstate}"/>
                       </div>
                   </div>
                  
                   <div class="form-group col-lg-11">
                       <label class="col-lg-3 control-label class1">撤离备注</label>
                       <div  class="col-lg-7 class2">
                          <textarea name="remark" rows="5" cols="50" name="remark" <#if leave.state==2>readonly</#if>>${leave.remark }</textarea>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-5 col-lg-7">
                      	   <#if leave.state==2>
                           <button type="submit" class="btn btn-primary" disabled="disabled">已批准</button>
                           <#else>
                           <button type="submit" class="btn btn-primary">申请</button>
                           </#if>
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

/*60s计时*/
function settime(countdown) {
	if (countdown == 0) {
		$("#agetflight").text("获取航班信息");
		$('#agetflight').attr('href','javascript:getFliht()'); 
		return;
	} else {
		$("#agetflight").text(countdown+"s");
		countdown--;
	}
	setTimeout(function() {
		settime(countdown)
	}, 1000)
}

function getFliht(){
	var flight = $("#flight").val();
	var depdate = $("#depdate").val();
	if(flight==""){
		alert("请输入航班号！");
		return false;
	}
	if(depdate==""){
		alert("请选择出发日期！");
		return false;
	}
	
	 $('#agetflight').attr('href','#'); 
     settime(5);
	
	$.ajax({ 
        type: "POST",
        url:"/outteam/flight",
        data:{  
            "flight" : flight,
            "depdate":depdate
        },
        scriptCharset: 'utf-8',
        success: function(data) {
        	if(data.depcity=="" || data.depcity==null){
        		alert(data.error);
        	}else{
        		if(data.size>1){
        			layer.open({
        				type: 2,
        			    area: ['750px', '361px'],
        			    fix: false, //不固定
        			    title: "该航班号有多趟航班，请根据实际情况选择！默认为第一个。",
        			    maxmin: true,
        			    content: '/outteam/flightlist?flight='+flight+"&depdate="+depdate
        			}); 
        		}else{
            		$("#depcity").val(data.depcity);
            		$("#arrcity").val(data.arrcity);
            		$("#depterminal").val(data.depterminal);
            		$("#arrterminal").val(data.arrterminal);
            		$("#depscheduled").val(data.depscheduled);
            		$("#arrscheduled").val(data.arrscheduled);
            		$("#depactual").val(data.depactual);
            		$("#arractual").val(data.arractual);
            		$("#depport").val(data.depport);
            		$("#arrport").val(data.arrport);
            		$("#flightstate").val(data.flightstate);
        		}
        		
        		
        	}
        	
        }
	});
	
}
</script>

</@override> <@extends name="/base/base.ftl"/>
