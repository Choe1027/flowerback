package com.flower.service.service;


import com.flower.common.exception.BizException;
import com.flower.common.exception.Error;
import com.flower.common.utils.JsonUtil;
import com.flower.common.utils.StringUtil;
import com.flower.common.utils.UrlConnectUtil;
import com.flower.core.bean.UserBean;
import com.flower.core.constant.Context;
import com.flower.core.dao.mapper.BaseMapper;
import com.flower.core.service.BaseServiceImpl;
import com.flower.core.utils.RequestPool;
import com.flower.service.dao.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyk
 * @date 2018/8/8/008 13:54
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserBean> implements UserService {

    @Value("${wechat.url}")
    private String url;
    @Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.appscret}")
    private String appScret;

    @Autowired
    private UserMapper userMapper;
    @Override
    protected BaseMapper<UserBean> getMainMapper() {
        return userMapper;
    }

    @Override
    public Map<String, Object> wechatAuthorize(String code) {
        if (StringUtil.isEmpty(code)){
            throw new BizException(Error.biz_lost_param,"校验微信身份，缺少code参数");
        }
        Map<String,String> map = new HashMap<>();
        map.put("js_code",code);
        map.put("grant_type","authorization_code");
        map.put("appid",appid);
        map.put("secret",appScret);
        String result = UrlConnectUtil.doUrl(url, "POST", null, map);
        //{"session_key":"BYbgapiICdsFTemc5z6EvA==","openid":"o75cJ48rf-z8TLE2N7EoLBcf44aU"}
        Map<String, Object> resultMap = JsonUtil.jsonToMap(result);
        // 保存微信session_key
        RequestPool.getSession().setAttribute(Context.session_wechat_session_key,map.get("session_key"));
        resultMap.remove("session_key");
        UserBean user = getUserByOpenId((String) resultMap.get("openid"));
        resultMap.put("isNeedLogin","0");
        if (user != null){
            resultMap.put("isNeedLogin","1");
            resultMap.put("user",user);
        }
        return resultMap;
    }

    @Override
    public UserBean getUserByOpenId(String openId) {
        if (StringUtil.isEmpty(openId)){
            throw  new BizException(Error.biz_lost_param,"缺少openid参数");
        }
        UserBean userBean = new UserBean();
        userBean.setOpenid(openId);
        userBean = get(userBean);
        return userBean;
    }
}
