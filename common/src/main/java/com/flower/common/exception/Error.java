package com.flower.common.exception;

/**
 * @author cyk
 * @date 2018/8/14/014 14:43
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public enum Error {

    id_must_not_be_null(100,"id参数不能为空","缺少id")
    ;
    /**
     * 异常码
     */
    private Integer code;
    /**
     * 备注
     * 后台调试时查看
     */
    private String remark;
    /**
     * 返回给前端显示
     */
    private String returnMsg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    Error(Integer code, String remark, String returnMsg) {
        this.code = code;
        this.remark = remark;
        this.returnMsg = returnMsg;
    }
}
