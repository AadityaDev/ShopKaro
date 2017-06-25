package com.aditya.webapp.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AppError implements Serializable{

    private final String errorMessage;
    private final int errorCode;

    public AppError(@NotNull String errorMessage,@NotNull int errorCode){
        this.errorMessage=errorMessage;
        this.errorCode=errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
