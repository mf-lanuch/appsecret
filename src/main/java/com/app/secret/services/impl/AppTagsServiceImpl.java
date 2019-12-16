package com.app.secret.services.impl;

import org.springframework.stereotype.Service;
import com.app.secret.core.base.serviceimpl.BaseServiceImpl;
import com.app.secret.entity.AppTags;
import com.app.secret.mapper.AppTagsMapper;
import com.app.secret.services.AppTagsService;

@Service
public class AppTagsServiceImpl extends BaseServiceImpl<AppTags, AppTagsMapper> implements AppTagsService {

}

