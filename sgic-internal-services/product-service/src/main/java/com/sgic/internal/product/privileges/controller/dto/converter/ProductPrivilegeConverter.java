package com.sgic.internal.product.privileges.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.privileges.controller.dto.ProductPrivilegeDto;
import com.sgic.internal.product.privileges.entities.Privilege;
import com.sgic.internal.product.privileges.entities.ProductPrivilege;

@Service
public class ProductPrivilegeConverter {
	private static Logger logger = LogManager.getLogger(ProductPrivilege.class);

	// Convert All List<Entity> to List<DTO>
	public static List<ProductPrivilegeDto> EntityListTODtoList(List<ProductPrivilege> productPrivilegeList) {
		if (productPrivilegeList != null) {
			logger.info("Product Privilege Converter -> Convert Lists Entity to DTO");
			List<ProductPrivilegeDto> listProductPrivilegeDto = new ArrayList<>();
			for (ProductPrivilege productPrivilege : productPrivilegeList) {
				ProductPrivilegeDto productPrivilegeDto = new ProductPrivilegeDto();

				productPrivilegeDto.setProductPrivilegeId(productPrivilege.getId());
				productPrivilegeDto.setProductPrivilegeNameId(productPrivilege.getPrivilege().getPrivilegeId());
				productPrivilegeDto.setProductPrivilegeName(productPrivilege.getPrivilege().getName());
				productPrivilegeDto.setProductPrivilegeStatus(productPrivilege.isPrivilegeStatus());

				listProductPrivilegeDto.add(productPrivilegeDto);
			}
			return listProductPrivilegeDto;
		}
		return null;
	}

	
	// Convert Data To Entity
	public static ProductPrivilege DtoToEntity(ProductPrivilegeDto productPrivilegeDto) {
		ProductPrivilege productPrivilege = new ProductPrivilege();
		if (productPrivilegeDto != null) {
			logger.info("Product Privilege Converter -> Convert Object DTO to Entity");
//					productPrivilege.setId(productPrivilegeDto.getProjectPrivilegeId());

			Privilege privilege = new Privilege();
			privilege.setPrivilegeId(productPrivilegeDto.getProductPrivilegeNameId());
//			privilege.setName(productPrivilegeDto.getProjectPrivilegeName());
			
			productPrivilege.setPrivilege(privilege);

			productPrivilege.setPrivilegeStatus(productPrivilegeDto.isProductPrivilegeStatus());

			return productPrivilege;
		}
		return null;
	}

	// Convert Data To Entity
	public static ProductPrivilege DtoToEntityUpdate(ProductPrivilegeDto productPrivilegeDto) {
		ProductPrivilege productPrivilege = new ProductPrivilege();
		if (productPrivilegeDto != null) {
			logger.info("Product Privilege Converter -> Convert Object DTO to Entity");
			productPrivilege.setId(productPrivilegeDto.getProductPrivilegeId());

			Privilege privilege = new Privilege();
			privilege.setPrivilegeId(productPrivilegeDto.getProductPrivilegeNameId());
			privilege.setName(productPrivilegeDto.getProductPrivilegeName());
			productPrivilege.setPrivilege(privilege);

			productPrivilege.setPrivilegeStatus(productPrivilegeDto.isProductPrivilegeStatus());

			return productPrivilege;
		}
		return null;
	}

	// Convert Entity To Data
	public static ProductPrivilegeDto EntityToDto(ProductPrivilege productPrivilege) {
		ProductPrivilegeDto productPrivilegeDto = new ProductPrivilegeDto();
		if (productPrivilege != null) {
			logger.info("Product Privilege Converter -> Convert Object Entity to DTO");
			productPrivilegeDto.setProductPrivilegeId(productPrivilege.getId());
			productPrivilegeDto.setProductPrivilegeNameId(productPrivilege.getPrivilege().getPrivilegeId());
			productPrivilegeDto.setProductPrivilegeName(productPrivilege.getPrivilege().getName());
			productPrivilegeDto.setProductPrivilegeStatus(productPrivilege.isPrivilegeStatus());

			return productPrivilegeDto;
		}
		return null;
	}
}
