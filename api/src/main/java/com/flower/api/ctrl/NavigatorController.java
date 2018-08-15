package com.flower.api.ctrl;

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
//        ResponseResult result = null;
//        result.getData();
//        try {
//            File file = new File("/aaa/a.txt");
//            FileInputStream fis = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            throw new SysException(Error.system_error,e);
//        }
        return navigationBeans;
    }
}
