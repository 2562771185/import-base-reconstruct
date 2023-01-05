package com.tjhq.wsjrj.mjz.importbase.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * 
 * @TableName fm_hrmdata_ty
 */
@TableName(value ="fm_hrmdata_ty")
public class PersonTY extends BaseEntity implements Serializable {
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
     * 人员类别
     */
    private String rylb;

    /**
     * 对象状态
     */
    private String dxzt;

    /**
     * 入伍时间
     */
    private String rwsj;

    /**
     * 退伍时间
     */

    private String twsj;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(String createOrgId) {
        this.createOrgId = createOrgId;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonTY personTY = (PersonTY) o;

        return new EqualsBuilder().append(id, personTY.id).append(status, personTY.status).append(version, personTY.version).append(createTime, personTY.createTime).append(updateTime, personTY.updateTime).append(createUserId, personTY.createUserId).append(createOrgId, personTY.createOrgId).append(sznf, personTY.sznf).append(szyf, personTY.szyf).append(xm, personTY.xm).append(sfzh, personTY.sfzh).append(rylb, personTY.rylb).append(dxzt, personTY.dxzt).append(rwsj, personTY.rwsj).append(twsj, personTY.twsj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(status).append(version).append(createTime).append(updateTime).append(createUserId).append(createOrgId).append(sznf).append(szyf).append(xm).append(sfzh).append(rylb).append(dxzt).append(rwsj).append(twsj).toHashCode();
    }

    @Override
    public String toString() {
        return "PersonTY{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", version=" + version +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", createOrgId='" + createOrgId + '\'' +
                ", sznf='" + sznf + '\'' +
                ", szyf='" + szyf + '\'' +
                ", xm='" + xm + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", rylb='" + rylb + '\'' +
                ", dxzt='" + dxzt + '\'' +
                ", rwsj='" + rwsj + '\'' +
                ", twsj='" + twsj + '\'' +
                '}';
    }
}