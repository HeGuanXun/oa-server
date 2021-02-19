package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.CompanyType;
import org.apache.ibatis.annotations.Param;
/**
 * CompanyType的Dao接口
 * @author
 */
public interface CompanyTypeDao{

	/**
	 * 获得数据的总行数
	 */
	long getCompanyTypeRowCount(Assist assist);
	
	/**
	 * 获得CompanyType数据集合
	 */
	List<CompanyType> selectCompanyType(Assist assist);
	/**
	 * 通过CompanyType的id获得对象
	 */
	CompanyType selectCompanyTypeById(Integer id);
	
	/**
	 * 获得一个CompanyType对象
	 */
	CompanyType selectCompanyTypeObjSingle(CompanyType obj);
	
	/**
	 * 获得一个CompanyType对象集合
	 */
	List<CompanyType> selectCompanyTypeByObj(CompanyType obj);


	/**
	 * 插入CompanyType中属性值不为null的数据到数据库
	 */
	int insertNotNullCompanyType(CompanyType value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertCompanyTypeByBatch(List<CompanyType> value);
	/**
	 * 通过id删除
	 */
	int deleteCompanyTypeById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullCompanyTypeById(CompanyType companyType);
}