/*
* renderMod.js用于渲染页面中的数据表格和表单，可以根据需要渲染出不同的页面并添加相应的功能
* 作者：张小富
* 创建事件：2019-1-1 完善时间：
* 修改时间：
* 代码说明：---1：renderMod.js 为tableNormal.js和formNormal.js的组合文件，意在提高代码复用，回归功能本质
*            2：renderMod.js大部分组建使用方法与其他两个文件中定义的相同使用上略有偏差，详细请看相关说明文档，推荐使用renderMod渲染页面
* */

$(function () {
    layui.use(['table', 'form', 'laydate', 'element', 'upload', "jquery", "layer","util"], function () {
        var table = layui.table, form = layui.form, element = layui.element, laydate = layui.laydate,
            upload = layui.upload, $ = layui.jquery, layer = layui.layer,util = layui.util,param = {},
            formAction = renderMod['form'] || renderMod['formAction']//表单数据
            ,addTable = renderMod['table'] || renderMod['addTable']//表格数据
            ,bindButton = renderMod['btn'] || renderMod['bindButton']//按钮数据
            ,ahead = renderMod['first'] || renderMod['firstExecute']//最先加载内容
            ,bindEvent = renderMod['bind'] || renderMod['bindEvent']//常用事件绑定
        ;
        //最先加载事件
        if(ahead && ahead !== false){
            if(Type(ahead)==="function"){
                ahead();
            }
        }
        //表单渲染
        if (formAction && Type(formAction) === "json") {
            var normal = {
                    filter: "sub"
                },//通用默认操作集合
                nor_date = {
                    elem: "#date",
                    format:"y-M-d",
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
                if (val.filter && (val.select || val.get || (val.options && Type(val.options) === "json"))) {
                    if (val.get) {
                        val.get.success = function (res) {
                            var dat = res.data.data,value = {};
                            if(res.code ===0 && res.data){
                                for (var name in dat[0]) {
                                    if (dat[0].hasOwnProperty(name)) {
                                        if(val.dateName && name === val.dateName){
                                            //格式化日期时间
                                            value[name] = layui.util.toDateString(new Date(dat[0][name]).getTime(),"yyyy年MM月dd日");
                                        }else{
                                            value[name] = dat[0][name];
                                        }
                                    }
                                }
                                form.val(val.filter, value);
                            }
                        };
                        subUp(val.get)
                    }

                    if(val.select){
                        if(Type(val.select) === "json"){
                            getSelect(val.select);
                        }else if(Type(val.select) === "array"){
                            for(var s=0;s<val.select.length;s++){
                                getSelect(val.select[s]);
                            }
                        }

                        function getSelect(re){
                            var id = re.ids || "id",text = re.text || "text",filter = re.filter || "select";
                            re.success = function(res){
                                if (res.code === 0) {
                                    var $d = $("select[lay-filter='"+filter+"']");
                                    for (var i = 0; i < res.data.length; i++) {
                                        $d .append($("<option>").attr({"value":res.data[i][id]}).append(res.data[i][text]));
                                    }
                                    form.render("select");
                                }
                            };
                            //删除不必要参数，避免污染参数
                            delete re.ids;
                            delete re.text;
                            delete re.filter;
                            subUp(re)
                        }
                    }
                    if(!val.get && !val.select) {
                        form.val(val.filter, val.options);
                    }
                    form.render();
                } else{
                    putMsg({
                        error:"renderMod.js遇到一个无法处理的错误：",
                        log:"formAction.val参数传递错误(LINE:51),请参考表单渲染文档！"
                    });
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
                    compareData(ver, nor_ver);
                    form.verify(ver);
                }
            }

            //文件上传
            if (file && file !== false) {
                if (file === true) {
                    //渲染默认上传域
                    //严重不推荐使用
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
                    //dataBase：表单所有数据,包含内容如下
                    //-----elem:被执行事件的DOM对象（点击的按钮）
                    //-----form:表单dorm组建，没有form标签则不存在
                    //-----field:容器内的所有表单字段 {name: value}

                    //避免其他按钮被处理
                    if($(this).attr("lay-submit") === undefined){
                        return false;
                    }

                    //表单提交前处理事件
                    var bef = true;
                    //console.log(sub.before);
                    if (sub.before) {
                        var backBefore = sub.before(param,dataBase);
                        if(!backBefore){
                            bef = false;
                        }else{
                            console.log(backBefore);
                            param = backBefore;
                        }
                    }
                    //bef = Boolean(sub.before && sub.before(data));
                    //console.log(bef);
                    //表单提交事件（处理在subUp函数内部处理）
                    console.log(param);
                    sub.form && bef && subUp(sub.form, dataBase,param);
                    //表单提交后处理事件(不推荐使用，推荐使用ajax success/error处理)
                    sub.func && bef && sub.func(dataBase);
                    //阻止按钮默认事件
                    return false;
                })
            }

            //表单组件监听事件
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
                        //当eve.filter = true时则使用默认的过滤字符，否则使用自定义的字符
                        var filter = eve.filter === true ? '(' + normal.filter + ')' :  '(' + eve.filter + ')';
                        console.log(eve);
                        console.log(eve.box + filter);
                        form.on(eve.box + filter, function (data) {
                            //data：所有数据,包含内容如下
                            //-----elem:原始DOM对象(select(下拉) checkbox(复选) switch(开关) radio(单选))
                            //-----value:被选中的值(select(下拉) checkbox(复选) switch(开关) radio(单选))
                            //-----othis:美化后的DOM对象(select(下拉) checkbox(复选) switch(开关))
                            //-----elem.checked(checkbox(复选) switch(开关))
                            console.log("=IN=");
                            //如果存在函数则执行函数
                            eve.func && eve.func(data);

                            //自定义是否需要阻止默认事件
                            var eBreak = true;//true -> 阻止 false -> 不阻止
                            if(eve.break === false){
                                eBreak = false;
                            }
                            if (eBreak === true) {
                                //阻止按钮默认事件
                                return false;
                            }
                        })
                    }else{
                        putMsg({
                            log:"要使用event功能，box参数必须存在",
                            error:"参数填写错误！"
                        })
                    }
                }
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
                    compareData(tbs, args_table);
                    table.render(tbs);
                } else if (Type(tbs) === "array") {
                    for (var x = 0; x < tbs.length; x++) {
                        if (Type(tbs[x]) === "json") {
                            compareData(tbs[x], args_table);
                            allData = table.render(tbs[x]);
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
                    //console.log(resValue);
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
                        return active[type] ? false:"";//存在type则阻止其他事件，否则继续执行
                    });
                };

                //首次页面渲染后按钮事件绑定
                $(".layui-table-tool .layui-btn").on('click', function () {
                    //console.log("===TOOLBAR===");
                    var type = $(this).data('type');
                    //console.log(type);
                    active[type] ? active[type].call(this) : '';
                    //console.log(active[type] ? false:"");
                    return active[type] ? false:"";//存在type则阻止其他事件，否则继续执行
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
        //按钮绑定渲染
        if(bindButton && bindButton !== false){
            if(Type(bindButton)==="json"){
                btn(bindButton);
            }else if(Type(bindButton)==="array"){
                for(var b=0;b<bindButton.length;b++){
                    btn(bindButton[b]);
                }
            }

            function btn(dat){
                //console.log("===BTN===");
                //console.log(dat);
                var datType = dat.type || "click"
                    ,datBan = Boolean(dat.ban) || false
                    ,datFunc = dat.func || function(){
                    layer.alert("事件触发成功！！！");
                };
                $(dat.elem).on(datType,function(){
                        datFunc();
                        if(datBan === false){
                            return false;
                        }
                });//绑定函数
            }

        }
        //常用事件绑定
        if(bindEvent && Type(bindEvent) === "json"){
            var bindFunc = {
                delItem:function(el){
                    if(doJudg({
                        0:[el]
                    })){
                        putMsg({
                            alert:"页面调用错误，操作无法进行！",
                            error:"DOM元素填写无效！(delItem)",
                            log:el
                        });
                        return false;
                    }
                    //delItem用于删除表格中的选中数据，表格ID获取button标签的data-id，默认ID为"table"
                    $(el).on("click",function(){
                        var tableId = $(this).data("id") || "table";
                        //basic.js中定义的函数
                        action.checkTable(tableId);
                    })
                },
                addItem:function(item){
                    if(doJudg({
                        "undefined":[item.elem,item.url]
                    })){
                        putMsg({
                            alert:"页面调用错误，操作无法进行！",
                            error:"必填参数不能为空，请参照文档检查代码(addItem)！",
                            log:item
                        });
                        return false;
                    }
                    //addItem用于添加表格数据，匹配data-id对应的表格，默认表格ID为"table"
                    $(item.elem).on("click",function(){
                        var areas = ["90%","90%"],name = item.name || "sdsd",value = item.value || "j",tableId = $(this).data("id") || "table"
                            ,setUrl = item.base;
                        if(item.area === "min"){
                            areas = ["300px","400px"]
                        }
                        layOpen({
                            type:2,
                            title:"添加数据",
                            content:setUrl || item.url,
                            area:areas,
                            maxmin:false,
                            end:function(){
                                var res = tempValue(name,value);
                                action.reTable({
                                    name:tableId,
                                    data:res
                                });
                            }
                        });
                    })
                },
                selectItem:function(cl){
                    if(Type(cl) === "array"){
                        for(var i=0;i<cl.length;i++){
                            forSelect(cl[i]);
                        }
                    }else if(Type(cl) === "json"){
                        forSelect(cl);
                    }

                    function forSelect(item){
                        $(item.elem).on("click",function(){
                            if(doJudg({
                                "undefined":[item.cb,item.db,item.name,item.key,item.data]
                            })){
                                putMsg({
                                    alert:"页面调用错误，操作无法进行！",
                                    error:"必填参数不能为空，请参照文档检查代码(selectItem)！",
                                    log:item
                                });
                                return false;
                            }
                            var name = item.name,value = item.value || item.key,url = item.url || "/admin/index/global/data.html";
                            layOpen({
                                type:2,
                                title:"选择数据",
                                content:url+"?cb="+item.cb+"&db="+item.db+"&se="+item.se+"&key="+item.key+"&vg="+item.name+"&v="+item.value,
                                area:["90%","90%"],
                                end:function(){
                                    //获取数据并且删除数据
                                    var res = tempValue(name,value);
                                    //console.log(JSON.stringify(res));
                                    if(res === undefined){
                                        //不提示信息，避免用户取消
                                        return false;
                                    }else{
                                        //item.data[item.key] = {};
                                        item.data[item.key] = res;
                                        //console.log(res);
                                        for(var i=0;i<res.length;i++){
                                            for(var key in res[i]){
                                                if(res[i].hasOwnProperty(key)){
                                                    $("*[name="+key+"]").val(res[i][key])
                                                }
                                            }
                                        }
                                    }
                                }
                            });
                        })
                    }
                }
            };
            //匹配并运行函数，将参数传递进函数
            for(var name in bindEvent){
                if(bindEvent.hasOwnProperty(name)){
                    if(bindFunc[name] !== undefined){
                        bindFunc[name](bindEvent[name]);
                    }
                }
            }
        }

        //日期选择器的渲染函数
        function a(date) {
            //匹配默认数据，未填写的参数将使用已有的参数填充
            compareData(date, nor_date);
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
            $.cookie("RenderDate-a-Func",JSON.stringify(date));
        }
    });
});


