package com.hgx.common.controller;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hgx.common.entity.View;
import com.hgx.common.entity.ZcView;
import com.hgx.common.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.common.service.AssetService;
import com.hgx.common.entity.Asset;
import com.hgx.common.utils.HttpJsonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 何冠勋
 */
@Api(value = "资产管理",tags = "资产管理")
@RequestMapping(value = "/asset")
@RestController
public class AssetController{

	@Autowired
	private AssetService assetService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<Asset>> getList(Asset asset){
		 return HttpJsonResult.ok(assetService.getList(asset));
	}

	@ApiOperation("详情")
	@GetMapping(value = "/getById")
	public HttpJsonResult<Asset> getById(Integer id){
		return HttpJsonResult.ok(assetService.getAssetById(id));
	}

	@Data
	private class Ckjl{
		@ApiModelProperty("日期")
		private String date;
		@ApiModelProperty("类型")
		private String type;
		@ApiModelProperty("交收人")
		private String jsr;
		@ApiModelProperty("管理员")
		private String manager;
		@ApiModelProperty("出入库情况说明")
		private String ckqk;

		public Ckjl(String date, String type, String jsr, String manager, String ckqk) {
			this.date = date;
			this.type = type;
			this.jsr = jsr;
			this.manager = manager;
			this.ckqk = ckqk;
		}
	}

	@ApiOperation("详情-出库记录")
	@GetMapping(value = "/ckjl")
	public HttpJsonResult<ArrayList<Ckjl>> ckjl(){
		ArrayList<Ckjl> ckjls = new ArrayList<>();
		ckjls.add(new Ckjl("2020-01-02","出库","张三","李白","出库"));
		ckjls.add(new Ckjl("2020-01-03","出库","张三","李白","出库"));
		ckjls.add(new Ckjl("2020-01-04","入库","张三","李白","入库"));
		return HttpJsonResult.ok(ckjls);
	}
	@Data
	private class Lyghjl{
		@ApiModelProperty("日期")
		private String date;
		@ApiModelProperty("类型")
		private String type;
		@ApiModelProperty("交收人")
		private String jsr;
		@ApiModelProperty("管理员")
		private String manager;
		@ApiModelProperty("情况说明")
		private String remark;

		public Lyghjl(String date, String type, String jsr, String manager, String remark) {
			this.date = date;
			this.type = type;
			this.jsr = jsr;
			this.manager = manager;
			this.remark = remark;
		}

		public Lyghjl(String date, String jsr, String manager, String remark) {
			this.date = date;
			this.jsr = jsr;
			this.manager = manager;
			this.remark = remark;
		}
	}
	@ApiOperation("详情-领用归还记录")
	@GetMapping(value = "/lyghjl")
	public HttpJsonResult<ArrayList<Lyghjl>> lyghjl(){
		ArrayList<Lyghjl> ckjls = new ArrayList<>();
		ckjls.add(new Lyghjl("2020-01-02","领用","张三","李白","出库"));
		ckjls.add(new Lyghjl("2020-01-03","领用","张三","李白","入库"));
		ckjls.add(new Lyghjl("2020-01-04","归还","张三","李白","出库"));
		return HttpJsonResult.ok(ckjls);
	}

	@ApiOperation("详情-报销记录")
	@GetMapping(value = "/bxjl")
	public HttpJsonResult<ArrayList<Lyghjl>> bxjl(){
		ArrayList<Lyghjl> ckjls = new ArrayList<>();
		ckjls.add(new Lyghjl("2020-01-02","张三","李白","报销"));
		ckjls.add(new Lyghjl("2020-01-02","张三","李白","报销"));
		ckjls.add(new Lyghjl("2020-01-02","张三","李白","报销"));
		ckjls.add(new Lyghjl("2020-01-02","张三","李白","报销"));
		return HttpJsonResult.ok(ckjls);
	}

	@ApiOperation("详情-报废记录")
	@GetMapping(value = "/bfjl")
	public HttpJsonResult<ArrayList<Lyghjl>> bfjl(){
		ArrayList<Lyghjl> ckjls = new ArrayList<>();
		ckjls.add(new Lyghjl("2020-01-02","张三","李白","报废"));
		ckjls.add(new Lyghjl("2020-01-02","张三","李白","报废"));
		ckjls.add(new Lyghjl("2020-01-02","张三","李白","报废"));
		return HttpJsonResult.ok(ckjls);
	}

	@ApiOperation("详情-转移记录")
	@GetMapping(value = "/zyjl")
	public HttpJsonResult<ArrayList<Lyghjl>> zyjl(){
		ArrayList<Lyghjl> ckjls = new ArrayList<>();
		ckjls.add(new Lyghjl("2020-01-02","赠送","张三","李白","赠送"));
		ckjls.add(new Lyghjl("2020-01-02","赠送","张三","李白","赠送"));
		ckjls.add(new Lyghjl("2020-01-02","变卖","张三","李白","变卖"));
		return HttpJsonResult.ok(ckjls);
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(Asset asset){
		if(asset.getId()!=null){
			try {
				assetService.updateNotNullById(asset);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			assetService.saveNotNull(asset);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("新增失败！"+e);
		}
		return HttpJsonResult.ok("新增成功！");
	}

	@ApiOperation("固定资产出入库一览表")
	@GetMapping(value = "/zcview")
	public HttpJsonResult<ArrayList<View>> zcview(){
		ArrayList<View> ckjls = new ArrayList<>();
		ckjls.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "111", "花木兰", "程咬金", "贷款萨克的"));
		ckjls.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "2222", "花木兰", "程咬金", "贷款萨克dsadsd的"));
		ckjls.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "33", "花木兰", "程咬金", "贷款萨dasdasdas克的"));
		ckjls.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "43243", "花木兰", "程咬金", "贷款萨克fssdf的"));
		ckjls.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "234234", "花木兰", "程咬金", "gdsfgdsfgd"));
		return HttpJsonResult.ok(ckjls);
	}

	@ApiOperation("固定资产出入库一览表-导出")
	@GetMapping(value = "/zcExport")
	public void zcExport(HttpServletResponse response){
		ArrayList<View> list = new ArrayList<>();
		list.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "111", "花木兰", "程咬金", "贷款萨克的"));
		list.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "2222", "花木兰", "程咬金", "贷款萨克dsadsd的"));
		list.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "33", "花木兰", "程咬金", "贷款萨dasdasdas克的"));
		list.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "43243", "花木兰", "程咬金", "贷款萨克fssdf的"));
		list.add(new View("2020-01-02", "赠送", "00001", "电脑", "手机"
				, "234234", "花木兰", "程咬金", "gdsfgdsfgd"));
		//Excel标题
		String[] title = ExcelUtil.getFixedVoList(View.class);
		//Excel文件名字
		String fileName = "固定资产出入库"+System.currentTimeMillis()+".xls";
		//sheet名
		String sheetName = "固定资产出入库";
		Field[] fields = View.class.getDeclaredFields();
		ExcelUtil.export(list,fields,title,sheetName,fileName,response);
	}
	@ApiOperation("资产一览表")
	@GetMapping(value = "/zcll")
	public HttpJsonResult<ArrayList<ZcView>> zcll(){
		List<ZcView> datas = new ZcView().getDatas();
		return HttpJsonResult.ok(datas);
	}
	@ApiOperation("资产一览表-导出")
	@GetMapping(value = "/zclldc")
	@JsonBackReference
	public void zclldc(HttpServletResponse response){
		List<ZcView> list = new ZcView().getDatas();
		//Excel标题
		String[] title = ExcelUtil.getFixedVoList(ZcView.class);
		//Excel文件名字
		String fileName = "资产一览表"+System.currentTimeMillis()+".xls";
		//sheet名
		String sheetName = "资产一览表";
		Field[] fields = ZcView.class.getDeclaredFields();
		ExcelUtil.export(list,fields,title,sheetName,fileName,response);
	}
}
