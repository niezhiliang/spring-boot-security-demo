package com.niezhiliang.security.demo.config;

import com.niezhiliang.security.demo.handler.MyAuthenticationAccessDeniedHandler;
import com.niezhiliang.security.demo.handler.MyAuthenticationFailureHandler;
import com.niezhiliang.security.demo.handler.MyAuthenticationSucessHandler;
import com.niezhiliang.security.demo.service.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import javax.sql.DataSource;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/18 14:24
 */
@Configuration
//打开注解控制权限
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSucessHandler myAuthenticationSucessHandler;

    @Autowired
    private MyAuthenticationAccessDeniedHandler myAuthenticationAccessDeniedHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                //处理权限不足
                .accessDeniedHandler(myAuthenticationAccessDeniedHandler)
                .and()
                .formLogin()
                //登录失效跳转地址
                .loginPage("/user/unlogin")
                //登录地址
                .loginProcessingUrl("/login")
                //登录成功处理
                .successHandler(myAuthenticationSucessHandler)
                //登录失败处理
                .failureHandler(myAuthenticationFailureHandler)
                //配置用户退出功能
                .and()
                .rememberMe()
                // 配置 token 持久化仓库
                .tokenRepository(persistentTokenRepository())
                // remember 过期时间，单为秒
                .tokenValiditySeconds(3600)
                // 处理自动登录逻辑
                .userDetailsService(userDetailService)
                .and()
                .logout()
                .logoutUrl("/signout")
                .logoutSuccessUrl("/user/signout")
                .deleteCookies("JSESSIONID")
                .and()
                .authorizeRequests()
                //白名单列表，无需登录
                .antMatchers("/login","/user/unlogin",
                        "/user/signout")
                .permitAll()
                //所有方法都要进行认证
                .anyRequest()
                .authenticated()
                .and().csrf().disable();
    }

    // spring security自带的密码加密工具类
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //允许多请求地址多加斜杠  比如 /msg/list   //msg/list
    @Bean
    public HttpFirewall httpFirewall() {
        return new DefaultHttpFirewall();
    }

    /**
     * 记住我设置持久化对象
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }



}
