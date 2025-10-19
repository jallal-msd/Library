package com.Library.Library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * librarySecurity
 */

@Configuration
@EnableWebSecurity
public class librarySecurity {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(
        (requests) -> requests.requestMatchers("/*/*", "/*/*/*", "/api/*", "api/all").permitAll()
            .requestMatchers(HttpMethod.DELETE).permitAll()
            .requestMatchers(HttpMethod.POST).permitAll()
            .requestMatchers(HttpMethod.PUT).permitAll()
            .requestMatchers(HttpMethod.GET).permitAll());

    http.csrf().disable();
    return http.build();

  }

  // @Bean
  // public UserDetailsService userDetailsServce(){
  // UserDetails user = User.withUsername("username")
  // .password(PasswordEncoder.encode("password")
  // .roles("USER")
  // .build();
  // }

}
