package com.app.secret.services.impl;

import com.app.secret.core.request.PartOverTimeReq;
import com.app.secret.core.vo.PartOverTimeVO;
import com.app.secret.mapper.MfPartMapper;
import com.app.secret.mapper.MfUserInfoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.secret.services.MfPartService;

@Service
public class MfPartServiceImpl implements MfPartService {

    @Autowired
    private MfPartMapper mfPartMapper;

    @Override
    public List<PartOverTimeVO> getPartOvertime(PartOverTimeReq partOverTimeReq) {
        return mfPartMapper.getPartOvertime(partOverTimeReq);
    }
}

