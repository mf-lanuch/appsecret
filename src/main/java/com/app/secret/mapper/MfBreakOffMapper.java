package com.app.secret.mapper;

import com.app.secret.core.dto.QueryMfBreakOffDTO;
import com.app.secret.core.vo.MfBreakOffVO;
import com.app.secret.entity.MfBreakOff;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MfBreakOffMapper extends Mapper<MfBreakOff> {
    /**
     * 获取调休率
     *
     * @param query
     * @return
     */
    List<MfBreakOffVO> listMfBreakOff(@Param("query") QueryMfBreakOffDTO query);
}
