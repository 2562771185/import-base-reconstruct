package com.tjhq.wsjrj.mjz.importbase.service.intf;

import com.tjhq.hqoa.framework.framework.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/7
 * \* Time: 15:12
 * \* Description:
 * \
 */
public interface RsjImportService {
    Result importExcel(MultipartFile excel, Boolean c1, Boolean c2, Boolean c3, Integer inputType, Boolean printlog);

    Result exportExcel(HttpServletResponse response);

    Result downloadFile(HttpServletResponse response, String filepath);
}
