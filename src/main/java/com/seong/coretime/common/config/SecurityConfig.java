package com.seong.coretime.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 1. REST API이므로 CSRF 보안 해제
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/join").permitAll() // 2. 회원가입 경로는 누구나 허용
                        .anyRequest().authenticated() // 3. 그 외 나머지는 인증 필요
                );

        return http.build();
    }
}
