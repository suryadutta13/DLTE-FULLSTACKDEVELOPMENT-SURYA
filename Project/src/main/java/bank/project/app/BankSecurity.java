package bank.project.app;

import bank.project.dao.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BankSecurity {

    @Autowired
    BankService bankService;

    AuthenticationManager authenticationManager;

    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests((requests)->{
            requests.antMatchers("/resources/images/**").permitAll(); //images in resources are given all permission
            requests.antMatchers("/web/login").permitAll(); //granting all permissions for login pages
            requests.antMatchers("/web/dashboard").authenticated();
//           requests.anyRequest().permitAll();
        });
        //
        httpSecurity.formLogin().loginPage("/web/login").usernameParameter("username").failureHandler(loginFailureHandler).successHandler(loginSuccessHandler).permitAll();
        httpSecurity.logout().permitAll();
        httpSecurity.csrf().disable();
//        httpSecurity.authorizeRequests().anyRequest().permitAll();

        AuthenticationManagerBuilder builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(bankService);
        authenticationManager = builder.build();
        httpSecurity.authenticationManager(authenticationManager);

        return httpSecurity.build();
    }
}

