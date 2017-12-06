<!DOCTYPE html>
<html style="height: 100%">
<head>
    <meta charset="utf-8">
    <link href="<@ps.s/>/echarts/echart.css" rel="stylesheet">
    <style>
        
    </style>
</head>

<body style="height: 100%; margin: 0">
        <div class="aside-box aside-left">
                <aside>
                        <h5>震区列表</h5>
                        <dl class="dlbottom">
                        <#list list as record>
                            <dd>
                           		<a href="/leader/info?cataId=${record.cataId }" 
                           		title="${record.locationCname }(${record.m }级)(<#if record.isouttem==1>出队<#else>未出对</#if>)">
                                <span class="list-part">${record.locationCname }</span>
                                </a>
                                <a href="/leader/info?cataId=${record.cataId }" 
                                title="${record.locationCname }(${record.m }级)(<#if record.isouttem==1>出队<#else>未出对</#if>)">
                                <span class="list-part">(${record.m }级)(<#if record.isouttem==1>出队<#else>未出队</#if>)</span>
                                </a>
                                <#if record.isouttem==2>
	                           		<div class="drop">
	                                    <a href="#">操作</a>
	                                    <ul>
	                                        <li><a href="#" onclick="outteam('${record.cataId}')">出队</a></li>
	                                        <li><a href="#" onclick="unoutteam('${record.cataId}')">不出队</a></li>
	                                    </ul>
	                                </div>
                           		</#if>
                                
                            </dd>
                           </#list>
                            
                        </dl>
                </aside>
        </div>
   

    <div id="container" style="height: 100%"></div>
    <div class="aside-right aside-box">
        <aside class="top">
                <h5>出队单位</h5>
                <dl>
                <#if outteamlist??>
               		<#list outteamlist as outteam>
                    <dd onclick="getPersonnel('${outteam.id}')">${outteam.company }</dd>
                    </#list>
                 <#else>
                  <dd>无</dd>
                 </#if>
                </dl>
        </aside>
        <aside class="bottom">
                <h5>出队成员</h5>
                <dl id="personneldd">
                <dd><span>无</span></dd>
                    <!-- <dd><span>徐志坚</span> <span>北京市</span><span>地震局</span></dd>
                    <dd><span>徐志坚</span> <span>北京市</span><span>地震局</span></dd>
                    <dd><span>徐志坚</span> <span>北京市</span><span>地震局</span></dd>
                    <dd><span>徐志坚</span> <span>北京市</span><span>地震局</span></dd>
                    <dd><span>徐志坚</span> <span>北京市</span><span>地震局</span></dd>
                    <dd><span>徐志坚</span> <span>北京市</span><span>地震局</span></dd>
                    <dd><span>徐志坚</span> <span>北京市</span><span>地震局</span></dd> -->
                </dl>
        </aside>
    </div>
   <script type="text/javascript" src="<@ps.s/>/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<@ps.s/>/echarts/echarts-all-3.js"></script>
    <script type="text/javascript" src="<@ps.s/>/echarts/ecStat.min.js"></script>
    <script type="text/javascript" src="<@ps.s/>/echarts/dataTool.min.js"></script>
    <script type="text/javascript" src="<@ps.s/>/echarts/china.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
    <script type="text/javascript" src="<@ps.s/>/echarts/bmap.min.js"></script>
    <script type="text/javascript">
    function outteam(cataId){
    	window.location.href = "/leader/outteam?cataId="+cataId;
    }
    function unoutteam(cataId){
    	window.location.href = "/leader/unoutteam?cataId="+cataId;
    }
    
    function getPersonnel(otid){
    	$.ajax({ 
            type: "POST",
            url:"/leader/getPersonnel",
            data:{  
                "otid" : otid
            },
            success: function(data) {
            	$("#personneldd").html(data);
            }
    	});
    }
    
    </script>
    <script type="text/javascript">
        $(".aside-left aside .drop").click(function(e){
            $(this).toggleClass("active").children("ul").stop().slideToggle();
            $(this).parent().siblings().children(".drop").each(function(i,e){
                $(e).removeClass("active").children("ul").stop().hide();
            })
            e.stopPropagation();
        })
        $(document).on("click",function(e){
            $(".aside-left aside .drop").removeClass("active").children("ul").stop().slideUp();
            e.stopPropagation();
        })
        var dom = document.getElementById("container");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;
        var geoCoordMap = {
            '上海': [121.4648, 31.2891],
            '新疆': [86.8236, 42.0883],
            '甘肃': [103.5901, 36.3043],
            '北京': [116.4551, 40.2539],
            '江苏': [118.8062, 31.9208],
            '广西': [108.479, 23.1152],
            '江西': [116.0046, 28.6633],
            '安徽': [117.29, 32.0581],
            '内蒙古': [111.4124, 40.4901],
            '黑龙江': [127.9688, 45.368],
            '天津': [117.4219, 39.4189],
            '山西': [112.3352, 37.9413],
            '广东': [113.5107, 23.2196],
            '四川': [103.9526, 31.3617],
            '西藏': [91.1865, 30.1465],
            '云南': [102.9199, 25.4663],
            '湖北': [114.3896, 30.6628],
            '辽宁': [123.1238, 42.1216],
            '山东': [117.1582, 36.8701],
            '海南': [110.3893, 19.8516],
            '河北': [114.4995, 38.6006],
            '福建': [119.4543, 25.9222],
            '青海': [101.4038, 36.8207],
            '陕西': [109.1162, 33.8004],
            '贵州': [106.6992, 26.7682],
            '河南': [113.4668, 34.6234],
            '重庆': [107.7539, 30.1904],
            '宁夏': [106.3586, 38.1775],
            '吉林': [125.8154, 44.2584],
            '湖南': [113.0823, 28.2568],
            '浙江': [30.2799, 120.16174]
        };

        function randomValue() {
            return Math.round(Math.random() * 1000);
        }

        var BJData = ${flights};


        var planePath = 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z';

        var convertData = function (data) {
            var res = [];
            for (var i = 0; i < data.length; i++) {
                var dataItem = data[i];
                var fromCoord = geoCoordMap[dataItem[0].name];
                var toCoord = geoCoordMap[dataItem[1].name];
                if (fromCoord && toCoord) {
                    res.push({
                        fromName: dataItem[0].name,
                        toName: dataItem[1].name,
                        coords: [fromCoord, toCoord]
                    });
                }
            }
            return res;
        };

        var series = [];
        [['北京', BJData]].forEach(function (item, i) {
            series.push(
                {
                    name: 'categoryA',
                    type: 'map',
                    geoIndex: 0,
                    tooltip: {
                        trigger: 'item',
                        show: true,
                        textStyle: {
                            color: '#fff'
                        }
                    },
                    data: [
                        { name: '北京', value: 'qweqweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee' },
                        { name: '天津', value: randomValue() },
                        { name: '上海', value: randomValue() },
                        { name: '重庆', value: randomValue() },
                        { name: '河北', value: randomValue() },
                        { name: '河南', value: randomValue() },
                        { name: '云南', value: randomValue() },
                        { name: '辽宁', value: randomValue() },
                        { name: '黑龙江', value: randomValue() },
                        { name: '湖南', value: randomValue() },
                        { name: '安徽', value: randomValue() },
                        { name: '山东', value: randomValue() },
                        { name: '新疆', value: randomValue() },
                        { name: '江苏', value: randomValue() },
                        { name: '浙江', value: randomValue() },
                        { name: '江西', value: randomValue() },
                        { name: '湖北', value: randomValue() },
                        { name: '广西', value: randomValue() },
                        { name: '甘肃', value: randomValue() },
                        { name: '山西', value: randomValue() },
                        { name: '内蒙古', value: 'qweqweeeeeeeeeee<br/>eeeeeeeeeeeeeeeeeeeeeeee' },
                        { name: '陕西', value: randomValue() },
                        { name: '吉林', value: randomValue() },
                        { name: '福建', value: randomValue() },
                        { name: '贵州', value: randomValue() },
                        { name: '广东', value: randomValue() },
                        { name: '青海', value: randomValue() },
                        { name: '西藏', value: randomValue() },
                        { name: '四川', value: randomValue() },
                        { name: '宁夏', value: randomValue() },
                        { name: '海南', value: randomValue() }
                    ]
                },
                {
                    name: item[0] + ' Top10',
                    type: 'lines',
                    zlevel: 1,
                    effect: {
                        show: true,
                        period: 6,
                        trailLength: 0.7,
                        color: '#fff',
                        symbolSize: 3
                    },
                    lineStyle: {
                        normal: {
                            color: '#00ff00',
                            width: 0,
                            curveness: 0.2
                        }
                    },
                    data: convertData(item[1])
                },
                {
                    name: item[0] + '111',
                    type: 'lines',
                    zlevel: 2,
                    symbol: ['none', 'arrow'],
                    symbolSize: 10,
                    effect: {
                        show: true,
                        period: 6,
                        trailLength: 0,
                        symbol: planePath,
                        symbolSize: 15
                    },
                    lineStyle: {
                        normal: {
                            color: '#00ff00',
                            width: 1,
                            opacity: 0.6,
                            curveness: 0.2
                        }
                    },
                    data: convertData(item[1])
                },
                {
                    name: item[0] + ' Top10123',
                    type: 'effectScatter',
                    coordinateSystem: 'geo',
                    zlevel: 2,
                    rippleEffect: {
                        brushType: 'stroke'
                    },
                    label: {
                        normal: {
                            show: false,
                            position: 'right',
                            formatter: '{b}'
                        }
                    },
                    symbolSize: function (val) {
                        return val[2] / 8;
                    },
                    itemStyle: {
                        normal: {
                            color: '#ffff00'
                        }
                    },
                    data: item[1].map(function (dataItem) {
                        return {
                            name: dataItem[0].name,
                            value: geoCoordMap[dataItem[0].name].concat([dataItem[0].value])
                           
                        };
                    })
                }
            );
        });

        option = {
            backgroundColor: '#003380',
            title: {
                text: '${text}',
                subtext: '${subtext}',
                left: 'center',
                textStyle: {
                    color: '#fff'
                }
            },
            tooltip: {
                trigger: 'item',
                formatter: function (params) {
                    var res = params.name + '<br/>';
                    var myseries = option.series;
                    for (var i = 0; i < myseries.length; i++) {
                        for (var j = 0; j < myseries[i].data.length; j++) {
                            if (myseries[i].data[j].name == params.name) {
                                res += myseries[i].name + ' : ' + myseries[i].data[j].value + '</br>';
                            }
                        }
                    }
                    return res;
                }
            },
            geo: {
                map: 'china',
                label: {
                    normal: {
                        show: true,
                        textStyle: {
                            color: 'white'
                        }
                    },
                    emphasis: {
                        show: true
                    }
                },
                roam: true,
                itemStyle: {
                    normal: {
                        areaColor: '#01a0f3',
                        borderColor: '#ffffff'
                    },
                    emphasis: {
                        areaColor: '#007eff'
                    }
                }
            },
            series: series
        };;
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    </script>
</body>

</html>