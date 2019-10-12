package com.litbo.hospital.maintenance.vo;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/10/12 16:07
 * @Version:
 * @Description:
 */
public class DelVo {
    @Override
    public String toString() {
        return "DelVo{" +
                "pids=" + Arrays.toString(pids) +
                '}';
    }

    public String[] getPids() {
        return pids;
    }

    public void setPids(String[] pids) {
        this.pids = pids;
    }

    public DelVo() {
    }

    public DelVo(String[] pids) {
        this.pids = pids;
    }

    String[] pids;


}
