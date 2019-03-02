package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.vo.*;
import java.util.List;

public interface GangweiService {

    //添加岗位
    void saveGw(SGangwei gw);


    //通过岗位id删除岗位
    void deleteGwByGwId(String gw_id);
    //获取所有岗位
    PageInfo getGws(int pageNum, int pageSize);
    //获取所有岗位通过岗位状态
    PageInfo listGwsByGwZt(int pageNum, int pageSize, String gwZt);
    //获取岗位列表通过级别和名称迷糊查询
    PageInfo getGwsByGwLevelAndGwName(int pageNum, int pageSize, String gwLevel, String gwName);
    //通过岗位id获取岗位信息
    SGangwei getGwsByGwId(int pageNum, int pageSize, String gw_id);
    //通过岗位等级来获取岗位信息
    List<SGangwei> getGwByGwLevel(String gw_level);
    //通过岗位职责状态查询岗位信息
    PageInfo getGwsByGwZzZt(int pageNum, int pageSize, Integer gwZzZt);
    //修改岗位信息
    void updateGw(SGangwei gw);
    //数据准备
    GWReadyResourcesVO readyResources();
    //岗位职责提交
    void gwzzSubmit(GWSubmitVO gwSubmitVO);
    //通过审核人查询待审核岗位职责
    PageInfo listZdsByShr(int pageNum, int pageSize, String shr_id);
    //通过岗位id查询 岗位的审核信息  ， 通过岗位和审核人获取当前未审核信息
    GwShDetailMsg getShDetailMgsByZdId(Integer gwId, String shrId);
    //提交审核信息
    void submitShMsg(ShMsgVO shMsgVO);

    //通过审核人和岗位职责状态查询待审核岗位职责
    PageInfo listGwsByShrAndZzZt(int pageNum, int pageSize, String shr_id,Integer gwZzZt);
    //通过岗位id获取修改意见和岗位信息
    GwZzReadyForXgVO readyForXgByGwId(Integer gwId);
    //修改后重新提交
    void reSubmit(GWSubmitVO gwSubmitVO);


}
