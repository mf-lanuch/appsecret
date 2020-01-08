package com.app.secret.services;

import com.app.secret.core.domain.PageResult;
import com.app.secret.core.dto.QueryMfBreakOffDTO;
import com.app.secret.core.vo.MfBreakOffVO;

import java.text.ParseException;

public interface MfBreakOffService {

    /**
     * 初始化调休数据
     */
    void initMfBreakOff() throws ParseException;

    /**
     * 获取调休旅列表
     *
     * @param dto
     * @return
     */
    PageResult<MfBreakOffVO> listMfBreakOff(QueryMfBreakOffDTO dto);
}
