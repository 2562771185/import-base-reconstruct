package com.tjhq.wsjrj.mjz.importbase.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName fm_hrmdata_rsjn
 */
@TableName(value ="fm_hrmdata_rsjn")
public class PersonRsjn extends BaseEntity implements Serializable {
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
     * 补贴类型
     */
    private String btlx;

    /**
     * 培训时间
     */
    private String pxrq;

    /**
     * 是否失业
     */
    private String sfsy;

    /**
     * 参保状态
     */
    private String cbzt;

    /**
     * 月待遇金额
     */
    private Double ydyje;

    /**
     * 就业单位
     */
    private String jydw;

    /**
     * 补贴金额
     */
    private Double btje;

    /**
     * 培训工种
     */
    private String pxgz;

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
     * 补贴类型
     */
    public String getBtlx() {
        return btlx;
    }

    /**
     * 补贴类型
     */
    public void setBtlx(String btlx) {
        this.btlx = btlx;
    }

    /**
     * 培训时间
     */
    public String getPxrq() {
        return pxrq;
    }

    /**
     * 培训时间
     */
    public void setPxrq(String pxrq) {
        this.pxrq = pxrq;
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
     * 是否失业
     */
    public String getSfsy() {
        return sfsy;
    }

    /**
     * 是否失业
     */
    public void setSfsy(String sfsy) {
        this.sfsy = sfsy;
    }

    /**
     * 参保状态
     */
    public String getCbzt() {
        return cbzt;
    }

    /**
     * 参保状态
     */
    public void setCbzt(String cbzt) {
        this.cbzt = cbzt;
    }

    /**
     * 月待遇金额
     */
    public Double getYdyje() {
        return ydyje;
    }

    /**
     * 月待遇金额
     */
    public void setYdyje(Double ydyje) {
        this.ydyje = ydyje;
    }

    /**
     * 就业单位
     */
    public String getJydw() {
        return jydw;
    }

    /**
     * 就业单位
     */
    public void setJydw(String jydw) {
        this.jydw = jydw;
    }

    /**
     * 补贴金额
     */
    public Double getBtje() {
        return btje;
    }

    /**
     * 补贴金额
     */
    public void setBtje(Double btje) {
        this.btje = btje;
    }

    /**
     * 培训工种
     */
    public String getPxgz() {
        return pxgz;
    }

    /**
     * 培训工种
     */
    public void setPxgz(String pxgz) {
        this.pxgz = pxgz;
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
        PersonRsjn other = (PersonRsjn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateOrgId() == null ? other.getCreateOrgId() == null : this.getCreateOrgId().equals(other.getCreateOrgId()))
            && (this.getSznf() == null ? other.getSznf() == null : this.getSznf().equals(other.getSznf()))
            && (this.getBtlx() == null ? other.getBtlx() == null : this.getBtlx().equals(other.getBtlx()))
            && (this.getPxrq() == null ? other.getPxrq() == null : this.getPxrq().equals(other.getPxrq()))
            && (this.getSzyf() == null ? other.getSzyf() == null : this.getSzyf().equals(other.getSzyf()))
            && (this.getXm() == null ? other.getXm() == null : this.getXm().equals(other.getXm()))
            && (this.getSfzh() == null ? other.getSfzh() == null : this.getSfzh().equals(other.getSfzh()))
            && (this.getSfsy() == null ? other.getSfsy() == null : this.getSfsy().equals(other.getSfsy()))
            && (this.getCbzt() == null ? other.getCbzt() == null : this.getCbzt().equals(other.getCbzt()))
            && (this.getYdyje() == null ? other.getYdyje() == null : this.getYdyje().equals(other.getYdyje()))
            && (this.getJydw() == null ? other.getJydw() == null : this.getJydw().equals(other.getJydw()))
            && (this.getBtje() == null ? other.getBtje() == null : this.getBtje().equals(other.getBtje()))
            && (this.getPxgz() == null ? other.getPxgz() == null : this.getPxgz().equals(other.getPxgz()));
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
        result = prime * result + ((getBtlx() == null) ? 0 : getBtlx().hashCode());
        result = prime * result + ((getPxrq() == null) ? 0 : getPxrq().hashCode());
        result = prime * result + ((getSzyf() == null) ? 0 : getSzyf().hashCode());
        result = prime * result + ((getXm() == null) ? 0 : getXm().hashCode());
        result = prime * result + ((getSfzh() == null) ? 0 : getSfzh().hashCode());
        result = prime * result + ((getSfsy() == null) ? 0 : getSfsy().hashCode());
        result = prime * result + ((getCbzt() == null) ? 0 : getCbzt().hashCode());
        result = prime * result + ((getYdyje() == null) ? 0 : getYdyje().hashCode());
        result = prime * result + ((getJydw() == null) ? 0 : getJydw().hashCode());
        result = prime * result + ((getBtje() == null) ? 0 : getBtje().hashCode());
        result = prime * result + ((getPxgz() == null) ? 0 : getPxgz().hashCode());
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
        sb.append(", sznf=").append(sznf);
        sb.append(", btlx=").append(btlx);
        sb.append(", pxrq=").append(pxrq);
        sb.append(", szyf=").append(szyf);
        sb.append(", xm=").append(xm);
        sb.append(", sfzh=").append(sfzh);
        sb.append(", sfsy=").append(sfsy);
        sb.append(", cbzt=").append(cbzt);
        sb.append(", ydyje=").append(ydyje);
        sb.append(", jydw=").append(jydw);
        sb.append(", btje=").append(btje);
        sb.append(", pxgz=").append(pxgz);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}