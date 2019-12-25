package com.app.secret.services.impl;

import com.app.secret.core.dto.QueryPersonalOtDetailDTO;
import com.app.secret.core.vo.PersonalOtDetailVO;
import com.app.secret.services.MfUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.secret.entity.MfWork;
import com.app.secret.mapper.MfWorkMapper;
import com.app.secret.services.MfWorkService;

import java.util.List;

@Service
public class MfWorkServiceImpl implements MfWorkService {

	@Autowired
	private MfWorkMapper mfWorkMapper;

	@Autowired
	private MfUserInfoService mfUserInfoService;

	@Override
	public int insert(MfWork work) {
		return mfWorkMapper.insert(work);
	}

	@Override
	public int delete(MfWork work) {
		return mfWorkMapper.delete(work);
	}

	@Override
	public List<PersonalOtDetailVO> listPersonalOtDetail(QueryPersonalOtDetailDTO query) {
		if (mfUserInfoService.judgeIT(query.getPcode())) {
			// it
			return mfWorkMapper.listItPersonalOtDetail(query);
		}
		return null;
	}

}

