package com.apress.prospringmvc.bookstore.web.config.sec;

import com.apress.prospringmvc.bookstore.domain.Account;
import com.apress.prospringmvc.bookstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class BookstoreAuthenticationProvider implements AuthenticationProvider {

  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Autowired
	private AccountService authenticationService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		Account account = authenticationService.getAccount(username);
		if(account == null) {
			throw new BadCredentialsException("Authentication failed <username> for " + username);
		}
		if(!passwordEncoder.matches(password, account.getPassword())) {
			throw new BadCredentialsException("Authentication failed <password> for " + username);
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		account.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole())));
		return new
				UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
