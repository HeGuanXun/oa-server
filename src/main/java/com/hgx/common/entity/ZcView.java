package com.hgx.common.entity;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ZcView{
    private String id;
    @ApiModelProperty("资产类型")
    private String aa;
    @ApiModelProperty("资产分类")
    private String bb;
    @ApiModelProperty("资产名称")
    private String cc;
    @ApiModelProperty("规格/型号")
    private String dd;
    @ApiModelProperty("数量")
    private String ee;
    @ApiModelProperty("单位")
    private String ff;
    @ApiModelProperty("资产编码")
    private String gg;
    @ApiModelProperty("位置")
    private String hh;
    @ApiModelProperty("使用人-隶属部门")
    private String ii;
    @ApiModelProperty("使用人-姓名")
    private String jj;
    @ApiModelProperty("责任人-隶属部门")
    private String kk;
    @ApiModelProperty("采购价格")
    private String ll;
    @ApiModelProperty("最后一次盘点日期")
    private String mm;
    @ApiModelProperty("已使用时长")
    private String nn;
    @ApiModelProperty("市场估值")
    private String oo;
    @ApiModelProperty("残值")
    private String pp;
    @ApiModelProperty("预计报废日期")
    private String qq;
    @ApiModelProperty("报废方式")
    private String rr;
    @ApiModelProperty("评价部门")
    private String ss;
    @ApiModelProperty("处置部门")
    private String tt;
    public ZcView() {
    }

    public ZcView(String aa, String bb, String cc, String dd, String ee, String ff, String gg, String hh, String ii, String jj, String kk, String ll, String mm, String nn, String oo, String pp, String qq, String rr, String ss, String tt) {
        this.aa = aa;
        this.bb = bb;
        this.cc = cc;
        this.dd = dd;
        this.ee = ee;
        this.ff = ff;
        this.gg = gg;
        this.hh = hh;
        this.ii = ii;
        this.jj = jj;
        this.kk = kk;
        this.ll = ll;
        this.mm = mm;
        this.nn = nn;
        this.oo = oo;
        this.pp = pp;
        this.qq = qq;
        this.rr = rr;
        this.ss = ss;
        this.tt = tt;
    }

    @JsonBackReference
    public List<ZcView> getDatas(){

        ArrayList<ZcView> list = new ArrayList<>();
        list.add(new ZcView("固定资产","数码/电脑/笔记本电脑","huawei P40","xxx","8888","万科",
                "9080979","海南","市场部","花木兰","技术部","768","2020-10-23","12小时",
                "100000","98898","2021-09-90"
                ,"自动","风控部","服务部"));
        list.add(new ZcView("固定资产","数码/电脑/笔记本电脑","huawei P40","xxx","8888","万科",
                "9080979","海南","市场部","花木兰","技术部","768","2020-10-23","12小时",
                "100000","98898","2021-09-90"
                ,"自动","风控部","服务部"));
        list.add(new ZcView("固定资产","数码/电脑/笔记本电脑","huawei P40","xxx","8888","万科",
                "9080979","海南","市场部","花木兰","技术部","768","2020-10-23","12小时",
                "100000","98898","2021-09-90"
                ,"自动","风控部","服务部"));
        list.add(new ZcView("固定资产","数码/电脑/笔记本电脑","huawei P40","xxx","8888","万科",
                "9080979","海南","市场部","花木兰","技术部","768","2020-10-23","12小时",
                "100000","98898","2021-09-90"
                ,"自动","风控部","服务部"));
        list.add(new ZcView("固定资产","数码/电脑/笔记本电脑","huawei P40","xxx","8888","万科",
                "9080979","海南","市场部","花木兰","技术部","768","2020-10-23","12小时",
                "100000","98898","2021-09-90"
                ,"自动","风控部","服务部"));
        return list;
    }
}