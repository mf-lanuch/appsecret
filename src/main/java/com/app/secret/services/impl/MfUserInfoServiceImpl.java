package com.app.secret.services.impl;

import com.app.secret.core.domain.PageResult;
import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.dto.GetPersonalOvertimeNewDTO;
import com.app.secret.core.dto.QueryOverTimeListDTO;
import com.app.secret.core.request.PersonalAttenceReq;
import com.app.secret.core.util.CommonConverter;
import com.app.secret.core.vo.PersonalOtListVO;
import com.app.secret.core.vo.PersonalOtResVO;
import com.app.secret.core.vo.PersonalOvertimeVO;
import com.app.secret.core.vo.PersonalAttenceListVO;
import com.app.secret.entity.MfUserInfo;
import com.app.secret.mapper.MfUserInfoMapper;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.secret.services.MfUserInfoService;
import tk.mybatis.mapper.entity.Example;

@Service
public class MfUserInfoServiceImpl implements MfUserInfoService {
    @Autowired
    private MfUserInfoMapper mfUserInfoMapper;

    @Override
    public PersonalOvertimeVO getPersonalOvertime(GetPersonalOvertimeNewDTO query) {
        String pcode = query.getPcode();
        PersonalOvertimeVO vo;
        vo = mfUserInfoMapper.getPersonalOverTimeNew(query);
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
    public PageResult<PersonalAttenceListVO> getPersonalAttenceList(PersonalAttenceReq personalAttenceReq) {
        PageHelper.startPage(personalAttenceReq.getPageIndex(), personalAttenceReq.getPageSize());
        return CommonConverter.convertToPageResult(new PageInfo<>(mfUserInfoMapper.getPersonalAttenceList(personalAttenceReq)));
    }

    @Override
    public PageResult<PersonalOvertimeVO> listPersonaOvertime(QueryOverTimeListDTO dto) {
        PageHelper.startPage(dto.getPageIndex(), dto.getPageSize());
        return CommonConverter.convertToPageResult(new PageInfo<>(mfUserInfoMapper.listPersonaOvertime(dto)));
    }
}

