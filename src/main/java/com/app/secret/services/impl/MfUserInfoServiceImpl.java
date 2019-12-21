package com.app.secret.services.impl;

import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.vo.PersonaOvertimeVO;
import com.app.secret.mapper.MfUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.secret.services.MfUserInfoService;

@Service
public class MfUserInfoServiceImpl implements MfUserInfoService {
    @Autowired
    private MfUserInfoMapper mfUserInfoMapper;

    @Override
    public PersonaOvertimeVO getPersonalOvertime(GetPersonalOvertimeDTO query) {
        String pcode = query.getPcode();
        if (this.judgeIT(pcode)) {
            // IT 人员
            PersonaOvertimeVO vo = mfUserInfoMapper.getITPersonalOvertime(query);
            return vo;
        }
        // TODO 非IT
        return null;
    }

    @Override
    public boolean judgeIT(String pcode) {
        // TODO
        return true;
    }
}

