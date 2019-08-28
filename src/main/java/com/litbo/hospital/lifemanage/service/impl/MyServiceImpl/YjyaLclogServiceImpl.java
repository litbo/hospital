package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaLclogVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaZdVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.YjyaLclogMapper;
import com.litbo.hospital.lifemanage.service.MyService.YjyaLclogService;
import com.litbo.hospital.lifemanage.service.MyService.YjyaZdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class YjyaLclogServiceImpl implements YjyaLclogService {
    @Autowired
    private YjyaLclogMapper mapper;

    @Autowired
    private YjyaZdService service;
    @Override
    public int insertYjyaLclog(YjyaLclogVO vo) {
        return mapper.insertYjyaLclog(vo);
    }

    @Override
    public YjyaLclogVO selectYalogByBh(String bh) {
        YjyaLclogVO vo = mapper.selectYalogByBh(bh);
        return vo;
    }

    @Override
    public PageInfo selectAllYalogByExample(Integer pageNum, Integer pageSize, String zt, Date qssj, Date jssj, String yabh, String yaname) {
        PageHelper.startPage(pageNum,pageSize);
        List<YjyaLclogVO> vos = mapper.selectAllYalogByExample(zt, qssj, jssj, yabh, yaname);
        YjyaLclogVO vo = new YjyaLclogVO();
        int size = vos.size();
        for (int i = 0; i < size; i++) {
            YjyaLclogVO vo1 = vos.get(i);
            Date date = vo1.getYjyaSykssj();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, 1);
            /*判断并修改预案记录状态,同时修改制订预案为已备案*/
            if("1".equals(vo1.getYjyaZt())){
                if (new Date().getTime() >= cal.getTime().getTime()){
                    vo1.setYjyaBakssj(cal.getTime());
                    YjyaZdVO zdVO = new YjyaZdVO();
                    zdVO.setYjyaBh(vo1.getYjyaBh());
                    updateYalog(vo);
                    service.updateYjyaZd(zdVO);
                }
            }

        }
        return new PageInfo(vos);
    }

    @Override
    public int updateYalog(YjyaLclogVO vo) {
        YjyaLclogVO yalog = mapper.selectYalogByBh(vo.getYjyaBh());
        BeanUtil.copyProperties(vo, yalog, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        return mapper.updateYalog(yalog);
    }


}
