package com.litbo.hospital.security.vo;

import com.litbo.hospital.security.bean.FwPjql;
import com.litbo.hospital.security.bean.FwPjqlZjb;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class InsertFwPjqlVo implements Serializable {
    private static final long serialVersionUID = 8607859409880232081L;
    private FwPjql fwPjql;
    private List<FwPjqlZjb> fwPjqlZjbs;
}
