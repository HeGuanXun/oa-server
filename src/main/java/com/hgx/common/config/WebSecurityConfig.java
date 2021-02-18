//package com.hgx.invoicing.config;
//
//import com.hgx.invoicing.security.JwtAuthenticationFilter;
//import com.hgx.invoicing.security.JwtAuthenticationProvider;
//import com.hgx.invoicing.security.JwtLoginFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
//		http.cors().and()
//				.authorizeRequests()
//				.antMatchers("/login").permitAll()
//				.anyRequest().authenticated()
//				.and().formLogin().loginPage("/login").permitAll()
//				.and().logout().permitAll();
//		http.csrf().disable();
//		http.headers().frameOptions().sameOrigin();
//		// 退出登录处理器
//		http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
//		// 开启登录认证流程过滤器
//		http.addFilterBefore(new JwtLoginFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
//		// 访问控制时登录状态检查过滤器
//		http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
//	}
//
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
//		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// 使用自定义登录身份认证组件
//		auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
//	}
//
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
//}