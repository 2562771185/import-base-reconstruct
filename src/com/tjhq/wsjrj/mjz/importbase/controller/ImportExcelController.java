package com.tjhq.wsjrj.mjz.importbase.controller;

import com.tjhq.hqoa.framework.framework.Result;
import com.tjhq.wsjrj.mjz.importbase.annotation.LogAnnotation;
import com.tjhq.wsjrj.mjz.importbase.model.dto.ImportExcelDto;
import com.tjhq.wsjrj.mjz.importbase.model.entity.*;
import com.tjhq.wsjrj.mjz.importbase.model.vo.*;
import com.tjhq.wsjrj.mjz.importbase.service.impl.absimpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2023/1/4
 * \* Time: 9:32
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/sso")
@CrossOrigin
public class ImportExcelController {

    @Autowired
    private CjraImportExcelService cjraImportExcelService;
    @Autowired
    private CjrbImportExcelService cjrbImportExcelService;
    @Autowired
    private CLImportExcelService clImportExcelService;
    @Autowired
    private EtbzImportExcelService etbzImportExcelService;
    @Autowired
    private GlbzImportExcelService glbzImportExcelService;
    @Autowired
    private GrzfImportExcelService grzfImportExcelService;
    @Autowired
    private JbshImportExcelService jbshImportExcelService;
    @Autowired
    private RsjnImportExcelService rsjnImportExcelService;
    @Autowired
    private SwxxImportExcelService swxxImportExcelService;
    @Autowired
    private TyImportExcelService tyImportExcelService;
    @Autowired
    private XczxImportExcelService xczxImportExcelService;
    @Autowired
    private YbjaImportExcelService ybjaImportExcelService;
    @Autowired
    private YbjbImportExcelService ybjbImportExcelService;

    @PostMapping("/cjra/importExcel")
    @LogAnnotation(module = "残疾人类型1", operation = "导入Excel")
    public Result importExcelToCjra(@RequestParam("file") MultipartFile excel,
                                    @RequestParam("c1") Boolean c1,
                                    @RequestParam("c2") Boolean c2,
                                    @RequestParam("c3") Boolean c3,
                                    @RequestParam("inputType") Integer inputType,
                                    @RequestParam("printlog") Boolean printlog) {
        return cjraImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonCjra.class, CjraExcelVo.class);
    }

    @PostMapping("/cjrb/importExcel")
    @LogAnnotation(module = "残疾人类型2", operation = "导入Excel")
    public Result importExcelToCjrb(@RequestParam("file") MultipartFile excel,
                                    @RequestParam("c1") Boolean c1,
                                    @RequestParam("c2") Boolean c2,
                                    @RequestParam("c3") Boolean c3,
                                    @RequestParam("inputType") Integer inputType,
                                    @RequestParam("printlog") Boolean printlog) {
        return cjrbImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonCjrb.class, CjrbExcelVo.class);
    }

    @PostMapping("/cl/importExcel")
    @LogAnnotation(module = "残联", operation = "导入Excel")
    public Result importExcelToCl(@RequestParam("file") MultipartFile excel,
                                  @RequestParam("c1") Boolean c1,
                                  @RequestParam("c2") Boolean c2,
                                  @RequestParam("c3") Boolean c3,
                                  @RequestParam("inputType") Integer inputType,
                                  @RequestParam("printlog") Boolean printlog) {
        return clImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonCL.class, CLExcelVo.class);
    }

    @PostMapping("/etbz/importExcel")
    @LogAnnotation(module = "儿童保障", operation = "导入Excel")
    public Result importExcelToEtbz(@RequestParam("file") MultipartFile excel,
                                    @RequestParam("c1") Boolean c1,
                                    @RequestParam("c2") Boolean c2,
                                    @RequestParam("c3") Boolean c3,
                                    @RequestParam("inputType") Integer inputType,
                                    @RequestParam("printlog") Boolean printlog) {
        return etbzImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonEtbz.class, EtbzExcelVo.class);
    }

    @PostMapping("/glbz/importExcel")
    @LogAnnotation(module = "高龄保障", operation = "导入Excel")
    public Result importExcelToGlbz(@RequestParam("file") MultipartFile excel,
                                    @RequestParam("c1") Boolean c1,
                                    @RequestParam("c2") Boolean c2,
                                    @RequestParam("c3") Boolean c3,
                                    @RequestParam("inputType") Integer inputType,
                                    @RequestParam("printlog") Boolean printlog) {
        return glbzImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonGlbz.class, GlbzExcelVo.class);
    }

    @PostMapping("/grzf/importExcel")
    @LogAnnotation(module = "个人自付", operation = "导入Excel")
    public Result importExcelToGrzf(@RequestParam("file") MultipartFile excel,
                                    @RequestParam("c1") Boolean c1,
                                    @RequestParam("c2") Boolean c2,
                                    @RequestParam("c3") Boolean c3,
                                    @RequestParam("inputType") Integer inputType,
                                    @RequestParam("printlog") Boolean printlog) {
        return grzfImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonGrzf.class, GrzfExcelVo.class);
    }

    @PostMapping("/jbsh/importExcel")
    @LogAnnotation(module = "基本生活", operation = "导入Excel")
    public Result importExcelToJbsh(@RequestParam("file") MultipartFile excel,
                                    @RequestParam("c1") Boolean c1,
                                    @RequestParam("c2") Boolean c2,
                                    @RequestParam("c3") Boolean c3,
                                    @RequestParam("inputType") Integer inputType,
                                    @RequestParam("printlog") Boolean printlog) {
        return jbshImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonJbsh.class, JbshExcelVo.class);
    }
    @PostMapping("/rsj/importExcel")
    @LogAnnotation(module = "人社局", operation = "导入Excel")
    public Result importExcelToRsj(@RequestParam("file") MultipartFile excel,
                                    @RequestParam("c1") Boolean c1,
                                    @RequestParam("c2") Boolean c2,
                                    @RequestParam("c3") Boolean c3,
                                    @RequestParam("inputType") Integer inputType,
                                    @RequestParam("printlog") Boolean printlog) {
        return rsjnImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonRsjn.class, RsjExcelVo.class);
    }
    @PostMapping("/swxx/importExcel")
    @LogAnnotation(module = "死亡信息", operation = "导入Excel")
    public Result importExcelToSwxx(@RequestParam("file") MultipartFile excel,
                                   @RequestParam("c1") Boolean c1,
                                   @RequestParam("c2") Boolean c2,
                                   @RequestParam("c3") Boolean c3,
                                   @RequestParam("inputType") Integer inputType,
                                   @RequestParam("printlog") Boolean printlog) {
        return swxxImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonSwxx.class, SwxxExcelVo.class);
    }
    @PostMapping("/ty/importExcel")
    @LogAnnotation(module = "退役", operation = "导入Excel")
    public Result importExcelToTy(@RequestParam("file") MultipartFile excel,
                                    @RequestParam("c1") Boolean c1,
                                    @RequestParam("c2") Boolean c2,
                                    @RequestParam("c3") Boolean c3,
                                    @RequestParam("inputType") Integer inputType,
                                    @RequestParam("printlog") Boolean printlog) {
        return tyImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonTY.class, TYExcelVo.class);
    }
    @PostMapping("/xczx/importExcel")
    @LogAnnotation(module = "乡村振兴", operation = "导入Excel")
    public Result importExcelToXczx(@RequestParam("file") MultipartFile excel,
                                  @RequestParam("c1") Boolean c1,
                                  @RequestParam("c2") Boolean c2,
                                  @RequestParam("c3") Boolean c3,
                                  @RequestParam("inputType") Integer inputType,
                                  @RequestParam("printlog") Boolean printlog) {
        return xczxImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonXczx.class, XczxExcelVo.class);
    }
    @PostMapping("/mbkbz/importExcel")
    @LogAnnotation(module = "慢病卡病种", operation = "导入Excel")
    public Result importExcelToMbkbz(@RequestParam("file") MultipartFile excel,
                                    @RequestParam("c1") Boolean c1,
                                    @RequestParam("c2") Boolean c2,
                                    @RequestParam("c3") Boolean c3,
                                    @RequestParam("inputType") Integer inputType,
                                    @RequestParam("printlog") Boolean printlog) {
        return ybjaImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonYbja.class, MbkbzExcelVo.class);
    }
    @PostMapping("/sfcb/importExcel")
    @LogAnnotation(module = "是否参保", operation = "导入Excel")
    public Result importExcelToSfcb(@RequestParam("file") MultipartFile excel,
                                     @RequestParam("c1") Boolean c1,
                                     @RequestParam("c2") Boolean c2,
                                     @RequestParam("c3") Boolean c3,
                                     @RequestParam("inputType") Integer inputType,
                                     @RequestParam("printlog") Boolean printlog) {
        return ybjbImportExcelService.importExcel(new ImportExcelDto(excel, c1, c2, c3, inputType, printlog), PersonYbjb.class, SfcbExcelVo.class);
    }
}
