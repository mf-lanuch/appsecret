package com.app.secret.services.impl;

import org.springframework.stereotype.Service;
import com.app.secret.core.base.serviceimpl.BaseServiceImpl;
import com.app.secret.entity.AppDept;
import com.app.secret.mapper.AppDeptMapper;
import com.app.secret.services.AppDeptService;

@Service
public class AppDeptServiceImpl extends BaseServiceImpl<AppDept, AppDeptMapper> implements AppDeptService {

}

