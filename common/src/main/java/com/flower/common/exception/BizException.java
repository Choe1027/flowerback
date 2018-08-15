package com.flower.common.exception;

/**
 * @author cyk
 * @date 2018/8/14/014 14:42
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 6812202525292547656L;
    public BizException() {
        super();
    }

    public BizException(Throwable throwable) {
        super(Error.biz_error, throwable);
    }

    public BizException(String... remark) {
        super(Error.biz_error, remark);
    }

    public BizException(Error errorCode, String... remark) {
        super(errorCode, remark);
    }

    public BizException(Error errorCode, Throwable throwable, String... remark) {
        super(errorCode, throwable, remark);
    }
}
