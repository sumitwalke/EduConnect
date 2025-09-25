package com.wecp.progressive.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.wecp.progressive.jwt.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                
                        //Authentication 
                        .antMatchers("/auth/**").permitAll()
                        
                        // Attendance 
                        .antMatchers(HttpMethod.GET,"/attendance/**").hasAnyAuthority("TEACHER", "STUDENT")
                        .antMatchers(HttpMethod.POST,"/attendance/**").hasAuthority("TEACHER")
                        .antMatchers(HttpMethod.PUT,"/attendance/**").hasAuthority("TEACHER")
                        .antMatchers(HttpMethod.DELETE,"/attendance/**").hasAuthority("TEACHER")

                        // Course
                        .antMatchers(HttpMethod.GET,"/course/**").hasAnyAuthority("TEACHER", "STUDENT")
                        .antMatchers(HttpMethod.POST,"/course/**").hasAuthority("TEACHER")
                        .antMatchers(HttpMethod.PUT,"/course/**").hasAuthority("TEACHER")
                        .antMatchers(HttpMethod.DELETE,"/course/**").hasAuthority("TEACHER")

                        // Enrollment
                        .antMatchers(HttpMethod.GET,"/enrollment/**").hasAnyAuthority("TEACHER", "STUDENT")
                        .antMatchers(HttpMethod.POST, "/enrollment/**").hasAuthority("STUDENT")
                        .antMatchers(HttpMethod.PUT, "/enrollment/**").hasAuthority("STUDENT")
                        .antMatchers(HttpMethod.DELETE, "/enrollment/**").hasAuthority("STUDENT")

                        // Student
                        .antMatchers(HttpMethod.GET,"/student/**").hasAuthority("STUDENT")
                        .antMatchers(HttpMethod.POST,"/student/**").hasAuthority("STUDENT")
                        .antMatchers(HttpMethod.PUT,"/student/**").hasAuthority("STUDENT")
                        .antMatchers(HttpMethod.DELETE,"/student/**").hasAuthority("STUDENT")

                        // Teacher
                        .antMatchers(HttpMethod.GET,"/teacher/**").hasAuthority("TEACHER")
                        .antMatchers(HttpMethod.POST,"/teacher/**").hasAuthority("TEACHER")
                        .antMatchers(HttpMethod.PUT,"/teacher/**").hasAuthority("TEACHER")
                        .antMatchers(HttpMethod.DELETE,"/teacher/**").hasAuthority("TEACHER")
                        .anyRequest().authenticated()
                    );

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}