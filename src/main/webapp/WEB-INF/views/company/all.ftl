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
						<th>全选</th>
						<th>ID</th>
						<th>单位简码</th>
						<th>省份</th>
						<th>类型</th>
					</tr>
					<#list list as company>
					<tr>
						<td><input name="" type="checkbox" value="" /></td>
						<td>${company.id }</td>
						<td>${company.code }</td>
						<td>${company.province }</td>
						<td>${company.type }</td>
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
			
			
			
		    parent.$('#yearm').val('我被改变了');
		    parent.layer.close(index);
		});
	});
</script>
</@override> <@extends name="/base/base_dialog.ftl"/>
