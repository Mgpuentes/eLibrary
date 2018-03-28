package com.puentes.elibrary;

import com.puentes.elibrary.backend.persistance.domain.security.Role;
import com.puentes.elibrary.backend.persistance.domain.security.User;
import com.puentes.elibrary.backend.persistance.domain.security.UserRole;
import com.puentes.elibrary.backend.persistance.repositories.RoleRepository;
import com.puentes.elibrary.backend.service.UserService;
import com.puentes.elibrary.enums.RolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ElibraryApplication implements CommandLineRunner {

	private final UserService userService;
	private final RoleRepository roleRepository;

	@Autowired
	public ElibraryApplication(UserService userService, RoleRepository roleRepository) {
		this.userService = userService;
		this.roleRepository = roleRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ElibraryApplication.class, args);
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {

		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("password");
		admin.setEmail("admin@email.com");

		Role adminRole = new Role(RolesEnum.ADMIN);
		Role userRole = new Role(RolesEnum.USER);
		adminRole = roleRepository.save(adminRole);
		userRole = roleRepository.save(userRole);

		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(admin, adminRole));
		userRoles.add(new UserRole(admin, userRole));
		userService.createUser(admin, userRoles);
	}
}
