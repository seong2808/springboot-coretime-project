package com.seong.coretime.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            // 인증 정보가 없거나 익명 사용자일 경우 (예: 회원가입 시)
            if (authentication == null || !authentication.isAuthenticated() ||
                    authentication.getPrincipal().equals("anonymousUser")) {
                return Optional.of("SYSTEM");
            }

            // 로그인한 유저의 ID(이메일 등)를 반환
            return Optional.of(authentication.getName());
        };
    }
}
