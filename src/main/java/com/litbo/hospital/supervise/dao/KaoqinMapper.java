package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.KaoqinVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KaoqinMapper {
    void insertKaoqin(KaoqinVO kaoqinVO) ;

    List<KaoqinVO> listKaoqin();

    void delKaoqin();
}
