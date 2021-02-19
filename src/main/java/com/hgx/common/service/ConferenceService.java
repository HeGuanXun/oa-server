package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.Conference;

/**
 * Conference的服务接口
 * @author
 */
public interface ConferenceService{
	/**
	 * 获得所以数据集
	 */
	List<Conference> getList(Conference conference);

	/**
	 * 获取Conference信息
	 */
	Conference getConferenceById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(Conference conference);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(Conference conference);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
