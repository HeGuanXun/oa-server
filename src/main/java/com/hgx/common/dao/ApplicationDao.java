package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Application;
import org.apache.ibatis.annotations.Param;
/**
 * Application的Dao接口
 * @author
 */
public interface ApplicationDao{

	/**
	 * 获得数据的总行数
	 */
	long getApplicationRowCount(Assist assist);
	
	/**
	 * 获得Application数据集合
	 */
	List<Application> selectApplication(Assist assist);
	/**
	 * 通过Application的id获得对象
	 */
	Application selectApplicationById(Integer id);
	
	/**
	 * 获得一个Application对象
	 */
	Application selectApplicationObjSingle(Application obj);
	
	/**
	 * 获得一个Application对象集合
	 */
	List<Application> selectApplicationByObj(Application obj);


	/**
	 * 插入Application中属性值不为null的数据到数据库
	 */
	int insertNotNullApplication(Application value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertApplicationByBatch(List<Application> value);
	/**
	 * 通过id删除
	 */
	int deleteApplicationById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullApplicationById(Application application);
}