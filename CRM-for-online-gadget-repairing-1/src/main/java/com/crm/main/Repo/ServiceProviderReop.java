package com.crm.main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.main.Model.ServiceProvider;

@Repository
public interface ServiceProviderReop extends JpaRepository<ServiceProvider, Integer> {
		public ServiceProvider findBySpEmailAndSpPasssword(String mailid, String pwd); 
		public ServiceProvider findBySpEmail(String mailid);
}
