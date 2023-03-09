package com.javapoint.habits.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final DataSource dataSource;
    private PasswordEncoder passwordEncoder;


    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
        ;
    }

    @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
                    )
                    .formLogin((form) -> form
                        .loginPage("/login")
                        .successForwardUrl("/client")
                        .permitAll()
                    )
                    .logout((logout) -> logout.permitAll());
            return http.build();
    }

            /*@Bean
            public UserDetailsService userDetailsService() {
                UserDetails user =
                        User.withDefaultPasswordEncoder()
                                .username("user1")
                                .password("password")
                                .roles("USER")
                                .build();

                return new InMemoryUserDetailsManager(user);
            }*/

    /* @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/").permitAll()
                .anyRequest().hasRole("USER")
        )
        .formLogin((form) -> form
                .loginPage("/login")
                .permitAll()
        ).logout((logout) -> logout.permitAll());
    }*/

}
