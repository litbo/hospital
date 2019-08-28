package com.litbo.hospital.common.utils.calculate;

import com.litbo.hospital.efficiency.dao.LevelDAO;
import com.litbo.hospital.efficiency.vo.LevelVO;
import org.springframework.stereotype.Component;

@Component
public class ReLevel {


    public static String getLevel(String using, Integer us,Integer idling){

        Double inFact = Double.valueOf(using);


        if (inFact>100){
            return "超负荷运转";
        }
        else if ( inFact <= 100 && inFact >= us){
            return "高效运转";
        }else if (inFact >= idling && inFact < us ){
            return "中效运转";
        }else if (inFact > 0 && inFact < idling){
            return "低效运转";
        }else if (inFact == 0){
            return "长期闲置";
        }
        throw new RuntimeException("不在设置效率等级范围内");
    }

}
