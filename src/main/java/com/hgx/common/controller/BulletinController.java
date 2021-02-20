package com.hgx.common.controller;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hgx.common.entity.ZcView;
import com.hgx.common.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.hgx.common.service.BulletinService;
import com.hgx.common.entity.Bulletin;
import com.hgx.common.utils.HttpJsonResult;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 何冠勋
 */
@Api(value = "简报",tags = "简报")
@RequestMapping(value = "/bulletin")
@RestController
public class BulletinController{

	@Autowired
	private BulletinService bulletinService;

	@ApiOperation("导出")
	@GetMapping(value = "/export")
	@JsonBackReference
	public void export(HttpServletResponse response){
		Class<Bulletin> bulletinClass = Bulletin.class;
		//1.获取数据
		List<Bulletin> list = bulletinService.getList(null);
		//2.设置Excel标题
		String[] title = ExcelUtil.getFixedVoList(bulletinClass);
		//3.设置Excel文件名字
		String fileName = "简报"+System.currentTimeMillis()+".xls";
		//4.设置sheet名
		String sheetName = "简报";
		//5.获取所有字段
		Field[] fields = bulletinClass.getDeclaredFields();
		//6.生产报表
		ExcelUtil.export(list,fields,title,sheetName,fileName,response);
	}

	@ApiOperation("获取全部信息")
	@GetMapping(value = "/list")
	public HttpJsonResult<List<Bulletin>> getList(Bulletin bulletin){
		 return HttpJsonResult.ok(bulletinService.getList(bulletin));
	}

	@ApiOperation("根据id获取bulletin信息")
	@GetMapping(value = "/getById")
	public HttpJsonResult<Bulletin> getById(Integer id){
		return HttpJsonResult.ok(bulletinService.getBulletinById(id));
	}

//	@ApiOperation("新增或者修改")
//	@PostMapping(value = "/saveOrUpdate")
//	public HttpJsonResult<String> saveOrUpdate(Bulletin bulletin){
//		if(bulletin.getId()!=null){
//			try {
//				bulletinService.updateNotNullById(bulletin);
//				return HttpJsonResult.ok("更新成功！");
//				} catch (Exception e) {
//				return HttpJsonResult.errorException("更新失败！"+e);
//			}
//		}
//		try {
//			bulletinService.saveNotNull(bulletin);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return HttpJsonResult.errorException("新增失败！"+e);
//		}
//		return HttpJsonResult.ok("新增成功！");
//	}

//	@ApiOperation("删除")
//	@GetMapping(value = "/deleteById")
//	public HttpJsonResult<String> deleteById(Integer id){
//		try {
//			bulletinService.deleteById(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return HttpJsonResult.errorException("删除失败！"+e);
//		}
//		return HttpJsonResult.ok("删除成功！");
//	}

}
