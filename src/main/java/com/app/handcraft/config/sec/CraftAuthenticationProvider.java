package com.app.handcraft.config.sec;

import com.app.handcraft.entity.UserDetail;
import com.app.handcraft.service.UserInteractionService;
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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CraftAuthenticationProvider implements AuthenticationProvider {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserInteractionService userInteractionService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetail account = userInteractionService.getAccount(username);
        if (account == null) {
            throw new BadCredentialsException("Authentication failed <username> for " + username);
        }
        if (!passwordEncoder.matches(password, account.getPassword())) {
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
