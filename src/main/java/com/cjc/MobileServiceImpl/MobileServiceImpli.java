package com.cjc.MobileServiceImpl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.cjc.Entity.Mobile;
import com.cjc.MobileDAO.MobileDao;
import com.cjc.MobileService.MoblieService;

@Service
public class MobileServiceImpli implements MoblieService {
	
	private MobileDao mobiledao;

	public MobileServiceImpli(MobileDao mobiledao) {
		super();
		this.mobiledao = mobiledao;
	}

	@Override
	public Mobile addproducts(Mobile mob) {
		Mobile save = mobiledao.save(mob);
		return save;
	}

	@Override
	public Mobile getproduct(Integer id) {
		if (mobiledao.existsById(id)) {
			Mobile mobile = mobiledao.findById(id).get();
			return mobile;
		}
		return null;
	}

	@Override
	public Mobile updateproducts(Integer id, Mobile mob) {
		if (mobiledao.existsById(id)) {
			Mobile mobile = mobiledao.findById(id).get();
			mobile.setMobileName(mob.getMobileName());
			mobile.setMobileBrand(mob.getMobileBrand());
			mobile.setMobilePrice(mob.getMobilePrice());
			
			return mobiledao.save(mobile);
			
		}
		return null;
	}

	@Override
	public Mobile editproduct(Integer id, Mobile mob) {
		if (mobiledao.existsById(id)) {
			Mobile mobile = mobiledao.findById(id).get();
			if (mob.getMobileName()!=null) {
				mobile.setMobileName(mob.getMobileName());
				
			}
			if (mob.getMobileBrand()!=null) {
				mobile.setMobileBrand(mob.getMobileBrand());
				
			}
			if (mob.getMobilePrice()!=null) {
				mobile.setMobilePrice(mob.getMobilePrice());
			}
			return mobiledao.save(mobile);
		}
		return null;
	}

	@Override
	public List<Mobile> getallmobiles() {
		List<Mobile> findAll = mobiledao.findAll();
		return findAll;
	}

	@Override
	public List<Mobile> getmobilesxml() {
		List<Mobile> findAll = mobiledao.findAll();
		return findAll;
	}

	@Override
	public String deletemobile(Integer id) {
		String msg="";
		if (mobiledao.existsById(id)) {
			 mobiledao.deleteById(id);
			msg="ID Deleted Successfully"+id;
			return msg;
		}
		msg="ID Not Found/Existed"+id;
		return msg;
	}

	//Pagination
	@Override
	public List<Mobile> putpagination(int pageNumber, int pagesize) {
		Pageable page= PageRequest.of(pageNumber, pagesize);
	      Page<Mobile> findAll = mobiledao.findAll(page);
		
		if (findAll.hasContent()) {
		 List<Mobile> content = findAll.getContent();
			return content;
		}
		
		return null;
	}

	@Override
	public List<Mobile> getmobilebyprice(String direction) {
	   
		Sort sort;
	
		if (direction!=null && direction.equalsIgnoreCase("desc")) {
			sort = Sort.by(Sort.Direction.DESC, "mobilePrice");
		}
		else {
			sort=Sort.by(Sort.Direction.ASC,"mobilePrice");
		}
		return mobiledao.findAll(sort);
	}

	@Override
	public List<Mobile> getmobilesbyname(String mobileName) {
		List<Mobile> findByMobiles = mobiledao.findByMobileName(mobileName);
		return findByMobiles;
	}

	@Override
	public List<Mobile> sortedmethodfilter(String mobileBrand, Double minmobilePrice, Double maxmobilePrice) {
		List<Mobile> filterMobiles = mobiledao.filterMobiles(mobileBrand, minmobilePrice, maxmobilePrice);
		
		return filterMobiles;
	}

}
