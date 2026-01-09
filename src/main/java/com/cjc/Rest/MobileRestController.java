package com.cjc.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.Entity.Mobile;
import com.cjc.MobileService.MoblieService;
import com.cjc.MobileXml.MobileXml;

@RestController
public class MobileRestController {
	@Autowired
	private MoblieService mobileservice;
	
	
	public MoblieService getMobileservice() {
		return mobileservice;
	}


	public void setMobileservice(MoblieService mobileservice) {
		this.mobileservice = mobileservice;
	}


	@PostMapping(value = "/addmobiles", consumes = {"application/json", "application/xml"}, produces = {"application/xml", "application/json"})
	public Mobile addallmobiles(@RequestBody Mobile mob) {
		return mobileservice.addproducts(mob);
	}
	
	@GetMapping(value = "/getallmobiles")
	public List<Mobile> getallmobiles() {
		List<Mobile> getallmobiles = mobileservice.getallmobiles();
		return getallmobiles;
	
	}
	@GetMapping(value = "/getallxmlmobiles", produces = {"application/xml"})
	public MobileXml getallmobilesXMl(){
		List<Mobile> getmobilesxml = mobileservice.getmobilesxml();
		MobileXml mx=new MobileXml();
		mx.setMobliexml(getmobilesxml);
		return mx;

	}
	
	@PutMapping(value = "updatemobile/{id}", consumes = {"application/json", "application/xml"}, produces = {"application/xml", "application/json"})
	public Mobile updatemobile(@PathVariable int id, @RequestBody Mobile mob)
	{
		return mobileservice.updateproducts(id, mob);
	}
	
	@PatchMapping(value = "/editmobile/{id}", consumes = {"application/json", "application/xml"}, produces = {"application/xml", "application/json"})
	public Mobile editmobile(@RequestBody Mobile mob, @PathVariable int id) {
		return mobileservice.editproduct(id, mob);
	}
	
	@DeleteMapping(value = "/deletemobile/{id}")
	public String deletemobile(@PathVariable int id) {
		return mobileservice.deletemobile(id);
	}
	
	//Pagination
	@GetMapping(value = "/getmobiles/page")
	public List<Mobile> pagination(@RequestParam (defaultValue = "0") int pageNumber, @RequestParam (defaultValue = "3") int pagesize){
		return mobileservice.putpagination(pageNumber, pagesize);
	}
	//sorting 
	// New: sort by price (direction query param: asc or desc). Defaults to asc.
	@GetMapping(value = "/getproducts/sortbyprice")
	public List<Mobile> getmobilebyprice(@RequestParam (defaultValue = "asc")String direction){
		return mobileservice.getmobilebyprice(direction);
	}
	
	//Search from Name
	@GetMapping(value = "getmobiles/findbyname/{mobileName}")
	public List<Mobile> findbyname(@PathVariable ("mobileName") String mobileName){
		 List<Mobile> getmobilesbyname = mobileservice.getmobilesbyname(mobileName);
		 return getmobilesbyname;
		
	}
	
	//Filter mobile by Category minprice maxprice
	@GetMapping(value = "/addfilter")
	public List<Mobile> addfilter(@RequestParam (required = false) String mobileBrand,
			                       @RequestParam (required = false) Double minmobilePrice,
			                       @RequestParam (required = false) Double maxmobilePrice){
		List<Mobile> sortedmethodfilter = mobileservice.sortedmethodfilter(mobileBrand, minmobilePrice, maxmobilePrice);
		return sortedmethodfilter;
		
		
	}
	
	
	

}
