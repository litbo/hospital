var main_list =
    [
        {
            "title": "首页",
            "url": "?p=home",
            "href":"?p=home",
            "id": "0",
            "icon": "home",
            "shiro":"a",
            "func":function(){
            }
        },
        {
            "page":"home",
            "tools":[],
            "items":[
                {
                    "title": "我的任务",
                    "url": "./home/my_task.html",
                    "id": "11",
                    "icon": "calendar-check",
                    "shiro":"a"
                },
                {
                    "title": "提醒事项",
                    "url": "./home/remind.html",
                    "id": "12",
                    "icon": "clipboard",
                    "shiro":"a"
                },
                {
                    "title": "共享信息",
                    "url": "javascript:void(0);",
                    "id": "13",
                    "icon": "star",
                    "shiro":"a",
                    "list": [
                        {
                            "title": "通知公告",
                            "url": "./home/announcement.html",
                            "id": "14",
                            "shiro":"a"
                        },
                        {
                            "title": "公共信息",
                            "url": "./home/public_info.html",
                            "id": "15",
                            "shiro":"a"
                        }
                    ]
                }
            ]
        },
        {
            "page":"data",
            "tools":[
                {
                    "title": "联网设备",
                    "icon": "globe-asia",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "运行记录",
                            "url": "data&t=0&n=0",
                            "shiro": "a",
                            "id": "2",
                            "items": [
                                {
                                    "title": "运行记录",
                                    "url": "javascript:void(0);",
                                    "icon":"book-open",
                                    "id": "21",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "单机运行设备",
                                            "url": "./data/network-sys/equip_record.html",
                                            "id": "22",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "使用科室设备运行记录",
                                            "url": "./data/network-sys/room_record.html",
                                            "id": "23",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title":"设备联网设置",
                                    "url":"javascript:void(0);",
                                    "icon":"network-wired",
                                    "id":"24",
                                    "shiro": "a",
                                    "list":[
                                        {
                                            "title":"设备联网设置",
                                            "url":"./data/network-sys/equip_network.html",
                                            "id":"25",
                                            "shiro": "a"
                                        },
                                        {
                                            "title":"设备值班排班设置",
                                            "url":"./data/network-sys/equip_work.html",
                                            "id":"26",
                                            "shiro": "a"
                                        },
                                        {
                                            "title":"设备加班设置",
                                            "url":"./data/network-sys/equip_overtime.html",
                                            "id":"27",
                                            "shiro": "a"
                                        },
                                        {
                                            "title":"核实工时设置",
                                            "url":"./data/network-sys/work_time.html",
                                            "id":"28",
                                            "shiro": "a"
                                        },
                                        {
                                            "title":"运行记录",
                                            "url":"./data/network-sys/run_record.html",
                                            "id":"29",
                                            "shiro": "a"
                                        },
                                        {
                                            "title":"原始记录",
                                            "url":"./data/network-sys/begin_record.html",
                                            "id":"30",
                                            "shiro": "a"
                                        },
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"工作量记录",
                            "url":"data&t=0&n=1",
                            "shiro": "a",
                            "id": "25",
                            'items':[
                                {
                                    "title":"设备工作量记录",
                                    "url":"javascript:void(0);",
                                    "id":"26",
                                    "icon":"industry",
                                    "shiro": "a",
                                    "list":[
                                        {
                                            "title":"单机工作量",
                                            "url":"./table.html",
                                            "id":"27"
                                        },
                                        {
                                            "title":"科室设备工作量",
                                            "url":"./table.html",
                                            "id":"28"
                                        },
                                        {
                                            "title":"同种设备工作量",
                                            "url":"./table.html",
                                            "id":"29"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"实时监控",
                            "url":"http://www.baidu.com",
                            "id":"30",
                            "shiro": "a"
                        }
                    ]
                }
            ],
            "items":[]
        },
        {
            "page":"life",
            "tools":[
                {
                    "title":"采购管理",
                    "icon":"shopping-cart",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"申购管理",
                            "url":"life&t=0&n=0",
                            "shiro":"a",
                            "id":"3",
                            "items":[
                                {
                                    "title":"科室申购",
                                    "url":"./table.html",
                                    "icon":"credit-card",
                                    "id":"31",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"科室讨论",
                                            "url":"./life/purchase-management/department-discuss.html",
                                            "id":"32",
                                            "shiro":"a"
                                        },
                                        {
                                            "title": "申购单填写",
                                            "url": "./table.html",
                                            "id": "33",
                                            "shiro": "a"
                                        },
                                        {
                                            "title":"科室汇总审核",
                                            "url":"./table.html",
                                            "id":"34",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"申购进度跟踪",
                                            "url":"./table.html",
                                            "id":"35",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"申购汇总",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"36",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"申购单论证分析",
                                            "url":"./table.html",
                                            "id":"37",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"申购单汇总",
                                            "url":"./table.html",
                                            "id":"38",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"临时采购授权",
                                            "url":"./table.html",
                                            "id":"39",
                                            "shiro":"a"
                                        }

                                    ]
                                },
                                {
                                    "title":"集体讨论",
                                    "url":"./table.html",
                                    "icon":"comments",
                                    "id":"310",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"装备委员会记录",
                                            "url":"./table.html",
                                            "id":"311",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"年度采购计划",
                                            "url":"./table.html",
                                            "id":"312",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"院办公会记录",
                                            "url":"./table.html",
                                            "id":"313",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"采购实施计划",
                                            "url":"./table.html",
                                            "id":"314",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"统计查询",
                                    "url":"./table.html",
                                    "icon":"comments",
                                    "id":"315",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"申购设备公示查询",
                                            "url":"./table.html",
                                            "id":"316",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"字典设置",
                                    "url":"./table.html",
                                    "icon":"comments",
                                    "id":"317",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"申购讨论条件",
                                            "url":"./table.html",
                                            "id":"318",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"论证分析全额设置",
                                            "url":"./table.html",
                                            "id":"319",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"招标采购",
                            "url":"life&t=0&n=1",
                            "shiro":"a",
                            "id":"320",
                            "items":[
                                {
                                    "title":"招标采购",
                                    "url":"./table.html",
                                    "icon":"shopping-cart",
                                    "id":"321",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"计划打包",
                                            "url":"./table.html",
                                            "id":"322",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"中标录入",
                                            "url":"./table.html",
                                            "id":"323",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"合同录入",
                                            "url":"./table.html",
                                            "id":"324",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"合同查询",
                                            "url":"./table.html",
                                            "id":"325",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"合同执行",
                            "url":"life&t=0&n=2",
                            "shiro":"a",
                            "id":"326",
                            "items":[
                                {
                                    "title":"合同执行",
                                    "url":"./table.html",
                                    "icon":"file-contract",
                                    "id":"327",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"到货登记",
                                            "url":"./table.html",
                                            "id":"328",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"科室接收",
                                            "url":"./table.html",
                                            "id":"329",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"设备验收",
                                            "url":"./table.html",
                                            "id":"330",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"信息查看",
                                    "url":"./table.html",
                                    "icon":"magic",
                                    "id":"331",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"合同进度查看",
                                            "url":"./table.html",
                                            "id":"332",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"验收管理",
                            "url":"life&t=0&n=3",
                            "id":"333",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"到货登记",
                                    "url":"./table.html",
                                    "icon":"solar-panel",
                                    "id":"334",
                                    "shiro":"a"
                                },
                                {
                                    "title":"科室验收",
                                    "url":"./table.html",
                                    "icon":"user-md",
                                    "id":"335",
                                    "shiro":"a"
                                },
                                {
                                    "title":"设备验收",
                                    "url":"./table.html",
                                    "icon":"drafting-compass",
                                    "id":"336",
                                    "shiro":"a"
                                },
                                {
                                    "title":"统计查询",
                                    "url":"./table.html",
                                    "icon":"chart-pie",
                                    "id":"337",
                                    "shiro":"a"
                                }
                            //     {
                            //         "title":"商务验收",
                            //         "url":"./table.html",
                            //         "icon":"solar-panel",
                            //         "id":"338",
                            //         "shiro":"a",
                            //         "list":[
                            //             {
                            //                 "title":"待商务验收设备",
                            //                 "url":"./table.html",
                            //                 "id":"339",
                            //                 "shiro":"a"
                            //             },
                            //             {
                            //                 "title":"商务验收查询",
                            //                 "url":"./table.html",
                            //                 "id":"340",
                            //                 "shiro":"a"
                            //             }
                            //         ]
                            //     },
                            //     {
                            //         "title":"临床验收",
                            //         "url":"./table.html",
                            //         "icon":"user-md",
                            //         "id":"341",
                            //         "shiro":"a",
                            //         "list":[
                            //             {
                            //                 "title":"待临床验收设备",
                            //                 "url":"./table.html",
                            //                 "id":"342",
                            //                 "shiro":"a"
                            //             },
                            //             {
                            //                 "title":"临床验收查询",
                            //                 "url":"./table.html",
                            //                 "id":"343",
                            //                 "shiro":"a"
                            //             }
                            //         ]
                            //     },
                            //     {
                            //         "title":"技术验收",
                            //         "url":"./table.html",
                            //         "icon":"drafting-compass",
                            //         "id":"344",
                            //         "shiro":"a",
                            //         "list":[
                            //             {
                            //                 "title":"待技术验收设备",
                            //                 "url":"./table.html",
                            //                 "id":"345",
                            //                 "shiro":"a"
                            //             },
                            //             {
                            //                 "title":"技术验收查询",
                            //                 "url":"./table.html",
                            //                 "id":"346",
                            //                 "shiro":"a"
                            //             }
                            //         ]
                            //     }
                            // ]
                            ]
                        }
                    ]
                },
                {
                    "title":"使用管理",
                    "icon":"mouse-pointer",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"操作规程",
                            "url":"life&t=1&n=0",
                            "id":"347",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"操作规程查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"348",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"已备案操作规程",
                                            "url":"./table.html",
                                            "id":"349",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"适用中操作规程",
                                            "url":"./table.html",
                                            "id":"350",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已停用操作规程",
                                            "url":"./table.html",
                                            "id":"351",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"操作规程制定",
                                    "url":"./table.html",
                                    "icon":"pencil-alt",
                                    "shiro":"a",
                                    "id":"352",
                                    "list":[
                                        {
                                            "title":"编写",
                                            "url":"./table.html",
                                            "id":"353",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"操作规程制定流程",
                                            "url":"./table.html",
                                            "id":"354",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"操作规程再评价",
                                    "url":"./table.html",
                                    "icon":"comment-alt",
                                    "id":"355",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"操作规程再评价流程",
                                            "url":"./table.html",
                                            "id":"356",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"进度查询",
                                    "url":"./table.html",
                                    "icon":"spinner",
                                    "id":"357",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"制定进度",
                                            "url":"./table.html",
                                            "id":"358",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"再评价进度",
                                            "url":"./table.html",
                                            "id":"359",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"操作规程模板",
                                    "url":"./table.html",
                                    "id":"360",
                                    "icon":"paperclip",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"模板列表",
                                            "url":"./table.html",
                                            "id":"361",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"录入模板",
                                            "url":"./table.html",
                                            "id":"362",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"电子台账",
                            "url":"life&t=1&n=2",
                            "id":"363",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"设备台账",
                                    "url":"./table.html",
                                    "id":"364",
                                    "icon":"file-invoice-dollar",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"总账",
                                            "url":"./table.html",
                                            "id":"365",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"分户账",
                                            "url":"./table.html",
                                            "id":"366",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"分类账",
                                            "url":"./table.html",
                                            "id":"367",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"账实核对",
                                    "url":"./table.html",
                                    "icon":"clipboard-check",
                                    "id":"368",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"计划制定",
                                            "url":"./table.html",
                                            "id":"369",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"计划查询",
                                            "url":"./table.html",
                                            "id":"370",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"账实核对",
                                            "url":"./table.html",
                                            "id":"371",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"核实对比",
                                            "url":"./table.html",
                                            "id":"372",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"查询统计",
                                    "url":"./table.html",
                                    "icon":"chart-pie",
                                    "id":"373",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"科室设备综合查询",
                                            "url":"./table.html",
                                            "id":"374",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"综合查询",
                                            "url":"./table.html",
                                            "id":"375",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"综合统计",
                                            "url":"./table.html",
                                            "id":"376",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"字典设置",
                                    "url":"./table.html",
                                    "icon":"stamp",
                                    "id":"377",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"设备金额档设置",
                                            "url":"./table.html",
                                            "id":"378",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"其他台账",
                                    "url":"./table.html",
                                    "icon":"file-invoice-dollar",
                                    "id":"379",
                                    "shiro":"a"
                                }

                            ]
                        }
                        //,379
                        // {
                        //     "title":"用前检查",
                        //     "url":"life&t=1&n=1",
                        //     "id":"1",
                        //     "shiro":"a",
                        //     "items":[
                        //         {
                        //             "title":"用前检查任务",
                        //             "url":"./table.html",
                        //             "id":"3",
                        //             "icon":"tasks",
                        //             "shiro":"a",
                        //             "list":[
                        //                 {
                        //                     "title":"待执行任务",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"已执行任务",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         },
                        //         {
                        //             "title":"统计查询",
                        //             "url":"./table.html",
                        //             "id":"3",
                        //             "icon":"chart-pie",
                        //             "shiro":"a",
                        //             "list":[
                        //                 {
                        //                     "title":"分科室统计",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         },
                        //         {
                        //             "title":"用前检查规范",
                        //             "url":"./table.html",
                        //             "id":"3",
                        //             "icon":"scroll",
                        //             "shiro":"a",
                        //             "list":[
                        //                 {
                        //                     "title":"规范查询",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"规范编制",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"编制任务",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         }
                        //     ]
                        // },
                        // {
                        //     "title":"设备档案管理",
                        //     "url":"life&t=1&n=3",
                        //     "id":"1",
                        //     "shiro":"a",
                        //     "items":[
                        //         {
                        //             "title":"档案检索",
                        //             "url":"./table.html",
                        //             "icon":"search",
                        //             "id":"3",
                        //             "shiro":"a",
                        //             "list":[
                        //                 {
                        //                     "title":"案卷目录",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"文件目录",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"设备建档查询",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         },
                        //         {
                        //             "title":"档案借阅",
                        //             "url":"./table.html",
                        //             "icon":"hands-helping",
                        //             "id":"3",
                        //             "shiro":'a',
                        //             "list":[
                        //                 {
                        //                     "title":"档案借阅",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"档案借阅记录",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"逾期提醒",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         },
                        //         {
                        //             "title":"原始资料提交",
                        //             "url":"./table.html",
                        //             "icon":"university",
                        //             "id":"3",
                        //             "shiro":"a",
                        //             "list":[
                        //                 {
                        //                     "title":"原始资料提交",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"原始资料提交记录",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"原始资料整理与接收",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"原始资料接收记录",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         },
                        //         {
                        //             "title":"档案管理",
                        //             "url":"./table.html",
                        //             "icon":"folder-open",
                        //             "id":"3",
                        //             "shiro":'a',
                        //             "list":[
                        //                 {
                        //                     "title":"立卷建档",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"资料归档",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"实物档案位置设置",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"历史档案管理",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"电子资料归档记录",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         },
                        //         {
                        //             "title":"案卷移交",
                        //             "url":"./table.html",
                        //             "icon":"folder-minus",
                        //             "id":'3',
                        //             "shiro":"a",
                        //             "list":[
                        //                 {
                        //                     "title":"案卷移交",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"案卷移交记录",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         },
                        //         {
                        //             "title":"设备大事记",
                        //             "url":"./table.html",
                        //             "icon":"clipboard-list",
                        //             "id":"3",
                        //             "shiro":"a",
                        //             "list":[
                        //                 {
                        //                     "title":"设备大事记",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"需时间纠错案卷列表",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         },
                        //         {
                        //             "title":"基础信息设置",
                        //             "url":"./table.html",
                        //             "icon":"sliders-h",
                        //             "id":"3",
                        //             "shiro":"a",
                        //             "list":[
                        //                 {
                        //                     "title":"档案室设置",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"柜子条码打印",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"档案编码规则设置",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"文件类型设置",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"档案数据字典",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         },
                        //         {
                        //             "title":"基础信息设置(实施人员)",
                        //             "url":"./table.html",
                        //             "icon":"sliders-h",
                        //             "id":"3",
                        //             "shiro":"a",
                        //             "list":[
                        //                 {
                        //                     "title":"档案临时文件存储途径",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"电子档案文件存放目录",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"电子文件设置",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 },
                        //                 {
                        //                     "title":"金额线设置",
                        //                     "url":"./table.html",
                        //                     "id":"3",
                        //                     "shiro":"a"
                        //                 }
                        //             ]
                        //         }
                        //     ]
                        // }
                    ]
                },
                {
                    "title":"应急管理",
                    "icon":"exclamation-triangle",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"应急预案",
                            "url":"life&t=2&n=0",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"应急预案查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"已备案",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"试用中",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已弃用",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"应急预案制定",
                                    "url":"./table.html",
                                    "icon":"pencil-alt",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"开始指定",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"制订收件箱",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"应急预案再评价",
                                    "url":"./table.html",
                                    "icon":"comment-alt",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"再评价收件箱",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"进度查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"制订进度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"再评价进度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"模板录入和查询",
                                    "url":"./table.html",
                                    "icon":"paperclip",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"模板录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"模板列表",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"应急替代",
                            "url":"life&t=2&n=1",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"紧急报停",
                                    "url":"./table.html",
                                    "icon":"minus-circle",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"紧急报停搜查",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"替代设备搜查",
                                    "url":"./table.html",
                                    "icon":"screwdriver",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"搜查设备",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"设备替换完成",
                                    "url":"./table.html",
                                    "icon":"check",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"等待替换",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"替换完成",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"病人安置记录",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"总结报告",
                                    "url":"./table.html",
                                    "icon":"flag",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"总结评价",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"应急替代报告",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"查询&统计",
                                    "url":"./table.html",
                                    "icon":"chart-pie",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"搜查结果查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"应急调配",
                            "url":"life&t=2&n=2",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"设备调配",
                                    "url":"./table.html",
                                    "icon":"puzzle-piece",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"查询调用",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"设备送达",
                                    "url":"./table.html",
                                    "icon":"check-circle",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"未送达调配单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已送达调配单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"设备归还",
                                    "url":"./table.html",
                                    "icon":"undo-alt",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"收条",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"调配跟踪",
                                    "url":"./table.html",
                                    "icon":"umbrella-beach",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"调配跟踪",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"使用监视",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"汇总考评",
                                    "url":"./table.html",
                                    "icon":"envelope-open-text",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"查询&统计",
                                    "url":"./table.html",
                                    "icon":"chart-pie",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"事件查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"统计报表",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]

                },
                {
                    "title":"处置管理",
                    "icon":"compact-disc",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"处置管理",
                            "url":"life&t=3&n=0",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"处置查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"处置查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待报废清单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已报废清单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"处置申请",
                                    "url":"./table.html",
                                    "icon":"rocket",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"处置申请",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"处置任务",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"处置上报",
                                    "url":"./table.html",
                                    "icon":"arrow-up",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"待上报列表",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                    ]
                                },
                                {
                                    "title":"处置批复",
                                    "url":"./table.html",
                                    "icon":"calendar-check",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"待批复列表",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"处置清理",
                                    "url":"./table.html",
                                    "icon":"broom",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"待清理设备",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"处置备案",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"待备案处置设备",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"资产管理",
                    "icon":"money-check",
                    "shiro":"a",
                    "content":[]
                }
            ],
            "items":[]
        },
        {
            "page":"safe",
            "tools":[
                {
                    "title":"风险管理",
                    "icon":"exclamation-triangle",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"风险管理",
                            "url":"safe&t=0&n=0",
                            "shiro":"a",
                            "id":"4",
                            "items":[
                                {
                                    "title":"风险分析",
                                    "url":"./table.html",
                                    "icon":"poll",
                                    "id":"41",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"风险分值定义",
                                            "url":"./safe/risk-management/risk-rating.html",
                                            "id":"42",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"风险等级",
                                            "url":"./safe/risk-managment/risk-rating.html",
                                            "id":"43",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"风险评价",
                                    "url":"./table.html",
                                    "icon":"user-edit",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"风险监测",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"风险预警",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"实时监视",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"风险控制",
                                    "url":"./table.html",
                                    "icon":"sliders-h",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"风险控制实施",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"质控等级目录",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"分级风控方案",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"设备风控单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"维修管理",
                    "icon":"wrench",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"设备维修",
                            "url":"safe&t=1&n=0",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"维修任务",
                                    "url":"./table.html",
                                    "icon":"wrench",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"报修",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修任务",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修费申请",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"满意度再评价",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"补录维修报告",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"查询&统计",
                                    "url":"./table.html",
                                    "icon":"chart-pie",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"工程师工作情况",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"信息设备维修查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"本科维修费汇总",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"综合查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"字典管理",
                                    "url":"./table.html",
                                    "icon":"book",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"配件字典",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修字典",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"简称配置故障现象",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"维修设置",
                                    "url":"./table.html",
                                    "icon":"sliders-h",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"反馈信息设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"辅助维修工程师来源设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"配件清零设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修短信提醒设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"报修审核设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修签到设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"科室确认环节停留时间设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修审核环节启用设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"领导分管设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"院外维修工程师用户管理",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"维修实时监控",
                                    "url":"./table.html",
                                    "icon":"eye",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        },
                        {
                            "title":"维修合同",
                            "url":"safe&t=1&n=1",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"报修合同",
                                    "url":"./table.html",
                                    "icon":"scroll",
                                    "id":"3",
                                    "list":[
                                        {
                                            "title":"合同录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"合同支付(1)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"合同查询(2)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"维修配件",
                            "url":"safe&t=1&n=2",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"配件申购",
                                    "url":"./table.html",
                                    "icon":"shopping-cart",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"配件入库",
                                    "url":"./table.html",
                                    "icon":"university",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"配件入库",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"申购入库",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"配件出库",
                                    "url":"./table.html",
                                    "icon":"sign-out-alt",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"配件退库",
                                    "url":"./table.html",
                                    "id":"3",
                                    "icon":"gavel",
                                    "shiro":"a"
                                },
                                {
                                    "title":"配件查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"入库查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"出库查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"库存查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"退库查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"供货商查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"配件字典",
                                    "url":"./table.html",
                                    "icon":"torah",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        },
                        {
                            "title":"维修发票",
                            "url":"safe&t=1&n=3",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"维修发票管理",
                                    "url":"./table.html",
                                    "id":"3",
                                    "icon":"receipt",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"维修发票登记",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修发票审核",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修发票查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"应用培训",
                    "icon":"graduation-cap",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"人员培训",
                            "url":"safe&t=2&n=0",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"培训计划",
                                    "url":"./table.html",
                                    "id":"3",
                                    "icon":"scroll",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"计划制定",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"人员档案",
                                    "url":"./table.html",
                                    "icon":"user-tag",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"人员名单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待训人员",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"人员录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"培训过程",
                                    "url":"./table.html",
                                    "icon":"user-clock",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"签到",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"考核",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"颁证",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"培训查询",
                                    "url":"./table.html",
                                    "icon":"user-friends",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"计划查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"人员上岗资质",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"设备上岗资质",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"医疗事件",
                    "icon":"briefcase-medical",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"安全(不良)事件",
                            "url":"safe&t=3&n=0",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"不良事件报告",
                                    "url":"./table.html",
                                    "icon":"file-powerpoint",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"可疑报告",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"网络直报",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"报告反馈",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"泄械控制",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"统计查询",
                                    "url":"./table.html",
                                    "icon":"chart-pie",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"报告查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"综合查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"综合统计",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"质量管理",
                    "icon":"feather",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"维护保养",
                            "url":"safe&t=4&n=0",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"维护保养规范",
                                    "url":"./table.html",
                                    "id":"3",
                                    "icon":"newspaper",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"保养规范",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"规范编制",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"编制任务",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"维护保养计划",
                                    "url":"./table.html",
                                    "icon":"scroll",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"常规保养计划",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"预防性维护计划",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"维护保养任务",
                                    "url":"./table.html",
                                    "icon":"map",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"预防性维护待执行任务",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"常规保养待执行任务",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已执行任务",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"统计查询",
                                    "url":"./table.html",
                                    "icon":"chart-pie",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"综合查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"统计报表",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"维护保养设置",
                                    "url":"./table.html",
                                    "icon":"sliders-h",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        },
                        {
                            "title":"设备质检",
                            "url":"safe&t=4&n=1",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"检测计划",
                                    "url":"./table.html",
                                    "id":"3",
                                    "icon":"scroll",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"计划制定",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"计划修改",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"计划查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"检测任务",
                                    "url":"./table.html",
                                    "icon":"newspaper",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"计划实施查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"质量检测项目设置",
                                    "url":"./table.html",
                                    "icon":"sliders-h",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        },
                        {
                            "title":"设备巡检",
                            "url":"safe&t=4&n=2",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"巡检计划",
                                    "url":"./table.html",
                                    "icon":"scroll",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"计划制定",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"计划修改",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"计划查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"巡检任务",
                                    "url":"./table.html",
                                    "icon":"newspaper",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"设备巡检(0)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"计划实施查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        },
                        {
                            "title":"设备计量",
                            "url":"safe&t=4&n=3",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"查询统计",
                                    "url":"./table.html",
                                    "icon":"chart-pie",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"综合查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"综合统计",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"计量器具信息",
                                    "url":"./table.html",
                                    "icon":"info",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"总账",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"分户账",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"报废账",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"计量台账录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"计量任务",
                                    "url":"./table.html",
                                    "icon":"newspaper",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"检定提醒(0)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"送检申请",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"送检审批(0)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"检定结果录入(0)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"检定结果导入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"计量查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"已送检计量器具清单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已鉴定计量器具清单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"特种设备",
                            "url":"safe&t=4&n=4",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"特种设备台账",
                                    "url":"./table.html",
                                    "icon":"file-invoice-dollar",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"特种设备",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"安全附件",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"特种设备录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"特种设备检测",
                                    "url":"./table.html",
                                    "icon":"check-square",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"检测计划",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"送检任务",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"送检申请",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"送检审批",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"结果录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"结果查看",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"特种设备从业人员",
                                    "url":"./table.html",
                                    "id":"3",
                                    "icon":"user",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"从业人员",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"人员设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"证件到期提醒",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"厂商管理",
                    "icon":"building",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"资质审核",
                            "url":"safe&t=5&n=0",
                            "id":"1",
                            "shiro":"a",
                            'items':[
                                {
                                    "title":"使用说明",
                                    "url":"./table.html",
                                    "icon":"info",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"单证验证",
                                    "url":"./table.html",
                                    "icon":"user-check",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"经营/生产许可证",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"产品注册证",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"单证验证查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"许可证列表(0)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"注册证列表(0)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"综合验证",
                                    "url":"./table.html",
                                    "icon":"check",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"综合验证查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"综合验证列表(0)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"无网录入",
                                    "url":"./table.html",
                                    "icon":"sign-in-alt",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        },
                        {
                            "title":"厂商管理",
                            "url":"safe&t=5&n=1",
                            "id":"1",
                            "shiro":"a",
                            "items":[
                                {
                                    "title":"厂商",
                                    "url":"./table.html",
                                    "icon":"building",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"厂商录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"厂商查询(1779)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"证件",
                                    "url":"./table.html",
                                    "icon":"id-card-alt",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"证件录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"证件查询(3)",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"工程师",
                                    "url":"./table.html",
                                    "icon":"users-cog",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"设置外院维修工程师",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ],
            "items":[]
        },
        {
            "page":"beneft",
            "tools":[
                {
                    "title":"事前论证",
                    "icon":"thumbtack",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"可行性论证",
                            "url":"beneft&t=0&n=0",
                            "shiro":"a",
                            "id":"5",
                            "items":[
                                {
                                    "title":"经济效益论证",
                                    "url":"./table.html",
                                    "icon":"credit-card",
                                    "id":"51",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"项目方案录入",
                                            "url":"./beneft/prior-argument/scheme-input.html",
                                            "id":"52",
                                            "shiro":"a"
                                        },
                                        {
                                            "title": "项目论证结果",
                                            "url": "./table.html",
                                            "id": "53",
                                            "shiro": "a"
                                        },
                                        {
                                            "title":"项目财务指标",
                                            "url":"./table.html",
                                            "id":"54",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"设备与方案关联",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"效益评价结果",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"设备评价等级列表",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"事中监管",
                    "icon":"landmark",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"使用情况分析",
                            "url":"beneft&t=1&n=0",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"效率KPI",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"开机率",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"机时利用率",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"空转率",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"工作日平均闲置时间",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"效率等级",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"效率等级设置",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        },
                        {
                            "title":"成本效益分析",
                            "url":"beneft&t=1&n=1",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"设备成本效益分析",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"医疗设备成本效益分析评价",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"PACS明细查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"成本效益设置",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"设备成本科目预设",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"设备收入科目预设",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"设备成本属性设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"成本效益基础管理",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"内置科目",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"会计结账日设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"医疗风险基金设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"工作量监测",
                            "url":"beneft&t=1&n=2",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"跟踪监测",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"流失情况监测",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"增减变动监测",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"论证数据监测",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"管控结果",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"经济指标动态分析报告",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"综合统计",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"使用情况统计表",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"经济效益分析和评价报告",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"工作量设置",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"设备工作量设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"经济损失分析",
                            "url":"beneft&t=1&n=3",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"收入流失",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"收入流失分析",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"耗用超支",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"损耗超支分析",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"损失指标分析",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"经济损失指标分析",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"定期评价",
                    "icon":"user-edit",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"使用评价",
                            "url":"beneft&t=2&n=0",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"工作效率",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"机时利用率",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"完好率",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"配置效率",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"预测工作量符合率",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"功能利用率",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"运营效率",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"投资收益率",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"综合评价",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"综合评价",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"评价标准设置",
                                    "url":"./table.html",
                                    "icon":"clipboard-list",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"使用效率等级设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"完好等级设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"预测符合等级设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"功能利用等级设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"投资收益等级设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ],
            "items":[]
        },
        {
            "page":"admin",
            "tools":[
                {
                    "title":"基础管理",
                    "icon":"building",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"安全指标体系",
                            "url":"admin&t=0&n=0",
                            "shiro":"a",
                            "id":"6",
                            "items":[
                                {
                                    "title":"指标数据",
                                    "icon":"chart-line",
                                    "url":"./admin/basic-management/index-data.html",
                                    "id":"61",
                                    "shiro":"a"
                                },
                                {
                                    "title":"指标监视",
                                    "icon":"eye",
                                    "url":"./table.html",
                                    "id":"62",
                                    "shiro":"a"
                                },
                                {
                                    "title":"指标设置",
                                    "icon":"sliders-h",
                                    "url":"./table.html",
                                    "id":"63",
                                    "shiro":"a"
                                }
                            ]
                        },
                        {
                            "title":"组织机构管理",
                            "url":"admin&t=0&n=1",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"机构与岗位",
                                    "url":"./table.html",
                                    "icon":"chess-rook",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"机构管理",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"科室导入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"岗位管理",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"机构属性设置",
                                    "url":"./table.html",
                                    "icon":"sliders-h",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"部门类别设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"管理部门类别设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修部门设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"科室系统字典",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"规章制度管理",
                            "url":"admin&t=0&n=2",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"规章制度查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"已备案的规章制度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"试用中的规章制度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已停用的规章制度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"规章制度制定",
                                    "url":"./table.html",
                                    "icon":"pencil-alt",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"编写",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待审核",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待修改",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"试用中",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"规章制度再评价",
                                    "url":"./table.html",
                                    "icon":"comment-alt",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"待评价",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待修改",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待审核",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"试用中",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"进度查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"制定进度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"再评价进度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"规章制度模板",
                                    "url":"./table.html",
                                    "icon":"paperclip",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"模板列表",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"模板录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"岗位职责管理",
                            "url":"admin&t=0&n=3",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"岗位职责查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"已备案的岗位职责",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"试用中的岗位职责",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已停用的岗位职责",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"岗位职责制定",
                                    "url":"./table.html",
                                    "icon":"pencil-alt",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"编写",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待审核",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待修改",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"试用中",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"岗位职责再评价",
                                    "url":"./table.html",
                                    "icon":"comment-alt",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"待评价",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待修改",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待审核",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"试用中",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"进度查询",
                                    "url":"./table.html",
                                    "icon":"spinner",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"制定进度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"再评价进度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"规章制度模板",
                                    "url":"./table.html",
                                    "icon":"paperclip",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"模板列表",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"模板录入",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"科务管理",
                    "icon":"cogs",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"使用部门",
                            "url":"admin&t=1&n=0",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"科室团队分工",
                                    "url":"./table.html",
                                    "icon":"chalkboard-teacher",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"科室管理团队",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待审核管理团队",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已退回管理团队",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"科室团队成立进度",
                                    "url":"./table.html",
                                    "icon":"spinner",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"科室团队汇总",
                                    "url":"./table.html",
                                    "icon":"asterisk",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"科室质安管理团队汇总",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"质控管理员名单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"监测联络员名单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"科室资产管理人员名单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"计量管理员名单",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"未成立管理团队科室",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"设备管理",
                                    "url":"./table.html",
                                    "icon":"wrench",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"设备使用管理人授权",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"设备操作人授权",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"设备值班排版设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"设备存放设置",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title":"管理部门",
                            "url":"admin&t=1&n=1",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"维修分管设备划分",
                                    "url":"./table.html",
                                    "icon":"chalkboard-teacher",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"工程师负责部门划分",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"工程师负责部门查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修部门负责设备划分",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"维修部门负责设备查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"工程师负责设备划分",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"工程师负责设备查询",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"领导分管划分",
                                    "url":"./table.html",
                                    "icon":"chalkboard-teacher",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        },
                        {
                            "title":"员工管理",
                            "url":"admin&t=1&n=2",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"员工信息查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"员工信息导入",
                                    "url":"./table.html",
                                    "icon":"file-import",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"落实监督",
                    "icon":"eye",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"合规性检查",
                            "url":"admin&t=2&n=0",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"设备证照检查",
                                    "url":"./table.html",
                                    "icon":"check-square",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"设备证件导入",
                                    "url":"./table.html",
                                    "icon":"file-import",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"厂商多证导入",
                                    "url":"./table.html",
                                    "icon":"file-import",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"规章制度检查",
                                    "url":"./table.html",
                                    "icon":"check-square",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"设备状态及标识检查",
                                    "url":"./table.html",
                                    "icon":"check-square",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"机构与岗位职责检查",
                                    "url":"./table.html",
                                    "icon":"check-square",
                                    "id":"3",
                                    "shiro":"a"
                                },
                                {
                                    "title":"操作规程与应急预案检查",
                                    "url":"./table.html",
                                    "icon":"check-square",
                                    "id":"3",
                                    "shiro":"a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"改善提高",
                    "icon":"arrow-up",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"改善提案",
                            "url":"admin&t=3&n=0",
                            "shiro":"a",
                            "id":"1",
                            "items":[
                                {
                                    "title":"改善提案制订",
                                    "url":"./table.html",
                                    "icon":"pencil-alt",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"新建改善提案",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"已退回提案",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待受理提案",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"待审批提案",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                },
                                {
                                    "title":"改善提案查询",
                                    "url":"./table.html",
                                    "icon":"search",
                                    "id":"3",
                                    "shiro":"a",
                                    "list":[
                                        {
                                            "title":"提案制订进度",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        },
                                        {
                                            "title":"改善提案检查",
                                            "url":"./table.html",
                                            "id":"3",
                                            "shiro":"a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ],
            "items":[]
        },
        {
            "page":"system",
            "tools":[
                {
                    "title":"数据字典",
                    "icon":"database",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"数据字典",
                            "url":"system&t=0&n=0",
                            "shiro":"a",
                            "id":"6",
                            "items":[
                                {
                                    "title": "基础字典",
                                    "url": "./system/data-dictionary/basic.html",
                                    "icon":"book",
                                    "id": "61",
                                    "shiro": "a"
                                },
                                {
                                    "title": "专业字典",
                                    "url": "./system/data-dictionary/major.html",
                                    "icon":"torah",
                                    "id": "62",
                                    "shiro": "a"
                                },
                                {
                                    "title": "状态字典",
                                    "url": "./system/data-dictionary/state.html",
                                    "icon":"torah",
                                    "id": "63",
                                    "shiro": "a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"系统设置",
                    "icon":"hourglass-start",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"系统信息",
                            "url":"system&t=1&n=0",
                            "shiro":"a",
                            "id":"64",
                            "items":[
                                {
                                    "title": "LOGO设置",
                                    "url": "#",
                                    "id": "65",
                                    "shiro": "a"
                                },
                                {
                                    "title": "报表抬头设置",
                                    "url": "./table.html",
                                    "id": "66",
                                    "shiro": "a"
                                },
                                {
                                    "title": "文件版本设置",
                                    "url": "./table.html",
                                    "id": "67",
                                    "shiro": "a"
                                },
                                {
                                    "title": "短信猫设置",
                                    "url": "./table.html",
                                    "id": "68",
                                    "shiro": "a"
                                },
                                {
                                    "title": "作息时间",
                                    "url": "./table.html",
                                    "id": "69",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title":"设备设置",
                            "url":"system&t=1&n=1",
                            "shiro":"a",
                            "id":"610",
                            "items":[
                                {
                                    "title": "设备信息",
                                    "url": "./table.html",
                                    "icon":"info-circle",
                                    "id": "611",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设备信息查询",
                                            "url": "./system/system-setup/information-search.html",
                                            "id": "612",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备信息导入",
                                            "url": "./system/system-setup/information-import.html",
                                            "id": "613",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备信息录入",
                                            "url": "./system/system-setup/information-entry.html",
                                            "id": "614",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备附件信息导入",
                                            "url": "./table.html",
                                            "id": "615",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备附件信息录入",
                                            "url": "./table.html",
                                            "id": "616",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备属性扩展",
                                            "url": "./table.html",
                                            "id": "617",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备卫标分类设置",
                                            "url": "./table.html",
                                            "id": "618",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "卫标已关联设备",
                                            "url": "./table.html",
                                            "id": "619",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "设备确认",
                                    "url": "./table.html",
                                    "icon":"check-circle",
                                    "id": "620",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title":"系统提醒",
                            "url":"system&t=1&n=2",
                            "shiro":"a",
                            "id":"621",
                            "items":[
                                {
                                    "title": "提醒设置",
                                    "url": "./table.html",
                                    "icon":"sliders-h",
                                    "id": "622",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "提醒类别",
                                            "url": "./table.html",
                                            "id": "623",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "日期前提醒设置",
                                            "url": "./table.html",
                                            "id": "624",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "日期后提醒设置",
                                            "url": "./table.html",
                                            "id": "625",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "提醒信息",
                                    "url": "./table.html",
                                    "icon":"bell",
                                    "id": "626",
                                    "shiro": "a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"用户管理",
                    "icon":"users-cog",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"用户管理",
                            "url":"system&t=2&n=0",
                            "shiro":"a",
                            "id":"627",
                            "items":[
                                {
                                    "title": "用户设置",
                                    "url": "./system/user-management/user-setting.html",
                                    "icon":"sliders-h",
                                    "id": "628",
                                    "shiro": "a"
                                },
                                {
                                    "title": "角色设置",
                                    "url": "./system/user-management/role-setting.html",
                                    "icon":"users-cog",
                                    "id": "629",
                                    "shiro": "a"
                                },
                                {
                                    "title": "用户权限分配",
                                    "url": "./table.html",
                                    "icon":"user-lock",
                                    "id": "630",
                                    "shiro": "a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title":"门户管理",
                    "icon":"desktop",
                    "shiro":"a",
                    "content":[
                        {
                            "title":"公告",
                            "url":"system&t=3&n=0",
                            "shiro":"a",
                            "id":"631",
                            "items":[
                                {
                                    "title": "拟稿",
                                    "url": "./table.html",
                                    "icon":"pen",
                                    "id": "632",
                                    "shiro": "a"
                                },
                                {
                                    "title": "审核",
                                    "url": "./table.html",
                                    "icon":"clipboard-check",
                                    "id": "633",
                                    "shiro": "a"
                                },
                                {
                                    "title": "查询",
                                    "url": "./table.html",
                                    "icon":"search",
                                    "id": "634",
                                    "shiro": "a"
                                },
                                {
                                    "title": "公告类别管理",
                                    "url": "./table.html",
                                    "icon":"sliders-h",
                                    "id": "635",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title":"公共下载",
                            "url":"system&t=3&n=2",
                            "shiro":"a",
                            "id":"636",
                            "items":[
                                {
                                    "title": "拟稿",
                                    "url": "./table.html",
                                    "icon":"pen",
                                    "id": "637",
                                    "shiro": "a"
                                },
                                {
                                    "title": "审核",
                                    "url": "./table.html",
                                    "icon":"clipboard-check",
                                    "id": "638",
                                    "shiro": "a"
                                },{
                                    "title": "查询",
                                    "url": "./table.html",
                                    "icon":"search",
                                    "id": "639",
                                    "shiro": "a"
                                }
                            ]
                        }

                    ]
                }
            ],
            "items":[]
        }
    ];

var nav_list = [
    {
        "page":"data",
        "title":"数据收集",
        "icon":"fas fa-chart-bar"
    },
    {
        "page":"life",
        "title":"全寿命管理",
        "icon":"far fa-heart"
    },
    {
        "page":"safe",
        "title":"安全管理",
        "icon":"far fa-smile"
    },
    {
        "page":"beneft",
        "title":"效益管理",
        "icon":"far fa-gem"
    },
    {
        "page":"admin",
        "title":"行政管理",
        "icon":"fas fa-sitemap"
    },
    {
        "page":"system",
        "title":"系统管理",
        "icon":"fas fa-cogs"
    }
]