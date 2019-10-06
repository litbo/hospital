package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjZbdcVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjsqVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EqTjService {


    /*条件查或全查调剂申请*/
    PageInfo selectByExample(Integer pageNum,
                             Integer pageSize,
                             EqTjShowVO showVO);

    /*条件查或全查本科室调剂申请*/
    PageInfo selectByBenBmExample(Integer pageNum,
                                  Integer pageSize,
                                  EqTjShowVO showVO);

    /*主键查*/
    EqTjsqVO selectByPrimaryKey(String id);

    /*增加或者修改一条调入申请记录*/
    int insertTjDrSq(EqTjsqVO eqTjsqDrVO);

    /*删除装备掉出的装备或者整条记录后,调剂申请的变化*/
    int deleteTjZbdc(String id, List<String> zbbm, List<String> ggxh);

    /*查询所在科室设备**/
    PageInfo ListEqInfo(Integer pageNum, Integer pageSize, String bmId);


    /*根据主键删除*/
    int deleteByPrimaryKey(String id);

    /*根据主键删除装备调出*/
    int deleteZbDcById(String id);

    /* 根据主键修改*/
    int updateByPrimaryKey(EqTjsqVO tj);

    /*修改装备调出*/
    int updateZbdcByPrimaryKey(EqTjZbdcVO vo);

    /*根据设备名称和科室名称模糊查询可调剂设备*/

    PageInfo selectAllEqInfo(String sbName, String bmname, String yq);

    /*装备调出增加一些记录*/
    int insertTjZbdc(List<EqTjZbdcVO> zbdcVO);

    /*装备调出记录主键查询*/
    EqTjZbdcVO selectTjZbdcByPrimary(String id);

    /* 申请id查询 进度,申请id，科室id,决定是增加一条调出申请还是修改申请装备 */


    /*改变装备借出状态*/
    int updateEqInfoSfJc(String sbbh, String status);

    /*查询所有待借出设备,点替换之后装备状态变成待借出,未送达调配单+1，别人将无法查询到*/
    PageInfo selectWsdYsd(Integer pageNum, Integer pageSize, String lx);

    /*查询所有已借出设备/验收单已送达*/
    PageInfo selectYsdYsd(Integer pageNum, Integer pageSize, String lx);

    /*修改待调剂装备的信息*/
    int updateDcZb(String id,
                   String zbbm,
                   String ggxh);

    /*修改待调剂装备数量*/
    int updateZbCount(String id);

    int updateSqZbBykey(String id, Integer count, String zbname);

    String importTjsqimg(MultipartFile img);
}
