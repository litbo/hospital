$(function () {
    dataScreen1();
    dataScreen2();
    dataScreen3();
    dataScreen4();
    dataScreen5();
    dataScreen6();
});

//设备运作状态图
function dataScreen1() {
    function loadOneColumn() {
        var myChart = echarts.init(document.getElementById('data-screen1'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                x: 'left',
                text: '设备运作状态图',
                textStyle:{
                    color:'#eee'
                }
            },
            grid: {
                top:20
            },
            legend: {
                orient : 'vertical',
                x : 'right',
                textStyle:{
                    color:'#ccc'
                },
                data:[]
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            series: [{
                name:'设备运作状态图',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#f19b78','#ff70ae','#fdc323','#2b92fb','#91c7ae',
                        '#bda29a','#546570'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    normal: {
                        show: true,
                        position: 'bottom',
                        formatter: '{b}\n{c}' + "台",
                        fontsize:'22',
                        fontWeight: 'bold'
                    }
                },
                labelLine: {
                    normal: {
                        show: true
                    }
                },
                data: []
            }]
        });
        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
        var names = [];    //类别数组（用于存放饼图的类别）
        var brower = [];
        $.ajax({
            type: 'get',
            url: '../json/dataScreen1.json',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.data, function (index, item) {
                    names.push(item.status);    //挨个取出类别并填入类别数组 
                    brower.push({
                        name: item.status,
                        value: item.num
                    });
                });
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表      
                    legend: {
                        data: names
                    },
                    series: [{
                        data: brower
                    }]
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    }
    loadOneColumn();
}

//设备收益指标
function dataScreen2() {
    // 表格
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#table1'
            ,url:'../json/dataScreen2.json'
            ,title: '设备收益指标'
            ,size: 'sm' //小尺寸的表格
            ,even: true //开启隔行背景
            ,skin: 'nob'
            ,cellMinWidth:40
            ,width:235
            ,cols: [[
                {field:'name', title:'设备',unresize:true}
                ,{field:'number', title:'工量',unresize:true}
                ,{field:'profit', title:'收入',unresize:true}
                ,{field:'profitRate', title:'收益率',width:70,align:'center',unresize:true}
            ]]
        });

    });
    //散点图
    function loadOneColumn() {
        var myChart = echarts.init(document.getElementById('data-screen2'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                x: 'left',
                text: '设备收益指标',
                textStyle:{
                    color:'#fff'
                }
            },
            grid: {
                left: '4%',   // 与容器左侧的距离
                right: '13%', // 与容器右侧的距离
                containLabel: true,
                y: 60,
                y2: 10,
                bottom:32
            },
            tooltip: {
                trigger: 'item',
                formatter: '{b}:\n{c}'
            },
            xAxis: {
                type: 'value',
                name: '人数',
                min: 0,
                max: 600,
                interval: 100,
                axisLine: {
                    show: true,
                    onZero: true,
                    lineStyle: {
                        color:'#fff',
                    },
                },
                splitLine: 'none',
                data: []
            },
            yAxis: {
                type: 'value',
                name: '(￥)',
                min: 0,
                max: 500,
                interval: 100,
                axisLine: {
                    show: true,
                    onZero: true,
                    lineStyle: {
                        color:'#fff',
                    },
                },
                splitLine: 'none',
                axisLabel: {
                    formatter: '{value} 万'
                }
            },
            series: [{
                name: '设备收益指标',
                type: 'scatter',
                smooth:true,
                symbolSize: 10,
                itemStyle: {
                    normal: {
                        areaStyle: {
                            type: 'default'
                        },
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#e062ae','#ffdb5c','#ff9f7f',
                                '#FE8463','#9BCA63'
                            ];
                            return colorList[params.dataIndex]
                        },
                        label: {
                            show: true,
                            position: 'top',
                            formatter: '{b}\n{c}'
                        }
                    }
                },
                data: []
            }]
        });
        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
        var names = [];    //类别数组
        var brower = [];
        $.ajax({
            type: 'get',
            url: '../json/dataScreen2.json',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.data, function (index, item) {
                    names.push(item.name);    //挨个取出类别并填入类别数组 
                    brower.push({
                        name: item.name,
                        value: [item.number,item.profit]
                    });
                });
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表                
                    legend: {
                        data: names
                    },
                    series: [{
                        data: brower
                    }]
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    }
    loadOneColumn();
}

//全院设备分布图
function dataScreen3() {
    function loadOneColumn() {
        var myChart = echarts.init(document.getElementById('data-screen3'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                x: 'left',
                text: '全院设备分布图',
                textStyle:{
                    color:'#eee'
                }
            },
            barWidth:20,
            tooltip: {
                trigger: 'item'
            },
            xAxis: [
                {
                    type: 'category',
                    splitLine: {show:false},
                    data: [],
                    axisLine: {
                        show: true,
                        onZero: true,
                        lineStyle: {
                            color:'#eee',
                        },
                    },
                    axisLabel:{
                        rotate:30,
                        margin: 10
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    show: true,
                    axisLine: {
                        show: true,
                        onZero: true,
                        lineStyle: {
                            color:'#eee',
                        },
                    },
                }
            ],
            calculable: true,
            grid: {
                borderWidth: 0,
                y: 80,
                y2: 60
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: []
            },
            series: [{
                name: '全院设备分布图',
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#f19b78','#ff70ae','#fdc323','#2b92fb','#91c7ae',
                                '#bda29a','#546570'
                            ];
                            return colorList[params.dataIndex]
                        },
                        label: {
                            show: true,
                            position: 'top',
                            formatter: '{b}\n{c}'
                        }
                    }
                },
                data: []
            }]
        });
        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
        var names = [];    //类别数组（用于存放饼图的类别）
        var brower = [];
        $.ajax({
            type: 'get',
            url: '../json/dataScreen3.json',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.data, function (index, item) {
                    names.push(item.dep);    //挨个取出类别并填入类别数组 
                    brower.push({
                        name: item.dep,
                        value: item.num
                    });
                });
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表                
                    legend: {
                        data: names
                    },
                    series: [{
                        data: brower
                    }],
                    xAxis: {
                        data:names
                    }
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    }
    loadOneColumn();
}

//当前工作状态
function dataScreen4(){
    function loadOneColumn() {
        var myChart = echarts.init(document.getElementById('data-screen4'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                text: '当前工作状态   ',
                x:'center',
                textStyle:{
                    color:'#fff'
                }
            },
            tooltip: {
                trigger: 'item'
            },
            xAxis: {
                type: 'category',
                name: '(毫安)',
                axisLine: {
                    show: true,
                    onZero: true,
                    lineStyle: {
                        color:'#fff',
                    },
                },
                data: []
            },
            grid:{
                left: '1%',   // 与容器左侧的距离
                right: '13%', // 与容器右侧的距离
                containLabel: true,
                y: 60,
                y2: 10,
                bottom:12
            },
            yAxis: {
                type: 'value',
                name: '电流变化',
                splitLine: 'none',
                axisLine: {
                    show: true,
                    onZero: true,
                    lineStyle: {
                        color:'#fff',
                    },
                },
            },
            color:'#f19b78',
            series: [{
                name: '当前工作状态',
                type: 'line',
                smooth: true,
                data: []
            }]
        });
        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
        var brower = [];
        $.ajax({
            type: 'get',
            url: '../json/dataScreen4-.json',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.list, function (index, item) {
                    brower.push({
                        value: item.num
                    });
                });
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表          
                    series: [{
                        data: brower
                    }]
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    }
    loadOneColumn();

    // 表格
    getList();
    function getList() {

        $.ajax({
            type : "GET",
            url : "../json/dataScreen4.json",
            dataType : "json",//返回的数据类型

            success: function (result) {
                // console.log(1);
                //我这里返回的是text
                if (result != "" && result != undefined) {
                    // console.log(2);
                    var data = result.data;
                    // console.log(data);
                    var deviceName,
                        dutyOfficer,
                        current,
                        surplus,
                        currVoltage,
                        currElectricity,
                        bulb,
                        eleConsumption,
                        leakageCurrent;
                    for(var i = 0; i< data.length; i++)
                    {
                        deviceName = data[i].deviceName;
                        dutyOfficer = data[i].dutyOfficer;
                        current = data[i].current;
                        surplus = data[i].surplus;
                        currVoltage = data[i].currVoltage;
                        currElectricity = data[i].currElectricity;
                        bulb = data[i].bulb;
                        eleConsumption = data[i].eleConsumption;
                        leakageCurrent = data[i].leakageCurrent;
                    }//添加你拼接好的html到table里
                    $("#deviceName").text(deviceName);
                    $("#dutyOfficer").text(dutyOfficer);
                    $("#current").text(current);
                    $("#surplus").text(surplus);
                    $("#currVoltage").text(currVoltage);
                    $("#currElectricity").text(currElectricity);
                    $("#bulb").text(bulb);
                    $("#eleConsumption").text(eleConsumption);
                    $("#leakageCurrent").text(leakageCurrent);
                }
            },
            error : function() {
                alert("查询失败！");
            }
        });
    }
}

//综合指标查询
function dataScreen5() {
    function loadOneColumn() {
        var myChart = echarts.init(document.getElementById('data-screen5'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                x: 'center',
                text: '综合指标查询',
                subtext: '机时利用率',
                textStyle:{
                    color:'#fff'
                }
            },
            barWidth:10,
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                },
                formatter: function (params) {
                    var tar;
                    if (params[1].value != '-') {
                        tar = params[1];
                    }
                    else {
                        tar = params[0];
                    }
                    return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value + "%";
                }
            },
            legend: {
                x: 'center',
                data:['机械利用率'],
            },
            grid: {
                left: '2%',
                right: '2%',
                bottom: 8,
                containLabel: true
            },
            xAxis: {
                type : 'category',
                splitLine: {show:false},
                axisLine: {
                    show: true,
                    onZero: true,
                    lineStyle: {
                        color:'#fff',
                    },
                },
                data: []
            },
            yAxis: {
                type : 'value',
                axisLine: {
                    show: true,
                    onZero: true,
                    lineStyle: {
                        color:'#fff',
                    }
                },
                splitLine: 'none',
                axisLabel: {
                    formatter: '{value} %'
                },
                min: 0,
                max: 100,
                interval: 20
            },
            series: [
                {
                    name: '机械利用率',
                    type: 'bar',
                    stack: '总量',
                    itemStyle: {
                        normal: {
                            barBorderColor: 'rgba(0,0,0,0)',
                            color: 'rgba(0,0,0,0)'
                        },
                        emphasis: {
                            barBorderColor: 'rgba(0,0,0,0)',
                            color: 'rgba(0,0,0,0)'
                        }
                    },
                    data: []
                },
                {
                    name: '机械利用率',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: false,
                            position: 'top',
                        }
                    },
                    color:'#fec321',
                    data: []
                },
            ]
        });
        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
        var names = [];    //类别数组（用于存放饼图的类别）
        var brower = [];
        var brower2 = [];
        $.ajax({
            type: 'get',
            url: '../json/dataScreen5.json',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.data, function (index, item) {
                    names.push(item.name);    //挨个取出类别并填入类别数组 
                    brower.push({
                        name: item.name,
                        value: item.bottom
                    });
                    brower2.push({
                        name: item.name,
                        value: item.top
                    });
                });
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表                
                    series: [
                        {
                            data: brower
                        },
                        {
                            data: brower2
                        }
                    ],
                    xAxis: {
                        data: names
                    }
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    }
    loadOneColumn();
}

//设备运行时长图
function dataScreen6(){
    function loadOneColumn() {
        var myChart = echarts.init(document.getElementById('data-screen6'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                x: 'center',
                text: '设备运作时长图',
                textStyle:{
                    color:'#eee'
                }
            },
            barWidth:5,
            tooltip: {
                trigger: 'item'
            },
            xAxis: [
                {
                    type : 'value',
                    boundaryGap : [0, 0.01],
                    min: 0,
                    max: 700,
                    interval: 100,
                    axisLabel: {
                        formatter: '{value} H'
                    },
                    axisLine: {
                        show: true,
                        onZero: true,
                        lineStyle: {
                            color:'#eee',
                        },
                    },
                }
            ],
            yAxis: [
                {
                    type : 'category',
                    data : [],
                    axisLine: {
                        show: true,
                        onZero: true,
                        lineStyle: {
                            color:'#eee',
                        },
                    },
                }
            ],
            calculable: true,
            grid: {
                borderWidth: 0,
                y: 60,
                y2: 70,
                bottom:30
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: []
            },
            series: [{
                name: '全院设备分布图',
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#f19b78','#ff70ae','#fdc323','#2b92fb','#91c7ae',
                                '#bda29a','#546570','#CA8622','#A7908E','#D74462'
                            ];
                            return colorList[params.dataIndex]
                        },
                        label: {
                            show: true,
                            position: 'right',
                            formatter: '{b}\n{c}'
                        }
                    }
                },
                data: []
            }]
        });
        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
        var names = [];    //类别数组（用于存放饼图的类别）
        var brower = [];
        $.ajax({
            type: 'get',
            url: '../json/dataScreen6.json',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result.data, function (index, item) {
                    names.push(item.name);    //挨个取出类别并填入类别数组 
                    brower.push({
                        name: item.name,
                        value: item.hour
                    });
                });
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表                
                    legend: {
                        data: names
                    },
                    series: [{
                        data: brower
                    }],
                    yAxis: {
                        data:names
                    }
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });
    }
    loadOneColumn();
}

//全屏

