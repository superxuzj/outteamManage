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
			<li>用户管理</li>
			<li>用户详情</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
<div class="col-lg-12">
		<section class="panel">
			<div class="panel-body">
				<form class="form-horizontal" action="/user/uploadword" role="form" enctype="multipart/form-data" method="post" >
					<div class="form-group col-lg-4">
						<label for="exampleInputFile"></label>
						<div class="col-lg-9">
								<div class="input-append">  
                                      <input type="file" name="file" id="exampleInputFile">
								</div> 
						</div>
					</div>
					<div class="form-group col-lg-3">
						<div class="col-lg-offset-2 col-lg-10">
							 <input type="submit" class="btn btn-primary submittijioa" value="提交">
						</div>
					</div>
				</form>
			</div>
		</section>

	</div>
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form">                                                  
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">ID</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="f-name" value="123" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">姓名</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">性别</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">出生年月</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">民族</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">国籍</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">籍贯</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">学历</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">政治面貌</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">血型</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">身高</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">体重</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">帽码</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">衣码</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">鞋码</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">病史</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">药物过敏史</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">身份证号</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">身份证有效期至</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">护照号</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">护照有效期至</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">队员编号</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">单位</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">联系电话</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">电子邮件</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">联系地址</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">紧急联系人姓名</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">紧急联系人电话</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">入队时间</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">在册方式</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">状态</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">岗位</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">救援专业</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   <div class="form-group col-lg-6">
                       <label class="col-lg-3 control-label">掌握语言</label>
                       <div class="col-lg-7">
                           <input type="text" class="form-control" id="l-name" placeholder=" ">
                       </div>
                   </div>
                   
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
                       <div class="col-sm-11">
                      <section class="panel personpanel">
                          <header class="panel-heading">
                                                                   培训记录
                      <a class="btn btn-success btn-sm aleft" href="javascript:void(0)" onclick="addPeixunRecord()" title="">添加记录</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>开始时间</th>
                                  <th>结束时间</th>
                                  <th>培训机构</th>
                                  <th>内容</th>
                                  
                              </tr>
                              </thead>
                              <tbody id="peixunRecord">
                              <tr>
                                  <td>2005.10</td>
                                  <td></td>
                                  <td>荷兰ICET</td>
                                  <td>搜救、营救、医疗、危险品救援知识</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td></td>
                                  <td>荷兰ICET</td>
                                  <td>搜救、营救、医疗、危险品救援知识</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td></td>
                                  <td>荷兰ICET</td>
                                  <td>搜救、营救、医疗、危险品救援知识</td>
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
                                                                   荣誉记录
                      <a class="btn btn-success btn-sm aleft" href="javascript:void(0)" onclick="addRongyuRecord()" title="">添加记录</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>时间</th>
                                  <th>获奖名称</th>
                                  <th>颁发机构</th>
                                  <th>奖励级别</th>
                                  
                              </tr>
                              </thead>
                              <tbody id="rongyuRecord">
                              <tr>
                                  <td>2005.10</td>
                                  <td>三等奖</td>
                                  <td>居住小区</td>
                                  <td>高级别</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td>三等奖</td>
                                  <td>居住小区</td>
                                  <td>高级别</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td>三等奖</td>
                                  <td>居住小区</td>
                                  <td>高级别</td>
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
                                                                   免疫记录
                      <a class="btn btn-success btn-sm aleft" href="javascript:void(0)" onclick="" title="">添加记录</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>时间</th>
                                  <th>接种疫苗名称</th>
                              </tr>
                              </thead>
                              <tbody id="">
                              <tr>
                                  <td>2005.10</td>
                                  <td>天花</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td>天花</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                  <td>2005.10</td>
                                  <td>天花</td>
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
                                                                   考核记录
                      <a class="btn btn-success btn-sm aleft" href="javascript:void(0)" onclick="" title="">添加记录</a>
                          </header>
                          <table class="table">
                              <thead>
                              <tr>
                                  <th>时间</th>
                                  <th>科目</th>
                                  <th>成绩</th>
                                  
                              </tr>
                              </thead>
                              <tbody id="">
                              <tr>
                                  <td>2005.10</td>
                                  <td>考勤</td>
                                  <td>100</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                   <td>2005.10</td>
                                  <td>考勤</td>
                                  <td>100</td>
                                  <td><a class="btn btn-danger btn-sm" href="" title="Bootstrap 3 themes generator">删除</a></td>
                              </tr>
                              <tr>
                                   <td>2005.10</td>
                                  <td>考勤</td>
                                  <td>100</td>
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
