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
            , addTable = renderMod['table'] || renderMod['addTable'];//表格数据
        //表单渲染
        if (formAction && Type(formAction) === "json") {
            var normal = {
                    filter: "sub"
                },//通用默认操作集合
                nor_date = {
                    elem: "#date",
                    value: today,
                    format: "y-M-d"
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

                //日期选择器的渲染函数
                function a(date) {
                    //匹配默认数据，未填写的参数将使用已有的参数填充
                    compereData(date, nor_date);
                    //判断日期选择器是否为范围选择器
                    if (date.range) {
                        //默认连接符
                        var bars = date.bar || "-";
                        if (Type(date.range) === "array") {
                            bars = date.range
                        }
                        //默认日期渲染
                        date.value = today + " " + bars + " " + today
                    }
                    //日期选择器渲染
                    laydate.render(date);
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
                    , resValue = {};//
                //绑定按钮事件
                active[type] = function () {
                    //动态获取表单数据
                    if(Type(res.data) === "array"){
                        for(var x=0;x<res.data.length;x++){
                            console.log("input="+res.data[x]);
                            resValue[res.data[x]] = $("input[name='"+res.data[x]+"']").val();
                            console.log(resValue[res.data[x]]);
                        }
                        console.log(resValue);
                    }

                    //添加额外数据
                    if(res.where){
                        for (var name in res.where) {
                            if (res.where.hasOwnProperty(name)) {
                                resValue[name] = res.where[name];
                            }
                        }
                        console.log(resValue);
                    }
                    console.log(resValue);
                    //执行重载
                    table.reload(
                        res.tid || args_table.id,
                        {
                            url: res.url
                            , where: resValue
                        });
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
                });
            }
        }
    });
});


