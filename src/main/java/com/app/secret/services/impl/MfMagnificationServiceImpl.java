package com.app.secret.services.impl;

import com.app.secret.core.dto.UpdateMfMagDTO;
import com.app.secret.core.vo.MfMagnificationVO;
import com.app.secret.entity.MfMagnification;
import com.app.secret.mapper.MfMagnificationMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.secret.services.MfMagnificationService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MfMagnificationServiceImpl implements MfMagnificationService {

    @Autowired
    private MfMagnificationMapper mfMagnificationMapper;

    @Override
    public List<MfMagnificationVO> listMfMagnification() {
        List<MfMagnification> list = mfMagnificationMapper.selectAll();
        List<MfMagnificationVO> vos = new ArrayList<>();
        for (MfMagnification mfMagnification : list) {
            MfMagnificationVO vo = new MfMagnificationVO();
            BeanUtils.copyProperties(mfMagnification, vo);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MfMagnification updateMfMagnification(UpdateMfMagDTO dto) {
        MfMagnification magnification = mfMagnificationMapper.selectByPrimaryKey(dto.getId());
        magnification.setUpdateTime(new Date());
        magnification.setMagValue(dto.getMagValue());
        mfMagnificationMapper.updateByPrimaryKey(magnification);
        return magnification;
    }
}

