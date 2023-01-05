package com.tjhq.wsjrj.mjz.importbase.service.impl.absimpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ObjectUtil;
import com.tjhq.hqoa.platform.system.dto.SysUserDto;
import com.tjhq.hqoa.platform.system.util.SysUserUtil;
import com.tjhq.hqoa.workFlow.core.util.UUIDUtil;
import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.common.SSYFConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.jbsh.JbshConvert;
import com.tjhq.wsjrj.mjz.importbase.model.entity.BaseEntity;
import com.tjhq.wsjrj.mjz.importbase.model.entity.PersonJbsh;
import com.tjhq.wsjrj.mjz.importbase.model.vo.GrzfExcelVo;
import com.tjhq.wsjrj.mjz.importbase.model.vo.JbshExcelVo;
import com.tjhq.wsjrj.mjz.importbase.service.abs.AbstractImport;
import com.tjhq.wsjrj.mjz.importbase.service.intf.PersonJbshService;
import com.tjhq.wsjrj.mjz.importbase.service.intf.PersonJbshService;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.FileUtil;
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
public class JbshImportExcelService extends AbstractImport {
    @Autowired
    private PersonJbshService jbshService;

    /**
     * 需要子类根据自己的情况过滤、转化数据
     *
     * @param vos 传入excel读取到的数据list
     */
    @Override
    protected List filterAndConvertData(List vos) {
        List collect = (List) vos.stream().map(vo -> {
            if (vo.getClass().equals(JbshExcelVo.class)) {
                PersonJbsh data = BeanUtil.copyProperties(vo, PersonJbsh.class);
                if (IdcardUtil.isValidCard(data.getSfzh())) {
                    //拷贝属性到实体类中
                    PersonJbsh dbData = BeanUtil.copyProperties(vo, PersonJbsh.class);
                    //转化数据为入库形式
                    String ssyf = SSYFConvert.convertToDbData(dbData.getSzyf());
                    String hbzlx = JbshConvert.convertToDbData(dbData.getHbzlx());
                    dbData.setSzyf(ssyf);
                    dbData.setHbzlx(hbzlx);
                    return dbData;
                }
            }
            return null;
        }).collect(Collectors.toList());
        collect = (List) collect.stream().filter(item -> ObjectUtil.isNotNull(item)).collect(Collectors.toList());
        return collect;
    }

    /**
     * 生成过滤map
     * @return 身份证号为key，多个entity为value的map
     */
    @Override
    protected MultiMap createFilterMap() {
        MultiMap sfzhMap = new MultiValueMap();
        List<PersonJbsh> list = jbshService.list();
        for (PersonJbsh cl : list) {
            sfzhMap.put(cl.getSfzh(), cl);
        }
        sfzhMap.put(null, null);
        return sfzhMap;
    }

    /**
     * 输出日志到文件中
     */
    @Override
    protected void printLog(StringBuilder logStr) {
        FileUtil.printLog(logStr, SysConstant.LogPath.JBSH_LOG_FILEPATH);
    }

    /**
     * @param entity
     * @return
     */
    @Override
    protected String buildSqlString(BaseEntity entity) {
        SysUserDto sysUserDto = SysUserUtil.getSysUserDto();
        if (sysUserDto == null) {
            throw new RuntimeException("未登录:无法操作!");
        }
        PersonJbsh dbData = (PersonJbsh) entity;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO FM_HRMDATA_JBSH (ID,SZNF,SZYF,XM,SFZH,HBZLX,STATUS,VERSION,CREATE_TIME,UPDATE_TIME,CREATE_USER_ID,CREATE_ORG_ID) VALUES ");
        String uuid = UUIDUtil.getUUID();
        sql.append("('").append(uuid).append("','")
                .append(dbData.getSznf()).append("','")
                .append(dbData.getSzyf()).append("','")
                .append(dbData.getXm()).append("','")
                .append(dbData.getSfzh()).append("','")
                .append(dbData.getHbzlx()).append("','")
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
