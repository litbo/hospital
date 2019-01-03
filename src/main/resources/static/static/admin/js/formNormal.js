/*
* formNormal.js用于渲染页面中的表单
* 作者：张小富
* 创建事件：2019-1-1 完善时间：
* 修改时间：
* 代码说明：---1：formNormal.js可以控制表单的提交与判断等操作
*            2：详细表单说明请参考LAYUI官方文档https://www.layui.com/doc/modules/form.html
* */

$(function(){
    if(formAction && Type(formAction) === "json"){
        layui.use(['form','laydate'],function(){
            var form = layui.form,laydate = layui.laydate,
                normal = {
                    filter:"sub"
                },//通用默认操作集合
                nor_date ={
                    elem: "#date",
                    value: today,
                    format: "y-M-d"
                },//默认的日期选择器
                nor_ver = {

                },//默认添加的表单验证数据
                //日期选择
                date = formAction.date,
                //表单默认值
                val = formAction.val,
                //表单数据验证
                ver = formAction.ver,
                //提交选择
                sub = formAction.submit,
                filter = "";

            //表单默认值渲染
            if(val && val !== false){
                //自动匹配lay-filter相同的元素，val.value：{name(input表单name):value(name对应默认数据)}
                if(val.filter && val.value && Type(val.value) === "json"){
                    form.val(val.filter , val.value);
                }else{
                    console.error("formNormal.js遇到一个无法处理的错误：");
                    console.error("formAction.val参数传递错误,请参考相关文档！");
                }
            }

            //日期选择器渲染
            //支持 默认渲染 单选择器渲染 多选择器渲染
            if (date && date !== false) {
                //当 data = true 时使用默认的参数渲染数据
                if(date === true){
                    a(nor_date);
                    //当 data 数据类型为 JSON 时则渲染一个日期选择器(优先自定义属性)
                }else if(Type(date) === "json"){
                    a(date);
                    //当 data 数据类型为 ARRAY 时则渲染多个日期选择器(优先自定义属性)
                }else if(Type(date) === "array"){
                    for(var j=0;j<date.length;j++){
                        a(date[j]);
                    }
                }
                //日期选择器的渲染函数
                function a(date){
                    //匹配默认数据，未填写的参数将使用已有的参数填充
                    compereData(date, nor_date);
                    //判断日期选择器是否为范围选择器
                    if(date.range){
                        //默认连接符
                        var bars = date.bar || "-";
                        if(Type(date.range) === "array"){
                            bars = date.range
                        }
                        //默认日期渲染
                        date.value = today+" "+bars+" "+today
                    }
                    //日期选择器渲染
                    laydate.render(date);
                }
            }

            //表单数据验证函数
            //LAYUI表单组建默认支持：required（必填项） phone（手机号） email（邮箱） url（网址） number（数字） date（日期） identity（身份证）
            // 自定义值
            if(ver && ver !== false){
                if(Type(ver) === "json"){
                    compereData(ver, nor_ver);
                    form.verify(ver);
                }
            }

            //表单按钮点击事件
            if(sub && sub !== false){
                //设定固定的提交按钮事件还是所有的提交按钮的事件
                if(sub.filter){
                    //当sub.filter = true时则使用默认的过滤字符，否则使用自定义的字符
                    sub.filter === true ? filter = '('+normal.filter+')': filter = '('+sub.filter+')';
                }
                form.on('submit'+filter,function(data){
                    //data：表单所有数据,包含内容如下
                    //-----elem:被执行事件的DOM对象（点击的按钮）
                    //-----form:表单dorm组建，没有form标签则不存在
                    //-----field:容器内的所有表单字段 {name: value}

                    //表单提交事件（处理在subUp函数内部处理）
                    subUp(sub,data);
                    //阻止按钮默认事件
                    return false;
                })
            }

            //表单组建监听事件
            //可以监听的组建 select checkbox switch radio
            if(event && event !== false){
                //设定固定的提交按钮事件还是所有的提交按钮的事件
                if(event.filter){
                    //当event.filter = true时则使用默认的过滤字符，否则使用自定义的字符
                    event.filter === true ? filter = '('+normal.filter+')': filter = '('+event.filter+')';
                    form.on(event.box+filter,function(data){
                        //data：所有数据,包含内容如下
                        //-----elem:原始DOM对象(select(下拉) checkbox(复选) switch(开关) radio(单选))
                        //-----value:被选中的值(select(下拉) checkbox(复选) switch(开关) radio(单选))
                        //-----othis:美化后的DOM对象(select(下拉) checkbox(复选) switch(开关))
                        //-----elem.checked(checkbox(复选) switch(开关))

                        //如果存在函数则执行函数
                        event.func || event.func(data);

                        //自定义是否需要阻止默认事件
                        if(event.break === true){
                            //阻止按钮默认事件
                            return false;
                        }
                    })
                }
            }
        })
    }
});