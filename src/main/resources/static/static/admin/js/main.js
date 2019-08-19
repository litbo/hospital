layui.use(['layer', 'form', 'element', 'jquery'], function () {
    var element = layui.element
        , $ = layui.jquery
        , hideBtn = $('#hideBtn')
        , mainLayout = $('#main-layout')
        , menu = []
        , mainMask = $('.main-mask')
        , showMsg = "当前页面已打开，是否刷新此页面？";
    //element.init();
    //element.render("nav");
    //监听左侧主导航点击
    element.on('nav(leftNav)', function (elem) {
        //console.log(elem);
        var id = elem.attr('data-id')
            , url = elem.attr('data-url')
            , text = elem.attr('data-text');
        //console.log(url);
        if (!url) {
            return;
        }
        var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
        if (isActive.length > 0) {
            //切换到选项卡
            if(isActive.hasClass("layui-this")){
                layer.confirm(showMsg, function (index) {
                    var src = $(".layui-tab-item.layui-show").find("iframe").attr("src");
                    $(".layui-tab-item.layui-show").find("iframe").attr("src", src);
                    layer.close(index);
                })
            }else{
                element.tabChange('tab', id);
            }
        } else {
            element.tabAdd('tab', {
                title: text,
                content: '<iframe src="' + url + '" name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
                id: id
            });
            element.tabChange('tab', id);
            setStorageMenu(text, url, id);
        }
        mainLayout.removeClass('hide-side');
    });
    //监听右上角用户按钮导航点击
    element.on('nav(rightNav)', function (elem) {
        var navA = $(elem)
            , id = navA.attr('data-id')
            , url = navA.attr('data-url')
            , text = navA.attr('data-text');
        if (!url) {
            return;
        }
        var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
        if (isActive.length > 0) {
            //切换到选项卡
            if(isActive.hasClass("layui-this")){
                layer.confirm(showMsg, function (index) {
                    var src = $(".layui-tab-item.layui-show").find("iframe").attr("src");
                    $(".layui-tab-item.layui-show").find("iframe").attr("src", src);
                    layer.close(index);
                })
            }else{
                element.tabChange('tab', id);
            }
        } else {
            element.tabAdd('tab', {
                title: text,
                content: '<iframe src="' + url + '" name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
                id: id
            });
            element.tabChange('tab', id);

        }
        mainLayout.removeClass('hide-side');
    });

    element.on('tabDelete', function (data) {
        var id = $(this).parent().attr("lay-id")
            , ground = data.elem[0].childNodes[1].childNodes
            , num = ground.length;
        //根据cookie值判断是否重载图表
        if ($(".navs li").length <= 1) {
            if ($.cookie("ww") < 100) {
                $.cookie("ww", null);
                document.getElementById('home').contentWindow.location.reload();
            }

        }
        //将当前删除的tab对应的列表选中取消
        $(".layui-nav-item a[data-id='" + id + "']").parent().removeClass("layui-this");
        /*if($('.layui-nav-tree .layui-nav-child').length >0 && $('.layui-nav-tree .layui-nav-child').prev().children("span").length <= 0){
            location.reload();
        }*/
    });
    //菜单隐藏显示
    hideBtn.on('click', function () {
        if (!mainLayout.hasClass('hide-side')) {
            mainLayout.addClass('hide-side');
        } else {
            mainLayout.removeClass('hide-side');
        }
    });
    //遮罩点击隐藏
    mainMask.on('click', function () {
        mainLayout.removeClass('hide-side');
    });
    /**
     *@todo tab切换监听
     * tab切换监听不能写字初始化加载$(function())方法内，否则不执行
     */
    element.on('tab(tab)', function (data) {
        //console.log(this); //当前Tab标题所在的原始DOM元素
        setStorageCurMenu();
    });
    /*
     * @todo 监听layui Tab项的关闭按钮，改变本地存储
     */
    element.on('tabDelete(tab)', function (data) {
        var layId = $(this).parent('li').attr('lay-id');
        //console.log(layId);
        removeStorageMenu(layId);
    });

    /*
     * @todo 初始化加载完成执行方法
     * 打开或刷新后执行
     */
    /**
     * @todo 本地存储-session
     * @tips 专对于导航（其他可用，需要适当调整输入）
     * @warm 除非必要，请不要修改下方三个函数代码，如使用本地存储功能请参照文档
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
        var curMenu = sessionStorage.getItem('curMenu'), $layTabTit = $('.layui-tab-title'),
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

    $(function () {
        /*
         * @todo 读取本地存储中记录的已打开的tab项
         * 刷新后，读取记录，打开原来已打开的tab项
         */

        //延时加载
        setTimeout(function () {
            var se = window.location.search;
            if (sessionStorage.getItem("menu")) {
                menu = JSON.parse(sessionStorage.getItem("menu"));
                if (menu.length === 0) {
                    //当不在首页时则展开左侧第一个导航第
                    if (se !== "home") {
                        if ($('.layui-nav-tree .layui-nav-child').length > 0) {
                            $(".layui-nav-tree .layui-nav-item").eq(0).addClass("layui-nav-itemed")
                        } else {
                            // $(".layui-nav-tree .layui-nav-item").eq(0).addClass("layui-this")
                        }
                    }
                    return false;
                }
                for (var i = 0; i < menu.length; i++) {
                    if (se !== menu[i]["search"]) {
                        removeStorageMenu(menu[i].id);
                        continue;
                    }
                    element.tabAdd('tab', {
                        title: menu[i].title,
                        content: '<iframe src="' + menu[i].url + '" name="iframe' + menu[i].id + '" class="iframe" framborder="0" data-id="' + menu[i].id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
                        id: menu[i].id
                    });
                }
            } else if (sessionStorage.getItem("menu")) {
                $(".layui-nav-tree .layui-nav-item")[1].click();
                return false;
            }
            var curMenu, id;
            if (sessionStorage.getItem("curMenu")) {
                $('.layui-tab-title').find('layui-this').removeClass('layui-class');
                curMenu = JSON.parse(sessionStorage.getItem("curMenu"));
                if (se !== curMenu["search"]) {
                    return;
                }
                id = curMenu.id;
                $('.layui-tab-title li[lay-id="' + id + '"]').addClass('layui-this');
                element.tabChange('tab', id);
                var $this_tag = $(".layui-nav-tree *[data-id=" + id + "]");
                if($this_tag.length>0){
                    $this_tag[0].click();
                    $this_tag.parent().addClass("layui-this");
                    if ($this_tag.parent()[0].tagName === "DD" || $this_tag.parent()[0].tagName === "dd") {
                        $this_tag.parent().parent().parent().addClass("layui-nav-itemed");
                    }
                }
            }

        }, 100);
        //点击tab标题时，触发reloadTab函数
        // $('#tabName').on('click','li',function(){
        //     reloadTab(this);
        // });

        //初始化加载结束
    });
});