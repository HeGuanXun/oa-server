package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.Asset;

/**
 * Asset的服务接口
 * @author
 */
public interface AssetService{
	/**
	 * 获得所以数据集
	 */
	List<Asset> getList(Asset asset);

	/**
	 * 获取Asset信息
	 */
	Asset getAssetById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(Asset asset);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(Asset asset);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
