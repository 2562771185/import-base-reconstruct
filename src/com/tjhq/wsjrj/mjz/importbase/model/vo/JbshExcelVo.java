package com.tjhq.wsjrj.mjz.importbase.model.vo;


import com.tjhq.wsjrj.mjz.importbase.annotation.ExcelColumn;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * 对应Excel中的数据行，必须和数据表一一对应
 */
public class JbshExcelVo {

    /**
     * 所属年份
     */
    @ExcelColumn(value = "所属年份",col = 1)
    private String sznf;

    /**
     * 所属月份
     */
    @ExcelColumn(value = "所属月份", col = 2)
    private String szyf;
    /**
     * 姓名
     */
    @ExcelColumn(value = "姓名",col = 3)
    private String xm;

    /**
     * 身份证
     */
    @ExcelColumn(value = "身份证号",col = 4)
    private String sfzh;

    /**
     * 基本生活保障类别
     */
    @ExcelColumn(value = "基本生活保障类型", col = 5)
    private String hbzlx;


    public JbshExcelVo() {
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

    public String getHbzlx() {
        return hbzlx;
    }

    public void setHbzlx(String hbzlx) {
        this.hbzlx = hbzlx;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sznf", sznf)
                .append("szyf", szyf)
                .append("xm", xm)
                .append("sfzh", sfzh)
                .append("hbzlx", hbzlx)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JbshExcelVo that = (JbshExcelVo) o;

        return new EqualsBuilder().append(sznf, that.sznf).append(szyf, that.szyf).append(xm, that.xm).append(sfzh, that.sfzh).append(hbzlx, that.hbzlx).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(sznf).append(szyf).append(xm).append(sfzh).append(hbzlx).toHashCode();
    }
}
