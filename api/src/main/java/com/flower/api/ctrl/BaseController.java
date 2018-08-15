package com.flower.api.ctrl;

/**
 * @author cyk
 * @date 2018/8/15/015 12:09
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface BaseController<T> {

    Object add(T t);

    void deleteById(Long[] ids);


}
