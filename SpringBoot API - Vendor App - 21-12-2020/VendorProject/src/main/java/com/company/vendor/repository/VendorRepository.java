package com.company.vendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.vendor.entites.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	
	@Query("select type, count(type) from vendor group by type ")
	public List<Object[]> findTypeAndTypeCount();

}
