//package com.example.fotomoto.Config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//import static org.springframework.http.HttpMethod.OPTIONS;
//import static org.springframework.security.config.Customizer.withDefaults;
//import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
//import static org.springframework.security.web.util.matcher.RegexRequestMatcher.regexMatcher;
//
//@CrossOrigin
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    private final JwtAuthenticationFilter jwtAuthFilter;
//    private final AuthenticationProvider authenticationProvider;
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain
//            (HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
//        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
//        httpSecurity.csrf(AbstractHttpConfigurer::disable);
//        httpSecurity.authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(mvcMatcherBuilder.pattern("/auth/authenticate/**")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern("/**")).authenticated()
////                        .requestMatchers(mvcMatcherBuilder.pattern("/auth/folders/add-folder/**")).hasRole("ADMIN")
////                        .requestMatchers(mvcMatcherBuilder.pattern("/auth/folders/get-all-folders/**")).hasRole("USER")
////                        .requestMatchers(mvcMatcherBuilder.pattern("/auth/folders/add-folder").has
////                        .requestMatchers(mvcMatcherBuilder.pattern("/v3/api-docs")).permitAll()
////                        .requestMatchers(mvcMatcherBuilder.pattern("/configuration/**")).permitAll()
////                        .requestMatchers(mvcMatcherBuilder.pattern("/swagger-ui/**")).permitAll()
////                        .requestMatchers(mvcMatcherBuilder.pattern("/webjars/**")).permitAll()
////                        .requestMatchers(mvcMatcherBuilder.pattern("/**")).permitAll()
//                        .anyRequest().authenticated())
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//        return httpSecurity.build();
//    }
//
//
//
//
//
//}


//
package com.example.fotomoto.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@CrossOrigin
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain
            (HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.authorizeHttpRequests((requests) -> requests
                        .requestMatchers(mvcMatcherBuilder.pattern("/**")).permitAll()
                        .anyRequest().authenticated())
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
