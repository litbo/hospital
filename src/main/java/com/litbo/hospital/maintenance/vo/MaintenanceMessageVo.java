package com.litbo.hospital.maintenance.vo;

/**
 * @Author: 樊小铭
 * Date: 2019/9/17 18:12
 * @Version:
 * @Description:
 */
public class MaintenanceMessageVo {
    private String eqCatagory; // 设备分类
    private String weiBaoRen;// 维保人
    private String weiBaoZeRenRen;// 维保责任人
    private String fenLeiBianMa; // 设备分类编码
    private String sheBeiMingCheng;// 装备名称
    private String guiGeXingHao;// 规格型号
    private String xuLieHao;// 序列号
    private String shengChanChangJia;// 生产厂家
    private String chanDi;// 产地
    private String shiYongKeShi;// 使用科室
    private String qiYongShiJian;// 启用时间
    private String danJia;// 单价
    private String baoYangShiJian;// 保养时间
    private String yiQiXianZhuang;// 仪器现状
    private String beiZhu;// 备注
    private String weiHuRenYuan;// 维护人员
    private String jianChaRiQi;// 检查日期
    private String keShiQianShou;// 科室签收
    private String wanChengRiQi;// 完成日期

    public MaintenanceMessageVo() {
    }

    public MaintenanceMessageVo(String eqCatagory, String weiBaoRen, String weiBaoZeRenRen, String fenLeiBianMa, String sheBeiMingCheng, String guiGeXingHao, String xuLieHao, String shengChanChangJia, String chanDi, String shiYongKeShi, String qiYongShiJian, String danJia, String baoYangShiJian, String yiQiXianZhuang, String beiZhu, String weiHuRenYuan, String jianChaRiQi, String keShiQianShou, String wanChengRiQi) {
        this.eqCatagory = eqCatagory;
        this.weiBaoRen = weiBaoRen;
        this.weiBaoZeRenRen = weiBaoZeRenRen;
        this.fenLeiBianMa = fenLeiBianMa;
        this.sheBeiMingCheng = sheBeiMingCheng;
        this.guiGeXingHao = guiGeXingHao;
        this.xuLieHao = xuLieHao;
        this.shengChanChangJia = shengChanChangJia;
        this.chanDi = chanDi;
        this.shiYongKeShi = shiYongKeShi;
        this.qiYongShiJian = qiYongShiJian;
        this.danJia = danJia;
        this.baoYangShiJian = baoYangShiJian;
        this.yiQiXianZhuang = yiQiXianZhuang;
        this.beiZhu = beiZhu;
        this.weiHuRenYuan = weiHuRenYuan;
        this.jianChaRiQi = jianChaRiQi;
        this.keShiQianShou = keShiQianShou;
        this.wanChengRiQi = wanChengRiQi;
    }

    @Override
    public String toString() {
        return "MaintenanceMessageVo{" +
                "eqCatagory='" + eqCatagory + '\'' +
                ", weiBaoRen='" + weiBaoRen + '\'' +
                ", weiBaoZeRenRen='" + weiBaoZeRenRen + '\'' +
                ", fenLeiBianMa='" + fenLeiBianMa + '\'' +
                ", sheBeiMingCheng='" + sheBeiMingCheng + '\'' +
                ", guiGeXingHao='" + guiGeXingHao + '\'' +
                ", xuLieHao='" + xuLieHao + '\'' +
                ", shengChanChangJia='" + shengChanChangJia + '\'' +
                ", chanDi='" + chanDi + '\'' +
                ", shiYongKeShi='" + shiYongKeShi + '\'' +
                ", qiYongShiJian='" + qiYongShiJian + '\'' +
                ", danJia='" + danJia + '\'' +
                ", baoYangShiJian='" + baoYangShiJian + '\'' +
                ", yiQiXianZhuang='" + yiQiXianZhuang + '\'' +
                ", beiZhu='" + beiZhu + '\'' +
                ", weiHuRenYuan='" + weiHuRenYuan + '\'' +
                ", jianChaRiQi='" + jianChaRiQi + '\'' +
                ", keShiQianShou='" + keShiQianShou + '\'' +
                ", wanChengRiQi='" + wanChengRiQi + '\'' +
                '}';
    }

    public String getEqCatagory() {
        return eqCatagory;
    }

    public void setEqCatagory(String eqCatagory) {
        this.eqCatagory = eqCatagory;
    }

    public String getWeiBaoRen() {
        return weiBaoRen;
    }

    public void setWeiBaoRen(String weiBaoRen) {
        this.weiBaoRen = weiBaoRen;
    }

    public String getWeiBaoZeRenRen() {
        return weiBaoZeRenRen;
    }

    public void setWeiBaoZeRenRen(String weiBaoZeRenRen) {
        this.weiBaoZeRenRen = weiBaoZeRenRen;
    }

    public String getFenLeiBianMa() {
        return fenLeiBianMa;
    }

    public void setFenLeiBianMa(String fenLeiBianMa) {
        this.fenLeiBianMa = fenLeiBianMa;
    }

    public String getSheBeiMingCheng() {
        return sheBeiMingCheng;
    }

    public void setSheBeiMingCheng(String sheBeiMingCheng) {
        this.sheBeiMingCheng = sheBeiMingCheng;
    }

    public String getGuiGeXingHao() {
        return guiGeXingHao;
    }

    public void setGuiGeXingHao(String guiGeXingHao) {
        this.guiGeXingHao = guiGeXingHao;
    }

    public String getXuLieHao() {
        return xuLieHao;
    }

    public void setXuLieHao(String xuLieHao) {
        this.xuLieHao = xuLieHao;
    }

    public String getShengChanChangJia() {
        return shengChanChangJia;
    }

    public void setShengChanChangJia(String shengChanChangJia) {
        this.shengChanChangJia = shengChanChangJia;
    }

    public String getChanDi() {
        return chanDi;
    }

    public void setChanDi(String chanDi) {
        this.chanDi = chanDi;
    }

    public String getShiYongKeShi() {
        return shiYongKeShi;
    }

    public void setShiYongKeShi(String shiYongKeShi) {
        this.shiYongKeShi = shiYongKeShi;
    }

    public String getQiYongShiJian() {
        return qiYongShiJian;
    }

    public void setQiYongShiJian(String qiYongShiJian) {
        this.qiYongShiJian = qiYongShiJian;
    }

    public String getDanJia() {
        return danJia;
    }

    public void setDanJia(String danJia) {
        this.danJia = danJia;
    }

    public String getBaoYangShiJian() {
        return baoYangShiJian;
    }

    public void setBaoYangShiJian(String baoYangShiJian) {
        this.baoYangShiJian = baoYangShiJian;
    }

    public String getYiQiXianZhuang() {
        return yiQiXianZhuang;
    }

    public void setYiQiXianZhuang(String yiQiXianZhuang) {
        this.yiQiXianZhuang = yiQiXianZhuang;
    }

    public String getBeiZhu() {
        return beiZhu;
    }

    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }

    public String getWeiHuRenYuan() {
        return weiHuRenYuan;
    }

    public void setWeiHuRenYuan(String weiHuRenYuan) {
        this.weiHuRenYuan = weiHuRenYuan;
    }

    public String getJianChaRiQi() {
        return jianChaRiQi;
    }

    public void setJianChaRiQi(String jianChaRiQi) {
        this.jianChaRiQi = jianChaRiQi;
    }

    public String getKeShiQianShou() {
        return keShiQianShou;
    }

    public void setKeShiQianShou(String keShiQianShou) {
        this.keShiQianShou = keShiQianShou;
    }

    public String getWanChengRiQi() {
        return wanChengRiQi;
    }

    public void setWanChengRiQi(String wanChengRiQi) {
        this.wanChengRiQi = wanChengRiQi;
    }
}
