/*
* basic.js 页面的基本函数集合,放置于页面顶部，且必须位于JQuery.js之后
* */

/**
 * @todo 全局通用变量的定义
 * @arguments
 * @return 当前时间计算 date year month day today time
 *         表格表单定义数据 renderMod
 **/
//计算当前时间
var date = new Date()
    , year = date.getFullYear()
    , month = date.getMonth() + 1
    , day = date.getDate()
    , today = year + "-" + month + "-" + day//获取年-月-日
    , time = date.getTime(),
    //初始化页面渲染数据
    renderMod = {}
    ,allData = null;

/**
 * @todo 日期格式化
 * @tips 以下日期转换方式将在未来被删除，推荐使用layui日期转换格式，详见文档
 * @arguments time -> 需要转换的日期
 * @return {string} -> 转换后的时间
 **/
//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
//例子：
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function(fmt) {
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    console.log(this);
    if(/(y+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o){
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    //console.log(fmt);
    return fmt;
};

/**
 * @todo 获取URL中的参数的值
 * @arguments name -> 需要获取的URL参数
 * @return true -> 对应参数的值 {string}
 *         false -> null {null}
 **/
(function ($) {
    $.getUrlParam = function (name, site) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"), r;
        if (site === 1) {
            r = window.parent.location.search.substr(1).match(reg)
        } else {
            try {
                r = site.location.search.substr(1).match(reg);
            } catch (e) {
                r = window.location.search.substr(1).match(reg)
            }
        }
        if (r != null) return decodeURI(r[2]);
        return null;
    };
})(jQuery);

/**
 * @todo 本地存储-cookie
 * @tips 以下存储方式将在未来被删除，推荐使用layui-data等框架支持方式本地存储，详见文档
 * @arguments name -> 操作的cookie名
 *            value -> 操作的cookie值
 *            options -> 操作的cookie的其他参数
 * @return {string} -> 读取的cookie
 */
jQuery.cookie = function (name, value, options) {
    if (typeof value !== 'undefined') {
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires === 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires === 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString();
        }
        var path = options.path ? '; path=' + (options.path) : '';
        var domain = options.domain ? '; domain=' + (options.domain) : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else {
        var cookieValue = null;
        if (document.cookie && document.cookie !== '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                if (cookie.substring(0, name.length + 1) === (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};

/**
 * @todo 本地存储-session
 * @tips 专对于导航（其他可用，需要适当调整输入）
 * @arguments title -> 操作的session名
 *            url -> 操作的session所在的链接search信息
 *            id -> 操作的session对应的导航ID
 * @return {string} -> 读取的session
 */
//本地存储记录所有打开的窗口
function setStorageMenu(title, url, id) {
    var menu = JSON.parse(sessionStorage.getItem('menu'));
    if (menu) {
        var deep = false;
        for (var i = 0; i < menu.length; i++) {
            if (menu[i].id === id) {
                deep = true;
                menu[i].title = title;
                menu[i].url = url;
                menu[i].id = id;
                menu[i].search = $.getUrlParam('p');
            }
        }
        if (!deep) {
            menu.push({
                title: title,
                url: url,
                id: id,
                search: $.getUrlParam('p')
            })
        }
    } else {
        menu = [{
            title: title,
            url: url,
            id: id,
            search: $.getUrlParam('p')
        }]
    }
    sessionStorage.setItem('menu', JSON.stringify(menu));
}

//本地存储记录当前打开窗口
function setStorageCurMenu() {
    var curMenu = sessionStorage.getItem('curMenu'),$layTabTit = $('.layui-tab-title'),
    text = $layTabTit.find('.layui-this').text();
    text = text.split('ဆ')[0];
    if (text === "系统主页") {
        return;
    }
    var url = $('.layui-tab-content').find('.layui-show').find('.weIframe').attr('src');
    var id = $layTabTit.find('.layui-this').attr('lay-id');
    curMenu = {
        title: text,
        url: url,
        id: id,
        search: location.search
    };
    sessionStorage.setItem('curMenu', JSON.stringify(curMenu));
}

//本地存储中移除删除的元素
function removeStorageMenu(id) {
    var menu = JSON.parse(sessionStorage.getItem('menu'));
    //var curMenu = JSON.parse(localStorage.getItem('curMenu'));
    if (menu) {
        var deep = false;
        for (var i = 0; i < menu.length; i++) {
            if (menu[i].id === id) {
                deep = true;
                menu.splice(i, 1);
            }
        }
    } else {
        return false;
    }
    sessionStorage.setItem('menu', JSON.stringify(menu));
}

/**
 * @todo 临时数据传递
 * @tips
 * @arguments name -> 获取的表名
 *            value -> 获取的键值,当value不存在时则默认会清空表内所有数据
 *            clear -> 获取后是否清空原数据（可空，默认清空查询的数据，可赋值null清空表内所有数据）
 *            type -> 数据存储方式（可空，默认sessionData）
 * @return {string} -> 获取的值，如无value则
 **/
function tempValue(name,value,clear,type){
    var temp = null;
    //获取存储的值
    switch(type){
        case"data":temp = layui.data(name);break;
        default:temp = layui.sessionData(name);break;
    }
    //清除存储的值
    if(value === undefined || clear === null || clear === "null"){
        layui.sessionData(name,null);
    }else if(clear !== false){
            layui.sessionData(name,{
                remove:true,
                key:value
            });

    }
    //返回值
    if(value){
        return temp[value];
    }else{
        return temp;
    }
}

/**
 * @todo 数据类型判断
 * @tips 类型中返回的Json对应格式为{...},其他格式Json返回相应格式
 * @arguments value -> 需要判断的数据
 * @return {string} -> 类型对应的小写名
 **/
function Type(value) {
    if (value === undefined) {
        return "undefined";
    } else if (value === null) {
        return "null";
    } else if (typeof value === "object") {
        if (value instanceof Array) {
            return "array";
        } else if (value instanceof Function) {
            return "function";
        } else {
            try {
                var tt = typeof JSON.parse(JSON.stringify(value))
            } catch (e) {
                return value.constructor;
            }
            if (tt === "object") {
                return "json"
                //"json"表示格式为{}的数据，非严格意义的json
            }
        }
    } else if (typeof value === "function") {
        return "function";
    } else {
        var type = typeof (value);
        return type.toLowerCase();
    }
}

/**
 * @todo 错误提示与输出
 * @tips
 * @arguments errMsg -> 提示与输出信息
 * @return
 **/
function putMsg(errMsg){
    layui.use('layer',function(){
        var layer = layui.layer;
        //console.log(errMsg);
        //LAYUI方法
        errMsg.msg && layer.msg(errMsg.msg);
        errMsg.alert && layer.alert(errMsg.alert);
        //Console方法
        errMsg.log && console.log(errMsg.log);
        errMsg.error && console.error(errMsg.error);
        //Window方法
        errMsg.wAlert && layer.wAlert(errMsg.wAlert);
    })
}

/**
 * @todo 数据合并（JSON）
 * @tips 合并两个数据不一样之处，将y中x没有的项添加进x中（X为主）
 * @arguments x -> 主数据
 *            y -> 基础数据(用于比较的数据)
 * @return {Object} -> x*
 */
function compereData(x, y) {
    for (var name in y) {
        if(y.hasOwnProperty(name)){
            if (x[name] === undefined) {
                x[name] = y[name];
            }
        }
    }
}


/**
 * @todo 页面加载效果遮罩
 * @arguments text -> 提示文字
 *            time -> 遮罩自动结束时间
 * @return
 **/
function markPage(text, time){
    //如果页面中不存在定位元素则创建定位元素
    var $beg = $(".begin");
    if ($beg.length <= 0) {
        $("body").prepend($("<div>").attr("class", "begin"))
    }
    var timer = null;
    text = text || "页面急速加载中!";//遮罩提示文本
    time = Number(time) || 3000;//遮罩显示时间
    //渲染页面遮罩样式
    $beg.append($("<div>").attr("class", "main-mask").css({"display": "block", "background": "rgba(0,0,0,0.6)"})
        .append($("<p>").attr("class", "loading").html("<br />" + text)
            .prepend($("<i>").attr("class", "layui-icon layui-icon-loading layui-icon layui-anim layui-anim-rotate layui-anim-loop"))
        ));
    //一定时间后自动移除遮罩
    clearTimeout(timer);
    timer = setTimeout(function () {
        $(".begin").remove();
    }, time);
    //监听页面加载完毕后移除遮罩元素
    document.addEventListener('readystatechange', function () {
        if (document.readyState === "complete") {
            $(".begin").remove();
        }
    });
}

/**
 * @todo 模拟弹出窗口
 * @tips
 * @arguments data -> 自定义弹出参数
 *            def_data -> 默认弹出参数（可不填）
 * @return
 */
function layOpen(data,def_data){
    var w = document.body.clientWidth - 20
        , h = document.body.clientHeight - 20
        ,def_open=
        {
            type:1,
            title:"详情",
            content:"无内容哦~",
            area:[w + "px", h + "px"],
            resize:false,
            maxmin:true,
            move:false,
            scrollbar:false
        }
    ;
    compereData(data,def_data || def_open);
    if(data.site === "top"){

    }
    switch(data.site){
        case "top":return top.layer.open(data);
        case "parent":return parent.layer.open(data);
        default :return layer.open(data);
    }

}

/**
 * @todo 数据提交
 * @tips 包含3种提交形式（原生HTML提交 JS-AJAX XHR提交 JQ-AJAX提交）
 * @param value -> 需要提交的必要参数
 * @param data -> layui返回的函数参数
 * @return value参数不正确 -> false{boolean}
 */
function subUp(value, data) {
    //value：提交参数 data：submit函数中默认的参数(可选，当data不存在时将自动获取表单数据)
    //判断必填项是否为空
    if (!value.url && (value.switch !== "xhr" && value.switch !== "html" && value.data)) {
        return false;
    }
    //判断是否需要自动获取表单数据(根据input的name属性自动获取所有的数据)
    if (Type(value.data) === "array") {
        var dataP = {}, valus = null;
        for (var i = 0; i < value.data.length; i++) {
            valus = value.data[i];
            if (!data) {
                var inputValue = $("input[name=" + valus + "]").val();
                if (inputValue) {
                    dataP[valus] = inputValue;
                } else if ($("select[name=" + valus + "]").val()) {
                    dataP[valus] = $("select[name=" + valus + "]").val();
                }
            } else {
                dataP[valus] = data.field[valus];
            }
        }
        if (value.add) {
            for (var names in value.add) {
                if (value.add.hasOwnProperty(names)) {
                    dataP[names] = add[names];
                }
            }
        }
    }
    //判断当前数据上传类型(默认以JQajax提交)
    if (value.switch === "xhr") {//以原生JS形式异步提交数据(基本代码)
        //if (value.data.file) {//！！！！！代码未完善！！！！！
        //var formData = new FormData();
        //formData.append(value.data.name, $(value.data.file)[0].files[0]);
        //console.log(formData);
        // XMLHttpRequest 对象
        var xhr = new XMLHttpRequest();
        xhr.open(value.method || "GET", value.url, value.async || true);
        xhr.onload = function () {
            alert("上传完成!");
        };
        xhr.send(form);
        //}
    } else if (value.switch === "html") {//以HTML默认的方式提交数据
        //使用HTML默认提交方式提交数据（使用新建内嵌框架实现不跳转新页面）
        //使用不可见iframe获取返回数据，但由于未知原因(暂未知)无法获取iframe内返回的数据，故目前只能提交则成功
        //form标签无需添加method和url，只需在数据中填写则可以自动渲染
        var frameName = value.target || "framesXXX";
        $("body").append($("<iframe>").attr({
            "name": frameName,
            "style": "display:none;width:1px;height:1px;",
            "id": "framesX"
        }));
        var $form = $("#form");
        $form.attr({"method": value.method || "GET", "action": value.url, "target": frameName});
        $form[0].submit();
        alert("提交成功！");
        window.location.reload();
    } else {//以ajax形式提交数据(默认)
        //以参数形式调用获取的数据解决异步数据不可外部调用与修改
        var ajaxOptions = {
            success: function (data) {
                //如果参数中没有给出默认成功函数则只判断是否传输成功，其他数据的解析将通过参数中的done内函数完成
                if (data.code === 0) {
                    alert("提交成功！");
                } else if (data.code === 1) {
                    alert("提交失败，请重试！");
                }
                value.done && value.done();
            },
            error: function (er) {
                putMsg({
                    alert:"提交失败，请重试！",
                    log:er
                });
                value.fine && value.fine(er);
            }
        };
        var backData = function (callback) {
            compereData(value, ajaxOptions);
            value.data = dataP || value.data;
            $.ajax(value);
        };
        backData(value.success);
    }
}


/**
 * @todo 多函数调用
 * @tips 函数集合
 **/
func = {
    //this = obj
    //添加提示信息
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
    //添加表格行点击
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
    //添加表格内功能按钮
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
            putMsg({
                msg:"系统错误！",
                log:value,
                error:"tableFunc参数填写错误"
            });
            return false;
        }

        function cc(vas) {
            layui.use('table', function () {
                var table = layui.table, layer = layui.layer, filt = vas.filter || "table1",tool = vas.tool || "tool",tableOn = tool+'(' + filt + ')',openT = true;
                //console.log(tableOn);
                table.on(tableOn, function (obj) {
                    //console.log(vas);
                    if(tool === "toolbar"){
                        var checkStatus = table.checkStatus(obj.config.id || vas.tableId);//获取选中数据
                    }
                    var data = obj.data;//获得当前行数据
                    //console.log("===tool/toolbar===");
                    //console.log(obj);
                    //console.log(checkStatus);
                    if(vas.dataUrl && vas.dataUrl !== false){
                        vas.content += "?";
                        for(var i=0;i<vas.dataUrl.length;i++){
                            vas.content += vas.dataUrl[i] + "=" + data[vas.dataUrl[i]] + "&";
                        }
                    }
                    //判断是否自定义layer是否弹出
                    if(vas.layOpen !== undefined) openT = Boolean(vas.layOpen);
                    openT && layOpen(vas);
                    //有函数则执行函数
                    vas.func && vas.func(obj,checkStatus);
                });
            });
        }
    },
    //添加表格编辑事件
    "tableEdit":function(value){
        allData = this.data;
        layui.use('table',function(){
            var table = layui.table;
            table.on('edit('+value.filter+')', function(obj){
                var val = obj.value //得到修改后的值
                    ,data = obj.data //得到所在行所有数据
                    ,field = obj.field //得到字段对应的name
                    ,tips = value.tip || field;
                layer.confirm("确定将 "+tips+" 修改为："+val+"吗？",function(index){
                    value.func && value.func(val,obj);
                    layer.close(index);
                })
            });
        })
    },
    "layDataAdd":function(index,data,inName){
        for(var i=0;i<inName.length;i++){
            data[inName[i]] = $("input[name='"+inName[i]+"']").val();
        }
        console.log(data);
        layer.close(index);
        //return false;
    },
    //向表格中添加数据
    "reTable":function(name,res){
        layui.use('table',function(){
            var table = layui.table;
            var oData =  table.cache[name];//获取表格所有数据
            oData.push(res);
            //重新渲染表格
            table.reload(name,{
                data : oData
            });
        });
    },
    //表格外获取选中数据并删除选中数据
    "checkTable":function(name){
        layui.use('table', function() {
            var table = layui.table;

            var oData =  table.cache[name];//获取表格所有数据
            layui.each(oData,function(index,data){
                //index -> 数据序号 data -> 遍历的所有数据
                //当钱数据被选中时则删除当前数据，否则清除LAYUI痕迹，重新渲染
                if(data.LAY_CHECKED === true){
                    oData.splice(index, 1);
                }else{
                    delete data["LAY_CHECKED"];
                    delete data["LAY_TABLE_INDEX"];
                }
            });
            table.reload(name,{
                data : oData
            });
        });
    }
};
//表格函数调用函数函数
//@tips 在未来更新中将逐渐弱化此引用函数方式，将采用直接函数书写方式
function tableFunc(fn){
    if (Type(fn) === "json") {
        var obj = fn.obj;
        for (var name in fn) {
            if(fn.hasOwnProperty(name)){
                if (func[name]) {
                    func[name].call(obj, fn[name]);
                }else{
                    switch(name){
                        case "btn":
                        case "tools":func["toolFunc"].call(obj, fn["tools"]);break;
                    }
                }
                console.log(name + " 已加载！");
            }
        }
    } else {
        putMsg({
            msg:"系统错误！",
            error:"tableFunc参数填写错误",
            log:arguments
        });
    }
}

/**
 * @todo 动态添加JS
 * @tips 动态添加页面渲染所必须的基础函数<顺序不能更改>
 * @arguments
 * @return
 */
document.write("<script type='text/javascript' data-version='x2' src='" + window.location.origin + "/static/admin/layui/layui.js'></script>");
document.write("<script type='text/javascript' data-version='x2' src='" + window.location.origin + "/static/admin/js/renderMod.js'></script>");

window.onload = function(){
    //手机版显示 数据查找 按钮
   var $dataSearch = $("a[lay-event='dataSearch']");
   if($dataSearch.length>0){
       $dataSearch.on('click',function(){
           layOpen({
               title:"数据查找",
               content:$("#hideXs")
           });
       })
   }
};
