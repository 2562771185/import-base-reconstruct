package com.tjhq.wsjrj.mjz.importbase.utils.excel;


import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.mapper.PersonMbkbzMapper;
import com.tjhq.wsjrj.mjz.importbase.model.entity.Mbkbz;
import com.tjhq.wsjrj.mjz.importbase.model.entity.OaTSysOrganization;
import com.tjhq.wsjrj.mjz.importbase.service.intf.OaTSysOrganizationService;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/7
 * \* Time: 10:43
 * \* Description:
 * \
 */

public class CommonDataUtil {
    static YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");

    /**
     * 月份列表
     */
    public static final Map<String, String> MONTH_MAP = new HashMap<>();
    /**
     * 是否
     */
    public static final Map<String, String> SF_MAP = new HashMap<>();
    /**
     * 基本生活保障类型列表
     */
    public static final Map<String, String> JBSH_MAP = new HashMap<>();
    /**
     * 慢病卡列表
     */
    public static Map<String, Integer> MBKBZ_MAP;
    /**
     * 所属来源列表
     */
    public static Map<String, String> SSLY_MAP;

    public CommonDataUtil() {
    }


    static {
        MONTH_MAP.put("1月", "0");
        MONTH_MAP.put("2月", "1");
        MONTH_MAP.put("3月", "2");
        MONTH_MAP.put("4月", "3");
        MONTH_MAP.put("5月", "4");
        MONTH_MAP.put("6月", "5");
        MONTH_MAP.put("7月", "6");
        MONTH_MAP.put("8月", "7");
        MONTH_MAP.put("9月", "8");
        MONTH_MAP.put("10月", "9");
        MONTH_MAP.put("11月", "10");
        MONTH_MAP.put("12月", "11");

        SF_MAP.put("是", "0");
        SF_MAP.put("否", "1");

        JBSH_MAP.put("农村低保A档", "0");
        JBSH_MAP.put("农村低保B档", "1");
        JBSH_MAP.put("农村低保C档", "2");
        JBSH_MAP.put("城市低保A1档", "3");
        JBSH_MAP.put("城市低保A2档", "4");
        JBSH_MAP.put("城市低保B1档", "5");
        JBSH_MAP.put("城市低保B2档", "6");
        JBSH_MAP.put("城市低保C1档", "7");
        JBSH_MAP.put("城市低保C2档", "8");
        JBSH_MAP.put("城市特困", "9");
        JBSH_MAP.put("农村特困", "10");
        JBSH_MAP.put("孤儿基本生活保障金", "11");

        OaTSysOrganizationService sysOrganizationService = BeanUtils.getBean(OaTSysOrganizationService.class);
        SSLY_MAP = sysOrganizationService.list().stream().collect(Collectors.toMap(OaTSysOrganization::getOrgname, OaTSysOrganization::getOrgid));
        log.info("所属来源列表:" + SSLY_MAP);

        PersonMbkbzMapper mbkbzMapper = BeanUtils.getBean(PersonMbkbzMapper.class);
        log.info("mbkbzMapper" + mbkbzMapper);
        List<Mbkbz> mbkbzs = mbkbzMapper.selectList(null);
        MBKBZ_MAP = mbkbzs.stream().collect(Collectors.toMap(Mbkbz::getMbkbz, Mbkbz::getBh));
        log.info("慢病卡病种列表:" + MBKBZ_MAP);
    }

}
