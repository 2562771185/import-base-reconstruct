package com.tjhq.wsjrj.mjz.importbase.model.vo;


import com.tjhq.wsjrj.mjz.importbase.annotation.ExcelColumn;


/**
 * 对应Excel中的数据行，必须和数据表一一对应
 */
public class CLExcelVo {

    /**
     * 所属年份
     */
    @ExcelColumn(value = "所属年份", col = 1)
    private String sznf;

    /**
     * 所属月份
     */
    @ExcelColumn(value = "所属月份", col = 2)
    private String szyf;
    /**
     * 姓名
     */
    @ExcelColumn(value = "姓名", col = 3)
    private String xm;

    /**
     * 身份证
     */
    @ExcelColumn(value = "身份证号", col = 4)
    private String sfzh;

    /**
     * 残疾证号
     */
    @ExcelColumn(value = "残疾证号", col = 5)
    private String cjzh;

    /**
     * 残疾类别
     */
    @ExcelColumn(value = "残疾类别", col = 6)
    private String cjlb;

    /**
     * 残疾等级
     */
    @ExcelColumn(value = "残疾等级", col = 7)
    private String cjdj;

    /**
     * 残疾详情
     */
    @ExcelColumn(value = "残疾详情")
    private String cjxq;

    /**
     * 持证状态
     */
    @ExcelColumn(value = "持证状态", col = 8)
    private String czzt;


    public CLExcelVo() {
    }


    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getCjzh() {
        return cjzh;
    }

    public void setCjzh(String cjzh) {
        this.cjzh = cjzh;
    }

    public String getCjlb() {
        return cjlb;
    }

    public void setCjlb(String cjlb) {
        this.cjlb = cjlb;
    }

    public String getCjdj() {
        return cjdj;
    }

    public void setCjdj(String cjdj) {
        this.cjdj = cjdj;
    }

    public String getCjxq() {
        return cjxq;
    }

    public void setCjxq(String cjxq) {
        this.cjxq = cjxq;
    }

    public String getCzzt() {
        return czzt;
    }

    public void setCzzt(String czzt) {
        this.czzt = czzt;
    }

    public String getSznf() {
        return sznf;
    }

    public void setSznf(String sznf) {
        this.sznf = sznf;
    }

    public String getSzyf() {
        return szyf;
    }

    public void setSzyf(String szyf) {
        this.szyf = szyf;
    }

    @Override
    public String toString() {
        return "残联人员信息{" +
                "sznf='" + sznf + '\'' +
                ", szyf='" + szyf + '\'' +
                ", xm='" + xm + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", cjzh='" + cjzh + '\'' +
                ", cjlb='" + cjlb + '\'' +
                ", cjdj='" + cjdj + '\'' +
                ", cjxq='" + cjxq + '\'' +
                ", czzt='" + czzt + '\'' +
                '}';
    }
}
