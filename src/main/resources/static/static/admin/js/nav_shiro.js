/*
* 本页面注释已做删减并做代码优化，查看完整版注释请看 nav_all.js 查看未优化代码请看 old_nav.js（只有本JS中代码为最新，其余代码均为老版本，仅作为参考）
* */
var $mainList = $("#main_nav_list")//填充1级导航的DOM
    , $viceList = $(".cts_list")//填充2-3级导航的DOM
    , $mapSite = $('.map_site')//站点导航DOM
    , $navList = $(".menus_con")//填充4-5级导航的DOM
    , n = gn = $.getUrlParam('n')//获取URL地址中的 n 属性值，表示右侧副列表的列表项 t 下的第 n 个子列表
    , t = gt = $.getUrlParam('t')//获取URL地址中的 t 属性值，表示右侧主列表的列表项t下
    , p = $.getUrlParam('p')//获取URL地址中的 p 属性值，表示当前页面的名称
    , nN = Number(n)//Number化n值
    , tN = Number(t)
    , shiro = layui.sessionData("rl").sr
    , mList = {} //具体页面导航数据
    , nList = {};//大页面导航数据
var firstTerm = true;

$(function () {
    layui.use("element",function(){
        var element = layui.element;
        $.ajax({
            url: "/static/admin/js/json/nav.json",
            async: false,
            success: function (res) {
                nList = res;
                addNav($navList);
                $.ajax({
                    url: "/static/admin/js/json/list.json",
                    async: false,
                    success: function (res) {
                        mList = res;
                        addList($mainList, $viceList, mList);
                        element.render();
                    }
                })
            }
        })
    })
});

function addList(list, list1, main_list) {//list:包含主列表的容器 list1:包含副列表的容器
    function addSample(a) {//a:main_list[x] （x>=0） 或 main_list[x].tools[y].children[z]
        var thisA = a.children || a.items;
        if (thisA) {//判断是否为 返回首页 列表项（x=0？）
            for (var i = 0; i < thisA.length; i++) {
                addPage(thisA[i]);
            }
        } else {
            addPage(a);
        }
    }//判断当前页面，新建并切换TAB标签页
    function addPage(a) {//a:main_list[0] 或 main_list[x].items[i] (x>1)
        var small_list = "", bre = true;
        //权限不匹配不渲染列表
        if (shiro !== undefined) {
            for (var k = 0; k < shiro.length; k++) {
                if (a.shiro === shiro[k].rightName) {
                    bre = true;
                    break;
                } else {
                    bre = false;
                }
            }
            //若一个匹配都不成功则不渲染
            if (!bre) {
                return false;
            }
        }else{
            return false;
        }
        if (a.children) {
            var $dl = $("<dl>").attr("class", "layui-nav-child").append(small_list);
            for (var j = 0; j < a.children.length; j++) {
                var aList_j = a.children[j];
                for (var u = 0; u < shiro.length; u++) {
                    if (aList_j.shiro === shiro[u].rightName) {
                        bre = true;
                        break;
                    } else {
                        bre = false;
                    }
                }
                //若一个匹配都不成功则不渲染
                if (!bre) {
                    continue;
                }
                $dl.append($("<dd>").attr(
                    {
                        "shiro:hasPermission": aList_j.shiro
                    }).append($("<a>").attr(
                    {
                        "href": "javascript:void(0);",
                        "data-url": aList_j.url,
                        "data-id": aList_j.id,
                        "data-text": aList_j.title
                    }).html(aList_j.title)
                    .prepend($("<span>").attr("class", "l-line"))
                 ));
                if(aList_j.children){
                    var $dll = $("<dl>");
                    for(var m=0;m<aList_j.children.length;m++){
                        for (var ms = 0; ms < shiro.length; ms++) {
                            if (aList_j.children[m].shiro === shiro[ms].rightName) {
                                $dll.append($("<dd>").attr(
                                    {
                                        "shiro:hasPermission": aList_j.children[m].shiro,
                                        "style":"margin:1px 0 1px 10px;"
                                    }).append($("<a>").attr(
                                    {
                                        "href": "javascript:void(0);",
                                        "data-url": aList_j.children[m].url,
                                        "data-id": aList_j.children[m].id,
                                        "data-text": aList_j.children[m].title
                                    }).html(aList_j.children[m].title)
                                    .prepend($("<span>").attr({"class": "l-line-w"}))
                                ));
                            }
                        }
                    }
                    $dl.append($dll);
                }
            }
            list.append($("<li>").attr(
                {
                    "class": "layui-nav-item",
                    "shiro:hasPermission": a.shiro
                }).append($("<a>").attr(
                {"href": "javascript:void(0);"}).html(a.title)
                .prepend($("<i>").attr("class", "fas fa-" + a.icon))).append($dl)
            );
        } else {
            list.append($("<li>").attr(
                {
                    "class": "layui-nav-item",
                    "shiro:hasPermission": a.shiro
                }).append($("<a>").attr(
                {
                    "href": "javascript:void(0);",
                    "data-url": a.url,
                    "data-id": a.id,
                    "data-text": a.title
                }
            ).html(a.title).prepend($("<i>").attr("class", "fas fa-" + a.icon))));
        }
    }//在list中动态添加主列表项
    function addTools(a, x) {//a：包含副列表的容器 $(“#body”) x:当前列表项 main_list[x]
        for (var i = 0; i < x.tools.length; i++) {
            if (x.tools[i].children) {//当副列表的列表项存在时才会将列表项添加进a中，否则无意义
                var sUrl = ""//设置URL地址
                    , sTarget = ""//设置链接打开方式
                    , bres = true
                    , xt_i = x.tools[i];
                //匹配权限
                if (shiro !== undefined) {
                    for (var k = 0; k < shiro.length; k++) {
                        if (xt_i.shiro === shiro[k].rightName) {
                            bres = true;
                            break;
                        } else {
                            bres = false;
                        }
                    }
                    //若一个匹配都不成功则不渲染
                    if (!bres) {
                        continue;
                    }
                }else{
                    return false;
                }
                var $ul = $("<ul>").attr("class", "min_tools"),clickUrl = "javascript:void(0);";
                for (var j = 0; j < x.tools[i].children.length; j++) {
                    var xT_iC_j = x.tools[i].children[j], bres1 = true;
                    if (shiro !== undefined) {
                        for (var t = 0; t < shiro.length; t++) {
                            if (xT_iC_j.shiro === shiro[t].rightName) {
                                bres1 = true;
                                break;
                            } else {
                                bres1 = false;
                            }
                        }
                        //若一个匹配都不成功则不渲染
                        if (!bres1) {
                            continue;
                        }
                    }else{
                        return false;
                    }
                    //页面初始化加载可展示的第一个导航
                    if(firstTerm && !gt && !gn){
                        addSample(xT_iC_j);
                        firstTerm = false;
                    }
                    var pt,pn;
                    //判断URL值是否为URL地址或者IP地址
                    if (/^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/.test(xT_iC_j.url) || /((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)/.test(xT_iC_j.url)) {
                        sUrl = xT_iC_j.url;
                        sTarget = "_blank";
                    } else {
                        sUrl = "?p=" + xT_iC_j.url;
                        sTarget = "_self";
                        pt = Number(xT_iC_j.url.split("&")[1].split("=")[1]);//获取当前渲染的项中URL的t
                        pn = Number(xT_iC_j.url.split("&")[2].split("=")[1]);//获取当前渲染的项中URL的n
                    }

                    var $newLi = $("<li>").attr(
                        {
                            "shiro:hasPermission": xT_iC_j.shiro
                        }).append($("<a>").attr(
                        {
                            "href": sUrl,
                            "class": "tools_li",
                            "data-url": sUrl,
                            "data-id": xT_iC_j.id,
                            "data-text": xT_iC_j.title,
                            "target": sTarget
                        }).html(xT_iC_j.title)
                    );
                    if(pt === tN && pn === nN){
                        $newLi.find("a").addClass("nav_this");
                    }

                    $ul.append($newLi);
                }
                //clickUrl = xt_i.url;
                a.append($("<li>").attr(
                    {
                        "class": "layui-nav-item",
                        "shiro:hasPermission": xt_i.shiro
                    }).append($("<a>").attr({"href": clickUrl}).html(a.title)
                        .prepend($("<i>").attr("class", "fas fa-" + xt_i.icon))
                        .append($("<p>").attr("class", "tools_title").html(xt_i.title))
                    ).append($ul)
                );
            }
        }
    }//动态添加副列表
    //页面导航判断与渲染
    for (var x = 1; x < main_list.length; x++) {
        var mX = main_list[x]
            , mXit = mX.items
            , mXto = mX.tools;
        if (p !== null) {//判断页面URL中是否有表示当前页面名称的属性值
            if (p === mX.page) {//判断页面URL中表示当前页面名称的属性值（p）与哪一个数据匹配
                if (n === null && t === null) {// 当URL中无 t 与 n 属性时执行
                    if (mXit.length === 0 && mXto.length !== 0) {
                        //无默认主列表但有副列表，则使用副列表第一个列表项对应的主列表项为默认导航列表
                        addTools(list1, mX);
                        //addSample(mXto[0].children[0]);
                    } else if (mXit.length !== 0 && mXto.length === 0) {
                        //有默认主列表并且无副列表，则不渲染副列表
                        addSample(mX);
                    } else if (mXit.length !== 0 && mXto.length !== 0) {
                        //有默认导航列表并且有工具列表，则渲染主列表并且添加副列表
                        addTools(list1, mX);
                        //addSample(mX);
                    }
                    addMaps($mapSite, x);
                } else if (n === null || t === null) {// 当URL中只有 t 与 n 属性中的一个时删除URL中的 t 与 n
                    location.search = "?p=" + p;
                } else if (nN < mXto[tN].children.length && tN < mXto.length) {//当URL中同时有 t 与 n 时则动态加载相应的数据
                    addTools(list1, mX);
                    firstTerm && addSample(mXto[tN].children[nN]);
                    addMaps($mapSite, x);
                } else {//当出现未知可能性时则直接跳转默认页面，例如：当 n 与 t 与数据实际情况不符合时，删除 t 与 n
                    location.search = "?p=" + p;
                }
            } else {//当URL中的表示当前页面名称的属性值（p）无法与当前列表中的数据相匹配时
                var onThis;//判断所有数据中是否有一个值与表示当前页面名称的属性值（p）对应
                for (var j = 1; j < main_list.length; j++) {
                    //当有对应时则返回true并且结束循环，否则返回false并继续循环直至循环结束
                    onThis = (p === main_list[j].page);
                    if (onThis) break;
                }
                //表示当前页面名称的属性值（p）与所有的数据中对应的名称均不匹配时页面将直接跳转至首页
                if (!onThis) location.search = "?p=home";
            }
        } else {//URL中无p属性时默认直接载入首页
            location.search = "?p=home";
        }
    }
}//动态的向页面中添加列表

function addMaps(con, x) {//con:包含位置地图的容器名 x:当前页面的序号
    var location = window.location.origin + window.location.pathname;//获取当前页面不包含任何属性值的根地址（例：http://www.XXX.com/index.html）
    for (var i = 0; i < nList.length; i++) {
        if (p === nList[i].page) {
            if (n !== null && t !== null) {
                addSite(p, nList[i].title, mList[x].tools[tN].children[nN]);
            } else {
                addSite("home", "首页", nList[i]);
            }
        }
    }

    function addSite(p, txt, title) {//p:跳转页面名 txt:上一项文字 title:当前项文字
        con.html("位置：")
            .append($("<a>").attr({"href": location + "?p=" + p, "class": "map_prev"}).html(txt))
            .append("&nbsp;&gt;&nbsp;")
            .append($("<span>").html(title.title))
    }
}//通过nav_list匹配页面的名称

function addNav(con) {//con包含导航菜单的容器名
    for (var i = 0; i < nList.length; i++) {
        con.append($("<li>").attr("class", "layui-nav-item menu-btn")
            .append($("<a>").attr("href", "?p=" + nList[i].page)
                .append($("<i>").attr("class", nList[i].icon))
                .append($("<p>").attr("class", "menu-tit").html(nList[i].title))
            )
        );
        //添加每个页面点开后新增一个标签页
        /*if(p !== "home"){
            if(p === nList[i].page){
                changeTab({
                    title:nList[i].title,
                    url:"./global/page.html?p="+p+"&s="+i,
                    id:"pageFix"
                })
            }
        }*/
    }
}//通过nav_list向页面中添加顶部导航列表
