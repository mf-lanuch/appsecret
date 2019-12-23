package com.app.secret.services;

import com.app.secret.core.dto.UpdateMfMagDTO;
import com.app.secret.core.vo.MfMagnificationVO;
import com.app.secret.entity.MfMagnification;

import java.util.List;

public interface MfMagnificationService {
    List<MfMagnificationVO> listMfMagnification();

    MfMagnification updateMfMagnification(UpdateMfMagDTO dto);
}

