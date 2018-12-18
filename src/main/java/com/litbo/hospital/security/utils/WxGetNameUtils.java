package com.litbo.hospital.security.utils;

import com.litbo.hospital.security.vo.FwVo;
import com.litbo.hospital.security.vo.PjVo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.dao.EmpDao;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.dao.EqDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-10 9:20
 */
@Component
public class WxGetNameUtils {

    @Autowired
    private EmpDao empDao;

    private static EmpDao empDaoImpl;

    @Autowired
    private BmDao bmDao;

    private static BmDao bmDaoImpl;

    @Autowired
    private EqDao eqDao;

    private static EqDao eqDaoImpl;

    @PostConstruct
    public void init(){
        WxGetNameUtils.empDaoImpl = empDao;
        WxGetNameUtils.bmDaoImpl = bmDao;
        WxGetNameUtils.eqDaoImpl = eqDao;
    }

    public static FwVo getName(String userId,String eqId){
        FwVo fwVo = new FwVo();
        SEmp emp = empDaoImpl.getEmpByUserId(userId);
        fwVo.setUsername(emp.getUserXm());
        SBm bm = bmDaoImpl.getBmByOid(emp.getBmId());
        fwVo.setBmName(bm.getBmName());
        fwVo.setBmId(emp.getBmId());
        if(eqId != null){
            EqInfo eq = eqDaoImpl.getEqById(eqId);
            fwVo.setEqName(eq.getEqName());
            fwVo.setEqGg(eq.getEqGg());
            fwVo.setEqXh(eq.getEqXh());
            fwVo.setEqBxjssj(eq.getEqBxjssj());
        }
        return fwVo;
    }

    /**
     * 获取配件
     * @param fwId
     * @return
     */
    public static List<PjVo> getPjVo(String fwId){

        return null;
    }

   /* public static FwInfoVo getInfoByFwId(String fwId){

    }*/


}
