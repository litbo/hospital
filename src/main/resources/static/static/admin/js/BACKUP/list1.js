var main_list =
    [
        {
            "title": "首页",
            "url": "?p=home",
            "href": "?p=home",
            "id": "0",
            "icon": "home",
            "shiro": "a",
            "func": function () {
            }
        },
        {
            "page": "home",
            "tools": [],
            "items": [
                {
                    "title": "我的任务",
                    "url": "./home/my_task.html",
                    "id": "11",
                    "icon": "calendar-check",
                    "shiro": "a"
                },
                {
                    "title": "提醒事项",
                    "url": "./home/remind.html",
                    "id": "12",
                    "icon": "clipboard",
                    "shiro": "a"
                },
                {
                    "title": "共享信息",
                    "url": "javascript:void;",
                    "id": "13",
                    "icon": "star",
                    "shiro": "a",
                    "list": [
                        {
                            "title": "通知公告",
                            "url": "./home/announcement.html",
                            "id": "14",
                            "shiro": "a"
                        },
                        {
                            "title": "公共信息",
                            "url": "./home/public_info.html",
                            "id": "15",
                            "shiro": "a"
                        }
                    ]
                }
            ]
        },
        {
            "page": "data",
            "tools": [
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
                                    "url": "javascript:void;",
                                    "icon": "book-open",
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
                                    "title": "设备联网设置",
                                    "url": "javascript:void;",
                                    "icon": "network-wired",
                                    "id": "24",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设备联网设置",
                                            "url": "./data/network-sys/equip_network.html",
                                            "id": "25",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备值班排班设置",
                                            "url": "./data/network-sys/equip_work.html",
                                            "id": "26",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备加班设置",
                                            "url": "./data/network-sys/equip_overtime.html",
                                            "id": "27",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "核实工时设置",
                                            "url": "./data/network-sys/work_time.html",
                                            "id": "28",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "运行记录",
                                            "url": "./data/network-sys/run_record.html",
                                            "id": "29",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "原始记录",
                                            "url": "./data/network-sys/begin_record.html",
                                            "id": "30",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "工作量记录",
                            "url": "data&t=0&n=1",
                            "shiro": "a",
                            "id": "25",
                            'items': [
                                {
                                    "title": "设备工作量记录",
                                    "url": "javascript:void;",
                                    "id": "26",
                                    "icon": "industry",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "单机工作量",
                                            "url": "./data/network-sys/equip_worktime.html",
                                            "id": "27"
                                        },
                                        {
                                            "title": "科室设备工作量",
                                            "url": "./data/network-sys/room_worktime.html",
                                            "id": "28"
                                        },
                                        {
                                            "title": "同种设备工作量",
                                            "url": "./data/network-sys/same_worktime.html",
                                            "id": "29"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "实时监控",
                            "url": "http://www.baidu.com",
                            "id": "30",
                            "shiro": "a"
                        }
                    ]
                }
            ],
            "items": []
        },
        {
            "page": "life",
            "tools": [
                {
                    "title": "采购管理",
                    "icon": "shopping-cart",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "申购管理",
                            "url": "life&t=0&n=0",
                            "shiro": "a",
                            "id": "3",
                            "items": [
                                {
                                    "title": "科室申购",
                                    "url": "./table.html",
                                    "icon": "credit-card",
                                    "id": "31",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "科室讨论",
                                            "url": "./life/purchase-management/department-discuss.html",
                                            "id": "32",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "填写申购单",
                                            "url": "./life/purchase-management/write_purchase.html",
                                            "id": "33",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "科室汇总审核",
                                            "url": "./life/purchase-management/gather-audit.html",
                                            "id": "34",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "申购进度跟踪",
                                            "url": "./life/purchase-management/tracking-schedule.html",
                                            "id": "35",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "申购汇总",
                                    "url": "javascript:void(0);",
                                    "icon": "clipboard-list",
                                    "id": "36",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "申购单论证分析",
                                            "url": "./life/purchase-management/purchase-discuss.html",
                                            "id": "37",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "申购单汇总",
                                            "url": "./life/purchase-management/purchase-gather.html",
                                            "id": "38",
                                            "shiro": "a"
                                        }
                                        , {
                                            "title": "临时采购授权",
                                            "url": "./life/purchase-management/temp-buy.html",
                                            "id": "39",
                                            "shiro": "a"
                                        }

                                    ]
                                },
                                {
                                    "title": "集体讨论",
                                    "url": "javascript:void(0);",
                                    "icon": "comments",
                                    "id": "310",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "装备委员会记录",
                                            "url": "./life/purchase-management/equip-record.html",
                                            "id": "311",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "年度采购计划",
                                            "url": "./life/purchase-management/year-buy.html",
                                            "id": "312",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "院办公会记录",
                                            "url": "./life/purchase-management/hos-record.html",
                                            "id": "313",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "采购实施计划",
                                            "url": "./life/purchase-management/buy-plan.html",
                                            "id": "314",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "统计查询",
                                    "url": "javascript:void(0);",
                                    "icon": "comments",
                                    "id": "315",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "申购设备公示查询",
                                            "url": "./life/purchase-management/equipment-query.html",
                                            "id": "316",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "字典设置",
                                    "url": "javascript:void(0);",
                                    "icon": "comments",
                                    "id": "317",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "申购讨论条件",
                                            "url": "./table.html",
                                            "id": "318",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "论证分析金额设置",
                                            "url": "./table.html",
                                            "id": "319",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "招标采购",
                            "url": "life&t=0&n=1",
                            "shiro": "a",
                            "id": "320",
                            "items": [
                                {
                                    "title": "招标采购",
                                    "url": "./table.html",
                                    "icon": "shopping-cart",
                                    "id": "321",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "计划打包",
                                            "url": "./table.html",
                                            "id": "322",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "中标录入",
                                            "url": "./table.html",
                                            "id": "323",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "合同录入",
                                            "url": "./table.html",
                                            "id": "324",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "合同查询",
                                            "url": "./table.html",
                                            "id": "325",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "验收管理",
                            "url": "life&t=0&n=2",
                            "id": "333",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "到货登记",
                                    "url": "./life/purchase-management/goods-reg.html",
                                    "icon": "solar-panel",
                                    "id": "334",
                                    "shiro": "a"
                                },
                                {
                                    "title": "科室验收",
                                    "url": "./life/purchase-management/room-reg.html",
                                    "icon": "user-md",
                                    "id": "335",
                                    "shiro": "a"
                                },
                                {
                                    "title": "设备验收",
                                    "url": "./life/purchase-management/equip-reg.html",
                                    "icon": "drafting-compass",
                                    "id": "336",
                                    "shiro": "a"
                                },
                                {
                                    "title": "统计查询",
                                    "url": "./table.html",
                                    "icon": "chart-pie",
                                    "id": "337",
                                    "shiro": "a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "使用管理",
                    "icon": "mouse-pointer",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "操作规程",
                            "url": "life&t=1&n=0",
                            "id": "338",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "操作规程查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "339",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "已备案操作规程",
                                            "url": "./life/use-management/record-rule.html",
                                            "id": "340",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "试用中操作规程",
                                            "url": "./life/use-management/test-rule.html",
                                            "id": "341",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已停用操作规程",
                                            "url": "./life/use-management/banned-rule.html",
                                            "id": "342",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "操作规程制定",
                                    "url": "javascript",
                                    "icon": "pencil-alt",
                                    "shiro": "a",
                                    "id": "343",
                                    "list": [
                                        {
                                            "title": "编写",
                                            "url": "./life/use-management/edit-rule.html",
                                            "id": "344",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "操作规程制定流程",
                                            "url": "./life/use-management/process-rule.html",
                                            "id": "345",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "操作规程再评价",
                                    "url": "./table.html",
                                    "icon": "comment-alt",
                                    "id": "346",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "操作规程再评价流程",
                                            "url": "./life/use-management/again-rule.html",
                                            "id": "347",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "进度查询",
                                    "url": "./table.html",
                                    "icon": "spinner",
                                    "id": "348",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "制定进度",
                                            "url": "./life/use-management/process-edit.html",
                                            "id": "349",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "再评价进度",
                                            "url": "./life/use-management/process-again.html",
                                            "id": "350",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "操作规程模板",
                                    "url": "./table.html",
                                    "id": "351",
                                    "icon": "paperclip",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "模板列表",
                                            "url": "./life/use-management/modern-list.html",
                                            "id": "352",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "录入模板",
                                            "url": "./life/use-management/modern-edit.html",
                                            "id": "353",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "电子台账",
                            "url": "life&t=1&n=1",
                            "id": "354",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "设备台账",
                                    "url": "./table.html",
                                    "id": "355",
                                    "icon": "file-invoice-dollar",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "总账",
                                            "url": "./life/electric-bill/bill-list.html",
                                            "id": "356",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "分户账",
                                            "url": "./life/electric-bill/bill-hueman.html",
                                            "id": "357",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "分类账",
                                            "url": "./life/electric-bill/bill-type.html",
                                            "id": "358",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "账实核对",
                                    "url": "./table.html",
                                    "icon": "clipboard-check",
                                    "id": "359",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "计划制定",
                                            "url": "./life/electric-bill/plan-write.html",
                                            "id": "360",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "计划查询",
                                            "url": "./life/electric-bill/plan-search.html",
                                            "id": "361",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "账实核对",
                                            "url": "./life/electric-bill/purchase-check.html",
                                            "id": "362",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "核实对比",
                                            "url": "./life/electric-bill/compere-com.html",
                                            "id": "363",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "查询统计",
                                    "url": "./table.html",
                                    "icon": "chart-pie",
                                    "id": "364",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "科室设备综合查询",
                                            "url": "./table.html",
                                            "id": "365",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "综合查询",
                                            "url": "./table.html",
                                            "id": "366",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "综合统计",
                                            "url": "./table.html",
                                            "id": "367",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "字典设置",
                                    "url": "./table.html",
                                    "icon": "stamp",
                                    "id": "368",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设备金额档设置",
                                            "url": "./table.html",
                                            "id": "369",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "其他台账",
                                    "url": "./life/electric-bill/bill-list-qt.html",
                                    "icon": "file-invoice-dollar",
                                    "id": "370",
                                    "shiro": "a"
                                }

                            ]
                        }
                    ]
                },
                {
                    "title": "应急管理",
                    "icon": "exclamation-triangle",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "应急预案",
                            "url": "life&t=2&n=0",
                            "id": "371",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "应急预案查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "372",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "已备案",
                                            "url": "./table.html",
                                            "id": "373",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "试用中",
                                            "url": "./table.html",
                                            "id": "374",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已弃用",
                                            "url": "./table.html",
                                            "id": "375",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "应急预案制定",
                                    "url": "./table.html",
                                    "icon": "pencil-alt",
                                    "id": "376",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "开始指定",
                                            "url": "./table.html",
                                            "id": "377",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "制订收件箱",
                                            "url": "./table.html",
                                            "id": "378",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "应急预案再评价",
                                    "url": "./table.html",
                                    "icon": "comment-alt",
                                    "id": "379",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "再评价收件箱",
                                            "url": "./table.html",
                                            "id": "380",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "进度查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "381",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "制订进度",
                                            "url": "./table.html",
                                            "id": "382",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "再评价进度",
                                            "url": "./table.html",
                                            "id": "383",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "模板录入和查询",
                                    "url": "./table.html",
                                    "icon": "paperclip",
                                    "id": "384",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "模板录入",
                                            "url": "./table.html",
                                            "id": "385",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "模板列表",
                                            "url": "./table.html",
                                            "id": "386",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "应急替代",
                            "url": "life&t=2&n=1",
                            "id": "387",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "紧急报停",
                                    "url": "./table.html",
                                    "icon": "minus-circle",
                                    "id": "388",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "紧急报停搜查",
                                            "url": "./table.html",
                                            "id": "389",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "替代设备搜查",
                                    "url": "./table.html",
                                    "icon": "screwdriver",
                                    "id": "390",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "搜查设备",
                                            "url": "./table.html",
                                            "id": "391",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "设备替换完成",
                                    "url": "./table.html",
                                    "icon": "check",
                                    "id": "392",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "等待替换",
                                            "url": "./table.html",
                                            "id": "393",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "替换完成",
                                            "url": "./table.html",
                                            "id": "394",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "病人安置记录",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "395",
                                    "shiro": "a"
                                },
                                {
                                    "title": "总结报告",
                                    "url": "./table.html",
                                    "icon": "flag",
                                    "id": "396",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "总结评价",
                                            "url": "./table.html",
                                            "id": "397",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "应急替代报告",
                                            "url": "./table.html",
                                            "id": "398",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "查询&统计",
                                    "url": "./table.html",
                                    "icon": "chart-pie",
                                    "id": "399",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "搜查结果查询",
                                            "url": "./table.html",
                                            "id": "3991",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "应急调配",
                            "url": "life&t=2&n=2",
                            "id": "3992",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "设备调配",
                                    "url": "./table.html",
                                    "icon": "puzzle-piece",
                                    "id": "3993",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "查询调用",
                                            "url": "./table.html",
                                            "id": "3994",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "设备送达",
                                    "url": "./table.html",
                                    "icon": "check-circle",
                                    "id": "3995",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "未送达调配单",
                                            "url": "./table.html",
                                            "id": "3996",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已送达调配单",
                                            "url": "./table.html",
                                            "id": "3997",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "设备归还",
                                    "url": "./table.html",
                                    "icon": "undo-alt",
                                    "id": "3998",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "收条",
                                            "url": "./table.html",
                                            "id": "3999",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "调配跟踪",
                                    "url": "./table.html",
                                    "icon": "umbrella-beach",
                                    "id": "39910",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "调配跟踪",
                                            "url": "./table.html",
                                            "id": "39911",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "使用监视",
                                            "url": "./table.html",
                                            "id": "39912",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "汇总考评",
                                    "url": "./table.html",
                                    "icon": "envelope-open-text",
                                    "id": "39913",
                                    "shiro": "a"
                                },
                                {
                                    "title": "查询&统计",
                                    "url": "./table.html",
                                    "icon": "chart-pie",
                                    "id": "39914",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "事件查询",
                                            "url": "./table.html",
                                            "id": "39915",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "统计报表",
                                            "url": "./table.html",
                                            "id": "39916",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]

                },
                {
                    "title": "处置管理",
                    "icon": "compact-disc",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "处置管理",
                            "url": "life&t=3&n=0",
                            "id": "39917",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "处置查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "39918",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "处置查询",
                                            "url": "./table.html",
                                            "id": "39919",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待报废清单",
                                            "url": "./table.html",
                                            "id": "39920",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已报废清单",
                                            "url": "./table.html",
                                            "id": "39921",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "处置申请",
                                    "url": "./table.html",
                                    "icon": "rocket",
                                    "id": "39922",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "处置申请",
                                            "url": "./table.html",
                                            "id": "39923",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "处置任务",
                                            "url": "./table.html",
                                            "id": "39924",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "处置上报",
                                    "url": "./table.html",
                                    "icon": "arrow-up",
                                    "id": "39925",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "待上报列表",
                                            "url": "./table.html",
                                            "id": "39926",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "处置批复",
                                    "url": "./table.html",
                                    "icon": "calendar-check",
                                    "id": "39927",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "待批复列表",
                                            "url": "./table.html",
                                            "id": "39928",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "处置清理",
                                    "url": "./table.html",
                                    "icon": "broom",
                                    "id": "39929",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "待清理设备",
                                            "url": "./table.html",
                                            "id": "39930",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "处置备案",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "39931",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "待备案处置设备",
                                            "url": "./table.html",
                                            "id": "39932",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ],
            "items": []
        },
        {
            "page": "safe",
            "tools": [
                {
                    "title": "风险管理",
                    "icon": "exclamation-triangle",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "风险管理",
                            "url": "safe&t=0&n=0",
                            "shiro": "a",
                            "id": "4",
                            "items": [
                                {
                                    "title": "风险分析",
                                    "url": "./table.html",
                                    "icon": "poll",
                                    "id": "41",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "风险分值定义",
                                            "url": "./table.html",
                                            "id": "42",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "风险等级",
                                            "url": "./safe/risk-management/risk-rating.html",
                                            "id": "43",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "风险评价",
                                    "url": "./table.html",
                                    "icon": "user-edit",
                                    "id": "44",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "风险监测",
                                            "url": "./table.html",
                                            "id": "45",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "风险预警",
                                            "url": "./table.html",
                                            "id": "46",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "实时监视",
                                            "url": "./table.html",
                                            "id": "47",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "风险控制",
                                    "url": "./table.html",
                                    "icon": "sliders-h",
                                    "id": "48",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "风险控制实施",
                                            "url": "./table.html",
                                            "id": "49",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "质控等级目录",
                                            "url": "./table.html",
                                            "id": "410",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "分级风控方案",
                                            "url": "./table.html",
                                            "id": "411",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备风控单",
                                            "url": "./table.html",
                                            "id": "412",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "维修管理",
                    "icon": "wrench",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "设备维修",
                            "url": "safe&t=1&n=0",
                            "id": "413",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "维修任务",
                                    "url": "./table.html",
                                    "icon": "wrench",
                                    "id": "414",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "报修",
                                            "url": "./safe/service-management/repair.html",
                                            "id": "415",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修任务",
                                            "url": "./safe/service-management/servicing-task.html",
                                            "id": "416",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修费申请",
                                            "url": "./safe/service-management/repair-apply.html",
                                            "id": "417",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "满意度再评价",
                                            "url": "./table.html",
                                            "id": "418",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "补录维修报告",
                                            "url": "./safe/service-management/additional-record.html",
                                            "id": "419",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "查询&统计",
                                    "url": "./table.html",
                                    "icon": "chart-pie",
                                    "id": "420",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "工程师工作情况",
                                            "url": "./table.html",
                                            "id": "421",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "信息设备维修查询",
                                            "url": "./table.html",
                                            "id": "422",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修查询",
                                            "url": "./table.html",
                                            "id": "423",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "本科维修费汇总",
                                            "url": "./table.html",
                                            "id": "424",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "综合查询",
                                            "url": "./table.html",
                                            "id": "425",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "字典管理",
                                    "url": "./table.html",
                                    "icon": "book",
                                    "id": "426",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "配件字典",
                                            "url": "./table.html",
                                            "id": "427",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修字典",
                                            "url": "./table.html",
                                            "id": "428",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "简称配置故障现象",
                                            "url": "./table.html",
                                            "id": "429",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "维修设置",
                                    "url": "./table.html",
                                    "icon": "sliders-h",
                                    "id": "430",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "反馈信息设置",
                                            "url": "./table.html",
                                            "id": "431",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "辅助维修工程师来源设置",
                                            "url": "./table.html",
                                            "id": "432",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "配件清零设置",
                                            "url": "./table.html",
                                            "id": "433",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修短信提醒设置",
                                            "url": "./table.html",
                                            "id": "434",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "报修审核设置",
                                            "url": "./table.html",
                                            "id": "435",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修签到设置",
                                            "url": "./table.html",
                                            "id": "436",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "科室确认环节停留时间设置",
                                            "url": "./table.html",
                                            "id": "437",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修审核环节启用设置",
                                            "url": "./table.html",
                                            "id": "438",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "领导分管设置",
                                            "url": "./table.html",
                                            "id": "439",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "院外维修工程师用户管理",
                                            "url": "./table.html",
                                            "id": "4391",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "维修实时监控",
                                    "url": "./table.html",
                                    "icon": "eye",
                                    "id": "4392",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "维修合同",
                            "url": "safe&t=1&n=1",
                            "id": "4393",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "报修合同",
                                    "url": "./table.html",
                                    "icon": "scroll",
                                    "id": "4394",
                                    "list": [
                                        {
                                            "title": "合同录入",
                                            "url": "./safe/service-management/contract-input1.html",
                                            "id": "4395",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "合同支付",
                                            "url": "./safe/service-management/contract-payment.html",
                                            "id": "4396",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "合同查询",
                                            "url": "./safe/service-management/contract-search.html",
                                            "id": "4397",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "维修配件",
                            "url": "safe&t=1&n=2",
                            "id": "4398",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "配件申购",
                                    "url": "./safe/service-management/accessories-purchase.html",
                                    "icon": "shopping-cart",
                                    "id": "4399",
                                    "shiro": "a"
                                },
                                {
                                    "title": "配件入库",
                                    "url": "./table.html",
                                    "icon": "university",
                                    "id": "43910",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "配件入库",
                                            "url": "./safe/service-management/accessories-in.html",
                                            "id": "43911",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "申购入库",
                                            "url": "./safe/service-management/purchase-input.html",
                                            "id": "43912",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "配件出库",
                                    "url": "./safe/service-management/accessories-out.html",
                                    "icon": "sign-out-alt",
                                    "id": "43913",
                                    "shiro": "a"
                                },
                                {
                                    "title": "配件退库",
                                    "url": "./table.html",
                                    "id": "43914",
                                    "icon": "gavel",
                                    "shiro": "a"
                                },
                                {
                                    "title": "配件查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "43915",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "入库查询",
                                            "url": "./safe/service-management/ruku-search.html",
                                            "id": "43916",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "出库查询",
                                            "url": "./safe/service-management/chuku-search.html",
                                            "id": "43917",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "库存查询",
                                            "url": "./safe/service-management/stock-check.html",
                                            "id": "43918",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "退库查询",
                                            "url": "./table.html",
                                            "id": "43919",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "供货商查询",
                                            "url": "./table.html",
                                            "id": "43920",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "配件字典",
                                    "url": "./safe/service-management/accessories-dictionary.html",
                                    "icon": "torah",
                                    "id": "43921",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "维修发票",
                            "url": "safe&t=1&n=3",
                            "id": "43922",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "维修发票管理",
                                    "url": "./table.html",
                                    "id": "43923",
                                    "icon": "receipt",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "维修发票登记",
                                            "url": "./safe/maintenance-management/invoice-registration.html",
                                            "id": "43924",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修发票审核",
                                            "url": "./safe/maintenance-management/invoice-audit.html",
                                            "id": "43925",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修发票查询",
                                            "url": "./safe/maintenance-management/invoice-inquiry.html",
                                            "id": "43926",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "应用培训",
                    "icon": "graduation-cap",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "人员培训",
                            "url": "safe&t=2&n=0",
                            "id": "43927",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "培训计划",
                                    "url": "./table.html",
                                    "id": "43928",
                                    "icon": "scroll",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "计划制定",
                                            "url": "./safe/application-training/plan-formulation.html",
                                            "id": "43929",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "人员档案",
                                    "url": "./table.html",
                                    "icon": "user-tag",
                                    "id": "43930",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "人员名单",
                                            "url": "./table.html",
                                            "id": "43931",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待训人员",
                                            "url": "./table.html",
                                            "id": "43932",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "人员录入",
                                            "url": "./safe/application-training/personnel-input.html",
                                            "id": "43933",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "培训过程",
                                    "url": "./table.html",
                                    "icon": "user-clock",
                                    "id": "43934",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "签到",
                                            "url": "./table.html",
                                            "id": "43935",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "考核",
                                            "url": "./table.html",
                                            "id": "43936",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "颁证",
                                            "url": "./table.html",
                                            "id": "43937",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "培训查询",
                                    "url": "./table.html",
                                    "icon": "user-friends",
                                    "id": "43938",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "计划查询",
                                            "url": "./safe/application-training/plan-query.html",
                                            "id": "43939",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "人员上岗资质",
                                            "url": "./table.html",
                                            "id": "43940",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备上岗资质",
                                            "url": "./table.html",
                                            "id": "43941",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "医疗事件",
                    "icon": "briefcase-medical",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "安全(不良)事件",
                            "url": "safe&t=3&n=0",
                            "id": "43942",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "不良事件报告",
                                    "url": "./table.html",
                                    "icon": "file-powerpoint",
                                    "id": "43943",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "可疑报告",
                                            "url": "./safe/medical-incident/suspicious-report.html",
                                            "id": "43944",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "网络直报",
                                            "url": "./table.html",
                                            "id": "43945",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "报告反馈",
                                            "url": "./table.html",
                                            "id": "43946",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "泄械控制",
                                            "url": "./table.html",
                                            "id": "43947",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "统计查询",
                                    "url": "./table.html",
                                    "icon": "chart-pie",
                                    "id": "43948",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "报告查询",
                                            "url": "./safe/medical-incident/report-query.html",
                                            "id": "43949",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "综合查询",
                                            "url": "./table.html",
                                            "id": "43950",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "综合统计",
                                            "url": "./table.html",
                                            "id": "43951",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "质量管理",
                    "icon": "feather",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "维护保养",
                            "url": "safe&t=4&n=0",
                            "id": "43952",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "维护保养规范",
                                    "url": "./table.html",
                                    "id": "43953",
                                    "icon": "newspaper",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "保养规范",
                                            "url": "./table.html",
                                            "id": "43954",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "规范编制",
                                            "url": "./table.html",
                                            "id": "43955",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "编制任务",
                                            "url": "./table.html",
                                            "id": "43956",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "维护保养计划",
                                    "url": "./table.html",
                                    "icon": "scroll",
                                    "id": "43957",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "常规保养计划",
                                            "url": "./table.html",
                                            "id": "43958",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "预防性维护计划",
                                            "url": "./table.html",
                                            "id": "43959",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "维护保养任务",
                                    "url": "./table.html",
                                    "icon": "map",
                                    "id": "43960",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "预防性维护待执行任务",
                                            "url": "./table.html",
                                            "id": "43961",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "常规保养待执行任务",
                                            "url": "./table.html",
                                            "id": "43962",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已执行任务",
                                            "url": "./table.html",
                                            "id": "43963",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "统计查询",
                                    "url": "./table.html",
                                    "icon": "chart-pie",
                                    "id": "43964",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "综合查询",
                                            "url": "./table.html",
                                            "id": "43965",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "统计报表",
                                            "url": "./table.html",
                                            "id": "43966",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "维护保养设置",
                                    "url": "./table.html",
                                    "icon": "sliders-h",
                                    "id": "43967",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "设备质检",
                            "url": "safe&t=4&n=1",
                            "id": "43968",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "检测计划",
                                    "url": "./table.html",
                                    "id": "43969",
                                    "icon": "scroll",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "计划制定",
                                            "url": "./table.html",
                                            "id": "43970",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "计划修改",
                                            "url": "./table.html",
                                            "id": "43971",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "计划查询",
                                            "url": "./table.html",
                                            "id": "43972",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "检测任务",
                                    "url": "./table.html",
                                    "icon": "newspaper",
                                    "id": "43973",
                                    "shiro": "a"
                                },
                                {
                                    "title": "计划实施查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "43974",
                                    "shiro": "a"
                                },
                                {
                                    "title": "质量检测项目设置",
                                    "url": "./table.html",
                                    "icon": "sliders-h",
                                    "id": "43975",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "设备巡检",
                            "url": "safe&t=4&n=2",
                            "id": "43976",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "巡检计划",
                                    "url": "./table.html",
                                    "icon": "scroll",
                                    "id": "43977",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "计划制定",
                                            "url": "./table.html",
                                            "id": "43978",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "计划修改",
                                            "url": "./table.html",
                                            "id": "43979",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "计划查询",
                                            "url": "./table.html",
                                            "id": "43980",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "巡检任务",
                                    "url": "./table.html",
                                    "icon": "newspaper",
                                    "id": "43981",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设备巡检",
                                            "url": "./table.html",
                                            "id": "43982",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "计划实施查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "43983",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "设备计量",
                            "url": "safe&t=4&n=4398",
                            "id": "43984",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "查询统计",
                                    "url": "./table.html",
                                    "icon": "chart-pie",
                                    "id": "43985",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "综合查询",
                                            "url": "./table.html",
                                            "id": "43986",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "综合统计",
                                            "url": "./table.html",
                                            "id": "43987",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "计量器具信息",
                                    "url": "./table.html",
                                    "icon": "info",
                                    "id": "43988",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "总账",
                                            "url": "./table.html",
                                            "id": "43989",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "分户账",
                                            "url": "./table.html",
                                            "id": "43990",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "报废账",
                                            "url": "./table.html",
                                            "id": "43991",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "计量台账录入",
                                            "url": "./table.html",
                                            "id": "43992",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "计量任务",
                                    "url": "./table.html",
                                    "icon": "newspaper",
                                    "id": "43993",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "检定提醒",
                                            "url": "./table.html",
                                            "id": "43994",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "送检申请",
                                            "url": "./table.html",
                                            "id": "43995",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "送检审批",
                                            "url": "./table.html",
                                            "id": "43996",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "检定结果录入",
                                            "url": "./table.html",
                                            "id": "43997",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "检定结果导入",
                                            "url": "./table.html",
                                            "id": "43998",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "计量查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "43999",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "已送检计量器具清单",
                                            "url": "./table.html",
                                            "id": "439910",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已鉴定计量器具清单",
                                            "url": "./table.html",
                                            "id": "439911",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "特种设备",
                            "url": "safe&t=4&n=4",
                            "id": "439912",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "特种设备台账",
                                    "url": "./table.html",
                                    "icon": "file-invoice-dollar",
                                    "id": "439913",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "特种设备",
                                            "url": "./table.html",
                                            "id": "439914",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "安全附件",
                                            "url": "./table.html",
                                            "id": "439915",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "特种设备录入",
                                            "url": "./table.html",
                                            "id": "439916",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "特种设备检测",
                                    "url": "./table.html",
                                    "icon": "check-square",
                                    "id": "439917",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "检测计划",
                                            "url": "./table.html",
                                            "id": "439918",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "送检任务",
                                            "url": "./table.html",
                                            "id": "439919",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "送检申请",
                                            "url": "./table.html",
                                            "id": "439920",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "送检审批",
                                            "url": "./table.html",
                                            "id": "439921",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "结果录入",
                                            "url": "./table.html",
                                            "id": "439922",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "结果查看",
                                            "url": "./table.html",
                                            "id": "439923",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "特种设备从业人员",
                                    "url": "./table.html",
                                    "id": "439924",
                                    "icon": "user",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "从业人员",
                                            "url": "./table.html",
                                            "id": "439925",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "人员设置",
                                            "url": "./table.html",
                                            "id": "439926",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "证件到期提醒",
                                            "url": "./table.html",
                                            "id": "439927",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "厂商管理",
                    "icon": "building",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "资质审核",
                            "url": "safe&t=5&n=0",
                            "id": "439928",
                            "shiro": "a",
                            'items': [
                                {
                                    "title": "使用说明",
                                    "url": "./safe/facturer-management/instructions.html\n",
                                    "icon": "info",
                                    "id": "439929",
                                    "shiro": "a"
                                },
                                {
                                    "title": "单证验证",
                                    "url": "./table.html",
                                    "icon": "user-check",
                                    "id": "439930",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "经营/生产许可证",
                                            "url": "./safe/facturer-management/business-license.html",
                                            "id": "439931",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "产品注册证",
                                            "url": "./safe/facturer-management/registration-certificate.html",
                                            "id": "439932",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "单证验证查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "439933",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "许可证列表",
                                            "url": "./safe/facturer-management/license-list.html",
                                            "id": "439934",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "注册证列表",
                                            "url": "./safe/facturer-management/registration-list.html",
                                            "id": "439935",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "综合验证",
                                    "url": "./safe/facturer-management/comprehensive-verification.html",
                                    "icon": "check",
                                    "id": "439936",
                                    "shiro": "a"
                                },
                                {
                                    "title": "综合验证查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "439937",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "综合验证列表",
                                            "url": "./table.html",
                                            "id": "439938",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "无网录入",
                                    "url": "./table.html",
                                    "icon": "sign-in-alt",
                                    "id": "439939",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "厂商管理",
                            "url": "safe&t=5&n=1",
                            "id": "439940",
                            "shiro": "a",
                            "items": [
                                {
                                    "title": "厂商",
                                    "url": "./table.html",
                                    "icon": "building",
                                    "id": "439941",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "厂商录入",
                                            "url": "./table.html",
                                            "id": "439942",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "厂商查询",
                                            "url": "./table.html",
                                            "id": "439943",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "证件",
                                    "url": "./table.html",
                                    "icon": "id-card-alt",
                                    "id": "439944",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "证件录入",
                                            "url": "./table.html",
                                            "id": "439945",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "证件查询",
                                            "url": "./table.html",
                                            "id": "439946",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "工程师",
                                    "url": "./table.html",
                                    "icon": "users-cog",
                                    "id": "439947",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设置外院维修工程师",
                                            "url": "./table.html",
                                            "id": "439948",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ],
            "items": []
        },
        {
            "page": "beneft",
            "tools": [
                {
                    "title": "事前论证",
                    "icon": "thumbtack",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "可行性论证",
                            "url": "beneft&t=0&n=0",
                            "shiro": "a",
                            "id": "5",
                            "items": [
                                {
                                    "title": "经济效益论证",
                                    "url": "./table.html",
                                    "icon": "credit-card",
                                    "id": "51",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "项目方案录入",
                                            "url": "./beneft/prior-argument/scheme-input.html",
                                            "id": "52",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "项目论证结果",
                                            "url": "./beneft/prior-argument/argument-result.html",
                                            "id": "53",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "项目财务指标",
                                            "url": "./beneft/prior-argument/financial-index.html",
                                            "id": "54",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备与方案关联",
                                            "url": "./beneft/prior-argument/scheme-association.html",
                                            "id": "55",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "效益评价结果",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "56",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设备评价等级列表",
                                            "url": "./beneft/prior-argument/evaluate-list.html",
                                            "id": "57",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "事中监管",
                    "icon": "landmark",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "使用情况分析",
                            "url": "beneft&t=1&n=0",
                            "shiro": "a",
                            "id": "58",
                            "items": [
                                {
                                    "title": "效率KPI",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "59",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "开机率",
                                            "url": "./beneft/usage-situation/boot-rate.html",
                                            "id": "510",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "机时利用率",
                                            "url": "./beneft/usage-situation/utilization-ratio.html",
                                            "id": "511",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "空转率",
                                            "url": "./beneft/usage-situation/idling-rate.html",
                                            "id": "512",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "工作日平均闲置时间",
                                            "url": "./beneft/usage-situation/average-time.html",
                                            "id": "513",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "效率等级",
                                    "url": "./beneft/usage-situation/efficiency-level.html",
                                    "icon": "clipboard-list",
                                    "id": "514",
                                    "shiro": "a"
                                },
                                {
                                    "title": "效率等级设置",
                                    "url": "./beneft/usage-situation/set-efficiency-level.html",
                                    "icon": "clipboard-list",
                                    "id": "515",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "成本效益分析",
                            "url": "beneft&t=1&n=1",
                            "shiro": "a",
                            "id": "516",
                            "items": [
                                {
                                    "title": "设备成本效益分析",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "517",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "医疗设备成本效益分析评价",
                                            "url": "./beneft/cost-benefit/analysis-evaluation.html",
                                            "id": "518",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "PACS明细查询",
                                            "url": "./beneft/cost-benefit/pacs-check.html",
                                            "id": "519",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "成本效益设置",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "520",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设备成本科目预设",
                                            "url": "./beneft/cost-benefit/set-equipmentcost-subject.html",
                                            "id": "521",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备收入科目预设",
                                            "url": "./beneft/cost-benefit/set-equipment-income.html",
                                            "id": "522",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备成本属性设置",
                                            "url": "./table.html",
                                            "id": "523",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "成本效益基础管理",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "524",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "内置科目",
                                            "url": "./beneft/cost-benefit/internal-subjects.html",
                                            "id": "525",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "会计结账日设置",
                                            "url": "./table.html",
                                            "id": "526",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "医疗风险基金设置",
                                            "url": "./table.html",
                                            "id": "527",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "工作量监测",
                            "url": "beneft&t=1&n=2",
                            "shiro": "a",
                            "id": "528",
                            "items": [
                                {
                                    "title": "跟踪监测",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "529",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "流失情况监测",
                                            "url": "./beneft/sz-supervise/wastage.html",
                                            "id": "530",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "增减变动监测",
                                            "url": "./beneft/sz-supervise/increase-decrease.html",
                                            "id": "531",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "论证数据监测",
                                            "url": "./beneft/sz-supervise/argument-data.html",
                                            "id": "532",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "管控结果",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "533",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "经济指标动态分析报告",
                                            "url": "./beneft/sz-supervise/economic-indicator.html",
                                            "id": "534",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "综合统计",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "535",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "使用情况统计表",
                                            "url": "./beneft/sz-supervise/service-condition.html",
                                            "id": "536",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "经济效益分析和评价报告",
                                            "url": "./beneft/sz-supervise/economic-benefit.html",
                                            "id": "537",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "工作量设置",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "538",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设备工作量设置",
                                            "url": "./beneft/sz-supervise/device-work.html",
                                            "id": "539",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "经济损失分析",
                            "url": "beneft&t=1&n=3",
                            "shiro": "a",
                            "id": "540",
                            "items": [
                                {
                                    "title": "收入流失",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "541",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "收入流失分析",
                                            "url": "./beneft/sz-supervise/income-lose.html",
                                            "id": "542",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "耗用超支",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "543",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "损耗超支分析",
                                            "url": "./beneft/sz-supervise/overspending.html",
                                            "id": "544",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "损失指标分析",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "545",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "经济损失指标分析",
                                            "url": "./beneft/sz-supervise/economic-loss.html",
                                            "id": "546",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "定期评价",
                    "icon": "user-edit",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "使用评价",
                            "url": "beneft&t=2&n=0",
                            "shiro": "a",
                            "id": "547",
                            "items": [
                                {
                                    "title": "工作效率",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "548",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "机时利用率",
                                            "url": "./table.html",
                                            "id": "549",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "完好率",
                                            "url": "./table.html",
                                            "id": "550",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "配置效率",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "551",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "预测工作量符合率",
                                            "url": "./table.html",
                                            "id": "552",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "功能利用率",
                                            "url": "./table.html",
                                            "id": "553",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "运营效率",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "554",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "投资收益率",
                                            "url": "./table.html",
                                            "id": "555",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "综合评价",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "556",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "综合评价",
                                            "url": "./table.html",
                                            "id": "557",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "评价标准设置",
                                    "url": "./table.html",
                                    "icon": "clipboard-list",
                                    "id": "558",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "使用效率等级设置",
                                            "url": "./table.html",
                                            "id": "559",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "完好等级设置",
                                            "url": "./table.html",
                                            "id": "561",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "预测符合等级设置",
                                            "url": "./table.html",
                                            "id": "562",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "功能利用等级设置",
                                            "url": "./table.html",
                                            "id": "563",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "投资收益等级设置",
                                            "url": "./table.html",
                                            "id": "564",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ],
            "items": []
        },
        {
            "page": "admin",
            "tools": [
                {
                    "title": "基础管理",
                    "icon": "building",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "安全指标体系",
                            "url": "admin&t=0&n=0",
                            "shiro": "a",
                            "id": "6",
                            "items": [
                                {
                                    "title": "指标数据",
                                    "icon": "chart-line",
                                    "url": "./admin/basic-management/index-data.html",
                                    "id": "61",
                                    "shiro": "a"
                                },
                                {
                                    "title": "指标监视",
                                    "icon": "eye",
                                    "url": "./table.html",
                                    "id": "62",
                                    "shiro": "a"
                                },
                                {
                                    "title": "指标设置",
                                    "icon": "sliders-h",
                                    "url": "./table.html",
                                    "id": "63",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "组织机构管理",
                            "url": "admin&t=0&n=1",
                            "shiro": "a",
                            "id": "64",
                            "items": [
                                {
                                    "title": "机构与岗位",
                                    "url": "./table.html",
                                    "icon": "chess-rook",
                                    "id": "65",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "机构管理",
                                            "url": "./table.html",
                                            "id": "66",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "科室导入",
                                            "url": "./table.html",
                                            "id": "67",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "岗位管理",
                                            "url": "./admin/basic-management/position-management.html",
                                            "id": "68",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "机构属性设置",
                                    "url": "./table.html",
                                    "icon": "sliders-h",
                                    "id": "69",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "部门类别设置",
                                            "url": "./admin/basic-management/department-category.html",
                                            "id": "610",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "管理部门类别设置",
                                            "url": "./admin/basic-management/manage-department.html",
                                            "id": "611",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修部门设置",
                                            "url": "./admin/basic-management/service-department.html",
                                            "id": "612",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "科室系统字典",
                                            "url": "./admin/basic-management/department-system.html",
                                            "id": "613",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "规章制度管理",
                            "url": "admin&t=0&n=2",
                            "shiro": "a",
                            "id": "614",
                            "items": [
                                {
                                    "title": "规章制度查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "615",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "已备案的规章制度",
                                            "url": "./admin/basic-management/beian-rules.html",
                                            "id": "616",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "试用中的规章制度",
                                            "url": "./admin/basic-management/tryout-rules.html",
                                            "id": "617",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已停用的规章制度",
                                            "url": "./admin/basic-management/blockup-rules.html",
                                            "id": "618",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "规章制度制定",
                                    "url": "./table.html",
                                    "icon": "pencil-alt",
                                    "id": "619",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "编写",
                                            "url": "./admin/basic-management/write.html",
                                            "id": "620",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待审核",
                                            "url": "./admin/basic-management/check-pending.html",
                                            "id": "621",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待修改",
                                            "url": "./admin/basic-management/revise.html",
                                            "id": "622",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "试用中",
                                            "url": "./admin/basic-management/tryout.html",
                                            "id": "623",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "规章制度再评价",
                                    "url": "./table.html",
                                    "icon": "comment-alt",
                                    "id": "624",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "待评价",
                                            "url": "./admin/basic-management/evaluate.html",
                                            "id": "625",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待修改",
                                            "url": "./admin/basic-management/revise.html",
                                            "id": "626",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待审核",
                                            "url": "./admin/basic-management/check-pending.html",
                                            "id": "627",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "试用中",
                                            "url": "./admin/basic-management/tryout.html",
                                            "id": "628",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "进度查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "629",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "制定进度",
                                            "url": "./admin/basic-management/schedule-development.html",
                                            "id": "630",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "再评价进度",
                                            "url": "./admin/basic-management/revalue.html",
                                            "id": "631",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "规章制度模板",
                                    "url": "./table.html",
                                    "icon": "paperclip",
                                    "id": "632",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "模板列表",
                                            "url": "./admin/basic-management/template-list.html",
                                            "id": "633",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "模板录入",
                                            "url": "./admin/basic-management/template-entry.html",
                                            "id": "634",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "岗位职责管理",
                            "url": "admin&t=0&n=3",
                            "shiro": "a",
                            "id": "635",
                            "items": [
                                {
                                    "title": "岗位职责查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "636",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "已备案的岗位职责",
                                            "url": "./admin/basic-management/post-beian.html",
                                            "id": "637",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "试用中的岗位职责",
                                            "url": "./admin/basic-management/post-tryoutRules.html",
                                            "id": "638",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已停用的岗位职责",
                                            "url": "./admin/basic-management/post-blockup.html",
                                            "id": "639",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "岗位职责制定",
                                    "url": "./table.html",
                                    "icon": "pencil-alt",
                                    "id": "640",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "编写",
                                            "url": "./admin/basic-management/begin-write.html",
                                            "id": "641",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待审核",
                                            "url": "./admin/basic-management/post-checkPending.html",
                                            "id": "642",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待修改",
                                            "url": "./admin/basic-management/post-revise.html",
                                            "id": "643",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "试用中",
                                            "url": "./admin/basic-management/post-tryout.html",
                                            "id": "644",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "岗位职责再评价",
                                    "url": "./table.html",
                                    "icon": "comment-alt",
                                    "id": "645",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "待评价",
                                            "url": "./admin/basic-management/post-checkPending.html",
                                            "id": "646",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待修改",
                                            "url": "./admin/basic-management/post-checkPending.html",
                                            "id": "647",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待审核",
                                            "url": "./admin/basic-management/post-checkPending.html",
                                            "id": "648",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "试用中",
                                            "url": "./admin/basic-management/post-checkPending.html",
                                            "id": "649",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "进度查询",
                                    "url": "./table.html",
                                    "icon": "spinner",
                                    "id": "650",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "制定进度",
                                            "url": "./admin/basic-management/post-schedule.html",
                                            "id": "651",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "再评价进度",
                                            "url": "./admin/basic-management/post-revalue.html",
                                            "id": "652",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "规章制度模板",
                                    "url": "./table.html",
                                    "icon": "paperclip",
                                    "id": "653",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "模板列表",
                                            "url": "./admin/basic-management/post-templateList.html",
                                            "id": "654",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "模板录入",
                                            "url": "./admin/basic-management/post-templateEntry.html",
                                            "id": "655",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "科务管理",
                    "icon": "cogs",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "使用部门",
                            "url": "admin&t=1&n=0",
                            "shiro": "a",
                            "id": "656",
                            "items": [
                                {
                                    "title": "科室团队分工",
                                    "url": "./table.html",
                                    "icon": "chalkboard-teacher",
                                    "id": "657",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "科室管理团队",
                                            "url": "./admin/discipline-management/department-management.html",
                                            "id": "658",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待审核管理团队",
                                            "url": "./admin/discipline-management/checkPending-team.html",
                                            "id": "659",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已退回管理团队",
                                            "url": "./admin/discipline-management/notpass-team.html",
                                            "id": "660",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "科室团队成立进度",
                                    "url": "./table.html",
                                    "icon": "spinner",
                                    "id": "661",
                                    "shiro": "a"
                                },
                                {
                                    "title": "科室团队汇总",
                                    "url": "./table.html",
                                    "icon": "asterisk",
                                    "id": "662",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "科室质安管理团队汇总",
                                            "url": "./admin/discipline-management/qualitySafe-management.html",
                                            "id": "663",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "质控管理员名单",
                                            "url": "./admin/discipline-management/qualityControl-management.html",
                                            "id": "664",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "监测联络员名单",
                                            "url": "./admin/discipline-management/monitoring-liaison.html",
                                            "id": "665",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "科室资产管理人员名单",
                                            "url": "./admin/discipline-management/asset-management.html",
                                            "id": "666",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "计量管理员名单",
                                            "url": "./admin/discipline-management/metering-management.html",
                                            "id": "667",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "未成立管理团队科室",
                                            "url": "./admin/discipline-management/not-established.html",
                                            "id": "668",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "设备管理",
                                    "url": "./table.html",
                                    "icon": "wrench",
                                    "id": "669",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设备使用管理人授权",
                                            "url": "./admin/discipline-management/department-use.html",
                                            "id": "670",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备操作人授权",
                                            "url": "./admin/discipline-management/department-operation.html",
                                            "id": "671",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备值班排版设置",
                                            "url": "./table.html",
                                            "id": "672",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备存放设置",
                                            "url": "./table.html",
                                            "id": "673",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            "title": "管理部门",
                            "url": "admin&t=1&n=1",
                            "shiro": "a",
                            "id": "674",
                            "items": [
                                {
                                    "title": "维修分管设备划分",
                                    "url": "./table.html",
                                    "icon": "chalkboard-teacher",
                                    "id": "675",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "工程师负责部门划分",
                                            "url": "./admin/discipline-management/engineer-department.html",
                                            "id": "676",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "工程师负责部门划分查询",
                                            "url": "./admin/discipline-management/engineer-search.html",
                                            "id": "677",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "维修部门下的工程师负责设备划分",
                                            "url": "./admin/discipline-management/service-equipment.html",
                                            "id": "678",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": '维修部门下的工程师负责设备划分查询',
                                            "url": './admin/discipline-management/repair-search.html',
                                            "id": '6781',
                                            "shiro": 'a'
                                        }
                                    ]
                                },
                                {
                                    "title": "领导分管划分",
                                    "url": "./admin/discipline-management/leadership-charge.html",
                                    "icon": "chalkboard-teacher",
                                    "id": "679",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "员工管理",
                            "url": "admin&t=1&n=2",
                            "shiro": "a",
                            "id": "680",
                            "items": [
                                {
                                    "title": "员工信息查询",
                                    "url": "./admin/discipline-management/employee-query.html",
                                    "icon": "search",
                                    "id": "681",
                                    "shiro": "a"
                                },
                                {
                                    "title": "员工信息导入",
                                    "url": "./admin/discipline-management/employee-input.html",
                                    "icon": "file-import",
                                    "id": "682",
                                    "shiro": "a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "落实监督",
                    "icon": "eye",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "合规性检查",
                            "url": "admin&t=2&n=0",
                            "shiro": "a",
                            "id": "683",
                            "items": [
                                {
                                    "title": "设备证照检查",
                                    "url": "./admin/supervision/certificate-inspection.html",
                                    "icon": "check-square",
                                    "id": "684",
                                    "shiro": "a"
                                },
                                {
                                    "title": "设备证件导入",
                                    "url": "./admin./supervision/certificate-input.html",
                                    "icon": "file-import",
                                    "id": "685",
                                    "shiro": "a"
                                },
                                {
                                    "title": "厂商多证导入",
                                    "url": "./admin/supervision/producer-introduction.html",
                                    "icon": "file-import",
                                    "id": "686",
                                    "shiro": "a"
                                },
                                {
                                    "title": "规章制度检查",
                                    "url": "./admin/supervision/rules-regulations.html",
                                    "icon": "check-square",
                                    "id": "687",
                                    "shiro": "a"
                                },
                                {
                                    "title": "设备状态及标识检查",
                                    "url": "./admin/supervision/device-status.html",
                                    "icon": "check-square",
                                    "id": "688",
                                    "shiro": "a"
                                },
                                {
                                    "title": "机构与岗位职责检查",
                                    "url": "./admin/supervision/institutional-post.html",
                                    "icon": "check-square",
                                    "id": "689",
                                    "shiro": "a"
                                },
                                {
                                    "title": "操作规程与应急预案检查",
                                    "url": "./admin/supervision/operating-regulations.html",
                                    "icon": "check-square",
                                    "id": "690",
                                    "shiro": "a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "改善提高",
                    "icon": "arrow-up",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "改善提案",
                            "url": "admin&t=3&n=0",
                            "shiro": "a",
                            "id": "691",
                            "items": [
                                {
                                    "title": "改善提案制订",
                                    "url": "./table.html",
                                    "icon": "pencil-alt",
                                    "id": "692",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "新建改善提案",
                                            "url": "./admin/improvement/new-improvement.html",
                                            "id": "693",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "已退回提案",
                                            "url": "./admin/improvement/proposal-returned.html",
                                            "id": "694",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待受理提案",
                                            "url": "./admin/improvement/proposal-returned.html",
                                            "id": "695",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "待审批提案",
                                            "url": "./admin/improvement/proposal-returned.html",
                                            "id": "696",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "改善提案查询",
                                    "url": "./table.html",
                                    "icon": "search",
                                    "id": "697",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "提案制订进度",
                                            "url": "./admin/improvement/proposal-progress.html",
                                            "id": "698",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "改善提案检查",
                                            "url": "./admin/improvement/proposal-progress.html",
                                            "id": "699",
                                            "shiro": "a"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ],
            "items": []
        },
        {
            "page": "system",
            "tools": [
                {
                    "title": "数据字典",
                    "icon": "database",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "数据字典",
                            "url": "system&t=0&n=0",
                            "shiro": "a",
                            "id": "7",
                            "items": [
                                {
                                    "title": "基础字典",
                                    "url": "./system/data-dictionary/basic.html",
                                    "icon": "book",
                                    "id": "71",
                                    "shiro": "a"
                                },
                                {
                                    "title": "专业字典",
                                    "url": "./system/data-dictionary/major.html",
                                    "icon": "torah",
                                    "id": "72",
                                    "shiro": "a"
                                },
                                {
                                    "title": "状态字典",
                                    "url": "./system/data-dictionary/state.html",
                                    "icon": "torah",
                                    "id": "73",
                                    "shiro": "a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "系统设置",
                    "icon": "hourglass-start",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "系统设置",
                            "url": "system&t=1&n=0",
                            "shiro": "a",
                            "id": "74",
                            "items": [
                                {
                                    "title": "LOGO设置",
                                    "url": "./system/system-setup/LOGO-set.html",
                                    "id": "75",
                                    "shiro": "a"
                                },
                                {
                                    "title": "报表抬头设置",
                                    "url": "./system/system-setup/bbtt-set.html",
                                    "id": "76",
                                    "shiro": "a"
                                },
                                {
                                    "title": "设备标签抬头设置",
                                    "url": "./system/system-setup/equip-head-set.html",
                                    "id": "760",
                                    "shiro": "a"
                                },
                                {
                                    "title": "文件版本设置",
                                    "url": "./system/system-setup/DOCED-setup.html",
                                    "id": "77",
                                    "shiro": "a"
                                },
                                {
                                    "title": "短信猫设置",
                                    "url": "./system/system-setup/modem-gsm.html",
                                    "id": "78",
                                    "shiro": "a"
                                },
                                {
                                    "title": "作息时间",
                                    "url": "./system/system-setup/time-table.html",
                                    "id": "79",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "设备信息",
                            "url": "system&t=1&n=1",
                            "shiro": "a",
                            "id": "710",
                            "items": [
                                {
                                    "title": "设备信息",
                                    "url": "./table.html",
                                    "icon": "info-circle",
                                    "id": "711",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "设备信息查询",
                                            "url": "./system/system-setup/information-search.html",
                                            "id": "712",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备信息导入",
                                            "url": "./system/system-setup/information-import.html",
                                            "id": "713",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备信息录入",
                                            "url": "./system/system-setup/information-entry.html",
                                            "id": "714",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备附件信息导入",
                                            "url": "./system/system-setup/fjImport.html",
                                            "id": "715",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备附件信息录入",
                                            "url": "./system/system-setup/fjEntry.html",
                                            "id": "716",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备属性扩展",
                                            "url": "./system/system-setup/device-property.html",
                                            "id": "717",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "设备卫标分类设置",
                                            "url": "./system/system-setup/repair-classify.html",
                                            "id": "718",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "卫标已关联设备",
                                            "url": "./system/system-setup/weiBiao.html",
                                            "id": "719",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "设备确认",
                                    "url": "./table.html",
                                    "icon": "check-circle",
                                    "id": "720",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "系统提醒",
                            "url": "system&t=1&n=2",
                            "shiro": "a",
                            "id": "721",
                            "items": [
                                {
                                    "title": "提醒设置",
                                    "url": "./table.html",
                                    "icon": "sliders-h",
                                    "id": "722",
                                    "shiro": "a",
                                    "list": [
                                        {
                                            "title": "提醒类别",
                                            "url": "./system/system-setup/reminder-classify.html",
                                            "id": "723",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "日期前提醒设置",
                                            "url": "./system/system-setup/preDate.html",
                                            "id": "724",
                                            "shiro": "a"
                                        },
                                        {
                                            "title": "日期后提醒设置",
                                            "url": "./system/system-setup/afterDate.html",
                                            "id": "725",
                                            "shiro": "a"
                                        }
                                    ]
                                },
                                {
                                    "title": "提醒信息",
                                    "url": "./system/system-setup/reminder-information.html",
                                    "icon": "bell",
                                    "id": "726",
                                    "shiro": "a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "用户管理",
                    "icon": "users-cog",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "用户管理",
                            "url": "system&t=2&n=0",
                            "shiro": "a",
                            "id": "727",
                            "items": [
                                {
                                    "title": "用户设置",
                                    "url": "./system/user-management/user-setting.html",
                                    "icon": "sliders-h",
                                    "id": "728",
                                    "shiro": "a"
                                },
                                {
                                    "title": "角色设置",
                                    "url": "./system/user-management/role-setting.html",
                                    "icon": "users-cog",
                                    "id": "729",
                                    "shiro": "a"
                                },
                                {
                                    "title": "用户权限分配",
                                    "url": "./table.html",
                                    "icon": "user-lock",
                                    "id": "730",
                                    "shiro": "a"
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": "门户管理",
                    "icon": "desktop",
                    "shiro": "a",
                    "content": [
                        {
                            "title": "公告",
                            "url": "system&t=3&n=0",
                            "shiro": "a",
                            "id": "731",
                            "items": [
                                {
                                    "title": "拟稿",
                                    "url": "./system/portal-management/draft.html",
                                    "icon": "pen",
                                    "id": "732",
                                    "shiro": "a"
                                },
                                {
                                    "title": "审核",
                                    "url": "./system/portal-management/auditing.html",
                                    "icon": "clipboard-check",
                                    "id": "733",
                                    "shiro": "a"
                                },
                                {
                                    "title": "查询",
                                    "url": "./system/portal-management/search.html",
                                    "icon": "search",
                                    "id": "734",
                                    "shiro": "a"
                                },
                                {
                                    "title": "公告类别管理",
                                    "url": "./system/portal-management/announce-category.html",
                                    "icon": "sliders-h",
                                    "id": "735",
                                    "shiro": "a"
                                }
                            ]
                        },
                        {
                            "title": "公共下载",
                            "url": "system&t=3&n=1",
                            "shiro": "a",
                            "id": "736",
                            "items": [
                                {
                                    "title": "拟稿",
                                    "url": "./system/portal-management/download-draft.html",
                                    "icon": "pen",
                                    "id": "737",
                                    "shiro": "a"
                                },
                                {
                                    "title": "审核",
                                    "url": "./system/portal-management/download-auditing.html",
                                    "icon": "clipboard-check",
                                    "id": "738",
                                    "shiro": "a"
                                }, {
                                    "title": "查询",
                                    "url": "./system/portal-management/download-search.html",
                                    "icon": "search",
                                    "id": "739",
                                    "shiro": "a"
                                }
                            ]
                        }

                    ]
                }
            ],
            "items": []
        }
    ];

var nav_list = [
    {
        "page": "data",
        "title": "数据收集",
        "icon": "fas fa-chart-bar"
    },
    {
        "page": "life",
        "title": "全寿命管理",
        "icon": "far fa-heart"
    },
    {
        "page": "safe",
        "title": "安全管理",
        "icon": "far fa-smile"
    },
    {
        "page": "beneft",
        "title": "效益管理",
        "icon": "far fa-gem"
    },
    {
        "page": "admin",
        "title": "行政管理",
        "icon": "fas fa-sitemap"
    },
    {
        "page": "system",
        "title": "系统管理",
        "icon": "fas fa-cogs"
    }
]