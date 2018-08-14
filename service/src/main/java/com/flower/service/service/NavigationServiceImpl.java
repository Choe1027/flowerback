package com.flower.service.service;


import com.flower.common.utils.BeanSort;
import com.flower.core.bean.NavigationBean;
import com.flower.core.dao.mapper.BaseMapper;
import com.flower.core.service.BaseServiceImpl;
import com.flower.core.service.NavigationService;
import com.flower.service.dao.NavigationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class NavigationServiceImpl extends BaseServiceImpl<NavigationBean> implements NavigationService {

    @Autowired
    private NavigationMapper navigationMapper;

    @Override
    protected BaseMapper<NavigationBean> getMainMapper() {
        return navigationMapper;
    }

    @Override
    public List<NavigationBean> getListSortByOrderNo() {
        NavigationBean navigationBean = new NavigationBean();
        navigationBean.setState(0);
        List<NavigationBean> select = select(navigationBean);
        BeanSort<NavigationBean> beanSort = new BeanSort<>("orderNo");
        beanSort.sortList(select);
        return select;
    }
}
