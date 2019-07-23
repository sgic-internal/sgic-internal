package com.sgic.internal.defecttracker.defect.controller.dto.converter;
//package com.sgic.internal.defecttracker.project.controller.converter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.sgic.internal.defecttracker.project.controller.dto.ResourceAllocationListDto;
//import com.sgic.internal.defecttracker.project.entities.Employee;
//import com.sgic.internal.defecttracker.project.entities.ResourceAllocationList;
//
//public class ResourceAllocationListConverter {
//
//	public static ResourceAllocationListDto ResourceAllocationListToResourceAllocationListDto(
//			ResourceAllocationList resourceAllocationList) {
//		ResourceAllocationListDto resourceAllocationListDto = new ResourceAllocationListDto();
//
//		if (resourceAllocationList != null) {
//			resourceAllocationListDto.setResourceId(resourceAllocationList.getResourceId());
//			resourceAllocationListDto.setEmpId(resourceAllocationList.getEmpId());
//			resourceAllocationListDto.setEmployeeid(resourceAllocationList.getEmployeeObj().getEmployeeid());
//			resourceAll	ocationListDto.setFirstname(resourceAllocationList.getEmployeeObj().getFirstname());
//			resourceAllocationListDto.setName(resourceAllocationList.getEmployeeObj().getName());
//			resourceAllocationListDto.setEmail(resourceAllocationList.getEmployeeObj().getEmail());
//			resourceAllocationListDto.setDesignationid(resourceAllocationList.getEmployeeObj().getDesignationid());
//			resourceAllocationListDto.setDesignationname(resourceAllocationList.getEmployeeObj().getDesignationname());
//			resourceAllocationListDto.setAvailability(resourceAllocationList.getEmployeeObj().getAvailability());
//			resourceAllocationListDto.setBench(resourceAllocationList.getEmployeeObj().isBench());
//			return resourceAllocationListDto;
//		}
//		return resourceAllocationListDto;
//	}
//
//	public static ResourceAllocationList ResourceAllocationListDtoToResourceAllocationList(
//			ResourceAllocationListDto resourceAllocationListDto) {
//		ResourceAllocationList resourceAllocationList = new ResourceAllocationList();
//		if (resourceAllocationListDto != null) {
//			resourceAllocationList.setResourceId(resourceAllocationListDto.getResourceId());
////			Project projectObj = new Project();
////			projectObj.setProjectId(resourceAllocationList.getProjectObj().getProjectId());
////			projectObj.setProjectName(resourceAllocationList.getProjectObj().getProjectName());
////			resourceAllocationList.setProjectObj(projectObj);
//			Employee employeeObj = new Employee();
//			employeeObj.setEmpId(resourceAllocationList.getEmployeeObj().getEmpId());
//			employeeObj.setEmployeeid(resourceAllocationList.getEmployeeObj().getEmployeeid());
//			employeeObj.setFirstname(resourceAllocationList.getEmployeeObj().getFirstname());
//			employeeObj.setName(resourceAllocationList.getEmployeeObj().getName());
//			employeeObj.setEmail(resourceAllocationList.getEmployeeObj().getEmail());
//			employeeObj.setDesignationid(resourceAllocationList.getEmployeeObj().getDesignationid());
//			employeeObj.setDesignationname(resourceAllocationList.getEmployeeObj().getDesignationname());
//			employeeObj.setAvailability(resourceAllocationList.getEmployeeObj().getAvailability());
//			employeeObj.setBench(resourceAllocationList.getEmployeeObj().isBench());
//			return resourceAllocationList;
//		}
//
//		return null;
//
//	}
//
//	public static List<ResourceAllocationListDto> ResourceAllocationListToResourceAllocationListDto(
//			List<ResourceAllocationList> resourceAllocationList1) {
//
//		if (resourceAllocationList1 != null) {
//			List<ResourceAllocationListDto> listresourceAllocationDto = new ArrayList<>();
//			for (ResourceAllocationList resourceAllocationList : resourceAllocationList1) {
//				ResourceAllocationListDto resourceAllocationListDto = new ResourceAllocationListDto();
//				resourceAllocationListDto.setResourceId(resourceAllocationList.getResourceId());
//				resourceAllocationListDto.setEmpId(resourceAllocationList.getEmpId());
//				resourceAllocationListDto.setEmployeeid(resourceAllocationList.getEmployeeObj().getEmployeeid());
//				resourceAllocationListDto.setFirstname(resourceAllocationList.getEmployeeObj().getFirstname());
//				resourceAllocationListDto.setName(resourceAllocationList.getEmployeeObj().getName());
//				resourceAllocationListDto.setDesignationid(resourceAllocationList.getEmployeeObj().getDesignationid());
//				resourceAllocationListDto.setDesignationname(resourceAllocationList.getEmployeeObj().getDesignationname());
//				resourceAllocationListDto.setAvailability(resourceAllocationList.getEmployeeObj().getAvailability());
//				resourceAllocationListDto.setBench(resourceAllocationList.getEmployeeObj().isBench());
////				resourceAllocationListDto.setProjectId(resourceAllocationList.getProjectObj().getProjectId());
////				resourceAllocationListDto.setProjectName(resourceAllocationList.getProjectObj().getProjectName());
//				listresourceAllocationDto.add(resourceAllocationListDto);
//
//			}
//
//			return listresourceAllocationDto;
//		}
//		return null;
//
//	}
//}
