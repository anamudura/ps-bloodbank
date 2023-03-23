package com.example.ps1.security.config;


import com.example.ps1.security.CustomAuthenticationSuccessHandler;
import com.example.ps1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig  {
    @Autowired
    private final UserService userService;
    @Autowired
    CustomAuthenticationSuccessHandler successHandler;



    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/doctor").hasAnyRole("ROLE_DOCTOR")
//                .antMatchers("/admin").hasAnyRole("ROLE_ADMIN")
//                .antMatchers("/donator").hasAnyRole("ROLE_DONATOR")
//                .and().formLogin().loginPage("/login")
//                .successHandler(successHandler)
//                .permitAll()
//                .and().logout();
        http
                .formLogin(formLogin -> formLogin
                        .successHandler(new CustomAuthenticationSuccessHandler()).loginPage("/login")
                );
        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return auth;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }



}
