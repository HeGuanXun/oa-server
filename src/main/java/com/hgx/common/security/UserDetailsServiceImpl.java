//package com.hgx.invoicing.security;
//
//import com.hgx.invoicing.dao.SetUserDao;
//import com.hgx.invoicing.model.BmsUser;
//import com.hgx.invoicing.model.Role;
//import com.hgx.invoicing.model.SetUser;
//import com.hgx.invoicing.utils.Assist;
//import com.hgx.invoicing.utils.SpringUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * 用户登录认证信息查询
// *
// * @author 何冠勋
// * @since 2020/7/13
// */
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private SetUserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if (userDao == null) {
//            userDao = SpringUtil.getBean(SetUserDao.class);
//        }
//        SetUser setUser = new SetUser();
//        setUser.setUsername(username);
//        SetUser bmsUser = userDao.selectSetUserObjSingle(setUser);
//        if (bmsUser == null) {
//            return null;
//        }
//        String password = new BCryptPasswordEncoder().encode(bmsUser.getPassword());
//        bmsUser.setPassword(password);
//        // 根据用户ID，查询用户的角色
//        List<Role> roles = new ArrayList<>();
//        Role role = new Role();
//        Role role_ = new Role();
//        role.setId(1);
//        role.setName("ROLE_ADMIN");
//        role_.setId(2);
//        role_.setName("ROLE_USER");
//        roles.add(role);
//        roles.add(role_);
//        // 添加角色
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (int i = 0; i < roles.size(); i++) {
//            authorities.add(new SimpleGrantedAuthority(roles.get(i).getName()));
//        }
//        // 构建 Security 的 BmsUser 对象
//        return new User(bmsUser.getUsername(), bmsUser.getPassword(), authorities);
//    }
//}