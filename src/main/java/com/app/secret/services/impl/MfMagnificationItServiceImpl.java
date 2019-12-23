package com.app.secret.services.impl;

import com.app.secret.core.vo.MfMagnificationVO;
import com.app.secret.entity.MfMagnificationIt;
import com.app.secret.mapper.MfMagnificationItMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.secret.services.MfMagnificationItService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MfMagnificationItServiceImpl implements MfMagnificationItService {

    @Autowired
    private MfMagnificationItMapper mfMagnificationItMapper;

    @Override
    public List<MfMagnificationVO> listMfMagnificationIt() {
        List<MfMagnificationIt> list = mfMagnificationItMapper.selectAll();
        List<MfMagnificationVO> vos = new ArrayList<>();
        for (MfMagnificationIt mfMagnificationIt : list) {
            MfMagnificationVO vo = new MfMagnificationVO();
            BeanUtils.copyProperties(mfMagnificationIt, vo);
            vos.add(vo);
        }
        return vos;
    }
}

