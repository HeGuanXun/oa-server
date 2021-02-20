package com.hgx.common.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.common.service.EvectionService;
import com.hgx.common.entity.Evection;
import com.hgx.common.utils.HttpJsonResult;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "人事申请-出差",tags = "人事申请-出差")
@RequestMapping(value = "/evection")
@RestController
public class EvectionController{

	@Autowired
	private EvectionService evectionService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<Evection>> getList(Evection evection){
		 return HttpJsonResult.ok(evectionService.getList(evection));
	}

	@ApiOperation("根据id获取evection信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<Evection> getById(Integer id){
		return HttpJsonResult.ok(evectionService.getEvectionById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(Evection evection){
		if(evection.getId()!=null){
			try {
				evectionService.updateNotNullById(evection);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			evectionService.saveNotNull(evection);
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
			evectionService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
