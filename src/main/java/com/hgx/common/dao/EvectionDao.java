package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Evection;
import org.apache.ibatis.annotations.Param;
/**
 * Evection的Dao接口
 * @author
 */
public interface EvectionDao{

	/**
	 * 获得数据的总行数
	 */
	long getEvectionRowCount(Assist assist);
	
	/**
	 * 获得Evection数据集合
	 */
	List<Evection> selectEvection(Assist assist);
	/**
	 * 通过Evection的id获得对象
	 */
	Evection selectEvectionById(Integer id);
	
	/**
	 * 获得一个Evection对象
	 */
	Evection selectEvectionObjSingle(Evection obj);
	
	/**
	 * 获得一个Evection对象集合
	 */
	List<Evection> selectEvectionByObj(Evection obj);


	/**
	 * 插入Evection中属性值不为null的数据到数据库
	 */
	int insertNotNullEvection(Evection value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertEvectionByBatch(List<Evection> value);
	/**
	 * 通过id删除
	 */
	int deleteEvectionById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullEvectionById(Evection evection);
}