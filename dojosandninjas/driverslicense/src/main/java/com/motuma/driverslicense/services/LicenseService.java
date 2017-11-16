package com.motuma.driverslicense.services;

import org.springframework.stereotype.Service;

import com.motuma.driverslicense.models.License;
import com.motuma.driverslicense.repositories.LicenseRepository;


@Service
public class LicenseService {
private  LicenseRepository licenseRepo;
	
	public LicenseService(LicenseRepository licenseRepo) {
		this.licenseRepo = licenseRepo;
	}

	public void addLicense(License license) {
		licenseRepo.save(license);		
	}
	
}