package com.app.secret.core.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 * @author crsu 2019/12/31
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -2244096662620574843L;
    private int pageNum;
    private int pageSize;
    private int currentPageSize;
    private long recordTotal;
    private int pageTotal;
    private List<T> list;
    private int prePage;
    private int nextPage;
    private boolean firstPage = false;
    private boolean lastPage = false;
    private boolean hasPreviousPage = false;
    private boolean hasNextPage = false;
    private int navigatePages;
    private int[] navigatePageNum;
    private int navigateFirstPage;
    private int navigateLastPage;

    public PageResult() {
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageSize() {
        return this.currentPageSize;
    }

    public void setCurrentPageSize(int currentPageSize) {
        this.currentPageSize = currentPageSize;
    }

    public long getRecordTotal() {
        return this.recordTotal;
    }

    public void setRecordTotal(long recordTotal) {
        this.recordTotal = recordTotal;
    }

    public int getPageTotal() {
        return this.pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPrePage() {
        return this.prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isFirstPage() {
        return this.firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return this.lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isHasPreviousPage() {
        return this.hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return this.hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return this.navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int[] getNavigatePageNum() {
        return this.navigatePageNum;
    }

    public void setNavigatePageNum(int[] navigatePageNum) {
        this.navigatePageNum = navigatePageNum;
    }

    public int getNavigateFirstPage() {
        return this.navigateFirstPage;
    }

    public void setNavigateFirstPage(int navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public int getNavigateLastPage() {
        return this.navigateLastPage;
    }

    public void setNavigateLastPage(int navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }
}
