package com.litbo.hospital.lifemanage.dao.MyMapper;



import com.litbo.hospital.lifemanage.bean.MyBean.EqBraz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EqBrazMapper {

    @Insert(" insert into eq_braz (id, br_bxid, br_zrmz, \n" +
            "      br_name, br_jibing, br_age, \n" +
            "      br_sex, br_jjdy, br_bqgc, \n" +
            "      br_bqbh, br_yisheng, br_hushi, \n" +
            "      br_sj)\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{brBxid,jdbcType=VARCHAR}, #{brZrmz,jdbcType=VARCHAR}, \n" +
            "      #{brName,jdbcType=VARCHAR}, #{brJibing,jdbcType=VARCHAR}, #{brAge,jdbcType=INTEGER}, \n" +
            "      #{brSex,jdbcType=VARCHAR}, #{brJjdy,jdbcType=VARCHAR}, #{brBqgc,jdbcType=VARCHAR}, \n" +
            "      #{brBqbh,jdbcType=VARCHAR}, #{brYisheng,jdbcType=VARCHAR}, #{brHushi,jdbcType=VARCHAR}, \n" +
            "      #{brSj,jdbcType=DATE})")
    int insertEqBraz(EqBraz braz);

    @Update("update eq_braz\n" +
        "    set br_bxid = #{brBxid,jdbcType=VARCHAR},\n" +
        "      br_zrmz = #{brZrmz,jdbcType=VARCHAR},\n" +
        "      br_name = #{brName,jdbcType=VARCHAR},\n" +
        "      br_jibing = #{brJibing,jdbcType=VARCHAR},\n" +
        "      br_age = #{brAge,jdbcType=INTEGER},\n" +
        "      br_sex = #{brSex,jdbcType=VARCHAR},\n" +
        "      br_jjdy = #{brJjdy,jdbcType=VARCHAR},\n" +
        "      br_bqgc = #{brBqgc,jdbcType=VARCHAR},\n" +
        "      br_bqbh = #{brBqbh,jdbcType=VARCHAR},\n" +
        "      br_yisheng = #{brYisheng,jdbcType=VARCHAR},\n" +
        "      br_hushi = #{brHushi,jdbcType=VARCHAR},\n" +
        "      br_sj = #{brSj,jdbcType=DATE}\n" +
        "    where id = #{id,jdbcType=VARCHAR}")
    Integer updateEqBraz(EqBraz braz);
    @Select("select * from eq_braz where br_bxid=#{bxid} ")
    EqBraz selectEqBrazById(String bxid);

}