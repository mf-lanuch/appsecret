package com.app.secret.core.util;

import com.app.secret.core.domain.PageResult;
import com.github.pagehelper.PageInfo;

/**
 * @author crsu 2019/12/31
 */
public final class CommonConverter {
    public static <T> PageResult<T> convertToPageResult(PageInfo<T> pageInfo) {
        PageResult<T> pageResult = new PageResult<>();
        PageUtils.copyPageInfo(pageResult, pageInfo);
        pageResult.setList(pageInfo.getList());
        return pageResult;
    }
}
