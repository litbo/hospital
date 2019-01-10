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
    renderMod = {};
/**
 * @todo 表格多函数调用
 * @tips 表格函数集合
 **/
/*var func = {//this = obj
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
};*/

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
 * @todo 页面加载效果遮罩
 * @arguments text -> 提示文字
 *            time -> 遮罩自动结束时间
 * @return
 **/
function markPage(text, time) {
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
 * @todo 数据提交
 * @tips 包含3种提交形式（原生HTML提交 JS-AJAX XHR提交 JQ-AJAX提交）
 * @arguments value -> 需要提交的必要参数
 *            data -> layui返回的函数参数
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
                alert("提交失败，请重试！");
                console.log(er);
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
 * @todo 数据合并（JSON）
 * @tips 合并两个数据不一样之处，将y中x没有的项添加进x中（X为主）
 * @arguments x -> 主数据
 *            y -> 基础数据(用于比较的数据)
 * @return {Object} -> x*
 */
function compereData(x, y) {
    for (var name in y) {
        if(y.hasOwnProperty(name)){
            if (!x[name]) {
                x[name] = y[name];
            }
        }
    }
}

/**
 * @todo 本地存储-cookie
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
 * @todo 本地存储-session
 * @tips 动态添加页面渲染所必须的基础函数<顺序不能更改>
 * @arguments title -> 操作的session名
 *            url -> 操作的session所在的链接search信息
 *            id -> 操作的session对应的导航ID
 * @return {string} -> 读取的session
 */
//
document.write("<script type='text/javascript' data-version='x2' src='" + window.location.origin + "/static/admin/layui/layui.js'></script>");
document.write("<script type='text/javascript' data-version='x2' src='" + window.location.origin + "/static/admin/js/renderMod.js'></script>");
