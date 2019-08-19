package com.litbo.hospital.metering.vo;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/14 14:51
 * @Version:
 * @Description:
 */
public class PageVo {
    /**
     * msg : success
     * code : 0
     * data : {"total":0,"list":[]}
     */
    private String msg;
    private int code;
    private DataEntity data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public class DataEntity {
        /**
         * total : 0
         * list : []
         */
        private int total;
        private List<?> list;

        public DataEntity(int total, List<?> list) {
            this.total = total;
            this.list = list;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public void setList(List<?> list) {
            this.list = list;
        }

        public int getTotal() {
            return total;
        }

        public List<?> getList() {
            return list;
        }
    }
}
