> Markdown说明：本文档使用 Typora 编写，如格式出现错误，请尝试使用 Typora 打开本文档
>
> 作者：张小富
>
> 创建时间：2018-11-16

# nav_list - 数组列表说明

`nav_list`变量用于定义页面中的导航列表（顶部），通过改变页面URL参数的方式切换不同的页面



**<u>`nav.js`</u>中的addNav函数通过调用`nav_list`变量来渲染页面列表**



> `nav_list`变量存在于`list.js` 文件中

—–END—–

## nav_list[x] - JSON类型

`nav_list[x]`控制单个导航列表项

*示例：*

```javascript
{
    "page":"data",
    "title":"数据收集",
    "icon":"fas fa-chart-bar"
}
```

JSON属性说明：

| 属性名 | 是否启用 | 含义                      |
| :----: | :------: | ------------------------- |
|  page  |    是    | 页面的名称（URL跳转指向） |
| title  |    是    | 导航名称                  |
|  icon  |    是    | 导航图标                  |

—–END—–