package com.app.secret.mapper;

import com.app.secret.core.dto.QueryPersonalOtDetailDTO;
import com.app.secret.core.vo.PersonalOtDetailVO;
import com.app.secret.entity.MfWork;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface MfWorkMapper extends BaseMapper<MfWork> {

    /**
     * IT员工的加班明细
     *
     * @param query
     * @return
     */
    List<PersonalOtDetailVO> listItPersonalOtDetail(@Param("query") QueryPersonalOtDetailDTO query);

//    List<PersonalOtDetailVO> listItPersonalOtDetail(@Param("workYear") Integer workYear,
//                                                    @Param("workMonth") Integer workMonth,
//                                                    @Param("pcode") String pcode);

    /**
     * 员工的加班明细
     *
     * @param query
     * @return
     */
    List<PersonalOtDetailVO> listPersonalOtDetail(@Param("query") QueryPersonalOtDetailDTO query);
}

