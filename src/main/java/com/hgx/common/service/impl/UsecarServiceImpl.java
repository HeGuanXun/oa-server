package com.hgx.common.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.service.UsecarService;
import com.hgx.common.dao.UsecarDao;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Usecar;
/**
 * Usecar的服务接口的实现类
 * @author
 */
@Service
public class UsecarServiceImpl implements UsecarService{

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private UsecarDao usecarDao;

	@Override
	public List<Usecar> getList(Usecar usecar){
		return usecarDao.selectUsecar(null);
	}
	@Override
	public Usecar getUsecarById(Integer id){
		return usecarDao.selectUsecarById(id);
	}

	@Override
	public String saveNotNull(Usecar usecar){
		if (usecar == null){
			return Assist.resultFormat(Assist.C500, "usecar不能为null");
		}
		int result = usecarDao.insertNotNullUsecar(usecar);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(Usecar usecar){
		if (usecar == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = usecarDao.updateNotNullUsecarById(usecar);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id){
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = usecarDao.deleteUsecarById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}