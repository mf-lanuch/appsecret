package com.app.secret.services;

import com.app.secret.core.dto.QueryPersonalOtDetailDTO;
import com.app.secret.core.vo.PersonalOtDetailVO;
import com.app.secret.entity.MfWork;

import java.util.List;

public interface MfWorkService {

    int insert(MfWork work);

    int delete(MfWork work);

    /**
     * IT员工的加班明细
     *
     * @param query
     * @return
     */
    List<PersonalOtDetailVO> listPersonalOtDetail(QueryPersonalOtDetailDTO query);
}