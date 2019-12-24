package com.app.secret.services;

import com.app.secret.core.dto.UpdateMfMagDTO;
import com.app.secret.core.vo.MfMagnificationVO;
import com.app.secret.entity.MfMagnificationIt;

import java.util.List;

public interface MfMagnificationItService {
    List<MfMagnificationVO> listMfMagnificationIt();

    MfMagnificationIt updateMfMagnificationIt(UpdateMfMagDTO dto);

}

