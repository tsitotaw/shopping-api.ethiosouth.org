package org.ethiosouth.shoppingapi.security;

import lombok.RequiredArgsConstructor;
import org.ethiosouth.shoppingapi.filter.CustomAuthenticationFilter;
import org.ethiosouth.shoppingapi.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers("/h2-console").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/customers/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/orders/**").hasAnyAuthority("BUYER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/productreviews/**").hasAnyAuthority("BUYER");
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/products/**").hasAnyAuthority("SELLER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/productcategories/**").hasAnyAuthority("SELLER");
        http.authorizeRequests().anyRequest().authenticated();

        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
