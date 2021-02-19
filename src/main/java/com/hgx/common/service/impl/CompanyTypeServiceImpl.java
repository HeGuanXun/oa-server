package com.hgx.common.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.service.CompanyTypeService;
import com.hgx.common.dao.CompanyTypeDao;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.CompanyType;
/**
 * CompanyType的服务接口的实现类
 * @author
 */
@Service
public class CompanyTypeServiceImpl implements CompanyTypeService{

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private CompanyTypeDao companyTypeDao;

	@Override
	public List<CompanyType> getList(CompanyType companyType){
		return companyTypeDao.selectCompanyType(null);
	}
	@Override
	public CompanyType getCompanyTypeById(Integer id){
		return companyTypeDao.selectCompanyTypeById(id);
	}

	@Override
	public String saveNotNull(CompanyType companyType){
		if (companyType == null){
			return Assist.resultFormat(Assist.C500, "companyType不能为null");
		}
		int result = companyTypeDao.insertNotNullCompanyType(companyType);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(CompanyType companyType){
		if (companyType == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = companyTypeDao.updateNotNullCompanyTypeById(companyType);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id){
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = companyTypeDao.deleteCompanyTypeById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}