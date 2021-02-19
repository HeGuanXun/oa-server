package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Asset;
import org.apache.ibatis.annotations.Param;
/**
 * Asset的Dao接口
 * @author
 */
public interface AssetDao{

	/**
	 * 获得数据的总行数
	 */
	long getAssetRowCount(Assist assist);
	
	/**
	 * 获得Asset数据集合
	 */
	List<Asset> selectAsset(Assist assist);
	/**
	 * 通过Asset的id获得对象
	 */
	Asset selectAssetById(Integer id);
	
	/**
	 * 获得一个Asset对象
	 */
	Asset selectAssetObjSingle(Asset obj);
	
	/**
	 * 获得一个Asset对象集合
	 */
	List<Asset> selectAssetByObj(Asset obj);


	/**
	 * 插入Asset中属性值不为null的数据到数据库
	 */
	int insertNotNullAsset(Asset value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertAssetByBatch(List<Asset> value);
	/**
	 * 通过id删除
	 */
	int deleteAssetById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullAssetById(Asset asset);
}