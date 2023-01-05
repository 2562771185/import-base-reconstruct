package com.tjhq.wsjrj.mjz.importbase.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2023/1/4
 * \* Time: 14:52
 * \* Description:
 * \
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 所属年份
     */
    protected String sznf;

    /**
     * 所属月份
     */
    protected String szyf;

    /**
     * 姓名
     */
    protected String xm;

    /**
     * 身份证号
     */
    protected String sfzh;
}
