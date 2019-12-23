package com.app.secret.mapper;

import com.app.secret.core.vo.PeriodOverTimeVO;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.secret.core.dto.OvertimeRateDto;
import com.app.secret.core.request.DeptOvertimeReq;
import com.app.secret.core.request.OvertimeRateReq;
import com.app.secret.core.request.PartOverTimeReq;
import com.app.secret.core.vo.PartOverTimeVO;
import com.app.secret.entity.MfPart;

import tk.mybatis.mapper.common.BaseMapper;

public interface MfPartMapper extends BaseMapper<MfPart>{

    /**
     * 获取部门加班时长
     *
     * @param partOverTimeReq
     * @return
     */
    List<PartOverTimeVO> getPartOvertime(@Param("query") PartOverTimeReq partOverTimeReq);

    /**
     * 获取部门加班时长
     *
     * @param overtimeRateReq
     * @return
     */
    OvertimeRateDto getCompanyOvertimeRate(@Param("query") OvertimeRateReq overtimeRateReq);

    /**
     * 获取部门加班时长
     *
     * @param overtimeRateReq
     * @return
     */
    OvertimeRateDto getItOvertimeRate(@Param("query") OvertimeRateReq overtimeRateReq);

    /**
     * 获取部门加班时长
     *
     * @param overtimeRateReq
     * @return
     */
    OvertimeRateDto getTraditionOvertimeRate(@Param("query") OvertimeRateReq overtimeRateReq);


    /**
     * 获取部门每月加班时长
     *
     * @param deptOvertimeReq
     *
     * @return
     */
    List<PartOverTimeVO> getDeptOvertimeMonth(@Param("query") DeptOvertimeReq deptOvertimeReq);

    /**
     * 获取部门每月加班时长及同期加班时长
     *
     * @param deptOvertimeReq
     *
     * @return
     */
    List<PeriodOverTimeVO> getPeriodOvertime(@Param("query") DeptOvertimeReq deptOvertimeReq);


}

