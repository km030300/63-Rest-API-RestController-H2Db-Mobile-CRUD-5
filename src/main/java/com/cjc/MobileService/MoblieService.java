package com.cjc.MobileService;

import java.util.List;
import com.cjc.Entity.Mobile;

public interface MoblieService {
	
	Mobile addproducts(Mobile mob);
	Mobile getproduct( Integer id);
	Mobile updateproducts(Integer id, Mobile mob);
	Mobile editproduct(Integer id, Mobile mob);
	List<Mobile> getallmobiles();
	List<Mobile> getmobilesxml();
	String deletemobile(Integer id);
	List<Mobile> putpagination(int pageNumber, int pagesize);
	List<Mobile> getmobilebyprice(String direction);
	List<Mobile> getmobilesbyname(String mobileName);
	List<Mobile> sortedmethodfilter(String mobileBrand, Double minmobilePrice, Double maxmobilePrice);

}
