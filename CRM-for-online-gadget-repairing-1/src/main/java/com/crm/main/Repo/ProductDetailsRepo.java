package com.crm.main.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.main.Model.Productdetails;

@Repository
public interface ProductDetailsRepo extends JpaRepository<Productdetails, Integer> {

	public List<Productdetails> findByCustomerId(int cid);
}
