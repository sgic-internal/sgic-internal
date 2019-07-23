package com.sgic.internal.product.controller.dto.mapper;
//package com.sgic.internal.product.privileges.controller.dto.mapper;
//
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sgic.internal.product.privileges.controller.dto.PrivilegeDTO;
//import com.sgic.internal.product.privileges.controller.dto.converter.PrivilegeConverter;
//import com.sgic.internal.product.privileges.entities.Privilege;
//import com.sgic.internal.product.privileges.services.PrivilegeService;
//
//@Service
//public class PrivilegeMapper {
//	
//	@Autowired
//	private PrivilegeConverter privilegeConverter;
//	@Autowired
//	private PrivilegeService privilegeService;
//
//	private static Logger logger = LogManager.getLogger(PrivilegeDTO.class);
//
//	// Get All Privilege
//	@SuppressWarnings("static-access")
//	public List<PrivilegeDTO> getAllPrivilage() {
//		logger.info("Privilege Mapper -> All Privilege Data Retrieved");
//		List<Privilege> privilagelist = privilegeService.getAllPrivilege();
//		return privilegeConverter.PrivilegeEntityToPrivilegeDTOList(privilagelist);
//	}
//
//	// Save Privilege
//	@SuppressWarnings("static-access")
//	public Privilege savePrivilege(PrivilegeDTO privilegeDTO) {
//		logger.info("Privilege Mapper -> Privilege Saved");
//		return privilegeService.savePrivilege(privilegeConverter.PrivilageDTOTOPrivilegeEntity(privilegeDTO));
//	}
//
//	// Update Privilege
//	@SuppressWarnings("static-access")
//	public Privilege updatePrivilege(PrivilegeDTO privilegeDTO) {
//		logger.info("Privilege Mapper -> Privilege Updated ", privilegeDTO.getPrivilageName());
//		return privilegeService.updatePrivilege(privilegeConverter.PrivilageDTOTOPrivilegeEntity(privilegeDTO)); 
//	}
//
//	// Delete Privilege
//	public PrivilegeDTO deletePrivilegeById(Long privilageId) {
//		logger.info("Privilege Mapper -> Privilege Deleted");
//		privilegeService.deletePrivilegeById(privilageId);
//		return null;
//	}
//
//	// Get Privilege By Id
//	@SuppressWarnings("static-access")
//	public PrivilegeDTO getPrivilegeById(Long privilageId) {
//		logger.info("Privilege Mapper -> Privilege Id Found");
//		Privilege privilege  = privilegeService.getPrivilegeById(privilageId);
//		return privilegeConverter.PrivilageEntityTOPrivilegeDTO(privilege);
//	}
//
//}
