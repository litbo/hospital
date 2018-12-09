package com.litbo.hospital.supervise.vo;

import java.io.Serializable;

public class SetBmVO implements Serializable {
    private String pbm_id;    //新父部门
    private String[] obm_ids;  //待处理的部门

    public String getPbm_id() {
        return pbm_id;
    }

    public void setPbm_id(String pbm_id) {
        this.pbm_id = pbm_id;
    }

    public String[] getObm_ids() {
        return obm_ids;
    }

    public void setObm_ids(String[] obm_ids) {
        this.obm_ids = obm_ids;
    }
}
