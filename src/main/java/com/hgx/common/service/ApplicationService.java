package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.Application;

/**
 * Application的服务接口
 * @author
 */
public interface ApplicationService{
	/**
	 * 获得所以数据集
	 */
	List<Application> getList(Application application);

	/**
	 * 获取Application信息
	 */
	Application getApplicationById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(Application application);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(Application application);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
