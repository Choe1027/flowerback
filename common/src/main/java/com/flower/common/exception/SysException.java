package com.flower.common.exception;

/**
 * @author cyk
 * @date 2018/8/14/014 14:34
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class SysException extends BaseException {

    private static final long serialVersionUID = 6812202525292547656L;

    public SysException() {
        super();
    }

    public SysException(String remark) {
        super(Error.system_error, remark);
    }

    public SysException(Exception e) {
        super(Error.system_error, e);
    }

    public SysException(String remark, Exception e) {
        super(Error.system_error, e, remark);
    }

    public SysException(Error errorCode, String... remark) {
        super(errorCode, remark);
    }

    public SysException(Error errorCode, Throwable e, String... remark) {
        super(errorCode, e, remark);
    }
}
