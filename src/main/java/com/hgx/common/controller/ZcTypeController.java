package com.hgx.common.controller;
import com.hgx.common.entity.CompanyType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.common.service.ZcTypeService;
import com.hgx.common.entity.ZcType;
import com.hgx.common.utils.HttpJsonResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "资产-资产分类",tags = "资产-资产分类")
@RequestMapping(value = "/zcType")
@RestController
public class ZcTypeController{

	@Autowired
	private ZcTypeService zcTypeService;
	
	@Data
	private static class Tree{
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
	@ApiOperation("获取树信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<Tree[]> getList(ZcType zcType){
		List<ZcType> list = zcTypeService.getList(zcType);
		Tree mTree = new Tree(null,"固定资产");
		Tree zTree = new Tree(null,"易耗品");
		ArrayList<Tree> mTrees = new ArrayList<>();
		ArrayList<Tree> zTrees = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals("固定资产")) {
				mTree.setId(list.get(i).getId());
			}
			if (list.get(i).getName().equals("易耗品")) {
				zTree.setId(list.get(i).getId());
			}
			if (list.get(i).getUpType().equals("固定资产")) {
				mTrees.add(new Tree(list.get(i).getId(),list.get(i).getName()));
			}
			if (list.get(i).getUpType().equals("易耗品")) {
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
		Tree[] myTree = new Tree[2];
		myTree[0] = mTree;
		myTree[1] = zTree;
		return HttpJsonResult.ok(myTree);
	}

	@ApiOperation("根据id获取zcType信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<ZcType> getById(Integer id){
		return HttpJsonResult.ok(zcTypeService.getZcTypeById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(ZcType zcType){
		if(zcType.getId()!=null){
			try {
				zcTypeService.updateNotNullById(zcType);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			zcTypeService.saveNotNull(zcType);
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
			zcTypeService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
