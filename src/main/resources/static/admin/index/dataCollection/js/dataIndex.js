$(function () {

    // 隐藏图片
    $(".site-demo-active").click(function () {
        $('.index_show img').hide(10);
    });

    // 判断下拉框(add2)
    var adjustmentBegin = $("#scheduling").val();


    if(adjustmentBegin == 1){
        $(".adjustment").css("display","inline-block");
        $(".Night").css("display","none");
        $(".night_select option[value=2]").attr("selected", true);
    }
    else if (adjustmentBegin == 2) {
        $(".adjustment").css("display","none");
        $(".night_select option[value=1]").attr("selected", true);
        $(".day_select option[value=2]").attr("selected", true);
    }
    else if (adjustmentBegin == 3) {
        $(".adjustment").css("display","inline-block");
        $(".Night").css("display","inline-block");
    }
    else if (adjustmentBegin == 4) {
        $(".adjustment").css("display","none");
        $(".night_select option[value=2]").attr("selected", true);
        $(".day_select option[value=1]").attr("selected", true);
    }
    else if (adjustmentBegin == 5) {
        $(".adjustment").css("display","none");
    }

    // 判断下拉框(add4)
    var hourSelect = $(".hour_select").val();
    if(hourSelect == 1 ){
        $(".ci").css("display","none");
        $(".shi").css("display","inline-block");
    }else{
        $(".shi").css("display","none");
        $(".ci").css("display","inline-block");
    }
});

