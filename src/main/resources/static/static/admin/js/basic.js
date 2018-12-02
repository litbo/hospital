/*
* basic.js 页面的基本函数集合,放置于页面顶部，JQ下方
* */

//获取当前页面的URL属性值，接收参数name：属性名，如果有对应属性值则返回属性值否则返回 null

    (function ($) {
        $.getUrlParam = function (name,site) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"),r = window.location.search.substr(1).match(reg);
            if(site === 1){
                r = window.parent.location.search.substr(1).match(reg)
            }
            if (r != null) return decodeURI(r[2]);
            return null;
        };
    })(jQuery);

    //为表格页面添加message提示信息
    function addTableMessage(num,obj){
        if(num < 0){
            return ;
        }
        var oData = obj.data;
        $("td:nth-child("+num+")").mouseover(function (e) {
            for (var i = 0; i < oData.length; i++) {
                if (oData[i].messages) {
                    for (var titles in oData[i]) {
                        if (oData[i][titles] === $(this).text()) {//确保当前的单元值与捕获的数据中的值对应，避免对应错误
                            $("#tips").html("");
                            for (var j = 0; j < oData[i].messages.length; j++) {
                                $("#tips").append("<p>\n" +
                                    "        <span class=\"tip_title\">" + oData[i].messages[j].name + "</span>：<span class=\"tip_conts\">" + oData[i].messages[j].value + "</span>\n" +
                                    "    </p>")
                            }
                            e = e || window.event;
                            _x = e.pageX || e.clientX + document.body.scroolLeft;
                            _y = e.pageY || e.clientY + document.body.scrollTop;
                            $("#tips").css("left",_x+'px').css("top",_y+'px').fadeIn(500);
                            $(this).mouseleave(function(){
                                $("#tips").fadeOut(100);
                            })
                        }
                    }
                }

            }
        })
    }


jQuery.cookie = function (name, value, options) {
    if (typeof value != 'undefined') {
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
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
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
}



