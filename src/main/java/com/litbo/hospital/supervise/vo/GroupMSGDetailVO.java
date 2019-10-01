package com.litbo.hospital.supervise.vo;

public class GroupMSGDetailVO {

//    使用科室医学装备管理小组组长             组长
//    使用科室医学装备管理小组副组长          副组长
//    使用科室质量安全管理人员	           质安管理人员
//    使用科室资产管理员                   资产管理人员
//    使用科室计量员                       计量管理人员
//    使用科室监测联络员                    监测联络员
//    使用科室质检员                       质控管理人员

//    使用科室设备授权操作人员	3	修改
//    使用科室设备保管人	3	修改
//    使用科室资产管理员	3	修改
//    使用科室医学装备管理小组成员	3	修改

    private String  bmName;
    private String[] zzs;  //    组长
    private String[] fzzs;  //   副组长
    private String[] zagls;  //    质安管理人员
    private String[] zcgls;  //    资产管理人员
    private String[] jlgls;  //    计量管理人员
    private String[] jclls;  //    监测联络员
    private String[] zkgls;  //    质控管理人员

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String[] getZzs() {
        return zzs;
    }

    public void setZzs(String[] zzs) {
        this.zzs = zzs;
    }

    public String[] getFzzs() {
        return fzzs;
    }

    public void setFzzs(String[] fzzs) {
        this.fzzs = fzzs;
    }

    public String[] getZagls() {
        return zagls;
    }

    public void setZagls(String[] zagls) {
        this.zagls = zagls;
    }

    public String[] getZcgls() {
        return zcgls;
    }

    public void setZcgls(String[] zcgls) {
        this.zcgls = zcgls;
    }

    public String[] getJlgls() {
        return jlgls;
    }

    public void setJlgls(String[] jlgls) {
        this.jlgls = jlgls;
    }

    public String[] getJclls() {
        return jclls;
    }

    public void setJclls(String[] jclls) {
        this.jclls = jclls;
    }

    public String[] getZkgls() {
        return zkgls;
    }

    public void setZkgls(String[] zkgls) {
        this.zkgls = zkgls;
    }
}
