package com.app.secret.services.impl;

import com.app.secret.core.dto.OvertimeRateDto;
import com.app.secret.core.request.DeptOvertimeReq;
import com.app.secret.core.request.OvertimeRateReq;
import com.app.secret.core.request.PartOverTimeReq;
import com.app.secret.core.request.PeriodOvertimeReq;
import com.app.secret.core.vo.OverTimeRateVO;
import com.app.secret.core.vo.PartOverTimeVO;
import com.app.secret.core.vo.PeriodOverTimeVO;
import com.app.secret.core.vo.PeriodOvertimeWeekVO;
import com.app.secret.mapper.MfPartMapper;
import com.app.secret.mapper.MfUserInfoMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.secret.services.MfPartService;

@Service
public class MfPartServiceImpl implements MfPartService {

    @Autowired
    private MfPartMapper mfPartMapper;

    @Override
    public List<PartOverTimeVO> getPartOvertime(PartOverTimeReq partOverTimeReq) {
        return mfPartMapper.getPartOvertime(partOverTimeReq);
    }

    @Override
    public OverTimeRateVO getOverTimeRate(OvertimeRateReq overtimeRateReq) {
        OverTimeRateVO overTimeRateVO = new OverTimeRateVO();
        OvertimeRateDto companyOverTime = new OvertimeRateDto();
        OvertimeRateDto itOverTime = new OvertimeRateDto();
        OvertimeRateDto traditionOverTime = new OvertimeRateDto();
        companyOverTime = mfPartMapper.getCompanyOvertimeRate(overtimeRateReq);
        itOverTime = mfPartMapper.getItOvertimeRate(overtimeRateReq);
        traditionOverTime = mfPartMapper.getTraditionOvertimeRate(overtimeRateReq);
        overTimeRateVO.setCompanyitOvertimeRate(
            companyOverTime == null ? 0 : companyOverTime.getOverTimeRate());
        overTimeRateVO.setItOvertimeRate(itOverTime == null ? 0 : itOverTime.getOverTimeRate());
        overTimeRateVO.setTraditionOvertimeRate(
            traditionOverTime == null ? 0 : traditionOverTime.getOverTimeRate());
        return overTimeRateVO;
    }

    @Override
    public List<PartOverTimeVO> getDeptOvertimeMonth(DeptOvertimeReq deptOvertimeReq) {
        return mfPartMapper.getDeptOvertimeMonth(deptOvertimeReq);
    }

    @Override
    public List<PeriodOverTimeVO> getPeriodOvertime(DeptOvertimeReq deptOvertimeReq) {
        return mfPartMapper.getPeriodOvertime(deptOvertimeReq);
    }

    @Override
    public List<PeriodOvertimeWeekVO> getPeriodOvertimeWeek(PeriodOvertimeReq periodOvertimeReq) {
        return mfPartMapper.getPeriodOvertimeWeek(periodOvertimeReq);

    }
}

