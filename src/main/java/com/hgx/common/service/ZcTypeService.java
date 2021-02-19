package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.ZcType;

/**
 * ZcType的服务接口
 * @author
 */
public interface ZcTypeService{
	/**
	 * 获得所以数据集
	 */
	List<ZcType> getList(ZcType zcType);

	/**
	 * 获取ZcType信息
	 */
	ZcType getZcTypeById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(ZcType zcType);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(ZcType zcType);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
