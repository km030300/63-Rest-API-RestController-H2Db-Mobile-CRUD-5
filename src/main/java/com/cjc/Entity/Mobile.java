package com.cjc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@XmlRootElement

public class Mobile {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer mobileId;
	    private String mobileName;
	    private String mobileBrand;
	    private Double mobilePrice;
		public Mobile() {
			super();
		}
		public Mobile(Integer mobileId, String mobileName, String mobileBrand, Double mobilePrice) {
			super();
			this.mobileId = mobileId;
			this.mobileName = mobileName;
			this.mobileBrand = mobileBrand;
			this.mobilePrice = mobilePrice;
		}
		public Integer getMobileId() {
			return mobileId;
		}
		public void setMobileId(Integer mobileId) {
			this.mobileId = mobileId;
		}
		public String getMobileName() {
			return mobileName;
		}
		public void setMobileName(String mobileName) {
			this.mobileName = mobileName;
		}
		public String getMobileBrand() {
			return mobileBrand;
		}
		public void setMobileBrand(String mobileBrand) {
			this.mobileBrand = mobileBrand;
		}
		public Double getMobilePrice() {
			return mobilePrice;
		}
		public void setMobilePrice(Double mobilePrice) {
			this.mobilePrice = mobilePrice;
		}
		@Override
		public String toString() {
			return "Mobile [mobileId=" + mobileId + ", mobileName=" + mobileName + ", mobileBrand=" + mobileBrand
					+ ", mobilePrice=" + mobilePrice + "]";
		}
	    
	    

}
