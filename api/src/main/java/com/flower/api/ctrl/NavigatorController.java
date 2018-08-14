package com.flower.api.ctrl;

import com.flower.common.bean.ResponseResult;
import com.flower.core.bean.NavigationBean;
import com.flower.core.service.NavigationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cyk
 * @date 2018/8/14/014 18:17
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@RestController
@RequestMapping("/navigation")
public class NavigatorController {

    @Autowired
    private NavigationService navigationService;

    @RequestMapping(method = {RequestMethod.GET})
    public Object getList(){

        List<NavigationBean> navigationBeans = navigationService.getListSortByOrderNo();
        ResponseResult result = new ResponseResult();
//        result.setStatusCode();

        return navigationBeans;
    }
}
