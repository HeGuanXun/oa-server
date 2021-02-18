//package com.hgx.invoicing.utils;
//
//import com.hgx.invoicing.dao.SetUserDao;
//import com.hgx.invoicing.model.SetUser;
//import com.hgx.invoicing.security.JwtAuthenticationToken;
//import com.hgx.invoicing.security.JwtTokenUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Security相关操作
// * @author 何冠勋
// * @date 2020-07-16
// */
//public class SecurityUtils {
//
//	@Autowired
//	private static SetUserDao userService;
//
//	public static Map<String,Object> MAPS = new HashMap<>(10);
//
//	//获取等钱登录用户
//	public static SetUser getCurrentUser() {
//		SetUser currentUser;
//		if (MAPS.get(CommonConstant.CURRENT_USER)==null) {
//			 currentUser = userService.selectSetUser(null).get(0);
//		}else {
//			currentUser = (SetUser) MAPS.get(CommonConstant.CURRENT_USER);
//		}
//		return currentUser;
//	}
//
//
//	/**
//	 * 系统登录认证
//	 * @param request
//	 * @param username
//	 * @param password
//	 * @param authenticationManager
//	 * @return
//	 */
//	public static JwtAuthenticationToken login(HttpServletRequest request, String username, String password, AuthenticationManager authenticationManager) {
//		JwtAuthenticationToken token = new JwtAuthenticationToken(username, password);
//		token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//		// 执行登录认证过程
//	    Authentication authentication = authenticationManager.authenticate(token);
//	    // 认证成功存储认证信息到上下文
//	    SecurityContextHolder.getContext().setAuthentication(authentication);
//		// 生成令牌并返回给客户端
//	    token.setToken(JwtTokenUtils.generateToken(authentication));
//	    return token;
//	}
//
//	/**
//	 * 获取令牌进行认证
//	 * @param request
//	 */
//	public static void checkAuthentication(HttpServletRequest request) {
//		// 获取令牌并根据令牌获取登录认证信息
//		Authentication authentication = JwtTokenUtils.getAuthenticationFromToken(request);
//		// 设置登录认证信息到上下文
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//	}
//
//	/**
//	 * 获取当前用户名
//	 * @return
//	 */
//	public static String getUsername() {
//		String username = null;
//		Authentication authentication = getAuthentication();
//		if(authentication != null) {
//			Object principal = authentication.getPrincipal();
////			if (principal != null){
////				username = (String) principal;
////			}
//			if(principal != null && principal instanceof UserDetails) {
//				username = ((UserDetails) principal).getUsername();
//			}
////			if(principal != null && principal instanceof UserDetails) {
////				username = ((UserDetails) principal).getUsername();
////			}
//		}
//		return username;
//	}
//
//	/**
//	 * 获取用户名
//	 * @return
//	 */
//	public static String getUsername(Authentication authentication) {
//		String username = null;
//		if(authentication != null) {
//			Object principal = authentication.getPrincipal();
//			if(principal != null && principal instanceof UserDetails) {
//				username = ((UserDetails) principal).getUsername();
//			}
//		}
//		return username;
//	}
//
//	/**
//	 * 获取当前登录信息
//	 * @return
//	 */
//	public static Authentication getAuthentication() {
//		if(SecurityContextHolder.getContext() == null) {
//			return null;
//		}
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		return authentication;
//	}
//
//}
