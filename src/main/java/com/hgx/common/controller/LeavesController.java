package com.hgx.common.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.common.service.LeavesService;
import com.hgx.common.entity.Leaves;
import com.hgx.common.utils.HttpJsonResult;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "人事申请-请假",tags = "人事申请-请假")
@RequestMapping(value = "/leaves")
@RestController
public class LeavesController{

	@Autowired
	private LeavesService leavesService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<Leaves>> getList(Leaves leaves){
		 return HttpJsonResult.ok(leavesService.getList(leaves));
	}

	@ApiOperation("根据id获取leaves信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<Leaves> getById(Integer id){
		return HttpJsonResult.ok(leavesService.getLeavesById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(Leaves leaves){
		if(leaves.getId()!=null){
			try {
				leavesService.updateNotNullById(leaves);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			leavesService.saveNotNull(leaves);
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
			leavesService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
