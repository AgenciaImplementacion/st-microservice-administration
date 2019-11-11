package com.ai.st.microservice.administration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ai.st.entities.schema.administration.RoleEntity;
import com.ai.st.entities.schema.administration.UserEntity;
import com.ai.st.microservice.administration.business.RoleBusiness;
import com.ai.st.microservice.administration.models.services.IRoleService;
import com.ai.st.microservice.administration.models.services.IUserService;

@Component
public class StMicroserviceAdministrationApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(StMicroserviceAdministrationApplicationStartup.class);

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IUserService userService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("ST - Loading Domains ... ");
		this.initRoles();
		this.initUsers();
	}

	public void initRoles() {
		Long countRoles = roleService.getAllCount();
		if (countRoles == 0) {

			try {
				RoleEntity roleAdministrator = new RoleEntity();
				roleAdministrator.setId(RoleBusiness.ROLE_ADMINISTRATOR);
				roleAdministrator.setName("ADMINISTRADOR");
				roleService.createRole(roleAdministrator);

				RoleEntity roleManager = new RoleEntity();
				roleManager.setId(RoleBusiness.ROLE_MANAGER);
				roleManager.setName("GESTOR");
				roleService.createRole(roleManager);

				RoleEntity roleIntegrator = new RoleEntity();
				roleIntegrator.setId(RoleBusiness.ROLE_INTEGRATOR);
				roleIntegrator.setName("INTEGRADOR");
				roleService.createRole(roleIntegrator);

				RoleEntity roleOperator = new RoleEntity();
				roleOperator.setId(RoleBusiness.ROLE_OPERATOR);
				roleOperator.setName("OPERADOR");
				roleService.createRole(roleOperator);

				RoleEntity roleProvider = new RoleEntity();
				roleProvider.setId(RoleBusiness.ROLE_SUPPLY_SUPPLIER);
				roleProvider.setName("PROVEEDOR INSUMO");
				roleService.createRole(roleProvider);

				log.info("The domains 'roles' have been loaded!");
			} catch (Exception e) {
				log.error("Failed to load 'roles' domains");
			}

		}
	}

	public void initUsers() {
		Long countUsers = userService.getAllCount();
		if (countUsers == 0) {

			try {
				UserEntity userToTest = new UserEntity();
				userToTest.setFirstName("Jhon Freddy");
				userToTest.setLastName("Rondon Betancourt");
				userToTest.setCreatedAt(new Date());
				userToTest.setEmail("jhonfr29@gmail.com");
				userToTest.setEnabled(true);
				userToTest.setUsername("jrondon");
				userToTest.setPassword("$2a$10$C9Dz6U721ss4HsClLNS7EuWfla6nTMfO8gB9XlZbeNXzi6xNivvnC");

				RoleEntity roleAdministrator = roleService.getRoleById(RoleBusiness.ROLE_ADMINISTRATOR);
				if (roleAdministrator instanceof RoleEntity) {
					List<RoleEntity> listRoles = new ArrayList<RoleEntity>();
					listRoles.add(roleAdministrator);
					userToTest.setRoles(listRoles);
				}

				userService.createUser(userToTest);

				log.info("The domains 'users' have been loaded!");
			} catch (Exception e) {
				log.error("Failed to load 'users' domains: " + e.getMessage());
			}

		}
	}

}
