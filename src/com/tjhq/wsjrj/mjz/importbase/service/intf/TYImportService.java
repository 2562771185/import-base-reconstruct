package com.tjhq.wsjrj.mjz.importbase.service.intf;

import com.tjhq.hqoa.framework.framework.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/6
 * \* Time: 16:12
 * \* Description:
 * \
 */
public interface TYImportService {
    Result importExcel(MultipartFile excel, Boolean c1, Boolean c2, Boolean c3, Integer inputType, Boolean printlog);

}
