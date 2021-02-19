package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Conference;
import org.apache.ibatis.annotations.Param;
/**
 * Conference的Dao接口
 * @author
 */
public interface ConferenceDao{

	/**
	 * 获得数据的总行数
	 */
	long getConferenceRowCount(Assist assist);
	
	/**
	 * 获得Conference数据集合
	 */
	List<Conference> selectConference(Assist assist);
	/**
	 * 通过Conference的id获得对象
	 */
	Conference selectConferenceById(Integer id);
	
	/**
	 * 获得一个Conference对象
	 */
	Conference selectConferenceObjSingle(Conference obj);
	
	/**
	 * 获得一个Conference对象集合
	 */
	List<Conference> selectConferenceByObj(Conference obj);


	/**
	 * 插入Conference中属性值不为null的数据到数据库
	 */
	int insertNotNullConference(Conference value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertConferenceByBatch(List<Conference> value);
	/**
	 * 通过id删除
	 */
	int deleteConferenceById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullConferenceById(Conference conference);
}