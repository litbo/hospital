package com.litbo.hospital.efficiency.dao.provider;

import com.litbo.hospital.efficiency.bean.LevelBean;
import org.apache.commons.lang3.StringUtils;

/**
 * description:
 * @author: sz
 * @date: 2019/8/22 16:31
 */
public class LevelProvider {

    public String updateLevel(LevelBean levelBean){

        StringBuilder sql = new StringBuilder("UPDATE dbo.efficiency_level");

        if (StringUtils.isNotBlank(levelBean.getUsing())||StringUtils.isNotBlank(levelBean.getIdling())){

            sql.append(" SET ");

            if (StringUtils.isNotBlank(levelBean.getUsing())){
                sql.append("dbo.efficiency_level.using = ");
                sql.append(levelBean.getUsing());
            }

            if (StringUtils.isNotBlank(levelBean.getIdling())){
                sql.append(" ,dbo.efficiency_level.idling = ");
                sql.append(levelBean.getIdling());
            }

        }

        return sql.toString();
    }

}
