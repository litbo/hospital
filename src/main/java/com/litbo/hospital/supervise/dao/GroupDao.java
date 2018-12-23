package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.bean.SGroupUser;
import com.litbo.hospital.supervise.vo.GroupUserSelectVO;
import com.litbo.hospital.supervise.vo.SGroupSelectVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GroupDao {
    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag ,sh_yj from s_group")
    public List<SGroup> getGroups() ;
    @Select("select sp.group_id, sp.bm_id,bm.bm_name, sp.group_name, sp.user_id1,emp1.user_xm as userName1, \n" +
            "sp.create_time, sp.user_id2,emp2.user_xm as userName2, sp.sh_time, sp.sh_flag ,sp.sh_yj \n" +
            "FROM s_group sp  INNER JOIN s_bm bm on (sp.bm_id=bm.bm_id) \n" +
            "INNER JOIN s_emp emp1 ON (sp.user_id1 = emp1.user_id)\n" +
            "INNER JOIN s_emp emp2 ON (sp.user_id2 = emp2.user_id) ")
    List<SGroupSelectVO> getSelectGroups();

    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag ,sh_yj from s_group where group_id=#{group_id}")
    SGroup getGroupById(String group_id);
    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag,sh_yj from s_group " +
            " where user_id2=#{shrId} and sh_flag=1")
    SGroup getDshGroupByShr(String shrId);
    @Select("select group_id, bm_id, group_name, user_id1, create_time, user_id2, sh_time, sh_flag ,sh_yj " +
            "from s_group where sh_flag=0")
    List<SGroup> getYTHGroup();

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



//    SELECT * from s_group_users u INNER JOIN s_emp emp on (u.user_id=emp.user_id) INNER JOIN s_gangwei gw ON (u.gw_id=gw.gw_id)gw_id
}
