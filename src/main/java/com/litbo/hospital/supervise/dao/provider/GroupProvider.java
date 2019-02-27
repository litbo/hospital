package com.litbo.hospital.supervise.dao.provider;

public class GroupProvider {

    public String selectGroupByBmNameAndGName(String bmName, String groupName,String shCode){
/**    @Select("select sp.group_id, sp.bm_id,bm.bm_name, sp.group_name, sp.user_id1,emp1.user_xm as userName1, \n" +
                "sp.create_time, sp.user_id2,emp2.user_xm as userName2, sp.sh_time, sp.sh_flag ,sp.sh_yj \n" +
                "FROM s_group sp  LEFT JOIN s_bm bm on (sp.bm_id=bm.bm_id) \n" +
                "LEFT JOIN s_emp emp1 ON (sp.user_id1 = emp1.user_id)\n" +
                "LEFT JOIN s_emp emp2 ON (sp.user_id2 = emp2.user_id) ")*/
        StringBuffer sql = new StringBuffer("" +
                "   select sp.group_id, sp.bm_id,bm.bm_name, sp.group_name, sp.user_id1,emp1.user_xm as userName1, sp.create_time, sp.user_id2,emp2.user_xm as userName2, sp.sh_time, sp.sh_flag ,sp.sh_yj " +
                "   FROM s_group sp  LEFT JOIN s_bm bm on (sp.bm_id=bm.bm_id) " +
                "   LEFT JOIN s_emp emp1 ON (sp.user_id1 = emp1.user_id) " +
                "   LEFT JOIN s_emp emp2 ON (sp.user_id2 = emp2.user_id) " +
                "   where 1=1 and sp.sh_flag=#{shCode}" );
        if(bmName!=null)  sql.append(" and bm.bm_name Like '%'+#{bmName}+'%'");
        if(groupName!=null) sql.append(" and sp.group_name Like '%'+#{groupName}+'%'");
        return sql.toString();
    }

    public String listPreEmpsByBmNameAndGwName(String gwName, String userXm,String bmName){

        StringBuffer sql = new StringBuffer("" +
                "   SELECT bm.bm_name,  emp.user_xm,sex.sex,emp.tel " +
                "   from s_group gp " +
                "   INNER JOIN s_group_users gpu on (gp.group_id=gpu.group_id) " +
                "   INNER JOIN s_gangwei gw ON (gpu.gw_id=gw.gw_id) " +
                "   INNER JOIN s_emp emp ON (emp.user_id=gpu.user_id) " +
                "   INNER JOIN s_bm bm ON (bm.bm_id=gp.bm_id) " +
                "   INNER JOIN s_sex sex ON (sex.sex_id=emp.sex_id) " +
                "   where  gw.gw_name=#{gwName}" );
        if(userXm!=null)  sql.append(" and emp.user_xm Like '%'+#{userXm}+'%'");
        if(bmName!=null) sql.append(" and bm.bm_name Like '%'+#{bmName}+'%'");
        return sql.toString();
    }
}
