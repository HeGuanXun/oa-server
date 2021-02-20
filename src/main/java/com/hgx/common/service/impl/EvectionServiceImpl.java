package com.hgx.common.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.service.EvectionService;
import com.hgx.common.dao.EvectionDao;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Evection;
/**
 * Evection的服务接口的实现类
 * @author
 */
@Service
public class EvectionServiceImpl implements EvectionService{

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private EvectionDao evectionDao;

	@Override
	public List<Evection> getList(Evection evection){
		return evectionDao.selectEvection(null);
	}
	@Override
	public Evection getEvectionById(Integer id){
		return evectionDao.selectEvectionById(id);
	}

	@Override
	public String saveNotNull(Evection evection){
		if (evection == null){
			return Assist.resultFormat(Assist.C500, "evection不能为null");
		}
		int result = evectionDao.insertNotNullEvection(evection);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(Evection evection){
		if (evection == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = evectionDao.updateNotNullEvectionById(evection);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id){
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = evectionDao.deleteEvectionById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}