package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;

import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjKaoPingKsListVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjKaoPingVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjKaoPingZongVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqHtMapper;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqTjKaopingMapper;
import com.litbo.hospital.lifemanage.service.MyService.EqTjKaoPingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EqTjKaoPingServiceimpl implements EqTjKaoPingService {
    @Autowired
    private EqTjKaopingMapper mapper;
    @Autowired
    private EqHtMapper htMapper;
    @Override
    public EqTjKaoPingZongVO getAllZongKaoPing(String sqtjid) {
        /*一个申请调剂对应一个这个*/
        EqTjKaoPingZongVO pingVO = new EqTjKaoPingZongVO();
        /*科室大集合*/
        List<EqTjKaoPingKsListVO> kslist=new ArrayList<>();
        /*查询此调集申请的所有调配记录*/
        List<EqTjKaoPingVO> vos = mapper.getAllZongKaoPing(sqtjid);
        /*此申请调剂单下的所有调配单编号*/
        List<String> dpdidlist =
                vos.stream().map(EqTjKaoPingVO::getId)
                        .collect(Collectors.toList());
        pingVO.setList(vos);
        pingVO.setSfyl(mapper.getSfylBySqid(sqtjid));

        int size = dpdidlist.size();
        for (int i = 0; i < size; i++) {
            mapper.getAllTjKs(dpdidlist.get(i));
        }
        /*辅助集合,记录数量用,调用数量*/
        /*查询该调配单的所有装备编号*/

        /*查询已经调剂交接的设备编号*/

        return pingVO;
    }


}
