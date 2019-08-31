package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.bean.LevelBean;
import com.litbo.hospital.efficiency.dao.provider.LevelProvider;
import com.litbo.hospital.efficiency.vo.LevelVO;
import org.apache.ibatis.annotations.*;

/**
 *  效率等级设置的DAO层
 */
@Mapper
public interface LevelDAO {

    /**
     * 查询现在的效率设置数据
     * @return 返回效率等级
     */
    @Select("select * from efficiency_level")
    LevelVO selectLevel();

    /**
     * 设置效率数据
     * @param levelBean   利用率 利用率
     * @return 返回效率等级
     */
    //@UpdateProvider(type = LevelProvider.class,method = "updateLevel")
    @Update({
            "<script>",
                "UPDATE dbo.efficiency_level",
                "<set>",
                    "<if test='levelBean.using != null'> using = #{levelBean.using},</if>",
                    "<if test='levelBean.idling != null'> idling = #{levelBean.idling},</if>",
                "</set>",
            "</script>"
    })
    Integer updateLevel(@Param("levelBean") LevelBean levelBean);

}
