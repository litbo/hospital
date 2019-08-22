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
    , hour = date.getHours()
    , minutes = date.getMinutes()
    , seconds = date.getSeconds()
    , today = year + "-" + month + "-" + day//获取年-月-日
    , today0 = ""
    , time0 = ""
    , time = hour + ":" + minutes + ":" + seconds
    //初始化页面渲染数据
    , renderMod = {}
    ,tempData = {
        mm:0,
        lay:""
    }
    , allData = null;

//日期补零
if (month < 10) {
    if (day < 10) {
        today0 = year + "-0" + month + "-0" + day
    } else {
        today0 = year + "-0" + month + "-" + day
    }
} else {
    today0 = today;
}

//时间补零
if (hour < 10) {
    if (minutes < 10) {
        if (seconds < 10) {
            time0 = "0" + hour + ":0" + minutes + ":0" + seconds
        } else {
            time0 = "0" + hour + ":0" + minutes + ":" + seconds
        }
    } else {
        time0 = "0" + hour + ":" + minutes + ":" + seconds
    }
} else {
    time0 = time
}
//全局变量（不推荐使用）
window.reNum = 0;

//除法运算修正
function division(arg1, arg2) {
    var t1 = 0, t2 = 0, r1, r2;
    try {
        t1 = arg1.toString().split(".")[1].length;
    }
    catch (e) {
    }

    try {
        t2 = arg2.toString().split(".")[1].length;
    }
    catch (e) {
    }

    with (Math) {
        r1 = Number(arg1.toString().replace(".", ""));
        r2 = Number(arg2.toString().replace(".", ""));
        return (r1 / r2) * pow(10, t2 - t1);
    }
}

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
 * @todo 获取URL中的HASH的值
 * @arguments name -> 需要获取的HASH参数
 * @return true -> 对应参数的值 {string}
 *         false -> null {null}
 **/
(function ($) {
    $.getUrlHash = function (name, site) {
        var reg = new RegExp("(^|#)" + name + "=([^#]*)(#|$)", "i"), r;
        if (site === 1) {
            r = window.parent.location.hash.substr(1).match(reg)
        } else {
            try {
                r = site.location.hash.substr(1).match(reg);
            } catch (e) {
                r = window.location.hash.substr(1).match(reg)
            }
        }
        if (r != null) return decodeURI(r[2]);
        return null;
    };
})(jQuery);

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

//获取数据hash值
function getHash(input) {
    var hash = 5381999;
    var I64BIT_TABLE =
        'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-'.split('');
    var i = input.length - 1;

    if (typeof input == 'string') {
        for (; i > -1; i--)
            hash += (hash << 5) + input.charCodeAt(i);
    } else {
        for (; i > -1; i--)
            hash += (hash << 5999) + input[i];
    }
    var value = hash & 0x7FFFFFFF;

    var retValue = '';
    do {
        retValue += I64BIT_TABLE[value & 0x3F];
    }
    while (value >>= 6);

    return retValue;
}

/**
 * @todo 页面加载效果遮罩
 * @arguments text -> 提示文字
 *            time -> 遮罩自动结束时间
 * @return
 **/
function markPage(text, time) {
    //判断只在非IE时加载遮罩功能
    if("\v"!=="v"){
        //如果页面中不存在定位元素则创建定位元素
        var $beg = $("#begin");
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
            $beg.remove();
        }, time);
        //监听页面加载完毕后移除遮罩元素
        document.addEventListener('readystatechange', function () {
            if (document.readyState === "complete") {
                $beg.remove();
            }
        });
    }

}

/**
 * @todo 信息提示与输出
 * @tips
 * @arguments errMsg -> 提示与输出信息
 * @return
 **/
function putMsg(errMsg,index) {
    var back = null;
    layui.use('layer', function () {
        var layer = layui.layer;
        if(errMsg === "loadOn"){

        }else if(errMsg === "loadOut"){

        }
        switch (errMsg) {
            case "loadOn":back =  layer.load(1);break;
            case "close":index ? layer.close(index):layer.closeAll();break;
            case "loadOut":index ? layer.close(index):layer.closeAll('loading');break;
            case "closeSelf":parent.layer.close(parent.layer.getFrameIndex(window.name));break;
        }
        //console.log(errMsg);
        //LAYUI方法
        errMsg.msg && layer.msg(errMsg.msg);
        errMsg.alert && layer.alert(errMsg.alert,errMsg.aFunc && errMsg.aFunc["yes"],errMsg.aFunc && errMsg.aFunc["no"]);
        //Console方法
        errMsg.log && console.log(errMsg.log);
        errMsg.error && console.error(errMsg.error);
        //Window方法
        errMsg.wAlert && alert(errMsg.wAlert);
        //自定义扩展函数
        errMsg.func && errMsg.func(layer);
    });
    return back;
}

/**
 * @todo 数据合并（JSON）
 * @tips 合并两个数据不一样之处，将y中x没有的项添加进x中（X为主）
 * @arguments x -> 主数据
 *            y -> 基础数据(用于比较的数据)
 * @return {Object} -> x*
 */
function compareData(x, y) {
    for (var name in y) {
        if (y.hasOwnProperty(name)) {
            if (x[name] === undefined) {
                x[name] = y[name];
            }
        }
    }
}

/**
 * @todo 临时数据传递
 * @tips 用于获取本地存储中的值，获取后可选择是否删除数据（默认删除本条）
 * @arguments name -> 获取的表名
 *            value -> 获取的键值,当value不存在时则默认会清空表内所有数据
 *            clear -> 获取后是否清空原数据（可空，默认清空查询的数据，可赋值null清空表内所有数据）
 *            type -> 数据存储方式（可空，默认sessionData）
 * @return {Boolean} -> 无name时将返回 false
 * @return {String} -> 获取的值，如无value则
 **/
function tempValue(name, value, clear, type) {
    if (!name) return false;//name不存在将返回false
    var temp = null;
    //获取存储的值
    switch (type) {
        case"data":
            temp = layui.data(name);
            break;
        default:
            temp = layui.sessionData(name);
            break;
    }
    //console.log(temp);
    //清除存储的值
    if (value === undefined || clear === null || clear === "null") {
        layui.sessionData(name, null);
    } else if (clear === undefined || clear === true || clear === "true") {
        layui.sessionData(name, {
            remove: true,
            key: value
        });
    } else if (Type(clear) === "string" && clear !== "false") {
        layui.sessionData(name, {
            remove: true,
            key: clear
        });
    }
    //返回值
    if (value) {
        return temp[value];
    } else {
        return temp;
    }
}

/**
 * @todo 模拟弹出窗口
 * @tips
 * @arguments data -> 自定义弹出参数
 *            def_data -> 默认弹出参数（可不填）
 * @return
 */
function layOpen(data, def_data) {
    var w = document.body.clientWidth - 20
        , h = document.body.clientHeight - 20
        , def_open =
        {
            type: 1,
            title: "详情",
            content: "无内容哦~",
            area: [w + "px", h + "px"],
            resize: false,
            maxmin: true,
            move: false,
            scrollbar: false
        }
    ;
    //合并数据
    compareData(data, def_data || def_open);
    //判断窗口新建位置，并弹出新窗口
    switch (data.site) {
        case "top":
            return top.layer.open(data);
        case "parent":
            return parent.layer.open(data);
        default :
            return layer.open(data);
    }
}

/**
 * @todo 数据提交
 * @tips 包含3种提交形式（原生HTML提交 JS-AJAX XHR提交 JQ-AJAX提交）
 * @param value -> 需要提交的必要参数
 * @param data -> layui返回的函数参数
 * @param param -> 传递参数
 * @return boolean value参数不正确 -> false{}
 */
function subUp(value, data, param) {
    //value：提交参数 data：submit函数中默认的参数(可选，当data不存在时将自动获取表单数据) param:可用参数
    //判断数据有效性
    if (doJudg({
        "undefined": [value.url]
    })) {
        putMsg({
            alert: "数据传输URL未填写！",
            error: "参数填写不正确，程序无法继续进行！请检查（487行）传递的参数中的第一项（0）中是否含有URL",
            log: arguments
        });
        return false;
    }
    //添加加载动画
    var loadIndex = putMsg("loadOn");
    $(".layui-layer-shade").css("opacity","0.05");
    $(".layui-layer-loading").append(
        $("<p>").css({"margin":"15px -55px","font-size":"2em","font-weight":"600","letter-spacing":"3px","color":"#787878"}).text("请求发送中")
    );
    //判断是否需要半自动获取表单数据(根据input的name属性自动获取所有的数据)
    var dataP = {}, valus = "";
    if (Type(value.data) === "array") {
        //dataP 提交的数据 valus 填写的表单name值
        dataP = getFormValue(value.data);
        //向data中直接添加附加数据
        if (value.add) {
            for (var names in value.add) {
                if (value.add.hasOwnProperty(names)) {
                    dataP[names] = value.add[names];
                }
            }
        }
    } else if (Type(value.data) === "json") {
        dataP = value.data;
    }
    //获取自定义的参数并合并到 dataP 中
    if (value.param) {
        for (var na in value.param) {
            if (value.param.hasOwnProperty(na)) {
                dataP[value.param[na]] = param[na];
            }
        }
    }
    //判断当前数据上传类型(默认以JQajax提交)
    if (value['switch'] === "xhr") {
        //未进行完整测试，不建议使用
        //以原生JS形式异步提交数据(基本代码)
        // XMLHttpRequest 对象
        var xhr = new XMLHttpRequest();
        xhr.open(value.method || "GET", value.url, value.async || true);
        xhr.onload = function () {
            //关闭加载动画
            putMsg("loadOut");
            $(".layui-layer-shade").css("opacity","0");
            alert("上传完成!");
        };
        xhr.send(form);
    } else if (value['switch'] === "html") {//以HTML默认的方式提交数据
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
        //关闭加载动画
        putMsg("loadOut");
        $(".layui-layer-shade").css("opacity","0");
        alert("提交成功！");
        window.location.reload();
    } else {
        //以$ajax形式提交数据(默认)
        //以参数形式调用获取的数据解决异步数据不可外部调用与修改
        var ajaxOptions = {
            success: function (data) {
                //如果参数中没有给出默认成功函数则只判断是否传输成功，其他数据的解析将通过参数中的done内函数完成
                if (data.code === 0) {
                        layer.alert("请求发送成功！", {icon: 1}, function (id) {
                            if (value.reload) {
                                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                                //自定义事件
                                if(value.sureDo){
                                    value.sureDo();
                                }
                                //当reload = truthy 时 判断reload等于 "parent"父级重载 否则本级重载
                                if(value.reload === "parent"){
                                    if(value.shutWin){
                                        parent.layer.close(index);
                                    }
                                    parent.location.reload()
                                } else{
                                    window.location.reload();
                                }
                            }else if(value.shutWin) {
                                parent.layer.close(index);
                            }else{
                                layer.close(id);
                            }
                        })
                } else {
                    putMsg({
                        alert: data.msg || "提交失败，请重试！",
                        error: "数据返回异常",
                        log: data
                    });
                }
                //提交成功后执行（不论返回数据是否正确）
                value.done && value.done(data);
            },
            error: function (er) {
                putMsg({
                    alert: "提交失败，请重试！",
                    error: "数据提交异常,错误信息为（subUp函数）",
                    log: er.responseJSON
                });
                putMsg({
                    error: "错误的提交数据为（subUp函数）:",
                    log: dataP || value.data
                });
                //提交失败后执行函数
                value.fine && value.fine(er);
            },
            complete:function(){
                //关闭加载动画
                putMsg("loadOut");
                $(".layui-layer-shade").css("opacity","0");
            }
        };
        //将AJAX数据同步化
        var backData = function (callback) {
            //合并数据
            compareData(value, ajaxOptions);
            //判断若以JSON形式发送则格式化数据
            if (value.contentType === "application/json") {
                dataP = JSON.stringify(dataP);
            }
            //数据回填
            value.data = dataP || value.data;
            //强制同步提交(同步可能导致部分页面遮罩无效，故默认改为异步)
            /*if(!value.async){
                value.async = false;
            }*/
            //提交数据
            $.ajax(value);
        };
        backData(value.success);
    }
}

//获取表格数据并且清空LAYUI自动添加的数据
function getTableValue(name, inClear) {
    //oData 初始表格数据 clear 初始清除参数集合
    var oData = [], clear = ["LAY_CHECKED", "LAY_TABLE_INDEX"];
    layui.use("table", function () {
        var table = layui.table;
        //获取表格缓存中的数据
        oData = table.cache[name];
        //判断是否需要清除不需要的参数
        if (inClear === false) {
            clear = [];
        } else if (Type(inClear) === "array") {
            if (inClear[0] === true) {
                inClear.splice(0, 1);//删除标识符 true
                clear = clear.concat(inClear);
            } else {
                clear = inClear;
            }
        } else if (Type(inClear) === "string") {
            clear = [inClear];
        }
        //当clear长度不为0时则执行清除参数操作
        if (clear.length !== 0) {
            for (var j = 0; j < oData.length; j++) {
                for (var x = 0; x < clear.length; x++) {
                    if (oData[clear[x]] !== undefined) {
                        delete oData[i][[clear[x]]]
                    }
                }
            }
        }
    });
    //返回表格数据
    return oData;
}

//获取给定name的表单数据
//返回JSON
function getFormValue(name,res,force,must){
    var data = res || {};
    //遍历所有的name
    for(var c=0;c<name.length;c++){
        var inputValue = $("input[type=text][name=" + name[c] + "]").val()
            ,selectValue = $("select[name=" + name[c] + "]").val()
            ,hideValue = $("input[type=hidden][name=" + name[c] + "]").val()
            ,textareaValue = $("textarea[name=" + name[c] + "]").val()
            ,radioValue = $("input[type=radio][name=" + name[c] + "]:checked").val()
            ,checkBox = $("input[type=checkbox][name=" + name[c] + "]:checked")
            ,checkBoxValue = checkBox.val();

        //只匹配首先获取到的name抛弃后匹配成功的，
        //如强制匹配（第二参数为true）则未匹配成功则会使用其他匹配上的DOM的值
        if (inputValue) {
            data[name[c]] = inputValue;
        } else if (selectValue) {
            data[name[c]] = selectValue;
        } else if (hideValue) {
            data[name[c]] = hideValue;
        } else if (textareaValue) {
            data[name[c]] = textareaValue;
        } else if (radioValue) {
            data[name[c]] = radioValue;
        } else if (checkBoxValue) {
            if(checkBox.length>1){
                var str = [];
                checkBox.each(function(){
                    str.push($(this).val())
                });
                data[name[c]] = str;
            }else{
                data[name[c]] = checkBoxValue;
            }

        }else{
            if(force){
                data[name[c]] = $("*[name='"+name[c]+"']").val();
            }
            if(must){
                must["show"] && (data[name[c]] = must.show || null)
            }
        }
        //console.log(data);
    }
    return data;
}

//抽象出的简化判断，成立返回false 不成立则返回true
function judg(data, end, mod, con) {
    var da = null;
    for (var x = 0; x < data.length; x++) {
        //获取单个具体数据
        da = data[x];
        //判断需要判断数据的类型与格式
        if (con === "l") {
            da = da.length;
        } else if (Type(con) === "string" && da[con] !== undefined) {
            da = da[con];
        }
        //匹配运算符号
        switch (mod) {
            case "=":
                if (da === end) {
                    return false;
                }
                break;
            case "<":
                if (da < end) {
                    return false;
                }
                break;
            case ">":
                if (da > end) {
                    return false;
                }
                break;
            case "<=":
                if (da <= end) {
                    return false;
                }
                break;
            case ">=":
                if (da >= end) {
                    return false;
                }
                break;
            case "!=":
                if (da !== end) {
                    return false;
                }
                break;
            case "!":
                if (da === !end) {
                    return false;
                }
                break;
        }
    }
    //无成功匹配
    return true;
}

//判断数据是否符合要求合法（用于无法使用layui自带判断情况）
function doJudg(value) {
    //数据是否有效标志
    var ju = true;
    for (var name in value) {
        if (value.hasOwnProperty(name)) {
            //获取数据匹配参数
            switch (name) {
                case "undefined":
                    ju = judg(value[name], undefined, "=");
                    break;
                case 0:
                    ju = judg(value[name], 0, "=", "l");
                    break;
                case "00":
                    ju = judg(value[name], "", "=");
                    break;
            }
            //如果有一个匹配成功则会直接返回true，表示有不符合要求的
            if (!ju) {
                //是否显示报错信息 === true则显示，否则不显示
                value.truth && value.truth === true ? putMsg({
                    alert: "数据不合法！",
                    error: "参数不合法，未通过效验！",
                    log: value
                }) : "";
                //数据不合法
                return true;
            }
        }
    }
    //若全都未匹配则返回false，表示全都符合要求
    value['false'] && value['false']();
    return false;
}

/**
 * @todo 多函数调用
 * @tips 函数集合
 **/
action = func = {
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
                    if (oData[i].hasOwnProperty(titles)) {
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
                , filter = Type(value) !== "string" ? value.filter : value
                , yes = Type(value) !== "json" ? value.yes : "确定要跳转链接吗？"
                , no = Type(value) !== "json" ? value.no : "没有可以跳转的链接。";
            table.on('tool(' + filter + ')', function (obj) {
                var data = obj.data,
                    con = "";
                if (obj.event === "openLink") {
                    if (data.link) {
                        layer.confirm(yes, function (index) {
                            //链接拼接
                            con = data.link + "?";
                            if (Type(value.param) === "array") {
                                for (var g = 0; g < value.param.length; g++) {
                                    con += value.param[g] + "&";
                                }
                            } else {
                                con = data.link + "?" + value.param + "=" + data[value.param];
                            }
                            //弹出窗口
                            layOpen({
                                type: 2,
                                title: "详细",
                                content: con,
                                area: ["90%", "90%"]
                            });
                            layer.close(index);
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
        //数据类型判断
        if (Type(value) === "json") {
            cc(value);
        } else if (Type(value) === "array") {
            for (var i = 0; i < value.length; i++) {
                cc(value[i]);
            }
        } else {
            putMsg({
                msg: "操作执行失败！",
                log: value,
                error: "tableFunc参数填写错误"
            });
            return false;
        }

        //事件绑定函数
        function cc(vas) {
            layui.use('table', function () {
                var table = layui.table,
                    layer = layui.layer,
                    filt = vas.filter || "table1",
                    tool = vas.tool || "tool",
                    tableOn = tool + '(' + filt + ')',
                    baseUrl = vas.content,
                    showContent = "",
                    num =0,
                    openT = true;
                //绑定表格事件
                table.on(tableOn, function (obj) {
                    //排除多个数据源干扰，如toolbar有数据干扰问题，可移除外层限制if
                    //只有在点击表格内按钮时才执行事件
                    //获取当前点击按钮event
                    //只有在点击表格标题行按钮才执行事件
                    if (tool === "toolbar") {
                        //获取选中行数据
                        var checkStatus = table.checkStatus(obj.config.id || vas.tableId);//获取选中数据
                    }
                    var event = obj.event;
                    if (Type(value) === "json") {
                        if (event === value.event) {
                            vas = value;
                        }else{
                            return false;
                        }
                    } else if (Type(value) === "array") {
                        for (var x = 0; x < value.length; x++) {
                            if (event === value[x].event) {
                                vas = value[x];
                            }else{
                                num++;
                            }
                        }
                        if(num === value.length){
                            num = 0;
                            return false;
                        }
                    }
                    if(vas.send){
                        checkStatus && func.sendTo(vas.send,checkStatus,table);
                        return true;
                    }

                    //当无法正常获取URL的时候
                    //if (baseUrl === undefined && vas.content !== undefined) {
                        baseUrl = vas.content;
                    //}

                    //获得当前行数据
                    var data = obj.data;
                    //当存在dataUrl时则填充进URL参数中
                    if (vas.dataUrl && vas.dataUrl !== false) {
                        showContent = baseUrl + "?";
                        for (var i = 0; i < vas.dataUrl.length; i++) {
                            showContent += vas.dataUrl[i] + "=" + data[vas.dataUrl[i]] + "&";
                        }
                    }
                    //判断是否允许自定义layer窗口弹出
                    if (vas.layOpen !== undefined) openT = Boolean(vas.layOpen);
                    //弹出前执行函数
                    if(vas.before){
                        var nnf = vas.before(obj,checkStatus);
                        openT = (nnf !== false);
                    }
                    //创建一个新的副本（强制切断联系，避免修改原数据）
                    var newJ = "";
                    if(vas.type === 1){
                        newJ = vas
                    }else{
                        newJ = JSON.parse(JSON.stringify(vas))
                    }
                    //修改弹窗链接
                    if(showContent){
                        //console.log(1);
                        newJ.content = showContent;
                    }
                    //console.log("即将弹出",newJ);
                    if(vas.download === true){
                    	window.location = newJ.content;
                    	return;
                    }
                    //若允许弹出则弹出
                    openT && layOpen(newJ);
                    //若有函数则执行函数，传递参数 obj 表格缓存数据 checkStatus 所有已选中数据
                    vas.func && vas.func(obj, checkStatus);

                    //还原url
                    //vas.content = "";
                });
            });
        }
    },
    //添加表格编辑事件
    "tableEdit": function (value) {
        layui.use('table', function () {
            var table = layui.table;
            table.on('edit(' + value.filter + ')', function (obj) {
                var val = obj.value //得到修改后的值
                    , data = obj.data //得到所在行所有数据
                    , field = obj.field //得到字段对应的name
                    , uValue = obj.uValue//字段修改前的值（自定义JS，table.js重置后将失效）
                    , tips = value.tip || uValue;
                //是否提示信息
                if (value.confirm === false) {
                    value.func && value.func.call(this, val, uValue, obj);
                } else {
                    layer.confirm("确定将 " + tips + " 修改为：" + val + "吗？", function (index) {
                        //执行自定义函数
                        value.func && value.func(val, uValue, obj);
                        //关闭弹出的确认信息
                        layer.close(index);
                    }, function (index) {
                        //取消操作将重置已编辑的数据
                        //获取改变前的数据
                        data[field] = uValue;
                        //更新数据
                        obj.update(data);
                        //table.reload();
                    })
                }

            });
        })
    },
    //向表格中添加数据
    "reTable": function (value) {
        var name = value.name || "table", res = value.data, pp = false, hh = "200";
        layui.use('table', function () {
            var table = layui.table
                , oData = table.cache[name];//获取表格所有数据

            //未选择数据则不执行操作
            if (res.length === 0) {
                return false;
            }

            //若需覆盖原数据则不保留原数据，否则向后逐条追加数据
            if (value.cover === true) {
                oData = res;
            } else {
                if (oData.length === 0) {
                    for (var v = 0; v < res.length; v++) {
                        delParam(res[v]);
                        oData.push(res[v]);
                    }
                } else {
                    for (var i = 0; i < oData.length; i++) {
                        delParam(oData[i]);
                        compRes(oData[i], res);
                    }

                    for (var j = 0; j < res.length; j++) {
                        delParam(res[j]);
                        oData.push(res[j]);
                    }
                }
            }

            //数据对比函数
            function compRes(data, val) {
                //循环需要添加的数据
                for (var x = 0; x < val.length; x++) {
                    //删除不需要进行判断的参数
                    delParam(val[x]);
                    //获取数据字符串
                    var dd = JSON.stringify(data)
                        , vv = JSON.stringify(val[x]);
                    //当数据一样时，删除当前数据并且结束循环
                    if (dd === vv) {
                        val.splice(x, 1);
                        return true;
                    }
                }
            }

            //删除不需要进行判断的参数
            function delParam(data) {
                //默认将删除 LAY_CHECKED LAY_TABLE_INDEX
                !value.delVal && data["LAY_CHECKED"] && delete data["LAY_CHECKED"];
                !value.delVal && data["LAY_TABLE_INDEX"] && delete data["LAY_TABLE_INDEX"];
                //判断是否需要删除某个判断的元素（删除自定义参数）
                if (value.del !== undefined && Type(value.del) === "array") {
                    for (var cc = 0; cc < value.del.length; cc++) {
                        data[cc] && delete data[cc];
                    }
                }
            }

            //数据大于15条时显示分页按钮并拉高表格高度
            if (oData.length > 15) {
                pp = true;
                hh = "250"
            }

            //重新渲染表格
            table.reload(name, {
                data: oData,
                page: pp,
                height: hh
            });

            //信息提示
            /*if (res.length === 0) {
                layer.msg("重复数据无法添加！");
            }*/

            layer.msg("已成功添加" + res.length + "条新数据！");
        });
    },
    //表格外获取选中数据并删除选中数据(只修改本地数据)
    "checkTable": function (name) {
        layui.use('table', function () {
            var table = layui.table
                , oData = table.cache[name];//获取表格所有数据
            var ck = table.checkStatus(name);//获取选中数据
            if (ck.data.length === 0) {
                putMsg({
                    alert: "当前未选中任何数据！"
                });
                return false;
            }
            layer.confirm("确定要删除这" + ck.data.length + "条数据吗？", function (index) {
                if (ck.isAll === true) {
                    oData = [];
                } else {
                    for (var j = 0; j < oData.length; j++) {
                        //找出所有数据中的已选中数据并删除
                        if (oData[j].LAY_CHECKED === true) {
                            oData.splice(j, 1);
                        } else {
                            delete oData[j]["LAY_CHECKED"];
                            delete oData[j]["LAY_TABLE_INDEX"];
                        }
                    }
                }
                //重新渲染表格
                table.reload(name, {
                    data: oData
                });
                layer.close(index);
            });

        });
    },
    //表格外获取选中数据并删除选中数据（可提交数据）
    "delTable": function (value) {
        layui.use('table', function () {
            var table = layui.table;
            table.on("tool(" + value.filter + ")", function (obj) {
                var ck = table.checkStatus(value.id || obj.config.id );//获取已选中数据
                //console.log("======normalBegin=====",value);
                //按钮匹配
                if (obj.event === value.event) {
                    func.sendTo(value,ck,table);
                }
            });
        });
    },
    "sendTo":function (value,ck,table) {
        var tempData =[],loc = true,oData = table.cache[value.id];
            if (ck.data.length === 0) {
                putMsg({
                    alert: "请选择至少一条数据！"
                });
                return false;
            }
            //上传数据定义
            value.data = {};
            //获取表格中的某一个值组成一个数组
            if(value.par){
                for(var t=0;t<ck.data.length;t++){
                    tempData.push(String(ck.data[t][value.par]));
                }
                value.data[value.name] = tempData;
            }else{
                value.data[value.name] = ck.data;
            }
            //其他需要扩充的数据
            if (value.adds !== undefined) {
                //console.log("adds = ",value.add);
                if(Type(value.adds) === "json"){
                    for (var name in value.adds) {
                        if (value.adds.hasOwnProperty(name)) {
                            value.data[name] = value.adds[name]
                        }
                    }
                }else if(Type(value.adds) === "array"){
                    value.data = getFormValue(value.adds,value.data);
                }
            }
            //console.log("拼接完成：",value.data);
            //强制以JSON格式发送数据
            value.contentType = "application/json";
            //提交成功回调函数
            value.success = function (res) {
                if (res.code === 0) {

                    //判断是否重新渲染表格
                    value.reTable && table.reload(name, {
                        data: res.data
                    });
                    //判断是否需要重新渲染表格数据
                    !loc && table.reload(name, {
                        data: oData
                    });

                    layer.alert("操作成功！",function (index) {
                        //判断是否刷新页面
                        value.reload && window.location.reload();
                        layer.close(index);
                    });
                } else {
                    layer.alert("删除失败！",function(){
                        location.reload();
                    });
                }

            };
            //判断是否为删除数据
            if (value.confirm === false) {
                //不删除数据则直接发送数据
                subUp(value)
            } else {
                var showMsg = "确定要删除这" + ck.data.length + "条数据吗？";
                if(value.show && Type(value.show) === "string"){
                    showMsg = value.show;
                } else if(Type(value.show) === "array"){
                    showMsg = value.show[0]+ ck.data.length + value.show[1];
                }
                layer.confirm(showMsg, function (index) {
                    loc=false;
                    //上传已删除文件
                    subUp(value);
                    //获取除去要删除的数据后的数据
                    if(!value.del || value.del === true ){
                        if (ck.isAll === true) {
                            oData = [];
                        } else {
                            for (var j = 0; j < oData.length; j++) {
                                //找出所有数据中的已选中数据并删除
                                if (oData[j].LAY_CHECKED === true) {
                                    oData.splice(j, 1);
                                } else {
                                    delete oData[j]["LAY_CHECKED"];
                                    delete oData[j]["LAY_TABLE_INDEX"];
                                }
                            }
                        }
                    }
                });
            }
    }
};

//表格函数调用函数函数
function tableFunc(fn) {
    if (Type(fn) === "json") {
        var obj = fn.obj || this;
        for (var name in fn) {
            if (fn.hasOwnProperty(name)) {
                if (func[name]) {
                    func[name].call(obj, fn[name]);
                } else {
                    switch (name) {
                        case "btn":
                        case "tools":
                            func["toolFunc"].call(obj, fn["tools"]);
                            break;
                        case "subTable":
                        case "subs":
                            func["delTable"].call(obj, fn["subs"]);
                            break;
                    }
                }
            }
        }
    } else {
        putMsg({
            msg: "系统错误！",
            error: "tableFunc参数填写错误",
            log: arguments
        });
    }
}

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

function changeTab(ele, callback) {
    //ele:{title:"",id:"",url:""}
    layui.use(['element'], function () {
        var element = layui.element;
        if(ele.top){
            parent.layui.element.tabAdd('tab', {
                title: ele.title,
                content: '<iframe src="' + ele.url + '" name="iframe' + ele.id + '" class="iframe" framborder="0" data-id="' + ele.id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
                id: ele.id
            });
            parent.layui.element.tabChange('tab', ele.id);
        }else{
            element.tabAdd('tab', {
                title: ele.title,
                content: '<iframe src="' + ele.url + '" name="iframe' + ele.id + '" class="iframe" framborder="0" data-id="' + ele.id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
                id: ele.id
            });
            //console.log(ele);
            element.tabChange('tab', ele.id);
        }
        callback ? callback() : null;
    })//layui element规定用法，当主列表项无子列表时选中第一个列表项
}//打开一个新的TAB标签页，并切换至此标签页、选中相应列表项（回调函数实现）

/**
 * @todo 动态添加JS
 * @tips 动态添加页面渲染所必须的基础函数<顺序不能更改>
 * @arguments
 * @return
 */

//必要JS layui插件支持
document.write("<script type='text/javascript' data-version='x2' src='/static/admin/layui/layui.js'></script>");
//必要JS 表格表单及其他相关事件渲染支持
document.write("<script type='text/javascript' data-version='x2' src='/static/admin/js/renderMod.js'></script>");
//必要CSS fontAwesome插件支持
document.write("<link rel=\"stylesheet\" href=\"/static/admin/css/all.min.css\"/>");


window.onload = function () {
    //填充页面URL，便于调试页面
    // $("body").prepend($("<p>").css({
    //     "position": "absolute",
    //     "right": "0",
    //     "color": "#f10214",
    //     "border": "1px solid",
    //     "opacity": "0.4",
    //     "padding": "5px",
    //     "z-index": "99999"
    // }).html("当前页面地址：" + window.location.href).on("click", function () {
    //     $(this).remove()/*if(confirm("删除此内容？")){$(this).remove()}*/
    // }));
    //手机版 数据查找 按钮功能绑定
    var $dataSearch = $("a[lay-event='dataSearch']");
    if ($dataSearch.length > 0) {
        $dataSearch.on('click', function () {
            layOpen({
                title: "数据查找",
                content: $("#hideXs")
            });
            return false;
        })
    }
};
