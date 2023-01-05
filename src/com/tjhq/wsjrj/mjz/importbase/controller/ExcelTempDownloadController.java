package com.tjhq.wsjrj.mjz.importbase.controller;

import com.tjhq.hqoa.framework.framework.Result;
import com.tjhq.wsjrj.mjz.importbase.annotation.LogAnnotation;
import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.FileUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2023/1/5
 * \* Time: 14:48
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/sso")
@CrossOrigin
public class ExcelTempDownloadController {
    @GetMapping("/cjra/downloadExcel")
    @LogAnnotation(module = "残疾人类型1", operation = "下载Excel模板文件")
    public Result downloadCjraExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.CJRA_EXCEL_TEMPLATE);
        return Result.OK();
    }


    @GetMapping("/cjrb/downloadExcel")
    @LogAnnotation(module = "残疾人类型2", operation = "下载Excel模板文件")
    public Result downloadCjrbExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.CJRA_EXCEL_TEMPLATE);
        return Result.OK();
    }


    @GetMapping("/cl/downloadExcel")
    @LogAnnotation(module = "残联", operation = "下载Excel模板文件")
    public Result downloadClExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.CL_EXCEL_TEMPLATE);
        return Result.OK();
    }

    @GetMapping("/etbz/downloadExcel")
    @LogAnnotation(module = "儿童保障", operation = "下载Excel模板文件")
    public Result downloadEtbzExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.ETBZ_EXCEL_TEMPLATE);
        return Result.OK();
    }
    @GetMapping("/glbz/downloadExcel")
    @LogAnnotation(module = "高龄保障", operation = "下载Excel模板文件")
    public Result downloadGlbzExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.GLBZ_EXCEL_TEMPLATE);
        return Result.OK();
    }
    @GetMapping("/grzf/downloadExcel")
    @LogAnnotation(module = "个人自付", operation = "下载Excel模板文件")
    public Result downloadGrzfExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.GRZF_EXCEL_TEMPLATE);
        return Result.OK();
    }
    @GetMapping("/jbsh/downloadExcel")
    @LogAnnotation(module = "基本生活", operation = "下载Excel模板文件")
    public Result downloadJbshExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.JBSH_EXCEL_TEMPLATE);
        return Result.OK();
    }
    @GetMapping("/rsj/downloadExcel")
    @LogAnnotation(module = "人社局", operation = "下载Excel模板文件")
    public Result downloadRsjExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.RSJ_EXCEL_TEMPLATE);
        return Result.OK();
    }
    @GetMapping("/swxx/downloadExcel")
    @LogAnnotation(module = "死亡信息", operation = "下载Excel模板文件")
    public Result downloadSwxxExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.SWXX_EXCEL_TEMPLATE);
        return Result.OK();
    }
    @GetMapping("/ty/downloadExcel")
    @LogAnnotation(module = "退役", operation = "下载Excel模板文件")
    public Result downloadTyExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.TY_EXCEL_TEMPLATE);
        return Result.OK();
    }
    @GetMapping("/xczx/downloadExcel")
    @LogAnnotation(module = "乡村振兴", operation = "下载Excel模板文件")
    public Result downloadXczxExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.XCZX_EXCEL_TEMPLATE);
        return Result.OK();
    }
    @GetMapping("/mbkbz/downloadExcel")
    @LogAnnotation(module = "乡村振兴", operation = "下载Excel模板文件")
    public Result downloadMbkbzExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.MBKBZ_EXCEL_TEMPLATE);
        return Result.OK();
    }
    @GetMapping("/sfcb/downloadExcel")
    @LogAnnotation(module = "是否参保", operation = "下载Excel模板文件")
    public Result downloadSfcbExcelTemplate(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.ExcelTemplate.SFCB_EXCEL_TEMPLATE);
        return Result.OK();
    }
}
