package com.tjhq.wsjrj.mjz.importbase.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName fm_hrmdata_ybja
 */
@TableName(value ="fm_hrmdata_ybja")
public class PersonYbja extends BaseEntity implements Serializable {
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
     * 慢病卡病种
     */
    private String mbkbz;

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
     * 姓名
     */
    public String getXm() {
        return xm;
    }

    /**
     * 姓名
     */
    public void setXm(String xm) {
        this.xm = xm;
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
     * 慢病卡病种
     */
    public String getMbkbz() {
        return mbkbz;
    }

    /**
     * 慢病卡病种
     */
    public void setMbkbz(String mbkbz) {
        this.mbkbz = mbkbz;
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
        PersonYbja other = (PersonYbja) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateOrgId() == null ? other.getCreateOrgId() == null : this.getCreateOrgId().equals(other.getCreateOrgId()))
            && (this.getXm() == null ? other.getXm() == null : this.getXm().equals(other.getXm()))
            && (this.getSfzh() == null ? other.getSfzh() == null : this.getSfzh().equals(other.getSfzh()))
            && (this.getSznf() == null ? other.getSznf() == null : this.getSznf().equals(other.getSznf()))
            && (this.getSzyf() == null ? other.getSzyf() == null : this.getSzyf().equals(other.getSzyf()))
            && (this.getMbkbz() == null ? other.getMbkbz() == null : this.getMbkbz().equals(other.getMbkbz()));
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
        result = prime * result + ((getXm() == null) ? 0 : getXm().hashCode());
        result = prime * result + ((getSfzh() == null) ? 0 : getSfzh().hashCode());
        result = prime * result + ((getSznf() == null) ? 0 : getSznf().hashCode());
        result = prime * result + ((getSzyf() == null) ? 0 : getSzyf().hashCode());
        result = prime * result + ((getMbkbz() == null) ? 0 : getMbkbz().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createOrgId=").append(createOrgId);
        sb.append(", xm=").append(xm);
        sb.append(", sfzh=").append(sfzh);
        sb.append(", sznf=").append(sznf);
        sb.append(", szyf=").append(szyf);
        sb.append(", mbkbz=").append(mbkbz);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}