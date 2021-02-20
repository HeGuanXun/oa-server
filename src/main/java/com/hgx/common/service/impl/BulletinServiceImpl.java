package com.hgx.common.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.service.BulletinService;
import com.hgx.common.dao.BulletinDao;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Bulletin;
/**
 * Bulletin的服务接口的实现类
 * @author
 */
@Service
public class BulletinServiceImpl implements BulletinService{

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private BulletinDao bulletinDao;

	@Override
	public List<Bulletin> getList(Bulletin bulletin){
		return bulletinDao.selectBulletin(null);
	}
	@Override
	public Bulletin getBulletinById(Integer id){
		return bulletinDao.selectBulletinById(id);
	}

	@Override
	public String saveNotNull(Bulletin bulletin){
		if (bulletin == null){
			return Assist.resultFormat(Assist.C500, "bulletin不能为null");
		}
		int result = bulletinDao.insertNotNullBulletin(bulletin);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(Bulletin bulletin){
		if (bulletin == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = bulletinDao.updateNotNullBulletinById(bulletin);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id){
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = bulletinDao.deleteBulletinById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}