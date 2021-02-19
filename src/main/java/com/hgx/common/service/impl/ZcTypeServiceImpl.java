package com.hgx.common.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.service.ZcTypeService;
import com.hgx.common.dao.ZcTypeDao;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.ZcType;
/**
 * ZcType的服务接口的实现类
 * @author
 */
@Service
public class ZcTypeServiceImpl implements ZcTypeService{

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private ZcTypeDao zcTypeDao;

	@Override
	public List<ZcType> getList(ZcType zcType){
		return zcTypeDao.selectZcType(null);
	}
	@Override
	public ZcType getZcTypeById(Integer id){
		return zcTypeDao.selectZcTypeById(id);
	}

	@Override
	public String saveNotNull(ZcType zcType){
		if (zcType == null){
			return Assist.resultFormat(Assist.C500, "zcType不能为null");
		}
		int result = zcTypeDao.insertNotNullZcType(zcType);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(ZcType zcType){
		if (zcType == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = zcTypeDao.updateNotNullZcTypeById(zcType);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id){
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = zcTypeDao.deleteZcTypeById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}