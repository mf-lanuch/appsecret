package com.app.secret.core.util;

import com.app.secret.core.domain.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author crsu 2019/12/31
 */
public class PageUtils extends PageHelper {
    public PageUtils() {
    }

    public static void copyPageInfo(PageResult target, PageInfo source) {
        if (null != target && null != source) {
            target.setPageNum(source.getPageNum());
            target.setPageSize(source.getPageSize());
            target.setCurrentPageSize(source.getSize());
            target.setRecordTotal(source.getTotal());
            target.setPageTotal(source.getPages());
            target.setPrePage(source.getPrePage());
            target.setNextPage(source.getNextPage());
            target.setFirstPage(source.isIsFirstPage());
            target.setLastPage(source.isIsLastPage());
            target.setHasPreviousPage(source.isHasPreviousPage());
            target.setHasNextPage(source.isHasNextPage());
            target.setNavigateFirstPage(source.getNavigateFirstPage());
            target.setNavigatePageNum(source.getNavigatepageNums());
            target.setNavigateFirstPage(source.getNavigateFirstPage());
            target.setNavigateLastPage(source.getNavigateLastPage());
        }
    }
}
