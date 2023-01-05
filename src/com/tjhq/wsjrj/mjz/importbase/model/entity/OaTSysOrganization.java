package com.tjhq.wsjrj.mjz.importbase.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName oa_t_sys_organization
 */
@TableName(value ="oa_t_sys_organization")
public class OaTSysOrganization implements Serializable {
    /**
     * 
     */
    @TableId
    private String orgid;

    /**
     * 
     */
    private String parentorgid;

    /**
     * 
     */
    private String belongorgid;

    /**
     * 
     */
    private String orgcode;

    /**
     * 
     */
    private String orgname;

    /**
     * 
     */
    private String chinesespell;

    /**
     * 
     */
    private String shortorgname;

    /**
     * 
     */
    private String fullorgname;

    /**
     * 
     */
    private String partfullorgname;

    /**
     * 
     */
    private Integer levelnum;

    /**
     * 
     */
    private Integer orgtype;

    /**
     * 
     */
    private String hierarchycode;

    /**
     * 
     */
    private String orghierarchycode;

    /**
     * 
     */
    private Integer ordercode;

    /**
     * 
     */
    private String state;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String createuserid;

    /**
     * 
     */
    private String createorgid;

    /**
     * 
     */
    private Integer dbversion;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String updatetime;

    /**
     * 
     */
    private String chargeperson;

    /**
     * 
     */
    private String chargeleader;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getOrgid() {
        return orgid;
    }

    /**
     * 
     */
    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    /**
     * 
     */
    public String getParentorgid() {
        return parentorgid;
    }

    /**
     * 
     */
    public void setParentorgid(String parentorgid) {
        this.parentorgid = parentorgid;
    }

    /**
     * 
     */
    public String getBelongorgid() {
        return belongorgid;
    }

    /**
     * 
     */
    public void setBelongorgid(String belongorgid) {
        this.belongorgid = belongorgid;
    }

    /**
     * 
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     * 
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    /**
     * 
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * 
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    /**
     * 
     */
    public String getChinesespell() {
        return chinesespell;
    }

    /**
     * 
     */
    public void setChinesespell(String chinesespell) {
        this.chinesespell = chinesespell;
    }

    /**
     * 
     */
    public String getShortorgname() {
        return shortorgname;
    }

    /**
     * 
     */
    public void setShortorgname(String shortorgname) {
        this.shortorgname = shortorgname;
    }

    /**
     * 
     */
    public String getFullorgname() {
        return fullorgname;
    }

    /**
     * 
     */
    public void setFullorgname(String fullorgname) {
        this.fullorgname = fullorgname;
    }

    /**
     * 
     */
    public String getPartfullorgname() {
        return partfullorgname;
    }

    /**
     * 
     */
    public void setPartfullorgname(String partfullorgname) {
        this.partfullorgname = partfullorgname;
    }

    /**
     * 
     */
    public Integer getLevelnum() {
        return levelnum;
    }

    /**
     * 
     */
    public void setLevelnum(Integer levelnum) {
        this.levelnum = levelnum;
    }

    /**
     * 
     */
    public Integer getOrgtype() {
        return orgtype;
    }

    /**
     * 
     */
    public void setOrgtype(Integer orgtype) {
        this.orgtype = orgtype;
    }

    /**
     * 
     */
    public String getHierarchycode() {
        return hierarchycode;
    }

    /**
     * 
     */
    public void setHierarchycode(String hierarchycode) {
        this.hierarchycode = hierarchycode;
    }

    /**
     * 
     */
    public String getOrghierarchycode() {
        return orghierarchycode;
    }

    /**
     * 
     */
    public void setOrghierarchycode(String orghierarchycode) {
        this.orghierarchycode = orghierarchycode;
    }

    /**
     * 
     */
    public Integer getOrdercode() {
        return ordercode;
    }

    /**
     * 
     */
    public void setOrdercode(Integer ordercode) {
        this.ordercode = ordercode;
    }

    /**
     * 
     */
    public String getState() {
        return state;
    }

    /**
     * 
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 
     */
    public String getCreateuserid() {
        return createuserid;
    }

    /**
     * 
     */
    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    /**
     * 
     */
    public String getCreateorgid() {
        return createorgid;
    }

    /**
     * 
     */
    public void setCreateorgid(String createorgid) {
        this.createorgid = createorgid;
    }

    /**
     * 
     */
    public Integer getDbversion() {
        return dbversion;
    }

    /**
     * 
     */
    public void setDbversion(Integer dbversion) {
        this.dbversion = dbversion;
    }

    /**
     * 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * 
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 
     */
    public String getChargeperson() {
        return chargeperson;
    }

    /**
     * 
     */
    public void setChargeperson(String chargeperson) {
        this.chargeperson = chargeperson;
    }

    /**
     * 
     */
    public String getChargeleader() {
        return chargeleader;
    }

    /**
     * 
     */
    public void setChargeleader(String chargeleader) {
        this.chargeleader = chargeleader;
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
        OaTSysOrganization other = (OaTSysOrganization) that;
        return (this.getOrgid() == null ? other.getOrgid() == null : this.getOrgid().equals(other.getOrgid()))
            && (this.getParentorgid() == null ? other.getParentorgid() == null : this.getParentorgid().equals(other.getParentorgid()))
            && (this.getBelongorgid() == null ? other.getBelongorgid() == null : this.getBelongorgid().equals(other.getBelongorgid()))
            && (this.getOrgcode() == null ? other.getOrgcode() == null : this.getOrgcode().equals(other.getOrgcode()))
            && (this.getOrgname() == null ? other.getOrgname() == null : this.getOrgname().equals(other.getOrgname()))
            && (this.getChinesespell() == null ? other.getChinesespell() == null : this.getChinesespell().equals(other.getChinesespell()))
            && (this.getShortorgname() == null ? other.getShortorgname() == null : this.getShortorgname().equals(other.getShortorgname()))
            && (this.getFullorgname() == null ? other.getFullorgname() == null : this.getFullorgname().equals(other.getFullorgname()))
            && (this.getPartfullorgname() == null ? other.getPartfullorgname() == null : this.getPartfullorgname().equals(other.getPartfullorgname()))
            && (this.getLevelnum() == null ? other.getLevelnum() == null : this.getLevelnum().equals(other.getLevelnum()))
            && (this.getOrgtype() == null ? other.getOrgtype() == null : this.getOrgtype().equals(other.getOrgtype()))
            && (this.getHierarchycode() == null ? other.getHierarchycode() == null : this.getHierarchycode().equals(other.getHierarchycode()))
            && (this.getOrghierarchycode() == null ? other.getOrghierarchycode() == null : this.getOrghierarchycode().equals(other.getOrghierarchycode()))
            && (this.getOrdercode() == null ? other.getOrdercode() == null : this.getOrdercode().equals(other.getOrdercode()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateuserid() == null ? other.getCreateuserid() == null : this.getCreateuserid().equals(other.getCreateuserid()))
            && (this.getCreateorgid() == null ? other.getCreateorgid() == null : this.getCreateorgid().equals(other.getCreateorgid()))
            && (this.getDbversion() == null ? other.getDbversion() == null : this.getDbversion().equals(other.getDbversion()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getChargeperson() == null ? other.getChargeperson() == null : this.getChargeperson().equals(other.getChargeperson()))
            && (this.getChargeleader() == null ? other.getChargeleader() == null : this.getChargeleader().equals(other.getChargeleader()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrgid() == null) ? 0 : getOrgid().hashCode());
        result = prime * result + ((getParentorgid() == null) ? 0 : getParentorgid().hashCode());
        result = prime * result + ((getBelongorgid() == null) ? 0 : getBelongorgid().hashCode());
        result = prime * result + ((getOrgcode() == null) ? 0 : getOrgcode().hashCode());
        result = prime * result + ((getOrgname() == null) ? 0 : getOrgname().hashCode());
        result = prime * result + ((getChinesespell() == null) ? 0 : getChinesespell().hashCode());
        result = prime * result + ((getShortorgname() == null) ? 0 : getShortorgname().hashCode());
        result = prime * result + ((getFullorgname() == null) ? 0 : getFullorgname().hashCode());
        result = prime * result + ((getPartfullorgname() == null) ? 0 : getPartfullorgname().hashCode());
        result = prime * result + ((getLevelnum() == null) ? 0 : getLevelnum().hashCode());
        result = prime * result + ((getOrgtype() == null) ? 0 : getOrgtype().hashCode());
        result = prime * result + ((getHierarchycode() == null) ? 0 : getHierarchycode().hashCode());
        result = prime * result + ((getOrghierarchycode() == null) ? 0 : getOrghierarchycode().hashCode());
        result = prime * result + ((getOrdercode() == null) ? 0 : getOrdercode().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateuserid() == null) ? 0 : getCreateuserid().hashCode());
        result = prime * result + ((getCreateorgid() == null) ? 0 : getCreateorgid().hashCode());
        result = prime * result + ((getDbversion() == null) ? 0 : getDbversion().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getChargeperson() == null) ? 0 : getChargeperson().hashCode());
        result = prime * result + ((getChargeleader() == null) ? 0 : getChargeleader().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgid=").append(orgid);
        sb.append(", parentorgid=").append(parentorgid);
        sb.append(", belongorgid=").append(belongorgid);
        sb.append(", orgcode=").append(orgcode);
        sb.append(", orgname=").append(orgname);
        sb.append(", chinesespell=").append(chinesespell);
        sb.append(", shortorgname=").append(shortorgname);
        sb.append(", fullorgname=").append(fullorgname);
        sb.append(", partfullorgname=").append(partfullorgname);
        sb.append(", levelnum=").append(levelnum);
        sb.append(", orgtype=").append(orgtype);
        sb.append(", hierarchycode=").append(hierarchycode);
        sb.append(", orghierarchycode=").append(orghierarchycode);
        sb.append(", ordercode=").append(ordercode);
        sb.append(", state=").append(state);
        sb.append(", remark=").append(remark);
        sb.append(", createuserid=").append(createuserid);
        sb.append(", createorgid=").append(createorgid);
        sb.append(", dbversion=").append(dbversion);
        sb.append(", status=").append(status);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", chargeperson=").append(chargeperson);
        sb.append(", chargeleader=").append(chargeleader);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}