package com.apress.prospringmvc.bookstore.web.config.sec;

import com.apress.prospringmvc.bookstore.web.config.sec.BookstoreAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/images/**", "/styles/**","/webjars/**");
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(bookstoreAuthenticationProvider());
	}

	@Bean
	public AuthenticationProvider bookstoreAuthenticationProvider() {
		return new BookstoreAuthenticationProvider();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests(
						authorize -> authorize.mvcMatchers("/*/edit/*", "/*/delete/*")
								.hasRole("ADMIN")
								.anyRequest().permitAll()
				).formLogin(
				formLogin -> formLogin.loginPage("/login")
						.failureUrl("/login?auth_error=1")
		).logout(Customizer.withDefaults())
				.csrf().csrfTokenRepository(repo());
	}

	@Bean
	public CsrfTokenRepository repo() {
		HttpSessionCsrfTokenRepository repo = new HttpSessionCsrfTokenRepository();
		repo.setParameterName("_csrf");
		repo.setHeaderName("X-CSRF-TOKEN"); // default header name
		return repo;
	}
}