package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.ZcType;
import org.apache.ibatis.annotations.Param;
/**
 * ZcType的Dao接口
 * @author
 */
public interface ZcTypeDao{

	/**
	 * 获得数据的总行数
	 */
	long getZcTypeRowCount(Assist assist);
	
	/**
	 * 获得ZcType数据集合
	 */
	List<ZcType> selectZcType(Assist assist);
	/**
	 * 通过ZcType的id获得对象
	 */
	ZcType selectZcTypeById(Integer id);
	
	/**
	 * 获得一个ZcType对象
	 */
	ZcType selectZcTypeObjSingle(ZcType obj);
	
	/**
	 * 获得一个ZcType对象集合
	 */
	List<ZcType> selectZcTypeByObj(ZcType obj);


	/**
	 * 插入ZcType中属性值不为null的数据到数据库
	 */
	int insertNotNullZcType(ZcType value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertZcTypeByBatch(List<ZcType> value);
	/**
	 * 通过id删除
	 */
	int deleteZcTypeById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullZcTypeById(ZcType zcType);
}