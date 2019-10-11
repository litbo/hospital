package com.litbo.hospital.finance.vo;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/10/10 19:37
 * @Version:
 * @Description:
 */
public class DeleteVo {
    private List<String> ids;

    public DeleteVo() {
    }

    @Override
    public String toString() {
        return "DeleteVo{" +
                "ids=" + ids +
                '}';
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public DeleteVo(List<String> ids) {
        this.ids = ids;
    }
}
