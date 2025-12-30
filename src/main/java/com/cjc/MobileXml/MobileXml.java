package com.cjc.MobileXml;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.cjc.Entity.Mobile;

@XmlRootElement
public class MobileXml {
	
	private List<Mobile> mobliexml;

	public List<Mobile> getMobliexml() {
		return mobliexml;
	}

	public void setMobliexml(List<Mobile> mobliexml) {
		this.mobliexml = mobliexml;
	}
	

}
