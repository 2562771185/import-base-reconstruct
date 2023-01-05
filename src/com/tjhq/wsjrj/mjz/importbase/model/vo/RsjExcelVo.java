package com.tjhq.wsjrj.mjz.importbase.model.vo;

import com.tjhq.wsjrj.mjz.importbase.config.ExcelColumn;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * 人社局
 * 对应Excel中的数据行，必须和数据表一一对应
 */
public class RsjExcelVo implements Serializable {

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
     * 身份证号
     */
    @ExcelColumn(value = "身份证号", col = 4)
    private String sfzh;
    /**
     * 补贴类型
     */
    @ExcelColumn(value = "补贴类型", col = 5)
    private String btlx;

    /**
     * 培训时间
     */
    @ExcelColumn(value = "培训时间", col = 6)
    private String pxrq;


    /**
     * 是否失业
     */
    @ExcelColumn(value = "是否失业", col = 7)
    private String sfsy;

    /**
     * 参保状态
     */
    @ExcelColumn(value = "参保状态", col = 8)
    private String cbzt;

    /**
     * 月待遇金额
     */
    @ExcelColumn(value = "月待遇金额", col = 9)
    private Double ydyje;

    /**
     * 就业单位
     */
    @ExcelColumn(value = "就业单位", col = 10)
    private String jydw;

    /**
     * 补贴金额
     */
    @ExcelColumn(value = "补贴金额", col = 11)
    private Double btje;

    /**
     * 培训工种
     */
    @ExcelColumn(value = "培训工种", col = 12)
    private String pxgz;

    private static final long serialVersionUID = 1L;

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

    public String getBtlx() {
        return btlx;
    }

    public void setBtlx(String btlx) {
        this.btlx = btlx;
    }

    public String getPxrq() {
        return pxrq;
    }

    public void setPxrq(String pxrq) {
        this.pxrq = pxrq;
    }

    public String getSfsy() {
        return sfsy;
    }

    public void setSfsy(String sfsy) {
        this.sfsy = sfsy;
    }

    public String getCbzt() {
        return cbzt;
    }

    public void setCbzt(String cbzt) {
        this.cbzt = cbzt;
    }

    public Double getYdyje() {
        return ydyje;
    }

    public void setYdyje(Double ydyje) {
        this.ydyje = ydyje;
    }

    public String getJydw() {
        return jydw;
    }

    public void setJydw(String jydw) {
        this.jydw = jydw;
    }

    public Double getBtje() {
        return btje;
    }

    public void setBtje(Double btje) {
        this.btje = btje;
    }

    public String getPxgz() {
        return pxgz;
    }

    public void setPxgz(String pxgz) {
        this.pxgz = pxgz;
    }

    @Override
    public String toString() {
        return "人社局人员信息{" +
                "sznf='" + sznf + '\'' +
                ", szyf='" + szyf + '\'' +
                ", xm='" + xm + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", btlx='" + btlx + '\'' +
                ", pxrq='" + pxrq + '\'' +
                ", sfsy='" + sfsy + '\'' +
                ", cbzt='" + cbzt + '\'' +
                ", ydyje=" + ydyje +
                ", jydw='" + jydw + '\'' +
                ", btje=" + btje +
                ", pxgz='" + pxgz + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RsjExcelVo that = (RsjExcelVo) o;

        return new EqualsBuilder().append(sznf, that.sznf).append(szyf, that.szyf).append(xm, that.xm).append(sfzh, that.sfzh).append(btlx, that.btlx).append(pxrq, that.pxrq).append(sfsy, that.sfsy).append(cbzt, that.cbzt).append(ydyje, that.ydyje).append(jydw, that.jydw).append(btje, that.btje).append(pxgz, that.pxgz).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(sznf).append(szyf).append(xm).append(sfzh).append(btlx).append(pxrq).append(sfsy).append(cbzt).append(ydyje).append(jydw).append(btje).append(pxgz).toHashCode();
    }
}