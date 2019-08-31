package com.litbo.hospital.lifemanage.dao.provider.MyProvider;

public class SgYsProvider {
    private static String str = "";

    public String deleteByPrimaryKey(String ysId) {
        str = "delete from sg_ys where ys_id = #{ysId} ";
        return str;
    }

    public String insert() {
        str = "insert into sg_ys (ys_id, ys_dabh, ht_id, \n" +
                "      sg_id, ys_zzshjg, ys_zzshr, \n" +
                "      ys_zxd, ys_sms, ys_czsc, ys_wxsc, \n" +
                "      ys_qtjszl, ys_cphgzm, ys_bxk, ys_3crz, \n" +
                "      ys_jlqjrz, ys_bgd, ys_jyjyzm, ys_isgfxqx, \n" +
                "      ys_bzbs, ys_bq, ys_gfxsms, ys_hgzm, \n" +
                "      ys_qtcl)  values (#{ysId,jdbcType=VARCHAR}, " +
                "      #{ysDabh,jdbcType=VARCHAR}, #{htId,jdbcType=VARCHAR}, \n" +
                "      #{sgId,jdbcType=VARCHAR}, #{ysZzshjg,jdbcType=CHAR}," +
                "      #{ysZzshr,jdbcType=VARCHAR}, \n" +
                "      #{ysZxd,jdbcType=VARCHAR}, #{ysSms,jdbcType=CHAR}, " +
                "      #{ysCzsc,jdbcType=CHAR}, #{ysWxsc,jdbcType=CHAR}, \n" +
                "      #{ysQtjszl,jdbcType=CHAR}, #{ysCphgzm,jdbcType=CHAR}," +
                "      #{ysBxk,jdbcType=CHAR}, #{ys3crz,jdbcType=CHAR}, \n" +
                "      #{ysJlqjrz,jdbcType=CHAR}, #{ysBgd,jdbcType=CHAR}," +
                "      #{ysJyjyzm,jdbcType=CHAR}, #{ysIsgfxqx,jdbcType=CHAR}, \n" +
                "   #{ysBzbs,jdbcType=CHAR}, #{ysBq,jdbcType=CHAR}, #{ysGfxsms,jdbcType=CHAR}, #{ysHgzm,jdbcType=CHAR}, \n" +
                "   #{ysQtcl,jdbcType=CHAR}";
        return str;
    }
        public String selectByPrimaryKey(){
            str=getSelectAll()+" where ys_id=#{ysId}";
            return str;


    }

    public String selectByExample() {
        str="<script>"+getSelectAll()+
                "<if test=\"_parameter != null\">\n" +
                " <where>\n" +
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
                "    </if>"+
                " <if test=\"orderByClause != null\">\n" +
                "      order by ${orderByClause} ${sort}\n" +
                "    </if>"+
                "</script>";
        return str;

    }
    private String getSelectAll(){
        return " select * from sg_ys ";
    }
}
