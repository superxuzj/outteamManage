<@override name="head"> 

</@override> <@override name="body">
<style>
.form-group{
border-bottom:0px !important;
padding-bottom:1px !important;
margin-bottom:1px !important;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a></li>
			<li>地震事件管理</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
 <div class="row">
          <div class="col-lg-12">
                  <section class="panel">
                      <div class="panel-body">
                          <form class="form-horizontal" role="form">
                              <div class="form-group col-lg-3">
                                  <label for="inputEmail1" class="col-lg-3 control-label">eqinfo_id</label>
                                  <div class="col-lg-9">
                                      <input type="text" class="form-control" id="inputEmail1" placeholder="eqinfo_id">
                                  </div>
                              </div>
                              <div class="form-group col-lg-3">
                                  <label for="inputPassword1" class="col-lg-3 control-label">名称</label>
                                  <div class="col-lg-9">
                                      <input type="text" class="form-control" id="inputPassword1" placeholder="名称">
                                  </div>
                              </div>
                              <div class="form-group col-lg-3">
                             	 <label for="inputPassword1" class="col-lg-3 control-label">等级</label>
                                  <div class="col-lg-9">
                                    <select class="form-control m-bot15">
                                          <option>Option 1</option>
                                          <option>Option 2</option>
                                          <option>Option 3</option>
                                      </select>
                                  </div>
                              </div>
                              <div class="form-group col-lg-3">
                                  <div class="col-lg-offset-2 col-lg-10">
                                      <button type="submit" class="btn">搜索</button>
                                  </div>
                              </div>
                          </form>
                      </div>
                  </section>

              </div>
          <div class="col-lg-12">
				<a class="btn btn-primary btn-sm" href="javascript:add();" title="新增">新增</a>
			</div>
              <div class="col-lg-12">
                  <section class="panel">
                      <table class="table table-striped table-advance table-hover">
                       <tbody>
                          <tr>
                             <th>event_id</th>
                             <th>名称</th>
                             <th>区域</th>
                             <th>省份</th>
                             <th>位置</th>
                             <th>震级</th>
                             <th>日期</th>
                             <th>响应等级</th>
                             <th>状态</th>
                             <th>操作</th>
                          </tr>
                          
                          <#list page.list as earthquake>
                          <tr>
                             <td>${earthquake.eventid }</td>
                           <td>${earthquake.eqname }</td>
                           <td>${earthquake.area }</td>
                           <td>${earthquake.province }</td>
                           <td>${earthquake.location }</td>
                           <td>${earthquake.magnitude }</td>
                           <td>${earthquake.eqdate }</td>
                           <td>${earthquake.responseid }</td>
                           <td>${earthquake.state }</td>
                           <td>
                            <div class="btn-group">
                                <a class="btn btn-info dropdown-toggle" data-toggle="dropdown" href="" title="Bootstrap 3 themes generator">
                                	操作<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                  <li><a href="/earthquake/info?id=${earthquake.id }" title="详情">详情</a></li>
                                  <li class="divider"></li>
                                  <li><a href="/earthquake/goadd?id=${earthquake.id }" title="修改">修改</a></li>
                                  <li class="divider"></li>
                                  <li><a href="" title="Bootstrap 3 themes generator">结束</a></li>
                                </ul>
                            </div>
                            </td>
                        </tr>
                       </#list>
                     </tbody>
                     		
                  </table>
                </section>
            </div>
            <div class="col-lg-12">
				<#import "/macros/pager.ftl" as p/>
				<@p.pager page/>
			 </div>
</div>

<script type="text/javascript">
	function add(){
		window.location.href = "/earthquake/goadd";
	}
</script>
</@override> <@extends name="/base/base.ftl"/>
