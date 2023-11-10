package ua.com.dionysus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.http.HttpServletResponse;


@Configuration
public class ApplicationSecurity {

    @Autowired private JwtTokenFilter jwtTokenFilter;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/auth/login",  "/auth/register","/articles/{id}/pdp", "/articles/plp", "/products/**").permitAll()
                .antMatchers(HttpMethod.PUT ,"/articles/**",
                "product/liqueur/**", "/product-images/**", "products/{id}/process/**", "product/rum/**",
                "product/tequila/**", "product/whiskey/**", "product/wine/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/articles/**",
                        "product/liqueur/**", "/product-images/**", "products/{id}/process/**", "product/rum/**",
                        "product/tequila/**", "product/whiskey/**", "product/wine/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/articles/**",
                                "product/**", "/product-images/**", "products/{id}/process/**", "product/rum/**",
                                "product/tequila/**", "product/whiskey/**", "product/wine/**", "product/wine").hasAuthority("ADMIN")
                .anyRequest().authenticated();



        http.exceptionHandling()
                .authenticationEntryPoint(

                        (request, response, ex) -> {
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                        }
                );

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}