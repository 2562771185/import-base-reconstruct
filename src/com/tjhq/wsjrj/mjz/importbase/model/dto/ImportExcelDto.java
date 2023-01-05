package com.tjhq.wsjrj.mjz.importbase.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2023/1/3
 * \* Time: 21:30
 * \* Description: 导入Excel时传入的参数体
 * \
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportExcelDto {
    /**
     * Excel文件
     */
    MultipartFile excel;
    /**
     * 是否开启身份证验证
     */
    Boolean c1;
    /**
     * 是否开启所属月份验证
     */
    Boolean c2;
    /**
     * 是否开启所属年份验证
     */
    Boolean c3;
    /**
     * 导入类型
     */
    Integer inputType;
    /**
     * 是否开启打印日志
     */
    Boolean printlog;

}
