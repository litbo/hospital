/*
* 本文件作为存档与对照，实际中并未使用，单功能上与nav.js并无区别
* */

(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURI(r[2]);
        return null;
    };
})(jQuery);//获取当前页面的URL属性值，接收参数name：属性名，如果有对应属性值则返回属性值否则返回 null

var $mainList = $("#main_nav_list")
    ,$viceList = $(".cts2")
    ,$mapSite = $('.map_site')
    ,$navList = $(".menus_con")
    ,n = $.getUrlParam('n')//获取URL地址中的 n 属性值，表示副列表的列表项 t 下的第 n 个子列表
    ,t = $.getUrlParam('t')//获取URL地址中的 t 属性值，表示副列表的列表项t下
    ,p = $.getUrlParam('p')//获取URL地址中的 p 属性值，表示当前页面的名称
    ,nN = Number(n)//将string类型的 n 转变为number类型
    ,tN = Number(t);//将string类型的 t 转变为number类型

$(function () {
    addList($mainList,$viceList);
    addNav($navList);
});//页面创建完成动态加载数据


function addList(list,list1) {//list:包含主列表的容器 list1:包含副列表的容器
    var location = window.location.origin + window.location.pathname;//获取当前页面不包含任何属性值的根地址（例：http://www.XXX.com/index.html）
    function addSample(a) {//a:main_list[x] （x>=0） 或 main_list[x].tools[y].content[z]
        if (a.items) {//判断是否为 返回首页 列表项（x=0？）
            for (var i = 0; i < a.items.length; i++) {
                addPage(a.items[i]);
            }//遍历items中所有项，并写入list中
            var d = a.items[0];//选中第一个
            if (!d.list) {
                layui.use(['element'], function () {
                    var element = layui.element;
                    element.tabAdd('tab', {
                        title: d.title,
                        content: '<iframe src="' + d.url + '" name="iframe' + d.id + '" class="iframe" framborder="0" data-id="' + d.id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
                        id: d.id
                    });
                    element.tabChange('tab', d.id);
                    $('.layui-nav-item').eq(1).addClass('layui-this');
                })//layui element规定用法，当主列表项无子列表时选中第一个列表项
            } else {
                layui.use(['element'], function () {
                    var element = layui.element;
                    element.tabAdd('tab', {
                        title: d.list[0].title,
                        content: '<iframe src="' + d.list[0].url + '" name="iframe' + d.list[0].id + '" class="iframe" framborder="0" data-id="' + d.list[0].id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
                        id: d.list[0].id
                    });
                    element.tabChange('tab', d.list[0].id);
                    $('.layui-nav-child').children(':first').addClass('layui-this');
                });//layui element规定用法，当主列表项有子列表时选中第一个列表项的第一个子列表项
            }//默认打开一个新的TAB标签页，并切换至此标签页、选中相应列表项
        } else {
            addPage(a);
        }
    }//判断当前页面是否是首页,新建并切换TAB标签页
    function addPage(a) {//a:main_list[0] 或 main_list[x].items[i] (x>1)
        var small_list = "";
        if (a.list) {//如果存在main_list[x]list
            for (var j = 0; j < a.list.length; j++) {
                small_list += "<dd shiro:hasPermission name=\"" + a.list[j].shiro + "\"><a href=\"javascript:;\" data-url=\"" + a.list[j].url + "\" data-id='" + a.list[j].id + "' data-text=\"" + a.list[j].title + "\"><span class=\"l-line\"></span>" + a.list[j].title + "</a></dd>\n";
            }
            // 当li标签添加了class--》 layui-nav-itemed  《--后列表将默认展开，否则将默认不展开
            list.append("<li class=\"layui-nav-item\" shiro:hasPermission name=\"" + a.shiro + "\">\n" + "<a href=\"javascript:void(0);\"><i class=\"fas fa-" + a.icon + "\"></i>" + a.title + "</a>\n" + "<dl class=\"layui-nav-child\">\n" + small_list + "</dl>\n" + "</li>");
        } else {
            list.append("<li class=\"layui-nav-item\" shiro:hasPermission name=\"" + a.shiro + "\">\n" + "<a href=\"javascript:;\" data-url=\"" + a.url + "\" data-id='" + a.id + "' data-text=\"" + a.title + "\"><i class=\"fas fa-" + a.icon + "\"></i>" + a.title + "</a>\n" + "</li>");
        }
    }//在list中动态添加主列表项
    function addTools(a, x) {//a：包含副列表的容器 $(“#body”) x:当前列表项 main_list[x]
        var sList = "";
        for (var i = 0; i < x.tools.length; i++) {
            if (x.tools[i].content) {//当副列表的列表项存在时才会将列表项添加进a中，否则无意义
                sList = "";//清空上一次遍历的子列表项，避免数据冗杂
                var sUrl = "";
                var sTarget = "";
                for (var j = 0; j < x.tools[i].content.length; j++) {
                    if(/[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\.?/.test(x.tools[i].content[j].url)){
                        sUrl = x.tools[i].content[j].url;
                        sTarget = "target='_blank'";
                    }else{
                        sUrl = "?p=" + x.tools[i].content[j].url;
                        sTarget = "";
                    }
                    sList += "<li shiro:hasPermission name=\"" + x.tools[i].content[j].shiro + "\">\n" + "<a href=\"" + sUrl + "\" class='tools_li' data-id='" + x.tools[i].content[j].id + "' data-url='" + sUrl + "' data-name='" + x.tools[i].content[j].title + "' " + sTarget +">" + x.tools[i].content[j].title + "</a>\n" + "</li>";
                }
                a.append("<li shiro:hasPermission name=\"" + x.tools[i].shiro + "\">\n" + "<a href=\"javascript:void(0);\">\n" + "<i class=\"fas fa-" + x.tools[i].icon + "\"></i>\n" + "<p class=\"tools_title\">" + x.tools[i].title + "</p>\n" + "</a>\n" + "<ul class=\"min_tools\">\n" + sList + "</ul>\n" + "</li>");
            }
        }//循环遍历 x 中的所有副列表
    }//在a中动态添加副列表
    for (var x = 1; x < main_list.length; x++) {//遍历除首页的所有页面数的JSON
        if (p !== null) {//判断页面中是否有P属性值，该属性对应main_list中的page值，页面必须有p属性值才可以正常跳转
            if (p === main_list[x].page) {//只有当前页面的URL中的p属性的属性值与数据中的page属性相同时才会动态向页面中写入列表项
                if (n === null && t === null) {// 当URL中无 t 与 n 属性时执行
                    if (main_list[x].items.length === 0 && main_list[x].tools.length !== 0) {
                        //无默认导航列表并且有工具列表，则使用工具列表第一个对应的导航列表为默认导航列表
                        addTools(list1, main_list[x]);//添加工具列表
                        addSample(main_list[x].tools[0].content[0]);//设定默认导航列表
                    } else if (main_list[x].items.length !== 0 && main_list[x].tools.length === 0) {
                        //有默认导航列表并且无工具列表，则不渲染工具列表
                        addSample(main_list[x]);//添加默认导航列表
                    } else if (main_list[x].items.length !== 0 && main_list[x].tools.length !== 0) {
                        //有默认导航列表并且有工具列表，则渲染导航列表并且添加工具
                        addTools(list1, main_list[x]);//添加工具列表
                        addSample(main_list[x]);//添加默认导航列表
                    }
                    addMaps($mapSite,x);
                } else if (n === null || t === null) {// 当URL中无 t 或 n 属性时返回当前页面的默认页
                    window.location.href = location + "?p=" + p;
                } else if (nN < main_list[x].tools[tN].content.length && tN < main_list[x].tools.length) {//当有 n 与 t 时动态加载相应的数据
                    addTools(list1, main_list[x]);
                    addSample(main_list[x].tools[tN].content[nN]);
                    addMaps($mapSite,x);
                } else {//当出现未知可能性时直接跳转默认页面，例如：当 n 与 t 与数据实际情况不符合时，打开默认的页面
                    window.location.href = location + "?p=" + p;
                }


            } else {//当URL中的p属性无法与当前列表中的数据相匹配时
                var onThis = true;//当前页面URL值与JSON中PAGE值是否有对应
                for (var j = 1; j < main_list.length; j++) {//循环判断所有的数据
                    if (p === main_list[j].page) {//当有对应时则返回true并且结束循环，否则返回false并继续循环直至循环结束
                        onThis = true;
                        break;
                    } else {
                        onThis = false;
                    }
                }
                if (!onThis) {
                    window.location.href = location + "?p=home";
                }//p属性的值与所有页面对应的名称均不匹配时默认直接跳转首页
            }
        } else {//URL中无p属性时默认直接载入首页
            for (var c = 0; main_list[1].items.length > c; c++) {
                addSample(main_list[1].items[c]);
            }
            break;
        }
    }
}//动态的向页面中添加列表

function addMaps(con,x) {//con:包含位置地图的容器名 x:当前页面的序号
    var location = window.location.origin + window.location.pathname;//获取当前页面不包含任何属性值的根地址（例：http://www.XXX.com/index.html）
    for(var i=0;i<nav_list.length;i++){//遍历nav_list
        if(p === nav_list[i].page){//只有当URL中的P属性找到对应的数据时才添加位置地图
            con.html("");
            if(n !== null && t !== null){
                con.append("位置：<a href=\""+location+"?p="+p+"\" class=\"map_prev\">"+nav_list[i].title+"</a>&nbsp;&gt;&nbsp;<span>"+main_list[x].tools[tN].content[nN].title+"</span>\n")
            }else{
                con.append("位置：<a href=\""+location+"?p=home"+"\" class=\"map_prev\">首页</a>&nbsp;&gt;&nbsp;<span>"+nav_list[i].title+"</span>\n")
            }
        }
    }
}//通过nav_list匹配页面的名称

function addNav(con){//con包含导航菜单的容器名
    for(var i=0;i<nav_list.length;i++){
        con.append("<div class=\"menu-btn\">\n" + "<a href=\"?p="+nav_list[i].page+"\">\n" + "<i class=\""+nav_list[i].icon+"\"></i>\n" + "<p class=\"menu-tit\">"+nav_list[i].title+"</p>\n" + "</a>\n" + "</div>")
    }
}//通过nav_list向页面中添加顶部导航列表