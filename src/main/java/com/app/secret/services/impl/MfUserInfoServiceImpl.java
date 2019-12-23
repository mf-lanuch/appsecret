package com.app.secret.services.impl;

import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.request.PersonalAttenceReq;
import com.app.secret.core.vo.PersonaOvertimeVO;
import com.app.secret.core.vo.PersonalAttenceListVO;
import com.app.secret.entity.MfUserInfo;
import com.app.secret.mapper.MfUserInfoMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.secret.services.MfUserInfoService;
import tk.mybatis.mapper.entity.Example;

@Service
public class MfUserInfoServiceImpl implements MfUserInfoService {
    @Autowired
    private MfUserInfoMapper mfUserInfoMapper;

    @Override
    public PersonaOvertimeVO getPersonalOvertime(GetPersonalOvertimeDTO query) {
        String pcode = query.getPcode();
        PersonaOvertimeVO vo;
        if (this.judgeIT(pcode)) {
            // IT 人员
            vo = mfUserInfoMapper.getITPersonalOvertime(query);
            return vo;
        }
        // 非IT
        vo = mfUserInfoMapper.getPersonalOvertime(query);
        return vo;
    }

    @Override
    public boolean judgeIT(String pcode) {
        Example example = new Example(MfUserInfo.class);
        example.createCriteria().andEqualTo("pcode", pcode);
        List<MfUserInfo> mfUserInfos = mfUserInfoMapper.selectByExample(example);
        if (0 < mfUserInfos.size()) {
            return 1 == mfUserInfos.get(0).getIsIt();
        }
        return true;
    }

	@Override
	public List<MfUserInfo> getMfUserInfoList(MfUserInfo userInfo) {
		return mfUserInfoMapper.select(userInfo);
	}

    @Override
    public List<PersonalAttenceListVO> getPersonalAttenceList(
        PersonalAttenceReq personalAttenceReq) {
        return mfUserInfoMapper.getPersonalAttenceList(personalAttenceReq);
    }
}

