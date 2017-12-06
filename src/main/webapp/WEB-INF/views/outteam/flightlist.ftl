<@override name="head"> </@override> <@override name="body">
<style>
.form-group {
	border-bottom: 0px !important;
}
.twobutton{
	margin-left:250px;
}
.choose{
	cursor: pointer;
}
</style>
<div class="row">
	<div class="col-lg-12">
	<section class="panel">
		<table class="table table-striped table-advance table-hover">
			<tbody>
			<tr>
				<th>选择</th>
				<th>出发地</th>
				<th>到达地</th>
				<th>计划起飞</th>
				<th>计划到达</th>
			</tr>
			<#list resultList as result>
			<tr>
				<td><input type="radio" name="ischoose" value="${result.index }"></td>
				<td>${result.depPort }</td>
				<td>${result.arrPort }</td>
				<td>${result.depScheduled }</td>
				<td>${result.arrScheduled }</td>
			</tr>
			</#list>
			</tbody>
		</table>
	</section>
	</div>
</div>
<div class="row">
     <div class="form-group">
        <div class="col-lg-6 twobutton">
            <button type="button" class="btn btn-primary" id="confirm">确定</button>
            <button type="button" class="btn btn-danger" id="cancle">取消</button>
        </div>
    </div>
</div>

<script type="text/javascript">

$(document).ready(function(){ 
	$('input:radio:first').attr('checked', 'checked');
	var index = parent.layer.getFrameIndex(window.name);
	$('#confirm').on('click', function(){
		var cindex = $("input[name='ischoose']:checked").val();
		<#list resultList as result>
			if(cindex == '${result.index}'){
				parent.$("#depcity").val('${result.depCity}');
				parent.$("#arrcity").val('${result.arrCity}');
				parent.$("#depterminal").val('${result.depTerminal}');
				parent.$("#arrterminal").val('${result.arrTerminal}');
				parent.$("#depscheduled").val('${result.depScheduled}');
				parent.$("#arrscheduled").val('${result.arrScheduled}');
				parent.$("#depactual").val('${result.depActual}');
				parent.$("#arractual").val('${result.arrActual}');
				parent.$("#depport").val('${result.depPort}');
				parent.$("#arrport").val('${result.arrPort}');
				parent.$("#flightstate").val('${result.flightState}');
				
				parent.$("#arrcode").val('${result.arrCode}');
				parent.$("#depcode").val('${result.depCode}');
			}
	    </#list>
		//parent.$('#leaders').val(leaders);
		parent.layer.close(index);
	});
	
	$('#cancle').on('click', function(){
	    parent.layer.close(index);
	});
});


</script>
</@override> <@extends name="/base/base_dialog.ftl"/>
