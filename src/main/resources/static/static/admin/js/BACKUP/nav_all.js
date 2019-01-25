var $mainList = $("#main_nav_list")
    , $viceList = $(".cts2")
    , $mapSite = $('.map_site')
    , $navList = $(".menus_con")
    , n = $.getUrlParam('n')//获取URL地址中的 n 属性值，表示副列表的列表项 t 下的第 n 个子列表
    , t = $.getUrlParam('t')//获取URL地址中的 t 属性值，表示副列表的列表项t下
    , p = $.getUrlParam('p')//获取URL地址中的 p 属性值，表示当前页面的名称
    , nN = Number(n)//将string类型的 n 转变为number类型
    , tN = Number(t);//将string类型的 t 转变为number类型

$(function () {
    addList($mainList, $viceList);
    addNav($navList);
});//页面创建完成动态加载数据


function addList(list, list1) {//list:包含主列表的容器 list1:包含副列表的容器
    var location = window.location.origin + window.location.pathname;//获取当前页面不包含任何属性值的根地址（例：http://www.XXX.com/index.html）
    function changeTab(ele,callback){
        layui.use(['element'], function () {
            var element = layui.element;
            element.tabAdd('tab', {
                title: ele.title,
                content: '<iframe src="' +ele.url + '" name="iframe' + ele.id + '" class="iframe" framborder="0" data-id="' + ele.id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
                id: ele.id
            });
            element.tabChange('tab', ele.id);
            callback ? callback() : null;
        })//layui element规定用法，当主列表项无子列表时选中第一个列表项
    }
    function addSample(a) {//a:main_list[x] （x>=0） 或 main_list[x].tools[y].content[z]
        if (a.items) {//判断是否为 返回首页 列表项（x=0？）
            for (var i = 0; i < a.items.length; i++) {
                addPage(a.items[i]);
            }//遍历items中所有项，并写入list中
            if(p !== "home"){//首页不打开新TAB
                var d = a.items[0];//选中第一个副列表的第一个子列表项
                if (!d.list) {
                    changeTab(d,function(){
                        $('.layui-nav-item').eq(1).addClass('layui-this');//子列表添加展开后效果
                    })
                } else {
                    changeTab(d.list[0],function(){
                        $('.layui-nav-child').children(':first').addClass('layui-this');//子列表添加展开后效果
                    })
                }//默认打开一个新的TAB标签页，并切换至此标签页、选中相应列表项
            }

        } else {
            addPage(a);
        }
    }//判断当前页面是否是首页,新建并切换TAB标签页
    function addPage(a) {//a:main_list[0] 或 main_list[x].items[i] (x>1)
        var small_list = "";
        if (a.list) {//如果存在main_list[x]list
            var $dl = $("<dl>").attr("class", "layui-nav-child").append(small_list)
            for (var j = 0; j < a.list.length; j++) {
                var aList_j = a.list[j];
                $dl.append($("<dd>").attr(
                    {
                        "shiro:hasPermission": true,
                        "name": aList_j.shiro,
                    }).append($("<a>").attr(
                    {
                        "href": "javascript:void(0);",
                        "data-url": aList_j.url,
                        "data-id": aList_j.id,
                        "data-text": aList_j.title
                    }).html(aList_j.title)
                    .prepend($("<span>").attr("class", "l-line"))
                ))
                //small_list += "<dd shiro:hasPermission name=\"" + a.list[j].shiro + "\"><a href=\"javascript:;\" data-url=\"" + a.list[j].url + "\" data-id='" + a.list[j].id + "' data-text=\"" + a.list[j].title + "\"><span class=\"l-line\"></span>" + a.list[j].title + "</a></dd>\n";
            }
            // 当li标签添加了class--》 layui-nav-itemed  《--后列表将默认展开，否则将默认不展开
            list.append($("<li>").attr(
                {
                    "class": "layui-nav-item",
                    "shiro:hasPermission": true,
                    "name": a.shiro,
                }).append($("<a>").attr(
                {"href": "javascript:void(0);"}).html(a.title)
                .prepend($("<i>").attr("class", "fas fa-" + a.icon))).append($dl)
            );
            //list.append("<li class=\"layui-nav-item\" shiro:hasPermission name=\"" + a.shiro + "\">\n" + "<a href=\"javascript:void(0);\"><i class=\"fas fa-" + a.icon + "\"></i>" + a.title + "</a>\n" + "<dl class=\"layui-nav-child\">\n" + small_list + "</dl>\n" + "</li>");
        } else {
            list.append($("<li>").attr(
                {
                    "class": "layui-nav-item",
                    "shiro:hasPermission": true,
                    "name": a.shiro,
                }).append($("<a>").attr(
                {
                    "href": "javascript:void(0);",
                    "data-url": a.url,
                    "data-id": a.id,
                    "data-text": a.title
                }
            ).html(a.title).prepend($("<i>").attr("class", "fas fa-" + a.icon))));
            //list.append("<li class=\"layui-nav-item\" shiro:hasPermission name=\"" + a.shiro + "\">\n" + "<a href=\"javascript:;\" data-url=\"" + a.url + "\" data-id='" + a.id + "' data-text=\"" + a.title + "\"><i class=\"fas fa-" + a.icon + "\"></i>" + a.title + "</a>\n" + "</li>");
        }
    }//在list中动态添加主列表项
    function addTools(a, x) {//a：包含副列表的容器 $(“#body”) x:当前列表项 main_list[x]
        for (var i = 0; i < x.tools.length; i++) {
            if (x.tools[i].content) {//当副列表的列表项存在时才会将列表项添加进a中，否则无意义
                var sList = ""//保存副列表子项的字符串
                    ,sUrl = ""//设置URL地址
                    ,sTarget = "";//设置链接打开方式
                $ul = $("<ul>").attr("class", "min_tools");
                for (var j = 0; j < x.tools[i].content.length; j++) {
                    var xT_iC_j = x.tools[i].content[j];
                    //判断URL值是否为URL地址或者IP地址，是则直接跳转
                    if (/^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/.test(xT_iC_j.url) || /((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)/.test(xT_iC_j.url)) {
                        sUrl = xT_iC_j.url;
                        sTarget = "_blank";
                    } else {
                        sUrl = "?p=" + xT_iC_j.url;
                        sTarget = "_self";
                    }
                    //循环加入子列表
                    $ul.append($("<li>").attr(
                        {
                            "shiro:hasPermission": true,
                            "name": xT_iC_j.shiro,
                        }).append($("<a>").attr(
                        {
                            "href": sUrl,
                            "class": "tools_li",
                            "data-url": sUrl,
                            "data-id": xT_iC_j.id,
                            "data-text": xT_iC_j.title,
                            "target": ""
                        }).html(xT_iC_j.title)
                    ))
                    //sList += "<li shiro:hasPermission name=\"" + x.tools[i].content[j].shiro + "\">\n" + "<a href=\"" + sUrl + "\" class='tools_li' data-id='" + x.tools[i].content[j].id + "' data-url='" + sUrl + "' data-name='" + x.tools[i].content[j].title + "' " + sTarget +">" + x.tools[i].content[j].title + "</a>\n" + "</li>";
                }
                var xt_i = x.tools[i];
                a.append($("<li>").attr(
                    {
                        "class": "layui-nav-item",
                        "shiro:hasPermission": true,
                        "name": xt_i.shiro,
                    }).append($("<a>").attr({"href": "javascript:void(0);"}).html(a.title)
                        .prepend($("<i>").attr("class", "fas fa-" + xt_i.icon))
                        .append($("<p>").attr("class", "tools_title").html(xt_i.title))
                    ).append($ul)
                );
                //a.append("<li shiro:hasPermission name=\"" + x.tools[i].shiro + "\">\n" + "<a href=\"javascript:void(0);\">\n" + "<i class=\"fas fa-" + x.tools[i].icon + "\"></i>\n" + "<p class=\"tools_title\">" + x.tools[i].title + "</p>\n" + "</a>\n" + "<ul class=\"min_tools\">\n" + sList + "</ul>\n" + "</li>");
            }
        }//循环遍历 x 中的所有副列表
    }//在a中动态添加副列表
    for (var x = 1; x < main_list.length; x++) {//遍历除首页的所有页面数的JSON
        var mX = main_list[x]
            ,mXit = mX.items
            ,mXto = mX.tools;
        if (p !== null) {//判断页面中是否有P属性值，该属性对应main_list中的page值，页面必须有p属性值才可以正常跳转
            if (p === mX.page) {//只有当前页面的URL中的p属性的属性值与数据中的page属性相同时才会动态向页面中写入列表项
                if (n === null && t === null) {// 当URL中无 t 与 n 属性时执行
                    if (mXit.length === 0 && mXto.length !== 0) {
                        //无默认导航列表并且有工具列表，则使用工具列表第一个对应的导航列表为默认导航列表
                        addTools(list1, mX);//添加工具列表
                        addSample(mXto[0].content[0]);//设定默认导航列表
                    } else if (mXit.length !== 0 && mXto.length === 0) {
                        //有默认导航列表并且无工具列表，则不渲染工具列表
                        addSample(mX);//添加默认导航列表
                    } else if (mXit.length !== 0 && mXto.length !== 0) {
                        //有默认导航列表并且有工具列表，则渲染导航列表并且添加工具
                        addTools(list1, mX);//添加工具列表
                        addSample(mX);//添加默认导航列表
                    }
                    addMaps($mapSite, x);
                } else if (n === null || t === null) {// 当URL中无 t 或 n 属性时返回当前页面的默认页
                    window.location.href = location + "?p=" + p;
                } else if (nN < mXto[tN].content.length && tN < mXto.length) {//当有 n 与 t 时动态加载相应的数据
                    addTools(list1, mX);
                    addSample(mXto[tN].content[nN]);
                    addMaps($mapSite, x);
                } else {//当出现未知可能性时直接跳转默认页面，例如：当 n 与 t 与数据实际情况不符合时，删除n与t
                    window.location.href = location + "?p=" + p;
                }
            } else {//当URL中的p属性无法与当前列表中的数据相匹配时
                var onThis = true;//当前页面URL值与JSON中PAGE值是否有对应
                for (var j = 1; j < main_list.length; j++) {//循环判断所有的数据
                    //当有对应时则返回true并且结束循环，否则返回false并继续循环直至循环结束
                    onThis = p === main_list[j].page ? true : false;
                    if(onThis) break;
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

function addMaps(con, x) {//con:包含位置地图的容器名 x:当前页面的序号
    var location = window.location.origin + window.location.pathname;//获取当前页面不包含任何属性值的根地址（例：http://www.XXX.com/index.html）
    for (var i = 0; i < nav_list.length; i++) {//遍历nav_list
        if (p === nav_list[i].page) {//只有当URL中的P属性找到对应的数据时才添加位置地图
            if (n !== null && t !== null) {
                addSite(p,nav_list[i].title,main_list[x].tools[tN].content[nN]);
                //con.append("位置：<a href=\"" + location + "?p=" + p + "\" class=\"map_prev\">" + nav_list[i].title + "</a>&nbsp;&gt;&nbsp;<span>" + mXto[tN].content[nN].title + "</span>\n")
            } else {
                addSite("home","首页",nav_list[i]);
                //con.append("位置：<a href=\"" + location + "?p=home" + "\" class=\"map_prev\">首页</a>&nbsp;&gt;&nbsp;<span>" + nav_list[i].title + "</span>\n")
            }
        }
    }

    function addSite(p,txt,title){
        con.html("位置：")
            .append($("<a>").attr({"href":location + "?p=" + p,"class":"map_prev"}).html(txt))
            .append("&nbsp;&gt;&nbsp;")
            .append($("<span>").html(title.title))
    }
}//通过nav_list匹配页面的名称

function addNav(con) {//con包含导航菜单的容器名
    for (var i = 0; i < nav_list.length; i++) {
        con.append($("<div>").attr("class","menu-btn")
            .append($("<a>").attr("href","?p=" + nav_list[i].page)
                .append($("<i>").attr("class",nav_list[i].icon))
                .append($("<p>").attr("class","menu-tit").html(nav_list[i].title))
            )
        );
        //con.append("<div class=\"menu-btn\">\n" + "<a href=\"?p=" + nav_list[i].page + "\">\n" + "<i class=\"" + nav_list[i].icon + "\"></i>\n" + "<p class=\"menu-tit\">" + nav_list[i].title + "</p>\n" + "</a>\n" + "</div>")
    }
}//通过nav_list向页面中添加顶部导航列表