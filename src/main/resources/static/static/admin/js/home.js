layui.use('element', function () {
    var element = layui.element;
    $(function () {
        var emp = tempValue("rl", "emp", false)
            , glo = tempValue("rl", "glo", false)
            , loc = tempValue("pageLock", "lock", false)
            , f = tempValue("index", "f", null)
            , uu = $.getUrlHash("url")
            , tt = $.getUrlHash("title") || "新窗口"
            , ii = $.getUrlHash("id") || "n9999";
        //http://localhost/admin/index/index.html?p=home#url=./repair.html#title=百度首页#id=666666
        //判断点 #url=./repair.html #title=百度首页 #id=666666
        //获取URL HASH值打开新页面
        if (uu !== null) {
            element.tabAdd('tab', {
                title: tt,
                content: '<iframe src="' + uu + '" name="iframe"' + ii + '"" class="iframe" framborder="0" data-id="' + ii + '" scrolling="auto" width="100%"  height="100%"></iframe>',
                id: ii
            });
            element.tabChange('tab', ii);
            window.location.hash = "";
        }

        var active = {
            tabAdd: function(){
                //新增一个Tab项
                element.tabAdd('demo', {
                    title: '新选项'+ (Math.random()*1000|0) //用于演示
                    ,content: '内容'+ (Math.random()*1000|0)
                    ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                })
            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('tab', '7300'); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });


        //获取用户信息
        if (emp) {
            $(".h_name").text(emp.userXm);
            $(".h_room").text(emp.bmName);
            if (emp.sex === "女") {
                $(".user_head").attr("src", "/static/admin/images/woman.png")
            }
        } else {
            layer.alert("无法获取用户信息，请重新登录！", function (index) {
                layer.close(index);
                location.href = "/logout"
            })
        }

        //LOGO设置
        if (glo) {
            $(".m-logo img").attr("src", glo.logo)
        }

        $(document).on("click",function(){
            //锁定判断
            if($("#lock").length === 0){
                layer.confirm("锁定状态失效，请重新登录！", function () {
                    location.href = "/logout";
                    tempValue("pageLock", "lock", null);
                    window.locked = false;
                });
            }
        });

        if (loc || window.locked) {
            goLock(true);
        }

        //页面登出事件
        $(".quit").on("click", function () {
            layer.confirm("确定要退出吗？", function () {
                location.href = "/logout";
                tempValue("pageLock", "lock", null);
                window.locked = false;
            });
            return false;
        });
        //数据大屏
        $("#sjdp").click(function () {
            layer.open({
                type: 2,
                title:"",
                maxmin:true,
                area:['100%','100%'],
                content:['./dataCollection/page/dataScreen.html'],//数据大屏url
            });
            layer.full(index);
        });








        //页面锁定事件
        $("#lockSys").on("click", goLock);
        function goLock(cc) {
            //console.log(cc);
            if (cc !== true) {
                layer.confirm("确认锁定系统吗？", goo);
            } else {
                goo();
            }

            function goo(index) {
                layui.sessionData("pageLock", {
                    key: "lock",
                    value: "true"
                });
                window.locked = true;
                layer.close(index);
                var inn = layOpen({
                    type: 1,
                    content: $("#lock"),
                    closeBtn: 0,
                    maxmin: false,
                    fixed: true,
                    resize: false,
                    title: false,
                    area: ["100%", "100%"]
                });
                $("#check-btn").on("click", function () {
                    var k = $("#uKey").val();
                    if (!k) {
                        layer.alert("请输入密码！");
                        return false;
                    }
                    $.ajax({
                        url: "/hospital/lock",
                        type: "POST",
                        data: {
                            userId: emp.userId,
                            userPwd: k
                        },
                        success: function (res) {
                            if (res.code === 0) {
                                tempValue("pageLock", "lock", null);
                                window.locked = false;
                                layer.close(inn);
                            } else {
                                layer.alert("系统锁定解除失败！");
                                $("#uKey").val("");
                                console.log(res);
                            }
                        },
                        error: function (res) {
                            layer.alert("数据请求错误！");
                            console.log(res);
                        }
                    });
                    return false;
                })
            }
        }

        //判断当前页面，标示出当前页面的导航栏（改变导航栏底色）并禁止点击
        (function () {
            var page = $.getUrlParam("p");
            var $a = $(".menu-btn").find("a[href='?p=" + page + "']");
            if ($a.length > 0) {
                $a.addClass("hotShow").css("background", "#089ce20f");
                $a.on("click", function () {
                    return false;
                });
            }
        })();

        //判断主页(welcome.html)点击时渲染是否正确，不正确重载主页
        $("#refresh_home").click(function () {
            if ($(this).hasClass("layui-this")) {
                return false;
            }
            setTimeout(function () {
                document.getElementById('home').contentWindow.location.reload();
            }, 10)
        });
        //展开第一项列表

        //读取本地存储中的页面ID并打开页面（仅限当前页面存在的页面，主要用于welcome页跳转）
        if (f && typeof Number(f) === "number") {
            var ne = $("a[data-id='" + Number(f) + "']");
            if (ne.length > 0) {
                ne[0].click();
            }
        }

        $(".tools").on('click', function (event) {
            event.stopPropagation();
            $(".cts2").toggleClass("showMsg");
            var $con = $(".layui-tab-content");
            $con.parent().append(
                $("<div>").css({
                    width: "100%",
                    height: "100%",
                    position: "absolute",
                    top: "40px",
                    left: "0",
                    "z-index": 99
                }).attr("class", "showId").on("click", function () {
                    $(".cts2").removeClass("showMsg");
                    $(".conts").removeClass("showMsg");
                    $(this).remove();
                })
            )
        });

        $(".info1").on("click", function (event) {
            event.stopPropagation();
            $(".conts").toggleClass("showMsg");
            var $con = $(".layui-tab-content");
            $con.parent().append(
                $("<div>").css({
                    width: "100%",
                    height: "100%",
                    position: "absolute",
                    top: "40px",
                    left: "0",
                    "z-index": 99
                }).attr("class", "showId").on("click", function () {
                    $(".cts2").removeClass("showMsg");
                    $(".conts").removeClass("showMsg");
                    $(this).remove();
                })
            )
        });

        $(document).on("click", function () {
            $(".cts2").removeClass("showMsg");
            $(".conts").removeClass("showMsg");
            $(".showId").remove();
        });

        $("#goHome").on("click", function () {
            if ($.getUrlParam("p") !== "home") {
                layer.confirm("返回首页将关闭当前已打开的所有页面，是否确认？", function () {
                    location.href = "?p=home";
                });
            } else {
                layer.msg("您当前已处于首页！");
            }
        });

        window.onresize = changeSize;
        $(function(){
            changeSize();
            $(".nav_this").on("click",function () {
                layer.msg("您当前已处于此页面！");
                return false;
            })
        });

        //动态计算2-3级导航栏宽度
        function changeSize(){
            var winWid = $(document).outerWidth(),
                $li = $(".lg_cts2>li"),
                len = $li.eq(0).outerWidth() * $li.length;
            len += 10;
            if(winWid > 1170){
                $(".navs").css("margin-right",len+"px");
                $(".lg_tools").css("width",len+"px");
            }else{
                $(".navs").css("margin-right","55px");
            }
        }
    })
});