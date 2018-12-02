layui.use(['layer', 'form', 'element', 'jquery', 'dialog'], function () {
    var element = layui.element
        , $ = layui.jquery
        , hideBtn = $('#hideBtn')
        , mainLayout = $('#main-layout')
        , mainMask = $('.main-mask');
    //监听导航点击
    element.on('nav(leftNav)', function (elem) {
        var id = elem.attr('data-id')
            ,url = elem.attr('data-url')
            ,text = elem.attr('data-text');
        if (!url) {
            return;
        }
        var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
        if (isActive.length > 0) {
            //切换到选项卡
            element.tabChange('tab', id);
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
    //监听导航点击
    element.on('nav(rightNav)', function (elem) {
        var navA = $(elem).find('a')
            ,id = navA.attr('data-id')
            ,url = navA.attr('data-url')
            ,text = navA.attr('data-text');
        if (!url) {
            return;
        }
        var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
        if (isActive.length > 0) {
            //切换到选项卡
            element.tabChange('tab', id);
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

    element.on('tabDelete(tab)', function(data){
        var id = $(this).parent().attr("lay-id")
            ,ground = data.elem[0].childNodes[1].childNodes
            ,num = ground.length;
        if(num < 4 ){
            document.getElementById('home').contentWindow.location.reload();//重新加载welcome页，避免统计图表错乱
        }
        $(".layui-nav-item a[data-id='"+id+"']").parent().removeClass("layui-this");
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
    })

    //示范一个公告层
	/*layer.open({
		  type: 1
		  ,title: false //不显示标题栏
		  ,closeBtn: false
		  ,area: '300px;'
		  ,shade: 0.8
		  ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
		  ,resize: false
		  ,btn: ['好的']
		  ,btnAlign: 'c'
		  ,moveType: 1 //拖拽模式，0或者1
		  ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">后台模版1.1版本今日更新：<br><br><br>数据列表页...<br><br>编辑删除弹出功能<br><br>失去焦点排序功能<br>数据列表页<br>数据列表页<br>数据列表页</div>'
		  ,success: function(layero){
		    var btn = layero.find('.layui-layer-btn');
		    btn.find('.layui-layer-btn0').attr({
		      href: 'http://www.layui.com/'
		      ,target: '_blank'
		    });
		  }
		});*/
});