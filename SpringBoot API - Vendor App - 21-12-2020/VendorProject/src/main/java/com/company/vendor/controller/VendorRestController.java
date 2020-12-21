package com.company.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.vendor.entites.Vendor;
import com.company.vendor.repository.VendorRepository;

@RestController
@RequestMapping("/vendor")
public class VendorRestController {

	@Autowired
	VendorRepository vendorRepository;
	
	@GetMapping
	public List<Vendor> getLocation(){
		return vendorRepository.findAll();
	}
	
	@PostMapping
	public Vendor saveLocation(@RequestBody Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	
	@PutMapping
	public Vendor updateLocation(@RequestBody Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocationById(@PathVariable("id") int id) {
		vendorRepository.deleteById(id);
	}
}
