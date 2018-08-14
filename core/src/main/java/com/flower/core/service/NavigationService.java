package com.flower.core.service;


import com.flower.core.bean.NavigationBean;

import java.util.List;

/**
 * @author cyk
 * @date 2018/8/8/008 18:02
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface NavigationService extends BaseService<NavigationBean> {

    List<NavigationBean> getListSortByOrderNo();
}
