/*
* renderMod.js用于渲染页面中的数据表格和表单，可以根据需要渲染出不同的页面并添加相应的功能
* 作者：张小富
* 创建事件：2019-1-1 完善时间：
* 修改时间：
* 代码说明：---1：renderMod.js 为tableNormal.js和formNormal.js的组合文件，意在提高代码复用，回归功能本质
*            2：renderMod.js大部分组建使用方法与其他两个文件中定义的相同使用上略有偏差，详细请看相关说明文档，推荐使用renderMod渲染页面
* */

$(function () {
    layui.use(['table', 'form', 'laydate', 'element', 'upload', "jquery", "layer"], function () {
        var table = layui.table, form = layui.form, element = layui.element, laydate = layui.laydate,
            upload = layui.upload, $ = layui.jquery, layer = layui.layer,
            formAction = renderMod['form'] || renderMod['formAction']//表单数据
            ,addTable = renderMod['table'] || renderMod['addTable']//表格数据
            //函数集合
            ,func = {//this = obj
                "addMsg": function () {
                    var num = Number(arguments[0]) || Number(arguments[0][0]) || 1//添加messages的表格列数
                        , timeIn = Number(arguments[0][1]) || 500//动画渐入时间
                        , timeOut = Number(arguments[0][2]) || 100//动画渐出时间
                        , oData = this.data;
                    if (typeof oData !== "object") {
                        console.error("页面无法正常加载（参数传入错误-缺少必填项）！");
                        return;
                    }
                    $("td:nth-child(" + Number(num) + ")").mouseover(function (e) {
                        var $h_tip = $("#h_tips");
                        if ($h_tip.length <= 0) {
                            $("body").append($("<div>").attr("id", "h_tips"))
                        }
                        for (var i = 0; i < oData.length; i++) {
                            for (var titles in oData[i]) {
                                if(oData[i].hasOwnProperty(titles)){
                                    if (oData[i][titles] === $(this).text()) {//确保当前的单元值与捕获的数据中的值对应，避免对应错误
                                        $h_tip.html("");
                                        try {
                                            for (var j = 0; j < oData[i].messages.length; j++) {
                                                $h_tip.append("<p>\n" +
                                                    "        <span class=\"tip_title\">" + oData[i].messages[j].name + "</span>：<span class=\"tip_conts\">" + oData[i].messages[j].value + "</span>\n" +
                                                    "    </p>")
                                            }
                                        } catch (e) {
                                            continue;
                                        }
                                        e = e || window.event;
                                        _x = e.pageX || e.clientX + document.body.scroolLeft;
                                        _y = e.pageY || e.clientY + document.body.scrollTop;
                                        //$("#tips").fadeOut(50);
                                        $h_tip.css("left", _x + 'px').css("top", _y + 'px').fadeIn(timeIn);
                                        $(this).mouseleave(function () {
                                            $h_tip.fadeOut(timeOut).remove();
                                        });
                                        break;
                                    }
                                }
                            }
                        }
                    })
                },
                "addLink": function (value) {
                    layui.use('table', function () {
                        var table = layui.table
                            , filter = Type(value) !== "string" ? value[0] : value
                            , yes = Type(value) !== "string" ? value[1] : "确定要跳转链接吗？"
                            , no = Type(value) !== "string" ? value[2] : "没有可以跳转的链接。";
                        table.on('tool(' + filter + ')', function (obj) {
                            var data = obj.data;
                            if (obj.event === "openLink") {
                                if (data.link) {
                                    layer.confirm(yes, function () {
                                        location.href = data.link + "?link=" + encodeURIComponent(window.location.href);
                                    });
                                } else {
                                    layer.alert(no)
                                }
                            }
                        });
                    })
                },
                "toolFunc": function (value) {
                    if (Type(value) === "json") {
                        cc(value);
                    } else if (Type(value) === "array") {
                        for (var i = 0; i < value.length; i++) {
                            (function (i) {
                                cc(value[i]);
                            })(i)
                        }
                    } else {
                        console.error("toolFunc函数参数填写错误！");
                        return false;
                    }

                    function cc(vas) {
                        layui.use('table', function () {
                            var table = layui.table, layer = layui.layer, filt = vas.filter || "table1", tool = vas.tool || "tool";
                            table.on('' + tool + '(' + filt + ')', function (obj) {
                                //console.log(22);
                                var w = document.body.clientWidth - 20
                                    , h = document.body.clientHeight - 20;
                                //var data = obj.data;//获得当前行数据
                                if (obj.event === vas.event) {//弹出窗口
                                    layer.open({
                                        type: vas.type || 1,
                                        title: vas.title || "详情",
                                        content: vas.content || "无内容",
                                        area: vas.area || [w + "px", h + "px"],
                                        resize: vas.resize || false,
                                        move: vas.move || false
                                    });
                                }
                            });
                        });
                    }
                },
                "tableBtn": function (vas) {
                    layui.use('table', function () {
                        var table = layui.table, layer = layui.layer, filt = vas.filter || "table1",
                            event = vas.event || "dataSearch", id = vas.tool || "hideXs";
                        table.on('toolbar(' + filt + ')', function (obj) {
                            var w = document.body.clientWidth - 20
                                , h = document.body.clientHeight - 20;
                            //var data = obj.data;//获得当前行数据
                            if (obj.event === vas.event) {//弹出窗口
                                layer.open({
                                    type: vas.type || 1,
                                    title: vas.title || "详细查找",
                                    content: vas.content || $('#' + id),
                                    area: vas.area || [w + "px", h + "px"],
                                    resize: vas.resize || false,
                                    move: vas.move || false
                                });
                            }
                        });
                    });
                }
            }
        ;
        //表单渲染
        if (formAction && Type(formAction) === "json") {
            var normal = {
                    filter: "sub"
                },//通用默认操作集合
                nor_date = {
                    elem: "#date",
                    value: today
                },//默认的日期选择器
                nor_up = {
                    elem: "#up",
                    multiple: false,
                    accept: "file"

                },
                nor_ver = {},//默认添加的表单验证数据
                //日期选择
                date = formAction.date,
                //表单默认值
                val = formAction.val,
                //表单数据验证
                ver = formAction.ver,
                //提交选择
                sub = formAction.submit,
                //文件上传
                file = formAction.file,
                //提交选择
                eve = formAction.event,
                //默认不添加选择器
                filter = "", files = null;

            //表单默认值渲染
            if (val && val !== false) {
                //自动匹配lay-filter相同的元素，val.value：{name(input表单name):value(name对应默认数据)}
                if (val.filter && (val.get || (val.options && Type(val.options) === "json"))) {
                    if (val.get) {
                        val.get.success = function (data) {
                            for (var name in data) {
                                if (data.hasOwnProperty(name)) {
                                    form.val(val.filter, data[name]);
                                }
                            }
                        };
                        subUp(val.get)
                    } else {
                        form.val(val.filter, val.options);
                    }
                } else {
                    console.error("renderMod.js遇到一个无法处理的错误：");
                    console.error("formAction.val参数传递错误(LINE:50),请参考相关文档！");
                }
            }

            //日期选择器渲染
            //支持 默认渲染 单选择器渲染 多选择器渲染
            if (date && date !== false) {
                //当 data = true 时使用默认的参数渲染数据
                if (date === true) {
                    a(nor_date);
                    //当 data 数据类型为 JSON 时则渲染一个日期选择器(优先自定义属性)
                } else if (Type(date) === "json") {
                    a(date);
                    //当 data 数据类型为 ARRAY 时则渲染多个日期选择器(优先自定义属性)
                } else if (Type(date) === "array") {
                    for (var j = 0; j < date.length; j++) {
                        if (Type(date[j]) === "json") {
                            a(date[j]);
                        }
                    }
                }
            }

            //表单数据验证函数
            //LAYUI表单组建默认支持：required（必填项） phone（手机号） email（邮箱） url（网址） number（数字） date（日期） identity（身份证）
            // 自定义值
            if (ver && ver !== false) {
                if (Type(ver) === "json") {
                    compereData(ver, nor_ver);
                    form.verify(ver);
                }
            }

            //文件上传
            if (file && file !== false) {
                if (file === true) {
                    //渲染默认上传域
                    //严重不推荐使用rue
                    cUp(nor_up);
                    //渲染单个上传域
                } else if (Type(file) === "json") {
                    cUp(file);
                    //渲染多个上传域
                } else if (Type(file) === "array") {
                    for (var ff = 0; ff < file.length; ff++) {
                        if (Type(file[ff]) === "json") {
                            cUp(file[ff]);
                        }
                    }
                }

                function cUp(options) {
                    //console.log(options);
                    upload.render(options);
                    file.func && file.func();
                    if (file.bindAction) {
                        $(file.bindAction).on('click', function () {
                            return false;
                        })
                    }
                }

            }

            //表单按钮点击事件
            if (sub && sub !== false) {
                //设定固定的提交按钮事件还是所有的提交按钮的事件
                if (sub.filter) {
                    //当sub.filter = true时则使用默认的过滤字符，否则使用自定义的字符
                    sub.filter === true ? filter = '(' + normal.filter + ')' : filter = '(' + sub.filter + ')';
                }

                form.on('submit' + filter, function (dataBase) {
                    //data：表单所有数据,包含内容如下
                    //-----elem:被执行事件的DOM对象（点击的按钮）
                    //-----form:表单dorm组建，没有form标签则不存在
                    //-----field:容器内的所有表单字段 {name: value}

                    //表单提交前处理事件
                    var bef = true;
                    //console.log(sub.before);
                    if (sub.before) {
                        bef = sub.before(dataBase)
                    }
                    //bef = Boolean(sub.before && sub.before(data));
                    //console.log(bef);
                    //表单提交事件（处理在subUp函数内部处理）
                    sub.form && bef && subUp(sub.form, dataBase);
                    //表单提交后处理事件(不推荐使用，推荐使用ajax success/error处理)
                    sub.func && sub.func(dataBase);
                    //阻止按钮默认事件
                    return false;
                })
            }

            //表单组建监听事件
            //可以监听的组建 select checkbox switch radio
            if (eve && eve !== false) {
                if (Type(eve) === "json") {
                    setE(eve);
                } else if (Type(eve) === "array") {
                    for (var e = 0; e < eve.length; e++) {
                        setE(eve[e]);
                    }
                }

                function setE(eve) {
                    if (eve.box) {
                        if (eve.filter) {
                            //当eve.filter = true时则使用默认的过滤字符，否则使用自定义的字符
                            eve.filter === true ? filter = '(' + normal.filter + ')' : filter = '(' + eve.filter + ')';
                        }
                        form.on(eve.box + filter, function (data) {
                            //data：所有数据,包含内容如下
                            //-----elem:原始DOM对象(select(下拉) checkbox(复选) switch(开关) radio(单选))
                            //-----value:被选中的值(select(下拉) checkbox(复选) switch(开关) radio(单选))
                            //-----othis:美化后的DOM对象(select(下拉) checkbox(复选) switch(开关))
                            //-----elem.checked(checkbox(复选) switch(开关))

                            //如果存在函数则执行函数
                            eve.func || eve.func(data);

                            //自定义是否需要阻止默认事件
                            if ((eve.break || false) === true) {
                                //阻止按钮默认事件
                                return false;
                            }
                        })
                    }
                }

                //设定固定的提交按钮事件还是所有的提交按钮的事件

            }
        }
        //表格渲染
        if (addTable && Type(addTable) === "json") {

            //表格函数调用函数函数
            function tableFunc() {
                if (Type(arguments) === "json") {
                    var obj = arguments[0].obj;
                    for (var name in arguments[0]) {
                        if(arguments[0].hasOwnProperty(name)){
                            if (func[name]) {
                                func[name].call(obj, arguments[0][name]);
                                console.log(name + " 已加载！");
                            }
                        }
                    }
                } else {
                    layer.msg("系统错误！");
                    console.error("tableFunc参数填写错误");
                }
            }

            var args_table = {
                elem: '#table'
                , page: true
                , toolbar: '#toolBar'
                , height: 'full-25'
                , title: '数据表'
                , limit: 15
                , limits: [15, 25, 35, 45, 55, 65, 75, 85, 95]
                , minWidth: 1200
                , text:
                    {
                        none: "暂时还没有数据哦！"
                    }
                , id: "table"
            }
                , tbs = addTable.table//自定义表格参数
                , res = addTable.reSet;//自定义数据重载参数

            //TABLE表格创建
            if (tbs && tbs !== false) {
                if (Type(tbs) === "json") {
                    compereData(tbs, args_table);
                    table.render(tbs);
                } else if (Type(tbs) === "array") {
                    for (var x = 0; x < tbs.length; x++) {
                        if (Type(tbs[x]) === "json") {
                            compereData(tbs[x], args_table);
                            table.render(tbs[x]);
                        }
                    }
                }
            }

            //表格数据重载(查询数据)
            if (res && res !== false) {
                var type = res.type || "search"//绑定data-type="search"的按钮
                    , active = {}//绑定按钮事件
                    , resValue = {};//重载值
                //绑定按钮事件
                active[type] = function () {
                    //动态获取表单数据
                    if(Type(res.data) === "array"){
                        for(var x=0;x<res.data.length;x++){
                            var inputValue = $("input[name='"+res.data[x]+"']").val();
                            if(inputValue){
                                resValue[res.data[x]] = inputValue;
                            }else if($("select[name='"+res.data[x]+"']").val()){
                                resValue[res.data[x]] = $("select[name='"+res.data[x]+"']").val();
                            }
                        }
                        //console.log(resValue);
                    }

                    //添加额外数据
                    if(res.where){
                        for (var name in res.where) {
                            if (res.where.hasOwnProperty(name)) {
                                resValue[name] = res.where[name];
                            }
                        }
                        //console.log(resValue);
                    }
                    if(res.dat){
                        var dat = "",datArray="",bar = "~";
                        if(Type(res.dat) === "array"){
                            console.log(this);
                            dat = $(res.dat[0]).val();
                            if(res.dat[3]){
                                bar = dat[3]
                            }
                            datArray = dat.split(bar);
                            resValue[res.dat[1]] = datArray[0].trim();
                            resValue[res.dat[2]] = datArray[1].trim();
                        }else if(Type(res.dat) === "json"){
                            dat = $(res.dat.elem).val();
                            datArray = dat.split(res.dat.bar || "~");
                            resValue[res.dat.bTime] = datArray[0].trim();
                            resValue[res.dat.eTime] = datArray[1].trim();
                        }
                    }
                    console.log(resValue);
                    //执行重载
                    table.reload(
                        res.tid || args_table.id,
                        {
                            url: res.url
                            , where: resValue
                        });
                    //重新渲染日期选择器
                    if($.cookie("dddd")){
                        laydate.render(JSON.parse($.cookie("dddd")));
                    }
                    //重新绑定事件
                    $(".layui-table-tool .layui-btn").on('click', function () {
                        var type = $(this).data('type');
                        active[type] ? active[type].call(this) : '';
                    });
                };

                //首次页面渲染后按钮事件绑定
                $(".layui-table-tool .layui-btn").on('click', function () {
                    var type = $(this).data('type');
                    active[type] ? active[type].call(this) : '';
                    return false;
                });
            }

            //日期选择器渲染
            //支持 默认渲染 单选择器渲染 多选择器渲染
            if (date && date !== false) {
                //当 data = true 时使用默认的参数渲染数据
                if (date === true) {
                    a(nor_date);
                    //当 data 数据类型为 JSON 时则渲染一个日期选择器(优先自定义属性)
                } else if (Type(date) === "json") {
                    a(date);
                    //当 data 数据类型为 ARRAY 时则渲染多个日期选择器(优先自定义属性)
                } else if (Type(date) === "array") {
                    for (var v = 0; v < date.length; v++) {
                        if (Type(date[v]) === "json") {
                            a(date[j]);
                        }
                    }
                }
            }
        }

        //日期选择器的渲染函数
        function a(date) {
            //匹配默认数据，未填写的参数将使用已有的参数填充
            compereData(date, nor_date);
            //判断日期选择器是否为范围选择器
            if (date.range) {
                //默认连接符
                var bars = "~";
                if (Type(date.range) === "string") {
                    bars = date.range
                }
                if(date.range === true){
                    date.range = bars;
                }
                //默认日期渲染
                date.value = today + " " + bars + " " + today;
            }
            //日期选择器渲染
            laydate.render(date);
            $.cookie("dddd",JSON.stringify(date));
        }
    });
});


