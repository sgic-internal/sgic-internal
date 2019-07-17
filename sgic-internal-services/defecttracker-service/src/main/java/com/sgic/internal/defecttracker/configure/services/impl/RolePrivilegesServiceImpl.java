package com.sgic.internal.defecttracker.configure.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
