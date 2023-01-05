package com.tjhq.wsjrj.mjz.importbase.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName fm_hrmdata_xczx
 */
@TableName(value ="fm_hrmdata_xczx")
public class PersonXczx extends BaseEntity implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private String id;

    /**
     * 删除标识0未删除1已删除
     */
    private String status;

    /**
     * 乐观锁版本
     */
    private Integer version;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 创建人ID
     */
    private String createUserId;

    /**
     * 创建机构ID
     */
    private String createOrgId;


    /**
     * 户主姓名
     */
    private String jtcy;

    /**
     * 户主身份证号码
     */
    private String hzsfzh;

    /**
     * 与户主关系
     */
    private String yhzgx;

    /**
     * 户类型
     */
    private String hlx;

    /**
     * 监测对象类型
     */
    private String jcdxlx;

    /**
     * 风险是否消除
     */
    private Integer fxsfxc;

    /**
     * 识别年度
     */
    private String sbnd;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 删除标识0未删除1已删除
     */
    public String getStatus() {
        return status;
    }

    /**
     * 删除标识0未删除1已删除
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 乐观锁版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 乐观锁版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建人ID
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建人ID
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 创建机构ID
     */
    public String getCreateOrgId() {
        return createOrgId;
    }

    /**
     * 创建机构ID
     */
    public void setCreateOrgId(String createOrgId) {
        this.createOrgId = createOrgId;
    }

    /**
     * 所属年份
     */
    public String getSznf() {
        return sznf;
    }

    /**
     * 所属年份
     */
    public void setSznf(String sznf) {
        this.sznf = sznf;
    }

    /**
     * 所属月份
     */
    public String getSzyf() {
        return szyf;
    }

    /**
     * 所属月份
     */
    public void setSzyf(String szyf) {
        this.szyf = szyf;
    }

    /**
     * 身份证号
     */
    public String getSfzh() {
        return sfzh;
    }

    /**
     * 身份证号
     */
    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    /**
     * 户主姓名
     */
    public String getJtcy() {
        return jtcy;
    }

    /**
     * 户主姓名
     */
    public void setJtcy(String jtcy) {
        this.jtcy = jtcy;
    }

    /**
     * 户主身份证号码
     */
    public String getHzsfzh() {
        return hzsfzh;
    }

    /**
     * 户主身份证号码
     */
    public void setHzsfzh(String hzsfzh) {
        this.hzsfzh = hzsfzh;
    }

    /**
     * 与户主关系
     */
    public String getYhzgx() {
        return yhzgx;
    }

    /**
     * 与户主关系
     */
    public void setYhzgx(String yhzgx) {
        this.yhzgx = yhzgx;
    }

    /**
     * 家庭成员
     */
    public String getXm() {
        return xm;
    }

    /**
     * 家庭成员
     */
    public void setXm(String xm) {
        this.xm = xm;
    }

    /**
     * 户类型
     */
    public String getHlx() {
        return hlx;
    }

    /**
     * 户类型
     */
    public void setHlx(String hlx) {
        this.hlx = hlx;
    }

    /**
     * 监测对象类型
     */
    public String getJcdxlx() {
        return jcdxlx;
    }

    /**
     * 监测对象类型
     */
    public void setJcdxlx(String jcdxlx) {
        this.jcdxlx = jcdxlx;
    }

    /**
     * 风险是否消除
     */
    public Integer getFxsfxc() {
        return fxsfxc;
    }

    /**
     * 风险是否消除
     */
    public void setFxsfxc(Integer fxsfxc) {
        this.fxsfxc = fxsfxc;
    }

    /**
     * 识别年度
     */
    public String getSbnd() {
        return sbnd;
    }

    /**
     * 识别年度
     */
    public void setSbnd(String sbnd) {
        this.sbnd = sbnd;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PersonXczx other = (PersonXczx) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateOrgId() == null ? other.getCreateOrgId() == null : this.getCreateOrgId().equals(other.getCreateOrgId()))
            && (this.getSznf() == null ? other.getSznf() == null : this.getSznf().equals(other.getSznf()))
            && (this.getSzyf() == null ? other.getSzyf() == null : this.getSzyf().equals(other.getSzyf()))
            && (this.getSfzh() == null ? other.getSfzh() == null : this.getSfzh().equals(other.getSfzh()))
            && (this.getJtcy() == null ? other.getJtcy() == null : this.getJtcy().equals(other.getJtcy()))
            && (this.getHzsfzh() == null ? other.getHzsfzh() == null : this.getHzsfzh().equals(other.getHzsfzh()))
            && (this.getYhzgx() == null ? other.getYhzgx() == null : this.getYhzgx().equals(other.getYhzgx()))
            && (this.getXm() == null ? other.getXm() == null : this.getXm().equals(other.getXm()))
            && (this.getHlx() == null ? other.getHlx() == null : this.getHlx().equals(other.getHlx()))
            && (this.getJcdxlx() == null ? other.getJcdxlx() == null : this.getJcdxlx().equals(other.getJcdxlx()))
            && (this.getFxsfxc() == null ? other.getFxsfxc() == null : this.getFxsfxc().equals(other.getFxsfxc()))
            && (this.getSbnd() == null ? other.getSbnd() == null : this.getSbnd().equals(other.getSbnd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateOrgId() == null) ? 0 : getCreateOrgId().hashCode());
        result = prime * result + ((getSznf() == null) ? 0 : getSznf().hashCode());
        result = prime * result + ((getSzyf() == null) ? 0 : getSzyf().hashCode());
        result = prime * result + ((getSfzh() == null) ? 0 : getSfzh().hashCode());
        result = prime * result + ((getJtcy() == null) ? 0 : getJtcy().hashCode());
        result = prime * result + ((getHzsfzh() == null) ? 0 : getHzsfzh().hashCode());
        result = prime * result + ((getYhzgx() == null) ? 0 : getYhzgx().hashCode());
        result = prime * result + ((getXm() == null) ? 0 : getXm().hashCode());
        result = prime * result + ((getHlx() == null) ? 0 : getHlx().hashCode());
        result = prime * result + ((getJcdxlx() == null) ? 0 : getJcdxlx().hashCode());
        result = prime * result + ((getFxsfxc() == null) ? 0 : getFxsfxc().hashCode());
        result = prime * result + ((getSbnd() == null) ? 0 : getSbnd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", sznf=").append(sznf);
        sb.append(", szyf=").append(szyf);
        sb.append(", sfzh=").append(sfzh);
        sb.append(", jtcy=").append(jtcy);
        sb.append(", hzsfzh=").append(hzsfzh);
        sb.append(", yhzgx=").append(yhzgx);
        sb.append(", xm=").append(xm);
        sb.append(", hlx=").append(hlx);
        sb.append(", jcdxlx=").append(jcdxlx);
        sb.append(", fxsfxc=").append(fxsfxc);
        sb.append(", sbnd=").append(sbnd);
        sb.append("]");
        return sb.toString();
    }
}