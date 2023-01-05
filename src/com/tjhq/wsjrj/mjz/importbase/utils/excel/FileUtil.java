package com.tjhq.wsjrj.mjz.importbase.utils.excel;

import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/11/23
 * \* Time: 9:33
 * \* Description:
 * \
 */
public class FileUtil {
    static YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param file
     * @return
     */
    public static boolean deleteFile(File file) {
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            String[] children = file.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteFile(new File(file, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return file.delete();
    }

    /**
     * 检查文件是否为excel文件
     *
     * @param file
     * @return
     */


    /**
     * @param logStr 需要输出的字符串
     * @param path   输出的文件路径
     */
    public static void printLog(StringBuilder logStr, String path) {
        String rootPath = YCLogUtil.getRootPath();
        log.info("获取根目录：" + rootPath);
        //打印日志 生成下载文件
        log.info("----------------------------生成日志文件(目录:" + path + ")-------------------------------");
        File file = cn.hutool.core.io.FileUtil.touch(path);
        if (!file.exists()) {
            log.info("文件创建失败:"+file.getAbsolutePath());
            return;
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(String.valueOf(logStr));
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 下载文件
     *
     * @param response
     * @param filepath 文件路径
     * @return
     */
    public static void downloadFile(HttpServletResponse response, String filepath) {
        log.info("进入下载文件方法：" + filepath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        File file = new File(filepath);
        try {
            if (file.exists()) {
                String fileName = file.getName();
                log.info("文件存在：" + filepath);
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString()));
                // 实现文件下载
                byte[] buffer = new byte[1024];
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                log.info("下载文件成功-" + fileName);
            } else {
                log.info("文件不存在：" + filepath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("[下载文件出错]异常：" + e);
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String filepath = "W:\\yc\\apache-tomcat-9.0.46\\webapps\\yc\\static\\file\\logs\\残联人员-导入日志.log";
        String substring = filepath.substring(0, filepath.lastIndexOf("\\"));
        System.out.println("substring = " + substring);
    }
}
