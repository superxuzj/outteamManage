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
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">地震eqinfo_id</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="f-name" value="123" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6" col-lg-6>
                       <label class="col-lg-3 control-label">名称</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">单位名称</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出队类型</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="c-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">状态</label>
                       <div class="col-lg-9">
                           <select class="form-control m-bot15">
                                              <option>Option 1</option>
                                              <option>Option 2</option>
                                              <option>Option 3</option>
                                          </select>
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">人数</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="occupation" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">航班号</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" id="email" placeholder=" ">
                       </div>
                       <a class="btn btn-primary btn-sm" href="" title="Bootstrap 3 themes generator">获取航班信息</a>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发地点</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="mobile" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达地点</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="mobile" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出发时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="mobile" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">到达时间</label>
                       <div class="col-lg-9">
                           <input type="text" class="form-control" id="mobile" placeholder=" ">
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
                      <a class="btn btn-danger btn-sm aleft" href="javascript:void(0)" onclick="choosePerson()" title="">添加队员</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>#</th>
                                  <th>First Name</th>
                                  <th>Last Name</th>
                                  <th>Username</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td>1</td>
                                  <td>Mark</td>
                                  <td>Otto</td>
                                  <td>@mdo</td>
                              </tr>
                              <tr>
                                  <td>2</td>
                                  <td>Jacob</td>
                                  <td>Thornton</td>
                                  <td>@fat</td>
                              </tr>
                              <tr>
                                  <td>3</td>
                                  <td>Larry</td>
                                  <td>the Bird</td>
                                  <td>@twitter</td>
                              </tr>
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-5 col-lg-7">
                           <button type="submit" class="btn btn-primary">审批</button>
                           <button type="button" class="btn btn-danger">Cancel</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
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
