package com.flower.core.constant;

/**
 * @author cyk
 * @date 2018/7/30/030 11:55
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface Context {
    String field_create_time ="create_time";

    /**
     * 缓存中lock锁key的前缀
     */
    String CACHE_LOCK_KEY = "hj_cache_lock_";

    /**
     * 分布式锁的默认超时时间(毫秒)
     */
    Long CACHE_LOCK_TIMEOUT = 3000L;


    /**
     * 缓存当天最后的订单编号，自增
     */
    String CACHE_LATEST_ORDERNO ="order_num_incr";

    /**
     * 用户登录时所使用的极光环境
     */
    String CACHE_PUSH_LOGIN_ENV = "push_env";

    /**
     * 下划线
     */
    String UNDER_LINE = "_";

    /**
     * 分布式锁的默认超时时间(毫秒)
     */
    Long cache_lock_timeout = 3000L;

    /**
     * session中存储token串的key
     */
    String session_token = "session_token";

    /**
     * session中存储userId的key
     */
    String session_userId = "session_userId";

    /**
     * session中存储userName 的key
     */
    String session_userName = "session_userName";

    /**
     * session中存储用户类型的key
     */
    String session_userType = "session_userType";

    /**
     * session中存储用户验证码的key
     */
    String session_img_code = "session_img_code";

    /**
     * session 中存储微信登录用户的session_key
     */
    String session_wechat_session_key = "session_wechat_session_key";
}
