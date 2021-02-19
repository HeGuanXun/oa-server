package com.hgx.common.service.impl;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.service.AssetService;
import com.hgx.common.dao.AssetDao;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.Asset;
/**
 * Asset的服务接口的实现类
 * @author
 */
@Service
public class AssetServiceImpl implements AssetService{

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private AssetDao assetDao;

	@Override
	public List<Asset> getList(Asset asset){
		return assetDao.selectAsset(null);
	}
	@Override
	public Asset getAssetById(Integer id){
		return assetDao.selectAssetById(id);
	}

	@Override
	public String saveNotNull(Asset asset){
		if (asset == null){
			return Assist.resultFormat(Assist.C500, "asset不能为null");
		}
		int result = assetDao.insertNotNullAsset(asset);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(Asset asset){
		if (asset == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = assetDao.updateNotNullAssetById(asset);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id){
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = assetDao.deleteAssetById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}