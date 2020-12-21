package com.company.vendor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.vendor.entites.Vendor;
import com.company.vendor.repository.VendorRepository;

@Service
public class VenderServiceimpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;
	
	@Override
	public Vendor saveVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendorRepository.save(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendorRepository.save(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		vendorRepository.delete(vendor);
	}

	@Override
	public Vendor getVendorId(int id) {
		// TODO Auto-generated method stub
		return vendorRepository.findById(id).get();
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return vendorRepository.findAll();
	}

}
