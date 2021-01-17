package com.crm.main.Model;

import javax.persistence.*;

@Entity
public class ServiceProvider {

	@Id
	@GeneratedValue
	private int spID;
	private String spName;
	private String spShopname;
	private String spEmail;
	private String spRegnumber;
	private String spGSTno;
	private String spLandmark;
	private String spCity;
	private String spPincode;
	private String spMobilenumber;
	private String spPasssword;
	
	
	public int getSpID() {
		return spID;
	}
	public void setSpID(int spID) {
		this.spID = spID;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public String getSpShopname() {
		return spShopname;
	}
	public void setSpShopname(String spShopname) {
		this.spShopname = spShopname;
	}
	public String getSpEmail() {
		return spEmail;
	}
	public void setSpEmail(String spEmail) {
		this.spEmail = spEmail;
	}
	public String getSpRegnumber() {
		return spRegnumber;
	}
	public void setSpRegnumber(String spRegnumber) {
		this.spRegnumber = spRegnumber;
	}
	public String getSpGSTno() {
		return spGSTno;
	}
	public void setSpGSTno(String spGSTno) {
		this.spGSTno = spGSTno;
	}
	public String getSpLandmark() {
		return spLandmark;
	}
	public void setSpLandmark(String spLandmark) {
		this.spLandmark = spLandmark;
	}
	public String getSpCity() {
		return spCity;
	}
	public void setSpCity(String spCity) {
		this.spCity = spCity;
	}
	public String getSpPincode() {
		return spPincode;
	}
	public void setSpPincode(String spPincode) {
		this.spPincode = spPincode;
	}
	public String getSpMobilenumber() {
		return spMobilenumber;
	}
	public void setSpMobilenumber(String spMobilenumber) {
		this.spMobilenumber = spMobilenumber;
	}
	public String getSpPasssword() {
		return spPasssword;
	}
	public void setSpPasssword(String spPasssword) {
		this.spPasssword = spPasssword;
	}
	
	
	@Override
	public String toString() {
		return "ServiceProvider [spID=" + spID + ", spName=" + spName + ", spShopname=" + spShopname + ", spEmail="
				+ spEmail + ", spRegnumber=" + spRegnumber + ", spGSTno=" + spGSTno + ", spLandmark=" + spLandmark
				+ ", spCity=" + spCity + ", spPincode=" + spPincode + ", spMobilenumber=" + spMobilenumber
				+ ", spPasssword=" + spPasssword + "]";
	}
	
	
	
}
