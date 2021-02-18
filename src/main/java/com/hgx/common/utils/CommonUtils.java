package com.hgx.common.utils;

//import com.hgx.invoicing.security.JwtTokenUtils;
import com.hgx.common.entity.User;
import com.hgx.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils {
    private final static Logger LOG = LoggerFactory.getLogger(CommonUtils.class);
    @Autowired
    private UserService setUserService;

    public User currentUser;

    private static volatile CommonUtils commonUtils;

    public User getCurrentUser(String userName) {
        if (currentUser==null){
            User setUser = new User(userName);
            if (setUserService==null){
                setUserService = SpringUtil.getBean(UserService.class);
            }
//            currentUser = setUserService.find(setUser);
        }
        return currentUser;
    }

    public User getCurrentUser(HttpServletRequest request) {
//        String token = JwtTokenUtils.getToken(request);
//        String username = JwtTokenUtils.getUsernameFromToken(token);
        return this.getCurrentUser("");
    }

    public static CommonUtils newInstance(){
        if (commonUtils==null){
            synchronized(CommonUtils.class){
                if (commonUtils==null){
                    commonUtils = new CommonUtils();
                }
            }
        }
        return commonUtils;
    }

}
