package com.app.secret.mapper;

import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.dto.GetPersonalOvertimeNewDTO;
import com.app.secret.core.dto.QueryOverTimeListDTO;
import com.app.secret.core.request.PersonalAttenceReq;
import com.app.secret.core.vo.PersonalOtListVO;
import com.app.secret.core.vo.PersonalOvertimeVO;
import com.app.secret.core.vo.PersonalAttenceListVO;
import com.app.secret.entity.MfUserInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface MfUserInfoMapper extends Mapper<MfUserInfo> {
    /**
     * 获取IT人员个人加班时长
     *
     * @param query
     * @return
     */
    PersonalOvertimeVO getITPersonalOvertime(@Param("query") GetPersonalOvertimeDTO query);

    /**
     * 获取非IT人员个人加班时长
     *
     * @param query
     * @return
     */
    PersonalOvertimeVO getPersonalOvertime(@Param("query") GetPersonalOvertimeDTO query);

    /**
     * 获取考勤明细
     *
     * @param personalAttenceReq
     * @return
     */
    List<PersonalAttenceListVO> getPersonalAttenceList(@Param("query") PersonalAttenceReq personalAttenceReq);

    /**
     * 获取员工的加班统计列表
     *
     * @param query
     * @return
     */
    List<PersonalOvertimeVO> listPersonaOvertime(@Param("query") QueryOverTimeListDTO query);

    /**
     * 获取员工时间段内加班时长
     *
     * @param query
     * @return
     */
    List<PersonalOtListVO> getPersonalOvertimeList(@Param("query") GetPersonalOvertimeDTO query);

    /**
     * 获取IT人员个人加班时长
     *
     * @param query
     * @return
     */
    PersonalOvertimeVO getPersonalOverTimeNew(@Param("query") GetPersonalOvertimeNewDTO query);
}

