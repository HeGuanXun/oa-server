package com.hgx.common.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.service.ApplicationService;
import com.hgx.common.dao.ApplicationDao;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Application;
/**
 * Application的服务接口的实现类
 * @author
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private ApplicationDao applicationDao;

	@Override
	public List<Application> getList(Application application){
		return applicationDao.selectApplication(null);
	}
	@Override
	public Application getApplicationById(Integer id){
		return applicationDao.selectApplicationById(id);
	}

	@Override
	public String saveNotNull(Application application){
		if (application == null){
			return Assist.resultFormat(Assist.C500, "application不能为null");
		}
		int result = applicationDao.insertNotNullApplication(application);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(Application application){
		if (application == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = applicationDao.updateNotNullApplicationById(application);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id){
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = applicationDao.deleteApplicationById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}