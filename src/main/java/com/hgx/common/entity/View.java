package com.hgx.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class View {
    private Integer id;
    @ApiModelProperty("日期")
    private String date;
    @ApiModelProperty("品名")
    private String name;
    @ApiModelProperty("资产编号")
    private String num;
    @ApiModelProperty("资产类型")
    private String assetTypeOne;
    @ApiModelProperty("资产分类")
    private String assetTypeTwo;
    @ApiModelProperty("出入库数量")
    private String outInNum;
    @ApiModelProperty("交收人")
    private String jsr;
    @ApiModelProperty("管理员")
    private String manager;
    @ApiModelProperty("出入库情况说明")
    private String remark;

    public View(String date, String name, String num, String assetTypeOne, String assetTypeTwo, String outInNum, String jsr, String manager, String remark) {
        this.date = date;
        this.name = name;
        this.num = num;
        this.assetTypeOne = assetTypeOne;
        this.assetTypeTwo = assetTypeTwo;
        this.outInNum = outInNum;
        this.jsr = jsr;
        this.manager = manager;
        this.remark = remark;
    }

    public View() {
    }
}