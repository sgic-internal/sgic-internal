//package com.sgic.internal.product.privileges.controller.dto.converter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Service;
//
//import com.sgic.internal.product.privileges.controller.dto.PrivilegeDTO;
//import com.sgic.internal.product.privileges.entities.Privilege;
//
//@Service
//public class PrivilegeConverter {
//	
//	private static Logger logger = LogManager.getLogger(PrivilegeDTO.class);
//	
//	//Convert All List Privilege Entity to Dto
//	public static List<PrivilegeDTO> PrivilegeEntityToPrivilegeDTOList(List<Privilege> privilegelist){
//		
//		if(privilegelist != null) {
//			
//			logger.info("Privilege Converter => Convert Lists To Entity");		
//			List<PrivilegeDTO> listPrivilegeDto = new ArrayList<>();			
//			for(Privilege privilege : privilegelist) {				
//				PrivilegeDTO privilegeDTO = new PrivilegeDTO();
//				
//				privilegeDTO.setPrivilageName(privilege.getPrivilageNameString());
//				
//				listPrivilegeDto.add(privilegeDTO);
//			}
//			return listPrivilegeDto;
//		}
//		return null;
//	}
//	
//	
//	//Convert PrivilegeDTO to PrivilegeEntity
//	public static Privilege PrivilageDTOTOPrivilegeEntity (PrivilegeDTO privilegeDTO) {
//		
//		Privilege privilege = new Privilege();
//		if(privilegeDTO != null) {
//			logger.info("Privilege Convert => Privilage Dto Object to Privilege Entity");
//			
//			privilege.setPrivilageNameString(privilegeDTO.getPrivilageName());
//			
//			return privilege;
//		}
//		return null;	
//	}
//	
//	
//	//Convert PrivilegeDTO to PrivilegeEntity
//	public static PrivilegeDTO PrivilageEntityTOPrivilegeDTO (Privilege privilege) {
//		
//		PrivilegeDTO privilegeDTO = new PrivilegeDTO();
//		if(privilege != null) {
//			logger.info("Privilege Convert => Privilage Entity Object to Privilege Dto");
//			
//			privilegeDTO.setPrivilageName(privilege.getPrivilageNameString());
//			
//			return privilegeDTO;
//		}
//		return null;	
//	}
//}
