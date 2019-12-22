package com.app.secret.services;

import java.util.List;

import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.vo.PersonaOvertimeVO;
import com.app.secret.entity.MfUserInfo;

public interface MfUserInfoService {
    /**
     * 获取个人加班时长
     *
     * @param query
     * @return
     */
    PersonaOvertimeVO getPersonalOvertime(GetPersonalOvertimeDTO query);

    /**
     * 判断员工是否为IT人员
     *
     * @param pcode
     * @return
     */
    boolean judgeIT(String pcode);
    
    List<MfUserInfo> getMfUserInfoList(MfUserInfo userInfo);
}

