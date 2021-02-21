package com.hgx.common.controller;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.lang.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.common.service.CompanyTypeService;
import com.hgx.common.entity.CompanyType;
import com.hgx.common.utils.HttpJsonResult;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "会议室管理系统",tags = "会议-会议室管理系统")
@RequestMapping(value = "/companyType")
@RestController
public class CompanyTypeController{

	@Data
	private class Tree{
		private Integer id;
		private String label;
		private Tree[] children;

		public Tree(Integer id,String label) {
			this.id = id;
			this.label = label;
		}

		public Tree() {
		}
	}

	@Autowired
	private CompanyTypeService companyTypeService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<Tree[]> getList(CompanyType companyType){
		List<CompanyType> list = companyTypeService.getList(companyType);
		Tree mTree = new Tree(null,"母公司");
		Tree zTree = new Tree(null,"子公司");
		ArrayList<Tree> mTrees = new ArrayList<>();
		ArrayList<Tree> zTrees = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getType().equals("母公司")) {
				mTrees.add(new Tree(list.get(i).getId(),list.get(i).getName()));
			}
			if (list.get(i).getType().equals("子公司")) {
				zTrees.add(new Tree(list.get(i).getId(),list.get(i).getName()));
			}
		}
		Tree[] aa = new Tree[mTrees.size()];
		Tree[] bb = new Tree[zTrees.size()];
		for (int i = 0; i < mTrees.size(); i++) {
			aa[i] = mTrees.get(i);
		}
		for (int i = 0; i < zTrees.size(); i++) {
			bb[i] = zTrees.get(i);
		}
		mTree.setChildren(aa);
		zTree.setChildren(bb);
		Tree[] strings = new Tree[2];
		strings[0] = mTree;
		strings[1] = zTree;
		return HttpJsonResult.ok(strings);
	}

	@ApiOperation("根据id获取companyType信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<CompanyType> getById(Integer id){
		return HttpJsonResult.ok(companyTypeService.getCompanyTypeById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(CompanyType companyType){
		if(companyType.getId()!=null){
			try {
				companyTypeService.updateNotNullById(companyType);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			companyTypeService.saveNotNull(companyType);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("新增失败！"+e);
		}
		return HttpJsonResult.ok("新增成功！");
	}

	@ApiOperation("删除")
	@GetMapping(value = "/deleteById")
	public HttpJsonResult<String> deleteById(Integer id){
		try {
			companyTypeService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
