package com.litbo.hospital.lifemanage.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.lifemanage.bean.SgDhdj;
import com.litbo.hospital.lifemanage.bean.SgDjhw;
import com.litbo.hospital.lifemanage.bean.vo.DhdjksjsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqHtBianhaoVO;
import com.litbo.hospital.lifemanage.bean.vo.SgDhdjVO;
import com.litbo.hospital.lifemanage.dao.SgDhdjMapper;
import com.litbo.hospital.lifemanage.dao.SgDjhwMapper;
import com.litbo.hospital.lifemanage.service.SgDhdjService;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.EmpDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 到货登记表Service实现类
 */
@Service
public class SgDhdjServiceImpl implements SgDhdjService {
    @Autowired
    private SgDhdjMapper sgDhdjMapper;
    @Autowired
    private SgDjhwMapper sgDjhwMapper;
    @Autowired
    private EmpDao empDao;

    /**
     * 添加到货登记信息
     *
     * @param sgDhdjVO 到货登记信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void insertSgDhdj(SgDhdjVO sgDhdjVO) {
        SgDhdj sgDhdj = new SgDhdj();
        BeanUtils.copyProperties(sgDhdjVO, sgDhdj);
        String sgDhdjId = UUID.randomUUID().toString();
        sgDhdj.setDhdjId(sgDhdjId);
        sgDhdj.setDhdjId(sgDhdjId);
        boolean qbdh = false;
        List<String> list = sgDhdjMapper.selectHtBianhaos2();
        /*当传来的到货登记信息的合同编号曾经为为完全发货或者直接为为完全发货时*/
        if (list.contains(sgDhdjVO.getHtId()) || "0".equals(sgDhdjVO.getDhdjIsqbdh())) {
            sgDhdjMapper.insertSgDhdjLog(sgDhdj);
        } else {
            /*直接插入到到货登记表中*/
            sgDhdjMapper.insertSgDhdj(sgDhdj);
            qbdh = true;
        }

        for (SgDjhw sgDjhw : sgDhdjVO.getSgDjhws()) {
            sgDjhw.setDhdjId(sgDhdjId);
            sgDjhw.setDjhwId(UUID.randomUUID().toString());
            sgDjhw.setDjhwHtid(sgDhdjVO.getHtId());
            if (qbdh) {
                int i = sgDjhwMapper.insertDjhw(sgDjhw);
            } else {
                sgDjhwMapper.insertDjhwLog(sgDjhw);
            }
        }

        if (list.contains(sgDhdjVO.getHtId()) && "1".equals(sgDhdjVO.getDhdjIsqbdh())) {
            sgDhdjMapper.insertSgDhdj(sgDhdj);
            List<SgDjhw> djhwList = sgDjhwMapper.selectSgDjhwLogByHtid(sgDhdjVO.getHtId());
            int size = djhwList.size();
            for (int i = 0; i < size; i++) {
                sgDjhwMapper.insertDjhw(djhwList.get(i));
            }
        }

    }

    @Override
    public String Importdjhwimgurls(MultipartFile[] files) {
        String path = System.getProperty("user.dir");
        String filePath = path + "/bzps/imgs/";
        StringBuffer imgurls = new StringBuffer();
        for (MultipartFile file : files) {
            String url = UploadFile.upload(filePath, file);
            url = url.replaceAll("/", "\\\\");
            url = url.replace(path + "\\bzps", "");
            imgurls.append(url + ",");
        }

        return imgurls.toString();
    }


    /**
     * 查询科室接收的货物
     *
     * @param userId   当前用户id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<DhdjksjsVO>
     */
    @Override
    public PageInfo<DhdjksjsVO> selectDjhwKsjs(String userId, Integer pageNum, Integer pageSize) {
        //通过用户id查询所在的部门id

        SBm bm = empDao.getBmByEmpId(userId);
        String bmId = bm.getBmId();
        List<DhdjksjsVO> dhdjksjsVOS = sgDhdjMapper.selectDjhwKsjs(bmId);
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(sgDhdjMapper.selectDjhwKsjs(bmId));
    }

    /**
     * 科室接收
     *
     * @param djhwId 登记货物id
     * @param userId 登陆人id
     */
    @Override
    public void updateSgDhdjKsjs(String djhwId, String userId) {
        sgDjhwMapper.updateSgDhdjKsjs(djhwId, userId, new Date());
    }

    /**
     * 科室接收货物详情信息
     *
     * @param djhwId 到货登记id
     * @return SgDhdjVO
     */
    @Override
    public SgDhdjVO selectSgDhdjDetails(String djhwId) {
        SgDhdjVO sgDhdjVO = new SgDhdjVO();
        SgDhdj sgDhdj = null;
        //查询到货登记信息
        String htid = sgDjhwMapper.selectHtIdByDjhwJlid(djhwId);
        List<String> htjllist = sgDhdjMapper.selectHtBianhaos2();
        /*如果该登记货物信息在记录表里*/
        if (htjllist.contains(htid)) {
            sgDhdj = sgDhdjMapper.selectOneDhdjLog(djhwId);
        }
        /*如果不在记录表里*/
        else {
            sgDhdj = sgDhdjMapper.selectSgDhdjDetails(djhwId);

        }
        //查询申购登记货物信息
        List<SgDjhw> sgDjhw = sgDjhwMapper.selectSgDhdjDetails(djhwId);
        //封装成vo
        BeanUtils.copyProperties(sgDhdj, sgDhdjVO);
        sgDhdjVO.setSgDjhws(sgDjhw);
        return sgDhdjVO;
    }

    /*查询所有可以选择的合同编号*/
    @Override
    public PageInfo selectHtBianhao(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        /*全部到货的到货登记*/
        List<String> htids = sgDhdjMapper.selectDhdjHtids();
        /*记录log表里面的到货登记合同号*/
        List<String> list = sgDhdjMapper.selectHtBianhaos2();
        /*不在到货表里的合同编号*/
        List<String> list2 = sgDhdjMapper.selectHtBianhaos();
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            if (list.contains(list2.get(i))) {

            } else {
                list.add(list2.get(i));
            }
        }
        int i = list.size();
        for (int k = 0; k < i; k++) {
            if (htids.contains(list.get(k))) {
                list.remove(k);
                i = list.size();
            }
        }
        List<EqHtBianhaoVO> list3 = new ArrayList<>();
        int i2 = list.size();
        for (int k = 0; k < i2; k++) {
            EqHtBianhaoVO vo = new EqHtBianhaoVO();
            vo.setHtid(list.get(k));
            list3.add(vo);
        }


        return new PageInfo(list3);
    }

    @Override
    public PageInfo selectAllDhdj(Integer pageNum, Integer pageSize, String htid, String htzt) {
        boolean b = StringUtils.isNotBlank(htid);
        boolean b2 = StringUtils.isNotBlank(htzt);
        List<SgDhdjVO> vos = new ArrayList<>();
        /*记录log表里面的到货登记合同号*/
        List<String> list = sgDhdjMapper.selectHtBianhaos2();
//        List<String> newList = list.stream().distinct().collect(Collectors.toList());
        int size = list.size();

        List<SgDhdjVO> vos2 = sgDhdjMapper.selectAllDhdj();
        int size2 = vos2.size();
        for (int i = 0; i < size2; i++) {
            if (list.contains(vos2.get(i).getHtId())) {
                vos2.remove(i);
            }
            size2 = vos2.size();
        }
        for (int i = 0; i < size; i++) {
            SgDhdjVO dhdj = sgDhdjMapper.selectLastOneDhdjLog(list.get(i));
            vos.add(dhdj);
        }
        vos.addAll(vos2);
        int i = vos.size();
        for (int j = 0; j < i; j++) {
            String s = vos.get(j).getHtId();
            String s2 = vos.get(j).getDhdjIsqbdh();
            if (b) {
                if (!s.contains(htid)) {
                    vos.remove(j);
                    i = vos.size();
                    if (i < 1) {
                        break;
                    }
                    if (j > 0) {
                        --j;
                    } else if (j == 0) {
                        j = -1;
                    }
                }
            }
            if (b2) {
                if (!htzt.equals(s2)) {
                    vos.remove(j);
                    i = vos.size();
                    if (i < 1) {
                        break;
                    }
                    if (j > 0) {
                        --j;
                    } else if (j == 0) {
                        j = -1;
                    }

                }
            }


        }
        return new PageInfo<>(vos);
    }

    /*根据合同号查看详情*/
    @Override
    public PageInfo selectDhdjAndDjhwBy(Integer pageNum, Integer pageSize, String htid) {
        List<SgDhdjVO> vos = new ArrayList<>();
        /*记录log表里面的到货登记合同号*/
        List<String> list = sgDhdjMapper.selectHtBianhaos2();
        if (list.contains(htid)) {
            List<SgDhdjVO> dhdjlog = sgDhdjMapper.selectDhdjLogByHtid(htid);
            int size = dhdjlog.size();
            /*根据登记货物id匹配*/
            for (int i = 0; i < size; i++) {

                List<SgDjhw> sgDjhws = sgDjhwMapper.selectSgDjhwLogByDhdjid(dhdjlog.get(i).getDhdjId());
                dhdjlog.get(i).setSgDjhws(sgDjhws);

            }
            vos.addAll(dhdjlog);
        } else {
            List<SgDhdjVO> vos2 = sgDhdjMapper.selectSgDhdjOneByHtid(htid);
            SgDhdjVO vo = vos2.get(0);
            vo.setSgDjhws(sgDjhwMapper.selectSgDjhwByDhdjid(vo.getDhdjId()));
            vos.addAll(vos2);
        }
        return new PageInfo<>(vos);
    }


}
