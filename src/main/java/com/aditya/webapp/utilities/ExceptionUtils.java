package com.aditya.webapp.utilities;

import javax.validation.constraints.NotNull;

import com.aditya.webapp.dto.AppError;
import com.aditya.webapp.dto.AppResult;

import java.util.ArrayList;
import java.util.List;

public class ExceptionUtils {


    public static void setException(@NotNull Exception exception,@NotNull AppError datuxError, @NotNull AppResult datuxResult) {
        if ((exception != null) && (!StringUtils.isNull(exception.getMessage()))) {
            datuxError = new AppError(exception.getMessage(), datuxError.getErrorCode());
        } else {
            datuxError = new AppError(datuxError.getErrorMessage(), datuxError.getErrorCode());
        }
        List<AppError> errors = new ArrayList<>();
        errors.add(datuxError);
        datuxResult.setErrors(errors);
    }


}
