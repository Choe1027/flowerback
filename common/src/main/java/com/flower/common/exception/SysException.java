package com.flower.common.exception;

import com.flower.common.utils.LoggerUtil;
import com.flower.common.utils.StringUtil;

/**
 * @author cyk
 * @date 2018/8/14/014 14:34
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class SysException extends RuntimeException {

    private static final long serialVersionUID = 6812202525292547656L;

    private String remark;

    public SysException(){
        super();
    }

    public SysException(String remark) {
        this.remark = remark;
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
    }

    public SysException(Throwable cause) {
        super(cause);
    }

    public SysException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    @Override
    public String getMessage() {
        return StringUtil.isEmpty(remark)?super.getMessage():remark;
    }

    @Override
    public void printStackTrace() {
        LoggerUtil.error(this.getClass(),remark);
    }
}
