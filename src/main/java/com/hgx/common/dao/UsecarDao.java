package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Usecar;
import org.apache.ibatis.annotations.Param;
/**
 * Usecar的Dao接口
 * @author
 */
public interface UsecarDao{

	/**
	 * 获得数据的总行数
	 */
	long getUsecarRowCount(Assist assist);
	
	/**
	 * 获得Usecar数据集合
	 */
	List<Usecar> selectUsecar(Assist assist);
	/**
	 * 通过Usecar的id获得对象
	 */
	Usecar selectUsecarById(Integer id);
	
	/**
	 * 获得一个Usecar对象
	 */
	Usecar selectUsecarObjSingle(Usecar obj);
	
	/**
	 * 获得一个Usecar对象集合
	 */
	List<Usecar> selectUsecarByObj(Usecar obj);


	/**
	 * 插入Usecar中属性值不为null的数据到数据库
	 */
	int insertNotNullUsecar(Usecar value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertUsecarByBatch(List<Usecar> value);
	/**
	 * 通过id删除
	 */
	int deleteUsecarById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullUsecarById(Usecar usecar);
}