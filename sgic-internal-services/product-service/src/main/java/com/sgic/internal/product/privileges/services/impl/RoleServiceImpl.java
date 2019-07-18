//package com.sgic.internal.product.privileges.services.impl;
//
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.sgic.internal.product.privileges.entities.Role;
//import com.sgic.internal.product.privileges.repository.PrivilegeRepo;
//import com.sgic.internal.product.privileges.repository.RoleRepo;
//import com.sgic.internal.product.privileges.services.RoleService;
//
//public class RoleServiceImpl implements RoleService {
//	
//	private RoleRepo roleRepo;
//	
//	private static Logger logger = LogManager.getLogger(PrivilegeRepo.class);
//
//	@Override
//	public Role getRoleById(Long roleId) {
//		logger.info("service started -> getPrivilegeById");
//		return roleRepo.findRoleById(roleId);
//	}
//
//	@Override
//	public Role saveRole(Role role) {
//		logger.info("service started -> SavePrivilege");
//		return roleRepo.save(role);
//	}
//
//	@Override
//	public List<Role> getAllRole() {
//		logger.info("service started -> GetAllPrivilege");
//		return roleRepo.findAll();
//	}
//
//	@Override
//	public Role deleteRoleById(Long roleId) {
//		logger.info("service started -> deletePrivilegeById");
//		roleRepo.deleteById(roleId);
//		return null;
//	}
//
//	@Override
//	public Role updateRole(Role role) {
//		logger.info("service started -> UpdateCompany");
//		Long roleId = role.getRoleId();
//		logger.info("service started -> getCompanyId");
//		boolean isExist = ((RoleRepo) roleRepo).findById(roleId) != null;
//		if (isExist) {
//			logger.info("service started -> Updated By CompanyId");
//			return roleRepo.save(role);
//		} else {
//			logger.info("service started -> companyId Not Found");
//		}
//		return null;
//	}
//
//
//}
