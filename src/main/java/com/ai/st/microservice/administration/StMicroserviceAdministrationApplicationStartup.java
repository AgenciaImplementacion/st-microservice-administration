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

import com.ai.st.microservice.administration.business.RoleBusiness;
import com.ai.st.microservice.administration.entities.RoleEntity;
import com.ai.st.microservice.administration.entities.UserEntity;
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

				// User 1

				UserEntity userToTest1 = new UserEntity();
				userToTest1.setFirstName("Jhon Freddy");
				userToTest1.setLastName("Rondon Betancourt");
				userToTest1.setCreatedAt(new Date());
				userToTest1.setEmail("jhonfr29@gmail.com");
				userToTest1.setEnabled(true);
				userToTest1.setUsername("jrondon");
				userToTest1.setPassword("$2a$10$C9Dz6U721ss4HsClLNS7EuWfla6nTMfO8gB9XlZbeNXzi6xNivvnC");

				RoleEntity roleAdministrator = roleService.getRoleById(RoleBusiness.ROLE_ADMINISTRATOR);
				if (roleAdministrator instanceof RoleEntity) {
					List<RoleEntity> listRoles = new ArrayList<RoleEntity>();
					listRoles.add(roleAdministrator);
					userToTest1.setRoles(listRoles);
				}

				userService.createUser(userToTest1);

				// User 2

				UserEntity userToTest2 = new UserEntity();
				userToTest2.setFirstName("German");
				userToTest2.setLastName("Carrillo");
				userToTest2.setCreatedAt(new Date());
				userToTest2.setEmail("carrillo.german@gmail.com");
				userToTest2.setEnabled(true);
				userToTest2.setUsername("gcarrillo");
				userToTest2.setPassword("$2a$10$C9Dz6U721ss4HsClLNS7EuWfla6nTMfO8gB9XlZbeNXzi6xNivvnC");

				RoleEntity roleManager = roleService.getRoleById(RoleBusiness.ROLE_MANAGER);
				if (roleManager instanceof RoleEntity) {
					List<RoleEntity> listRoles = new ArrayList<RoleEntity>();
					listRoles.add(roleManager);
					userToTest2.setRoles(listRoles);
				}

				userService.createUser(userToTest2);

				// User 3

				UserEntity userToTest3 = new UserEntity();
				userToTest3.setFirstName("Felipe");
				userToTest3.setLastName("Cano");
				userToTest3.setCreatedAt(new Date());
				userToTest3.setEmail("felipecanol@gmail.com");
				userToTest3.setEnabled(true);
				userToTest3.setUsername("fcano");
				userToTest3.setPassword("$2a$10$C9Dz6U721ss4HsClLNS7EuWfla6nTMfO8gB9XlZbeNXzi6xNivvnC");

				if (roleManager instanceof RoleEntity) {
					List<RoleEntity> listRoles = new ArrayList<RoleEntity>();
					listRoles.add(roleManager);
					userToTest3.setRoles(listRoles);
				}

				userService.createUser(userToTest3);

				// User 4

				UserEntity userToTest4 = new UserEntity();
				userToTest4.setFirstName("Andres");
				userToTest4.setLastName("Acosta");
				userToTest4.setCreatedAt(new Date());
				userToTest4.setEmail("amacostapulido@gmail.com");
				userToTest4.setEnabled(true);
				userToTest4.setUsername("aacosta");
				userToTest4.setPassword("$2a$10$C9Dz6U721ss4HsClLNS7EuWfla6nTMfO8gB9XlZbeNXzi6xNivvnC");

				RoleEntity roleProvider = roleService.getRoleById(RoleBusiness.ROLE_SUPPLY_SUPPLIER);
				if (roleProvider instanceof RoleEntity) {
					List<RoleEntity> listRoles = new ArrayList<RoleEntity>();
					listRoles.add(roleProvider);
					userToTest4.setRoles(listRoles);
				}

				userService.createUser(userToTest4);

				// User 5

				UserEntity userToTest5 = new UserEntity();
				userToTest5.setFirstName("Jonathan");
				userToTest5.setLastName("Albarracin");
				userToTest5.setCreatedAt(new Date());
				userToTest5.setEmail("jonyfido@gmail.com");
				userToTest5.setEnabled(true);
				userToTest5.setUsername("jalbarracin");
				userToTest5.setPassword("$2a$10$C9Dz6U721ss4HsClLNS7EuWfla6nTMfO8gB9XlZbeNXzi6xNivvnC");

				if (roleProvider instanceof RoleEntity) {
					List<RoleEntity> listRoles = new ArrayList<RoleEntity>();
					listRoles.add(roleProvider);
					userToTest5.setRoles(listRoles);
				}

				userService.createUser(userToTest5);

				// User 6

				UserEntity userToTest6 = new UserEntity();
				userToTest6.setFirstName("Agencia");
				userToTest6.setLastName("Implementación");
				userToTest6.setCreatedAt(new Date());
				userToTest6.setEmail("agenciadeimplementacion@incige.com");
				userToTest6.setEnabled(true);
				userToTest6.setUsername("agencia");
				userToTest6.setPassword("$2a$10$C9Dz6U721ss4HsClLNS7EuWfla6nTMfO8gB9XlZbeNXzi6xNivvnC");

				List<RoleEntity> listRoles = new ArrayList<RoleEntity>();
				listRoles.add(roleAdministrator);
				userToTest6.setRoles(listRoles);

				userService.createUser(userToTest6);

				// User 7

				UserEntity userToTest7 = new UserEntity();
				userToTest7.setFirstName("Jhon Alexander");
				userToTest7.setLastName("Galindo");
				userToTest7.setCreatedAt(new Date());
				userToTest7.setEmail("jhonalex.ue@gmail.com");
				userToTest7.setEnabled(true);
				userToTest7.setUsername("jgalindo");
				userToTest7.setPassword("$2a$10$C9Dz6U721ss4HsClLNS7EuWfla6nTMfO8gB9XlZbeNXzi6xNivvnC");

				List<RoleEntity> listRoles2 = new ArrayList<RoleEntity>();
				listRoles2.add(roleProvider);
				userToTest7.setRoles(listRoles2);

				userService.createUser(userToTest7);

				log.info("The domains 'users' have been loaded!");
			} catch (Exception e) {
				log.error("Failed to load 'users' domains: " + e.getMessage());
			}

		}
	}

}
