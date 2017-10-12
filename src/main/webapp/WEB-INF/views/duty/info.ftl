<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>轮值管理</li>
			<li>轮值详情</li>
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
                   <div class="form-group">
                       <label class="col-lg-2 control-label">ID</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" id="f-name" value="123" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" id="l-name" value="预案a" placeholder=" ">
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">地震等级</label>
                       <div class="col-lg-6">
                           <select class="form-control m-bot15">
                                              <option>Option 1</option>
                                              <option>Option 2</option>
                                              <option>Option 3</option>
                                          </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">响应等级</label>
                       <div class="col-lg-6">
                           <select class="form-control m-bot15">
                                              <option>Option 1</option>
                                              <option>Option 2</option>
                                              <option>Option 3</option>
                                          </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-1 col-sm-8">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   轮值单位 
                      <a class="btn btn-danger btn-sm aleft" href="javascript:void(0)" onclick="addGov()" title="">添加单位</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>ID</th>
                                  <th>名称</th>
                                  <th>省份</th>
                                  <th>类型</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td>1</td>
                                  <td>地震局</td>
                                  <td>北京</td>
                                  <td>部门</td>
                              </tr>
                              <tr>
                                  <td>1</td>
                                  <td>地震局</td>
                                  <td>北京</td>
                                  <td>部门</td>
                              </tr>
                              <tr>
                                  <td>1</td>
                                  <td>地震局</td>
                                  <td>北京</td>
                                  <td>部门</td>
                              </tr>
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="submit" class="btn btn-primary">Save</button>
                           <button type="button" class="btn btn-danger">Cancel</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>


</@override> <@extends name="/base/base.ftl"/>
