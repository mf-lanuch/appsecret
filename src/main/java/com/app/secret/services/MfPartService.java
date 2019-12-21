package com.app.secret.services;

import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.request.PartOverTimeReq;
import com.app.secret.core.vo.PartOverTimeVO;
import com.app.secret.core.vo.PersonaOvertimeVO;
import java.util.List;

public interface MfPartService {

    /**
     * 获取部门加班时长
     *
     * @param partOverTimeReq
     * @return
     */
     List<PartOverTimeVO> getPartOvertime(PartOverTimeReq partOverTimeReq);

}

