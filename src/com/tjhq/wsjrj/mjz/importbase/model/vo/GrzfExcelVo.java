package com.tjhq.wsjrj.mjz.importbase.model.vo;

import com.tjhq.wsjrj.mjz.importbase.annotation.ExcelColumn;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * 对应Excel中的数据行，必须和数据表一一对应
 */
public class GrzfExcelVo {

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
     * 个人自付金额
     */
    @ExcelColumn(value = "个人自付金额", col = 5)
    private Double grzfje;


    public GrzfExcelVo() {
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

    public Double getGrzfje() {
        return grzfje;
    }

    public void setGrzfje(Double grzfje) {
        this.grzfje = grzfje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GrzfExcelVo that = (GrzfExcelVo) o;

        return new EqualsBuilder().append(sznf, that.sznf).append(szyf, that.szyf).append(xm, that.xm).append(sfzh, that.sfzh).append(grzfje, that.grzfje).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(sznf).append(szyf).append(xm).append(sfzh).append(grzfje).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sznf", sznf)
                .append("szyf", szyf)
                .append("xm", xm)
                .append("sfzh", sfzh)
                .append("grzfje", grzfje)
                .toString();
    }
}
