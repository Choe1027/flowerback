package com.flower.service.service;

import com.flower.core.bean.UserBean;

import java.util.Map;

/**
 * @author cyk
 * @date 2018/8/15/015 17:55
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface UserService {

    /**
     * 微信登录凭证校验
     * @param code
     * @return
     */
    Map<String, Object> wechatAuthorize(String code);

    /**
     * 根据OpenId获取
     * @param openId
     * @return
     */
    UserBean getUserByOpenId(String openId);
}
