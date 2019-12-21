package com.app.secret.mapper;

import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.request.PartOverTimeReq;
import com.app.secret.core.vo.PartOverTimeVO;
import com.app.secret.core.vo.PersonaOvertimeVO;
import com.app.secret.entity.MfPart;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

public interface MfPartMapper extends BaseMapper<MfPart>{

    /**
     * 获取部门加班时长
     *
     * @param partOverTimeReq
     * @return
     */
    List<PartOverTimeVO> getPartOvertime(@Param("query") PartOverTimeReq partOverTimeReq);

}

