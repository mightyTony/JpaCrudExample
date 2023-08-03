package com.example.dtodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer(){
//        return web -> {
//            web.ignoring()
//                    .antMatchers(
//                      "/swagger-ui/**",
//                      "/login"
//                    );
//        };
//    }

    // 필터
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()// csrf 쿠기 사용 안함
                .authorizeRequests() // 요청에 의한 보안 검사 시작
                .antMatchers("/swagger-ui/**").permitAll() // 해당 url 인증 필요 없이 접근 가능
                .antMatchers("/login").permitAll()
                .antMatchers("/signUp").permitAll()
                .anyRequest().authenticated() // 위 페이지 외엔 인증이 되어야 접근 가능(ROLE 상관없이)
                .and()
                .formLogin().loginPage("/login") // 접근이 차단된 페이지 클릭시 이동할 URL
                .loginProcessingUrl("/home"); // 로그인 시 매핑되는 URL
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(false); // 쿠키를 받을 것인가
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8888")); // 해당 경로는 CORS 허용
        configuration.setAllowedMethods(Arrays.asList("*")); // 와일드 카드 써서 모든 메서드 다 허용

        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


