<@override name="head">
<style>
.personpanel{
	margin-left:40px;
	margin-right:20px;
}
.aleft{
	margin-left:780px;
}
</style>
 </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>个人出队</li>
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
                       <div class="col-sm-11">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   行动记录
                      <a class="btn btn-success btn-sm aleft" href="javascript:void(0)" onclick="addActionRecord()" title="">添加记录</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>开始时间</th>
                                  <th>结束时间</th>
                                  <th>地点</th>
                                  <th>行动名称</th>
                                  <th>承担角色</th>
                                  
                              </tr>
                              </thead>
                              <tbody id="actionrecord">
                              <tr>
                                  <td>2005.10</td>
                                  <td></td>
                                  <td>巴基斯坦</td>
                                  <td>巴基斯坦地震救援</td>
                                  <td>装备保障</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td></td>
                                  <td>巴基斯坦</td>
                                  <td>巴基斯坦地震救援</td>
                                  <td>装备保障</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td></td>
                                  <td>巴基斯坦</td>
                                  <td>巴基斯坦地震救援</td>
                                  <td>装备保障</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              </tbody>
                          </table>
                      </section>
                  </div>
                   </div>
                   <div class="form-group">
                       <div class="col-sm-11">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   演练记录
                      <a class="btn btn-success btn-sm aleft" href="javascript:void(0)" onclick="addYanlianRecord()" title="">添加记录</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>开始时间</th>
                                  <th>结束时间</th>
                                  <th>地点</th>
                                  <th>行动名称</th>
                                  <th>承担角色</th>
                                  
                              </tr>
                              </thead>
                              <tbody id="yanlianRecord">
                              <tr>
                                  <td>2005.10</td>
                                  <td></td>
                                  <td>巴基斯坦</td>
                                  <td>巴基斯坦地震救援</td>
                                  <td>装备保障</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td></td>
                                  <td>巴基斯坦</td>
                                  <td>巴基斯坦地震救援</td>
                                  <td>装备保障</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td></td>
                                  <td>巴基斯坦</td>
                                  <td>巴基斯坦地震救援</td>
                                  <td>装备保障</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
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
<script type="text/javascript">
function addActionRecord(){
	$("#actionrecord").append('<tr><td>2005.10</td><td></td><td>巴基斯坦</td><td>巴基斯坦地震救援</td><td>装备保障</td><td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td></tr>');
}
function addYanlianRecord(){
	$("#yanlianRecord").append('<tr><td>2005.10</td><td></td><td>巴基斯坦</td><td>巴基斯坦地震救援</td><td>装备保障</td><td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td></tr>');
}
function addPeixunRecord(){
	$("#peixunRecord").append('<tr><td>2005.10</td><td></td><td>荷兰ICET</td><td>搜救、营救、医疗、危险品救援知识</td><td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td></tr>');
}

function addRongyuRecord(){
	$("#rongyuRecord").append('<tr><td>2005.10</td><td>三等奖</td><td>小区</td><td>中级</td><td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td></tr>');
}
</script>

</@override> <@extends name="/base/base.ftl"/>
