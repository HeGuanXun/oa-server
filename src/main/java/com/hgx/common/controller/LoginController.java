package com.hgx.common.controller;

import com.hgx.common.service.UserService;
import com.hgx.common.utils.HttpJsonResult;
import com.hgx.common.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

/**
 * 登录控制器
 * @author 何冠勋
 * @since 2020/7/13
 */
@Api(value = "登录",tags = "登录检验")
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录接口
     */
    @ApiOperation("获取全部信息")
    @PostMapping(value = "/login")
    public HttpJsonResult<String> login(User loginBean){
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        User currentUser;
        // 系统登录认证
        List<User> list = userService.getList(new User(username));
        if (CollectionUtils.isNotEmpty(list)){
            currentUser = list.get(0);
            if (currentUser.getPassword().equals(password)){
                return HttpJsonResult.ok("登录成功！");
            }
        }else {
            return HttpJsonResult.errorMsg("用户名或者密码错误！");
        }
        //获取当前登录的用户
        return HttpJsonResult.errorMsg("登录失败！");
    }
}