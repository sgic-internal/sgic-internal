//package com.sgic.internal.product.privileges.services.impl;
//
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sgic.internal.product.privileges.entities.Privilege;
//import com.sgic.internal.product.privileges.repository.PrivilegeRepo;
//import com.sgic.internal.product.privileges.services.PrivilegeService;
//
//@Service
//public class PrivilegeServiceImpl implements PrivilegeService {
//
//	@Autowired
//	PrivilegeRepo privilageRepo;
//	
//	private static Logger logger = LogManager.getLogger(PrivilegeRepo.class);
//	@Override
//	public Privilege getPrivilegeById(Long privilageId) {
//		logger.info("service started -> getPrivilegeById");
//		return privilageRepo.findPrivilegeById(privilageId);
//	}
//
//	@Override
//	public Privilege savePrivilege(Privilege privilege) {
//		logger.info("service started -> SavePrivilege");
//		return privilageRepo.save(privilege);
//	}
//
//	@Override
//	public List<Privilege> getAllPrivilege() {
//		logger.info("service started -> GetAllPrivilege");
//		return privilageRepo.findAll();
//	}
//
//	@Override
//	public Privilege deletePrivilegeById(Long privilageId) {
//		logger.info("service started -> deletePrivilegeById");
//		privilageRepo.deleteById(privilageId);
//		return null;
//	}
//
//
//	@Override
//	public Privilege updatePrivilege(Privilege privilege) {
//		logger.info("service started -> UpdateCompany");
//		Long privilageId = privilege.getPrivilegeId();
//		logger.info("service started -> getCompanyId");
//		boolean isExist = ((PrivilegeRepo) privilageRepo).findById(privilageId) != null;
//		if (isExist) {
//			logger.info("service started -> Updated By CompanyId");
//			return privilageRepo.save(privilege);
//		} else {
//			logger.info("service started -> companyId Not Found");
//		}
//		return null;
//	}
//	
//}
//
