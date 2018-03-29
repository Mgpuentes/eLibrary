package com.puentes.elibrary.config;

import com.puentes.elibrary.backend.service.impl.UserSecurityService;
import com.puentes.elibrary.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserSecurityService userSecurityService;

    private final Environment environment;

    /**
     * Public URLs
     */
    private static final String[] PUBLIC_MATCHERS = {

            "/webjars/**",
            "/css/**",
            "/js/**",
            "/user/**",
//            "/h2-console/**",
            "/images/**",
            "/about/**",
            "/contact/**",
            "/authors/**",
            "/signup/**",
            "/"

    };

    @Autowired
    public SecurityConfig(Environment environment, UserSecurityService userSecurityService) {
        this.environment = environment;
        this.userSecurityService = userSecurityService;
    }


    /**
     * Override this method to configure the {@link HttpSecurity}. Typically subclasses
     * should not invoke this method by calling super as it may override their
     * configuration. The default configuration is:
     * <p>
     * <pre>
     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     * </pre>
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception if an error occurs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*
         * If we are running with dev profile, disable csrf and frame options to enable h2
         * to work.
         */

        List<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
        if (activeProfiles.contains("dev")) {
            http.csrf().disable();
            http.headers().frameOptions().disable();
        }

        /* URLs to be authorized and some authenticated.*/
        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth

                .userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return SecurityUtils.passwordEncoder();
    }
}
