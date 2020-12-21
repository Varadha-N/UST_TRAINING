package com.company.vendor.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.vendor.entites.Vendor;
import com.company.vendor.repository.VendorRepository;
import com.company.vendor.services.VendorService;
import com.company.vendor.utilities.EmailUtility;
import com.company.vendor.utilities.ReportUtility;

@Controller
public class VendorController 
{

	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private VendorService venderService;
	
	@Autowired
	private EmailUtility emailUtility;
	
	@Autowired
	ServletContext sc;
	
	@Autowired
	private ReportUtility reportUtil;

	@RequestMapping("/showVendor")
	public String createVendor() 
	{
		return "createVendor";
		
	}
	
	@RequestMapping("/createVendor")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap modelMap)
	{
		Vendor vendors = venderService.saveVendor(vendor);
		String message = "Vendor Details Added Successfully with id:"+vendors.getId();
		modelMap.addAttribute("message", message);
		emailUtility.sendEmail("trainingdora@gmail.com", "New vendor details added", vendors.toString());
		return "createVendor";
	}
	
	@RequestMapping("/displayVendors")
	public String displayVendors(ModelMap modelMap) {
		List<Vendor> vendors = venderService.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
	
	@RequestMapping("/deleteVendor")
	public String deleteVendor(@RequestParam("id") int id, ModelMap modelMap ) {
		Vendor vendor = new Vendor();
		vendor.setId(id);
		venderService.deleteVendor(vendor);
		List<Vendor> vendors = venderService.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap ) {
		Vendor vendor = venderService.getVendorId(id);
		modelMap.addAttribute("vendor", vendor);
		return "updateVendor";
	}
	
	@RequestMapping("/updateVendor")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap modelMap ) {
		venderService.saveVendor(vendor);
		
		List<Vendor> vendors = venderService.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = vendorRepository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path,data);
		return "report";
	}
}
