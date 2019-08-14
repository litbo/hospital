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
        $(".night_select").val("2");
    }
    else if (adjustmentBegin == 2) {
        $(".adjustment").css("display","none");
        $(".night_select").val("1");
        $(".day_select").val("2");
    }
    else if (adjustmentBegin == 3) {
        $(".adjustment").css("display","inline-block");
        $(".Night").css("display","inline-block");
        $(".night_select").val("1");
        $(".day_select").val("1");
    }
    else if (adjustmentBegin == 4) {
        $(".adjustment").css("display","none")
        $(".night_select").val("2");
        $(".day_select").val("1");
    }
    else if (adjustmentBegin == 5) {
        $(".adjustment").css("display","none");
        $(".night_select").val("2");
        $(".day_select").val("2");
    }

    // 判断值班/不值班下拉框
    // 周一
    var weekday1 = $(".weekday1").val();
    if(weekday1 == 1){
        $(".day_select1").val("1");
    }
    else if (weekday1 == 2) {
        $(".day_select1").val("2");
        $(".night_select").val("2");
    }
    // 周二
    var weekday2 = $(".weekday2").val();
    if(weekday2 == 1){
        $(".day_select2").val("1");
    }
    else if (weekday2 == 2) {
        $(".day_select2").val("2");
        $(".night_select").val("2");
    }
    // 周三
    var weekday3 = $(".weekday3").val();
    if(weekday3 == 1){
        $(".day_select3").val("1");
    }
    else if (weekday3 == 2) {
        $(".day_select3").val("2");
        $(".night_select").val("2");
    }
    // 周四
    var weekday4 = $(".weekday4").val();
    if(weekday4 == 1){
        $(".day_select4").val("1");
    }
    else if (weekday4 == 2) {
        $(".day_select4").val("2");
        $(".night_select").val("2");
    }
    // 周五
    var weekday5 = $(".weekday5").val();
    if(weekday5 == 1){
        $(".day_select5").val("1");
    }
    else if (weekday5 == 2) {
        $(".day_select5").val("2");
        $(".night_select").val("2");
    }
    // 周六
    var weekday6 = $(".weekday6").val();
    if(weekday6 == 1){
        $(".day_select6").val("1");
    }
    else if (weekday6 == 2) {
        $(".day_select6").val("2");
        $(".night_select").val("2");
    }
    // 周日
    var weekday7 = $(".weekday7").val();
    if(weekday7 == 1){
        $(".day_select7").val("1");
    }
    else if (weekday7 == 2) {
        $(".day_select7").val("2");
        $(".night_select").val("2");
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

