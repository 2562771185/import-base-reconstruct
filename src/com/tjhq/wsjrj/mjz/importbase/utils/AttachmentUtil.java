package com.tjhq.wsjrj.mjz.importbase.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hw.fb.form.adapter.sql.service.IFormSqlService;
import com.hw.fb.form.form.formDesignDto.Component;
import com.tjhq.hqoa.framework.service.impl.SqlService;
import com.tjhq.hqoa.workFlow.core.util.UUIDUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author ZJY
 * @title TaskReleaseUtil
 * @date 2022/10/18 11：49
 * @description 事办成任务下发流程转数据工具类
 */

@Service
public class AttachmentUtil {

    private static final YCLogUtil log = YCLogUtil.log("logs","attachmentLog");
    
    private IFormSqlService formSqlService;
    private SqlService sqlService;

    public AttachmentUtil(IFormSqlService formSqlService, SqlService sqlService) {
        this.formSqlService = formSqlService;
        this.sqlService = sqlService;
    }

    /**
     * 将附件保存至建模表单
     * @param busiId 附件控件ID
     * @param busiType 主表附件为businessID，明细表附件为数据ID
     */
    public void saveAttachmentToFM(String busiId,String busiType,String fm_uuid){
        log.info("进入附件保存至建模处理...");
        try {
            //获取流程表单上的附件信息
            String selectSql = "SELECT ATTACHMENTID," +
                    "BUSIID," +
                    "BUSITYPE," +
                    "FILENAME," +
                    "ORIGINALFILENAME," +
                    "BASEPATH," +
                    "FILEPATH," +
                    "FILESIZE," +
                    "SUFFIX," +
                    "ENCRYPTEDTYPE," +
                    "COMPRESSEDFLAG," +
                    "STRATEGYID," +
                    "UPLOADTIME," +
                    "ATTACHMENTVERSION," +
                    "CREATEUSERID," +
                    "CREATEORGID," +
                    "DBVERSION," +
                    "STATUS," +
                    "UPDATETIME," +
                    "SAVESTATE " +
                    "FROM OA_T_SYS_ATTACHMENT WHERE BUSITYPE='" + busiType + "' AND BUSIID='"+busiId+"'";
            log.info("查询附件:" + selectSql);
            List<Map<String, Object>> attachmentList = formSqlService.getDataBySql("master", selectSql);
            log.info("附件数量: " + attachmentList.size());
            //将附件存放至对应的建模表单
            if(attachmentList.size()>0){
                int x = 1;
                for (Map<String, Object> map : attachmentList) {
                    //将附件信息对应的建模数据id添加到附件表,此时的BUSIID取值应为建模表单的上传控件ID
                    //--------------------建模表单附件上传控件ID，如表单控件更换记得修改---------------------
                    String fm_busiId = getFmFormBusiId();
                    //--------------------建模表单附件上传控件ID---------------------
                    String filePath = map.get("FILEPATH").toString().replaceAll("\\\\", "\\\\\\\\");//文件路径反斜杠处理
                    String insertSql = "INSERT INTO OA_T_SYS_ATTACHMENT(" +
                            "ATTACHMENTID,BUSIID,BUSITYPE,FILENAME," +
                            "ORIGINALFILENAME,BASEPATH,FILEPATH,FILESIZE," +
                            "SUFFIX,ENCRYPTEDTYPE,COMPRESSEDFLAG,STRATEGYID," +
                            "UPLOADTIME,ATTACHMENTVERSION," +
                            "SAVESTATE) VALUES(" +
                            "'"+ UUIDUtil.getUUID()+"'," +
                            "'"+fm_busiId+"'," +
                            "'"+fm_uuid+"'," +
                            "'"+map.get("FILENAME").toString()+"'," +
                            "'"+map.get("ORIGINALFILENAME").toString()+"'," +
                            "'"+map.get("BASEPATH").toString()+"'," +
                            "'"+filePath+"'," +
                            ""+Integer.parseInt(String.valueOf(map.get("FILESIZE")))+"," +
                            "'"+map.get("SUFFIX").toString()+"'," +
                            "'"+map.get("ENCRYPTEDTYPE").toString()+"'," +
                            ""+Integer.parseInt(String.valueOf(map.get("COMPRESSEDFLAG")))+"," +
                            "'"+map.get("STRATEGYID").toString()+"'," +
                            "'"+map.get("UPLOADTIME").toString()+"'," +
                            ""+Integer.parseInt(String.valueOf(map.get("ATTACHMENTVERSION")))+"," +
                            ""+Integer.parseInt(String.valueOf(map.get("SAVESTATE")))+")";
                    log.info("附件信息保存至建模Sql: "+insertSql);
                    sqlService.executeSql(insertSql);
                    x++;
                }
            } 
        } catch (Exception e) {
            log.info("附件信息保存至建模异常:"+e);
        }
    }
    
    
    /**
     * 根据businessId和明细行数据ID，取附件表对应明细行数据的busiId
     * @param businessId
     */
    public String getDetailBusiId(String businessId,String detailId){
        try {
            String detailBusiId="";
            //取附件表中对应的busiId
            String sql = "SELECT DISTINCT BUSIID FROM OA_T_SYS_ATTACHMENT WHERE BUSITYPE='"+businessId+"' AND BUSIID = '"+detailId+"'";
            log.info("查询附件表busiId的sql:"+sql);
            Map<String, Object> busiIdMap = new HashMap<String,Object>();
            busiIdMap = formSqlService.getOneDataBySql("master", sql);
            //明细附件为空
            if(busiIdMap.get("BUSIID")!=null && !"".equals(busiIdMap.get("BUSIID"))){
                detailBusiId = busiIdMap.get("BUSIID").toString();
                log.info("获取到流程表单明细BUSIID:"+detailBusiId);
                return detailBusiId;
            }else{
                return "";
            }
        } catch (Exception e) {
            log.info("获取流程表单明细BUSIID异常:"+e+",已返回空串处理....");
            return "";
        }
    }
    
    /**
     * 根据businessId获取流程表单的附件控件ID
     * @param businessId
     * @return busiid
     */
    public String getProcessFromBusiId(String businessId){
        try {
            //获得流程表单页面控件json的SQL
            String select_sql = "SELECT CONTENT FROM form_form WHERE PROCESS_ID=(SELECT PROCESSID FROM wf_hi_processinstance WHERE BUSINESSID='"+businessId+"')";
            Map<String, Object> data = formSqlService.getOneDataBySql("master", select_sql);
            String json_data = data.get("CONTENT").toString();
            log.info("获取到的流程表单上的页面JSON...");
            //取表单页面控件JSON并定位表单附件上传页面控件JSON
            return getBusiId(json_data);
        } catch (Exception e) {
            log.info("获取流程主表附件BUSIID异常"+e);
        }
        return "获取流程主表附件BUSIID失败";
    }
    
    /**
     * 获取建模表单上的页面json
     *
     */
    public String getFmFormBusiId(){
        String json_data = null;
        try {
            json_data = "";
            String select_sql = "SELECT CONTENT FROM form_form WHERE FORM_ID='fc902fee49373e9d65792c1cdab803d3'";
            Map<String, Object> data = formSqlService.getOneDataBySql("master", select_sql);
            json_data = data.get("CONTENT").toString();
            log.info("获取到的【建模】表单上的页面JSON...");
            return getBusiId(json_data);
        } catch (Exception e) {
            log.info("获取建模表单页面json异常:"+e);
        }
        return "获取流程主表附件BUSIID失败";
    }
    
    /**
     * 根据页面json数据获取附件上传控件的ID
     * @param json_data
     * @return
     */
    public String getBusiId(String json_data){
        String attachment_component_id = "";
        try {
            JSONObject formJson = JSONObject.parseObject(json_data);//表单页面JSON对象
            JSONArray formList = formJson.getJSONArray("formList");//表单组件块元素JSON对象(如一行一列块)，页面组件存放在这里面
            List<Component> componentList = new ArrayList<>();//保存遍历到的控件组件
            for (int i = 0;i<formList.size();i++){
                JSONArray formComponentList = formList.getJSONObject(i).getJSONArray("componentList");
                for(int j = 0;j<formComponentList.size();j++){
                    //遍历获取到的每一个控件组件的类型、名字、id
                    Component component = new Component();
                    component.setComponentType(formComponentList.getJSONObject(j).getString("componentType"));
                    component.setComponentName(formComponentList.getJSONObject(j).getString("componentName"));
                    component.setId(formComponentList.getJSONObject(j).getString("id"));
                    componentList.add(component);
                }
            }
            //遍历获取到的组件
            for(Component component:componentList){
                //如果组件类型为el-upload,则为附件上传组件
                if("el-upload".equals(component.getComponentType())){
                    attachment_component_id = component.getId();
                    log.info("获取到表单附件组件BUSIID:"+attachment_component_id);
                    break;
                }
            }
            return attachment_component_id;
        } catch (Exception e) {
            log.info("获取表单附件组件BUSIID异常");
        }
        return attachment_component_id;
    }

}
