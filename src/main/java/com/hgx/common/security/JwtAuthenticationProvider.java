//package com.hgx.invoicing.security;
//
//import com.hgx.invoicing.exception.BizException;
//import com.hgx.invoicing.utils.SpringUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * 身份验证提供者
// * @author 何冠勋
// * @since 2020/7/13
// */
//public class JwtAuthenticationProvider extends DaoAuthenticationProvider {
//
//    @Autowired
//    private UserDetailsServiceImpl  userDetailService;
//
//    public JwtAuthenticationProvider(UserDetailsService userDetailsService) {
//        setUserDetailsService(userDetailsService);
//        setPasswordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        // 获取用户输入的用户名和密码
//        String username = authentication.getName();
//        if (authentication.getCredentials()==null){
//            // 验证失败返回 null
//            return null;
//        }
//        String password = authentication.getCredentials().toString();
//
//        if (userDetailService==null){
//            userDetailService = SpringUtil.getBean(UserDetailsServiceImpl.class);
//        }
//        // 获取封装用户信息的对象
//        UserDetails userDetails = userDetailService.loadUserByUsername(username);
//        if (userDetails!=null){
//            // 进行密码的比对
//            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//            boolean flag = bCryptPasswordEncoder.matches(password, userDetails.getPassword());
//            // 校验通过
//            if (flag){
//                // 将权限信息也封装进去
//                return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
//            }
//        }
//        throw new BizException("用户名或者密码错误");
//    }
//
//    /**
//     * 这个方法 确保返回 true 即可，
//     *
//     * @param aClass
//     * @return
//     */
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;
//    }
//
//}