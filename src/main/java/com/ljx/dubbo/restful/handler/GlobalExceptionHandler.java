package com.ljx.dubbo.restful.handler;

import com.ljx.dubbo.restful.exception.ApiException;
import com.ljx.dubbo.restful.exception.ResultCode;
import com.ljx.dubbo.restful.exception.ResultVO;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author jiaxiong
 * @date 2020/4/19 5:08 下午
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResultVO<String> apiExceptionHandler(ApiException e) {
        return new ResultVO<>(ResultCode.FAILED, e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO<String> constraintViolationExceptionHandler(ConstraintViolationException e) {
        List<ConstraintViolation<?>> errorList = new ArrayList<>(e.getConstraintViolations());
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, errorList.get(0).getMessage());
    }
}
