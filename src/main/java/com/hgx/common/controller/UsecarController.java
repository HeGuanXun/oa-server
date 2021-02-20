package com.hgx.common.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.common.service.UsecarService;
import com.hgx.common.entity.Usecar;
import com.hgx.common.utils.HttpJsonResult;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "人事申请-用车",tags = "人事申请-用车")
@RequestMapping(value = "/usecar")
@RestController
public class UsecarController{

	@Autowired
	private UsecarService usecarService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<Usecar>> getList(Usecar usecar){
		 return HttpJsonResult.ok(usecarService.getList(usecar));
	}

	@ApiOperation("根据id获取usecar信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<Usecar> getById(Integer id){
		return HttpJsonResult.ok(usecarService.getUsecarById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(Usecar usecar){
		if(usecar.getId()!=null){
			try {
				usecarService.updateNotNullById(usecar);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			usecarService.saveNotNull(usecar);
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
			usecarService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
