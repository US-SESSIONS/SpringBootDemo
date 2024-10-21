package com.ussessions.warehousemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ussessions.warehousemanagement.entity.KYCDetail;
import com.ussessions.warehousemanagement.repository.KYCDetailRepository;

@Service
public class KycDocumentServiceImpl implements KYCDocumentService {
	@Autowired
	private KYCDetailRepository kycDetailRepository;

	@Override
	public void addKYC() {
		System.out.println("add kyc method called");
		kycDetailRepository.save(new KYCDetail());
		System.out.println("after save method");

	}

}
