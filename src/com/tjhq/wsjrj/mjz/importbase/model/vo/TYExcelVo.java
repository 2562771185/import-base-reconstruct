package com.tjhq.wsjrj.mjz.importbase.model.vo;

import com.tjhq.wsjrj.mjz.importbase.annotation.ExcelColumn;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


/**
 * 退役
 * 对应Excel中的数据行，必须和数据表一一对应
 */
public class TYExcelVo {

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
     * 人员类别
     */
    @ExcelColumn(value = "人员类别", col = 5)
    private String rylb;

    /**
     * 对象状态
     */
    @ExcelColumn(value = "对象状态", col = 6)
    private String dxzt;

    /**
     * 入伍时间
     */
    @ExcelColumn(value = "入伍时间", col = 7)
    private String rwsj;

    /**
     * 退伍时间
     */
    @ExcelColumn(value = "退伍时间", col = 8)
    private String twsj;

    public TYExcelVo() {
    }

    public String getSznf() {
        return sznf;
    }

    public void setSznf(String ssnf) {
        this.sznf = ssnf;
    }

    public String getSzyf() {
        return szyf;
    }

    public void setSzyf(String ssyf) {
        this.szyf = ssyf;
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

    public String getRylb() {
        return rylb;
    }

    public void setRylb(String rylb) {
        this.rylb = rylb;
    }

    public String getDxzt() {
        return dxzt;
    }

    public void setDxzt(String dxzt) {
        this.dxzt = dxzt;
    }

    public String getRwsj() {
        return rwsj;
    }

    public void setRwsj(String rwsj) {
        this.rwsj = rwsj;
    }

    public String getTwsj() {
        return twsj;
    }

    public void setTwsj(String twsj) {
        this.twsj = twsj;
    }

    @Override
    public String toString() {
        return "TYExcelVo{" +
                "ssnf='" + sznf + '\'' +
                ", ssyf=" + szyf +
                ", xm='" + xm + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", rylb=" + rylb +
                ", dxzt=" + dxzt +
                ", rwsj='" + rwsj + '\'' +
                ", twsj='" + twsj + '\'' +
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

        TYExcelVo tyExcelVo = (TYExcelVo) o;

        return new EqualsBuilder().append(sznf, tyExcelVo.sznf).append(szyf, tyExcelVo.szyf).append(xm, tyExcelVo.xm).append(sfzh, tyExcelVo.sfzh).append(rylb, tyExcelVo.rylb).append(dxzt, tyExcelVo.dxzt).append(rwsj, tyExcelVo.rwsj).append(twsj, tyExcelVo.twsj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(sznf).append(szyf).append(xm).append(sfzh).append(rylb).append(dxzt).append(rwsj).append(twsj).toHashCode();
    }
}
