package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.Leaves;

/**
 * Leaves的服务接口
 * @author
 */
public interface LeavesService{
	/**
	 * 获得所以数据集
	 */
	List<Leaves> getList(Leaves leaves);

	/**
	 * 获取Leaves信息
	 */
	Leaves getLeavesById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(Leaves leaves);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(Leaves leaves);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
