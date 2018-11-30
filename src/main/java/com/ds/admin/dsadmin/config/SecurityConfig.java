package com.ds.admin.dsadmin.config;

import com.ds.admin.dsadmin.security.LoginFailureHandler;
import com.ds.admin.dsadmin.security.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.inject.Inject;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Inject
    private LoginSuccessHandler loginSuccessHandler;
    @Inject
    private LoginFailureHandler loginFailureHandler;


//    @Bean
//    public AdminAuthenticationFilter adminAuthenticationFilter() throws Exception {
//        AdminAuthenticationFilter authFilter = new AdminAuthenticationFilter();
//        authFilter.setAuthenticationManager(authenticationManagerBean());
//        // handler들은 앞선 filter에서 연결시켜 줘야 함.
//        authFilter.setAuthenticationFailureHandler(loginFailureHandler);
//        authFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
//        return authFilter;
//    }
//
//    @Bean
//    public PreAdminAuthenticationFilter defaultAdminAuthenticationFilter() throws Exception {
//        PreAdminAuthenticationFilter authFilter = new PreAdminAuthenticationFilter();
//        authFilter.setAuthenticationManager(authenticationManagerBean());
//        return authFilter;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/static/**", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/faillogin")
                .defaultSuccessUrl("/")
                .permitAll()

        ;

//        http
//                .authorizeRequests()
//                .antMatchers(
//                        "/assets/**"
//                ).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                .logout()
//                .logoutSuccessHandler(logoutSuccessHandler)
//                .logoutSuccessUrl(loginPage)
//                .and()
//                .csrf().disable();
        super.configure(http);
    }
}
