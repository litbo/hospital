package com.litbo.hospital.user.vo;

import java.util.Arrays;

/**
 * @Author: 樊小铭
 * Date: 2019/9/25 10:11
 * @Version:
 * @Description:
 */
public class DeleteVo {
    private DictVo[] dictVos;

    public DeleteVo() {
    }

    @Override
    public String toString() {
        return "DeleteVo{" +
                "dictVos=" + Arrays.toString(dictVos) +
                '}';
    }

    public DictVo[] getDictVos() {
        return dictVos;
    }

    public void setDictVos(DictVo[] dictVos) {
        this.dictVos = dictVos;
    }

    public DeleteVo(DictVo[] dictVos) {
        this.dictVos = dictVos;
    }
}
