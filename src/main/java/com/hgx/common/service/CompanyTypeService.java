package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.CompanyType;

/**
 * CompanyType的服务接口
 * @author
 */
public interface CompanyTypeService{
	/**
	 * 获得所以数据集
	 */
	List<CompanyType> getList(CompanyType companyType);

	/**
	 * 获取CompanyType信息
	 */
	CompanyType getCompanyTypeById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(CompanyType companyType);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(CompanyType companyType);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
