//package com.hgx.invoicing.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Collection;
//
///**
// * 安全用户模型
// * @author 何冠勋
// * @since 2020/7/13
// */
//public class JwtUserDetails extends User {
//
//	private static final long serialVersionUID = 1L;
//
//	public JwtUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		this(username, password, true, true, true, true, authorities);
//	}
//
//	public JwtUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
//                          boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//	}
//
//}