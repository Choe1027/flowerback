package com.flower.common.exception;

import com.flower.common.utils.LoggerUtil;
import com.flower.common.utils.StringUtil;

/**
 * @author cyk
 * @date 2018/8/14/014 14:42
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 6812202525292547656L;

    private Error error;


    public BizException(Error error) {
        this.error = error;
    }


    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    @Override
    public String getMessage() {
        if (error != null){
            return StringUtil.isEmpty(error.getRemark())?super.getMessage():error.getRemark();
        }
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {

        if (error != null){
            LoggerUtil.error(this.getClass(),error.getRemark());
        }
        super.printStackTrace();
    }
}
