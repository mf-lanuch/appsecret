package com.app.secret.services.impl;

import com.app.secret.core.domain.PageResult;
import com.app.secret.core.dto.QueryMfBreakOffDTO;
import com.app.secret.core.dto.QueryOverTimeListDTO;
import com.app.secret.core.util.CommonConverter;
import com.app.secret.core.vo.MfBreakOffVO;
import com.app.secret.core.vo.PersonalOvertimeVO;
import com.app.secret.entity.MfUserInfo;
import com.app.secret.mapper.MfBreakOffMapper;
import com.app.secret.mapper.MfUserInfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import com.app.secret.entity.MfBreakOff;
import com.app.secret.services.MfBreakOffService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MfBreakOffServiceImpl implements MfBreakOffService {

    @Autowired
    private MfBreakOffMapper mfBreakOffMapper;

    @Autowired
    private MfUserInfoMapper mfUserInfoMapper;

    @Override
    public void initMfBreakOff() throws ParseException {
        // 初始化十二月份调休统计
        QueryOverTimeListDTO query = new QueryOverTimeListDTO();
        query.setWorkStartDate(DateUtils.parseDate("2019-12-1", "yyyy-MM-dd"));
        query.setWorkEndDate(DateUtils.parseDate("2019-12-31", "yyyy-MM-dd"));

        List<PersonalOvertimeVO> personalOvertimeVOS = mfUserInfoMapper.listPersonaOvertime(query);
        for (PersonalOvertimeVO eachVO : personalOvertimeVOS) {
            MfBreakOff mfBreakOff = new MfBreakOff();
            mfBreakOff.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
            mfBreakOff.setUserId(this.getUserIdByPcode(eachVO));
            mfBreakOff.setWorkMonth(12);
            mfBreakOff.setWorkYear(2019);
            mfBreakOff.setUsableBreakOffTime(DateUtils.parseDate(secondToDate(eachVO.getTotalOverTime(), "HH:mm:ss"), "HH:mm:ss"));
            // 随机设置已调休时间 不得大于可调休时间
            mfBreakOff.setUsedBreakOffTime(randomDate("00:00:00", secondToDate(eachVO.getTotalOverTime(), "HH:mm:ss")));
            mfBreakOff.setInsertTime(new Date());
            mfBreakOff.setUpdateTime(new Date());
            mfBreakOffMapper.insertSelective(mfBreakOff);
        }
    }

    @Override
    public PageResult<MfBreakOffVO> listMfBreakOff(QueryMfBreakOffDTO dto) {
        PageHelper.startPage(dto.getPageIndex(), dto.getPageSize());
        return CommonConverter.convertToPageResult(new PageInfo<>(mfBreakOffMapper.listMfBreakOff(dto)));
    }

    // region
    private String getUserIdByPcode(PersonalOvertimeVO eachVO) {
        Example example = new Example(MfUserInfo.class);
        example.createCriteria().andEqualTo("pcode", eachVO.getPcode());
        List<MfUserInfo> userInfos = mfUserInfoMapper.selectByExample(example);
        return userInfos.get(0).getId();
    }

    private static Date randomDate(String beginTime, String endTime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date start = format.parse(beginTime);
            Date end = format.parse(endTime);

            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    /**
     * 秒转换为指定格式的日期
     *
     * @param second
     * @param patten
     * @return
     */
    private String secondToDate(long second, String patten) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(second * 1000);//转换为毫秒
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat(patten);
        String dateString = format.format(date);
        return dateString;
    }
    // endregion
}
