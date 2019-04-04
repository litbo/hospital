package com.litbo.hospital.security.vo;

import com.litbo.hospital.security.bean.FwPjsg;
import com.litbo.hospital.security.bean.FwPjsgZjb;
import com.litbo.hospital.user.vo.LiveEmpVo;
import lombok.Data;

import java.util.List;
@Data
public class InsertFwPjsgVo {
    private FwPjsg fwPjsg;
    private List<FwPjsgZjb> fwPjsgZjbs;
    private LiveEmpVo sEmp;
}
