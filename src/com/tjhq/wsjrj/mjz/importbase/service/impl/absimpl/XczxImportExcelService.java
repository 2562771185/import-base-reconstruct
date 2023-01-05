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
import com.tjhq.wsjrj.mjz.importbase.handler.convert.common.SSYFConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.ty.DXZTConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.ty.RYLBConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.xczx.HlxConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.xczx.JcdxlxConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.xczx.YhzgxConvert;
import com.tjhq.wsjrj.mjz.importbase.model.entity.BaseEntity;
import com.tjhq.wsjrj.mjz.importbase.model.entity.PersonXczx;
import com.tjhq.wsjrj.mjz.importbase.model.vo.TYExcelVo;
import com.tjhq.wsjrj.mjz.importbase.model.vo.XczxExcelVo;
import com.tjhq.wsjrj.mjz.importbase.service.abs.AbstractImport;
import com.tjhq.wsjrj.mjz.importbase.service.intf.PersonXczxService;
import com.tjhq.wsjrj.mjz.importbase.service.intf.PersonXczxService;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
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
public class XczxImportExcelService extends AbstractImport {
    @Autowired
    private PersonXczxService xczxService;
    YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");


    /**
     * 需要子类根据自己的情况过滤、转化数据
     *
     * @param vos 传入excel读取到的数据list
     */
    @Override
    protected List filterAndConvertData(List vos) {
        List collect = (List) vos.stream().map(vo -> {
            if (vo.getClass().equals(XczxExcelVo.class)) {
                XczxExcelVo xczxExcelVo = (XczxExcelVo) vo;
                log.info("xczxExcelVo："+xczxExcelVo);
                if (IdcardUtil.isValidCard(xczxExcelVo.getSfzh())) {
                    //拷贝属性到实体类中
                    PersonXczx dbData = new PersonXczx();
                    dbData.setSznf(xczxExcelVo.getSznf());
                    dbData.setSfzh(xczxExcelVo.getSfzh());
                    dbData.setJtcy(xczxExcelVo.getJtcy());
                    dbData.setHzsfzh(xczxExcelVo.getHzsfzh());
                    dbData.setXm(xczxExcelVo.getXm());
                    dbData.setSbnd(xczxExcelVo.getSbnd());
                    //转化数据为入库形式
                    String sfxc = SFConvert.convertToDbData(xczxExcelVo.getFxsfxc());
                    log.info("风险是否消除："+sfxc);
                    String ssyf = SSYFConvert.convertToDbData(xczxExcelVo.getSzyf());
                    String hlx = HlxConvert.convertToDbData(xczxExcelVo.getHlx());
                    String jcdxlx = JcdxlxConvert.convertToDbData(xczxExcelVo.getJcdxlx());
                    String yhzgx = YhzgxConvert.convertToDbData(xczxExcelVo.getYhzgx());
                    dbData.setFxsfxc(Integer.valueOf(sfxc));
                    dbData.setSzyf(ssyf);
                    dbData.setHlx(hlx);
                    dbData.setJcdxlx(jcdxlx);
                    dbData.setYhzgx(yhzgx);
                    log.info("乡村振兴实体类：" + dbData);
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
     *
     * @return 身份证号为key，多个entity为value的map
     */
    @Override
    protected MultiMap createFilterMap() {
        MultiMap sfzhMap = new MultiValueMap();
        List<PersonXczx> list = xczxService.list();
        for (PersonXczx cl : list) {
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
        FileUtil.printLog(logStr, SysConstant.LogPath.XCZX_LOG_FILEPATH);
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
        PersonXczx dbData = (PersonXczx) entity;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO FM_HRMDATA_XCZX (ID,SZNF,SZYF,XM,SFZH,YHZGX,HLX,JCDXLX,FXSFXC,SBND,JTCY,HZSFZH,STATUS,VERSION,CREATE_TIME,UPDATE_TIME,CREATE_USER_ID,CREATE_ORG_ID) VALUES ");
        String uuid = UUIDUtil.getUUID();
        sql.append("('").append(uuid).append("','")
                .append(dbData.getSznf()).append("','")
                .append(dbData.getSzyf()).append("','")
                .append(dbData.getXm()).append("','")
                .append(dbData.getSfzh()).append("','")
                .append(dbData.getYhzgx()).append("','")
                .append(dbData.getHlx()).append("','")
                .append(dbData.getJcdxlx()).append("',")
                .append(dbData.getFxsfxc()).append(",'")
                .append(dbData.getSbnd()).append("','")
                .append(dbData.getJtcy()).append("','")
                .append(dbData.getHzsfzh()).append("','")
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
