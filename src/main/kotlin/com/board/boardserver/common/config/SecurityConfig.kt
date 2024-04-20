package com.board.boardserver.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter
import org.springframework.security.web.SecurityFilterChain

/**
 * @author jinwook.kim
 * @since 4/1/24
 */
@Configuration
@EnableWebSecurity
class SecurityConfig {
    private val allowedUrls = arrayOf("/guest/**", "/user/exists")

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .headers { it.frameOptions().sameOrigin() }
            .authorizeHttpRequests {
                it.requestMatchers(*allowedUrls).permitAll()
                it.requestMatchers(HttpMethod.POST, "/user").permitAll()
                it.requestMatchers("/admin/**").hasRole("ADMIN")
                  .anyRequest().hasRole("USER")
            }
            .oauth2ResourceServer {
                it.jwt { jwtAuthenticationConverter() }
            }
        return http.build()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    // JwtAuthenticationConverter 설정
    @Bean
    fun jwtAuthenticationConverter(): JwtAuthenticationConverter {
        val converter = JwtAuthenticationConverter()
        converter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter())
        return converter
    }

    // JwtGrantedAuthoritiesConverter 설정
    @Bean
    fun jwtGrantedAuthoritiesConverter(): JwtGrantedAuthoritiesConverter {
        val converter = JwtGrantedAuthoritiesConverter()
        // 권한 정보가 포함된 claim의 이름 설정(인증서버에서 roles값으로 반환하고 있음)
        converter.setAuthoritiesClaimName("roles")
        // role prefix 제거
        converter.setAuthorityPrefix("")
        return converter
    }
}