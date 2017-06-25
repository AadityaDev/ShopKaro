package com.aditya.webapp.dto;

import java.util.List;

public class AppResult implements IResult{

    private List<AppError> errors;
    private Object result;
    private boolean hasMore;
    private long totalRecordCount;

    @Override
    public List<AppError> getErrors() {
        return errors;
    }

    public void setErrors(List<AppError> errors) {
        this.errors = errors;
    }

    @Override
    public Object getResult() {
        return result;
    }

    @Override
    public long getTotalResultCount() {
        return totalRecordCount;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public long getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(long totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }
}
