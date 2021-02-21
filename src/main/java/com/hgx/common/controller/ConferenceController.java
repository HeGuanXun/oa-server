package com.hgx.common.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.common.service.ConferenceService;
import com.hgx.common.entity.Conference;
import com.hgx.common.utils.HttpJsonResult;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "会议管理系统",tags = "会议管理系统")
@RequestMapping(value = "/conference")
@RestController
public class ConferenceController{

	@Autowired
	private ConferenceService conferenceService;
	
	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<Conference>> getList(Conference conference){
		 return HttpJsonResult.ok(conferenceService.getList(conference));
	}

	@ApiOperation("根据id获取conference信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<Conference> getById(Integer id){
		return HttpJsonResult.ok(conferenceService.getConferenceById(id));
	}

	@ApiOperation("新增或者修改")
	@PostMapping(value = "/saveOrUpdate")
	public HttpJsonResult<String> saveOrUpdate(Conference conference){
		if(conference.getId()!=null){
			try {
				conferenceService.updateNotNullById(conference);
				return HttpJsonResult.ok("更新成功！");
				} catch (Exception e) {
				return HttpJsonResult.errorException("更新失败！"+e);
			}
		}
		try {
			conferenceService.saveNotNull(conference);
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
			conferenceService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpJsonResult.errorException("删除失败！"+e);
		}
		return HttpJsonResult.ok("删除成功！");
	}
}
