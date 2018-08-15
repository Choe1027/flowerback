package com.flower.core.bean;


import com.flower.common.annotation.Table;
import com.flower.common.bean.BaseBean;

/**
 * @author cyk
 * @date 2018/7/30/030 11:36
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Table(name = "navigation")
public class NavigationBean extends BaseBean {


    private static final long serialVersionUID = 1L;

    /**图片链接*/
    private String url;
    /**描述*/
    private String remark;
    /** 启用状态 0启用 1禁用*/
    private Integer state;
    /** 排序号*/
    private Integer orderNo;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
