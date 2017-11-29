<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	 <!-- 禁止浏览器从本地机的缓存中调阅页面内容 -->
    <meta http-equiv="Pragma" content="no-cache">
    <!-- 用来防止别人在框架里调用你的页面 -->
    <meta http-equiv="Window-target" content="_top">
    <!-- content的参数有all，none，index，noindex，follow，nofollow，默认是all -->
    <meta name="robots" content="none">
    <!-- 收藏图标 -->
    <link rel="Shortcut Icon" href="favicon.ico">
    <!-- 网页不会被缓存 -->
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <!-- 解决部分兼容性问题，如果安装了GCF，则使用GCF来渲染页面，如果未安装GCF，则使用最高版本的IE内核进行渲染。 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	
    <title>国家地震现场应急工作队出队管理系统</title>

    <!-- Bootstrap CSS -->    
    <link href="<@ps.s/>/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="<@ps.s/>/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="<@ps.s/>/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="<@ps.s/>/css/font-awesome.min.css" rel="stylesheet" />    
    <!-- easy pie chart-->
    <link href="<@ps.s/>/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <!-- owl carousel -->
    <link rel="stylesheet" href="<@ps.s/>/css/owl.carousel.css" type="text/css">
	<link href="<@ps.s/>/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <!-- Custom styles -->
	<link href="<@ps.s/>/css/widgets.css" rel="stylesheet">
    <link href="<@ps.s/>/css/style.css" rel="stylesheet">
    <link href="<@ps.s/>/css/style-responsive.css" rel="stylesheet" />
	<link href="<@ps.s/>/css/xcharts.min.css" rel=" stylesheet">
	<link href="<@ps.s/>/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
	<script src="<@ps.s/>/js/jquery-1.8.3.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
      <script src="<@ps.s/>/js/html5shiv.js"></script>
      <script src="<@ps.s/>/js/respond.min.js"></script>
      <script src="<@ps.s/>/js/lte-ie7.js"></script>
    <![endif]-->
 <@block name="head"></@block>
  </head>
  <body>
  <!-- container section start -->
  <section id="container" class="">
      <#include "/include/top.ftl"/>     
      <!--header end-->

      <!--sidebar start-->
      <#include "/include/left_menu.ftl"/>
      
      <!--sidebar end-->
      
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">            
              <!--overview start-->
			 <@block name="body"></@block>
              <!-- project team & activity end -->

          </section>
      </section>
      <!--main content end-->
  </section>
  <!-- container section start -->

    <!-- javascripts 
    <script src="<@ps.s/>/js/jquery.js"></script>-->
    <script src="<@ps.s/>/js/jquery-1.8.3.min.js"></script>
	<script src="<@ps.s/>/js/jquery-ui-1.10.4.min.js"></script>
    <script type="text/javascript" src="<@ps.s/>/js/jquery-ui-1.9.2.custom.min.js"></script>
    <!-- bootstrap -->
    <script src="<@ps.s/>/js/bootstrap.min.js"></script>
    <!-- nice scroll -->
    <script src="<@ps.s/>/js/jquery.scrollTo.min.js"></script>
    <script src="<@ps.s/>/js/jquery.nicescroll.js" type="text/javascript"></script>
    <!-- charts scripts -->
    <script src="<@ps.s/>/assets/jquery-knob/js/jquery.knob.js"></script>
    <script src="<@ps.s/>/js/jquery.sparkline.js" type="text/javascript"></script>
    <script src="<@ps.s/>/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
    <script src="<@ps.s/>/js/owl.carousel.js" ></script>
    <!--script for this page only-->
	<script src="<@ps.s/>/js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="<@ps.s/>/js/jquery.customSelect.min.js" ></script>
	<script src="<@ps.s/>/assets/chart-master/Chart.js"></script>
   
    <!--custome script for all page-->
    <script src="<@ps.s/>/js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="<@ps.s/>/js/sparkline-chart.js"></script>
    <script src="<@ps.s/>/js/easy-pie-chart.js"></script>
	<script src="<@ps.s/>/js/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="<@ps.s/>/js/jquery-jvectormap-world-mill-en.js"></script>
	<script src="<@ps.s/>/js/xcharts.min.js"></script>
	<script src="<@ps.s/>/js/jquery.autosize.min.js"></script>
	<script src="<@ps.s/>/js/jquery.placeholder.min.js"></script>
	<script src="<@ps.s/>/js/gdp-data.js"></script>	
	<script src="<@ps.s/>/js/morris.min.js"></script>
	<script src="<@ps.s/>/js/sparklines.js"></script>	
	<script src="<@ps.s/>/js/charts.js"></script>
	<script src="<@ps.s/>/js/jquery.slimscroll.min.js"></script>
	<script src="<@ps.s/>/layer/layer.js"></script>
	
	<script src="<@ps.s/>/js/validate/jquery.validator.min.js?local=zh-CN"></script>

	
	<script type="text/javascript" src="<@ps.s/>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function loginout(){
		window.location.href="/loginout";
	}
	function gohistory(){
		window.history.go(-1);
	}
</script>
  </body>
</html>



