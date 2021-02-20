package com.hgx.common.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.service.LeavesService;
import com.hgx.common.dao.LeavesDao;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Leaves;
/**
 * Leaves的服务接口的实现类
 * @author
 */
@Service
public class LeavesServiceImpl implements LeavesService{

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private LeavesDao leavesDao;

	@Override
	public List<Leaves> getList(Leaves leaves){
		return leavesDao.selectLeaves(null);
	}
	@Override
	public Leaves getLeavesById(Integer id){
		return leavesDao.selectLeavesById(id);
	}

	@Override
	public String saveNotNull(Leaves leaves){
		if (leaves == null){
			return Assist.resultFormat(Assist.C500, "leaves不能为null");
		}
		int result = leavesDao.insertNotNullLeaves(leaves);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(Leaves leaves){
		if (leaves == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = leavesDao.updateNotNullLeavesById(leaves);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id){
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = leavesDao.deleteLeavesById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}