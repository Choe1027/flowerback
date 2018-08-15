package com.flower.api.ctrl;

import com.flower.core.bean.UserBean;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyk
 * @date 2018/8/15/015 17:47
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = {RequestMethod.POST})
    public Object login(@RequestBody UserBean userBean){


        return null;
    }
}
