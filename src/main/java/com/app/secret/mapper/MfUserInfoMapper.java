package com.app.secret.mapper;

import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.vo.PersonaOvertimeVO;
import com.app.secret.entity.MfUserInfo;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

public interface MfUserInfoMapper extends BaseMapper<MfUserInfo>{
    /**
     * 获取IT人员个人加班时长
     *
     * @param query
     * @return
     */
    PersonaOvertimeVO getITPersonalOvertime(@Param("query") GetPersonalOvertimeDTO query);
}

