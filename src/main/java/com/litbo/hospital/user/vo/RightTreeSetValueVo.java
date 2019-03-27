package com.litbo.hospital.user.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


public class RightTreeSetValueVo {

    private String pid;
    private String rightId;
    private String rightName;


    private Boolean checked;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRightId() {
        return rightId;
    }

    public void setRightId(String rightId) {
        this.rightId = rightId;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = true;
    }
}
