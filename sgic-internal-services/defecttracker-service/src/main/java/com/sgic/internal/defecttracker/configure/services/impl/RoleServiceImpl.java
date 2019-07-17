package com.sgic.internal.defecttracker.configure.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.configure.entity.Role;
import com.sgic.internal.defecttracker.configure.repository.RoleRepository;
import com.sgic.internal.defecttracker.configure.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepo;

	@Override
	public List<Role> saveRole() {
		Role r1 = new Role("QA");
		Role r2 = new Role("DEV");
		Role r3 = new Role("TEC");
		Role r4 = new Role("SQA");
		Role r5 = new Role("STEC");
		List<Role> role = Arrays.asList(r1, r2, r3, r4, r5);
		return roleRepo.saveAll(role);	
		}

	@Override
	public List<Role> getAllRole() {
		return roleRepo.findAll();
	}

}
