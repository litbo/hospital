package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaLclogVO;

import java.util.Date;

public interface YjyaLclogService {
    
    int insertYjyaLclog(YjyaLclogVO vo);

    YjyaLclogVO selectYalogByBh(String bh);

    PageInfo selectAllYalogByExample(Integer pageNum, Integer pageSize, String zt, Date qssj,
                                     Date jssj, String yabh, String yaname);

    int updateYalog(YjyaLclogVO vo);

    /*再评价申请之后清空上次审核信息*/

}
