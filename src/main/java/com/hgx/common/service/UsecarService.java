package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.Usecar;

/**
 * Usecar的服务接口
 * @author
 */
public interface UsecarService{
	/**
	 * 获得所以数据集
	 */
	List<Usecar> getList(Usecar usecar);

	/**
	 * 获取Usecar信息
	 */
	Usecar getUsecarById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(Usecar usecar);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(Usecar usecar);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
