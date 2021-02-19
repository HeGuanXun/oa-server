package com.hgx.common.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.service.ConferenceService;
import com.hgx.common.dao.ConferenceDao;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Conference;
/**
 * Conference的服务接口的实现类
 * @author
 */
@Service
public class ConferenceServiceImpl implements ConferenceService{

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private ConferenceDao conferenceDao;

	@Override
	public List<Conference> getList(Conference conference){
		return conferenceDao.selectConference(null);
	}
	@Override
	public Conference getConferenceById(Integer id){
		return conferenceDao.selectConferenceById(id);
	}

	@Override
	public String saveNotNull(Conference conference){
		if (conference == null){
			return Assist.resultFormat(Assist.C500, "conference不能为null");
		}
		int result = conferenceDao.insertNotNullConference(conference);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(Conference conference){
		if (conference == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = conferenceDao.updateNotNullConferenceById(conference);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id){
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = conferenceDao.deleteConferenceById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}