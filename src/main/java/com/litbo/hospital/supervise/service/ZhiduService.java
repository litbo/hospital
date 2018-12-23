package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.vo.ShDetailMsg;
import com.litbo.hospital.supervise.vo.ShMsgVO;
import com.litbo.hospital.supervise.vo.ZhiduSubmitVO;

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
    ShDetailMsg getShDetailMgsByZdId(Integer zdId, String shrId);

    //提交审核人的审核信息
    void submitShMsg(ShMsgVO shMsgVO);

}
