package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Leaves;
import org.apache.ibatis.annotations.Param;
/**
 * Leaves的Dao接口
 * @author
 */
public interface LeavesDao{

	/**
	 * 获得数据的总行数
	 */
	long getLeavesRowCount(Assist assist);
	
	/**
	 * 获得Leaves数据集合
	 */
	List<Leaves> selectLeaves(Assist assist);
	/**
	 * 通过Leaves的id获得对象
	 */
	Leaves selectLeavesById(Integer id);
	
	/**
	 * 获得一个Leaves对象
	 */
	Leaves selectLeavesObjSingle(Leaves obj);
	
	/**
	 * 获得一个Leaves对象集合
	 */
	List<Leaves> selectLeavesByObj(Leaves obj);


	/**
	 * 插入Leaves中属性值不为null的数据到数据库
	 */
	int insertNotNullLeaves(Leaves value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertLeavesByBatch(List<Leaves> value);
	/**
	 * 通过id删除
	 */
	int deleteLeavesById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullLeavesById(Leaves leaves);
}