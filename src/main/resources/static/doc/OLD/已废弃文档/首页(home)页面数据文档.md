> Markdown说明：本文档使用 Typora 编写，如格式出现错误，请尝试使用 Typora 打开本文档
>
> 作者：张小富
>
> 创建时间：2018-12-04
>
> 修改时间：2018-12-06

# 首页(home)页面数据文档

首页文件存放于`/home`文件夹下

**首页文件组成：**

默认列表：

| 页面ID | 页面名称 | 文档名称     | 页面ID | 页面名称 | 文档名称          |
| ------ | -------- | ------------ | ------ | -------- | ----------------- |
| 11     | 我的任务 | my_task.html | 14     | 通知公告 | announcement.html |
| 12     | 提醒事项 | remind.html  | 15     | 共享信息 | public_info.html  |

## 11.我的任务页(my_task.html)

接收数据格式：

| 属性名         | 可见 | 描述       |
| -------------- | ---- | ---------- |
| task_name      | 是   | 任务名称   |
| task_form      | 是   | 任务来源   |
| task_date      | 是   | 安排日期   |
| guide_personal | 是   | 指定接受人 |
| state          | 是   | 状态       |

示例：

```javascript
[{
    "task_name": '任务1',
   	"task_form": "直接下发",
    "task_date": "2018-12-01",
    "guide_personal": "陈某某",
    "state": "良好"
},{...},{...}]
```

当页面查询请求发起时，将自动按照以下格式向后端请求数据，后端返回数据请按照以上接收格式处理。

**发送数据格式：**

| 属性名 | 类型   | 描述           | 举例    |
| ------ | ------ | -------------- | ------- |
| action | string | 数据请求类型   | getData |
| key    | string | 数据请求关键字 | my_task |

示例：

```javascript
{"action":"getData","key":"XXX"}
//数据以POST形式发送，只需以正常POST接收即可
```
## 12.提醒事项页(remind.html)

**接收数据格式：**

| 属性名       | 可见 | 描述           |
| ------------ | ---- | -------------- |
| remind_type  | 是   | 提醒类别       |
| remind_msg   | 是   | 提醒信息       |
| remind_times | 是   | 累计提醒（次） |
| remind_end   | 是   | 末次提醒       |
| cut_date     | 是   | 截止日期       |

示例：

```javascript
[{
    "remind_type": '普通提醒',
    "remind_msg": "新的提醒信息，请查收！",
    "cut_date": "2019-01-01",
    "remind_times": "7",
    "remind_end": "2018-11-25"
},{...},{...}]
```

当页面查询请求发起时，将自动按照以下格式向后端请求数据，后端返回数据请按照以上接收格式处理。

**发送数据格式：**

| 属性名 | 类型   | 描述           | 举例    |
| ------ | ------ | -------------- | ------- |
| action | string | 数据请求类型   | getData |
| key    | string | 数据请求关键字 | remind  |

示例：

```javascript
{"action":"getData","key":"XXX"}
//数据以POST形式发送，只需以正常POST接收即可
```
## 14.通知公告页(announcement.html)

**接收数据格式：**

| 属性名             | 可见 | 描述         |
| ------------------ | ---- | ------------ |
| activity_name      | 是   | 活动名       |
| process_name       | 是   | 流程名       |
| create_date        | 是   | 创建日期     |
| Service_monitoring | 是   | 服务水平监控 |
| cut_date           | 是   | 截止日期     |

示例：

```javascript
[{
    "activity_name": 'XXXXXXXXXX',
    "process_name": "XXXXX",
    "create_date": "2018-11-23 21：34:00",
    "Service_monitoring": "XXX",
    "cut_date": "2018-11-23 21：34:00",
    "link": "https://www.baidu.com",
    "messages": [
        {
            name: "流程名称",
            value: "某一个活动"
        },
        {
            name: "创建日期",
            value: "2018-11-23 21：34:00"
         }
                    ]
},{...},{...}]
```

当页面查询请求发起时，将自动按照以下格式向后端请求数据，后端返回数据请按照以上接收格式处理。

**发送数据格式：**

| 属性名 | 类型   | 描述           | 举例    |
| ------ | ------ | -------------- | ------- |
| action | string | 数据请求类型   | getData |
| key    | string | 数据请求关键字 | XXX     |

示例：

```javascript
{"action":"getData","key":"XXX"}
//数据以POST形式发送，只需以正常POST接收即可
```

## 15.通知公告页(public_info.html)

**接收数据格式：**

| 属性名      | 可见 | 描述     |
| ----------- | ---- | -------- |
| doc_name    | 是   | 文档名称 |
| up_personal | 是   | 上传人   |
| up_date     | 是   | 上传日期 |

示例：

```javascript
[{
    "doc_name": '文件1',
    "up_personal": "用户1",
    "up_date": "2018-12-01"
},{...},{...}]
```

当页面查询请求发起时，将自动按照以下格式向后端请求数据，后端返回数据请按照以上接收格式处理。

**发送数据格式：**

| 属性名 | 类型   | 描述           | 举例    |
| ------ | ------ | -------------- | ------- |
| action | string | 数据请求类型   | getData |
| key    | string | 数据请求关键字 | XXX     |

示例：

```javascript
{"action":"getData","key":"XXX"}
//数据以POST形式发送，只需以正常POST接收即可
```