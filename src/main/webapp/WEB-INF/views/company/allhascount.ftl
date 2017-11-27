<@override name="head"> </@override> <@override name="body">
<!-- 该页面为轮值功能提供单位信息 -->
<style>
.form-group {
	border-bottom: 0px !important;
	padding-bottom:1px !important;
	margin-bottom:1px !important;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<table class="table table-striped table-advance table-hover">
				<tbody>
					<tr>
						<th onclick="choose()" class="choose">全选</th>
						<th>ID</th>
						<th>单位简码</th>
						<th>省份</th>
					</tr>
					<#list list as company>
					<tr>
						<td><input class="allchoose" type="checkbox" value="${company.id }" /></td>
						<td  class="test" cid="${company.id }">${company.id }</td>
						<td>${company.code }</td>
						<td class="test">${company.province }</td>
					</tr>
					</#list>
				</tbody>

			</table>
		</section>
	</div>
</div>
<div class="row">
     <div class="form-group">
        <div class="col-lg-offset-6 col-lg-6 twobutton">
            <button type="button" class="btn btn-primary" id="save">确定</button>
            <button type="button" class="btn btn-danger">取消</button>
        </div>
    </div>
</div>

<script type="text/javascript">
	$(document).ready(function(){ 
		var index = parent.layer.getFrameIndex(window.name);
			$('#save').on('click', function(){
			var chooseArr = new Array;
			var str="";
		    $(".allchoose:checked").each(function(i){
		    	chooseArr[i] = $(this).val();
		    	str+="<tr>";
	    	   	$(this).parent().parent().children("td.test").each(function(i,e){
	    	   		
	    	        str+=$(e).prop("outerHTML");
	    	    });
				
	    	   	str+="<td class='test'><input type='text' class='inputvale'/></td>";
	    	   	str+="<td class='test'><input type='button' value='删除' onclick='firstdel(this)'></td>";
	    	   	str+="</tr>";
		    });
		    console.log(str);
		    parent.$('#companytbody').append(str);
		    
				
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
