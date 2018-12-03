package com.litbo.hospital.user.service;

import com.litbo.hospital.user.bean.SysDxm;
import com.litbo.hospital.user.bean.SysWjbb;
import com.litbo.hospital.user.bean.SysZxsj;

public interface SysService {
    int setWjbb(SysWjbb wjbb);

    int setDxm(SysDxm dxm);

    int setZxsj(SysZxsj zxsj);
}
