package com.flower.api.handler;

import com.flower.common.bean.ResponseResult;
import com.flower.common.exception.BizException;
import com.flower.common.exception.SysException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cyk
 * @date 2018/8/15/015 09:34
 * @email choe0227@163.com
 * @desc  全局异常处理
 * @modifier
 * @modify_time
 * @modify_remark
 */

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BizException.class)
    @ResponseBody
    ResponseResult handleBizException(BizException biz){

        ResponseResult result = new ResponseResult();
        result.setStatusCode(biz.getErrorCode().getCode());
        result.setStatusString(biz.getErrorCode().getReturnMsg());
        biz.printStackTrace();
        return result;
    }

    @ExceptionHandler(SysException.class)
    @ResponseBody
    ResponseResult handleSysException(SysException sysException){
        ResponseResult result = new ResponseResult();
        result.setStatusCode(-1);
        result.setStatusString(sysException.getMessage());
        sysException.printStackTrace();
        return result;
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseResult handleException(Exception exception){
        exception.printStackTrace();
        return ResponseResult.error();
    }
}
