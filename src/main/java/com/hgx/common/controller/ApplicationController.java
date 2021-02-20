package com.hgx.common.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.common.service.ApplicationService;
import com.hgx.common.entity.Application;
import com.hgx.common.utils.HttpJsonResult;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "报销",tags = "报销")
@RequestMapping(value = "/application")
@RestController
public class ApplicationController{

	@Autowired
	private ApplicationService applicationService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<Application>> getList(Application application){
		 return HttpJsonResult.ok(applicationService.getList(application));
	}

	@ApiOperation("根据id获取application信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<Application> getById(Integer id){
		return HttpJsonResult.ok(applicationService.getApplicationById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(Application application){
		if(application.getId()!=null){
			try {
				applicationService.updateNotNullById(application);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			applicationService.saveNotNull(application);
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
			applicationService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
