package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.Bulletin;

/**
 * Bulletin的服务接口
 * @author
 */
public interface BulletinService{
	/**
	 * 获得所以数据集
	 */
	List<Bulletin> getList(Bulletin bulletin);

	/**
	 * 获取Bulletin信息
	 */
	Bulletin getBulletinById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(Bulletin bulletin);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(Bulletin bulletin);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
