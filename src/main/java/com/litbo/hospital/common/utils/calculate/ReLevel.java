package com.litbo.hospital.common.utils.calculate;

import com.litbo.hospital.efficiency.dao.LevelDAO;
import com.litbo.hospital.efficiency.vo.LevelVO;
import org.springframework.stereotype.Component;

@Component
public class ReLevel {


    public static String getLevel(String using, LevelDAO levelDAO){

        Double inFact = Double.valueOf(using);

        LevelVO levelVO = levelDAO.selectLevel();

        if (inFact>100){
            return "超负荷运转";
        }
        else if ( inFact <= 100 && inFact > levelVO.getUsing()){
            return "高效运转";
        }else if (inFact > levelVO.getIdling() && inFact <= levelVO.getUsing() ){
            return "中效运转";
        }else if (inFact > 0 && inFact <= levelVO.getIdling()){
            return "低效运转";
        }else if (inFact == 0){
            return "长期闲置";
        }
        throw new RuntimeException("不在设置效率等级范围内");
    }

}
