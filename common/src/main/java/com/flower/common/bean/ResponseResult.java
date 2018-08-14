package com.flower.common.bean;

import java.io.Serializable;

/**
 * @author cyk
 * @date 2018/8/14/014 14:11
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ResponseResult implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer statusCode;
    private String statusString;
    private Object data;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static ResponseResult ok(){
        ResponseResult result = new ResponseResult();
        result.setStatusCode(1);
        result.setStatusString("成功");
        return result;
    }
    
}
