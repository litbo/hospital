package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.DhdjksjsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgDhdjVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 到货登记表Service接口
 */
public interface SgDhdjService {
    /**
     * 添加到货登记信息
     *
     * @param sgDhdjVO 到货登记信息
     */
    void insertSgDhdj(SgDhdjVO sgDhdjVO);

    /**
     * 查询科室接收的货物
     *
     * @param userId   当前用户id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<DhdjksjsVO>
     */
    PageInfo<DhdjksjsVO> selectDjhwKsjs(String userId, Integer pageNum, Integer pageSize);

    /**
     * 科室接收
     *
     * @param djhwId 登记货物id
     * @param userId 登陆人id
     */
    void updateSgDhdjKsjs(String djhwId, String userId);

    /*增加登记货物残损图片路径*/
    String Importdjhwimgurls(MultipartFile[] files);

    /**
     * 科室接收货物详情信息
     *
     * @param djhwId 到货登记id
     * @return SgDhdjVO
     */
    SgDhdjVO selectSgDhdjDetails(String djhwId);

    /*选择合同编号*/
    PageInfo selectHtBianhao(Integer pageNum, Integer pageSize);


    /*查询所有到货登记*/
    PageInfo<List<SgDhdjVO>> selectAllDhdj(Integer pageNum, Integer pageSize, String htid, String htzt);
    /*查询所有到货登记和登记货物记录*/
    PageInfo<List<SgDhdjVO>> selectDhdjAndDjhwBy(Integer pageNum, Integer pageSize, String htid);
}
