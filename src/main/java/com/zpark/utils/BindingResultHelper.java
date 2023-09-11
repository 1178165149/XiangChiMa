package com.zpark.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据校验工具类
 */
public class BindingResultHelper {

    public static Map<String, String> toErrorMap(BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<FieldError> errorList = bindingResult.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError fieldError : errorList) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return map;
        }
        return Collections.emptyMap();
    }
}