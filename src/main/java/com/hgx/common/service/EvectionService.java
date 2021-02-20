package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.Evection;

/**
 * Evection的服务接口
 * @author
 */
public interface EvectionService{
	/**
	 * 获得所以数据集
	 */
	List<Evection> getList(Evection evection);

	/**
	 * 获取Evection信息
	 */
	Evection getEvectionById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(Evection evection);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(Evection evection);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
