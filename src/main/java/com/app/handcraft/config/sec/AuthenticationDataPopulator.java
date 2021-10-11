package com.app.handcraft.config.sec;

import com.app.handcraft.entity.UserDetail;
import com.app.handcraft.repository.UserDetailRepository;
import com.app.handcraft.repository.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AuthenticationDataPopulator {
	private Logger logger = LoggerFactory.getLogger(AuthenticationDataPopulator.class);

	private UserDetailRepository userDetailRepository;
	private UserRoleRepository userRoleRepository;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public AuthenticationDataPopulator(UserDetailRepository userDetailRepository, UserRoleRepository userRoleRepository){
		this.userDetailRepository = userDetailRepository;
		this.userRoleRepository = userRoleRepository;
	}

	@PostConstruct
	private void init(){
		logger.info(" -->> Starting authentication data initialization...");
//		roleRepository.saveAll(List.of(new Role("ROLE_USER"), new Role("ROLE_ADMIN")));
//		userRoleRepository.saveAll(List.of(new UserRole("ROLE_USER"), new UserRole("ROLE_ADMIN")));
//		UserDetail userDetail = userDetailRepository.findByUsername("small@gmail.com");
//		UserDetail userDetail = UserDetail.builder()
//				.name("senapati")
//				.phoneNumber("81477")
//				.username("senapati@gmail.com")
//				.emailId("senapatirupen@gmail.com")
//				.password(passwordEncoder.encode("123"))
//				.rePassword(passwordEncoder.encode("123"))
//				.roles(List.of(userRoleRepository.findByRole("ROLE_USER")))
//		.build();
//		userDetail.setRoles(List.of(userRoleRepository.findByRole("ROLE_ADMIN")));
//		userDetailRepository.save(userDetail);

//		Address address = new Address();
//		address.setStreet("Liberty Street");
//		address.setCity("of angels");
//		address.setCountry("Europe");
//
//		Account john = new Account();
//		john.setFirstName("john");
//		john.setUsername("john");
//		john.setLastName("doe");
//		john.setEmailAddress("john@doe.com");
//		john.setPassword(passwordEncoder.encode("doe"));
//		john.setAddress(address);
//		john.setRoles(List.of(roleRepository.findByRole("ROLE_USER")));
//		accountRepository.save(john);
//
//		Account jane = new Account();
//		jane.setFirstName("jane");
//		jane.setLastName("doe");
//		jane.setUsername("jane");
//		jane.setEmailAddress("jane@doe.com");
//		jane.setPassword(passwordEncoder.encode("doe"));
//		jane.setAddress(address);
//		jane.setRoles(List.of(roleRepository.findByRole("ROLE_USER"), roleRepository.findByRole("ROLE_ADMIN")));
//		accountRepository.save(jane);
//
//		Account admin = new Account();
//		admin.setFirstName("admin");
//		admin.setLastName("admin");
//		admin.setUsername("admin");
//		admin.setEmailAddress("admin@admin.com");
//		admin.setPassword(passwordEncoder.encode("admin"));
//		admin.setAddress(address);
//		admin.setRoles(List.of(roleRepository.findByRole("ROLE_ADMIN")));
//		accountRepository.save(admin);
//		logger.info(" -->> Authentication data initialization completed.");
	}
}
