package com.app.secret.services.impl;

import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.dto.QueryOverTimeListDTO;
import com.app.secret.core.request.PersonalAttenceReq;
import com.app.secret.core.vo.PersonalOtListVO;
import com.app.secret.core.vo.PersonalOtResVO;
import com.app.secret.core.vo.PersonalOvertimeVO;
import com.app.secret.core.vo.PersonalAttenceListVO;
import com.app.secret.entity.MfUserInfo;
import com.app.secret.mapper.MfUserInfoMapper;

import java.util.ArrayList;
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
    public PersonalOtResVO getPersonalOvertime(GetPersonalOvertimeDTO query) {
        String pcode = query.getPcode();
        PersonalOtResVO personalOtResVO = new PersonalOtResVO();
        PersonalOvertimeVO vo;
        List<PersonalOtListVO> personalOtListVOS = new ArrayList<>();
        if (this.judgeIT(pcode)) {
            // IT 人员
            vo = mfUserInfoMapper.getITPersonalOvertime(query);
            // 获取加班明细
            personalOtListVOS = mfUserInfoMapper.getPersonalOvertimeList(query);
            personalOtResVO.setPersonalOvertimeVO(vo);
            personalOtResVO.setPersonalOtListVOS(personalOtListVOS);
            return personalOtResVO;
        }
        // 非IT
        vo = mfUserInfoMapper.getPersonalOvertime(query);
        // 获取加班明细
        personalOtListVOS = mfUserInfoMapper.getPersonalOvertimeList(query);
        personalOtResVO.setPersonalOvertimeVO(vo);
        personalOtResVO.setPersonalOtListVOS(personalOtListVOS);
        return personalOtResVO;
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

    @Override
    public List<PersonalOvertimeVO> listPersonaOvertime(QueryOverTimeListDTO dto) {
        return mfUserInfoMapper.listPersonaOvertime(dto);
    }
}

