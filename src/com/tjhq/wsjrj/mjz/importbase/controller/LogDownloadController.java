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
public class LogDownloadController {
    @GetMapping("/cjra/downloadLog")
    @LogAnnotation(module = "残疾人类型1", operation = "下载导入日志文件")
    public Result downloadCjraLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.CJRA_LOG_FILEPATH);
        return Result.OK();
    }

    @GetMapping("/cjrb/downloadLog")
    @LogAnnotation(module = "残疾人类型2", operation = "下载导入日志文件")
    public Result downloadCjrbLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.CJRA_LOG_FILEPATH);
        return Result.OK();
    }

    @GetMapping("/cl/downloadLog")
    @LogAnnotation(module = "残联", operation = "下载导入日志文件")
    public Result downloadClLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.CL_LOG_FILEPATH);
        return Result.OK();
    }

    @GetMapping("/etbz/downloadLog")
    @LogAnnotation(module = "儿童保障", operation = "下载导入日志文件")
    public Result downloadEtbzLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.ETBZ_LOG_FILEPATH);
        return Result.OK();
    }

    @GetMapping("/glbz/downloadLog")
    @LogAnnotation(module = "高龄保障", operation = "下载导入日志文件")
    public Result downloadGlbzLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.GLBZ_LOG_FILEPATH);
        return Result.OK();
    }

    @GetMapping("/grzf/downloadLog")
    @LogAnnotation(module = "个人自付", operation = "下载导入日志文件")
    public Result downloadGrzfLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.GRZF_LOG_FILEPATH);
        return Result.OK();
    }

    @GetMapping("/jbsh/downloadLog")
    @LogAnnotation(module = "基本生活保障", operation = "下载导入日志文件")
    public Result downloadJbshLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.JBSH_LOG_FILEPATH);
        return Result.OK();
    }
    @GetMapping("/rsj/downloadLog")
    @LogAnnotation(module = "人社局", operation = "下载导入日志文件")
    public Result downloadRsjLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.RSJ_LOG_FILEPATH);
        return Result.OK();
    }
    @GetMapping("/swxx/downloadLog")
    @LogAnnotation(module = "死亡信息", operation = "下载导入日志文件")
    public Result downloadSwxxLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.SWXX_LOG_FILEPATH);
        return Result.OK();
    }
    @GetMapping("/ty/downloadLog")
    @LogAnnotation(module = "退役", operation = "下载导入日志文件")
    public Result downloadTyLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.TY_LOG_FILEPATH);
        return Result.OK();
    }
    @GetMapping("/xczx/downloadLog")
    @LogAnnotation(module = "乡村振兴", operation = "下载导入日志文件")
    public Result downloadXczxLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.XCZX_LOG_FILEPATH);
        return Result.OK();
    }
    @GetMapping("/mbkbz/downloadLog")
    @LogAnnotation(module = "慢病卡病种", operation = "下载导入日志文件")
    public Result downloadMbkbzLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.MBKBZ_LOG_FILEPATH);
        return Result.OK();
    }
    @GetMapping("/sfcb/downloadLog")
    @LogAnnotation(module = "是否参保", operation = "下载导入日志文件")
    public Result downloadSfcbLog(final HttpServletResponse response) {
        FileUtil.downloadFile(response, SysConstant.LogPath.SFCB_LOG_FILEPATH);
        return Result.OK();
    }
}
