package com.tjhq.wsjrj.mjz.importbase.constants;

import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;

import java.io.File;
import java.sql.PseudoColumnUsage;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/11/24
 * \* Time: 9:31
 * \* Description: 系统通用变量
 * \
 */
public class SysConstant {
    public static class ExcelTemplate{
        /**
         * 残联模板文件地址
         */
        public static final String CL_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "残联AI数据导入模板.xls";
        /**
         * 退役模板文件地址
         */
        public static final String TY_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "退役AI数据导入模板.xls";
        /**
         * 乡村振兴模板文件地址
         */
        public static final String XCZX_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "乡村振兴AI数据导入模板.xls";
        /**
         * 人社局模板文件地址
         */
        public static final String RSJ_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "人社局AI数据导入模板.xls";
        /**
         * 残疾人类型1模板文件地址
         */
        public static final String CJRA_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "残疾人保障类型1AI数据导入模板.xls";
        /**
         * 残疾人类型2模板文件地址
         */
        public static final String CJRB_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "残疾人保障类型2AI数据导入模板.xls";
        /**
         * 儿童保障类型模板文件地址
         */
        public static final String ETBZ_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "儿童保障类型AI数据导入模板.xls";
        /**
         * 高龄保障类型模板文件地址
         */
        public static final String GLBZ_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "高龄保障类型AI数据导入模板.xls";
        /**
         * 基本保障类型模板文件地址
         */
        public static final String JBSH_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "基本生活保障类型AI数据导入模板.xls";
        /**
         * 个人自付金额模板文件地址
         */
        public static final String GRZF_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "个人自付金额AI数据导入模板.xls";
        /**
         * 是否参保模板文件地址
         */
        public static final String SFCB_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "是否资助参保AI数据导入模板.xls";
        /**
         * 慢病卡病种模板文件地址
         */
        public static final String MBKBZ_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "慢病卡病种AI数据导入模板.xls";
        /**
         * 死亡信息模板文件地址
         */
        public static final String SWXX_EXCEL_TEMPLATE = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "人员死亡信息AI数据导入模板.xls";
    }

    public static class LogPath {
        /**
         * 残联导入日志下载地址
         */
        public static final String CL_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "残联人员-导入日志.log";
        /**
         * 退役导入日志下载地址
         */
        public static final String TY_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "退役人员-导入日志.log";
        /**
         * 乡村振兴导入日志下载地址
         */
        public static final String XCZX_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "乡村振兴-导入日志.log";
        /**
         * 人社局导入日志下载地址
         */
        public static final String RSJ_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "人社局-导入日志.log";

        /**
         * 残疾人类型1导入日志下载地址
         */
        public static final String CJRA_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "残疾人类型1-导入日志.log";

        /**
         * 残疾人类型2导入日志下载地址
         */
        public static final String CJRB_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "残疾人类型2-导入日志.log";
        ;
        /**
         * 儿童保障导入日志下载地址
         */
        public static final String ETBZ_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "儿童保障-导入日志.log";

        /**
         * 高龄保障导入日志下载地址
         */
        public static final String GLBZ_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "高龄保障-导入日志.log";

        /**
         * 基本生活保障导入日志下载地址
         */
        public static final String JBSH_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "基本生活保障-导入日志.log";

        /**
         * 个人自付导入日志下载地址
         */
        public static final String GRZF_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "个人自付金额-导入日志.log";
        /**
         * 是否参保导入日志下载地址
         */
        public static final String SFCB_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "是否参保-导入日志.log";
        /**
         * 慢病卡病种导入日志下载地址
         */
        public static final String MBKBZ_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "慢病卡病种-导入日志.log";
        /**
         * 死亡信息人员导入日志下载地址
         */
        public static final String SWXX_LOG_FILEPATH = YCLogUtil.getRootPath() + "static" + File.separator + "file" + File.separator + "logs" + File.separator + "死亡信息-导入日志.log";

    }
    /**
     * 数据库一次性插入数量
     */
    public static final int BATCH_COUNT = 200;
    /**
     * 追加类型
     */
    public static final Integer INPUT_TYPE_INSERT = 1;
    /**
     * 更新类型
     */
    public static final Integer INPUT_TYPE_UPDATE = 2;

    /**
     * excel中的数据行
     */
    public static int DATA_COUNT = 0;
    /**
     * 系统日志文件夹名
     */
    public static final String SYSTEM_LOG_NAME = "import-log";
}
