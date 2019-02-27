package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.bean.SGroupUser;
import com.litbo.hospital.supervise.dao.provider.GroupProvider;
import com.litbo.hospital.supervise.vo.GroupPerCateGoryUserMSGDetailVO;
import com.litbo.hospital.supervise.vo.GroupUserSelectVO;
import com.litbo.hospital.supervise.vo.SGroupSelectVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupDao {
    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag ,sh_yj from s_group")
    public List<SGroup> getGroups() ;
    @Select("select sp.group_id, sp.bm_id,bm.bm_name, sp.group_name, sp.user_id1,emp1.user_xm as userName1, \n" +
            "sp.create_time, sp.user_id2,emp2.user_xm as userName2, sp.sh_time, sp.sh_flag ,sp.sh_yj \n" +
            "FROM s_group sp  LEFT JOIN s_bm bm on (sp.bm_id=bm.bm_id) \n" +
            "LEFT JOIN s_emp emp1 ON (sp.user_id1 = emp1.user_id)\n" +
            "LEFT JOIN s_emp emp2 ON (sp.user_id2 = emp2.user_id) ")
    List<SGroupSelectVO> getSelectGroups();
    @SelectProvider(type = GroupProvider.class,method = "selectGroupByBmNameAndGName")
    List<SGroupSelectVO> getSelectGroupsByBmNameAndGNameAndShCode(@Param("bmName") String bmName,@Param("groupName") String groupName,@Param("shCode") String shCode);

    @Select("select sp.group_id, sp.bm_id,bm.bm_name, sp.group_name, sp.user_id1,emp1.user_xm as userName1, \n" +
            "sp.create_time, sp.user_id2,emp2.user_xm as userName2, sp.sh_time, sp.sh_flag ,sp.sh_yj \n" +
            "FROM s_group sp  LEFT JOIN s_bm bm on (sp.bm_id=bm.bm_id) \n" +
            "LEFT JOIN s_emp emp1 ON (sp.user_id1 = emp1.user_id)\n" +
            "LEFT JOIN s_emp emp2 ON (sp.user_id2 = emp2.user_id) where sp.sh_flag=#{shCode} ")
    List<SGroupSelectVO> getSelectGroupsByShCode(String shCode);

    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag ,sh_yj from s_group where group_id=#{group_id}")
    SGroup getGroupById(String group_id);
    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag,sh_yj from s_group " +
            " where user_id2=#{shrId} and sh_flag=1")
    SGroup getDshGroupByShr(String shrId);
    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag ,sh_yj " +
            "from s_group where sh_flag=0")
    List<SGroup> getYTHGroup();
    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag ,sh_yj " +
            "from s_group where sh_flag=0 and user_id1=#{createId}")
    List<SGroup> getYTHGroupByCId(String createId);

    @Insert("insert into s_group (group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag,sh_yj) " +
            " values(#{groupId},#{bmId},#{groupName},#{userId1},#{createTime},#{userId2},#{shTime},#{shFlag},#{shYj}) ")
    void saveGroup(SGroup group);

    @Insert("insert into s_group_users (group_id, user_id, gw_id) " +
            " values(#{groupId},#{userId},#{gwId}) ")
    void saveGroupUser(SGroupUser user);

    @Select("SELECT u.gu_id,u.group_id, u.gw_id,u.user_id ,emp.user_xm ,gw.gw_name " +
            " from s_group_users u INNER JOIN s_emp emp on (u.user_id=emp.user_id)" +
            " INNER JOIN s_gangwei gw ON (u.gw_id=gw.gw_id)" +
            " WHERE u.group_id = #{gid}")
    List<GroupUserSelectVO> getGroupUserSelectByGId(String gid);

//    @Select("select sp.group_id, bm.bm_name, sp.group_name, sp.user_id1, sp.create_time, sp.user_id2, sp.sh_time, sp.sh_flag ,sp.sh_yj " +
//            " FROM s_group sp  INNER JOIN s_bm bm on (sp.bm_id=bm.bm_id)\n" +
//            " WHERE sp.group_id = #{gid}")
    @Select("select sp.group_id,sp.bm_id, bm.bm_name, sp.group_name, sp.user_id1,emp1.user_xm as userName1, \n" +
            "sp.create_time, sp.user_id2,emp2.user_xm as userName2, sp.sh_time, sp.sh_flag ,sp.sh_yj \n" +
            "FROM s_group sp  INNER JOIN s_bm bm on (sp.bm_id=bm.bm_id) \n" +
            "INNER JOIN s_emp emp1 ON (sp.user_id1 = emp1.user_id)\n" +
            "INNER JOIN s_emp emp2 ON (sp.user_id2 = emp2.user_id)\n" +
            "WHERE sp.group_id = #{gid}")
    SGroupSelectVO getGroupSelectByGId(String gid);

    @Update("update s_group set sh_time = #{shTime},sh_flag = #{shFlag},sh_yj=#{shYj} " +
            " where group_id = #{groupId}")
    void updateShGroup(SGroup group);


    @Select("select gu_id, group_id, user_id, gw_id from s_group_users where gu_id = #{guId}")
    SGroupUser getGroupUserByGuId(Integer guId);
    @Update("update s_group_users set group_id = #{groupId},user_id = #{userId},gw_id=#{gwId} " +
            " where gu_id = #{guId}")
    void updateGroupUser(SGroupUser user);

    @Select("select emp.user_xm " +
            " from s_group_users users  INNER JOIN s_emp emp on (users.user_id=emp.user_id) " +
            " INNER JOIN s_gangwei gw ON (users.gw_id=gw.gw_id) " +
            " WHERE gw.gw_name=#{gwName} and users.group_id=#{groupId}")
    List<String> getEmpXMByGIdAndGWXm(@Param("groupId") Integer groupId, @Param("gwName") String gwName);

    @Select(" select bm.obm_id,bm.bm_id,bm.bm_name,bm.user_id,bm.bm_tel,bm.bm_addr,bm.wx_flag,bm.p_bm_id,bm.xbm_flag " +
            " from s_bm bm LEFT JOIN s_group gp on (bm.bm_id=gp.bm_id) " +
            " where gp.bm_id is null and bm.xbm_flag=0 ")
    List<SBm> listWclGroupBm();


    @Select("    SELECT bm.bm_name,  emp.user_xm,sex.sex,emp.tel\n" +
            "    from s_group gp\n" +
            "    INNER JOIN s_group_users gpu on (gp.group_id=gpu.group_id)\n" +
            "    INNER JOIN s_gangwei gw ON (gpu.gw_id=gw.gw_id)\n" +
            "    INNER JOIN s_emp emp ON (emp.user_id=gpu.user_id)\n" +
            "    INNER JOIN s_bm bm ON (bm.bm_id=gp.bm_id)\n" +
            "    INNER JOIN s_sex sex ON (sex.sex_id=emp.sex_id)\n" +
            "    where gw.gw_name=#{gwName}")
    List<GroupPerCateGoryUserMSGDetailVO> listPreEmps(String gwName);

    @SelectProvider(type = GroupProvider.class,method = "listPreEmpsByBmNameAndGwName")
    List<GroupPerCateGoryUserMSGDetailVO> listPreEmpsByBmNameAndGwName(@Param("gwName") String gwName, @Param("userXm")String userXm, @Param("bmName")String bmName);

//    SELECT * from s_group_users u INNER JOIN s_emp emp on (u.user_id=emp.user_id) INNER JOIN s_gangwei gw ON (u.gw_id=gw.gw_id)gw_id
}
