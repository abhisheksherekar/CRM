package com.crm.main.Model;

import javax.persistence.*;

@Entity
public class Feedback {
	@Id
	@GeneratedValue
	 private int fId;
	 private int customerId;
	 private int spID;
	 private String feedbackMesssage;
	 private int rating;
	 private String overAll;
	 private String name;
	 private String email;
	 
	 
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeedbackMesssage() {
		return feedbackMesssage;
	}
	public void setFeedbackMesssage(String feedbackMesssage) {
		this.feedbackMesssage = feedbackMesssage;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getOverAll() {
		return overAll;
	}
	public void setOverAll(String overAll) {
		this.overAll = overAll;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSpID() {
		return spID;
	}
	public void setSpID(int spID) {
		this.spID = spID;
	}

	 
}
