package com.flower.api.ctrl;

import com.flower.core.bean.NavigationBean;
import com.flower.core.service.NavigationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
        return navigationBeans;
    }

    @RequestMapping(value = "/{id}",method = {RequestMethod.PUT})
    public Object update(@PathVariable("id") Long id, @RequestBody NavigationBean navigationBean){
//        navigationBean = null;
        navigationBean.setId(id);
        navigationService.update(navigationBean);

        return "更新成功";
    }
}
