package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.vo.*;

public interface ZhiduService {
    //获取所有制度
    PageInfo getZds(int pageNum, int pageSize);

    //加入制度
    void saveZd(SZhidu zd);

    //删除制度
    void deteleZd(int zd_id);

    //修改制度
    void updateZd(SZhidu zd);

    //制度编写后提交
    void submit(ZhiduSubmitVO zhiduSubmitVO);

    //重新提交制度信息
    void reSubmit(ZhiduSubmitVO zhiduSubmitVO);

    //通过审核人查询待审核的制度
    PageInfo listZdsByShr(int pageNum, int pageSize, String shr_id);

    //获取审核的详细信息
    ZdShDetailMsg getShDetailMgsByZdId(Integer zdId, String shrId);

    //提交审核人的审核信息
    void submitShMsg(ShMsgVO shMsgVO);
    //获取制度信息通过制度状态
    PageInfo listZdsByZdZt(int pageNum, int pageSize, String zdZt);
    //获取制度信息通过时间段制度名称和状态级联查询
    PageInfo listZdsByTimeAndZdNameAndZt(int pageNum, int pageSize, String startTime, String endTime, String zdName, String zdZt,String reFlag) throws  Exception;

    SZhidu getZdById(String id);

    PageInfo getShProcesses(int pageNum,int pageSize,Integer zdId);

    void dpjSubmitMsg(ZpjSumbitVO zpjSumbitVO);

    ZpjMsgVO getZpjMsgByZdId(String zdId);

    void dpjSubmitShMsg(ShMsgVO shMsgVO);
}
