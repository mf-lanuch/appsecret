package com.app.secret.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.secret.entity.MfWork;
import com.app.secret.mapper.MfWorkMapper;
import com.app.secret.services.MfWorkService;

@Service
public class MfWorkServiceImpl implements MfWorkService {

	@Autowired
	private MfWorkMapper mfWorkMapper;
	
	@Override
	public int insert(MfWork work) {
		return mfWorkMapper.insert(work);
	}

}

