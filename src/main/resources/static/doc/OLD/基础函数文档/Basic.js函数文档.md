> Markdown说明：本文档使用 Typora 编写，如格式出现错误，请尝试使用 Typora 打开本文档
>
> 作者：张小富
>
> 创建时间：2018-12-01

# Basic.js函数文档

Basic.js文件为整个项目的基础函数库，函数库内的绝大多数函数是所有页面共有的，在任何一个页面均可以使用的。

Basic.js文件为页面优化完善函数库，与其他js文件区别在于Basic.js文件函数均有 公有、基础 等特性。

详细函数说明如下：

## 1：getUrlParam函数

> 此函数采用jQuery方式封装，便于使用`$.`方式调用，便于扩展jQuery方式

`全局函数`

getUrlParam函数用于获取URL地址中的参数，一个可以获取一个参数值，用法如下：

**函数接收值：**

| 参数名 | 必填 | 数据类型            | 描述                                            |
| ------ | ---- | ------------------- | ----------------------------------------------- |
| name   | 是   | string              | URL中需要获取的参数名                           |
| site   | 否   | [number,object,“…”] | 标记需要捕获哪个位置的参数中的URL，默认当前窗口 |

- site参数默认值说明：

  site参数默认有两种形式定位（如下表格），当site参数无效时默认获取当前所在窗口的URL参数

  | 值     | 数据类型 | 描述                            |
  | ------ | -------- | ------------------------------- |
  | 1      | number   | 定位到父级窗口，获取URL中的参数 |
  | window | object   | 定位到指定窗口，获取URL中的参数 |

  > 当site为object类型的值时必须是window或者window对象下的子框架的对象，否则参数无效

**函数调用示例：**

  ```javascript
  //页面URL: www.domain.com?p=go 框架URL：www.domain.com/index?p=do
  //页面中调用
  $.getUrlParam("p")//go
  $.getUrlParam("p",top.frames[0])//do
  //框架中调用
  $.getUrlParam("p")//do
  $.getUrlParam("p",1)//go
  $.getUrlParam("p",top)//go
  ```


**函数返回值：**

- 当可以获取到所需的相关参数时，函数会返回URL中对应的参数值（string类型）
- 当无法获取到所需的相关参数时，函数会返回null(object类型)


## 2：$.cookie函数

$.cookie函数使用jQuery形式操作页面cookie（增加、获取、删除）

**函数接收值：**

| 参数名  | 必填 | 数据类型 | 描述                 |
| ------- | ---- | -------- | -------------------- |
| name    | 是   | string   | 需要操作的cookie名   |
| value   | 否   | 任意     | 需要增加的cookie值   |
| options | 否   | object   | 其他可操作cookie参数 |

- cookie操作说明：

  增加：当`name` `value`项已填写的时候默认为增加cookie（options为额外控制项，不填则默认）

  获取：当只有`name`项已填写时则默认为获取cookie值

  删除：需要删除cookie时直接将value项置为 `null` 即可

- option说明(增加cookie时有效)：

  | 参数名  | 数据类型       | 描述                                              |
  | ------- | -------------- | ------------------------------------------------- |
  | expires | Number \| Date | cookie数据有效期（单位：天）                      |
  | path    | String         | cookie路径，用于设置可以获取cookie的顶级目录      |
  | domain  | String         | cookie创建页面域名                                |
  | secure  | Boolean        | 如果为true，则cookie传输会以安全协议传输（HTTPS） |

  > option参数以JSON格式传输，无顺序

**函数调用示例：**

```javascript
$.cookie("f", 10, { expires: 1, domain: 'localhost' });
//创建一个名称为 f ,值为 10 ，有效期 1天 ，页面域名localhost的cookie
```

**函数返回值：**

只有当函数增加cookie时函数才会有返回值，返回值为需要获取的cookie名对应的cookie值4

## 3：markPage函数

markPage函数用于创建页面加载效果，可以自定义显示文字。

此函数需要在<body>内最开始的位置引入，遮罩会在设定好的时间（time参数）后自动消失，当页面加载完毕遮罩也会消失。

> 理论上此函数可以加载在任何页面的<body>内，但是实际测试发现只有只在index.html加效果最好

**函数接收值：**

| 参数值 | 必填 | 描述                 | 默认值             | 数据类型 |
| ------ | ---- | -------------------- | ------------------ | -------- |
| text   | 否   | 页面加载时的提示文字 | “页面急速加载中！” | String   |
| time   | 否   | 遮罩默认消失时间     | 3000               | Number   |

> 为兼容手机端，提示文字不易过多

函数调用示例：**

```javascript
markPage();
markPage("马上就加载好了！");
```

**函数返回值：**

此函数没有任何返回值

## 4：Type函数

Type函数用于判断给定的数据类型，并且返回对应数据类型名称（统一为小写形式）

| 数据类型 | 举例               | 返回结果 |
| -------- | ------------------ | -------- |
| Number   | Type(1)            | number   |
| Array    | Type([])           | array    |
| Function | Type(function(){}) | function |
| Json     | Type({})           | json     |
| String   | Type(“ppp”)        | string   |

> 其他非常规数据类型，将指向其constructor

## *：tableFunc函数

tableFunc函数用于操作table表格，是每个table表格公共操作的集合，通过JSON格式引用相应函数

| 属性值   | 必填             | 数据类型          | 描述                                                |
| -------- | ---------------- | ----------------- | --------------------------------------------------- |
| obj      | 是(个别情况不需) | Object            | TABLE组件函数默认参数，也可以是AJAX获取到的所有数据 |
| addMsg   | 否               | Number \|\| Array | 向表格中添加提示信息                                |
| addLink  | 否               | String            | 表格点击跳转链接（需要event=“openLink”支持）        |
| toolFunc | 否               | Json              |                                                     |

示例：

```javascript
function(obj){
    tableFunc({
        "obj":obj,
        "addMsg":2,
        "addLink":"table1",
        "toolFunc":{
            "title":"详细情况",
            "content":"无内容"
        }
    })
}
```



### 1：addMsg函数

`必须obj参数`

addMsg函数用于向页面中指定列加入提示信息。

> 由于LAYUI框架限制addMsg函数依照鼠标所在TABLE内容判断并显示，故最好在当前列数据不重复的情况下使用，否则有可能会出现数据对应错误。
>

**函数接收值：**

| 参数名  | 数据类型           | 描述                      | 必填 | 默认值 |
| ------- | ------------------ | ------------------------- | ---- | ------ |
| num     | Number             | 设定显示Message信息的列   | 否   | 1      |
| timeIn  | Number \|\| String | Message信息淡入动画是时间 | 否   | 500ms  |
| timeOut | Number \|\| String | Message信息淡出动画是时间 | 否   | 100ms  |

> 如果对应数据内无message数据（参考-表格（TABLE）公共属性.md）则表格不会添加message信息
>
> 如果参数填写错误，将使用默认值

**函数调用示例：**

```javascript
{
    "addMsg":2//表格第二列数据添加message
    "addMsg":[3,600,"300"]//表格第三列数据添加600ms淡入300ms淡出的message
}
```


### 2：addLink函数

addLink函数用于向页面中指定列加入提示信息。

**此函数根据表头的`event=“openLink”`来判断是哪一列数据，当传入的参数不为String类型时函数将默认选定`lay-filter="table1"`的表格标签**

**函数接收值：**

| 参数名 | 数据类型 | 描述                                | 必填 | 默认值               |
| ------ | -------- | ----------------------------------- | ---- | -------------------- |
| value  | String   | 用于指定table标签（lay-filter对应） | 是   | table1               |
| yes    | String   | 跳转确认框提示内容                  | 否   | 确定要跳转链接吗？   |
| no     | String   | 当前无链接提示内容                  | 否   | 没有可以跳转的链接。 |

> 如果对应数据内无link数据（参考-表格（TABLE）公共属性.md）则当弹出确认链接后

**函数调用示例：**

```javascript
{
    "addLink":"table1"//为table1表格匹配到的event="openLink"列添加点击事件
    "addLink":["table2","打开所点链接吗？","当前无链接哦！"]
}
```

### 3：toolFunc函数

toolFunc函数为表格按钮添加点击事件,使用数组形式，每一项内容为一个JSON

| 参数名  | 数据类型 | 描述                                                         | 必填 | 默认值                |
| ------- | -------- | ------------------------------------------------------------ | ---- | --------------------- |
| filter  | String   | 匹配表格的lay-filter                                         | 否   | table1                |
| event   | String   | 匹配按钮的lay-event                                          | 是   |                       |
| title   | String   | 弹窗的标题                                                   | 否   | “详情”                |
| type    | Number   | 弹出窗口的填充类型（1：填充文字 2：填充页面）                | 否   | 1                     |
| content | String   | 弹出窗口的文字或者链接地址                                   | 否   | “无内容”              |
| tool    | String   | 控制按钮在表格中位置<br>(**“tool”表格主体按钮 “toolbar”表格顶部工具条内容）**<br>*此项填写不正确将无法出现效果* | 否   | tool                  |
| area    | Array    | 弹出窗口的大小                                               | 否   | [width-20,height-20]* |
| resize  | Boolean  | 窗口是否可以允许用户调节大小                                 | 否   | false                 |
| move    | Boolean  | 窗口是否可以允许用户移动                                     | 否   | false                 |

> 弹出窗口默认为近似全屏样式,宽高均为页面宽高-20，自定义时务必以数组形式先宽再高

**函数调用示例：**

```javascript
{
    "toolFunc":[{
        "tool":"toolbar"//如操作的是表格顶部工具，此项必须修改为toolbar，否则可以不写
    	"filter":"table1",
    	"event":"record",
    	"title":"详细内容",
    	"type":2,
    	"content":"../../repair.html"
	},
    {
    	"event":"edit"
	},{...}]
 }
```