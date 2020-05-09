package com.pytap.project.web.service.impl;

import com.pytap.project.dao.AnnexMapper;
import com.pytap.project.entity.Annex;
import com.pytap.project.entity.AnnexExample;
import com.pytap.project.web.service.AnnexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/9 17:14
 */
@Service
public class AnnexServiceImpl implements AnnexService {

	@Resource
	private AnnexMapper annexMapper;

	@Override
	public Integer insertAnnex(Annex annex) {
		annex.setCreateTime(new Date());
		return annexMapper.insert(annex);
	}

	@Override
	public Integer deleteAnnex(Long id) {
		return annexMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateAnnex(Annex annex) {
		return annexMapper.updateByPrimaryKey(annex);
	}

	@Override
	public List<Annex> listAnnexesByTaskId(Long id) {
		AnnexExample annexExample = new AnnexExample();
		AnnexExample.Criteria criteria = annexExample.createCriteria();
		criteria.andTaskIdEqualTo(id);
		return annexMapper.selectByExample(annexExample);
	}
}
