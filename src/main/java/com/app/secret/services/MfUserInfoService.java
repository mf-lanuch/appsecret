package com.app.secret.services;

import com.app.secret.core.domain.PageResult;
import com.app.secret.core.dto.GetPersonalOvertimeNewDTO;
import com.app.secret.core.dto.QueryOverTimeListDTO;
import com.app.secret.core.request.PersonalAttenceReq;
import com.app.secret.core.vo.PersonalAttenceListVO;

import com.app.secret.core.vo.PersonalOtResVO;
import java.util.List;

import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.vo.PersonalOvertimeVO;
import com.app.secret.entity.MfUserInfo;

public interface MfUserInfoService {
    /**
     * 获取个人加班时长
     *
     * @param query
     * @return
     */
    PersonalOvertimeVO getPersonalOvertime(GetPersonalOvertimeNewDTO query);

    /**
     * 判断员工是否为IT人员
     *
     * @param pcode
     * @return
     */
    boolean judgeIT(String pcode);

    List<MfUserInfo> getMfUserInfoList(MfUserInfo userInfo);

    /**
     * 获取考勤明细
     *
     * @param personalAttenceReq
     * @return
     */
    PageResult<PersonalAttenceListVO> getPersonalAttenceList(PersonalAttenceReq personalAttenceReq);

    /**
     * 获取员工的加班统计列表
     *
     * @param dto
     * @return
     */
    PageResult<PersonalOvertimeVO> listPersonaOvertime(QueryOverTimeListDTO dto);
}

