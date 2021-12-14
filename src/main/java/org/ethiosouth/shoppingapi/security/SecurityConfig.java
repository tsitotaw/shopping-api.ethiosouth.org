package org.ethiosouth.shoppingapi.security;

import org.ethiosouth.shoppingapi.filter.CustomAuthenticationFilter;
import org.ethiosouth.shoppingapi.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@Service
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@CrossOrigin(origins = {"http://localhost:3000"})
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

        http.cors().configurationSource(request -> {
            var cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("http://localhost:3000"));
            cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            return cors;
        }).and().csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.headers().frameOptions().disable();


        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/roles/**").permitAll();// .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/customers/**").permitAll();// .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/customers/**").permitAll();//.hasAnyAuthority("BUYER", "SELLER", "ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/orders/**").permitAll();//.hasAnyAuthority("BUYER", "ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/productreviews/**").permitAll();//.hasAnyAuthority("BUYER", "SELLER", "ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/products/**").permitAll();//.hasAnyAuthority("BUYER", "SELLER", "ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/products/**").permitAll();//.hasAnyAuthority("SELLER", "ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/productcategories/**").permitAll();//.hasAnyAuthority("SELLER", "ADMIN");
        http.authorizeRequests().anyRequest().authenticated();

        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        //http.addFilterBefore(corsFilter(), SessionManagementFilter.class); //adds your custom CorsFilter
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
