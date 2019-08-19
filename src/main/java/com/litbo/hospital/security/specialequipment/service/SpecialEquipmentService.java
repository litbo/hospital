package com.litbo.hospital.security.specialequipment.service;



import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipment;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentEmployee;
import com.litbo.hospital.security.specialequipment.bean.vo.SpecialEquipmentEmployeeVo;
import com.litbo.hospital.security.specialequipment.bean.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;


public interface SpecialEquipmentService {


    //查询部门信息
    PageInfo selectSpEqBmInfo(int pageNum, int pageSize);
    //查询部门信息根据部门名称
    PageInfo selectSpEqBmInfoByName(int pageNum, int pageSize, String bmName);




    //插入特种设备信息
    int insertSpecialEq(SpecialEquipment specialEquipment);
    //删除特种设备信息
    int deleteSpecialEq(String speqId);
    //修改特种设备信息
    int updateSpecialEq(SpecialEquipment specialEquipment);
    //查询特种设备信息根据Id
    SpecialEquipment selectSpecialEqById(String speqId);
    //查询特种设备信息
    PageInfo selectSpecialEq(int pageNum, int pageSize);
    //查询特种设备信息Vo根据设备id name 类型 生产商 科室名称
    PageInfo selectSpeqVoByBhAndNameAndScsAndTypeAndBmId(int pageNum, int pageSize,
                                                         String speqBh, String speqName,
                                                         String speqScs, int speqType,
                                                         String bmId, int speqRun);
    //查询特种设备结果记录根据speqBh
    PageInfo selectSpeqRecordBySpeqId(int pageNum, int pageSize, String speqBh);



    //查询所有不是特种设备从业人员的用户
    PageInfo<UserVo> selectAllUser(int pageNum, int pageSize);
    //查询所有是特种设备从业人员的用户
    PageInfo<UserVo> selectAllUserIsSpem(int pageNum, int pageSize);
    //查询员工信息根据id name bmname
    PageInfo selectUserByIdAndNameAndBmName(int pageNum, int pageSize, String userId, String userXm, String bmName);
    //查询特种设备员工信息根据id name bmname
    PageInfo selectSpeqUserByIdAndNameAndBmName(int pageNum, int pageSize, String userId, String userXm, String bmName);
    //将员工设为特种设备从业人员
    void updateIsSpeqEm(String userId);
    //将员工设为特种设备从业人员
    void updateIsNotSpeqEm(String userId);
    //根据user_id查询user信息
    SpecialEquipmentEmployeeVo selectSpemById(String userId);
    //更改数据
    int updateSpem(SpecialEquipmentEmployeeVo specialEquipmentEmployee);
    //set用户照片
    String setSpemImg(MultipartFile img);
    //到期日期排序
    PageInfo selctDate(int pageNum, int pageSize);

    //导入excel表格特种设备信息
    int importSpeqInfo(MultipartFile file);


}
