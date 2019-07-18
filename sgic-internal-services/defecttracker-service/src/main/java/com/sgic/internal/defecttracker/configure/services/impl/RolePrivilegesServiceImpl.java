package com.sgic.internal.defecttracker.configure.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import com.sgic.internal.defecttracker.configure.entity.ProductPrivilege;
import com.sgic.internal.defecttracker.configure.entity.RolePrivileges;
import com.sgic.internal.defecttracker.configure.repository.RolePrivilegesRepository;
import com.sgic.internal.defecttracker.configure.services.RolePrivilegesService;

@Service
public class RolePrivilegesServiceImpl implements RolePrivilegesService{

	@Autowired
	RolePrivilegesRepository rolePrivilegeRepo;
	
	private static Logger logger = LogManager.getLogger(RolePrivilegesRepository.class);
	
	@Override
	public RolePrivileges createRolePrivileges(RolePrivileges rolePrivileges) {
		logger.info("Role Privileges Service INFO -> Create Role Privileges Method Started");
		try {
			logger.info("Role Privileges Service INFO -> Save Role Privileges Sucess!");
			return rolePrivilegeRepo.save(rolePrivileges);
		} catch (Exception ex) {
			logger.error("Role Privileges Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Role Privileges Service INFO -> Create Role Privileges Method Finished");
		}
		return null;
	}

	@Override
	public RolePrivileges updateRolePrivileges(RolePrivileges rolePrivileges) {
		logger.info("Role Privileges Service INFO -> Update Role Privileges Method Started");
		try {
			Long id = rolePrivileges.getId();
			logger.info("Role Privileges Service INFO -> getDefectSeverityId");
			boolean isExist = rolePrivilegeRepo.findRolePrivilegesById(id) != null;
			if (isExist) {
				logger.info("Role Privileges Service INFO -> Updated By Role Privileges Id");
				return rolePrivilegeRepo.save(rolePrivileges);
			} else {
				logger.warn("Role Privileges Service INFO -> Role Privileges Id Not Found");
			}
		} catch (Exception ex) {
			logger.error("Role Privileges Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Role Privileges Service INFO -> Update Role Privileges Method Finished");
		}
		return null;
	}

	@Override
	public RolePrivileges getRolePrivilegesById(Long rolePrivilegesId) {
		logger.info("Role Privileges Service INFO -> Get Role Privileges Id Method Started");
		try {
		logger.info("Role Privileges Service INFO -> Get Role Privileges Id");
		return rolePrivilegeRepo.findRolePrivilegesById(rolePrivilegesId);
		} catch (Exception ex) {
			logger.error("Role Privileges Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Role Privileges Service INFO -> Get Role Privileges Id Method Finished");
		}
		return null;
	}

	@Override
	public List<RolePrivileges> getAllRolePrivilegesy() {
		logger.info("Role Privileges Service INFO -> Get All Role Privileges Method Started");
		try {
		logger.info("Role Privileges Service INFO -> Get All Role Privileges");
		return rolePrivilegeRepo.findAll();
		} catch (Exception ex) {
			logger.error("Role Privileges Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Role Privileges Service INFO -> Get All Role Privileges Method Finished");
		}
		return null;
	}

	@Override
	public RolePrivileges deleteRolePrivilegesById(Long rolePrivilegesId) {
		logger.info("Role Privileges Service INFO -> Delete Role Privileges Method Started");
		try {
		logger.info("Role Privileges Service INFO -> Role Privileges Severity");
		rolePrivilegeRepo.deleteById(rolePrivilegesId);
		} catch (Exception ex) {
			logger.error("Role Privileges Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Role Privileges Service INFO -> Delete Role Privileges Method Finished");
		}
		return null;
	}

	@Override
	public List<RolePrivileges> getAllProductPrivilegesIds() {
		logger.info("Role Privileges Service INFO -> Get All Product Privileges Id Method Started");
		try {
		logger.info("Role Privileges Service INFO -> Get All Product Privileges Id Privileges");
		return rolePrivilegeRepo.GetAllProductPrivilegeId();
		} catch (Exception ex) {
			logger.error("Role Privileges Service ERROR! -> " + ex.getMessage());
		} finally {
			logger.info("Role Privileges Service INFO -> Get All Product Privileges Id Method Finished");
		}
		return null;
	}
	
	
	//Get All Product Privileges from Product Service
	@Override
	public List<ProductPrivilege> getAllProductPrivileges() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ProductPrivilege>> response = restTemplate.exchange(
				"http://localhost:8083/productservice/ProductPrivileges", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ProductPrivilege>>() {
				});
		List<ProductPrivilege> getProductPrivileges = response.getBody();
		return getProductPrivileges;
	}

	//Get All Product Privilege By Product Privilege Id from Product Service
	@Override
	public ProductPrivilege getProductPrivilegeById(Long productPrivilegeId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProductPrivilege> response = restTemplate.exchange(
				"http://localhost:8083/productservice/ProductPrivilege/" + productPrivilegeId, HttpMethod.GET, null,
				new ParameterizedTypeReference<ProductPrivilege>() {
				});
		ProductPrivilege productPrivilege = response.getBody();
		return productPrivilege;
	}

}
