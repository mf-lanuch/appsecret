package com.app.secret.services;

import com.app.secret.core.domain.PageResult;
import com.app.secret.core.dto.QueryPersonalOtDetailDTO;
import com.app.secret.entity.MfWork;


public interface MfWorkService {

    int insert(MfWork work);

    int delete(MfWork work);

    /**
     * IT员工的加班明细
     *
     * @param query
     * @return
     */
    PageResult listPersonalOtDetail(QueryPersonalOtDetailDTO query);
}