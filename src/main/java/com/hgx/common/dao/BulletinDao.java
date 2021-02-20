package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Bulletin;
import org.apache.ibatis.annotations.Param;
/**
 * Bulletin的Dao接口
 * @author
 */
public interface BulletinDao{

	/**
	 * 获得数据的总行数
	 */
	long getBulletinRowCount(Assist assist);
	
	/**
	 * 获得Bulletin数据集合
	 */
	List<Bulletin> selectBulletin(Assist assist);
	/**
	 * 通过Bulletin的id获得对象
	 */
	Bulletin selectBulletinById(Integer id);
	
	/**
	 * 获得一个Bulletin对象
	 */
	Bulletin selectBulletinObjSingle(Bulletin obj);
	
	/**
	 * 获得一个Bulletin对象集合
	 */
	List<Bulletin> selectBulletinByObj(Bulletin obj);


	/**
	 * 插入Bulletin中属性值不为null的数据到数据库
	 */
	int insertNotNullBulletin(Bulletin value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertBulletinByBatch(List<Bulletin> value);
	/**
	 * 通过id删除
	 */
	int deleteBulletinById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullBulletinById(Bulletin bulletin);
}