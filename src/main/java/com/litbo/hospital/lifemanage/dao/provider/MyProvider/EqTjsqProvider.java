package com.litbo.hospital.lifemanage.dao.provider.MyProvider;

public class EqTjsqProvider {
    private static String str = "";

    public String deleteByPrimaryKey() {
        str = "delete from eq_tjsq\n" +
                "    where id = #{id,jdbcType=VARCHAR}";
        return str;

    }


    public String insertTjDrSq() {
        str = "insert into  eq_tjsq (id,tj_sqks,tj_zbmc," +
                " tj_sqly,tj_drjbr,tj_sqsj,tj_sqtpgc,tj_sqlx,tj_sfyl,tj_czjg,tj_zhz, tj_drksurl)" +
                " values(#{id,jdbcType=VARCHAR},#{tjSqks,jdbcType=VARCHAR},#{tjZbmc,jdbcType=VARCHAR},#{tjSqly,jdbcType=VARCHAR},#{tjDrjbr,jdbcType=VARCHAR}," +
                " #{tjSqsj,jdbcType=DATE},#{tjSqtpgc,jdbcType=VARCHAR},#{tjSqlx,jdbcType=VARCHAR},#{tjSfyl,jdbcType=VARCHAR},#{tjCzjg,jdbcType=VARCHAR},#{tjZhz,jdbcType=VARCHAR},#{tjDrksurl,jdbcType=VARCHAR})";
        return str;
    }


    public String insertTjZbdc() {
        str = " insert into tj_zbdc (id, tj_sqtj, tj_dcks, \n" +
                "      tj_lxr, tj_dwsj, tj_zbbm, \n" +
                "      tj_ggxh, tj_tpsl, tj_sysc, \n" +
                "      tj_zbztjc, tj_fjjc, tj_dcjbr ,tj_dpsj,tj_dcksurl,tj_zhz,tj_sqzbbms,tj_sqzbcounts,tj_dclx) \n" +
                "      values ( #{id,jdbcType=VARCHAR}, #{tjSqtj,jdbcType=VARCHAR}, #{tjDcks,jdbcType=VARCHAR}, \n" +
                "      #{tjLxr,jdbcType=VARCHAR}, #{tjDwsj,jdbcType=DATE}, #{tjZbbm,jdbcType=VARCHAR}, \n" +
                "      #{tjGgxh,jdbcType=VARCHAR},  #{tjTpsl,jdbcType=INTEGER}, #{tjSysc,jdbcType=INTEGER}, \n" +
                "      #{tjZbztjc,jdbcType=VARCHAR}, #{tjFjjc,jdbcType=VARCHAR}, #{tjDcjbr,jdbcType=VARCHAR}, \n" +
                "      #{tjDpsj,jdbcType=DATE} ,#{tjDcksurl,jdbcType=VARCHAR},#{tjZhz,jdbcType=VARCHAR},#{tjSqzbbms,jdbcType=VARCHAR},#{tjSqzbcounts,jdbcType=VARCHAR},#{tjDclx,jdbcType=VARCHAR}) ";
        return str;
    }

    public String selectByExample() {
        str = "<script>" + "select id, bm_name,tj_zbmc,tj_drjbr,tj_sqsj\n" +
                " from s_bm \n" +
                " INNER JOIN eq_tjsq on s_bm.bm_id=eq_tjsq.tj_sqks" +
                " <if test=\"_parameter != null\">\n" +
                "<where>\n" +
                "      <foreach collection=\"oredCriteria\" item=\"criteria\" separator=\"or\">\n" +
                "        <if test=\"criteria.valid\">\n" +
                "          <trim prefix=\"(\" prefixOverrides=\"and\" suffix=\")\">\n" +
                "            <foreach collection=\"criteria.criteria\" item=\"criterion\">\n" +
                "              <choose>\n" +
                "                <when test=\"criterion.noValue\">\n" +
                "                  and ${criterion.condition}\n" +
                "                </when>\n" +
                "                <when test=\"criterion.singleValue\">\n" +
                "                  and ${criterion.condition} #{criterion.value}\n" +
                "                </when>\n" +
                "                <when test=\"criterion.betweenValue\">\n" +
                "                  and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}\n" +
                "                </when>\n" +
                "                <when test=\"criterion.listValue\">\n" +
                "                  and ${criterion.condition}\n" +
                "                  <foreach close=\")\" collection=\"criterion.value\" item=\"listItem\" open=\"(\" separator=\",\">\n" +
                "                    #{listItem}\n" +
                "                  </foreach>\n" +
                "                </when>\n" +
                "              </choose>\n" +
                "            </foreach>\n" +
                "          </trim>\n" +
                "        </if>\n" +
                "      </foreach>\n" +
                "    </where>" +
                "    </if>" +
                " <if test=\"orderByClause != null\">\n" +
                "      order by ${orderByClause} ${sort} \n" +
                "    </if>" +
                "</script>";
        return str;
    }

    public String selectByPrimaryKey() {
        str = " select id, tj_sqtj, tj_dcks," +
                "     tj_lxr, tj_dwsj, tj_zbbm," +
                "    tj_gg,tj_xh, tj_ggxh, tj_tpsl, tj_sysc," +
                "     tj_zbztjc, tj_fjjc, tj_dcjbr ," +
                "     tj_dpsj,tj_dcksurl ,tj_zhz,tj_sqzbbms,tj_sqzbcounts,tj_dclx from tj_zbdc where id = #{id}";
        return str;

    }

    public String updateByPrimaryKey() {
        str = " update eq_tjsq\n" +
                "    set tj_sqks = #{tjSqks,jdbcType=VARCHAR},\n" +
                "      tj_zbmc = #{tjZbmc,jdbcType=VARCHAR},\n" +
                "      tj_tprq = #{tjTprq,jdbcType=DATE},\n" +
                "      tj_sqly = #{tjSqly,jdbcType=VARCHAR},\n" +
                "      tj_drjbr = #{tjDrjbr,jdbcType=VARCHAR},\n" +
                "      tj_sqsj = #{tjSqsj,jdbcType=DATE},\n" +
                "      tj_sqtpgc = #{tjSqtpgc,jdbcType=VARCHAR},\n" +
                "      tj_sfyl = #{tjSfyl,jdbcType=VARCHAR},\n" +
                "      tj_sqzt = #{tjSqzt,jdbcType=VARCHAR},\n" +
                "      tj_czjg = #{tjCzjg,jdbcType=VARCHAR},\n" +
                "      tj_dpdzt = #{tjDpdzt,jdbcType=VARCHAR},\n" +
                "      tj_zhz = #{tjZhz,jdbcType=VARCHAR},\n" +
                "      tj_sqlx = #{tjSqlx,jdbcType=VARCHAR},\n" +
                "      tj_drksurl=#{tjDrksurl,jdbcType=VARCHAR}" +
                "    where id = #{id,jdbcType=VARCHAR}";
        return str;
    }

    private String getSelectSQL() {
        return "select id, bm_name,tj_zbmc,tj_drjbr,tj_sqsj\n" +
                "from s_bm \n" +
                "INNER JOIN eq_tjsq on s_bm.bm_id=eq_tjsq.tj_sqks";
    }

    public String selectSqJlByKey() {
            str=" select id,tj_sqks,tj_zbmc, " +
                " tj_sqly,tj_drjbr,tj_sqsj,tj_sqtpgc," +
                " tj_sqlx,tj_sfyl,tj_czjg,tj_zhz,tj_drksurl from eq_tjsq " +
                " where id = #{id}";
        return str;
    }
}
