/*
* basic.js 页面的基本函数集合,放置于页面顶部，且必须位于JQuery.js之后
* */
/**
 *@todo 获取URL中的参数的值
 **/
//获取当前页面的URL属性值，接收参数name：属性名，如果有对应属性值则返回属性值否则返回 null
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
 *@todo 页面加载遮罩
 **/
//页面加载遮罩
function markPage(text, time) {
    //如果页面中不存在定位元素则创建定位元素
    if (!($(".begin").length > 0)) {
        $("body").prepend($("<div>").attr("class", "begin"))
    }
    var timer = null;
    text = text || "页面急速加载中!";//遮罩提示文本
    time = Number(time) || 3000;//遮罩显示时间
    //渲染页面遮罩样式
    $(".begin").append($("<div>").attr("class", "main-mask").css({"display": "block", "background": "rgba(0,0,0,0.6)"})
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

//4：判断对象数据类型
/**
 *@todo 数据类型判断
 * 以小写字符串形式返回
 * @return {string}
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

//数据提交函数，包含3种提交形式（原生HTML提交 JS-AJAX XHR提交 JQ-AJAX提交）
/**
 * @return {boolean}
 */
function subUp(value,data) {
    //value：提交参数 data：submit函数中默认的参数(可选，当data不存在时将自动获取表单数据)
    //判断必填项是否为空
    if (!value.data || !value.url) {
        return false;
    }
    //判断是否需要自动获取表单数据(根据input的name属性自动获取所有的数据)
    if (Type(value.data) === "array") {
        var dataP = {};
        for (var i = 0; i < value.data.length; i++) {
            if(!data){
                dataP.value.data[i] = $("input[name=" + value.data[i] + "]").val();
            }else{
                dataP.value.data[i] = data.field[value.data[i]];
            }

        }
    }
    //判断当前数据上传类型(默认以JQajax提交)
    if (value.switch === "xhr") {//以原生JS形式异步提交数据(基本代码)
        if (value.data.file) {//！！！！！代码未完善！！！！！
            var formData = new FormData();
            formData.append(value.data.name, $(value.data.file)[0].files[0]);
            //console.log(formData);
            // XMLHttpRequest 对象
            var xhr = new XMLHttpRequest();
            xhr.open(value.method || "GET", value.url, value.async || true);
            xhr.onload = function () {
                alert("上传完成!");
            };
            xhr.send(form);
        }
    } else if (value.switch === "html") {//以HTML默认的方式提交数据
        //使用HTML默认提交方式提交数据（使用新建内嵌框架实现不跳转新页面）
        //使用不可见iframe获取返回数据，但由于未知原因(暂未知)无法获取iframe内返回的数据，故目前只能提交则成功
        //form标签无需添加method和url，只需在数据中填写则可以自动渲染
        var frameName = "framesXXX";
        $("body").append($("<iframe>").attr({
            "name": frameName,
            "style": "display:none;width:1px;height:1px;",
            "id": "framesX"
        }));
        var $form = $("#form");
        $form.attr({"method": value.method || "GET", "action": value.url, "target": value.target || frameName});
        $form[0].submit();
        alert("提交成功！");
        window.location.reload();
    } else {//以ajax形式提交数据(默认)
        //以参数形式调用获取的数据解决异步数据不可外部调用与修改
        var backData = function (callback) {
            $.ajax({
                url: value.url,
                cache: value.cache || true,
                method: value.method || "GET",
                data: dataP || value.data,
                processData: value.processData || true,
                contentType: value.contentType,
                success: callback || function (data) {
                    //如果参数中没有给出默认成功函数则只判断是否传输成功，其他数据的解析将通过参数中的done内函数完成
                    if (data.code === 0) {
                        alert("提交成功！");
                    } else if (data.code === 1) {
                        alert("提交失败，请重试！");
                    }
                    value.done || value.done()
                }, error: function (er) {
                    alert("提交失败，请重试！");
                    console.log(er);
                }
            })
        };
        backData(value.success);
    }
}

//合并两个数据不一样之处，将y中x没有的项添加进x中（X为主）
function compereData(x, y) {
    for (var name in y) {
        if (!x[name]) {
            x[name] = y[name];
        }
    }
}

/**
 *@todo 当前时间计算
 **/
//计算当前时间
var date = new Date()
    , year = date.getFullYear()
    , month = date.getMonth() + 1
    , day = date.getDate()
    , today = year + "-" + month + "-" + day//获取年-月-日
    , time = date.getTime();

//初始化页面渲染数据
var renderMod = {};
/**
 *@todo 本地存储 sessionStorage cookie 操作
 **/
//cookies操作函数
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
    var curMenu = sessionStorage.getItem('curMenu');
    var text = $('.layui-tab-title').find('.layui-this').text();
    text = text.split('ဆ')[0];
    if (text === "系统主页") {
        return;
    }
    var url = $('.layui-tab-content').find('.layui-show').find('.weIframe').attr('src');
    var id = $('.layui-tab-title').find('.layui-this').attr('lay-id');
    curMenu = {
        title: text,
        url: url,
        id: id,
        search: $.getUrlParam('p')
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
 *@todo 表格多函数调用
 **/
//表格调用函数集合
var func = {//this = obj
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
            if ($("#h_tips").length <= 0) {
                $("body").append($("<div>").attr("id", "h_tips"))
            }
            for (var i = 0; i < oData.length; i++) {
                for (var titles in oData[i]) {
                    if (oData[i][titles] === $(this).text()) {//确保当前的单元值与捕获的数据中的值对应，避免对应错误
                        $("#h_tips").html("");
                        try {
                            for (var j = 0; j < oData[i].messages.length; j++) {
                                $("#h_tips").append("<p>\n" +
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
                        $("#h_tips").css("left", _x + 'px').css("top", _y + 'px').fadeIn(timeIn);
                        $(this).mouseleave(function () {
                            $("#h_tips").fadeOut(timeOut).remove();
                        });
                        break;
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
                    var data = obj.data;//获得当前行数据
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
                var data = obj.data;//获得当前行数据
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
};
//表格函数调用函数函数
function tableFunc() {
    if (Type(arguments) === "json") {
        var obj = arguments[0].obj;
        for (var name in arguments[0]) {
            if (func[name]) {
                func[name].call(obj, arguments[0][name]);
                console.log(name + " 已加载！");
            }
        }
    } else {
        console.error("tableFunc参数填写错误")
    }
}



/*require.config({
    baseUrl: window.location.origin,
    paths: {
        "render": "/hospital/static/admin/js/renderMod.js"
    }
    <script src="../../static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
});*/

    document.write("<script type='text/javascript' data-version='x2' src='"+window.location.origin+"/static/admin/layui/layui.js'></script>");
    document.write("<script type='text/javascript' data-version='x2' src='"+window.location.origin+"/static/admin/js/renderMod.js'></script>");


/*
$(function(){
    beginRender();
})*/



/*
function loadJs(file){
    var scriptTag = document.getElementById('loadScript');
    var head = document.getElementsByTagName('head').item(0);
    if(scriptTag) head.removeChild(scriptTag);
    script = document.createElement('script');
    script.src = window.location.origin+file+".js";
    script.type = 'text/javascript';
    script.id = 'loadScript';
    head.appendChild(script);
}

loadJs("/hospital/static/admin/js/renderMod");*/
