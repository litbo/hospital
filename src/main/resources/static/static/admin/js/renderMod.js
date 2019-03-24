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
                if (val.filter && (val.list || val.select || val.get || (val.options && Type(val.options) === "json"))) {
                    //表单渲染
                    if (val.get) {
                        val.get.success = function (res) {
                            if(res.code !== 0 && res.data !== undefined){
                                layer.alert("数据渲染失败！");
                                console.log(res);
                                return false;
                            }
                            var dat = null,value = {};
                            if(res.data){
                                if(res.data.data !== undefined){
                                    dat = res.data.data;
                                }else if(res.data.list !== undefined){
                                    dat = res.data.list[0];
                                }else{
                                    dat = res.data;
                                }
                            }

                            if(res.code === 0 && dat !== undefined){
                                if(val.get.save){
                                    val.get.save["val"] = dat;
                                    console.log(val.get.save);
                                }
                                for (var name in dat) {
                                    if (dat.hasOwnProperty(name)) {
                                        if(val.dateName && name === val.dateName){
                                            //格式化日期时间
                                            value[name] = layui.util.toDateString(new Date(dat[name]).getTime(),"yyyy年MM月dd日");
                                        }else{
                                            value[name] = dat[name];
                                        }
                                        //表格渲染
                                        if(val.get.parse !== undefined){
                                            table.reload(val.get.tableId,{
                                                data:dat[val.get.parse]
                                            })
                                        }
                                    }
                                }
                                //表单默认值填充
                                form.val(val.filter, value);
                                if(val.datas !== undefined){
                                    val.datas[res] = res.data;
                                }
                            }
                        };
                        subUp(val.get)
                    }
                    //下拉渲染
                    if(val.select){
                        if(Type(val.select) === "json"){
                            getSelect(val.select);
                        }else if(Type(val.select) === "array"){
                            for(var s=0;s<val.select.length;s++){
                                getSelect(val.select[s]);
                            }
                        }
                    }
                    //多数据表格渲染
                    if(val.list){
                        if(Type(val.list) === "json"){
                            getSelect(val.list);
                        }else if(Type(val.list) === "array"){
                            for(var f=0;f<val.list.length;f++){
                                getSelect(val.list[f]);
                            }
                        }
                    }
                    //当不需要获取数据的时候就直接渲染页面
                    if(!val.get && !val.select && !val.list) {
                        form.val(val.filter, val.options);
                    }
                    //页面表单渲染
                    form.render();
                } else{
                    putMsg({
                        error:"renderMod.js遇到一个无法处理的错误：",
                        log:"renderMod.formAction.val参数传递错误(LINE:116),请参考表单渲染文档！"
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
                //文件上传事件
                function cUp(options) {
                    var dataP = {}, valus = "";
                    if (Type(options.data) === "array") {
                        //dataP 提交的数据 valus 填写的表单name值
                        for (var i = 0; i < options.data.length; i++) {
                            //获取一个name值
                            valus = options.data[i];
                            //获取表单中的数据，支持 input select textarea ,存在时就将data.field中的数据添加到dataP
                                var inputValue = $("input[name=" + valus + "]").val();
                                if (inputValue) {
                                    dataP[valus] = inputValue;
                                } else if ($("select[name=" + valus + "]").val()) {
                                    dataP[valus] = $("select[name=" + valus + "]").val();
                                } else if($("textarea[name=" + valus + "]").val()){
                                    dataP[valus] = $("textarea[name=" + valus + "]").val();
                                } else if($("input[type=radio][name=" + valus + "]").val()){
                                    dataP[valus] = $("input[type=radio][name=" + valus + "]").val();
                                } else if($("input[type=checkbox][name=" + valus + "]").val()){
                                    var $cks = $("input[type=checkbox][name=" + valus + "]");
                                    if($cks[0].checked === true){
                                        dataP[valus] = $cks.val();
                                    }
                                }
                        }
                        //向data中直接添加附加数据
                        if (options.add) {
                            for (var names in options.add) {
                                if (options.add.hasOwnProperty(names)) {
                                    dataP[names] = options.add[names];
                                }
                            }
                        }
                    }else if(Type(options.data) === "json"){
                        dataP = options.data;
                    }
                    options.data = dataP;
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
                            param = backBefore;
                        }
                    }
                    //console.log(bef);
                    //表单提交事件（处理在subUp函数内部处理）
                    //console.log(param);
                    var subForm = sub.up || sub.form;
                    subForm && bef && subUp(subForm, dataBase,param);
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
                        var filter = eve.filter === true ? '(' + normal.filter + ')' :  '(' + eve.filter + ')' || "";
                        console.log(eve);
                        console.log(eve.box + filter);
                        form.on(eve.box + filter, function (data) {
                            //data：所有数据,包含内容如下
                            //-----elem:原始DOM对象(select(下拉) checkbox(复选) switch(开关) radio(单选))
                            //-----value:被选中的值(select(下拉) checkbox(复选) switch(开关) radio(单选))
                            //-----othis:美化后的DOM对象(select(下拉) checkbox(复选) switch(开关))
                            //-----elem.checked(checkbox(复选) switch(开关))
                            //console.log("=IN=");
                            //如果存在函数则执行函数
                            eve.func && eve.func(data,eve);

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
                    , nData = []
                    , cData = []
                    , active = {}//绑定按钮事件
                    , resValue = {};//重载值
                //绑定按钮事件
                active[type] = function () {
                    resValue = {};
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
                    }
                    //添加额外数据
                    if(res.where){
                        for (var name in res.where) {
                            if (res.where.hasOwnProperty(name)) {
                                resValue[name] = res.where[name];
                            }
                        }
                    }
                    //时间选择器数据拆分
                    if(res.dat){
                        var dat = "",datArray="",bar = "~";
                        if(Type(res.dat) === "array"){
                            dat = $(res.dat[0]).val();
                            if(res.dat[3]){
                                //获取自定义的连接符
                                bar = res.dat[3]
                            }
                            datArray = dat.split(bar);
                            resValue[res.dat[1]] = datArray[0].trim();
                            resValue[res.dat[2]] = datArray[1].trim();
                        }else if(Type(res.dat) === "json"){
                            dat = $(res.dat.elem).val();
                            datArray = dat.split(res.dat.bar || bar);
                            resValue[res.dat.bTime] = datArray[0].trim();
                            resValue[res.dat.eTime] = datArray[1].trim();
                        }
                    }
                    //获取重载前表格数据
                    if(res.add === true && res.add.tableId !== undefined){
                        nData = table.cache(res.add.tableId);
                    }
                    //执行重载
                    table.reload(
                        res.tid || args_table.id,
                        {
                            url: res.url
                            , where: resValue
                            , parseData:res.parseData || function(res){
                                for(var x=0;x<nData.length;x++){
                                    res.data.list.push(nData[x]);
                                }
                                return {
                                    "code": res.code, //解析接口状态
                                    "msg": res.msg, //解析提示文本
                                    "count":res.data.total,//页面的所有数据数
                                    "data": res.data.list //解析数据列表
                                }
                            }
                        });
                    form.render();
                    //还原重载前的数据
                    if(res.add === true && res.add.tableId !== undefined){
                        cData = table.cache(res.add.tableId);
                        for(var b=0;b<cData.length;b++){
                            nData.push(cData[b]);
                        }
                        table.reload(res.add.tableId,{
                            data:nData
                        });
                    }
                    //重新渲染日期选择器
                    if($.cookie("RenderDate-a-Func")){
                        laydate.render(JSON.parse($.cookie("RenderDate-a-Func")));
                    }

                    //重新绑定select事件
                    if($(".layui-table-tool select").length > 0){
                        var val = {};
                        if(formAction !== undefined){
                            val = formAction.val ;
                        }
                        if(val.select){
                            if(Type(val.select) === "json"){
                                getSelect(val.select);
                            }else if(Type(val.select) === "array"){
                                for(var s=0;s<val.select.length;s++){
                                    getSelect(val.select[s]);
                                }
                            }
                            //重新渲染下拉
                            form.render("select");
                        }
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
                    var type = $(this).data('type');
                    active[type] ? active[type].call(this) : '';
                    return active[type] ? false:"";//存在type则阻止其他事件，否则不阻止
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
                            a(date[v]);
                        }
                    }
                }
            }

        }
        //按钮绑定渲染
        if(bindButton && bindButton !== false){
            //数据类型判断
            if(Type(bindButton)==="json"){
                btn(bindButton);
            }else if(Type(bindButton)==="array"){
                for(var b=0;b<bindButton.length;b++){
                    btn(bindButton[b]);
                }
            }
            //数据事件绑定函数
            function btn(dat){
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
                    //数据类型判断
                    if(doJudg({
                        0:[$(el)]
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
                addItem:function(cl){
                    //数据类型判断
                    if(Type(cl) === "array"){
                        for(var i=0;i<cl.length;i++){
                            forAdd(cl[i]);
                        }
                    }else if(Type(cl) === "json"){
                        forAdd(cl);
                    }
                    //添加表格数据事件函数
                    function forAdd(item){
                        //数据有效性判断
                        if(doJudg({
                            "undefined":[item.elem]
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
                            var areas = ["90%","90%"],
                                name = item.name || "sdsd",
                                value = item.value || item.key || "j",
                                tableId = item.table || $(this).data("id") || "table"
                                ,setUrl = "";
                            //判断是否使用固定小尺寸窗口
                            if(item.area === "min"){
                                areas = ["300px","400px"]
                            }
                            //获取数据页URL地址
                            if(item.url){
                                setUrl = item.url
                            }else{
                                //设置URL
                                setUrl = item.base || "/admin/index/global/data.html";
                                //设置参数
                                setUrl += "?cb="+item.cb+"&db="+item.db+"&se="+item.se+"&key="+item.key+"&vg="+item.name+"&v="+item.value;
                            }
                            //弹出自定义窗口
                            layOpen({
                                type:2,
                                title:"添加数据",
                                content:setUrl,
                                area:areas,
                                maxmin:false,
                                end:function(){
                                    //获取本地存储中的数据
                                    var res = tempValue(name,value);
                                    //数据有效则添加
                                    if(res !== undefined){
                                        //向表格中添加数据
                                        action.reTable({
                                            name:tableId,
                                            data:res
                                        });
                                    }
                                }
                            });
                            return false;
                        })
                    }
                },
                selectItem:function(cl){
                    //数据类型判断
                    if(Type(cl) === "array"){
                        for(var i=0;i<cl.length;i++){
                            forSelect(cl[i]);
                        }
                    }else if(Type(cl) === "json"){
                        forSelect(cl);
                    }
                    //数据选择事件处理
                    function forSelect(item){
                        $(item.elem).on("click",function(){
                            //判断数据有效性
                            if(doJudg({
                                "undefined":[item.key,item.name,item.data]
                            })){
                                putMsg({
                                    alert:"页面调用错误，操作无法进行！",
                                    error:"必填参数不能为空，请参照文档检查代码(selectItem)！",
                                    log:item
                                });
                                return false;
                            }
                            //调用值
                            var name = item.name,
                                param = {},
                                value = item.value || item.key,
                                url = item.url || "/admin/index/global/data.html"
                                ,content = url + "?key=" + item.key + "&vg=" + name;
                            if(item.cb){
                                content += "&cb=" + item.cb
                            }
                            if(item.db){
                                content += "&db="+item.db
                            }
                            if(item.se){
                                content += "&se="+item.se
                            }
                            if(item.value){
                                content += "&v="+value
                            }

                            //提交之前运行一个函数
                            var ss = item.before && item.before();
                            //如果有返回值并且需要添加数据则循环添加
                            if(ss && item.param && Type(item.param) === "array" && Type(ss) === "json"){
                                for(var p=0;p<item.param.length;p++){
                                    for(var nas in ss){
                                        if(ss.hasOwnProperty(nas)){
                                            if(nas === item.param[p]){
                                                content += "&" + nas + "=" + ss[nas];
                                            }
                                        }
                                    }
                                }
                            }
                            layOpen({
                                type:2,
                                title:"选择数据",
                                content:content,
                                area:["90%","90%"],
                                end:function(){
                                    //获取数据并且删除数据
                                    var res = tempValue(name,value);
                                    //判断是否选择了数据
                                    if(res !== undefined){
                                        //将获取到的值写到指定变量的指定参数内
                                        item.data[item.key] = res;
                                        //寻找匹配的元素并且将匹配上name值的DOM赋值
                                        for(var i=0;i<res.length;i++){
                                            for(var key in res[i]){
                                                if(res[i].hasOwnProperty(key)){
                                                    var $dom = $("input[name="+key+"]");
                                                    //判断DOM是否存在
                                                    if($dom.length > 0){
                                                        $dom.val(res[i][key]);
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                        item.func && item.func(res);
                                    }
                                }
                            });
                            return false;
                        })
                    }
                }
            };
            //匹配并运行函数，并将参数传递进函数
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
            if(date === undefined){
                return false;
            }
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
        //下拉列表动态加载
        function getSelect(re,tab){
            //re 提交的数据
            var id = re.ids || "id",
                text = re.text || "text",
                filter = re.filter || "select";
            if(tab === undefined){
                re.success = function(res){
                    if (res.code === 0) {
                        //获取指定select标签
                        var $d = $("select[lay-filter='"+filter+"']");
                        var datt = res.data.list || res.data;
                        for (var i = 0; i < datt.length; i++) {
                            //动态渲染option标签并且渲染进页面
                            $d .append($("<option>").attr({"value":datt[i][id]}).append(datt[i][text]));
                        }
                        //表单下拉单独重新渲染
                        form.render("select");
                    }else{
                        putMsg({
                            alert:"数据加载失败！",
                            error:"返回数据异常！",
                            log:res
                        });
                    }
                };
            }else{
                re.success = function(res){
                    if (res.code === 0) {
                        table.reload(tab,{
                            data:res.data
                        });
                    }else{
                        putMsg({
                            alert:"数据加载失败！",
                            error:"返回数据异常！",
                            log:res
                        });
                    }
                };
            }

            re.error = function(res){
                putMsg({
                    alert:"数据加载失败！",
                    error:"数据提交异常！",
                    log:res
                });
            };
            //删除不必要参数，避免污染参数
            //删除参数将导致无法重载，不建议删除
            /*if(!del){
                delete re.ids;
                delete re.text;
                delete re.filter;
            }*/
            //获取数据并渲染页面
            subUp(re)
        }
    });
});


