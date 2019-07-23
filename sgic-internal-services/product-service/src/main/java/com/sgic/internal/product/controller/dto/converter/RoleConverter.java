package com.sgic.internal.product.controller.dto.converter;
//package com.sgic.internal.product.privileges.controller.dto.converter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.sgic.internal.product.privileges.controller.dto.RoleDTO;
//import com.sgic.internal.product.privileges.entities.Role;
//
//public class RoleConverter {
//	
//	private static Logger logger = LogManager.getLogger(RoleDTO.class);
//	
//	//Convert All List Role Entity to Dto
//		public static List<RoleDTO> RoleEntityTORoleDTOList(List<Role> rolelist){
//			
//			if(rolelist != null) {
//				
//				logger.info("Role Converter => Convert Lists To Entity");		
//				List<RoleDTO> listRoleDto = new ArrayList<>();			
//				for(Role role : rolelist) {				
//					RoleDTO roleDTO = new RoleDTO();
//					
//					roleDTO.setRoleName(role.getRoleName());;
//					
//					listRoleDto.add(roleDTO);
//				}
//				return listRoleDto;
//			}
//			return null;
//		}
//		
//		
//		//Convert RoleDTO to RoleEntity
//		public static Role RoleDTOTORoleEntity (RoleDTO roleDTO) {
//			
//			Role role = new Role();
//			if(roleDTO != null) {
//				logger.info("Role Convert => Role Dto Object to Role Entity");
//				
//				role.setRoleName(roleDTO.getRoleName());;
//				
//				return role;
//			}
//			return null;	
//		}
//		
//		
//		//Convert RoleEntity to RoleDTO
//		public static RoleDTO RoleEntityTORoleDTO (Role role) {
//			
//			RoleDTO roleDTO = new RoleDTO();
//			if(role != null) {
//				logger.info("Role Convert => Role Entity Object to Role Dto");
//				
//				roleDTO.setRoleName(role.getRoleName());;
//				
//				return roleDTO;
//			}
//			return null;	
//		}
//
//}
