package com.tjhq.wsjrj.mjz.importbase.model.vo;

import com.tjhq.wsjrj.mjz.importbase.annotation.ExcelColumn;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * 乡村振兴
 * 对应Excel中的数据行，必须和数据表一一对应
 */
public class XczxExcelVo implements Serializable {

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
     * 身份证号
     */
    @ExcelColumn(value = "身份证号", col = 3)
    private String sfzh;

    /**
     * 户主姓名
     */
    @ExcelColumn(value = "户主姓名", col = 4)
    private String jtcy;

    /**
     * 户主身份证号码
     */
    @ExcelColumn(value = "户主身份证号码", col = 5)
    private String hzsfzh;

    /**
     * 与户主关系
     */
    @ExcelColumn(value = "与户主关系", col = 6)
    private String yhzgx;

    /**
     * 家庭成员
     */
    @ExcelColumn(value = "家庭成员", col = 7)
    private String xm;

    /**
     * 户类型
     */
    @ExcelColumn(value = "户类型", col = 8)
    private String hlx;

    /**
     * 监测对象类型
     */
    @ExcelColumn(value = "监测对象类型", col = 9)
    private String jcdxlx;

    /**
     * 风险是否消除
     */
    @ExcelColumn(value = "风险是否消除", col = 10)
    private String fxsfxc;

    /**
     * 识别年度
     */
    @ExcelColumn(value = "识别年度", col = 11)
    private String sbnd;

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

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getJtcy() {
        return jtcy;
    }

    public void setJtcy(String jtcy) {
        this.jtcy = jtcy;
    }

    public String getHzsfzh() {
        return hzsfzh;
    }

    public void setHzsfzh(String hzsfzh) {
        this.hzsfzh = hzsfzh;
    }

    public String getYhzgx() {
        return yhzgx;
    }

    public void setYhzgx(String yhzgx) {
        this.yhzgx = yhzgx;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getHlx() {
        return hlx;
    }

    public void setHlx(String hlx) {
        this.hlx = hlx;
    }

    public String getJcdxlx() {
        return jcdxlx;
    }

    public void setJcdxlx(String jcdxlx) {
        this.jcdxlx = jcdxlx;
    }

    public String getFxsfxc() {
        return fxsfxc;
    }

    public void setFxsfxc(String fxsfxc) {
        this.fxsfxc = fxsfxc;
    }

    public String getSbnd() {
        return sbnd;
    }

    public void setSbnd(String sbnd) {
        this.sbnd = sbnd;
    }

    @Override
    public String toString() {
        return "乡村振兴人员信息{" +
                "sznf='" + sznf + '\'' +
                ", szyf='" + szyf + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", jtcy='" + jtcy + '\'' +
                ", hzsfzh='" + hzsfzh + '\'' +
                ", yhzgx='" + yhzgx + '\'' +
                ", xm='" + xm + '\'' +
                ", hlx='" + hlx + '\'' +
                ", jcdxlx='" + jcdxlx + '\'' +
                ", fxsfxc='" + fxsfxc + '\'' +
                ", sbnd='" + sbnd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        XczxExcelVo that = (XczxExcelVo) o;

        return new EqualsBuilder().append(sznf, that.sznf).append(szyf, that.szyf).append(sfzh, that.sfzh).append(jtcy, that.jtcy).append(hzsfzh, that.hzsfzh).append(yhzgx, that.yhzgx).append(xm, that.xm).append(hlx, that.hlx).append(jcdxlx, that.jcdxlx).append(fxsfxc, that.fxsfxc).append(sbnd, that.sbnd).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(sznf).append(szyf).append(sfzh).append(jtcy).append(hzsfzh).append(yhzgx).append(xm).append(hlx).append(jcdxlx).append(fxsfxc).append(sbnd).toHashCode();
    }
}