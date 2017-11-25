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
				<th onclick="choose()" class="choose">全选</th>
				<th>联系人</th>
				<th>负责人</th>
				<#if hit==1><th>接机人</th></#if>
				<th>姓名</th>
				<th>单位</th>
				<th>电话</th>
			</tr>
			<#list userlist as user>
			<tr>
				<td><input class="allchoose" type="checkbox" value="${user.id }" <#if user.ischoose==1>checked</#if>/></td>
				<td><input class="contacts" type="checkbox" value="${user.id }" <#if user.iscontact==1>checked</#if> /></td>
				<td><input class="leader" type="checkbox" value="${user.id }" <#if user.islead==1>checked</#if> /></td>
				<#if hit==1><td><input class="meet" type="checkbox" value="${user.id }" <#if user.ismeet==1>checked</#if> /></td></#if>
				<td class="test">${user.name }</td>
				<td class="test">${user.company }</td>
				<td class="test">${user.phone }</td>
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
	var index = parent.layer.getFrameIndex(window.name);
	$('#confirm').on('click', function(){
		var chooseArr = new Array;
		var str="";
	    $(".allchoose:checked").each(function(i){
	    	chooseArr[i] = $(this).val();
	    	str+="<tr>";
    	   	$(this).parent().parent().children("td.test").each(function(i,e){
    	        str+=$(e).prop("outerHTML");
    	    });
    	   	str+="</tr>";
	    });
	    parent.$('#usertbody').html(str);
	    
		var chooses = chooseArr.join(',');//选择的人
		parent.$('#chooses').val(chooses);
	    
	   
	  
	   var contactArr = new Array;
	    $(".contacts:checked").each(function(i){
	    	contactArr[i] = $(this).val();
	    });
		var contacts = contactArr.join(',');//联系人
		parent.$('#contacts').val(contacts);
		
	    var leaderArr = new Array;
	    $(".leader:checked").each(function(i){
	    	leaderArr[i] = $(this).val();
	    });
		var leaders = leaderArr.join(',');//负责人
		parent.$('#leaders').val(leaders);
		
		var hit = ${hit};
		if(hit=="1"){
			var meetArr = new Array;
		    $(".meet:checked").each(function(i){
		    	meetArr[i] = $(this).val();
		    });
			var meets = meetArr.join(',');//负责人
			parent.$('#meets').val(meets);
		}
		
		
		parent.layer.close(index);
	});
	
	$('#cancle').on('click', function(){
	    parent.layer.close(index);
	});
});

function choose(){
	$('.allchoose').each(function() {
		if($(this).attr("checked")) { 
			$(this).removeAttr("checked"); 
		}else { 
			$(this).attr("checked","true"); 
		}  
	});
}

</script>
</@override> <@extends name="/base/base_dialog.ftl"/>
