package com.tjhq.wsjrj.mjz.importbase.service.impl.absimpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ObjectUtil;
import com.tjhq.hqoa.platform.system.dto.SysUserDto;
import com.tjhq.hqoa.platform.system.util.SysUserUtil;
import com.tjhq.hqoa.workFlow.core.util.UUIDUtil;
import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.common.SFConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.common.SJLYConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.common.SSYFConvert;
import com.tjhq.wsjrj.mjz.importbase.model.entity.BaseEntity;
import com.tjhq.wsjrj.mjz.importbase.model.entity.PersonSwxx;
import com.tjhq.wsjrj.mjz.importbase.model.vo.SwxxExcelVo;
import com.tjhq.wsjrj.mjz.importbase.service.abs.AbstractImport;
import com.tjhq.wsjrj.mjz.importbase.service.intf.PersonSwxxService;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.FileUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.MyDateUtil;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2023/1/4
 * \* Time: 11:47
 * \* Description:
 * \
 */
@Service
public class SwxxImportExcelService extends AbstractImport {

    /**
     * 需要子类根据自己的情况过滤、转化数据
     *
     * @param vos 传入excel读取到的数据list
     */
    @Override
    protected List<?> filterAndConvertData(List<?> vos) {
        return vos.stream().map(vo -> {
            if (vo.getClass().equals(SwxxExcelVo.class)) {
                PersonSwxx dbData = BeanUtil.copyProperties(vo, PersonSwxx.class);
                if (IdcardUtil.isValidCard(dbData.getSfzh())) {
                    //转化数据为入库形式
                    dbData.setSfsw(SFConvert.convertToDbData(dbData.getSfsw()));
                    dbData.setSzyf(SSYFConvert.convertToDbData(dbData.getSzyf()));
                    dbData.setSjly(SJLYConvert.convertToDbData(dbData.getSjly()));
                    dbData.setSwsj(MyDateUtil.formatDate(dbData.getSwsj(), "yyyy-MM-dd"));
                    return dbData;
                }
            }
            return null;
        }).filter(ObjectUtil::isNotNull).collect(Collectors.toList());
    }


    /**
     * 输出日志到文件中
     */
    @Override
    protected void printLog(StringBuilder logStr) {
        FileUtil.printLog(logStr, SysConstant.LogPath.SWXX_LOG_FILEPATH);
    }

    /**
     * @param entity 解析得到的实体类
     * @return 返回拼接的插入SQL
     */
    @Override
    protected String buildSqlString(BaseEntity entity) {
        SysUserDto sysUserDto = SysUserUtil.getSysUserDto();
        if (sysUserDto == null) {
            throw new RuntimeException("未登录:无法操作!");
        }
        PersonSwxx dbData = (PersonSwxx) entity;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO FM_HRMDATA_SWXX (ID,SZNF,SZYF,XM,SFZH,SJLY,SFSW,SWSJ,STATUS,VERSION,CREATE_TIME,UPDATE_TIME,CREATE_USER_ID,CREATE_ORG_ID) VALUES ");
        String uuid = UUIDUtil.getUUID();
        sql.append("('").append(uuid).append("','")
                .append(dbData.getSznf()).append("','")
                .append(dbData.getSzyf()).append("','")
                .append(dbData.getXm()).append("','")
                .append(dbData.getSfzh()).append("','")
                .append(dbData.getSjly()).append("','")
                .append(dbData.getSfsw()).append("','")
                .append(dbData.getSwsj()).append("','")
                .append("1").append("',")
                .append(1).append(",'")
                .append(DateTime.now()).append("','")
                .append(DateTime.now()).append("','")
                .append(sysUserDto.getUserId()).append("','")
                .append(sysUserDto.getOrgId())
                .append("')");
        return sql.toString();
    }
}
