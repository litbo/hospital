package com.litbo.hospital.security.vo;

import com.litbo.hospital.security.bean.JhRylr;
import com.litbo.hospital.supervise.vo.JhEmpVo;
import lombok.Data;

import java.util.List;

/**
 * @author zjc
 * @create 2019-03-15 9:41
 */
@Data
public class JhryVo {

    private JhRylr jhRylr;

    private List<JhEmpVo> emps;

}
