package com.tjhq.wsjrj.mjz.importbase.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName fm_mbkbz
 */
@TableName(value ="fm_mbkbz")
public class Mbkbz implements Serializable {
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

    /**
     * 编号
     */
    private Integer bh;

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

    /**
     * 编号
     */
    public Integer getBh() {
        return bh;
    }

    /**
     * 编号
     */
    public void setBh(Integer bh) {
        this.bh = bh;
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
        result = prime * result + ((getMbkbz() == null) ? 0 : getMbkbz().hashCode());
        result = prime * result + ((getBh() == null) ? 0 : getBh().hashCode());
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
        sb.append(", mbkbz=").append(mbkbz);
        sb.append(", bh=").append(bh);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}