package com.litbo.hospital.supervise.service;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.KaoqinVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface KaoqinService {


   Result insertKaoqin(KaoqinVO kaoqinVO);

   PageInfo<KaoqinVO> listKaoqin(int pageNum, int pageSize);

   void delKaoqin();
}
