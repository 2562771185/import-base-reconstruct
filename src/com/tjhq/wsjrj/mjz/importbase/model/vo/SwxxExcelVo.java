package com.tjhq.wsjrj.mjz.importbase.model.vo;

import com.tjhq.wsjrj.mjz.importbase.config.ExcelColumn;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 
 * fm_hrmdata_swxx 表对应的excel
 */
public class SwxxExcelVo implements Serializable {

    /**
     * 所属年份
     */
    @ExcelColumn(value = "所属年份",col =1)
    private String sznf;

    /**
     * 所在月份
     */
    @ExcelColumn(value = "所属月份",col = 2)
    private String szyf;

    /**
     * 姓名
     */
    @ExcelColumn(value = "姓名",col = 3)
    private String xm;

    /**
     * 身份证号
     */
    @ExcelColumn(value = "身份证号",col = 4)
    private String sfzh;

    /**
     * 死亡时间
     */
    @ExcelColumn(value = "死亡时间",col = 5)
    private String swsj;
    /**
     * 是否死亡
     */
    @ExcelColumn(value = "是否死亡",col = 6)
    private String sfsw;

    /**
     * 数据来源
     */
    @ExcelColumn(value = "数据来源",col = 7)
    private String sjly;

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

    public String getSwsj() {
        return swsj;
    }

    public void setSwsj(String swsj) {
        this.swsj = swsj;
    }

    public String getSfsw() {
        return sfsw;
    }

    public void setSfsw(String sfsw) {
        this.sfsw = sfsw;
    }

    public String getSjly() {
        return sjly;
    }

    public void setSjly(String sjly) {
        this.sjly = sjly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SwxxExcelVo that = (SwxxExcelVo) o;

        return new EqualsBuilder().append(sznf, that.sznf).append(szyf, that.szyf).append(xm, that.xm).append(sfzh, that.sfzh).append(swsj, that.swsj).append(sfsw, that.sfsw).append(sjly, that.sjly).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(sznf).append(szyf).append(xm).append(sfzh).append(swsj).append(sfsw).append(sjly).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sznf", sznf)
                .append("szyf", szyf)
                .append("xm", xm)
                .append("sfzh", sfzh)
                .append("swsj", swsj)
                .append("sfsw", sfsw)
                .append("sjly", sjly)
                .toString();
    }
}